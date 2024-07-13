package com.yhonrivera.test.serivceimpl;

import com.yhonrivera.test.dao.UsuarioDao;
import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Usuario;
import com.yhonrivera.test.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class UsuarioServiceIpmpl implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    private static final Logger logger = Logger.getLogger(Usuario.class.getName());

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
    public List<UsuarioDto> finAlld() {


        ModelMapper modelMapper = new ModelMapper();

        return this.usuarioDao.finAllnd().stream()
                .map(Usuario->modelMapper.map(Usuario,UsuarioDto.class))
                .collect(Collectors.toList());
    }
}
