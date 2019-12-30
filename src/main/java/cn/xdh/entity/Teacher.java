package cn.xdh.entity;

public class Teacher {
    private int id;
    private String name;
    private String mobile;
    private String password;
    private int add_time;
    private String add_ip;

    public Teacher() {
    }

    public Teacher(int id, String name, String mobile, String password, int add_time, String add_ip) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.add_time = add_time;
        this.add_ip = add_ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public String getAdd_ip() {
        return add_ip;
    }

    public void setAdd_ip(String add_ip) {
        this.add_ip = add_ip;
    }
}
