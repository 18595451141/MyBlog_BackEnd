package cn.myblog.entity;

//User表的实体类
public class Users {

    private String User_Id; //用户ID

    private String User_Name; //账号（用户名称）

    private String User_Pwd; //密码

    private Integer User_Jurisdiction; //权限：0普通用户,1会员,2管理员,3超管

    private String User_Autograph; //签名

    private String User_State; //状态

    private String User_WXId; //微信号码

    private String User_Phone; //手机号码

    private String User_MailBox; //邮箱号码

    private String User_RealName; //真实姓名

    private String User_Birth; //出生日期

    private String User_Register; //注册时间

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

    public Integer getUser_Jurisdiction() {
        return User_Jurisdiction;
    }

    public void setUser_Jurisdiction(Integer user_Jurisdiction) {
        User_Jurisdiction = user_Jurisdiction;
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

    public String getUser_MailBox() {
        return User_MailBox;
    }

    public void setUser_MailBox(String user_MailBox) {
        User_MailBox = user_MailBox;
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
                ", User_Jurisdiction=" + User_Jurisdiction +
                ", User_Autograph='" + User_Autograph + '\'' +
                ", User_State='" + User_State + '\'' +
                ", User_WXId='" + User_WXId + '\'' +
                ", User_Phone='" + User_Phone + '\'' +
                ", User_MailBox='" + User_MailBox + '\'' +
                ", User_RealName='" + User_RealName + '\'' +
                ", User_Birth='" + User_Birth + '\'' +
                ", User_Register='" + User_Register + '\'' +
                '}';
    }
}
