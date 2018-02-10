package com.taobao.weex.common;

import com.taobao.weex.i;
import java.util.Map;

/* compiled from: ProGuard */
public final class m {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Map<String, String> f;
    private String g = i.d;
    private String h = i.c;

    public m(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = null;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WeexSDKVersion:").append(this.g).append(" JSFrameworkVersion:").append(this.h).append(" instanceId:").append(this.a).append(" bundleUrl:").append(this.b).append(" errCode:").append(this.c).append(" function:").append(this.d).append(" exception:").append(this.e).append(" extParams:").append(this.f);
        return stringBuffer.toString();
    }
}
