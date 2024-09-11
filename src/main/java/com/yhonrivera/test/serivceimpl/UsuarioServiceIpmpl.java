package com.yhonrivera.test.serivceimpl;

import com.yhonrivera.test.dao.UsuarioDao;
import com.yhonrivera.test.dto.EmpresaDto;
import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Empresa;
import com.yhonrivera.test.model.Roles;
import com.yhonrivera.test.model.Usuario;
import com.yhonrivera.test.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class UsuarioServiceIpmpl implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        try{
            if(usuarioDto.getEmpresa()!=null&& usuarioDto.getRoles()!=null){
                this.usuarioDao.save(usuarioDto);
                return usuarioDto;
            }
return null;

        }catch (Exception e){

            throw new UnsupportedOperationException("error al guardar el usuario"+e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> finAlld() {
        List<Usuario> usuarios = usuarioDao.finAllnd();

        // Convertir lista de Usuario a lista de UsuarioDto usando ModelMapper
        return usuarios.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteUser(String cedula) {
        Optional<Usuario> userEntity = this.usuarioDao.fillAllndById(cedula);

        if(userEntity.isPresent()){
            Usuario currentUserEntity = userEntity.get();
            this.usuarioDao.delete(currentUserEntity);
            return "Usuario con ID " + cedula +" ha sido eliminado.";
        } else {
            return "El usuario con ID " + cedula + " no existe.";
        }

    }

    @Override
    public UsuarioDto update(UsuarioDto usuarioDto) {
        try {
            if(!usuarioDto.getCedula().isEmpty()){
                this.usuarioDao.update(usuarioDto);
                return usuarioDto;
            }
            return null;
        }catch (Exception e){
            throw new UnsupportedOperationException("error al guardar el usuario"+e);

        }
    }

    @Override
    public List<Empresa> finAlldEmpresa() {
        List<Empresa> empresas = usuarioDao.finAllndEmpresa();
        return empresas;
    }

    @Override
    public List<Roles> finAlldRoles() {
        List<Roles> roles = usuarioDao.finAllndRoles();
        return roles;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDto> fillAllndById(String cedula) {
        Optional<Usuario> usuarios=usuarioDao.fillAllndById(cedula);
       return  usuarios.stream()
               .map(this::convertToDto)
               .findAny();
    }


    private UsuarioDto convertToDto(Usuario usuario) {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.setEmpresa(usuario.getEmpresa().getNombre());
        usuarioDto.setNit(usuario.getEmpresa().getNit());
        usuarioDto.setRoles(usuario.getRoles().getId());
        usuarioDto.setRol(usuario.getRoles().getRol());
        return usuarioDto;
    }
}
