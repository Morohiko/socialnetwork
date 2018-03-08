package Service;

import java.util.Date;

public class Utils {
    static String getDataTime(){
        Date date = new Date();
        System.out.println("gettime = " + date.getTime());
        return Integer.toString((int) date.getTime());
    }
}
