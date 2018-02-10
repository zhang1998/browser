package com.uc.weex.h;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class s extends FrameLayout implements OnAttachStateChangeListener, OnGlobalLayoutListener {
    private final o a;
    private final Rect b;
    private int c;
    private int d = 0;

    public s(Context context, o oVar) {
        super(context);
        this.a = oVar;
        this.c = (int) WXViewUtils.d(60.0f);
        this.b = new Rect();
        addOnAttachStateChangeListener(this);
    }

    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void onViewDetachedFromWindow(View view) {
        if (VERSION.SDK_INT >= 16) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public final void onGlobalLayout() {
        getWindowVisibleDisplayFrame(this.b);
        int i = getContext().getResources().getDisplayMetrics().heightPixels - this.b.bottom;
        if (this.d != i && i > this.c) {
            this.d = i;
            Map hashMap = new HashMap();
            hashMap.put("screenY", Float.valueOf(WXViewUtils.e((float) this.b.bottom)));
            hashMap.put("screenX", Float.valueOf(WXViewUtils.e((float) this.b.left)));
            hashMap.put(Style.WIDTH, Float.valueOf(WXViewUtils.e((float) this.b.width())));
            hashMap.put(Style.HEIGHT, Float.valueOf(WXViewUtils.e((float) this.d)));
            this.a.a("keyboardDidShow", hashMap);
        } else if (this.d != 0 && i <= this.c) {
            this.d = 0;
            this.a.b("keyboardDidHide", "{}");
        }
    }
}
