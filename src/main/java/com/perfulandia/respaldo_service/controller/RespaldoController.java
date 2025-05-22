package com.perfulandia.respaldo_service.controller;

import com.perfulandia.respaldo_service.model.Respaldo;
import com.perfulandia.respaldo_service.service.RespaldoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/respaldo")
public class RespaldoController {

    private final RespaldoService service;

    public RespaldoController(RespaldoService service) {
        this.service = service;
    }

    @PostMapping
    public Respaldo crear(@RequestBody Respaldo respaldo) {
        respaldo.setFecha(LocalDateTime.now());
        return service.guardar(respaldo);
    }

    @GetMapping
    public List<Respaldo> listar() {
        return service.listarTodos();
    }
}