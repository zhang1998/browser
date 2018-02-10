package com.uc.webview.export.internal.android;

import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;

/* compiled from: ProGuard */
final class h extends WebBackForwardList {

    /* compiled from: ProGuard */
    final class a extends WebHistoryItem {
        final /* synthetic */ h a;

        a(h hVar, android.webkit.WebHistoryItem webHistoryItem) {
            this.a = hVar;
            this.mItem = webHistoryItem;
        }
    }

    h(android.webkit.WebBackForwardList webBackForwardList) {
        this.mList = webBackForwardList;
    }

    protected final WebHistoryItem createItem(android.webkit.WebHistoryItem webHistoryItem) {
        return new a(this, webHistoryItem);
    }
}
