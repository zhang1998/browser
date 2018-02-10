package com.taobao.android.binding.core;

import android.mini.support.annotation.Nullable;
import android.view.View;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.p;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class ec extends p {
    private i a;

    @JSMethod(uiThread = false)
    public void prepare(Map<String, Object> map) {
        if (this.a == null) {
            this.a = new i();
        }
    }

    @JSMethod(uiThread = false)
    public Map<String, String> bind(Map<String, Object> map, c cVar) {
        if (this.a == null) {
            this.a = new i();
        }
        String a = this.a.a(map, cVar, this.b);
        Map<String, String> hashMap = new HashMap(2);
        hashMap.put(INoCaptchaComponent.token, a);
        return hashMap;
    }

    @JSMethod(uiThread = false)
    public void unbind(Map<String, Object> map) {
        if (this.a != null) {
            i iVar = this.a;
            if (map != null) {
                iVar.a(dz.a(map, INoCaptchaComponent.token), dz.a(map, "eventType"));
            }
        }
    }

    @JSMethod(uiThread = false)
    public void unbindAll() {
        if (this.a != null) {
            this.a.a();
        }
    }

    @JSMethod(uiThread = false)
    public List<String> supportFeatures() {
        return Arrays.asList(new String[]{"pan", "orientation", "timing", "scroll"});
    }

    @JSMethod(uiThread = false)
    public Map<String, Float> getComputedStyle(@Nullable String str) {
        View a = ed.a(this.b.e, str);
        Map hashMap = new HashMap();
        if (a != null) {
            hashMap.put(Style.WX_TRANSLATE_X, Float.valueOf(WXViewUtils.c(a.getTranslationX(), this.b.o)));
            hashMap.put(Style.WX_TRANSLATE_Y, Float.valueOf(WXViewUtils.c(a.getTranslationY(), this.b.o)));
            hashMap.put("rotateX", Float.valueOf(a.getRotationX()));
            hashMap.put("rotateY", Float.valueOf(a.getRotationY()));
            hashMap.put("rotateZ", Float.valueOf(a.getRotation()));
            hashMap.put(Style.WX_SCALE_X, Float.valueOf(a.getScaleX()));
            hashMap.put(Style.WX_SCALE_Y, Float.valueOf(a.getScaleY()));
            hashMap.put("opacity", Float.valueOf(a.getAlpha()));
        }
        return hashMap;
    }

    public final void a() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public final void c() {
        if (this.a != null) {
            this.a.c();
        }
    }
}
