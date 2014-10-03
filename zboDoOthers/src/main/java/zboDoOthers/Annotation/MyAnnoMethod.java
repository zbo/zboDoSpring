package zboDoOthers.Annotation;
import java.lang.annotation.*;

/**
 * Created by twer on 14-10-3.
 * MyAnno test apply on method or constructor
 */
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnoMethod {
    String description();
    boolean isAnnotation();
}
