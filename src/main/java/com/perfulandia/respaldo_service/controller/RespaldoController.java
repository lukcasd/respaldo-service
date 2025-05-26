package com.perfulandia.respaldo_service.controller;

import com.perfulandia.respaldo_service.model.Respaldo;
import com.perfulandia.respaldo_service.service.RespaldoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/respaldo")
public class RespaldoController {

    private final RespaldoService respaldoService;

    public RespaldoController(RespaldoService respaldoService) {
        this.respaldoService = respaldoService;
    }

    @PostMapping("/guardar")
    public Respaldo crear(@RequestBody Respaldo respaldo) {
        respaldo.setFecha(LocalDateTime.now());
        return respaldoService.guardar(respaldo);
    }

    @GetMapping
    public List<Respaldo> listar() {
        return respaldoService.listarTodos();
    }


    @PostMapping("/venta")
    public ResponseEntity<Respaldo> postRespaldoVenta(@RequestBody Respaldo respaldo) {
        try {
            return new ResponseEntity<>(respaldoService.crearRespaldoVenta(respaldo),HttpStatus.OK);
        } catch (Exception e) {
      
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/producto")
    public ResponseEntity<Respaldo> postRespaldoProducto(@RequestBody Respaldo respaldo) {
        try {
            return new ResponseEntity<>(respaldoService.crearRespaldoProducto(respaldo),HttpStatus.OK);
        } catch (Exception e) {
      
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }   

    @PostMapping("/usuario")
    public ResponseEntity<Respaldo> postRespaldoUsuario(@RequestBody Respaldo respaldo) {
        try {
            return new ResponseEntity<>(respaldoService.crearRespaldoUsuario(respaldo),HttpStatus.OK);
        } catch (Exception e) {
      
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    } 

}

