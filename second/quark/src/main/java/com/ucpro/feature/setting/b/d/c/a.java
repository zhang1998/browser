package com.ucpro.feature.setting.b.d.c;

import android.content.Context;
import com.ucpro.feature.setting.b.b.a.d;
import com.ucpro.feature.setting.b.d.b.h;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a {
    public Context a;
    public ArrayList<h> b;
    private ArrayList<d> c = new ArrayList();

    public a(Context context) {
        this.a = context;
    }

    public final void a() {
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((h) it.next()).b();
            }
        }
    }
}
