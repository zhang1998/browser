package com.uc.weex.c;

import android.text.TextUtils;
import com.taobao.weex.common.g;
import com.uc.weex.h;

/* compiled from: ProGuard */
public enum b {
    JS_BRIDGE("jsBridge"),
    DOM_MODULE("domModule"),
    ENVIRONMENT("environment"),
    JS_FRAMEWORK("jsFramework"),
    JS_BUNDLE("jsBundle"),
    RENDER_ERROR("renderError"),
    WEEX_INITIATIVE("weexInitative"),
    UNKNOW_ERROR("unknowError");
    
    private String i;

    private b(String str) {
        this.i = str;
    }

    static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOW_ERROR;
        }
        if (str.contains("|")) {
            return WEEX_INITIATIVE;
        }
        if (str.equals("wx_create_instance_error") || str.equals("wx_network_error") || str.equals("wx_user_intercept_error")) {
            return RENDER_ERROR;
        }
        if (str.startsWith("-")) {
            if (str.compareTo(g.WX_ERR_JSFUNC_PARAM.z) >= 0 && str.compareTo(g.WX_ERR_JS_EXECUTE.z) <= 0) {
                return JS_BRIDGE;
            }
            if (str.compareTo(g.WX_ERR_LOAD_SO.z) >= 0 && str.compareTo(g.WX_ERR_COPY_FROM_APK.z) <= 0) {
                return ENVIRONMENT;
            }
            if (str.compareTo(g.WX_ERR_DOM_CREATEBODY.z) >= 0 && str.compareTo(g.WX_ERR_DOM_SCROLLTO.z) <= 0) {
                return DOM_MODULE;
            }
            if (str.compareTo(g.WX_ERR_JSDOWNLOAD_START.z) >= 0 && str.compareTo(g.WX_ERR_JSDOWNLOAD_END.z) <= 0) {
                return JS_BUNDLE;
            }
        }
        if (str.startsWith("UC")) {
            if (str.compareTo(h.WEEX_ERR_BUNDLE_FROM_REMOTE_URL_EMPTY.g) >= 0 && str.compareTo(h.WEEX_RRR_BUNDLE_FROM_UNKNOW_EMPTY.g) <= 0) {
                return JS_BUNDLE;
            }
            if (str.equals(h.WEEX_ERR_ENGINE_INIT_FAILED)) {
                return ENVIRONMENT;
            }
        }
        return UNKNOW_ERROR;
    }
}
