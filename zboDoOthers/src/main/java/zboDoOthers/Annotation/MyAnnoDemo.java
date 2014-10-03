package zboDoOthers.Annotation;

/**
 * Created by twer on 14-10-3.
 */
@MyAnnoType("this is a type Anno")
public class MyAnnoDemo {
    @MyAnnoMethod(description = "this is a method Anno", isAnnotation = true)
    public void myAnnoedLogic(){
        System.out.println("Hello from annotation");
    }
}
