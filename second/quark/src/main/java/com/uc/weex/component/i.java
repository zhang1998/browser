package com.uc.weex.component;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
final class i {
    String a;
    float[] b;
    float[] c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    final /* synthetic */ j j;

    i(j jVar, String str, e eVar) {
        this.j = jVar;
        this.a = str;
        this.b = a(eVar.e("in"));
        a(this.b);
        this.c = a(eVar.e("out"));
        String str2 = this.a;
        int i = -1;
        switch (str2.hashCode()) {
            case -1267206133:
                if (str2.equals("opacity")) {
                    i = 3;
                    break;
                }
                break;
            case -925180581:
                if (str2.equals(Style.WX_ROTATE)) {
                    i = 2;
                    break;
                }
                break;
            case 109250890:
                if (str2.equals("scale")) {
                    i = 1;
                    break;
                }
                break;
            case 1052832078:
                if (str2.equals(Style.WX_TRANSLATE)) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                a(this.c);
                this.d = this.c[0];
                this.e = this.c[1];
                return;
            case 1:
                this.f = this.c[0];
                this.g = this.c[1];
                return;
            case 2:
                this.h = this.c[0];
                return;
            case 3:
                this.i = this.c[0];
                return;
            default:
                return;
        }
    }

    private static float[] a(b bVar) {
        int size = bVar.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            float f;
            Object obj = bVar.get(i);
            if (obj == null) {
                f = 0.0f;
            } else {
                f = com.alibaba.fastjson.c.e.g(obj).floatValue();
            }
            fArr[i] = f;
        }
        return fArr;
    }

    private static void a(float[] fArr) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = WXViewUtils.d(fArr[i]);
        }
    }
}
