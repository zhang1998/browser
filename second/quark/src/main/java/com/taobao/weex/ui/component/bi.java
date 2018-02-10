package com.taobao.weex.ui.component;

import android.mini.support.v4.view.bx;
import com.uc.imagecodec.export.IPictureView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class bi implements bx {
    private float a = 99.0f;
    private int b;
    private bk c;

    public bi(bk bkVar) {
        this.c = bkVar;
        this.b = bkVar.b.e();
    }

    public final void a(int i, float f, int i2) {
        if (this.a == 99.0f) {
            this.a = f;
        } else if (Math.abs(f - this.a) >= this.c.i) {
            Map hashMap;
            if (i == this.b) {
                hashMap = new HashMap(1);
                hashMap.put("offsetXRatio", Float.valueOf(-f));
                this.c.fireEvent("scroll", hashMap);
            } else if (i < this.b) {
                hashMap = new HashMap(1);
                hashMap.put("offsetXRatio", Float.valueOf(IPictureView.DEFAULT_MIN_SCALE - f));
                this.c.fireEvent("scroll", hashMap);
            }
            this.a = f;
        }
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(int i) {
        switch (i) {
            case 0:
                this.a = 99.0f;
                this.c.fireEvent("scrollend");
                return;
            case 1:
                this.c.fireEvent("scrollstart");
                return;
            default:
                return;
        }
    }
}
