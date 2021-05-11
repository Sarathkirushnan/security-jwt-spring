package com.jwt.react.repository;

import com.jwt.react.dto.UserDto;
import com.jwt.react.entity.User;

public interface CreateRoleService {
	public User signUpConveter(UserDto userDto);
}
