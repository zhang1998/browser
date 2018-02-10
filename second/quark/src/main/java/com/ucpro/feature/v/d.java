package com.ucpro.feature.v;

import android.webkit.ValueCallback;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.translate.p;
import com.uc.translate.q;
import com.ucpro.business.stat.m;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class d implements q {
    final /* synthetic */ ValueCallback a;

    d(ValueCallback valueCallback) {
        this.a = valueCallback;
    }

    public final void a(String str, String str2) {
        m.a(Style.WX_TRANSLATE, "trans_error", "trans_error_code", str, "trans_error_msg", str2);
        e.a().a(str2, 1);
    }

    public final void a(p pVar) {
        if (this.a != null) {
            this.a.onReceiveValue(pVar.a);
        }
    }
}
