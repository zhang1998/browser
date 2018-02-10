package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: ProGuard */
public final class dn {
    static final dl a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new dq();
        } else {
            a = new eg();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.a(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        a.a(keyEvent);
    }
}
