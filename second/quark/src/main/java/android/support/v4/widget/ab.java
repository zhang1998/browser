package android.support.v4.widget;

import android.widget.TextView;

/* compiled from: ProGuard */
class ab implements cd {
    ab() {
    }

    public int a(TextView textView) {
        if (!bj.d) {
            bj.c = bj.a("mMaxMode");
            bj.d = true;
        }
        if (bj.c != null && bj.a(bj.c, textView) == 1) {
            if (!bj.b) {
                bj.a = bj.a("mMaximum");
                bj.b = true;
            }
            if (bj.a != null) {
                return bj.a(bj.a, textView);
            }
        }
        return -1;
    }
}
