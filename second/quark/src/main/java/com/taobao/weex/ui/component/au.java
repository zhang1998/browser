package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class au extends ab<CircleProgressBar> {
    public au(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 94842723:
                if (str.equals("color")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                String a = ah.a(obj, null);
                if (a != null) {
                    setColor(a);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "color")
    public void setColor(String str) {
        if (str != null && !str.equals("")) {
            int a = af.a(str, -65536);
            ((CircleProgressBar) getHostView()).setColorSchemeColors(a);
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return new CircleProgressBar(context);
    }
}
