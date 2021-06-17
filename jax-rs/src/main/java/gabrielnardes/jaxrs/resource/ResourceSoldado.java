package gabrielnardes.jaxrs.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import gabrielnardes.jaxrs.controller.SoldadoController;
import gabrielnardes.jaxrs.controller.response.SoldadoListResponse;
import gabrielnardes.jaxrs.entity.SoldadoEntity;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ResourceSoldado {
    private ObjectMapper objectMapper;

    public ResourceSoldado(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldadoListResponse criarLink(SoldadoEntity soldadoEntity) {
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldadoEntity.getId())).withRel();
        soldadoListResponse.add(link);

        return soldadoListResponse;
    }
}
