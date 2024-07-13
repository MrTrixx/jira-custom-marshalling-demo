package ru.jira.custom.marshalling.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtoClazzWithoutJacksonAnnotations implements RequestPluginDto, ResponsePluginDto {
    private String strProp;
    private int intProp;
    private char charProp;
    private Long longProp;
    private DtoClazzWithJacksonAnnotations.DtoClazzPartWithJacksonAnnotations innerObj;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DtoClazzPartWithoutJacksonAnnotations {
        private Map<String, Object> data;
    }
}
