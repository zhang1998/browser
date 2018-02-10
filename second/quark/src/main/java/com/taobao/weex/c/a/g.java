package com.taobao.weex.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* compiled from: ProGuard */
final class g extends AnimatorListenerAdapter {
    final /* synthetic */ ac a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    g(i iVar, ac acVar, String str) {
        this.c = iVar;
        this.a = acVar;
        this.b = str;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a == null) {
            WXLogUtils.e("RenderActionContextImpl-onAnimationEnd WXSDKInstance == null NPE");
            return;
        }
        ad a = ad.a();
        a.b.a(this.a.e, this.b, new HashMap(), false);
    }
}
