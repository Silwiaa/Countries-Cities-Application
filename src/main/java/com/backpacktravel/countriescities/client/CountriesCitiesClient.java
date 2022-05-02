package com.backpacktravel.countriescities.client;

import com.backpacktravel.countriescities.builder.Url;
import com.backpacktravel.countriescities.configuration.CountriesCitiesConfig;
import com.backpacktravel.countriescities.dto.countriesCitiesResponseDto.CityResponseDto;
import com.backpacktravel.countriescities.dto.countriesCitiesResponseDto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CountriesCitiesClient {
    private final RestTemplate restTemplate;
    private final CountriesCitiesConfig countriesCitiesConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(CountriesCitiesClient.class);

    public CountryDto getCountries() {
        Url urlService = new Url.UrlBuilder()
                .apiEndpoint(countriesCitiesConfig.getCountriesCitiesEndpoint())
                .value("/location/country/list")
                .build();

        String url = urlService.toString();
        HttpEntity request = createRequest("X-RapidAPI-Host", "X-RapidAPI-Key");
        try {
            ResponseEntity<CountryDto> response = restTemplate.exchange(url, HttpMethod.GET, request, CountryDto.class);
            return response.getBody();

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RestClientException(e.getMessage());
        }
    }

    public CityResponseDto getCitiesInCountry(String countryCode) {
        Url urlService = new Url.UrlBuilder()
                .apiEndpoint(countriesCitiesConfig.getCountriesCitiesEndpoint())
                .value("/location/country/" + countryCode + "/city/list?")
                .queryParams("per_page=", "100")
                .queryParams("&population=", "50000")
                .build();

        String url = urlService.toString();
        HttpEntity request = createRequest("X-RapidAPI-Host", "X-RapidAPI-Key");

        try {
            ResponseEntity<CityResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, request, CityResponseDto.class);
            System.out.println(response.getBody().getCities().size());
            return response.getBody();

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RestClientException(e.getMessage());
        }
    }

    private HttpEntity createRequest(String host, String key) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(host, countriesCitiesConfig.getCountriesCitiesHost());
        headers.set(key, countriesCitiesConfig.getCountriesCitiesKey());

        return new HttpEntity(headers);
    }
}
