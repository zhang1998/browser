package com.taobao.weex;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class RenderContainer extends FrameLayout {
    private WeakReference<ac> a;

    public RenderContainer(Context context) {
        super(context);
    }

    public RenderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RenderContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSDKInstance(ac acVar) {
        this.a = new WeakReference(acVar);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != null) {
            ac acVar = (ac) this.a.get();
            if (acVar != null) {
                acVar.a(i, i2);
            }
        }
    }
}
