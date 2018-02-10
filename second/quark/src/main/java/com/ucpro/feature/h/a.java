package com.ucpro.feature.h;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.ucpro.a.a.b;
import com.ucpro.a.at;
import com.ucpro.a.g;
import com.ucpro.c.d;
import java.net.URLEncoder;

/* compiled from: ProGuard */
public final class a implements b {
    private String a;
    private String b;
    private String c;
    private String d;

    private a() {
    }

    private String e() {
        if (TextUtils.isEmpty(this.a)) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            String str = VERSION.RELEASE;
            if (str == null || str.length() <= 0) {
                stringBuffer.append("5.0");
            } else if (Character.isDigit(str.charAt(0))) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append("5.0");
            }
            stringBuffer.append("; ");
            str = d.c();
            if (com.ucweb.common.util.n.a.a(str)) {
                str = "zh-CN";
            }
            stringBuffer.append(str).append("; ");
            str = Build.MODEL;
            if (str != null && str.length() > 0) {
                stringBuffer.append(str);
            }
            str = Build.ID;
            if (str != null && str.length() > 0) {
                stringBuffer.append(" Build/").append(URLEncoder.encode(str));
            }
            stringBuffer2.append("Quark/");
            stringBuffer2.append("2.4.1.985");
            this.a = String.format(g.h() ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 %s Mobile Safari/537.36" : "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.89 %s Mobile Safari/537.36", new Object[]{stringBuffer, stringBuffer2});
            new StringBuilder("getMobileUADefaultString: ").append(this.a);
        }
        return this.a;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.d)) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer.append("5.0");
            stringBuffer.append("; ");
            String c = d.c();
            if (com.ucweb.common.util.n.a.a(c)) {
                c = "zh-CN";
            }
            stringBuffer.append(c);
            stringBuffer.append("; HTC 802t");
            stringBuffer.append(" Build/KTU84L");
            stringBuffer2.append("Quark/");
            stringBuffer2.append("2.4.1.985");
            this.d = String.format(g.h() ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 %s Mobile Safari/537.36" : "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.89 %s Mobile Safari/537.36", new Object[]{stringBuffer, stringBuffer2});
            new StringBuilder("getBusinessUserAgent: ").append(this.d);
        }
        return this.d;
    }

    public final String a() {
        return "dv(HTC 802t);pr(UCBrowser/10.2.0.535);ov(Android 5.0.2);ss(360*640);pi(1080*1920);bt(UC);pm(1);bv(1);nm(0);im(0);sr(0);nt(2);";
    }

    public final String a(int i) {
        switch (i) {
            case 1:
                return e();
            case 2:
                if (TextUtils.isEmpty(this.b)) {
                    StringBuffer stringBuffer = new StringBuffer(g.h() ? "Mozilla/5.0 (Windows; U; Windows NT 5.2;. en-US) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.108 Safari/537.36 Quark/" : "Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36 Quark/");
                    stringBuffer.append("2.4.1.985");
                    this.b = stringBuffer.toString();
                    new StringBuilder("getMobileUAChromeString: ").append(this.b);
                }
                return this.b;
            case 3:
                if (TextUtils.isEmpty(this.c)) {
                    StringBuffer stringBuffer2 = new StringBuffer("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_2 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8H7 Safari/6533.18.5 Quark/");
                    stringBuffer2.append("2.4.1.985");
                    this.c = stringBuffer2.toString();
                    new StringBuilder("getMobileUAIphone: ").append(this.c);
                }
                return this.c;
            default:
                return e();
        }
    }

    public final String b() {
        return a(at.a());
    }

    private static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            CharSequence charSequence = "2.4.1.985";
            CharSequence c = d.c();
            if (com.ucweb.common.util.n.a.a((String) c)) {
                c = "zh-CN";
            }
            return str.replace("$version_uc_platform$", charSequence).replace("$os_version$", "Android " + VERSION.RELEASE).replace("$lang$", c).replace("$devicename$", Build.MODEL + " Build/" + Build.ID);
        } catch (Exception e) {
            return str;
        }
    }

    public static int d() {
        return com.ucpro.model.a.a.a.a("setting_select_ua_type", 1);
    }
}
