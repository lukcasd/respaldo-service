package com.perfulandia.respaldo_service.service;

import com.perfulandia.respaldo_service.model.Respaldo;
import com.perfulandia.respaldo_service.repository.RespaldoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespaldoService {

    private final RespaldoRepository repository;

    public RespaldoService(RespaldoRepository repository) {
        this.repository = repository;
    }

    public Respaldo guardar(Respaldo respaldo) {
        return repository.save(respaldo);
    }

    public List<Respaldo> listarTodos() {
        return repository.findAll();
    }
}