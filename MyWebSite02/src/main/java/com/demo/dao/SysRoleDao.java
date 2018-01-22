package com.demo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.demo.entity.SysRole;


@Component
public interface SysRoleDao extends JpaRepository<SysRole, String>{
	
	//?1  spring data jpa 官方的一种写法
	@Query(value = "select c.name from sys_user a "
			+ "left join sys_user_role b on a.id = b.user_id "
			+ "left join sys_role c on c.id = b.role_id "
			+ "where a.username = ?1 ",nativeQuery=true)
	Set<String> findUserRole(String usename);
}
