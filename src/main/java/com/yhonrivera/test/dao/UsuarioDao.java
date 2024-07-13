package com.yhonrivera.test.dao;

import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Usuario;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import jakarta.websocket.Session;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao {

   void save(UsuarioDto usuarioDto);
   Usuario update(Usuario usuario);
   Usuario delete(Usuario usuario);
    List<Usuario> finAllnd();
    Optional< Usuario> fillAllndById(Long id);
}
