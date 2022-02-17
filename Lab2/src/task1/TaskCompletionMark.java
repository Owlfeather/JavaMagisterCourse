package task1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskCompletionMark {
    public  void printMark() {
        String devSurname = "Martynyuk";
        System.out.printf("\nDeveloper surname: %s \n", devSurname);
        System.out.printf("Time of task receiving: 2022/02/11 17:25:00 \n");
        Date d = new Date();
        String submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(d.getTime());
        System.out.printf("Time of task submition: %s \n", submitTime);
    }
}
