package com.elaparato.service;


import com.elaparato.model.Usuario;
import com.elaparato.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuarioRepository repository;

    public UsuarioService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public List<Usuario> findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}
