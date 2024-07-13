package com.yhonrivera.test.dto;

import com.yhonrivera.test.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolDto {
    @Id
    private String rol;
    private int estado;
    private List<Usuario> usuarios;
}
