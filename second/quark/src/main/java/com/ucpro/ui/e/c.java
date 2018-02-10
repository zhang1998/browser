package com.ucpro.ui.e;

import android.content.Context;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ucpro.ui.e.a.d;
import java.util.HashMap;

/* compiled from: ProGuard */
final class c<T extends e> extends bd<b> {
    SparseArray<T> c;
    HashMap<String, Integer> d = new HashMap();
    private Context e;

    public final /* synthetic */ void a(bh bhVar, int i) {
        b bVar = (b) bhVar;
        e eVar = (e) this.c.valueAt(i);
        bVar.s = eVar;
        bVar.r = i;
        eVar.a(eVar, bVar);
    }

    public c(Context context) {
        this.e = context;
        this.c = new SparseArray();
    }

    public final int a() {
        return this.c != null ? this.c.size() : 0;
    }

    public final int a(int i) {
        return ((e) this.c.valueAt(i)).c().ordinal();
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        d a = d.a(i);
        return d.a(a, LayoutInflater.from(this.e).inflate(a.h, null));
    }
}
