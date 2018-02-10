package com.uc.weex.component.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.b.m;
import com.taobao.weex.ui.component.b.r;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.component.y;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.a;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.uc.apollo.impl.SettingsConst;
import com.uc.weex.component.c.a.a.e;
import com.uc.weex.component.c.a.c;
import com.uc.weex.component.c.a.t;
import com.uc.weex.component.f.d;
import java.util.Map;

/* compiled from: ProGuard */
public class b extends r {
    float e;
    float f;
    int h = -1;

    protected final /* synthetic */ ViewGroup a(Context context) {
        return b(context);
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        return b(context);
    }

    public b(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public final void a(ab abVar, int i) {
        super.a(abVar, i);
        if ((abVar instanceof m) && abVar.getDomObject().c_().contains("append")) {
            getInstance().b(abVar.getRef(), "append");
        }
    }

    protected final a b(Context context, int i) {
        a aVar = new a(context, this.a, this.b, i, this, !g());
        ((WXRecyclerView) aVar.getInnerView()).setItemAnimator(null);
        return aVar;
    }

    private boolean g() {
        if (this.h == -1) {
            for (bv parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof d) {
                    this.h = 1;
                    return true;
                }
            }
            this.h = 0;
            return false;
        } else if (this.h == 1) {
            return true;
        } else {
            return false;
        }
    }

    @WXComponentProp(name = "hasAnimation")
    public void setHasAnimation(boolean z) {
        WXRecyclerView wXRecyclerView = (WXRecyclerView) ((a) getHostView()).getInnerView();
        if (wXRecyclerView == null) {
            return;
        }
        if (!z) {
            wXRecyclerView.setItemAnimator(null);
        } else if (wXRecyclerView.getItemAnimator() == null) {
            wXRecyclerView.setItemAnimator(new android.mini.support.v7.widget.r());
        }
    }

    protected y measure(int i, int i2) {
        if (!g()) {
            return super.measure(i, i2);
        }
        y yVar = new y();
        yVar.a = i;
        yVar.b = i2;
        return yVar;
    }

    @WXComponentProp(name = "minForRefresh")
    public void setMinForRefresh(int i) {
        this.e = WXViewUtils.d((float) i);
    }

    @WXComponentProp(name = "maxPullDown")
    public void setMaxPullDown(int i) {
        float d = WXViewUtils.d((float) i);
        f fVar = (f) ((a) getHostView()).getInnerView();
        if (fVar != null) {
            fVar.setMaxOverScrollDistance(d);
        }
    }

    @WXComponentProp(name = "minShrink")
    public void setMinShrink(int i) {
        this.f = WXViewUtils.d((float) i);
    }

    private a b(Context context) {
        a aVar = (a) super.a(context);
        f fVar = (f) aVar.getInnerView();
        com.uc.weex.component.b.a();
        if (!g() && getDomObject().i().containsKey("maxPullDown")) {
            boolean z = 1 == a();
            if (1 == a()) {
                fVar.u = new t(new e(fVar));
            } else if (a() == 0) {
                fVar.u = new c(new e(fVar));
            }
            if (fVar.u != null) {
                fVar.u.a(new c(fVar, z, this));
                fVar.u.a(new d(fVar, this));
            }
            fVar.a(new e(fVar, this));
        }
        return aVar;
    }

    public final void a(ab abVar, Map<String, Object> map) {
        super.a(abVar, (Map) map);
        if (map != null) {
            String obj = map.get("offset") == null ? SettingsConst.FALSE : map.get("offset").toString();
            boolean booleanValue = ah.a(map.get("animated"), Boolean.valueOf(true)).booleanValue();
            if (obj != null && !booleanValue) {
                try {
                    float a = WXViewUtils.a(Float.parseFloat(obj), getInstance().o);
                    a aVar = (a) getHostView();
                    if (aVar != null) {
                        ab abVar2;
                        Object obj2 = null;
                        for (abVar2 = abVar; abVar2 != null; abVar2 = abVar2.getParent()) {
                            if (abVar2 instanceof m) {
                                obj2 = (m) abVar2;
                                break;
                            }
                        }
                        if (obj2 != null) {
                            f fVar = (f) aVar.getInnerView();
                            float f = 0.0f;
                            int indexOf = this.g.indexOf(obj2);
                            if (indexOf > 0) {
                                int i = indexOf - 1;
                                indexOf = 0;
                                float f2 = 0.0f;
                                while (indexOf <= i) {
                                    abVar2 = (ab) this.g.get(indexOf);
                                    com.taobao.weex.c.b.r k = abVar2.getDomObject().k();
                                    com.taobao.weex.c.b.r l = abVar2.getDomObject().l();
                                    if (1 == a()) {
                                        f = ((((abVar2.getDomObject().p() + k.a(1)) + k.a(3)) + l.a(1)) + l.a(3)) + f2;
                                    } else {
                                        f = ((((abVar2.getDomObject().o() + k.a(0)) + k.a(2)) + l.a(0)) + l.a(2)) + f2;
                                    }
                                    indexOf++;
                                    f2 = f;
                                }
                                f = f2;
                            }
                            fVar.setOffset(f + a);
                        }
                    }
                } catch (Exception e) {
                    WXLogUtils.e("scrollTo error :" + e.getMessage());
                }
            }
        }
    }
}
