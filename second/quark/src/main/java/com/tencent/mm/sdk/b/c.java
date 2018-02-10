package com.tencent.mm.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.b.b.a;

final class c implements a {
    private Handler handler = new Handler(Looper.getMainLooper());

    c() {
    }

    public final void f(String str, String str2) {
        b.level;
    }

    public final void g(String str, String str2) {
        b.level;
    }

    public final int getLogLevel() {
        return b.level;
    }

    public final void h(String str, String str2) {
        if (b.level <= 3) {
            Log.w(str, str2);
        }
    }

    public final void i(String str, String str2) {
        if (b.level <= 4) {
            Log.e(str, str2);
        }
    }
}
