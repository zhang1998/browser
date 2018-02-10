package com.taobao.weex.ui.view.listview.a;

import android.mini.support.v7.widget.StaggeredGridLayoutManager;
import android.mini.support.v7.widget.am;
import android.mini.support.v7.widget.bf;
import android.view.ViewGroup.LayoutParams;
import com.taobao.weex.ui.component.ak;

/* compiled from: ProGuard */
public final class d<T extends c> extends am<T> {
    private b c;

    public final /* synthetic */ void a(bf bfVar) {
        bfVar = (c) bfVar;
        if (this.c != null) {
            this.c.b(bfVar);
        }
        super.a(bfVar);
    }

    public final /* bridge */ /* synthetic */ void a(bf bfVar, int i) {
        c cVar = (c) bfVar;
        if (this.c != null) {
            this.c.a(cVar, i);
        }
    }

    public final /* synthetic */ boolean b(bf bfVar) {
        bfVar = (c) bfVar;
        if (this.c != null) {
            return this.c.a(bfVar);
        }
        return super.b(bfVar);
    }

    public final /* synthetic */ void c(bf bfVar) {
        bfVar = (c) bfVar;
        super.c(bfVar);
        if (bfVar != null) {
            boolean z;
            if (bfVar.m == null || !(bfVar.m.get() instanceof ak)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                LayoutParams layoutParams = bfVar.a.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                    ((StaggeredGridLayoutManager.LayoutParams) layoutParams).b = true;
                }
            }
        }
    }

    public d(b bVar) {
        this.c = bVar;
    }

    public final int b(int i) {
        if (this.c != null) {
            return this.c.b(i);
        }
        return i;
    }

    public final long c(int i) {
        return this.c.c(i);
    }

    public final int a() {
        if (this.c != null) {
            return this.c.e();
        }
        return 0;
    }

    public final /* synthetic */ bf a(int i) {
        if (this.c != null) {
            return (c) this.c.f(i);
        }
        return null;
    }
}
