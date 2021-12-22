package com.orbanszlrd.geo.poi;

import com.orbanszlrd.geo.country.CountryController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/poi")
@Log4j2
@Tag(name = "The POI API", description = "The POI API")
public class PointOfInterestController {
    private final PointOfInterestService pointOfInterestService;
    private final PointOfInterestModelAssembler pointOfInterestModelAssembler;

    @GetMapping(value = "", produces = {"application/hal+json"})
    @Operation(summary = "List all POIs", description = "List all POIs")
    public CollectionModel<EntityModel<PointOfInterestDto>> findAll() {
        log.info("List all POIs");
        List<PointOfInterestDto> pointsOfInterest = pointOfInterestService.findAll();
        List<EntityModel<PointOfInterestDto>> pointOfInterestEntities = pointsOfInterest.stream().map(pointOfInterestModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(pointOfInterestEntities,
                linkTo(methodOn(PointOfInterestController.class).findAll()).withSelfRel(),
                linkTo(methodOn(CountryController.class).findAll()).withRel("poi")
        );
    }

    @GetMapping(value = "/{id}", produces = {"application/hal+json"})
    @Operation(summary = "Find a POI", description = "Find a POI by its id")
    public EntityModel<PointOfInterestDto> findById(@Parameter(description = "The id of the POI", required = true, example = "1") @Min(1) @PathVariable Long id) {
        log.info("Find a POI by its id: {}", id);
        PointOfInterestDto pointOfInterestDto = pointOfInterestService.findById(id);
        return pointOfInterestModelAssembler.toModel(pointOfInterestDto);
    }

    @PostMapping(value = "", produces = {"application/hal+json"})
    @Operation(summary = "Insert a new POI", description = "Insert a new POI")
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<PointOfInterestDto> add(@Valid @RequestBody SavePointOfInterestCommand savePointOfInterestCommand) {
        log.info("Add new POI: {}", savePointOfInterestCommand.getName());
        PointOfInterestDto pointOfInterestDto = pointOfInterestService.add(savePointOfInterestCommand);
        return pointOfInterestModelAssembler.toModel(pointOfInterestDto);
    }

    @PutMapping(value = "/{id}", produces = {"application/hal+json"})
    @Operation(summary = "Update a POI", description = "Update a POI by its id")
    public EntityModel<PointOfInterestDto> update(@Parameter(description = "The id of the POI", required = true, example = "1") @Min(1) @PathVariable Long id, @Valid @RequestBody SavePointOfInterestCommand savePointOfInterestCommand) {
        log.info("Update a POI by its id: {}", id);
        PointOfInterestDto pointOfInterestDto = pointOfInterestService.update(id, savePointOfInterestCommand);
        return pointOfInterestModelAssembler.toModel(pointOfInterestDto);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/hal+json"})
    @Operation(summary = "Delete a POI", description = "Delete a POI by its id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "The id of the POI", required = true, example = "1") @Min(1) @PathVariable Long id) {
        log.info("Delete a POI by its id: {}", id);
        pointOfInterestService.deleteById(id);
    }
}
