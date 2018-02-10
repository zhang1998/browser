package com.taobao.weex.ui.animation;

import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import android.view.View;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.view.border.b;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public final class a extends Property<View, Integer> {
    public final /* synthetic */ Object get(Object obj) {
        int i;
        View view = (View) obj;
        b b = WXViewUtils.b(view);
        if (b != null) {
            i = b.c;
        } else if (view.getBackground() instanceof ColorDrawable) {
            i = ((ColorDrawable) view.getBackground()).getColor();
        } else {
            i = 0;
            WXLogUtils.e("BackgroundColorAnimation", "Unsupported background type");
        }
        return Integer.valueOf(i);
    }

    public final /* synthetic */ void set(Object obj, Object obj2) {
        View view = (View) obj;
        Integer num = (Integer) obj2;
        b b = WXViewUtils.b(view);
        if (b != null) {
            b.a(num.intValue());
        } else if (view.getBackground() instanceof ColorDrawable) {
            ((ColorDrawable) view.getBackground()).setColor(num.intValue());
        } else {
            WXLogUtils.e("BackgroundColorAnimation", "Unsupported background type");
        }
    }

    public a() {
        super(Integer.class, Style.BACKGROUND_COLOR);
    }
}
