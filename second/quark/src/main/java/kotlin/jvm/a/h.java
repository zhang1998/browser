package kotlin.jvm.a;

import kotlin.SinceKotlin;
import kotlin.d.b;
import kotlin.d.d;

/* compiled from: ProGuard */
public final class h {
    private static final a a;
    private static final b[] b = new b[0];

    static {
        a aVar;
        try {
            aVar = (a) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            aVar = null;
        } catch (ClassNotFoundException e2) {
            aVar = null;
        } catch (InstantiationException e3) {
            aVar = null;
        } catch (IllegalAccessException e4) {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new a();
        }
        a = aVar;
    }

    public static d a(c cVar) {
        return cVar;
    }

    public static b a(Class cls) {
        return new j(cls);
    }

    @SinceKotlin(version = "1.1")
    public static String a(b bVar) {
        String obj = bVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
