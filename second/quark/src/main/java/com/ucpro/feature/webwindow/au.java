package com.ucpro.feature.webwindow;

import android.util.Log;
import com.uc.webview.export.HttpAuthHandler;
import com.ucpro.ui.g.b;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
public final class au implements l {
    final /* synthetic */ HttpAuthHandler a;
    final /* synthetic */ ba b;

    public au(ba baVar, HttpAuthHandler httpAuthHandler) {
        this.b = baVar;
        this.a = httpAuthHandler;
    }

    public final boolean a(h hVar, int i, Object obj) {
        String str = ((b) hVar.findViewById(u.e)).getText().toString();
        String str2 = ((b) hVar.findViewById(u.f)).getText().toString();
        if (u.c == i) {
            new StringBuilder("user name:").append(str).append(", password:").append(str2);
            if (this.a != null) {
                this.a.proceed(str, str2);
            }
            hVar.dismiss();
            return true;
        } else if (u.d != i) {
            return false;
        } else {
            Log.e("showHttpAuthDialog", "user cancel http auth by NO!");
            if (this.a != null) {
                this.a.cancel();
            }
            hVar.dismiss();
            return true;
        }
    }
}
