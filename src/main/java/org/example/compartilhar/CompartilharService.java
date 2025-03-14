package org.example.compartilhar;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompartilharService {
    private List<Compartilhar> compartilhamentos = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Compartilhar> listarCompartilhamentos() {
        return compartilhamentos;
    }

    public Optional<Compartilhar> buscarCompartilhamento(Long id) {
        return compartilhamentos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Compartilhar criarCompartilhamento(Compartilhar compartilhar) {
        compartilhar.setId(proximoId++);
        compartilhar.setDataCompartilhamento(LocalDateTime.now());
        compartilhamentos.add(compartilhar);
        return compartilhar;
    }

    public boolean deletarCompartilhamento(Long id) {
        return compartilhamentos.removeIf(compartilhar -> compartilhar.getId().equals(id));
    }
}
