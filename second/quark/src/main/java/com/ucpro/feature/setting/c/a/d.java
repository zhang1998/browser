package com.ucpro.feature.setting.c.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.ucpro.services.d.a;

/* compiled from: ProGuard */
public final class d extends c {
    final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    protected final m a() {
        m mVar = new m("QuestSurveyCmsData", 50);
        mVar.a(1, "web_url", 1, 13);
        mVar.a(2, "quest_title", 1, 13);
        mVar.a(3, "is_click", 1, 11);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a.b != null) {
            mVar.a(1, a.a(this.a.b));
        }
        if (this.a.a != null) {
            mVar.a(2, a.a(this.a.a));
        }
        mVar.a(3, this.a.c);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.b = a.a(mVar.f(1));
        this.a.a = a.a(mVar.f(2));
        this.a.c = mVar.e(3);
        return true;
    }

    protected final i a(int i) {
        return new d(this.a);
    }
}
