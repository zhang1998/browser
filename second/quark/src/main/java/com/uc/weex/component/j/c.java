package com.uc.weex.component.j;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.view.l;
import com.uc.apollo.android.GuideDialog;
import com.uc.apollo.impl.SettingsConst;
import com.uc.media.interfaces.IProxyHandler;
import com.uc.weex.component.f;
import com.uc.weex.component.i.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class c extends ab<FrameLayout> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;

    public c(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
    }

    @WXComponentProp(name = "pageUrl")
    public void setPageUrl(String str) {
        this.a = str;
    }

    @WXComponentProp(name = "src")
    public void setSrc(String str) {
        this.b = str;
    }

    @WXComponentProp(name = "playStatus")
    public void setPlayStatus(String str) {
        if (!b.a(str)) {
            this.c = str.trim();
            this.f = true;
        }
    }

    @WXComponentProp(name = "title")
    public void setTitle(String str) {
        this.d = str;
    }

    @WXComponentProp(name = "param")
    public void setParam(String str) {
        this.e = str;
    }

    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        if (this.f) {
            Map hashMap = new HashMap();
            if (!b.a(this.e)) {
                for (String split : this.e.split(";")) {
                    String[] split2 = split.split(":");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            if (!b.a(this.a)) {
                hashMap.put(IProxyHandler.KEY_PAGE_URL, this.a);
            }
            if (!b.a(this.b)) {
                hashMap.put(IProxyHandler.KEY_VIDEO_URL, this.b);
            }
            if (!b.a(this.d)) {
                hashMap.put(GuideDialog.TITLE, this.d);
            }
            if (!b.a(this.c)) {
                f a = a();
                if (!(a == null || getHostView() == null)) {
                    if (this.c.startsWith("playContinuous")) {
                        a aVar = new a(this);
                        a.a(new b(this));
                    } else if (this.c.startsWith("play")) {
                        a.a(hashMap, new a(this), new b(this));
                    } else if (this.c.startsWith("simpleplay")) {
                        hashMap.put("autoPlayPreview", SettingsConst.TRUE);
                        a.a(hashMap, new a(this), new b(this));
                    } else if (this.c.startsWith("pause")) {
                        if (((FrameLayout) getHostView()).getChildCount() > 0) {
                            ((FrameLayout) getHostView()).getChildAt(0);
                            a.b();
                        }
                    } else if (this.c.startsWith("stop") && ((FrameLayout) getHostView()).getChildCount() > 0) {
                        ((FrameLayout) getHostView()).getChildAt(0);
                        a.c();
                    }
                }
            }
            this.f = false;
        }
    }

    private f a() {
        return com.uc.weex.component.b.a().a(getInstanceId());
    }

    public void destroy() {
        if (getHostView() != null && ((FrameLayout) getHostView()).getChildCount() > 0) {
            f a = a();
            if (a != null) {
                ((FrameLayout) getHostView()).getChildAt(0);
                ((FrameLayout) getHostView()).removeAllViews();
                a.a();
                com.uc.weex.component.b.a().b(getInstanceId());
            }
        }
        super.destroy();
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return new l(context);
    }
}
