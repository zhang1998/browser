package com.ucpro.feature.webwindow.c;

import com.uc.webview.export.JsPromptResult;
import com.ucpro.ui.g.b;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
public final class m implements l {
    final /* synthetic */ JsPromptResult a;
    final /* synthetic */ boolean[] b;
    final /* synthetic */ h c;

    public m(h hVar, JsPromptResult jsPromptResult, boolean[] zArr) {
        this.c = hVar;
        this.a = jsPromptResult;
        this.b = zArr;
    }

    public final boolean a(h hVar, int i, Object obj) {
        String str = ((b) hVar.findViewById(u.g)).getText().toString();
        if (u.c == i) {
            if (this.a != null) {
                this.a.confirm(str);
                this.b[0] = true;
            }
            hVar.dismiss();
        } else if (u.d == i) {
            if (this.a != null) {
                this.a.cancel();
                this.b[0] = true;
            }
            hVar.dismiss();
        }
        return this.b[0];
    }
}
