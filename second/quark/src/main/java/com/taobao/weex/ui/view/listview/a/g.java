package com.taobao.weex.ui.view.listview.a;

import android.mini.support.v7.widget.GridLayoutManager;
import android.mini.support.v7.widget.LinearLayoutManager;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.StaggeredGridLayoutManager;
import android.mini.support.v7.widget.av;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class g extends av {
    protected int a;
    private int[] b;
    private int[] c;
    private int d;
    private int e;
    private int f = 0;
    private WeakReference<a> g;

    public g(a aVar) {
        this.g = new WeakReference(aVar);
    }

    public final void a(RecyclerView recyclerView, int i) {
        super.a(recyclerView, i);
        this.f = i;
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        int n = layoutManager.n();
        int s = layoutManager.s();
        if (n != 0) {
            if (!(this.g == null || this.g.get() == null)) {
                ((a) this.g.get()).e(i);
            }
            s = (((s - this.d) - 1) * recyclerView.getHeight()) / n;
            if (n > 0 && this.f == 0 && this.g != null && this.g.get() != null) {
                ((a) this.g.get()).d(s);
            }
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (this.g != null) {
            a aVar = (a) this.g.get();
            if (aVar != null) {
                aVar.a(i2);
                if (layoutManager instanceof LinearLayoutManager) {
                    this.a = f.a;
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    this.d = linearLayoutManager.k();
                    aVar.a(linearLayoutManager.j(), this.d, i, i2);
                } else if (layoutManager instanceof GridLayoutManager) {
                    this.a = f.b;
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    this.d = gridLayoutManager.k();
                    aVar.a(gridLayoutManager.j(), this.d, i, i2);
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    this.a = f.c;
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    int i3 = staggeredGridLayoutManager.a;
                    if (this.b == null || i3 != this.b.length) {
                        this.b = new int[i3];
                    }
                    if (this.c == null || i3 != this.c.length) {
                        this.c = new int[i3];
                    }
                    try {
                        staggeredGridLayoutManager.a(this.c);
                        int[] iArr = this.c;
                        int i4 = iArr[0];
                        int length = iArr.length;
                        int i5 = 0;
                        while (i5 < length) {
                            i3 = iArr[i5];
                            if (i3 >= i4) {
                                i3 = i4;
                            }
                            i5++;
                            i4 = i3;
                        }
                        this.e = i4;
                        int[] iArr2 = this.b;
                        if (iArr2 == null) {
                            iArr2 = new int[staggeredGridLayoutManager.a];
                        } else if (iArr2.length < staggeredGridLayoutManager.a) {
                            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + staggeredGridLayoutManager.a + ", array size:" + iArr2.length);
                        }
                        for (i4 = 0; i4 < staggeredGridLayoutManager.a; i4++) {
                            iArr2[i4] = staggeredGridLayoutManager.b[i4].g();
                        }
                        this.d = a(this.b);
                        aVar.a(this.e, this.d, i, i2);
                    } catch (Exception e) {
                        WXLogUtils.e(e.toString());
                    }
                } else {
                    throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
                }
            }
        }
    }

    private static int a(int[] iArr) {
        int i = iArr[0];
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            if (i3 <= i) {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        return i;
    }
}
