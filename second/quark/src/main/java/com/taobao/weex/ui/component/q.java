package com.taobao.weex.ui.component;

import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.k;
import com.taobao.weex.utils.ah;

/* compiled from: ProGuard */
public class q extends l {
    public q(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected final void a(k kVar) {
        int parseInt;
        super.a(kVar);
        String str = (String) getDomObject().g().get("rows");
        try {
            if (!TextUtils.isEmpty(str)) {
                parseInt = Integer.parseInt(str);
                kVar.setLines(parseInt);
                kVar.setMinLines(parseInt);
            }
        } catch (NumberFormatException e) {
        }
        parseInt = 2;
        kVar.setLines(parseInt);
        kVar.setMinLines(parseInt);
    }

    protected final int a() {
        return 48;
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 3506649:
                if (str.equals("rows")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                Integer a = ah.a(obj, null);
                if (a != null) {
                    setRows(a.intValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "rows")
    public void setRows(int i) {
        k kVar = (k) getHostView();
        if (kVar != null && i > 0) {
            kVar.setLines(i);
        }
    }
}
