package com.ucpro.feature.webwindow.e;

import com.uc.webview.export.WebView.FindListener;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.feature.webwindow.bo;
import com.ucpro.feature.webwindow.g.e;
import com.ucpro.feature.webwindow.g.j;

/* compiled from: ProGuard */
public final class a implements FindListener {
    private j a;
    private bo b;

    public a(e eVar, bb bbVar) {
        this.a = eVar;
        this.b = bbVar;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (i == 0) {
            this.b.n();
        }
        this.a.a(i2, i);
    }
}
