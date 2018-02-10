package com.bumptech.glide.f.a;

import com.bumptech.glide.util.l;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public abstract class f<Z> extends a<Z> {
    private final int a;
    private final int b;

    public f() {
        this((byte) 0);
    }

    private f(byte b) {
        this.a = SectionHeader.SHT_LOUSER;
        this.b = SectionHeader.SHT_LOUSER;
    }

    public final void a(g gVar) {
        if (l.a(this.a, this.b)) {
            gVar.a(this.a, this.b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.a + " and height: " + this.b + ", either provide dimensions in the constructor or call override()");
    }

    public final void b(g gVar) {
    }
}
