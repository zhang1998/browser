package com.ucpro.feature.i.a;

import android.annotation.TargetApi;
import android.view.View;
import android.view.Window;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
class a implements b {
    private a() {
    }

    @TargetApi(11)
    public void a(Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            systemUiVisibility |= SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
        } else {
            systemUiVisibility &= -8193;
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }
}
