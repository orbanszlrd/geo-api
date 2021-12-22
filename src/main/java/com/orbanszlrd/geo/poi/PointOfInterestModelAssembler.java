package com.orbanszlrd.geo.poi;

import com.orbanszlrd.geo.country.CountryController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PointOfInterestModelAssembler implements RepresentationModelAssembler<PointOfInterestDto, EntityModel<PointOfInterestDto>> {
    @Override
    public EntityModel<PointOfInterestDto> toModel(PointOfInterestDto pointOfInterestDto) {
        return EntityModel.of(pointOfInterestDto,
                linkTo(methodOn(PointOfInterestController.class).findById(pointOfInterestDto.getId())).withSelfRel(),
                linkTo(methodOn(CountryController.class).findAll()).withRel("countries"),
                linkTo(methodOn(PointOfInterestController.class).findAll()).withRel("poi")
        );
    }
}
