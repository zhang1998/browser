package android.support.v4.view.b;

import android.os.Build.VERSION;
import java.util.List;

/* compiled from: ProGuard */
public final class aj {
    private static final ab b;
    public final Object a;

    static {
        if (VERSION.SDK_INT >= 19) {
            b = new ah();
        } else if (VERSION.SDK_INT >= 16) {
            b = new v();
        } else {
            b = new p();
        }
    }

    public aj() {
        this.a = b.a(this);
    }

    public aj(Object obj) {
        this.a = obj;
    }

    public static s a() {
        return null;
    }

    public static boolean b() {
        return false;
    }

    public static List<s> c() {
        return null;
    }

    public static s d() {
        return null;
    }
}
