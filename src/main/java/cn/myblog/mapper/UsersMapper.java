package cn.myblog.mapper;

import cn.myblog.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    @Select("select * from users")
    List<Users> FindUsers();
}