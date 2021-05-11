package com.jwt.react.service;

import java.util.Optional;

import com.jwt.react.entity.Role;
import com.jwt.react.entity.RoleName;

public interface RoleService {
	public Optional<Role> findByName(RoleName name);

}
