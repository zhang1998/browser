package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.b.r;
import com.taobao.weex.ui.view.o;
import com.taobao.weex.ui.view.refresh.core.l;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;
import com.taobao.weex.utils.ah;
import java.util.HashMap;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class at extends t implements l {
    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    public at(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected final com.taobao.weex.ui.view.l a(@NonNull Context context) {
        return new o(context);
    }

    public final void b() {
        com.taobao.weex.c.o domObject = getDomObject();
        if (domObject != null && domObject.c_().contains("loading")) {
            fireEvent("loading");
        }
    }

    public final void a(float f, int i, float f2) {
        com.taobao.weex.c.o domObject = getDomObject();
        if (domObject != null && domObject.c_().contains("pullingup")) {
            Map hashMap = new HashMap();
            hashMap.put("dy", Float.valueOf(f));
            hashMap.put("pullingDistance", Integer.valueOf(i));
            hashMap.put("viewHeight", Float.valueOf(f2));
            fireEvent("pullingup", hashMap);
        }
    }

    public boolean canRecycled() {
        return false;
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 1671764162:
                if (str.equals("display")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                String a = ah.a(obj, null);
                if (a != null) {
                    setDisplay(a);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "display")
    public void setDisplay(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("hide")) {
            if (((getParent() instanceof r) || (getParent() instanceof be)) && ((BaseBounceView) getParent().getHostView()).getSwipeLayout().c) {
                ((BaseBounceView) getParent().getHostView()).b();
                ((BaseBounceView) getParent().getHostView()).d();
            }
        }
    }
}
