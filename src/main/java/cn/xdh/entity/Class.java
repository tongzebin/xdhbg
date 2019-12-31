package cn.xdh.entity;

public class Class {
    private int id;
    private String class_name;
    private long add_time;
    private int teacher_id;
    private int is_graduate;

    public Class() {
    }

    public Class(int id, String class_name, long add_time, int teacher_id, int is_graduate) {
        this.id = id;
        this.class_name = class_name;
        this.add_time = add_time;
        this.teacher_id = teacher_id;
        this.is_graduate = is_graduate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getIs_graduate() {
        return is_graduate;
    }

    public void setIs_graduate(int is_graduate) {
        this.is_graduate = is_graduate;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                ", add_time=" + add_time +
                ", teacher_id=" + teacher_id +
                ", is_graduate=" + is_graduate +
                '}';
    }
}
