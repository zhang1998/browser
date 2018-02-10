package kotlin.jvm.a;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.d.a;
import kotlin.d.c;

/* compiled from: ProGuard */
public abstract class g implements Serializable, c {
    @SinceKotlin(version = "1.1")
    public static final Object b = i.a();
    @SinceKotlin(version = "1.1")
    public final Object a;
    private transient c c;

    protected abstract c b();

    @SinceKotlin(version = "1.1")
    protected g(Object obj) {
        this.a = obj;
    }

    @SinceKotlin(version = "1.1")
    public final c c() {
        c cVar = this.c;
        if (cVar != null) {
            return cVar;
        }
        cVar = b();
        this.c = cVar;
        return cVar;
    }

    public a d() {
        throw new AbstractMethodError();
    }

    public String e() {
        throw new AbstractMethodError();
    }

    public String f() {
        throw new AbstractMethodError();
    }
}
