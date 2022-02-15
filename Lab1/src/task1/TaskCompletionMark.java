package task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TaskCompletionMark {

    public static void main(String[] args) {

        String devSurname = "Martynyuk";
        Calendar calendar = new GregorianCalendar(2022,Calendar.FEBRUARY,11,17,25,0);
        String receiveTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(calendar.getTime());
        String submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.printf("Developer surname: %s \n", devSurname);
        System.out.printf("Time of task receiving: %s \n", receiveTime);
        System.out.printf("Time of task submition: %s \n", submitTime);

    }
}
