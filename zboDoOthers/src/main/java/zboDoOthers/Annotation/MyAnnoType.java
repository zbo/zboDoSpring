package zboDoOthers.Annotation;

import java.lang.annotation.*;

/**
 * Created by twer on 14-10-3.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnoType {
    String value();
}
