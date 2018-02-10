package com.taobao.weex.ui.component;

import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.l;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class s extends ae {
    protected /* synthetic */ void onHostViewInitialized(View view) {
        super.onHostViewInitialized((l) view);
        addClickListener(new r(this));
    }

    @Deprecated
    public s(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public s(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 3211051:
                if (str.equals("href")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }
}
