package cn.xdh.entity;

import java.util.Date;

/**
 * @ProjectName: xdhbg
 * @Package: cn.xdh.entity
 * @ClassName: Experience
 * @Author: 81394
 * @Description: 心得
 * @Date: 2019/12/27 21:51
 * @Version: 1.0
 */
public class Experience {
    private int id;
    private int Student_id;
    private String content;
    private int add_time;

    public Experience() {
    }

    public Experience(int id, int student_id, String content, int add_time) {
        this.id = id;
        Student_id = student_id;
        this.content = content;
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }
    public Date getDateTime(){
        Long l = (long)getAdd_time()*1000;
        return new Date(l);
    }
}
