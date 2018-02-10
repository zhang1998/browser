package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.text.Layout;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.t;
import java.lang.ref.WeakReference;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class bt extends ab<t> {
    @Deprecated
    public bt(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public bt(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    public void updateExtra(Object obj) {
        if ((obj instanceof Layout) && getHostView() != null && !obj.equals(((t) getHostView()).getTextLayout())) {
            ((t) getHostView()).setTextLayout((Layout) obj);
            ((t) getHostView()).invalidate();
        }
    }

    protected void setAriaLabel(String str) {
        t tVar = (t) getHostView();
        if (tVar != null) {
            tVar.setAriaLabel(str);
        }
    }

    public void refreshData(ab abVar) {
        super.refreshData(abVar);
        if (abVar instanceof bt) {
            updateExtra(abVar.getDomObject().q());
        }
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1550943582:
                if (str.equals("fontStyle")) {
                    z = true;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals("fontFamily")) {
                    z = true;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    z = true;
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    z = true;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    z = true;
                    break;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    z = true;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    z = true;
                    break;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    z = false;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    z = true;
                    break;
                }
                break;
            case 261414991:
                if (str.equals("textOverflow")) {
                    z = true;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    protected Object convertEmptyProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 94842723:
                if (str.equals("color")) {
                    obj2 = 1;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                return Integer.valueOf(32);
            case 1:
                return "black";
            default:
                return super.convertEmptyProperty(str, obj);
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        View tVar = new t(context);
        tVar.a = new WeakReference(this);
        return tVar;
    }
}
