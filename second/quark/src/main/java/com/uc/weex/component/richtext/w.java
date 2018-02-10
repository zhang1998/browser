package com.uc.weex.component.richtext;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.uc.weex.h.o;

/* compiled from: ProGuard */
public class w extends ab<ac> {
    public w(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
        if (aeVar instanceof aa) {
            ((aa) aeVar).z = this;
        }
    }

    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        if (getHostView() != null) {
            ac acVar = (ac) getHostView();
            Layout layout = (Layout) obj;
            if (acVar.a != layout) {
                acVar.a = layout;
                acVar.invalidate();
            }
        }
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -515807685:
                if (str.equals("lineHeight")) {
                    z = true;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    z = true;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    final o a() {
        return com.uc.weex.o.a.a(getInstance());
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        View acVar = new ac(context);
        acVar.setOnTouchListener(new v());
        return acVar;
    }
}
