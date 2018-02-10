package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ProGuard */
public final class be {
    static final dz a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new by();
        } else if (i >= 18) {
            a = new cq();
        } else if (i >= 14) {
            a = new ah();
        } else if (i >= 11) {
            a = new dj();
        } else {
            a = new cw();
        }
    }

    public static void a(ViewGroup viewGroup) {
        a.a(viewGroup);
    }
}
