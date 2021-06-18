package gabrielnardes.jaxrs.controller;

import gabrielnardes.jaxrs.controller.request.SoldadoEditRequest;
import gabrielnardes.jaxrs.controller.response.SoldadoListResponse;
import gabrielnardes.jaxrs.controller.response.SoldadoResponse;
import gabrielnardes.jaxrs.dto.Soldado;
import gabrielnardes.jaxrs.service.SoldadoService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService service;

    public SoldadoController(SoldadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<SoldadoListResponse>> buscarSoldados() {
        CollectionModel<SoldadoListResponse> soldadoListResponses = service.buscarSoldados();

        return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable Long id) {
        SoldadoResponse soldado = service.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        service.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldado(@PathVariable Long id,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest) {
        service.alterarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldado(@PathVariable Long id) {
        service.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/frente-castelo/{id}")
    public ResponseEntity frenteCastelo(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
