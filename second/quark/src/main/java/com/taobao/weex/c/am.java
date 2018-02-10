package com.taobao.weex.c;

import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.Map;

/* compiled from: ProGuard */
public class am extends ae {
    private float A = 32.0f;
    private boolean B = false;
    public int l = 1;
    float y = 0.0f;
    private float z = -1.0f;

    public final float b() {
        return WXViewUtils.a(this.A, this.o);
    }

    public final float c() {
        return WXViewUtils.a(this.z, this.o);
    }

    public final void a(ae aeVar, int i) {
        super.a(aeVar, i);
        if ("cell".equals(aeVar.r)) {
            if (!this.B) {
                d();
            }
            if (this.z != 0.0f && this.z != Float.NaN) {
                aeVar.g().a(Style.WIDTH, Float.valueOf(this.z));
            }
        }
    }

    public final void d() {
        float f = 0.0f;
        if (i() != null) {
            this.l = i().f();
            this.z = i().e();
            this.A = i().g();
            this.y = (this.a_.n[0] - this.a_.k.a(0)) - this.a_.k.a(2);
            this.y = WXViewUtils.c(this.y, this.o);
            if (-1 == this.l && -1.0f == this.z) {
                this.l = 1;
            } else if (-1.0f == this.z && -1 != this.l) {
                this.z = (this.y - (((float) (this.l - 1)) * this.A)) / ((float) this.l);
                if (this.z > 0.0f) {
                    f = this.z;
                }
                this.z = f;
            } else if (-1.0f != this.z && -1 == this.l) {
                this.l = Math.round(((this.y + this.A) / (this.z + this.A)) - 0.5f);
                if (this.l > 0) {
                    r0 = this.l;
                } else {
                    r0 = 1;
                }
                this.l = r0;
                this.z = ((this.y + this.A) / ((float) this.l)) - this.A;
            } else if (!(-1.0f == this.z || -1 == this.l)) {
                r0 = Math.round(((this.y + this.A) / (this.z + this.A)) - 0.5f);
                if (r0 > this.l) {
                    r0 = this.l;
                }
                this.l = r0;
                this.z = ((this.y + this.A) / ((float) this.l)) - this.A;
            }
            this.B = true;
            if (i.c()) {
                WXLogUtils.d("preCalculateCellWidth mColumnGap :" + this.A + " mColumnWidth:" + this.z + " mColumnCount:" + this.l);
            }
        }
    }

    public final void a(Map<String, Object> map) {
        super.a((Map) map);
        if (map.containsKey("columnCount") || map.containsKey("columnGap") || map.containsKey("columnWidth")) {
            d();
            if (this.z == 0.0f && this.z == Float.NaN) {
                WXLogUtils.w("preCalculateCellWidth mColumnGap :" + this.A + " mColumnWidth:" + this.z + " mColumnCount:" + this.l);
                return;
            }
            int e = e();
            for (int i = 0; i < e; i++) {
                if ("cell".equals(b(i).r)) {
                    b(i).g().a(Style.WIDTH, Float.valueOf(this.z));
                }
            }
        }
    }
}
