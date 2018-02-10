package com.bumptech.glide.b.b.b;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.i;
import com.bumptech.glide.util.g;

/* compiled from: ProGuard */
public final class m extends g<i, au<?>> implements o {
    private n a;

    protected final /* synthetic */ int a(Object obj) {
        return ((au) obj).c();
    }

    @Nullable
    public final /* synthetic */ au a(i iVar) {
        return (au) super.c(iVar);
    }

    public final /* synthetic */ au a(i iVar, au auVar) {
        return (au) super.b(iVar, auVar);
    }

    public m(int i) {
        super(i);
    }

    public final void a(n nVar) {
        this.a = nVar;
    }

    @SuppressLint({"InlinedApi"})
    public final void a(int i) {
        if (i >= 40) {
            b(0);
        } else if (i >= 20) {
            b(b() / 2);
        }
    }
}
