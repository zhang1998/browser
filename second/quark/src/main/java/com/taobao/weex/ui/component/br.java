package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.s;
import com.taobao.weex.utils.ah;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class br extends ab<s> {
    private OnCheckedChangeListener a;

    @Deprecated
    public br(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public br(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public void addEvent(String str) {
        super.addEvent(str);
        if (str != null && str.equals("change") && getHostView() != null) {
            if (this.a == null) {
                this.a = new bq(this);
            }
            ((s) getHostView()).setOnCheckedChangeListener(this.a);
        }
    }

    protected void removeEventFromView(String str) {
        super.removeEventFromView(str);
        if (getHostView() != null && "change".equals(str)) {
            ((s) getHostView()).setOnCheckedChangeListener(null);
        }
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 742313895:
                if (str.equals("checked")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                Boolean a = ah.a(obj, null);
                if (a != null) {
                    setChecked(a.booleanValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "checked")
    public void setChecked(boolean z) {
        ((s) getHostView()).setOnCheckedChangeListener(null);
        ((s) getHostView()).setChecked(z);
        ((s) getHostView()).setOnCheckedChangeListener(this.a);
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return new s(context);
    }
}
