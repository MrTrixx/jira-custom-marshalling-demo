package ru.jira.custom.marshalling.demo.resource;

import ru.jira.custom.marshalling.demo.dto.DtoClazzWithJacksonAnnotations;
import ru.jira.custom.marshalling.demo.dto.DtoClazzWithoutJacksonAnnotations;
import ru.jira.custom.marshalling.demo.dto.MyDataClazzWithJsonCreatorAnnotation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/demo")
public class DemoCustomMarshallerResource {

    /*
     todo: Добавить примеры (классы + эндпоинты)
      1) полностью с аннотациями
      2) частично с аннотациями
      3) без аннотаций
      4) класс с финальными полями - создание через конструктор
     */


    @Path("/checkJacksonMapperWithAnnotations")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DtoClazzWithJacksonAnnotations checkJacksonMapperWithAnnotations(DtoClazzWithJacksonAnnotations dto) {
        return dto;
    }

    @Path("/checkJacksonMapperWithoutAnnotations")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DtoClazzWithoutJacksonAnnotations checkJacksonMapperWithoutAnnotations(
            DtoClazzWithoutJacksonAnnotations dto) {
        return dto;
    }

    @Path("/checkJacksonMapperForDataClazzWithJsonCreator")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MyDataClazzWithJsonCreatorAnnotation checkJacksonMapperForDataClazzWithJsonCreator(
            MyDataClazzWithJsonCreatorAnnotation dto) {
        return dto;
    }

}
