package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v7.widget.av;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.b.r;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.q;
import com.taobao.weex.ui.view.refresh.wrapper.a;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
final class bb extends b {
    private static HashMap<String, aw> m = new HashMap();
    private boolean h = false;
    private int i;
    private int j;
    private av k;
    private q l;
    private String n;

    bb(@NonNull ac acVar) {
        super(acVar);
    }

    public final boolean a(@NonNull String str, @NonNull String str2) {
        ab b = ed.b(this.d, str);
        if (b == null) {
            WXLogUtils.e("ExpressionBinding", "[ExpressionScrollHandler]source component not found.");
            return false;
        }
        this.n = str;
        if (b instanceof be) {
            ViewGroup d = ((be) b).d();
            if (d != null && (d instanceof WXScrollView)) {
                this.l = new ba();
                ((WXScrollView) d).a(this.l);
                return true;
            }
        } else if (b instanceof r) {
            r rVar = (r) b;
            a aVar = (a) rVar.getHostView();
            if (aVar != null) {
                WXRecyclerView wXRecyclerView = (WXRecyclerView) aVar.getInnerView();
                boolean z = rVar.a() == 1;
                if (wXRecyclerView != null) {
                    if (m != null && ((aw) m.get(str)) == null) {
                        m.put(str, new aw());
                    }
                    this.k = new ay(this, z);
                    wXRecyclerView.a(this.k);
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(String str) {
    }

    public final void a(@NonNull String str, @Nullable Map<String, Object> map, @Nullable av avVar, @NonNull List<Map<String, Object>> list, @Nullable c cVar) {
        super.a(str, map, avVar, list, cVar);
    }

    public final boolean b(@NonNull String str, @NonNull String str2) {
        a();
        this.h = false;
        a("end", (float) this.i, (float) this.j, 0.0f, 0.0f, 0.0f, 0.0f);
        if (!(m == null || TextUtils.isEmpty(this.n))) {
            aw awVar = (aw) m.get(this.n);
            if (awVar != null) {
                awVar.a = this.i;
                awVar.b = this.j;
            }
        }
        ab b = ed.b(this.d, str);
        if (b == null) {
            WXLogUtils.e("ExpressionBinding", "[ExpressionScrollHandler]source component not found.");
            return false;
        }
        if (b instanceof be) {
            ViewGroup d = ((be) b).d();
            if (!(d == null || !(d instanceof WXScrollView) || this.l == null)) {
                WXScrollView wXScrollView = (WXScrollView) d;
                wXScrollView.c.remove(this.l);
                return true;
            }
        } else if (b instanceof r) {
            a aVar = (a) ((r) b).getHostView();
            if (aVar != null) {
                WXRecyclerView wXRecyclerView = (WXRecyclerView) aVar.getInnerView();
                if (!(wXRecyclerView == null || this.k == null)) {
                    wXRecyclerView.b(this.k);
                    return true;
                }
            }
        }
        return false;
    }

    private void a(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.b != null) {
            Map hashMap = new HashMap();
            hashMap.put("state", str);
            double b = WXViewUtils.b((double) f, this.e);
            double b2 = WXViewUtils.b((double) f2, this.e);
            hashMap.put("x", Double.valueOf(b));
            hashMap.put("y", Double.valueOf(b2));
            double b3 = WXViewUtils.b((double) f3, this.e);
            double b4 = WXViewUtils.b((double) f4, this.e);
            hashMap.put("dx", Double.valueOf(b3));
            hashMap.put("dy", Double.valueOf(b4));
            double b5 = WXViewUtils.b((double) f5, this.e);
            double b6 = WXViewUtils.b((double) f6, this.e);
            hashMap.put("tdx", Double.valueOf(b5));
            hashMap.put("tdy", Double.valueOf(b6));
            this.b.b(hashMap);
            if (i.c()) {
                new StringBuilder(">>>>>>>>>>>fire event:(").append(str).append(",").append(b).append(",").append(b2).append(",").append(b3).append(",").append(b4).append(",").append(b5).append(",").append(b6).append(")");
            }
        }
    }

    public final void b() {
        this.k = null;
        this.l = null;
        this.h = false;
        if (m != null) {
            m.clear();
        }
    }

    protected final void a(@NonNull Map<String, Object> map) {
        a("exit", ((Float) map.get("internal_x")).floatValue(), ((Float) map.get("internal_y")).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void c() {
    }

    public final void d() {
    }

    static /* synthetic */ boolean a(int i, int i2) {
        return (i > 0 && i2 > 0) || (i < 0 && i2 < 0);
    }

    static /* synthetic */ void a(bb bbVar, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i.c()) {
            String.format(Locale.CHINA, "[ExpressionScrollHandler] scroll changed. (contentOffsetX:%d,contentOffsetY:%d,dx:%d,dy:%d,tdx:%d,tdy:%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
        }
        bbVar.i = i;
        bbVar.j = i2;
        if (!bbVar.h) {
            bbVar.h = true;
            bbVar.a("start", (float) i, (float) i2, (float) i3, (float) i4, (float) i5, (float) i6);
        }
        try {
            ci.a(bbVar.c, (double) i, (double) i2, (double) i3, (double) i4, (double) i5, (double) i6, bbVar.e);
            if (!bbVar.a(bbVar.f, bbVar.c)) {
                bbVar.a(bbVar.a, bbVar.c, "scroll");
            }
        } catch (Exception e) {
            WXLogUtils.e("ExpressionBinding", "runtime error\n" + e.getMessage());
        }
    }
}
