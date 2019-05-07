package com.hcc.springboot_integrated.dao;

import com.hcc.springboot_integrated.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 通过JPA操作数据库
 *
 * @ClassName RolesRepository
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/6 17:08
 * @Version 1.0
 **/
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
}
