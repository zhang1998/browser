package com.uc.weex.component.richtext;

import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import com.taobao.weex.c.b.c;
import com.taobao.weex.c.b.j;
import com.taobao.weex.c.b.k;
import com.taobao.weex.c.b.q;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class y implements j {
    final /* synthetic */ aa a;

    private y(aa aaVar) {
        this.a = aaVar;
    }

    public final void a(k kVar, float f, q qVar) {
        aa aaVar = (aa) kVar;
        TextPaint b = this.a.b();
        if (aaVar.l == null) {
            qVar.a = 0.0f;
            qVar.b = 0.0f;
            return;
        }
        int i;
        if (c.a(f)) {
            f = kVar.a_.q;
        }
        int i2 = (int) f;
        String str = (String) aaVar.g().get("textAlign");
        Alignment alignment = Alignment.ALIGN_NORMAL;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(Style.CENTER)) {
                alignment = Alignment.ALIGN_CENTER;
            } else if (str.equals(Style.RIGHT)) {
                alignment = Alignment.ALIGN_OPPOSITE;
            }
        }
        this.a.y = new DynamicLayout(aaVar.l, aaVar.l, b, i2, alignment, IPictureView.DEFAULT_MIN_SCALE, 0.0f, true, null, i2);
        Layout b2 = this.a.y;
        if (b2 == null) {
            i = 0;
        } else {
            i = b2.getLineCount();
            if (i <= 0) {
                i = 0;
            } else {
                i -= 3;
                if (i < 0) {
                    i = 0;
                }
                i = b2.getLineBottom(i);
            }
        }
        float f2 = (float) i;
        qVar.a = f;
        qVar.b = f2;
    }
}
