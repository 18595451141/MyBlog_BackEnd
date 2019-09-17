package cn.myblog.entity;

public class Users_state {

    private Integer Us_id;

    private Integer User_id;

    private String Us_sessionid;

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

    public String getUs_sessionid() {
        return Us_sessionid;
    }

    public void setUs_sessionid(String us_sessionid) {
        Us_sessionid = us_sessionid;
    }

    @Override
    public String toString() {
        return "Users_state{" +
                "Us_id=" + Us_id +
                ", User_id=" + User_id +
                ", Us_sessionid=" + Us_sessionid +
                '}';
    }
}
