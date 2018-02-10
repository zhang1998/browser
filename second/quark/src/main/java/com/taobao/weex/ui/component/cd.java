package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.d;
import com.taobao.weex.ui.view.x;
import com.taobao.weex.utils.ah;
import java.util.HashMap;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class cd extends ab {
    protected d a;

    @Deprecated
    public cd(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public cd(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
        this.a = new x(getContext());
    }

    protected View initComponentHostView(@NonNull Context context) {
        this.a.a(new cb(this));
        this.a.a(new cc(this));
        return this.a.a();
    }

    public void destroy() {
        super.destroy();
        this.a.b();
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case 114148:
                if (str.equals("src")) {
                    z = true;
                    break;
                }
                break;
            case 537088620:
                if (str.equals("show-loading")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                Boolean a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setShowLoading(a.booleanValue());
                return true;
            case true:
                String a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setUrl(a2);
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "src")
    public void setUrl(String str) {
        if (!TextUtils.isEmpty(str) && getHostView() != null && !TextUtils.isEmpty(str)) {
            this.a.a(getInstance().a(Uri.parse(str)).toString());
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("goBack")) {
                this.a.d();
            } else if (str.equals("goForward")) {
                this.a.e();
            } else if (str.equals("reload")) {
                this.a.c();
            }
        }
    }

    @WXComponentProp(name = "show-loading")
    public void setShowLoading(boolean z) {
        this.a.a(z);
    }

    static /* synthetic */ void a(cd cdVar, String str, Object obj) {
        if (cdVar.getDomObject().c_().contains("error")) {
            Map hashMap = new HashMap();
            hashMap.put("type", str);
            hashMap.put("errorMsg", obj);
            cdVar.fireEvent("error", hashMap);
        }
    }
}
