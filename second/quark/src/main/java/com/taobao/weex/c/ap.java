package com.taobao.weex.c;

import android.view.View.MeasureSpec;
import com.taobao.weex.c.b.j;
import com.taobao.weex.c.b.k;
import com.taobao.weex.c.b.q;
import com.taobao.weex.ui.view.s;
import com.taobao.weex.utils.WXLogUtils;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class ap implements j {
    ap() {
    }

    public final void a(k kVar, float f, q qVar) {
        try {
            int makeMeasureSpec;
            s sVar = new s(((ae) kVar).p.a());
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            if (Float.isNaN(f)) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) f, SectionHeader.SHT_LOUSER);
            }
            sVar.measure(makeMeasureSpec, makeMeasureSpec2);
            qVar.a = (float) sVar.getMeasuredWidth();
            qVar.b = (float) sVar.getMeasuredHeight();
        } catch (Throwable e) {
            WXLogUtils.e(ae.m, WXLogUtils.getStackTrace(e));
        }
    }
}
