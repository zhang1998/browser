package com.ucpro.feature.downloadpage.e.a;

import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public final class a implements Runnable {
    final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        int lastIndexOf = this.a.v.getText().toString().lastIndexOf(46);
        if (lastIndexOf > 0) {
            this.a.v.setSelection(0, lastIndexOf);
        } else {
            this.a.v.selectAll();
        }
        f.c(this.a.getContext());
    }
}
