package cn.xdh;

import java.net.InetAddress;

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
    // 11
    public static Long getCurrentTime(){
        Long startTs = System.currentTimeMillis()/1000;
        return startTs;
    }

}
