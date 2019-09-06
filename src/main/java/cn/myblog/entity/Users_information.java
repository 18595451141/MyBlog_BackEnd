package cn.myblog.entity;

import java.util.Date;

//User表实体类
public class Users_information {

    private Integer User_id; //用户表主键id自增非空

    private String User_accountNumber; //账号唯一非空

    private String User_password; //密码非空

    private String User_Key; //用户密钥

    private String User_nickname; //昵称

    private String User_headPortrait; //头像存储路径

    private Integer User_jurisdiction; //用户权限：0普通用户，1会员，2管理员，3最高管理

    private String User_autograph; //签名

    private String User_phone; //手机

    private String User_weChatid; //微信

    private String User_mailBox; //邮箱

    private Date User_birth; //出生日期

    private String User_realName; //真实姓名

    private String User_idNumber; //身份证号

    private Date User_register; //注册时间

    //Alt+Insert 快捷创建 Getter and Setter


    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getUser_accountNumber() {
        return User_accountNumber;
    }

    public void setUser_accountNumber(String user_accountNumber) {
        User_accountNumber = user_accountNumber;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }

    public String getUser_Key() {
        return User_Key;
    }

    public void setUser_Key(String user_Key) {
        User_Key = user_Key;
    }

    public String getUser_nickname() {
        return User_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        User_nickname = user_nickname;
    }

    public String getUser_headPortrait() {
        return User_headPortrait;
    }

    public void setUser_headPortrait(String user_headPortrait) {
        User_headPortrait = user_headPortrait;
    }

    public Integer getUser_jurisdiction() {
        return User_jurisdiction;
    }

    public void setUser_jurisdiction(Integer user_jurisdiction) {
        User_jurisdiction = user_jurisdiction;
    }

    public String getUser_autograph() {
        return User_autograph;
    }

    public void setUser_autograph(String user_autograph) {
        User_autograph = user_autograph;
    }

    public String getUser_phone() {
        return User_phone;
    }

    public void setUser_phone(String user_phone) {
        User_phone = user_phone;
    }

    public String getUser_weChatid() {
        return User_weChatid;
    }

    public void setUser_weChatid(String user_weChatid) {
        User_weChatid = user_weChatid;
    }

    public String getUser_mailBox() {
        return User_mailBox;
    }

    public void setUser_mailBox(String user_mailBox) {
        User_mailBox = user_mailBox;
    }

    public Date getUser_birth() {
        return User_birth;
    }

    public void setUser_birth(Date user_birth) {
        User_birth = user_birth;
    }

    public String getUser_realName() {
        return User_realName;
    }

    public void setUser_realName(String user_realName) {
        User_realName = user_realName;
    }

    public String getUser_idNumber() {
        return User_idNumber;
    }

    public void setUser_idNumber(String user_idNumber) {
        User_idNumber = user_idNumber;
    }

    public Date getUser_register() {
        return User_register;
    }

    public void setUser_register(Date user_register) {
        User_register = user_register;
    }

    @Override
    public String toString() {
        return "Users_information{" +
                "User_id=" + User_id +
                ", User_accountNumber='" + User_accountNumber + '\'' +
                ", User_password='" + User_password + '\'' +
                ", User_Key='" + User_Key + '\'' +
                ", User_nickname='" + User_nickname + '\'' +
                ", User_headPortrait='" + User_headPortrait + '\'' +
                ", User_jurisdiction=" + User_jurisdiction +
                ", User_autograph='" + User_autograph + '\'' +
                ", User_phone='" + User_phone + '\'' +
                ", User_weChatid='" + User_weChatid + '\'' +
                ", User_mailBox='" + User_mailBox + '\'' +
                ", User_birth=" + User_birth +
                ", User_realName='" + User_realName + '\'' +
                ", User_idNumber='" + User_idNumber + '\'' +
                ", User_register=" + User_register +
                '}';
    }
}
