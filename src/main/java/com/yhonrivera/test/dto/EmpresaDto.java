package com.yhonrivera.test.dto;

import com.yhonrivera.test.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {
    @Id
    private Long id;
    private String nit;
    private String nombre;
    private String libre;
    private int estado;
    private List<Usuario> usuario;
}
