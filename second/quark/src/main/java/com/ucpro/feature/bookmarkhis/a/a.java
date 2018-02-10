package com.ucpro.feature.bookmarkhis.a;

import android.view.View;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.business.stat.m;
import com.ucpro.feature.bookmarkhis.a.b.d;
import com.ucweb.common.util.i.f;
import java.util.HashMap;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ View b;
    final /* synthetic */ i c;

    a(i iVar, d dVar, View view) {
        this.c = iVar;
        this.a = dVar;
        this.b = view;
    }

    public final void run() {
        if (this.a != null && this.a.a != null) {
            int i;
            e.a;
            String str = this.a.a.b;
            String e = f.e(this.a.a.c);
            int i2 = this.a.c;
            if (this.c.i() == null) {
                i = 0;
            } else {
                i = this.c.i().size();
            }
            new StringBuilder("statHistoryLongClick: \ntitle: ").append(str).append("\nhostName: ").append(e).append("\nindex: ").append(String.valueOf(i2)).append("\ntotalCount: ").append(String.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("long_click", SettingsConst.TRUE);
            hashMap.put("history_item_title", str);
            hashMap.put("history_item_host_name", e);
            hashMap.put("histroy_item_index", String.valueOf(i2));
            hashMap.put("count", String.valueOf(i));
            m.a("histroy", "histroy_action", hashMap);
            com.ucpro.ui.contextmenu.d a = com.ucpro.ui.contextmenu.f.a().a(this.c.b);
            a.c();
            a.a(com.ucpro.ui.c.a.d((int) R.string.delete_history_item), 30018);
            a.a(new Object[]{this.b, this.a});
            com.ucpro.ui.contextmenu.f.a().a(this.c.b, this.c);
        }
    }
}
