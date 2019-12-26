package cn.xdh.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * @author TZB
 */
public class Works implements Serializable {
    private int id;
    private int student_id;
    private String name;
    private String url;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private int add_time;
    private String time;

    public Works() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Works(int id, int student_id, String name, String url, int add_time, String time) {
        this.id = id;
        this.student_id = student_id;
        this.name = name;
        this.url = url;
        this.add_time = add_time;
        this.time = time;
    }
}
