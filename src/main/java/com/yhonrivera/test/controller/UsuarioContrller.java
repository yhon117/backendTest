package com.yhonrivera.test.controller;

import com.yhonrivera.test.dto.EmpresaDto;
import com.yhonrivera.test.dto.UsuarioDto;
import com.yhonrivera.test.model.Empresa;
import com.yhonrivera.test.model.Roles;
import com.yhonrivera.test.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioContrller {

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
    public void updateUsuario( @RequestBody UsuarioDto usuarioDto){
        usuarioService.update(usuarioDto);
    }

    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<String> deleteUser(@PathVariable String cedula){
        return new ResponseEntity<>(this.usuarioService.deleteUser(cedula), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getEmpresa")
    public ResponseEntity<List<Empresa>> getEmpresa(){
        return new ResponseEntity<>(this.usuarioService.finAlldEmpresa(),HttpStatus.OK);
    }


    @GetMapping("/getRoles")
    public ResponseEntity<List<Roles>> getRoles(){
        return new ResponseEntity<>(this.usuarioService.finAlldRoles(),HttpStatus.OK);
    }

    @GetMapping("/getUsuario/{cedula}")
    public Optional<UsuarioDto> get(@PathVariable String cedula){
        return usuarioService.fillAllndById(cedula);
    }
}
