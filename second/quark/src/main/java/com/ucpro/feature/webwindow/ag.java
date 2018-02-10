package com.ucpro.feature.webwindow;

import android.text.method.PasswordTransformationMethod;
import com.uc.webview.export.HttpAuthHandler;
import com.ucpro.ui.g.b;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.n;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
public final class ag implements n {
    final /* synthetic */ HttpAuthHandler a;
    final /* synthetic */ ba b;

    public ag(ba baVar, HttpAuthHandler httpAuthHandler) {
        this.b = baVar;
        this.a = httpAuthHandler;
    }

    public final void a(h hVar, int i) {
        if (i == 9507092) {
            b bVar = (b) hVar.findViewById(u.e);
            bVar.a();
            bVar.requestFocus();
            bVar = (b) hVar.findViewById(u.f);
            bVar.a();
            bVar.setInputType(128);
            bVar.setTransformationMethod(new PasswordTransformationMethod());
            hVar.e();
        } else if (i == 9507094 && this.a != null) {
            this.a.cancel();
        }
    }
}
