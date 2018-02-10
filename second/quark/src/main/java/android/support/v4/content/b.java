package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class b {
    private static final a a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            a = new f();
        } else if (i >= 11) {
            a = new h();
        } else {
            a = new e();
        }
    }

    public static Intent a(ComponentName componentName) {
        return a.a(componentName);
    }
}
