package com.g.b.a.a;

import android.content.Context;
import com.g.b.a.d.a;

/* compiled from: ProGuard */
final class b implements e {
    private Context a;
    private String b;
    private c c = null;

    public b(Context context, String str) {
        this.a = context;
        this.b = str;
        this.c = d.a(this.a);
        if (this.c != null) {
            a.a(this.c.toString());
        } else {
            a.a("WeiboInfo: is null");
        }
    }

    public final boolean a() {
        return this.c != null;
    }
}
