package com.hcc.springboot_integrated.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 *
 * @ClassName Role
 * @Description 角色与用户的关系是一对多；角色与菜单的关系多对多
 * @Author Abel
 * @Date 2019/5/5 22:24
 * @Version 1.0
 **/
//@Data
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    @Getter
    @Setter
    private Integer roleId;

    @Column(name = "roleName")
    @Getter
    @Setter
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)//fetch = FetchType.EAGER 是解决no Session问题
    @Getter
    @Setter
    private Set<User> users = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)//fetch = FetchType.EAGER 是解决no Session问题，LAZY 变成EAGER 就不会出现此问题
    @JoinTable(name = "t_role_menu", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
    @Getter
    @Setter
    private Set<Menu> menus = new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
