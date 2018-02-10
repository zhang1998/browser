package butterknife.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ProGuard */
public @interface ListenerClass {

    /* compiled from: ProGuard */
    public enum NONE {
    }

    Class<? extends Enum<?>> callbacks() default NONE.class;

    ListenerMethod[] method() default {};

    String setter();

    String targetType();

    String type();
}
