package com.ucpro.feature.webwindow.c;

import com.uc.webview.export.JsPromptResult;
import com.ucpro.ui.g.b;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.n;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
public final class f implements n {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ JsPromptResult b;
    final /* synthetic */ h c;

    public f(h hVar, boolean[] zArr, JsPromptResult jsPromptResult) {
        this.c = hVar;
        this.a = zArr;
        this.b = jsPromptResult;
    }

    public final void a(h hVar, int i) {
        if (i == 9507092) {
            ((b) hVar.findViewById(u.g)).requestFocus();
            hVar.e();
        } else if (i == 9507094) {
            new StringBuilder("onDialogCmd CMD_DISMISS handle: ").append(String.valueOf(this.a[0]));
            if (this.b != null && !this.a[0]) {
                this.b.cancel();
            }
        }
    }
}
