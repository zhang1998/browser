package com.ucpro.feature.g.c.b;

import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class h<T> extends bd<m> {
    ArrayList<T> c;
    l d;
    Object e;

    private h() {
    }

    public final /* synthetic */ void a(bh bhVar, int i) {
        m mVar = (m) bhVar;
        if (this.d == null) {
            throw new RuntimeException("please provider IProItemView interface impl");
        }
        Object obj = this.c.get(i);
        Object obj2 = this.e;
        mVar.m = obj;
        mVar.l = i;
        mVar.n = obj2;
        this.d.a(mVar.a, obj);
    }

    public final int a(int i) {
        if (this.d != null) {
            return 0;
        }
        throw new RuntimeException("please provider IProItemView interface impl");
    }

    public final int a() {
        return this.c != null ? this.c.size() : 0;
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        if (this.d != null) {
            return new m(this.d.a(), this.d);
        }
        throw new RuntimeException("please provider IProItemView interface impl");
    }
}
