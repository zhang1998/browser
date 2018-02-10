package com.uc.weex.component.g;

import android.content.Context;
import com.taobao.weex.ui.view.WXHorizontalScrollView;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public final class b extends WXHorizontalScrollView {
    private int a = 0;

    public b(Context context) {
        super(context);
        setOverScrollMode(0);
    }

    public final void setOverScrollDistance(float f) {
        this.a = (int) WXViewUtils.d(f);
    }

    protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!z && ((i3 < 0 && i2 < 0) || (i3 > getWidth() && i2 > 0))) {
            i = 0;
        }
        return super.overScrollBy((i + 1) / 2, i2, i3, i4, i5, i6, this.a, i8, z);
    }
}
