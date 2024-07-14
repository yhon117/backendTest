package com.yhonrivera.test.config;

import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(Usuario.class, UsuarioDto.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getEmpresa().getNombre(), UsuarioDto::setEmpresa);
                    mapper.map(src -> src.getRoles().getId(), UsuarioDto::setRoles);
                });

        return modelMapper;
    }
}
