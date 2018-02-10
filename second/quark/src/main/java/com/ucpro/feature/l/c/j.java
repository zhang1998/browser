package com.ucpro.feature.l.c;

import android.content.Context;
import com.ucpro.feature.l.a.a;
import com.ucpro.feature.l.a.b;
import com.ucpro.feature.l.a.g;
import com.ucpro.feature.l.b.k;
import com.ucpro.feature.l.b.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class j implements b {
    public f a = null;
    public k b = null;
    public a c = null;
    List<m> d = new ArrayList();
    public Context e = null;
    public int f = 0;
    public int g = 0;
    public float h = 0.0f;
    public int i = 0;
    private p j = null;
    private g k = null;

    public j(Context context, f fVar) {
        this.e = context;
        this.a = fVar;
        fVar.setPresenter(this);
        this.b = new com.ucpro.feature.l.b.g(context);
        this.j = new com.ucpro.feature.l.b.j(this.b);
        this.c = new b(context);
        this.k = new com.ucpro.feature.l.a.j(this.c);
        this.d.add(this.b);
        this.d.add(this.c);
        fVar.getContent().getViewPager().setAdapter(new g(this));
        fVar.getContent().getTabLayout().setupWithViewPager(fVar.getContent().getViewPager());
        this.i = com.ucweb.common.util.j.a.b(this.e, "0FD35766FBF86241", "D453CF393F9E62D2", 0);
        fVar.getContent().getViewPager().setCurrentItem(this.i);
        fVar.getContent().getViewPager().a(new c(this));
    }

    public final m a() {
        if (this.a.getContent().getViewPager().getCurrentItem() == 0) {
            return this.b;
        }
        return this.c;
    }
}
