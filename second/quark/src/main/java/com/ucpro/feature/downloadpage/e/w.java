package com.ucpro.feature.downloadpage.e;

import com.ucweb.common.util.f;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ y a;

    w(y yVar) {
        this.a = yVar;
    }

    public final void run() {
        int lastIndexOf = this.a.g.getText().toString().lastIndexOf(46);
        if (lastIndexOf > 0) {
            this.a.g.setSelection(0, lastIndexOf);
        } else {
            this.a.g.selectAll();
        }
        f.c(this.a.getContext());
    }
}
