package cn.myblog.mapper;

import cn.myblog.entity.Users_state;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersStateMapper {
    //单一登录：状态添加
    @Insert("INSERT INTO Users_state(User_id,Us_sessionid) VALUES(#{User_id},#{Us_sessionid})")
    Boolean Users_stateAdd(Users_state users_state);
    //根据用户id查找
    @Select("SELECT * FROM Users_state WHERE User_id=#{User_id}")
    List<Users_state> Users_stateUnique(Users_state users_state);
    //单一登录，匹配
    @Select("SELECT * FROM Users_state WHERE User_id=#{User_id} and Us_sessionid=#{Us_sessionid}")
    List<Users_state> Users_stateLogin(Users_state users_state);
    //单一登录，修改客户id
    @Update("Update Users_state Set Us_sessionid=#{Us_sessionid} where User_id=#{User_id}")
    Boolean Users_stateUpdate(Users_state users_state);
    //根据用户id删除
    @Delete("DELETE FROM Users_state WHERE User_id=#{User_id}")
    Boolean Users_stateDelete(Users_state users_state);
}
