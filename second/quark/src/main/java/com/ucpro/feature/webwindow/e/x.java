package com.ucpro.feature.webwindow.e;

import com.uc.webview.export.WebHistoryItem;
import com.uc.webview.export.extension.IBackForwardListListener;
import com.ucpro.feature.u.a;
import com.ucpro.feature.webwindow.bo;

/* compiled from: ProGuard */
public final class x implements IBackForwardListListener {
    private final bo a;

    public x(bo boVar) {
        this.a = boVar;
        a.a("WebViewBackForwardClientImpl", this);
    }

    public final void onNewHistoryItem(WebHistoryItem webHistoryItem) {
        this.a.p();
    }

    public final void onIndexChanged(WebHistoryItem webHistoryItem, int i) {
        this.a.p();
    }
}
