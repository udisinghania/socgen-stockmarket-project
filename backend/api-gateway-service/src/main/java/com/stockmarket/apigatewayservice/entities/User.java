package com.stockmarket.apigatewayservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    private String id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String mobile;

    private String role;
    private String confirmationToken;
    private boolean confirmed;
}
