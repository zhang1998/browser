package android.mini.support.v4.view.a;

import android.mini.support.annotation.Nullable;
import android.os.Build.VERSION;
import java.util.List;

/* compiled from: ProGuard */
public final class y {
    private static final s b;
    public final Object a;

    static {
        if (VERSION.SDK_INT >= 19) {
            b = new w();
        } else if (VERSION.SDK_INT >= 16) {
            b = new u();
        } else {
            b = new x();
        }
    }

    public y() {
        this.a = b.a(this);
    }

    public y(Object obj) {
        this.a = obj;
    }

    @Nullable
    public static r a() {
        return null;
    }

    public static boolean b() {
        return false;
    }

    @Nullable
    public static List<r> c() {
        return null;
    }

    @Nullable
    public static r d() {
        return null;
    }
}
