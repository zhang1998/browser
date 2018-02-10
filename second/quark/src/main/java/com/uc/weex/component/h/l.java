package com.uc.weex.component.h;

import android.graphics.Path;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public class l extends b {
    protected float[] n;
    private int o;

    public l(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "points")
    public void setPoints(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != this.o) {
                this.o = hashCode;
                String[] split = str.split("[,|\\s]");
                if (split.length >= 4) {
                    hashCode = split.length % 2 == 0 ? split.length : split.length - 1;
                    this.n = new float[hashCode];
                    for (int i = 0; i < hashCode; i++) {
                        this.n[i] = WXViewUtils.a(v.b(split[i]));
                    }
                }
            }
        }
    }

    protected Path a() {
        try {
            if (this.n != null) {
                Path path = new Path();
                path.moveTo(this.n[0], this.n[1]);
                int i = 2;
                while (i < this.n.length) {
                    int i2 = i + 1;
                    float f = this.n[i];
                    i = i2 + 1;
                    path.lineTo(f, this.n[i2]);
                }
                return path;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
