package com.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly=true)//默认事务只读
public class SysRoleService {

}
