package gabrielnardes.jaxrs.service;

import gabrielnardes.jaxrs.controller.request.SoldadoEditRequest;
import gabrielnardes.jaxrs.dto.Soldado;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoldadoService {
    public Soldado buscarSoldado(String cpf) {
        Soldado soldado = new Soldado();

        soldado.setCpf(cpf);
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e flecha");

        return soldado;
    }

    public void criarSoldado(Soldado soldado) {
    }

    public void alterarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest) {
    }

    public void deletarSoldado(String cpf) {
    }

    public List<Soldado> buscarSoldados() {
        Soldado soldado = new Soldado();
        soldado.setCpf("111");
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e flecha");

        Soldado soldado1 = new Soldado();
        soldado1.setCpf("222");
        soldado1.setNome("Legolas");
        soldado1.setRaca("Elfo");
        soldado1.setArma("Arco e flecha");

        return Arrays.asList(soldado, soldado1);
    }
}
