package com.hcc.springboot_integrated;

import com.hcc.springboot_integrated.dao.RoleRepository;
import com.hcc.springboot_integrated.pojo.Menu;
import com.hcc.springboot_integrated.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.util.Optional;
import java.util.Set;

/**
 * RoleRepository接口测试
 *
 * @ClassName RoleRepositoryTest
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/6 17:09
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * 多对多关联关系-----添加
     */
    @Test
    public void saveTest_ManyToMany() {
        //创建角色对象
        Role r = new Role();
        r.setRoleName("项目经理");

        //创建菜单对象
        Menu menus1 = new Menu();
        menus1.setMenuName("xxxx管理系统");
        menus1.setParentId(0);

        Menu menus2 = new Menu();
        menus2.setParentId(1);
        menus2.setMenuName("项目管理");
        //关联
        r.getMenus().add(menus1);
        r.getMenus().add(menus2);
        menus1.getRoles().add(r);
        menus2.getRoles().add(r);
        //保存
        this.roleRepository.save(r);
    }

    /**
     * 多对多关联关系-----查询
     */
    @Test
    public void findOneTest_ManyToMany() {
        Role role = new Role();
        role.setRoleId(4);
        Example<Role> of = Example.of(role);
        Optional<Role> optionalRole = this.roleRepository.findOne(of);
        Role role1 = optionalRole.get();
        System.out.println(role1);
        Set<Menu> menus = role1.getMenus();
        for (Menu menu :menus){
            System.out.println(menu);
        }
    }

}
