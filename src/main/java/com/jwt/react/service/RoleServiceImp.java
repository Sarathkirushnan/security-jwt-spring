package com.jwt.react.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.react.entity.Role;
import com.jwt.react.entity.RoleName;
import com.jwt.react.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {
@Autowired
RoleRepository roleRepository;
	@Override
	public Optional<Role> findByName(RoleName name) {
		return roleRepository.findByName(name);
	}

}
