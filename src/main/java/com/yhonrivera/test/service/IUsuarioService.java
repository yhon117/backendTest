package com.yhonrivera.test.service;

import com.yhonrivera.test.dto.UsuarioDto;

import java.util.List;

public interface IUsuarioService {

    UsuarioDto save(UsuarioDto usuarioDto);
    List<UsuarioDto> finAlld();
}
