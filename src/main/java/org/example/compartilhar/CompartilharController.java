package org.example.compartilhar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compartilhamentos")
public class CompartilharController {

    @Autowired
    private CompartilharService compartilharService;

    @GetMapping
    public List<Compartilhar> listarCompartilhamentos() {
        return compartilharService.listarCompartilhamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compartilhar> buscarCompartilhamento(@PathVariable Long id) {
        return ResponseEntity.of(compartilharService.buscarCompartilhamento(id));
    }

    @PostMapping
    public Compartilhar criarCompartilhamento(@RequestBody Compartilhar compartilhar) {
        return compartilharService.criarCompartilhamento(compartilhar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCompartilhamento(@PathVariable Long id) {
        if (compartilharService.deletarCompartilhamento(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
