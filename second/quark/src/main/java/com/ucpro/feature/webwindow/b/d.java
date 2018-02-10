package com.ucpro.feature.webwindow.b;

import android.webkit.ValueCallback;
import com.uc.media.interfaces.IProxyHandler;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class d implements ValueCallback<Integer> {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    d(k kVar, String str) {
        this.b = kVar;
        this.a = str;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Integer num = (Integer) obj;
        if (this.b.a != null) {
            f fVar = this.b.a;
            int intValue = num.intValue();
            String str = this.a;
            if (intValue > 0) {
                String str2;
                if (fVar.a.b() != null) {
                    str2 = fVar.a.b().b;
                } else {
                    str2 = "";
                }
                m.a("pic_viewer", "download_all", IProxyHandler.KEY_PAGE_URL, str2, "count", String.valueOf(intValue));
                com.ucweb.common.util.h.m.a(0, new v(fVar, str, intValue, intValue, str));
            }
        }
    }
}
