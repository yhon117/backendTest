package com.yhonrivera.test.dao;

import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Empresa;
import com.yhonrivera.test.model.Roles;
import com.yhonrivera.test.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UsuarioDao{


    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public void save(UsuarioDto usuarioDto) {
        ModelMapper modelMapper= new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDto,Usuario.class);

        String empresaNit=usuarioDto.getEmpresa();
        Empresa empresa = manager.find(Empresa.class,empresaNit);
        Long rolId=usuarioDto.getRoles();
        Roles rol=manager.find(Roles.class,rolId);
        if(empresa != null && rol != null){
            usuario.setEmpresa(empresa);
            usuario.setRoles(rol);

            this.manager.persist(usuario);

            this.manager.flush();
        }else {
        throw new RuntimeException("Empresa o Rol no encontrado ");
    }
    }

    @Override
    @Transactional
    public void update(UsuarioDto usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();

        Usuario usuarioExistente = manager.find(Usuario.class, usuarioDto.getCedula());

        if (usuarioExistente == null) {
            throw new RuntimeException("Usuario no encontrado con la cédula: " + usuarioDto.getCedula());
        }
        modelMapper.map(usuarioDto, usuarioExistente);

        String nuevoNitEmpresa = usuarioDto.getNit();
        Empresa empresaNueva = manager.find(Empresa.class, nuevoNitEmpresa);
        if (empresaNueva == null) {
            throw new RuntimeException("Empresa no encontrada con el NIT: " + nuevoNitEmpresa);
        }
        usuarioExistente.setEmpresa(empresaNueva);

        Long nuevoIdRol = usuarioDto.getRoles();
        Roles rolNuevo = manager.find(Roles.class, nuevoIdRol);
        if (rolNuevo == null) {
            throw new RuntimeException("Rol no encontrado con el ID: " + nuevoIdRol);
        }
        usuarioExistente.setRoles(rolNuevo);

        // Guardar los cambios actualizados en la base de datos
        manager.merge(usuarioExistente);
        manager.flush();

    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        this.manager.remove(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> finAllnd() {
        String jpql = "SELECT u FROM Usuario u JOIN FETCH u.empresa e JOIN FETCH u.roles r";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> fillAllndById(String cedula) {
        return Optional.ofNullable(this.manager.find(Usuario.class, cedula));

    }

    @Override
    public List<Empresa> finAllndEmpresa() {
        String jpql = "SELECT e FROM Empresa e";
        TypedQuery<Empresa> query = manager.createQuery(jpql,Empresa.class);
        return query.getResultList();
    }


    @Override
    public List<Roles> finAllndRoles() {
        String jpql = "SELECT r FROM Roles r";
        TypedQuery<Roles> query = manager.createQuery(jpql, Roles.class);
        return query.getResultList();
    }

}
