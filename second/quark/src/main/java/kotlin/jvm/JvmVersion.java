package kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.Retention;
import kotlin.annotation.a;
import kotlin.annotation.b;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@kotlin.annotation.Target(allowedTargets = {b.FILE, b.CLASS, b.PROPERTY, b.CONSTRUCTOR, b.FUNCTION})
@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003R\t\u0010\u0004\u001a\u00020\u0003¢\u0006\u0000R\t\u0010\u0002\u001a\u00020\u0003¢\u0006\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/jvm/JvmVersion;", "", "minimum", "", "maximum", "kotlin-stdlib"}, k = 1, mv = {1, 1, 6})
@Retention(a.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface JvmVersion {
    int maximum() default 100;

    int minimum() default 6;
}
