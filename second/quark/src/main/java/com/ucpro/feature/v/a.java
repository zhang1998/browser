package com.ucpro.feature.v;

import android.os.Message;
import com.quark.browser.R;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public class a extends e {
    private b c;

    public final void a(int i, Message message) {
        String str;
        if (com.ucpro.base.a.e.cY == i && (message.obj instanceof String)) {
            str = (String) message.obj;
            m.a(Style.WX_TRANSLATE, "trans_phrase", new String[0]);
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.translate_translate_request), 0);
            com.ucweb.common.util.h.m.a(0, new c(this, str));
        } else if (com.ucpro.base.a.e.cZ == i && (message.obj instanceof String[])) {
            String[] strArr = (String[]) message.obj;
            String str2 = strArr[1];
            str = strArr[0];
            if (this.c == null || s_().a() != this.c) {
                this.c = new b(this.b, s_());
                s_().a(this.c, true);
                com.ucweb.common.util.h.m.a(0, new g(this, str, str2));
            }
        } else if (com.ucpro.base.a.e.db != i) {
            int i2 = com.ucpro.base.a.e.da;
        } else if (message.obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) message.obj).booleanValue();
            if (this.c != null) {
                s_().a(booleanValue);
                this.c = null;
            }
        }
    }

    public final void b(int i, Message message) {
    }
}
