package cn.xdh.entity;

public class Admin {
    private int id;
    private String mobile;
    private String username;
    private String password;
    //状态,0为激活,1为未激活
    private int state;
    private int addtime;
    private String addip;

    public Admin() {
    }

    public Admin(int id, String mobile, String username, String password, int state, int addtime, String addip) {
        this.id = id;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.state = state;
        this.addtime = addtime;
        this.addip = addip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
