package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.SysMenuDao;

@Service
@Transactional(readOnly=true)//默认事务只读
public class SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	
	
	
}
