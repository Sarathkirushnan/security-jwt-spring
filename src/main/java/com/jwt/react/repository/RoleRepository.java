package com.jwt.react.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jwt.react.entity.Role;
import com.jwt.react.entity.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
//	Role findByName(RoleName roleAdmin);
    Optional<Role> findByName(RoleName roleName);
}
