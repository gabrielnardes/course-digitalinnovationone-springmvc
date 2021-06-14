package gabrielnardes.springwebmvc.rest;

import gabrielnardes.springwebmvc.model.Jedi;
import gabrielnardes.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {
    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() {
        return repository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable Long id) {
        final Optional<Jedi> jedi =  repository.findById(id);

        if (jedi.isPresent()) {
            return ResponseEntity.ok(jedi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/jedi")
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {
        return repository.save(jedi);
    }
}
