package com.ucpro.feature.bookmarkhis.c;

import android.app.Activity;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.c.b;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.feature.bookmarkhis.a.i;
import com.ucpro.feature.bookmarkhis.bookmark.aa;
import com.ucpro.feature.bookmarkhis.bookmark.ai;
import com.ucweb.common.util.f;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class a extends e implements c {
    private Activity c;
    private ai d;
    private i e;
    private com.ucpro.feature.bookmarkhis.c.a.a f;
    private ArrayList<com.ucpro.feature.bookmarkhis.c.a.c> g;

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.au) {
            int intValue;
            if (message.obj instanceof Integer) {
                intValue = ((Integer) message.obj).intValue();
            } else {
                intValue = 0;
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.clear();
            this.f = null;
            this.g.add(0, new com.ucpro.feature.bookmarkhis.c.a.c(com.ucpro.ui.c.a.d((int) R.string.bookmark), this.d.c(false)));
            this.g.add(1, new com.ucpro.feature.bookmarkhis.c.a.c(com.ucpro.ui.c.a.d((int) R.string.history), this.e.b(false)));
            this.f = new com.ucpro.feature.bookmarkhis.c.a.a(this.c, this.g);
            this.f.setWindowCallBacks(this);
            com.ucpro.feature.bookmarkhis.c.a.a aVar = this.f;
            if (aVar.g != null && intValue >= 0) {
                aVar.g.setCurrentItem$2563266(intValue);
            }
            this.f.getViewPager().a(new b(this));
            this.a.b().a(this.f, true);
        } else if (com.ucpro.base.a.e.av == i || com.ucpro.base.a.e.aF == i || com.ucpro.base.a.e.aI == i) {
            i();
        } else {
            this.d.a(i, message);
            this.e.a(i, message);
        }
    }

    public final void b(int i, Message message) {
        this.e.b(i, message);
        if (this.f != null) {
            this.f.l();
        }
    }

    protected final void a(b bVar) {
        super.a(bVar);
        this.c = bVar.a();
        this.d = new ai();
        this.d.a(bVar);
        this.e = new i();
        this.e.a(bVar);
    }

    private void i() {
        if (this.f == null || this.f.getCurPage() != 0) {
            s_().a(true);
            this.f = null;
            this.d.c = 0;
        } else if (this.g != null && this.g.size() > 0 && (((com.ucpro.feature.bookmarkhis.c.a.c) this.g.get(0)).b instanceof aa)) {
            aa aaVar = (aa) ((com.ucpro.feature.bookmarkhis.c.a.c) this.g.get(0)).b;
            if (aaVar.a()) {
                aaVar.c();
                return;
            }
            int i;
            ai aiVar = this.d;
            if (aiVar.c == 0 || aiVar.d == null) {
                i = true;
            } else {
                i = 0;
            }
            if (i == 0) {
                this.d.i();
                return;
            }
            s_().a(true);
            this.f = null;
            this.d.c = 0;
        }
    }

    public final void a(boolean z) {
        s_().a(z);
        this.f = null;
        this.d.c = 0;
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || !(gVar instanceof com.ucpro.feature.bookmarkhis.c.a.a)) {
            return false;
        }
        i();
        return true;
    }

    public final View a(View view) {
        f.a(this.c, view);
        if (view instanceof g) {
            return s_().b((g) view);
        }
        return null;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }
}
