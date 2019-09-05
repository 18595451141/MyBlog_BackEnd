package cn.myblog.mapper;

import cn.myblog.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    @Select("SELECT COUNT(*) FROM Users WHERE User_Name=#{User_Name} and User_Pwd=#{User_Pwd}")
    Boolean UsersLogin(Users user);

    @Insert("INSERT INTO USERS(User_Name,User_Pwd) VALUES(#{User_Name},#{User_Pwd})")
    Boolean UsersAdd(Users user);

}