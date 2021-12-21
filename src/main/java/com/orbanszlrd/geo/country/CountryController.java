package com.orbanszlrd.geo.country;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
@Log4j2
@Tag(name = "The Country API", description = "The Country API")
public class CountryController {
    private final CountryService countryService;

    @GetMapping(value = "", produces = {"application/json"})
    @Operation(summary = "List all countries", description = "List all countries")
    public List<Country> findAll() {
        log.info("List all countries");
        return countryService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    @Operation(summary = "Find a country", description = "Find a country by its id")
    public Country findById(@Parameter(description = "The id of the country", required = true, example = "1") @Min(1) @Max(1000) @PathVariable Long id) {
        log.info("Find a country by its id: {}",  id);
        return countryService.findById(id);
    }

    @PostMapping(value = "", produces = {"application/json"})
    @Operation(summary = "Insert a new country", description = "Insert a new country")
    @ResponseStatus(HttpStatus.CREATED)
    public Country add(@Valid @RequestBody SaveCountryCommand saveCountryCommand) {
        log.info("Add new country: {}", saveCountryCommand.getName());
        return countryService.add(saveCountryCommand);
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    @Operation(summary = "Update a country", description = "Update a country by its id")
    public Country update(@Parameter(description = "The id of the country", required = true, example = "1") @Min(1) @Max(1000) @PathVariable Long id, @Valid @RequestBody SaveCountryCommand saveCountryCommand) {
        log.info("Update a country by its id: {}", id);
        return countryService.update(id, saveCountryCommand);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    @Operation(summary = "Delete a country", description = "Delete a country by its id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "The id of the country", required = true, example = "10") @Min(1) @Max(1000) @PathVariable Long id) {
        log.info("Delete a country by its id: {}", id);
        countryService.deleteById(id);
    }
}
