package com.demo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.demo.entity.SysMenu;


@Component
public interface SysMenuDao extends JpaRepository<SysMenu, String>{
//JpaSpecificationExecutor 
//Interface to allow execution of Specifications based on the JPA criteria API.

	@Query(value = "select a.permission from sys_menu a "
		+ "left join sys_role_menu b on a.id = b.menu_id "
		+ "left join sys_user_role c on b.role_id = c.role_id "
		+ "where c.user_id = ?1" ,nativeQuery=true)//nativeQuery=true说明使用原生sql语句
	Set<String> findUserPermission(String userId);
	
}
