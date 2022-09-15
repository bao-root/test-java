package www.com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.com.task.TaskJob;

/**
 * @author YangXu
 * @description task定时任务测试类
 * @date 2022/09/13 19:42
 */
public class TaskJonTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring4.xml");
        TaskJob taskJob = (TaskJob) ac.getBean("taskJob");
        taskJob.task1();
    }
}
