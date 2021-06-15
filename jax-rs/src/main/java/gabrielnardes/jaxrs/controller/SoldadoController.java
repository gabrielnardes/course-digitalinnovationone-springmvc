package gabrielnardes.jaxrs.controller;

import gabrielnardes.jaxrs.controller.request.SoldadoEditRequest;
import gabrielnardes.jaxrs.dto.Soldado;
import gabrielnardes.jaxrs.service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService service;

    public SoldadoController(SoldadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Soldado>> buscarSoldados() {
        List<Soldado> soldados = service.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable String cpf) {
        Soldado soldado = service.buscarSoldado(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity<Soldado> criarSoldado(@RequestBody Soldado soldado) {
        service.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@PathVariable String cpf,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest) {
        service.alterarSoldado(cpf, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarSoldado(@PathVariable String cpf) {
        service.deletarSoldado(cpf);
        return ResponseEntity.ok().build();
    }
}
