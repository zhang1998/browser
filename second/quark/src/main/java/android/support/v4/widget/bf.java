package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.widget.TextView;

/* compiled from: ProGuard */
public final class bf {
    static final cd a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new n();
        } else if (i >= 18) {
            a = new ck();
        } else if (i >= 17) {
            a = new w();
        } else if (i >= 16) {
            a = new cj();
        } else {
            a = new ab();
        }
    }

    public static int a(@NonNull TextView textView) {
        return a.a(textView);
    }
}
