package cn.myblog.mapper;

import cn.myblog.entity.Users_information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    //用户账号密码登录
    @Select("SELECT * FROM Users_information WHERE User_accountNumber=#{User_accountNumber} and User_password=#{User_password}")
    List<Users_information> UsersLogin(Users_information users_information);
    //查询用户账号
    @Select("SELECT Count(*) FROM Users_information WHERE User_accountNumber=#{User_accountNumber}")
    Integer UsersAccountDuplication(Users_information user);
    //账号密码注册
    @Insert("INSERT INTO Users_information(User_accountNumber,User_password) VALUES(#{User_accountNumber},#{User_password})")
    Boolean UsersAdd(Users_information user);

}