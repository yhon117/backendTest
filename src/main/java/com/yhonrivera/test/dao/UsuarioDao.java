package com.yhonrivera.test.dao;

import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Empresa;
import com.yhonrivera.test.model.Roles;
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
   void update(UsuarioDto usuarioDto);
   void delete(Usuario usuario);
    List<Usuario> finAllnd();
    Optional< Usuario> fillAllndById(String cedula);

    List<Empresa> finAllndEmpresa();

    List<Roles> finAllndRoles();

}
