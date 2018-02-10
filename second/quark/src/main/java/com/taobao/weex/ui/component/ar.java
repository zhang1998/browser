package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.t;
import com.taobao.weex.i;
import com.taobao.weex.ui.view.g;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class ar extends ab<g> {
    protected /* synthetic */ void onHostViewInitialized(View view) {
        super.onHostViewInitialized((g) view);
        if (getParent() instanceof bk) {
            ((bk) getParent()).a(this);
        }
    }

    protected /* synthetic */ void setHostLayoutParams(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        g gVar = (g) view;
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.setMargins(i3, i5, i4, i6);
        gVar.setLayoutParams(layoutParams);
    }

    @Deprecated
    public ar(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public ar(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case 1177488820:
                if (str.equals("itemSize")) {
                    z = true;
                    break;
                }
                break;
            case 1873297717:
                if (str.equals("itemSelectedColor")) {
                    z = true;
                    break;
                }
                break;
            case 2127804432:
                if (str.equals("itemColor")) {
                    z = false;
                    break;
                }
                break;
        }
        String a;
        switch (z) {
            case false:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setItemColor(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setItemSelectedColor(a);
                return true;
            case true:
                Integer a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setItemSize(a2.intValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "itemColor")
    public void setItemColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            int a = af.a(str);
            if (a != SectionHeader.SHT_LOUSER) {
                ((g) getHostView()).setPageColor(a);
                ((g) getHostView()).forceLayout();
                ((g) getHostView()).requestLayout();
            }
        }
    }

    @WXComponentProp(name = "itemSelectedColor")
    public void setItemSelectedColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            int a = af.a(str);
            if (a != SectionHeader.SHT_LOUSER) {
                ((g) getHostView()).setFillColor(a);
                ((g) getHostView()).forceLayout();
                ((g) getHostView()).requestLayout();
            }
        }
    }

    @WXComponentProp(name = "itemSize")
    public void setItemSize(int i) {
        if (i >= 0) {
            ((g) getHostView()).setRadius(WXViewUtils.a((float) i, getInstance().o) / 2.0f);
            ((g) getHostView()).forceLayout();
            ((g) getHostView()).requestLayout();
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        View gVar = new g(context);
        if (getParent() instanceof bk) {
            return gVar;
        }
        if (!i.c()) {
            return null;
        }
        throw new t("WXIndicator initView error.");
    }
}
