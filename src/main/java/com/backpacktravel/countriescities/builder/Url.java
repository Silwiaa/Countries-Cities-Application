package com.backpacktravel.countriescities.builder;

import com.backpacktravel.countriescities.dto.ParameterDto;

import java.util.ArrayList;
import java.util.List;

public final class Url {
    private final String apiEndpoint;
    private final String value;
    private List<ParameterDto> queryParams;

    public static class UrlBuilder {
        private String apiEndpoint;
        private String value;
        private List<ParameterDto> queryParams = new ArrayList<>();

        public UrlBuilder apiEndpoint(String apiEndpoint) {
            this.apiEndpoint = apiEndpoint;
            return this;
        }

        public UrlBuilder value(String value) {
            this.value = value;
            return this;
        }

        public UrlBuilder queryParams(String key, String value) {
            queryParams.add(new ParameterDto(key, value));
            return this;
        }

        public Url build() {
            return new Url(apiEndpoint, value, queryParams);
        }
    }

    private Url(final String apiEndpoint, String value, List<ParameterDto> queryParams) {
        this.apiEndpoint = apiEndpoint;
        this.value = value;
        this.queryParams = new ArrayList<>(queryParams);
    }

    public String getUrl() {
        String url = apiEndpoint + value;

        for (ParameterDto parameterDto : queryParams) {
            url += parameterDto.getKey() + parameterDto.getValue();
        }

        return url;
    }

    @Override
    public String toString() {
        return getUrl();
    }
}
