package com.taobao.weex.bridge;

import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.common.c;
import com.taobao.weex.common.g;
import com.taobao.weex.common.m;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.v;

/* compiled from: ProGuard */
public class WXBridge implements c {
    public static final String TAG = "WXBridge";

    public native int execJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    public native int execJSService(String str);

    public native int initFramework(String str, WXParams wXParams);

    public native void takeHeapSnapshot(String str);

    public int callNative(String str, byte[] bArr, String str2) {
        return callNative(str, new String(bArr), str2);
    }

    public int callNative(String str, String str2, String str3) {
        int a;
        long currentTimeMillis = System.currentTimeMillis();
        ac b = ad.a().b(str);
        if (b != null) {
            b.a(currentTimeMillis);
        }
        try {
            a = s.a().a(str, str2, str3);
        } catch (Throwable th) {
            if (i.c()) {
                WXLogUtils.e(TAG, "callNative throw exception:" + th.getMessage());
            }
            a = 1;
        }
        if (b != null) {
            b.b(System.currentTimeMillis() - currentTimeMillis);
        }
        if (i.c() && a == -1) {
            WXLogUtils.w("destroyInstance :" + str + " JSF must stop callNative");
        }
        return a;
    }

    public int callAddElement(String str, String str2, byte[] bArr, String str3, String str4) {
        return callAddElement(str, str2, new String(bArr), str3, str4);
    }

    public int callAddElement(String str, String str2, String str3, String str4, String str5) {
        int a;
        long currentTimeMillis = System.currentTimeMillis();
        ac b = ad.a().b(str);
        if (b != null) {
            b.a(currentTimeMillis);
        }
        try {
            a = s.a().a(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            if (i.c()) {
                WXLogUtils.e(TAG, "callNative throw error:" + th.getMessage());
            }
            a = 1;
        }
        if (b != null) {
            b.b(System.currentTimeMillis() - currentTimeMillis);
        }
        if (i.c() && a == -1) {
            WXLogUtils.w("destroyInstance :" + str + " JSF must stop callNative");
        }
        return a;
    }

    public void reportJSException(String str, String str2, String str3) {
        s.a();
        if (i.c()) {
            WXLogUtils.e("reportJSException >>>> instanceId:" + str + ", exception function:" + str2 + ", exception:" + str3);
        }
        if (str != null) {
            ac b = ad.a().b(str);
            if (b != null) {
                String str4 = g.WX_ERR_JS_EXECUTE.z;
                if (!(b.b == null || b.d == null)) {
                    ac.a(new v(b, str2, str3, str4));
                }
                s.a(str, g.WX_ERR_JS_EXECUTE, "function:" + str2 + "#exception:" + str3);
                if (ad.a().j != null) {
                    m mVar = new m(str, b.h, g.WX_ERR_JS_EXECUTE.z, str2, str3);
                    if (i.c()) {
                        WXLogUtils.d(mVar.toString());
                    }
                }
            }
        }
    }

    public Object callNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        return new WXJSObject(s.a().b(str, str2, str3, a.c(new String(bArr))));
    }

    public void callNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        s.a().c(str, str2, str3, a.c(new String(bArr)));
    }

    public void setTimeoutNative(String str, String str2) {
        s.a().a(str, str2);
    }

    public void setJSFrmVersion(String str) {
        if (!TextUtils.isEmpty(str)) {
            i.c = str;
        }
    }
}
