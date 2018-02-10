package kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.Retention;
import kotlin.annotation.a;
import kotlin.annotation.b;

@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {b.FUNCTION, b.PROPERTY})
@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlin/internal/LowPriorityInOverloadResolution;", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 6})
@Retention(a.BINARY)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: ProGuard */
public @interface LowPriorityInOverloadResolution {
}
