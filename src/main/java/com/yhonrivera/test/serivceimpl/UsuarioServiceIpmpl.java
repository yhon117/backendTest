package com.yhonrivera.test.serivceimpl;

import com.yhonrivera.test.dao.UsuarioDao;
import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Usuario;
import com.yhonrivera.test.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
            if(!usuarioDto.getEmpresa().isEmpty()&& usuarioDto.getRoles()!=null){
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

    private UsuarioDto convertToDto(Usuario usuario) {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.setEmpresa(usuario.getEmpresa().getNombre());
        usuarioDto.setRoles(usuario.getRoles().getId());
        return usuarioDto;
    }
}
