package www.com.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YangXu
 * @description task定时任务类
 * @date 2022/09/13 19:34
 */
@Component
public class TaskJob {

    /**
     * 定时任务1
     */
    @Scheduled(cron = "0/3 * * * * ?")
    public void task1(){
        System.out.println("one: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

}
