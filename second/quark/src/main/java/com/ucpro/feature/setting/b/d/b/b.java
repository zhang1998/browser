package com.ucpro.feature.setting.b.d.b;

import android.content.Context;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.setting.b.b.a;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class b extends h {
    private a e = null;

    public b(Context context, a aVar) {
        super(context);
        this.e = aVar;
        c.a(this.e);
        a();
    }

    protected final void a() {
        super.a();
        this.d.setImageDrawable(com.ucpro.ui.c.a.a("open_sub_setting.svg"));
    }

    public final void b() {
        this.b.setText(this.e.a);
    }

    protected final void c() {
        g.a().a(e.bc, this.e);
    }
}
