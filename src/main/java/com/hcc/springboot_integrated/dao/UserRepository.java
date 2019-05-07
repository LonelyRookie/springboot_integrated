package com.hcc.springboot_integrated.dao;

import com.hcc.springboot_integrated.pojo.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 通过JPA操作数据库
 *
 * @ClassName UserRepository
 * @Description 继承JpaRepository接口，操作父接口的方法（如：分页与排序操作，CRUD操作）；
 * 继承JpaSpecificationExecutor接口，提供了多条件查询的支持，并且在查询中添加分页与排序
 * @Author Abel
 * @Date 2019/5/4 23:12
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    //方法名称查询方式
    //方法的名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母大写)
    List<User> findByName(String name);

    List<User> findByNameAndAge(String name, Integer age);

    List<User> findByNameLike(String name);


    //基于@Query注解查询与更新
    //索引参数
    @Query("from User where name=?1")
//使用HQL语句查询
    List<User> queryByNameUseHQL(String name);

    @Query(value = "select * from t_user where name=?1", nativeQuery = true)
//使用原生的SQL语句查询
    List<User> queryByNameUseSQL(String name);

    @Query("update User set name = ?1 where id=?2")//更新操作
    @Modifying
    int updateUserNameById(String name, Integer id);

    //命名参数
    @Query("from User where userId =:id or name=:name")
    List<User> findIdAndName(@Param("id") Integer id, @Param("name") String name);


}
