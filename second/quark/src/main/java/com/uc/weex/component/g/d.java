package com.uc.weex.component.g;

import android.content.Context;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public final class d extends WXScrollView {
    private int d = 0;

    public d(Context context) {
        super(context);
    }

    public final void setOverScrollDistance(float f) {
        this.d = (int) WXViewUtils.d(f);
    }

    protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!z && ((i4 < 0 && i < 0) || (i4 > getHeight() && i > 0))) {
            i2 = 0;
        }
        return super.overScrollBy(i, (i2 + 1) / 2, i3, i4, i5, i6, i7, this.d, z);
    }
}
