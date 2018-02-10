package com.ucpro.feature.bookmarkhis.b;

import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.privacymode.a.a;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class e extends com.ucpro.base.e.e implements j, p {
    private g c;

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.cC) {
            if (this.c == null || s_().a() != this.c) {
                this.c = new g(this.b);
                this.c.setPresenter(new k(this.b, this.c));
                this.c.setWindowManger(s_());
                this.c.setOnDeleteItem(this);
                this.c.setOnClickOpenItem(this);
                d();
                this.a.b().a(this.c, true);
                Time time = new Time();
                time.setToNow();
                int i2 = time.hour;
                m.a("privacy_mode", "privacy_bookmark", "privacy_bookmark_page_time", String.valueOf(i2));
            }
        } else if (i == com.ucpro.base.a.e.cD) {
            if (message != null && (message.obj instanceof Boolean)) {
                boolean booleanValue = ((Boolean) message.obj).booleanValue();
                if (this.c != null) {
                    this.a.b().a(booleanValue);
                    this.c = null;
                }
            }
        } else if (i != com.ucpro.base.a.e.cE) {
        } else {
            if (!a.a()) {
                g.a().a(com.ucpro.base.a.e.cx);
            } else if (message != null && (message.obj instanceof String[])) {
                c.a(((String[]) message.obj).length);
            }
        }
    }

    public final void b(int i, Message message) {
    }

    public final void a(ArrayList<Long> arrayList) {
        if (arrayList != null) {
            s.a().a((List) arrayList, new c(this));
        }
    }

    public final void a(com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        c.a((Object) mVar);
        if (mVar != null && mVar.h() && !TextUtils.isEmpty(mVar.f)) {
            s_().b(true);
            Object ajVar = new aj();
            ajVar.o = mVar.f;
            ajVar.s = aj.c;
            g.a().a(com.ucpro.base.a.e.k, ajVar);
            s_().a(true);
            m.a("privacy_mode", "privacy_bookmark_click", new String[0]);
        }
    }

    public final void d() {
        com.ucweb.common.util.h.m.a(0, new d(this));
    }

    static /* synthetic */ void a(e eVar, List list) {
        if (eVar.c != null && eVar.c != null) {
            eVar.c.setupBookmarkView(list);
        }
    }
}
