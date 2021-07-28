package com.stockmarket.apigatewayservice.mapper;

import com.stockmarket.apigatewayservice.dtos.UserDto;
import com.stockmarket.apigatewayservice.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toUserDto(User user)
    {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDto.class);
    }

    public User toUser(UserDto userDto)
    {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }

}
