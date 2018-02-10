package com.ucpro.feature.collectpanel;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.base.e.e;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;
import java.util.HashMap;

/* compiled from: ProGuard */
public class k extends e {
    private i c;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.aG == i) {
            Bundle bundle = (Bundle) message.obj;
            String string = bundle.getString("TITLE");
            String string2 = bundle.getString("URL");
            long a = s.a().a(m.a(string, string2));
            c.b(a >= 0);
            com.ucpro.ui.b.e.a().a("collect_toast_icon.svg", a.d((int) R.string.bookmark_add_sucess), a.d((int) R.string.select_classification), new d(this, string, string2, a));
        }
    }

    public final void b(int i, Message message) {
    }

    static /* synthetic */ void a(k kVar, String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (kVar.c != null) {
                Object obj;
                if (kVar.c.a != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return;
                }
            }
            l cVar = new com.ucpro.feature.collectpanel.view.c(kVar.b);
            kVar.c = new i(kVar.s_());
            kVar.c.a(cVar);
            cVar.setPresenter(kVar.c);
            g.a().b(com.ucpro.base.a.e.c, new b(kVar, str, str2, j));
            HashMap hashMap = new HashMap();
            hashMap.put("url", str2);
            hashMap.put("name", str);
            com.ucpro.business.stat.m.a("collectpanel", "cp_show", hashMap);
        }
    }
}
