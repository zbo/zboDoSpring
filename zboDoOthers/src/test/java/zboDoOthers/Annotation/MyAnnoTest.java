package zboDoOthers.Annotation;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

/**
 * Created by twer on 14-10-3.
 */
public class MyAnnoTest {
    @Test
    public void annoTest1() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName("zboDoOthers.Annotation.MyAnnoDemo");
        boolean flag = cls.isAnnotationPresent(MyAnnoType.class);
        if(flag){
            System.out.println("判断类是annotation");
            MyAnnoType annotation1 = cls.getAnnotation(MyAnnoType.class);
            System.out.println(annotation1.value());
        }

        Method method = cls.getMethod("myAnnoedLogic");
        flag = method.isAnnotationPresent(MyAnnoMethod.class) ;
        if(flag){
            System.out.println("判断方法也是annotation");
            MyAnnoMethod annotation2 = method.getAnnotation(MyAnnoMethod.class);
            System.out.println(annotation2.description()+"/t"+annotation2.isAnnotation());
        }
    }
}
