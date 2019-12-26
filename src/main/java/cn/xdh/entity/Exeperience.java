package cn.xdh.entity;

/**
 * @author TZB
 */
public class Exeperience {
    private int id;
    private int student_id;
    private String content;
    private int add_time;
    private String Time;

    @Override
    public String toString() {
        return "Exeperience{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", content='" + content + '\'' +
                ", add_time=" + add_time +
                ", Time='" + Time + '\'' +
                '}';
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

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Exeperience() {
    }

    public Exeperience(int id, int student_id, String content, int add_time, String time) {
        this.id = id;
        this.student_id = student_id;
        this.content = content;
        this.add_time = add_time;
        Time = time;
    }
}
