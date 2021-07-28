package com.stockmarket.apigatewayservice.repositories;

import com.stockmarket.apigatewayservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, String>{
}
