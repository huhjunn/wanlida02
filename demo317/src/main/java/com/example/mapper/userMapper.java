package com.example.mapper;

        import com.example.entity.User;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Component;

@Component
@Mapper
public interface userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //用户登录
    User userlogin(@Param("username") String username, @Param("password") String password);

    //注册新用户(方式1)
    int adduser(@Param("username") String username, @Param("password") String password);

    //注册新用户（方式2）
    int adduser1(@Param("username") String username, @Param("password") String password);

}