package cn.myblog.entity;

public class Users_state {

    private Integer Us_id;

    private Integer User_id;

    private Integer Us_state;

    public Integer getUs_id() {
        return Us_id;
    }

    public void setUs_id(Integer us_id) {
        Us_id = us_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public Integer getUs_state() {
        return Us_state;
    }

    public void setUs_state(Integer us_state) {
        Us_state = us_state;
    }

    @Override
    public String toString() {
        return "Users_state{" +
                "Us_id=" + Us_id +
                ", User_id=" + User_id +
                ", Us_state=" + Us_state +
                '}';
    }
}
