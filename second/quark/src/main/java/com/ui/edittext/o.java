package com.ui.edittext;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class o extends Handler implements Runnable {
    boolean a;
    private final WeakReference<TextView> b;

    public o(TextView textView) {
        this.b = new WeakReference(textView);
    }

    public final void run() {
        if (!this.a) {
            removeCallbacks(this);
            TextView textView = (TextView) this.b.get();
            if (textView != null && textView.I()) {
                if (textView.h != null) {
                    TextView.l(textView);
                }
                postAtTime(this, SystemClock.uptimeMillis() + 500);
            }
        }
    }
}
