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
    @Select("SELECT COUNT(*) FROM Users WHERE User_accountNumber=#{User_accountNumber} and User_password=#{User_password}")
    Boolean UsersLogin(Users user);

    @Insert("INSERT INTO USERS(User_accountNumber,User_password) VALUES(#{User_accountNumber},#{User_password})")
    Boolean UsersAdd(Users user);

}