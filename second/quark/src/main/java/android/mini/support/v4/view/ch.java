package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ProGuard */
public final class ch {
    static final cd a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new cf();
        } else if (i >= 19) {
            a = new ce();
        } else if (i >= 14) {
            a = new cc();
        } else {
            a = new cg();
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i) {
        return a.a(viewParent, view, view2, i);
    }

    public static void b(ViewParent viewParent, View view, View view2, int i) {
        a.b(viewParent, view, view2, i);
    }

    public static void a(ViewParent viewParent, View view) {
        a.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        a.a(viewParent, view, i, i2, i3, i4);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        a.a(viewParent, view, i, i2, iArr);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return a.a(viewParent, view, f, f2);
    }
}
