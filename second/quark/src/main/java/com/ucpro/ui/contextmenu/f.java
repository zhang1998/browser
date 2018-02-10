package com.ucpro.ui.contextmenu;

import android.content.Context;

/* compiled from: ProGuard */
public class f implements e {
    static final /* synthetic */ boolean c = (!f.class.desiredAssertionStatus());
    public a a = null;
    public d b;
    private int d;
    private int e;

    public static f a() {
        return c.a;
    }

    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public final d a(Context context) {
        if (this.b == null) {
            this.b = new d(context);
        }
        return this.b;
    }

    public final void a(Context context, b bVar) {
        this.a = new a(context);
        a aVar = this.a;
        aVar.b = a(context);
        if (aVar.b != null) {
            aVar.a.setAdapter(aVar.b);
        }
        if (this.a != null) {
            this.a.c = bVar;
        }
        d a = a(context);
        int i = this.d;
        int i2 = this.e;
        a.a.x = i;
        a.a.y = i2;
        a(context).notifyDataSetChanged();
        if (c || this.a != null) {
            this.a.show();
            return;
        }
        throw new AssertionError();
    }
}
