package cn.xdh.util;

import cn.xdh.entity.TeacherLog;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.security.MessageDigest;

public class SomeMethods {
    public static String getIp4(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
            String localip=ia.getHostAddress();
            return localip;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static long getCurrentTime(){
        long startTs = System.currentTimeMillis()/1000;
        return startTs;
    }

    //md5加密
    public static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            //System.out.println(new String(bytes));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static void getCookieValue(HttpServletRequest request, TeacherLog teacherLog,String action){
        //将老师操作放到日志中
        Cookie[] cookies = request.getCookies();
        //获得日志中需要的数据
        String teacherId = "teacherId";
        String name = "name";
        long add_time = SomeMethods.getCurrentTime();
        String teacherIp = "teacherIp";
        //将日志数据添加到日志实体类中
        teacherLog.setAction(action);
        teacherLog.setAdd_time(add_time);
        for(Cookie cookie:cookies){
            if (cookie.getName().equals(name)){
                teacherLog.setTeacher_name(cookie.getValue());
            }
            if (cookie.getName().equals(teacherId)){
                //将字符串形式的id转换成int类型
                int teacher_id = Integer.parseInt(cookie.getValue());
                teacherLog.setTeacher_id(teacher_id);
            }
            if (cookie.getName().equals(teacherIp)){
                teacherLog.setAdd_ip(cookie.getValue());
            }
        }
    }

}
