package com.backpacktravel.countriescities.facade;

import com.backpacktravel.countriescities.dto.countriesCitiesResponseDto.CityResponseDto;
import com.backpacktravel.countriescities.dto.countriesCitiesResponseDto.CountryDto;
import com.backpacktravel.countriescities.service.CountriesCitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountriesCitiesFacade {
    private final CountriesCitiesService countriesCitiesService;

    public CountryDto fetchCountries() {
        return countriesCitiesService.fetchCountries();
    }

    public CityResponseDto fetchCitiesInCountry(String countryCode) {
        return countriesCitiesService.fetchCitiesInCountry(countryCode);
    }
}
