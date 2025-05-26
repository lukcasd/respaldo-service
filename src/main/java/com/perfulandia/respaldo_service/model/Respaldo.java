package com.perfulandia.respaldo_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Respaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    private LocalDateTime fecha;

    private String origen; // nombre del microservicio asociado

    private String tipo; // Ej: automático, manual

    private String estado; // Ej: exitoso, fallido

    private int idVenta;

    private int idProductoVenta;

    private int idProducto;

    private int stock;

    private int idUsuario;

    private String rutUsuario;

    private String correoUsuario;
}