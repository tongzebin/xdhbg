package cn.xdh.entity;

public class Teacher {
    private int id;
    private String name;
    private String mobile;
    private String password;
    private int addtime;
    private String addip;

    public Teacher() {
    }

    public Teacher(int id, String name, String mobile, String password, int addtime, String addip) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.addtime = addtime;
        this.addip = addip;
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

    public int getAddtime() {
        return addtime;
    }

    public void setAddtime(int addtime) {
        this.addtime = addtime;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }
}
