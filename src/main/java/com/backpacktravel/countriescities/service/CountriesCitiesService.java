package com.backpacktravel.countriescities.service;

import com.backpacktravel.countriescities.client.CountriesCitiesClient;
import com.backpacktravel.countriescities.dto.countriesCitiesResponseDto.CityResponseDto;
import com.backpacktravel.countriescities.dto.countriesCitiesResponseDto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountriesCitiesService {
    private final CountriesCitiesClient countriesCitiesClient;

    public CountryDto fetchCountries() {
        return countriesCitiesClient.getCountries();
    }

    public CityResponseDto fetchCitiesInCountry(String countryCode) {
        return countriesCitiesClient.getCitiesInCountry(countryCode);
    }
}
