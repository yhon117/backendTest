package com.yhonrivera.test.controller;

import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Usuario;
import com.yhonrivera.test.service.IUsuarioService;
import com.yhonrivera.test.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioContrller {

    @Autowired
    private UsuarioService service;
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/save")
    public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuarioDto){
      return  new ResponseEntity<>(this.usuarioService.save(usuarioDto),HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<UsuarioDto>> getUsuario(){
        return new ResponseEntity<>(this.usuarioService.finAlld(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public void updateUsuario( @RequestBody Usuario usuario){
        service.update(usuario);
    }

    @DeleteMapping("/delete")
    public void deleteUsuario(@RequestBody Usuario usuario){
        service.delete(usuario);
    }
}
