package ru.jira.custom.marshalling.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyDataClazzWithJsonCreatorAnnotation implements RequestPluginDto, ResponsePluginDto {
    private final String strProp;
    private final int intProp;
    private final char charProp;
    private final Long longProp;
    private final DtoClazzWithJacksonAnnotations.DtoClazzPartWithJacksonAnnotations innerObj;

    @JsonCreator
    public MyDataClazzWithJsonCreatorAnnotation(
            @JsonProperty("strProp")
            final String strProp,
            @JsonProperty("intProp")
            final int intProp,
            @JsonProperty("charProp")
            final char charProp,
            @JsonProperty("longProp")
            final Long longProp,
            @JsonProperty("innerObj")
            final DtoClazzWithJacksonAnnotations.DtoClazzPartWithJacksonAnnotations innerObj) {
        this.strProp = strProp;
        this.intProp = intProp;
        this.charProp = charProp;
        this.longProp = longProp;
        this.innerObj = innerObj;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MyDataClazzPartWithJsonCreatorAnnotation {
        private final Map<String, Object> data;

        @JsonCreator
        public MyDataClazzPartWithJsonCreatorAnnotation(@JsonProperty("data") final Map<String, Object> data) {
            this.data = data;
        }
    }
}
