package cn.myblog.entity;

import java.util.Date;

//系统权限表实体类
public class SystemPermissions {

    private Integer Sp_id; //系统表主键id

    private String Sp_name; //系统名称

    private String Sp_mainRoute; //系统路径

    private String Sp_smallTwo; //系统二级目录

    private String Sp_smallTwoRoute; //系统二级目录路径

    private String Sp_Basepath; //系统根目录

    private Integer Sp_status; //系统状态:0隐藏 1显示

    private String Sp_description; //系统描述

    private String Sp_icon; //样式图标

    private Integer Sp_jurisdiction; //系统权限

    private Integer Sp_order; //系统排序

    private Date Sp_ctime; //创建时间

    public Integer getSp_id() {
        return Sp_id;
    }

    public void setSp_id(Integer sp_id) {
        Sp_id = sp_id;
    }

    public String getSp_name() {
        return Sp_name;
    }

    public void setSp_name(String sp_name) {
        Sp_name = sp_name;
    }

    public String getSp_mainRoute() {
        return Sp_mainRoute;
    }

    public void setSp_mainRoute(String sp_mainRoute) {
        Sp_mainRoute = sp_mainRoute;
    }

    public String getSp_smallTwo() {
        return Sp_smallTwo;
    }

    public void setSp_smallTwo(String sp_smallTwo) {
        Sp_smallTwo = sp_smallTwo;
    }

    public String getSp_smallTwoRoute() {
        return Sp_smallTwoRoute;
    }

    public void setSp_smallTwoRoute(String sp_smallTwoRoute) {
        Sp_smallTwoRoute = sp_smallTwoRoute;
    }

    public String getSp_Basepath() {
        return Sp_Basepath;
    }

    public void setSp_Basepath(String sp_Basepath) {
        Sp_Basepath = sp_Basepath;
    }

    public Integer getSp_status() {
        return Sp_status;
    }

    public void setSp_status(Integer sp_status) {
        Sp_status = sp_status;
    }

    public String getSp_description() {
        return Sp_description;
    }

    public void setSp_description(String sp_description) {
        Sp_description = sp_description;
    }

    public String getSp_icon() {
        return Sp_icon;
    }

    public void setSp_icon(String sp_icon) {
        Sp_icon = sp_icon;
    }

    public Integer getSp_jurisdiction() {
        return Sp_jurisdiction;
    }

    public void setSp_jurisdiction(Integer sp_jurisdiction) {
        Sp_jurisdiction = sp_jurisdiction;
    }

    public Integer getSp_order() {
        return Sp_order;
    }

    public void setSp_order(Integer sp_order) {
        Sp_order = sp_order;
    }

    public Date getSp_ctime() {
        return Sp_ctime;
    }

    public void setSp_ctime(Date sp_ctime) {
        Sp_ctime = sp_ctime;
    }

    @Override
    public String toString() {
        return "SystemPermissions{" +
                "Sp_id=" + Sp_id +
                ", Sp_name='" + Sp_name + '\'' +
                ", Sp_mainRoute='" + Sp_mainRoute + '\'' +
                ", Sp_smallTwo='" + Sp_smallTwo + '\'' +
                ", Sp_smallTwoRoute='" + Sp_smallTwoRoute + '\'' +
                ", Sp_Basepath='" + Sp_Basepath + '\'' +
                ", Sp_status=" + Sp_status +
                ", Sp_description='" + Sp_description + '\'' +
                ", Sp_icon='" + Sp_icon + '\'' +
                ", Sp_jurisdiction=" + Sp_jurisdiction +
                ", Sp_order=" + Sp_order +
                ", Sp_ctime=" + Sp_ctime +
                '}';
    }
}
