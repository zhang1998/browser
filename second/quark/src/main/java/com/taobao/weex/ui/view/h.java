package com.taobao.weex.ui.view;

import android.mini.support.v4.view.ao;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class h extends ao {
    public List<View> a;
    private List<View> b;
    private boolean c;

    public h() {
        this(true);
    }

    public h(boolean z) {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = true;
        this.c = z;
    }

    public final int a() {
        return this.b.size();
    }

    public final int c() {
        return this.a.size();
    }

    public final Object a(ViewGroup viewGroup, int i) {
        Object obj;
        try {
            obj = (View) this.b.get(i);
            try {
                if (i.c()) {
                    WXLogUtils.d("onPageSelected >>>> instantiateItem >>>>> position:" + i + ",position % getRealCount()" + (i % c()));
                }
                if (obj.getParent() == null) {
                    viewGroup.addView(obj);
                } else {
                    ((ViewGroup) obj.getParent()).removeView(obj);
                    viewGroup.addView(obj);
                }
            } catch (Exception e) {
                e = e;
                WXLogUtils.e("[CirclePageAdapter] instantiateItem: ", e);
                return obj;
            }
        } catch (Throwable e2) {
            Throwable e3;
            Throwable th = e2;
            obj = null;
            e3 = th;
            WXLogUtils.e("[CirclePageAdapter] instantiateItem: ", e3);
            return obj;
        }
        return obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (i.c()) {
            WXLogUtils.d("onPageSelected >>>> destroyItem >>>>> position:" + i);
        }
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final int a(Object obj) {
        return -2;
    }

    public final void d() {
        Object arrayList = new ArrayList();
        if (!this.c || this.a.size() <= 2) {
            arrayList.addAll(this.a);
        } else {
            arrayList.add(0, this.a.get(this.a.size() - 1));
            for (View add : this.a) {
                arrayList.add(add);
            }
            arrayList.add(this.a.get(0));
        }
        this.b.clear();
        b();
        this.b.addAll(arrayList);
        b();
    }

    public final int a(int i) {
        if (i < 0 || i >= this.b.size()) {
            return -1;
        }
        Object obj = this.b.get(i);
        if (obj instanceof View) {
            return this.a.indexOf(obj);
        }
        return -1;
    }

    public final int e() {
        if (!this.c || this.a.size() <= 2) {
            return 0;
        }
        return 1;
    }
}
