package com.taobao.weex.utils;

import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.a.i;
import com.taobao.weex.common.s;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class q implements i {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    q(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void a() {
        if (com.taobao.weex.i.c()) {
            WXLogUtils.d("TypefaceUtil", "downloadFontByNetwork begin url:" + this.a);
        }
    }

    public final void a(int i, Map<String, List<String>> map) {
    }

    public final void a(int i) {
    }

    public final void a(s sVar) {
        int parseInt;
        a aVar;
        boolean z = false;
        if (!TextUtils.isEmpty(sVar.a)) {
            try {
                parseInt = Integer.parseInt(sVar.a);
            } catch (NumberFormatException e) {
                WXLogUtils.e("TypefaceUtil", "IWXHttpAdapter onHttpFinish statusCode:" + sVar.a);
            }
            if (parseInt >= 200 && parseInt <= SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR && sVar.b != null) {
                z = u.a(this.b, sVar.b, com.taobao.weex.i.e());
                if (z) {
                    z = r.b(this.b, this.c);
                } else if (com.taobao.weex.i.c()) {
                    WXLogUtils.d("TypefaceUtil", "downloadFontByNetwork() onHttpFinish success, but save file failed.");
                }
            }
            if (!z) {
                aVar = (a) r.a.get(this.c);
                if (aVar != null) {
                    aVar.e = 3;
                }
            }
        }
        parseInt = 0;
        z = u.a(this.b, sVar.b, com.taobao.weex.i.e());
        if (z) {
            z = r.b(this.b, this.c);
        } else if (com.taobao.weex.i.c()) {
            WXLogUtils.d("TypefaceUtil", "downloadFontByNetwork() onHttpFinish success, but save file failed.");
        }
        if (!z) {
            aVar = (a) r.a.get(this.c);
            if (aVar != null) {
                aVar.e = 3;
            }
        }
    }
}
