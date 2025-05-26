package com.perfulandia.respaldo_service.model;


import java.time.LocalDate;

import lombok.Data;

@Data

public class UsuarioDTO {

    private int idUsuario;

   
    private String rut;

    
    private String nombre;

   
    private String apellido;

    
    private String email;

   
    private String contrasenia;


    private LocalDate fechaNacimiento;
    
}
