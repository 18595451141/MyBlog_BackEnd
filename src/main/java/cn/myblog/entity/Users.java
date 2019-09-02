package cn.myblog.entity;

//User表的实体类
public class Users {

    private String User_Id;
    private String User_Name;
    private String User_Pwd;
    private String User_Autograph;
    private String User_State;
    private String User_WXId;
    private String User_Phone;
    private String User_Box;
    private String User_RealName;
    private String User_Birth;
    private String User_Register;

    //Alt+Insert创建get/set快捷键

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Pwd() {
        return User_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        User_Pwd = user_Pwd;
    }

    public String getUser_Autograph() {
        return User_Autograph;
    }

    public void setUser_Autograph(String user_Autograph) {
        User_Autograph = user_Autograph;
    }

    public String getUser_State() {
        return User_State;
    }

    public void setUser_State(String user_State) {
        User_State = user_State;
    }

    public String getUser_WXId() {
        return User_WXId;
    }

    public void setUser_WXId(String user_WXId) {
        User_WXId = user_WXId;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        User_Phone = user_Phone;
    }

    public String getUser_Box() {
        return User_Box;
    }

    public void setUser_Box(String user_Box) {
        User_Box = user_Box;
    }

    public String getUser_RealName() {
        return User_RealName;
    }

    public void setUser_RealName(String user_RealName) {
        User_RealName = user_RealName;
    }

    public String getUser_Birth() {
        return User_Birth;
    }

    public void setUser_Birth(String user_Birth) {
        User_Birth = user_Birth;
    }

    public String getUser_Register() {
        return User_Register;
    }

    public void setUser_Register(String user_Register) {
        User_Register = user_Register;
    }

    @Override
    public String toString() {
        return "Users{" +
                "User_Id='" + User_Id + '\'' +
                ", User_Name='" + User_Name + '\'' +
                ", User_Pwd='" + User_Pwd + '\'' +
                ", User_Autograph='" + User_Autograph + '\'' +
                ", User_State='" + User_State + '\'' +
                ", User_Phone='" + User_Phone + '\'' +
                ", User_RealName='" + User_RealName + '\'' +
                ", User_Birth='" + User_Birth + '\'' +
                ", User_Register='" + User_Register + '\'' +
                '}';
    }
}
