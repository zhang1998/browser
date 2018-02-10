package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.ui.view.l;
import java.lang.ref.WeakReference;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class ae extends bv<l> {
    public /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    @Deprecated
    public ae(ac acVar, com.taobao.weex.c.ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public ae(ac acVar, com.taobao.weex.c.ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    public l a(@NonNull Context context) {
        l lVar = new l(context);
        lVar.a = new WeakReference(this);
        return lVar;
    }
}
