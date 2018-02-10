package com.ucpro.feature.z.c;

import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.services.e.e;
import com.ucweb.common.util.d;
import com.ucweb.common.util.i.f;
import java.util.List;

/* compiled from: ProGuard */
public final class a implements b {
    public e a = null;
    private boolean b = false;
    private String c = "";

    public a(e eVar) {
        this.a = eVar;
        eVar.setPresenter(this);
        e.a.d();
    }

    public final void a() {
        g.a().b(com.ucpro.base.a.e.ap, this.c);
    }

    public final void b() {
        if (this.b) {
            g.a().b(com.ucpro.base.a.e.ao, this.c);
        } else {
            g.a().b(com.ucpro.base.a.e.an, this.c);
        }
    }

    public final void c() {
        String b = e.a.b();
        if (!TextUtils.isEmpty(b)) {
            int b2 = com.ucweb.common.util.j.a.b(d.a(), "D514292C05AB961A", "4DD6A49CAF9C717C", 0);
            int hashCode = b.hashCode();
            if (b2 == hashCode) {
                this.a.setIsCanShow(false);
                return;
            }
            List l = f.l(b);
            if (l.size() == 1) {
                this.a.setText(com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_visit) + " " + ((String) l.get(0)));
                this.b = true;
                this.c = (String) l.get(0);
            } else {
                this.a.setText(com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_search) + " " + b);
                this.b = false;
                this.c = b;
            }
            this.a.setIsCanShow(true);
            com.ucweb.common.util.j.a.a(d.a(), "D514292C05AB961A", "4DD6A49CAF9C717C", hashCode);
        }
    }
}
