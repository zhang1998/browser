package com.taobao.weex.c;

import android.text.Spannable;

/* compiled from: ProGuard */
final class as {
    protected final int a = 0;
    protected final int b;
    protected final int c;
    protected final Object d;

    as(int i, Object obj) {
        this.b = i;
        this.d = obj;
        this.c = 17;
    }

    public final void a(Spannable spannable) {
        spannable.setSpan(this.d, this.a, this.b, this.c);
    }
}
