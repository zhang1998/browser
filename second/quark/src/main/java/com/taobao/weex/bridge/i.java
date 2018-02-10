package com.taobao.weex.bridge;

import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.b;
import com.taobao.weex.common.c;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.j;
import com.taobao.weex.utils.u;

/* compiled from: ProGuard */
public final class i implements c {
    String a = "WebBridge";
    b b;

    public i(b bVar) {
        this.b = bVar;
        this.b.initBridge(this);
    }

    public final int initFramework(String str, WXParams wXParams) {
        Object obj = "";
        try {
            obj = u.b("initJSFM.js", com.taobao.weex.i.e());
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(obj)) {
            return 0;
        }
        return this.b.initFramework("\nvar WXEnvironment = " + wXParams.toJsonString() + ";\n" + str);
    }

    public final int execJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        if (wXJSObjectArr == null) {
            return 0;
        }
        CharSequence stringBuilder = new StringBuilder();
        int length = wXJSObjectArr.length;
        for (int i = 0; i < length; i++) {
            WXJSObject wXJSObject = wXJSObjectArr[i];
            if (wXJSObject.type == 2) {
                stringBuilder.append("\"").append(j.a((String) wXJSObject.data)).append("\"");
            } else if (wXJSObject.type == 1) {
                stringBuilder.append((Double) wXJSObject.data);
            } else if (wXJSObject.type == 3) {
                stringBuilder.append((String) wXJSObject.data);
            }
            if (i != length - 1) {
                stringBuilder.append(",");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder(str3);
        stringBuilder2.append("(").append(stringBuilder).append(");");
        return this.b.execJS(str, stringBuilder2.toString());
    }

    public final int execJSService(String str) {
        return this.b.execJSService(str);
    }

    public final void takeHeapSnapshot(String str) {
    }

    public final int callNative(String str, String str2, String str3) {
        int a;
        long currentTimeMillis = System.currentTimeMillis();
        ac b = ad.a().b(str);
        if (b != null) {
            b.a(currentTimeMillis);
        }
        try {
            a = s.a().a(str, str2, str3);
        } catch (Throwable th) {
            if (com.taobao.weex.i.c()) {
                WXLogUtils.e(this.a, "callNative throw exception:" + th.getMessage());
            }
            a = 1;
        }
        if (b != null) {
            b.b(System.currentTimeMillis() - currentTimeMillis);
        }
        if (com.taobao.weex.i.c() && a == -1) {
            WXLogUtils.w("destroyInstance :" + str + " JSF must stop callNative");
        }
        return a;
    }

    public final int callAddElement(String str, String str2, String str3, String str4, String str5) {
        int a;
        long currentTimeMillis = System.currentTimeMillis();
        ac b = ad.a().b(str);
        if (b != null) {
            b.a(currentTimeMillis);
        }
        try {
            a = s.a().a(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            if (com.taobao.weex.i.c()) {
                WXLogUtils.e(this.a, "callNative throw error:" + th.getMessage());
            }
            a = 1;
        }
        if (b != null) {
            b.b(System.currentTimeMillis() - currentTimeMillis);
        }
        if (com.taobao.weex.i.c() && a == -1) {
            WXLogUtils.w("destroyInstance :" + str + " JSF must stop callNative");
        }
        return a;
    }

    public final Object callNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        return new WXJSObject(s.a().b(str, str2, str3, a.c(new String(bArr))));
    }

    public final void callNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        s.a().c(str, str2, str3, a.c(new String(bArr)));
    }

    public final void setTimeoutNative(String str, String str2) {
        s.a().a(str, str2);
    }
}
