package com.uc.weex.component;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.animation.AnimationSet;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.common.b;
import com.taobao.weex.common.e;
import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.ae;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.component.p;
import com.taobao.weex.ui.view.l;
import com.taobao.weex.ui.view.refresh.wrapper.a;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.af;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class j extends ae implements b, e {
    ArrayList<i> a = new ArrayList();
    h b;
    String c = "";
    private int d = 0;
    private float e = 0.0f;
    private g f;

    public j(ac acVar, com.taobao.weex.c.ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
        b(aeVar.i().get("transform"));
        Object obj = aeVar.i().get("opacity");
        if (obj != null && (obj instanceof com.alibaba.fastjson.e)) {
            this.a.add(new i(this, "opacity", (com.alibaba.fastjson.e) obj));
        }
        a(aeVar.i().get(Style.BACKGROUND_COLOR));
        this.c = (String) aeVar.i().get("bindingScroller");
        acVar.a((e) this);
    }

    @WXComponentProp(name = "bindingScroller")
    public void setBindingRef(String str) {
        this.c = str;
        b();
    }

    private void b() {
        ab a = ad.a().c.a(getInstanceId(), this.c);
        if (a == null) {
            this.f = null;
        } else if (a instanceof com.uc.weex.component.c.b) {
            this.f = (g) ((a) ((com.uc.weex.component.c.b) a).getHostView()).getInnerView();
        } else if (a.getHostView() instanceof g) {
            this.f = (g) a.getHostView();
        }
    }

    private void a(Object obj) {
        int i = 0;
        if (obj != null && (obj instanceof com.alibaba.fastjson.e)) {
            this.b = new h();
            com.alibaba.fastjson.e eVar = (com.alibaba.fastjson.e) obj;
            com.alibaba.fastjson.b e = eVar.e("in");
            this.b.a = new int[e.size()];
            for (int i2 = 0; i2 < e.size(); i2++) {
                this.b.a[i2] = e.b(i2).intValue();
            }
            com.alibaba.fastjson.b e2 = eVar.e("out");
            this.b.b = new int[e2.size()];
            while (i < e2.size()) {
                this.b.b[i] = af.a(e2.c(i));
                i++;
            }
        }
    }

    private void b(Object obj) {
        if (obj == null) {
            WXLogUtils.w("WXParallax initAnimation propStr ==null");
        } else if (obj instanceof com.alibaba.fastjson.b) {
            com.alibaba.fastjson.b bVar = (com.alibaba.fastjson.b) obj;
            for (int i = 0; i < bVar.size(); i++) {
                com.alibaba.fastjson.e a = bVar.a(i);
                this.a.add(i, new i(this, a.h("type"), a));
            }
        }
    }

    public final boolean a(String str) {
        this.c = (String) getDomObject().i().get("bindingScroller");
        if (TextUtils.isEmpty(this.c)) {
            ab abVar = getInstance().g;
            if (abVar != null && (abVar instanceof bv)) {
                p firstScroller = abVar.getFirstScroller();
                if (firstScroller != null) {
                    this.c = firstScroller.getRef();
                }
            }
        }
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(str) || !str.equals(this.c)) {
            return false;
        }
        return true;
    }

    public final void a(float f, float f2) {
        int i;
        this.e += f2;
        AnimationSet animationSet = new AnimationSet(true);
        for (i = 0; i < this.a.size(); i++) {
            i iVar = (i) this.a.get(i);
            if (iVar.j.getHostView() != null) {
                float d = iVar.j.d();
                if (d > iVar.b[1]) {
                    d = iVar.b[1];
                }
                if (d < iVar.b[0]) {
                    d = iVar.b[0];
                }
                if (i.c()) {
                    WXLogUtils.d("WXParallax", "type:" + iVar.a + " XDelta:" + f + " YDelta:" + f2);
                }
                String str = iVar.a;
                int i2 = -1;
                switch (str.hashCode()) {
                    case -1267206133:
                        if (str.equals("opacity")) {
                            i2 = 3;
                            break;
                        }
                        break;
                    case -925180581:
                        if (str.equals(Style.WX_ROTATE)) {
                            i2 = 2;
                            break;
                        }
                        break;
                    case 109250890:
                        if (str.equals("scale")) {
                            boolean z = true;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (str.equals(Style.WX_TRANSLATE)) {
                            i2 = 0;
                            break;
                        }
                        break;
                }
                float f3;
                float f4;
                switch (i2) {
                    case 0:
                        f3 = iVar.c[0] + (((iVar.c[2] - iVar.c[0]) * (d - iVar.b[0])) / (iVar.b[1] - iVar.b[0]));
                        f4 = iVar.c[1] + (((d - iVar.b[0]) * (iVar.c[3] - iVar.c[1])) / (iVar.b[1] - iVar.b[0]));
                        if (iVar.d != f3 || iVar.e != f4) {
                            ((l) iVar.j.getHostView()).setTranslationX(f3);
                            ((l) iVar.j.getHostView()).setTranslationY(f4);
                            iVar.d = f3;
                            iVar.e = f4;
                            if (i.c()) {
                                WXLogUtils.d("WXParallax", "XDelta:" + f + " YDelta:" + f2);
                                WXLogUtils.d("WXParallax", " fromTranslateX:" + iVar.d + " toTranslateX:" + f3 + " fromTranslateY:" + iVar.e + " toTranslateY:" + f4);
                            }
                            if (!iVar.j.getDomObject().i().containsKey("aa")) {
                                break;
                            }
                            WXLogUtils.d("CaiTest", " fromTranslateX:" + iVar.d + " toTranslateX:" + f3 + " fromTranslateY:" + iVar.e + " toTranslateY:" + f4);
                            break;
                        }
                        break;
                    case 1:
                        f3 = iVar.c[0] + (((iVar.c[2] - iVar.c[0]) * (d - iVar.b[0])) / (iVar.b[1] - iVar.b[0]));
                        f4 = iVar.c[1] + (((d - iVar.b[0]) * (iVar.c[3] - iVar.c[1])) / (iVar.b[1] - iVar.b[0]));
                        if (iVar.f != f3 || iVar.g != f4) {
                            ((l) iVar.j.getHostView()).setScaleX(f3);
                            ((l) iVar.j.getHostView()).setScaleY(f4);
                            if (i.c()) {
                                WXLogUtils.d("WXParallax", " fromScaleX:" + iVar.f + " toScaleX:" + f3 + " fromScaleY:" + iVar.g + " toScaleY:" + f4);
                            }
                            iVar.f = f3;
                            iVar.g = f4;
                            break;
                        }
                        break;
                    case 2:
                        f3 = iVar.c[0] + (((d - iVar.b[0]) * (iVar.c[1] - iVar.c[0])) / (iVar.b[1] - iVar.b[0]));
                        if (iVar.h == f3) {
                            break;
                        }
                        ((l) iVar.j.getHostView()).setPivotX(iVar.c[2]);
                        ((l) iVar.j.getHostView()).setPivotY(iVar.c[3]);
                        ((l) iVar.j.getHostView()).setRotation(f3);
                        iVar.h = f3;
                        break;
                    case 3:
                        f3 = iVar.c[0] + (((d - iVar.b[0]) * (iVar.c[1] - iVar.c[0])) / (iVar.b[1] - iVar.b[0]));
                        if (iVar.i == f3) {
                            break;
                        }
                        ((l) iVar.j.getHostView()).setAlpha(f3);
                        if (i.c()) {
                            WXLogUtils.d("WXParallax", "opacity fromOpacity:" + iVar.i + " toOpacity:" + f3);
                        }
                        if (iVar.j.getDomObject().i().containsKey("aa")) {
                            WXLogUtils.d("CaiTest", "opacity fromOpacity:" + iVar.i + " toOpacity:" + f3);
                        }
                        iVar.i = f3;
                        break;
                    default:
                        break;
                }
            }
        }
        if (this.b != null) {
            int i3;
            h hVar = this.b;
            if (i.c()) {
                WXLogUtils.d("WXParallax:getColor: XDelta" + f + " YDelta:" + f2 + " mOffsetY" + hVar.c.d());
            }
            if (hVar.c.d() > ((float) hVar.a[1])) {
                i3 = hVar.b[1];
            } else if (hVar.c.d() < ((float) hVar.a[0])) {
                i3 = hVar.b[0];
            } else {
                i3 = Color.red(hVar.b[0]) + ((((int) (hVar.c.d() - ((float) hVar.a[0]))) * (Color.red(hVar.b[1]) - Color.red(hVar.b[0]))) / (hVar.a[1] - hVar.a[0]));
                i = Color.green(hVar.b[0]) + ((((int) (hVar.c.d() - ((float) hVar.a[0]))) * (Color.green(hVar.b[1]) - Color.green(hVar.b[0]))) / (hVar.a[1] - hVar.a[0]));
                int d2 = ((((int) (hVar.c.d() - ((float) hVar.a[0]))) * (Color.blue(hVar.b[1]) - Color.blue(hVar.b[0]))) / (hVar.a[1] - hVar.a[0])) + Color.blue(hVar.b[0]);
                if (i.c()) {
                    WXLogUtils.d("WXParallax:getColor: r1" + i3 + " g1:" + i + " b1:" + d2);
                }
                i3 = Color.rgb(i3, i, d2);
            }
            if (this.d != i3) {
                ((l) getHostView()).setBackgroundColor(i3);
                this.d = i3;
            }
        }
    }

    private float d() {
        if (this.f == null) {
            b();
        }
        if (this.f != null) {
            return this.f.getScrollOffsetY();
        }
        return this.e;
    }
}
