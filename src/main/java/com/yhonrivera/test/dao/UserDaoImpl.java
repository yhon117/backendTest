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
    public Usuario update(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario delete(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> finAllnd() {
        String jpql = "SELECT new com.yhonrivera.test.model(u.cedula, u.primer_nombre, u.segundo_nombre, u.primer_apellido" +
                ",u.segundo_apellido, u.email, u.clave, u.estado, e.nit, e.nombre, r.rol) " +
                "FROM usuario u " +
                "JOIN u.empresa e " +
                "JOIN u.roles r";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);

        return query.getResultList();
    }

    @Override
    public Optional<Usuario> fillAllndById(Long id) {
        return Optional.empty();
    }
}
