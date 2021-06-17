package gabrielnardes.jaxrs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gabrielnardes.jaxrs.controller.request.SoldadoEditRequest;
import gabrielnardes.jaxrs.controller.response.SoldadoListResponse;
import gabrielnardes.jaxrs.controller.response.SoldadoResponse;
import gabrielnardes.jaxrs.dto.Soldado;
import gabrielnardes.jaxrs.entity.SoldadoEntity;
import gabrielnardes.jaxrs.repository.SoldadoRepository;
import gabrielnardes.jaxrs.resource.ResourceSoldado;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldadoService {

    private SoldadoRepository repository;
    private ObjectMapper objectMapper;
    private ResourceSoldado resourceSoldado;

    public SoldadoService(SoldadoRepository repository, ObjectMapper objectMapper, ResourceSoldado resourceSoldado) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.resourceSoldado = resourceSoldado;
    }

    public SoldadoResponse buscarSoldado(Long id) {
        SoldadoEntity soldadoEntity = repository.findById(id).orElseThrow();
        SoldadoResponse soldadoResponse = resourceSoldado.criarLinkDetalhe(soldadoEntity);
        return soldadoResponse;
    }

    public void criarSoldado(Soldado soldado) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldado, SoldadoEntity.class);
        repository.save(soldadoEntity);
    }

    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldadoEditRequest, SoldadoEntity.class);
        soldadoEntity.setId(id);
        repository.save(soldadoEntity);
    }

    public void deletarSoldado(Long id) {
        SoldadoEntity soldado = repository.findById(id).orElseThrow();
        repository.delete(soldado);
    }

    public CollectionModel<SoldadoListResponse> buscarSoldados() {
        List<SoldadoEntity> all = repository.findAll();

        List<SoldadoListResponse> soldadoStream = all.stream()
                .map(it -> resourceSoldado.criarLink(it))
                .collect(Collectors.toList());

        return new CollectionModel<>(soldadoStream);
    }
}
