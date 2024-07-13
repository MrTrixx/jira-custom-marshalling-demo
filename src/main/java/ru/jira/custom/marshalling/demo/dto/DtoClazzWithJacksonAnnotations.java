package ru.jira.custom.marshalling.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtoClazzWithJacksonAnnotations implements RequestPluginDto, ResponsePluginDto {
    @JsonProperty
    private String strProp;
    @JsonProperty
    private int intProp;
    @JsonProperty
    private char charProp;
    @JsonProperty
    private Long longProp;
    @JsonProperty
    private DtoClazzPartWithJacksonAnnotations innerObj;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DtoClazzPartWithJacksonAnnotations {
        @JsonProperty
        private Map<String, Object> data;
    }

}
