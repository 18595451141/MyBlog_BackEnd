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
    @Select("SELECT * FROM Users_information WHERE User_accountNumber=#{User_accountNumber}")
    List<Users_information> UsersLogin(Users_information users_information);

    @Select("SELECT Count(*) FROM Users_information WHERE User_accountNumber=#{User_accountNumber}")
    Integer UsersAccountDuplication(Users_information user);

    @Insert("INSERT INTO Users_information(User_accountNumber,User_password,User_Key) VALUES(#{User_accountNumber},#{User_password},#{User_Key})")
    Boolean UsersAdd(Users_information user);

}