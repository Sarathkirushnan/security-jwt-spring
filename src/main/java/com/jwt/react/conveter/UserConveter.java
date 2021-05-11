package com.jwt.react.conveter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jwt.react.dto.UserDto;
import com.jwt.react.entity.Role;
import com.jwt.react.entity.RoleName;
import com.jwt.react.entity.User;
import com.jwt.react.repository.CreateRoleService;
import com.jwt.react.repository.RoleRepository;

@Service
public class UserConveter{

	@Autowired
	private RoleRepository roleRepository;
	

	public User signUpConveter(UserDto userDto) {
		User user = new User();
		if(userDto != null) {
			user.setFirstname(userDto.getFirstname());
			user.setLastname(userDto.getLastname());
			user.setUsername(userDto.getUsername());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
			
			List<Role> roles  = new ArrayList<>();
			if(userDto.getRole() != null) {
				List<String> getRoles= userDto.getRole();
				getRoles.forEach(role->{
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(adminRole);
						break;
					case "mg":
						Role mgRole = roleRepository.findByName(RoleName.ROLE_PM).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(mgRole);
						break;
					case "user":
						Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(userRole);
						break;
					}
					
				});
			}else {
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
			user.setRoles(roles);
			return user;
		}
		return null;
	}

}
