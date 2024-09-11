package com.yhonrivera.test.service;

import com.yhonrivera.test.dto.EmpresaDto;
import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Empresa;
import com.yhonrivera.test.model.Roles;
import com.yhonrivera.test.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    UsuarioDto save(UsuarioDto usuarioDto);
    List<UsuarioDto> finAlld();
    String deleteUser(String cedula);
    UsuarioDto update(UsuarioDto usuarioDto);

    List<Empresa> finAlldEmpresa();

    List<Roles> finAlldRoles();

    Optional<UsuarioDto> fillAllndById(String cedula);

}
