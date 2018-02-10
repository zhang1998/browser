package com.ucpro.base.weex.component;

import android.content.Context;
import android.widget.FrameLayout;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;

/* compiled from: ProGuard */
final class c extends FrameLayout {
    final /* synthetic */ WXQuarkVideo a;

    c(WXQuarkVideo wXQuarkVideo, Context context) {
        this.a = wXQuarkVideo;
        super(context);
    }

    protected final void onDetachedFromWindow() {
        if (this.a.mVideoViewWrapper != null) {
            g.a().b(e.bv, new Object[]{this.a.mVideoViewWrapper});
        }
        super.onDetachedFromWindow();
    }
}
