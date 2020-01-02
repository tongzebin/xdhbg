package cn.xdh.entity;

import org.springframework.stereotype.Component;

@Component
public class TeacherLog {
    private int id;

    private int teacher_id;

    private String teacher_name;

    private String action;

    private long add_time;

    private String add_ip;

    public TeacherLog() {
    }

    public TeacherLog(int teacher_id, String teacher_name, String action, long add_time, String add_ip) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.action = action;
        this.add_time = add_time;
        this.add_ip = add_ip;
    }

    public TeacherLog(int id, int teacher_id, String teacher_name, String action, long add_time, String add_ip) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.action = action;
        this.add_time = add_time;
        this.add_ip = add_ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public String getAdd_ip() {
        return add_ip;
    }

    public void setAdd_ip(String add_ip) {
        this.add_ip = add_ip;
    }

    @Override
    public String toString() {
        return "TeacherLog{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", action='" + action + '\'' +
                ", add_time=" + add_time +
                ", add_ip='" + add_ip + '\'' +
                '}';
    }
}
