package com.yhonrivera.test.serivceimpl;

import com.yhonrivera.test.model.Usuario;
import com.yhonrivera.test.repository.UsuarioRepository;
import com.yhonrivera.test.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {

       return repository.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
       repository.save(usuario);
    }

    @Override
    public List<Usuario> finadAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public void update(Usuario usuario) {

        repository.save(usuario);
    }
}
