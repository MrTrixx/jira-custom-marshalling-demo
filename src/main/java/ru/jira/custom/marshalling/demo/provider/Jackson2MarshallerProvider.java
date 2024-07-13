package ru.jira.custom.marshalling.demo.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.jira.custom.marshalling.demo.dto.RequestPluginDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Jackson2MarshallerProvider implements MessageBodyReader<RequestPluginDto> {
    private final ObjectMapper objectMapper;

    @Override
    public boolean isReadable(
            final Class<?> clazz,
            final Type type,
            final Annotation[] annotations,
            final MediaType mediaType) {
        return RequestPluginDto.class.isAssignableFrom(clazz);
    }

    @Override
    public RequestPluginDto readFrom(
            final Class<RequestPluginDto> clazz,
            final Type type,
            final Annotation[] annotations,
            final MediaType mediaType,
            final MultivaluedMap<String, String> multivaluedMap,
            final InputStream inputStream) throws IOException, WebApplicationException {
        return objectMapper.readValue(inputStream, clazz);
    }
}
