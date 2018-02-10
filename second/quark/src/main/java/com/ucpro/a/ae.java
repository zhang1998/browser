package com.ucpro.a;

import android.text.TextUtils;
import com.ucpro.a.c.d;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
final class ae implements d {
    ae() {
    }

    public final void a(String str, int i) {
        new StringBuilder("onIntSettingChanged: \nkey: ").append(str).append("\nvalue: ").append(String.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            c.a("WebSettingMonitor\nonIntSettingChanged should with a empty key");
        }
    }

    public final void a(String str, boolean z) {
        new StringBuilder("onBoolSettingChanged: \nkey: ").append(str).append("\nvalue: ").append(String.valueOf(z));
    }

    public final void a(String str, float f) {
        new StringBuilder("onFloatSettingChanged: \nkey: ").append(str).append("\nvalue: ").append(String.valueOf(f));
    }
}
