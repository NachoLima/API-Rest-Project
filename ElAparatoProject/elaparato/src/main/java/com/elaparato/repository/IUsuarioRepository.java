package com.elaparato.repository;

import com.elaparato.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {
    List<Usuario> findAll();
    List<Usuario> findByUserName(String userName);
    Optional<Usuario> findById(String id);
    Usuario deleteUserById(String id);
}
