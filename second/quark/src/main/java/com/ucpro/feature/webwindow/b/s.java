package com.ucpro.feature.webwindow.b;

import com.bumptech.glide.c;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.f.e;
import com.bumptech.glide.n;
import com.bumptech.glide.p;
import com.bumptech.glide.util.l;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.ucpro.base.b.b;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.util.concurrent.ExecutionException;

/* compiled from: ProGuard */
final class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ m d;

    s(String str, int i, int i2, m mVar) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = mVar;
    }

    public final void run() {
        int i = SectionHeader.SHT_LOUSER;
        p b = ((b) c.b(d.a())).b(this.a);
        int i2 = -1 == this.b ? SectionHeader.SHT_LOUSER : this.b;
        if (-1 != this.c) {
            i = this.c;
        }
        b = b.c();
        h eVar = new e(b.b.a, i2, i);
        if (l.d()) {
            b.b.a.post(new n(b, eVar));
        } else {
            b.a(eVar);
        }
        try {
            File file = (File) eVar.get();
            if (file == null || !file.exists()) {
                m.a(2, new h(this));
            } else {
                m.a(2, new n(this, file));
            }
        } catch (InterruptedException e) {
            m.a(2, new x(this));
        } catch (ExecutionException e2) {
            m.a(2, new r(this));
        }
    }
}
