package ru.jira.custom.marshalling.demo.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.jira.custom.marshalling.demo.dto.ResponsePluginDto;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Jackson2UnmarshallerProvider implements MessageBodyWriter<ResponsePluginDto> {
    private final ObjectMapper objectMapper;

    @Override
    public boolean isWriteable(
            final Class<?> clazz,
            final Type type,
            final Annotation[] annotations,
            final MediaType mediaType) {
        return ResponsePluginDto.class.isAssignableFrom(clazz);
    }

    @Override
    public long getSize(
            final ResponsePluginDto object,
            final Class<?> clazz,
            final Type type,
            final Annotation[] annotations,
            final MediaType mediaType) {
        return -1L;
    }

    @Override
    public void writeTo(
            final ResponsePluginDto object,
            final Class<?> clazz,
            final Type type,
            final Annotation[] annotations,
            final MediaType mediaType,
            final MultivaluedMap<String, Object> multivaluedMap,
            final OutputStream outputStream) throws IOException, WebApplicationException {
        objectMapper.writeValue(outputStream, object);
    }
}
