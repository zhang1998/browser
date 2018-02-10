package com.uc.weex.component.richtext;

import android.text.Layout.Alignment;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;

/* compiled from: ProGuard */
class k {
    private Alignment a;

    k(String str) {
        Alignment alignment;
        if (Style.CENTER.equalsIgnoreCase(str)) {
            alignment = Alignment.ALIGN_CENTER;
        } else if (Style.RIGHT.equalsIgnoreCase(str)) {
            alignment = Alignment.ALIGN_OPPOSITE;
        } else {
            alignment = Alignment.ALIGN_NORMAL;
        }
        this.a = alignment;
    }
}
