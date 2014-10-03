import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by twer on 14-10-2.
 */
public class JobLaunch {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("batch.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        //Job job = (Job) context.getBean("helloWorldJob");
        Job job = (Job) context.getBean("csvJob");
        //FlatFileItemWriter writer= (FlatFileItemWriter) context.getBean("csvItemWriter");

        try {
            /* 运行Job */
            JobExecution result = launcher.run(job, new JobParameters());
            /* 处理结束，控制台打印处理结果 */
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
