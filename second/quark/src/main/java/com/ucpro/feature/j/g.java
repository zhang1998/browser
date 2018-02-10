package com.ucpro.feature.j;

import com.ucpro.base.a.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.j.a.b;
import com.ucpro.model.a.a;
import java.util.List;

/* compiled from: ProGuard */
public final class g implements e {
    private k a;
    private List<Integer> b = b.b();

    public g(k kVar) {
        this.a = kVar;
        this.a.setPresenter(this);
        b.a();
        a();
        if (this.b.size() >= 4) {
            this.a.a();
        }
    }

    public final void a(boolean z) {
        b.a();
        a.a.b("setting_shortcut_menu_enable", z);
        a();
        if (!z || this.b.size() == 0) {
            com.ucpro.base.a.g.a().b(e.dd, Boolean.valueOf(false));
        } else {
            com.ucpro.base.a.g.a().b(e.dd, Boolean.valueOf(true));
        }
        m.a("shrotcut_menu", "click_main_switch", "enable", String.valueOf(z));
    }

    public final void a(int i, boolean z) {
        if (z) {
            this.b.add(Integer.valueOf(i));
        } else {
            this.b.remove(Integer.valueOf(i));
        }
        b.a();
        String str = "";
        for (Integer valueOf : this.b) {
            str = str + String.valueOf(valueOf) + ",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        a.a.b("setting_selected_shortcut_menu", str);
        a();
        if (this.b.size() >= 4) {
            this.a.a();
        } else {
            this.a.setItemsEnable(true);
        }
        if (this.b.size() == 0) {
            com.ucpro.base.a.g.a().b(e.dd, Boolean.valueOf(false));
        } else {
            com.ucpro.base.a.g.a().b(e.dd, Boolean.valueOf(true));
        }
        m.a("shrotcut_menu", "click_item_switch", "enable", String.valueOf(z), "key", String.valueOf(i));
    }

    private void a() {
        List c = b.a().c();
        k kVar = this.a;
        b.a();
        kVar.a(b.d(), c);
    }
}
