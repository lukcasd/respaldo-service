package com.perfulandia.respaldo_service.service;

import com.perfulandia.respaldo_service.model.ProductoDTO;
import com.perfulandia.respaldo_service.model.Respaldo;
import com.perfulandia.respaldo_service.model.UsuarioDTO;
import com.perfulandia.respaldo_service.model.VentaDTO;
import com.perfulandia.respaldo_service.repository.RespaldoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RespaldoService {

    private final RespaldoRepository respaldoRepository;

    @Autowired
    private RestTemplate restTemplate;

    public RespaldoService(RespaldoRepository repository) {
        this.respaldoRepository = repository;
    }

    public Respaldo guardar(Respaldo respaldo) {
        return respaldoRepository.save(respaldo);
    }

    public List<Respaldo> listarTodos() {
        return respaldoRepository.findAll();
    }

    
    public Respaldo crearRespaldoVenta(Respaldo respaldo) {
        // Llamada al microservicio cliente
        String url = "http://localhost:8081/api/ventas/" + respaldo.getIdVenta();
        VentaDTO venta = restTemplate.getForObject(url, VentaDTO.class);
        if (venta != null) {
            respaldo.setIdVenta(respaldo.getIdProductoVenta());
        }
        return respaldoRepository.save(respaldo);
    }

    public Respaldo crearRespaldoProducto(Respaldo respaldo) {
        // Llamada al microservicio cliente
        String url = "http://localhost:8081/api/producto/" + respaldo.getIdProducto();
        ProductoDTO producto = restTemplate.getForObject(url, ProductoDTO.class);
        if (producto != null) {
            respaldo.setIdProducto(respaldo.getStock());
        }
        return respaldoRepository.save(respaldo);
    }

    public Respaldo crearRespaldoUsuario(Respaldo respaldo) {
        // Llamada al microservicio cliente
        String url = "http://localhost:8081/api/usuario/" + respaldo.getIdUsuario();
        UsuarioDTO usuario = restTemplate.getForObject(url, UsuarioDTO.class);
        if (usuario != null) {
            respaldo.setRutUsuario(respaldo.getCorreoUsuario());
        }
        return respaldoRepository.save(respaldo);

}

}
