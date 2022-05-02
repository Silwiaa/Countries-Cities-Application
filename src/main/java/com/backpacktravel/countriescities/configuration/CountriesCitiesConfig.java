package com.backpacktravel.countriescities.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CountriesCitiesConfig {
    @Value("${countriescities.api.endpoint}")
    private String countriesCitiesEndpoint;

    @Value("${countriescities.app.host}")
    private String countriesCitiesHost;

    @Value("${countriescities.app.key}")
    private String countriesCitiesKey;
}
