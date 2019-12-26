package cn.xdh.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String username;
    private String mobile;
    private String password;
    private String birthday;
    private int join_study_time;
    private int graduate_time;
    private String graduate_school;
    private int province_id;
    private int city_id;
    private int area_id;
    private String address;
    private int class_id;
    private String progress;
    private int is_graduate;
    private String company;
    private double salary;
    private int aim_province_id;
    private int aim_city_id;
    private int aim_area_id;
    private String aim_address;
    private int stage_id;

    public Student() {
    }

    public Student(int id, String username, String mobile, String password, String birthday, int join_study_time, int graduate_time, String graduate_school, int province_id, int city_id, int area_id, String address, int class_id, String progress, int is_graduate, String company, double salary, int aim_province_id, int aim_city_id, int aim_area_id, String aim_address, int stage_id) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
        this.birthday = birthday;
        this.join_study_time = join_study_time;
        this.graduate_time = graduate_time;
        this.graduate_school = graduate_school;
        this.province_id = province_id;
        this.city_id = city_id;
        this.area_id = area_id;
        this.address = address;
        this.class_id = class_id;
        this.progress = progress;
        this.is_graduate = is_graduate;
        this.company = company;
        this.salary = salary;
        this.aim_province_id = aim_province_id;
        this.aim_city_id = aim_city_id;
        this.aim_area_id = aim_area_id;
        this.aim_address = aim_address;
        this.stage_id = stage_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getJoin_study_time() {
        return join_study_time;
    }

    public void setJoin_study_time(int join_study_time) {
        this.join_study_time = join_study_time;
    }

    public int getGraduate_time() {
        return graduate_time;
    }

    public void setGraduate_time(int graduate_time) {
        this.graduate_time = graduate_time;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getIs_graduate() {
        return is_graduate;
    }

    public void setIs_graduate(int is_graduate) {
        this.is_graduate = is_graduate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAim_province_id() {
        return aim_province_id;
    }

    public void setAim_province_id(int aim_province_id) {
        this.aim_province_id = aim_province_id;
    }

    public int getAim_city_id() {
        return aim_city_id;
    }

    public void setAim_city_id(int aim_city_id) {
        this.aim_city_id = aim_city_id;
    }

    public int getAim_area_id() {
        return aim_area_id;
    }

    public void setAim_area_id(int aim_area_id) {
        this.aim_area_id = aim_area_id;
    }

    public String getAim_address() {
        return aim_address;
    }

    public void setAim_address(String aim_address) {
        this.aim_address = aim_address;
    }

    public int getStage_id() {
        return stage_id;
    }

    public void setStage_id(int stage_id) {
        this.stage_id = stage_id;
    }
}
