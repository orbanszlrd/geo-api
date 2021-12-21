package com.orbanszlrd.geo.country;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CountryNotFoundProblem extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("http://example.org/not-found");

    public CountryNotFoundProblem(Long id) {
        super(
                TYPE,
                "Not found",
                Status.NOT_FOUND,
                String.format("Country '%s' not found", id));
    }
}