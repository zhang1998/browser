package com.ucpro.feature.webwindow.e;

import com.uc.webview.browser.interfaces.DownloadListener;
import com.ucpro.base.a.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.downloadpage.e.b.a;
import hugo.weaving.DebugLog;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class g extends DownloadListener {
    private a a;

    public g() {
        com.ucpro.feature.u.a.a("WebDownloadListenerImpl", this);
    }

    public final void onVideoDownloadStart(String str, String str2, String str3, String str4, String str5, long j, boolean z, String str6, int i, Object obj) {
    }

    @DebugLog
    public final void onDownloadStartEx(String str, String str2, String str3, String str4, String str5, long j, boolean z, boolean z2, String str6, ArrayList<String> arrayList) {
        a aVar;
        if (this.a == null) {
            aVar = new a(str, str2, str3, str4, str5, j, z, z2, str6, arrayList);
        } else {
            aVar = this.a;
            aVar.a = str;
            aVar.b = str2;
            aVar.c = str3;
            aVar.d = str4;
            aVar.e = str5;
            aVar.f = j;
            aVar.g = z;
            aVar.h = z2;
            aVar.i = str6;
            aVar.j = arrayList;
        }
        this.a = aVar;
        com.ucpro.base.a.g.a().a(e.bl, this.a);
        m.a("download", "click_link", new String[0]);
    }
}
