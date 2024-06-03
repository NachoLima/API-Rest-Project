package com.elaparato.repository;

import com.elaparato.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UsuarioRepository implements IUsuarioRepository {

    private final Keycloak keycloakClient;

    @Value("${el-aparato.keycloak.realm}")
    private String realm;

    @Override
    public List<Usuario> findAll() {
        return keycloakClient.realm(realm).users().list().stream()
                .map(this::convertToUser).collect(Collectors.toList());
    }

    private Usuario convertToUser(UserRepresentation userRepresentation) {
        return Usuario.builder()
                .id(userRepresentation.getId())
                .userName(userRepresentation.getUsername())
                .email(userRepresentation.getEmail())
                .firstName(userRepresentation.getFirstName())
                .lastName(userRepresentation.getLastName())
                .build();
   }

   @Override
    public List<Usuario> findByUserName(String userName) {
        List<UserRepresentation> userRepresentation = keycloakClient
                .realm(realm)
                .users()
                .search(userName);

        return userRepresentation.stream().map(this::convertToUser)
                .collect(Collectors.toList());

    }
    @Override
    public Usuario deleteUserById(String id) {
        return null;
    }
    @Override
    public Optional<Usuario> findById(String id) {
        return Optional.empty();
    }

}
