package com.ucpro.ui.g;

import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class v implements q {
    final /* synthetic */ u a;
    private TextView b;
    private String c;
    private String d;
    private int[] e;

    public v(u uVar, TextView textView, String str) {
        this.a = uVar;
        this.b = textView;
        this.c = str;
        a();
    }

    public final void a() {
        this.b.setTextColor(a.c(this.c));
        if (this.d != null) {
            this.b.setBackgroundDrawable(a.a(this.d));
        }
        if (this.e != null && this.e.length >= 4) {
            this.b.setPadding(this.e[0], this.e[1], this.e[2], this.e[3]);
        }
    }
}
