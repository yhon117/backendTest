package com.yhonrivera.test.service;

import com.yhonrivera.test.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save (Usuario usuario);
    void delete(Usuario usuario);
    List<Usuario> finadAll();
    void update(Usuario usuario);
}
