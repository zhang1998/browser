package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.annotation.a;
import kotlin.annotation.b;

@MustBeDocumented
@Target(allowedTargets = {b.FUNCTION, b.CONSTRUCTOR, b.PROPERTY_GETTER, b.PROPERTY_SETTER, b.CLASS})
@Retention(a.SOURCE)
@Documented
@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlin/jvm/Strictfp;", "", "kotlin-runtime"}, k = 1, mv = {1, 1, 6})
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface Strictfp {
}
