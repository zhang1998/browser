package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: ProGuard */
public final class s {
    static final i a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new as();
        } else if (i >= 21) {
            a = new k();
        } else if (i >= 19) {
            a = new cg();
        } else if (i >= 9) {
            a = new cc();
        } else {
            a = new ak();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }

    public static void a(PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }
}
