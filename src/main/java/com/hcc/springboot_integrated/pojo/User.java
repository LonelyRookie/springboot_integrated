package com.hcc.springboot_integrated.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户实体类
 *
 * @ClassName User
 * @Description 角色与用户的关系是一对多
 * @Author Abel
 * @Date 2019/5/4 17:19
 * @Version 1.0
 **/
//@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "name")
    @Getter
    @Setter
    @NotEmpty
    private String name;

    @Column(name = "age")
    @Getter
    @Setter
    @DecimalMax("200")
    private Integer age;

    @Column(name = "gender")
    @Getter
    @Setter
    @NotEmpty
    private String gender;


    @ManyToOne(cascade = CascadeType.PERSIST)//级联保存
    @JoinColumn(name = "role_id")
    @Getter
    @Setter
    @Valid
    private Role role;

    public User() {
    }

    public User(Integer id, String name, Integer age, String gender) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
