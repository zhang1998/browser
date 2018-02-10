package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: ProGuard */
public final class s {
    static final r a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new q();
        } else {
            a = new o();
        }
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.b(keyEvent.getMetaState());
    }

    public static boolean b(KeyEvent keyEvent) {
        return a.c(keyEvent.getMetaState());
    }
}
