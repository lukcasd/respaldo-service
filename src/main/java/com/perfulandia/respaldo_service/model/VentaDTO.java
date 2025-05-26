package com.perfulandia.respaldo_service.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VentaDTO {
    private Integer idVenta;
    private LocalDate   fechaVenta;
    private Double precioBase;
    private Double descuento;
    private Double ivaPorcentaje;
    private Double totalVenta;
    private int idSucursal;
    private int idProducto;
    
}
