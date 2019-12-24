package cn.xdh.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String phone;
    private String password;
    private String name;
    //0为女,1为男
    private int sex;
    private int age;
    private String address;
    //入学时间
    private int startTime;
    //毕业时间
    private int lastTime;
    private String school;
    private String studyProcess;
    private String graduateStatus;
    private String experience;
    private int isDel;
    private int salary;
    private String company;
    private String city;
    //班期
    private String classDate;

    public Student() {
        super();
    }

    public Student(int id, String phone, String password, String name, int sex, int age, String address, int startTime, int lastTime, String school, String studyProcess, String graduateStatus, String experience, int isDel, int salary, String company, String city, String classDate) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.school = school;
        this.studyProcess = studyProcess;
        this.graduateStatus = graduateStatus;
        this.experience = experience;
        this.isDel = isDel;
        this.salary = salary;
        this.company = company;
        this.city = city;
        this.classDate = classDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudyProcess() {
        return studyProcess;
    }

    public void setStudyProcess(String studyProcess) {
        this.studyProcess = studyProcess;
    }

    public String getGraduateStatus() {
        return graduateStatus;
    }

    public void setGraduateStatus(String graduateStatus) {
        this.graduateStatus = graduateStatus;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }


}
