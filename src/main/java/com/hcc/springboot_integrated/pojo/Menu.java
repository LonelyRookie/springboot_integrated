package com.hcc.springboot_integrated.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 菜单实体类
 *
 * @ClassName Menu
 * @Description 角色与菜单的关系多对多
 * @Author Abel
 * @Date 2019/5/6 16:47
 * @Version 1.0
 **/
@Entity
@Table(name = "t_menu")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    @Getter
    @Setter
    private Integer menuId;

    @Column(name = "menuName")
    @Getter
    @Setter
    private String menuName;

    @Column(name = "menuUrl")
    @Getter
    @Setter
    private String menuUrl;

    @Column(name = "ParentId")
    @Getter
    @Setter
    private Integer ParentId;

    @ManyToMany(mappedBy = "menus")
    @Getter
    @Setter
    Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", ParentId=" + ParentId +
                '}';
    }
}
