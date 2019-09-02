package cn.myblog.mapper;

import cn.myblog.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UsersMapper {
    @Select("SELECT COUNT(*) FROM USERS WHERE User_Name=#{User_Name} AND User_Pwd=#{User_Pwd}")
    Boolean UsersLogin(Users user);
}