package com.orbanszlrd.geo.country;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final ModelMapper modelMapper;
    private final CountryRepository  countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country add(SaveCountryCommand saveCountryCommand) {
        Type type = new TypeToken<Country>() {}.getType();
        return countryRepository.save(modelMapper.map(saveCountryCommand, type));
    }

    public Country update(Long id, SaveCountryCommand saveCountryCommand) {
        Country oldCountry = findById(id);

        Type type = new TypeToken<Country>() {}.getType();
        Country country = modelMapper.map(saveCountryCommand, type);
        country.setId(id);
        country.setCreateDate(oldCountry.getCreateDate());
        return countryRepository.save(country);
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundProblem(id));
    }

    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
