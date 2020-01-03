package cn.xdh.entity;



import java.io.Serializable;
import java.util.Date;

/**
 * @author TZB
 */
public class Works implements Serializable {
    private int id;
    private int student_id;
    private String name;
    private String url;
    private long add_time;


    public Works() {
    }
    public Works(int id, int student_id, String name, String url, int add_time) {
        this.id = id;
        this.student_id = student_id;
        this.name = name;
        this.url = url;
        this.add_time = add_time;
    }
    public Works(int id, int student_id, String name, String url, int add_time, String time) {
        this.id = id;
        this.student_id = student_id;
        this.name = name;
        this.url = url;
        this.add_time = add_time;
    }

    public Date getDateTime(){
        Long l = (long)getAdd_time()*1000;
        return new Date(l);
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

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }




}
