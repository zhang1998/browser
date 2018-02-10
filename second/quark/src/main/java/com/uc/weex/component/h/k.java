package com.uc.weex.component.h;

import android.graphics.Path;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.bv;

/* compiled from: ProGuard */
public class k extends l {
    public k(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected final Path a() {
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
                path.lineTo(this.n[0], this.n[1]);
                return path;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
