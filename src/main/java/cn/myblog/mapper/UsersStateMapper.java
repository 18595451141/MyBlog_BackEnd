package cn.myblog.mapper;

import cn.myblog.entity.Users_state;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersStateMapper {
    @Insert("INSERT INTO Users_state(User_id) VALUES(#{User_id})")
    Boolean Users_stateAdd(Users_state users_state);
    @Select("SELECT * FROM Users_state WHERE User_id=#{User_id}")
    List<Users_state> Users_stateUnique(Users_state users_state);

    @Delete("DELETE FROM Users_state WHERE User_id=#{User_id}")
    Boolean Users_stateDelete(Users_state users_state);
}
