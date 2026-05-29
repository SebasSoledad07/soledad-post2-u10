package com.universidad.pruebas.service;

import com.universidad.pruebas.model.Tarea;
import com.universidad.pruebas.respository.TareaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private final TareaRepository repo;
    public TareaService(TareaRepository repo) { this.repo = repo; }

    public List<Tarea> listar() {
        return repo.findAll();
    }

    public Tarea crear(Tarea tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().isBlank())
            throw new IllegalArgumentException("El título no puede estar vacío");
        return repo.save(tarea);
    }
    public Tarea buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada: " + id));
    }
    public Tarea completar(Long id) {
        Tarea t = buscarPorId(id);
        t.setCompletada(true);
        return repo.save(t);
    }

    public Tarea actualizar(Long id, Tarea tarea) {
        Tarea actual = buscarPorId(id);
        if (tarea.getTitulo() == null || tarea.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        actual.setTitulo(tarea.getTitulo());
        actual.setDescripcion(tarea.getDescripcion());
        actual.setCompletada(tarea.isCompletada());
        return repo.save(actual);
    }

    public void eliminar(Long id) {
        buscarPorId(id);
        repo.deleteById(id);
    }
}
