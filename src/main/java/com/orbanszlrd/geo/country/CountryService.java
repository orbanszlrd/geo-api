package com.orbanszlrd.geo.country;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final ModelMapper modelMapper;
    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country add(SaveCountryCommand saveCountryCommand) {
        return countryRepository.save(modelMapper.map(saveCountryCommand, Country.class));
    }

    public Country update(Long id, SaveCountryCommand saveCountryCommand) {
        Country oldCountry = findById(id);
        Country country = modelMapper.map(saveCountryCommand, Country.class);
        country.setId(id);
        country.setCreateDate(oldCountry.getCreateDate());
        return countryRepository.save(country);
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
