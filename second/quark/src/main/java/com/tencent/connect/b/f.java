package com.tencent.connect.b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.a.b.n;
import com.tencent.connect.common.a;
import com.tencent.tauth.b;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class f extends a {
    public static String a = "libwbsafeedit";
    private b h;
    private String i;
    private WeakReference<Activity> j;

    public f(h hVar) {
        super(hVar, (byte) 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.app.Activity r13, java.lang.String r14, com.tencent.tauth.b r15) {
        /*
        r12 = this;
        r12.i = r14;
        r0 = new java.lang.ref.WeakReference;
        r0.<init>(r13);
        r12.j = r0;
        r12.h = r15;
        r1 = "com.tencent.open.agent.AgentActivity";
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = com.tencent.a.b.n.a();
        r2 = com.tencent.a.b.p.a(r2);
        if (r2 == 0) goto L_0x0186;
    L_0x001c:
        r2 = "com.tencent.minihd.qq";
        r0.setClassName(r2, r1);
        r2 = com.tencent.a.b.n.a();
        r2 = com.tencent.a.b.d.a(r2, r0);
        if (r2 == 0) goto L_0x0186;
    L_0x002b:
        if (r0 == 0) goto L_0x01b0;
    L_0x002d:
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = "format";
        r3 = "json";
        r1.putString(r2, r3);
        r2 = "status_os";
        r3 = android.os.Build.VERSION.RELEASE;
        r1.putString(r2, r3);
        r2 = "status_machine";
        r3 = android.os.Build.MODEL;
        r1.putString(r2, r3);
        r2 = "status_version";
        r3 = android.os.Build.VERSION.SDK;
        r1.putString(r2, r3);
        r2 = "sdkv";
        r3 = "2.9.4.lite";
        r1.putString(r2, r3);
        r2 = "sdkp";
        r3 = "a";
        r1.putString(r2, r3);
        r2 = r12.c;
        if (r2 == 0) goto L_0x008c;
    L_0x0060:
        r2 = r12.c;
        r2 = r2.a();
        if (r2 == 0) goto L_0x008c;
    L_0x0068:
        r2 = "access_token";
        r3 = r12.c;
        r3 = r3.b;
        r1.putString(r2, r3);
        r2 = "oauth_consumer_key";
        r3 = r12.c;
        r3 = r3.a;
        r1.putString(r2, r3);
        r2 = "openid";
        r3 = r12.c;
        r3 = r3.c;
        r1.putString(r2, r3);
        r2 = "appid_for_getting_config";
        r3 = r12.c;
        r3 = r3.a;
        r1.putString(r2, r3);
    L_0x008c:
        r2 = com.tencent.a.b.n.a();
        r3 = "pfStore";
        r4 = 0;
        r2 = r2.getSharedPreferences(r3, r4);
        r3 = com.tencent.connect.common.a.g;
        if (r3 == 0) goto L_0x0198;
    L_0x009b:
        r2 = "pf";
        r3 = new java.lang.StringBuilder;
        r4 = "desktop_m_qq-";
        r3.<init>(r4);
        r4 = com.tencent.connect.common.a.e;
        r3 = r3.append(r4);
        r4 = "-android-";
        r3 = r3.append(r4);
        r4 = com.tencent.connect.common.a.d;
        r3 = r3.append(r4);
        r4 = "-";
        r3 = r3.append(r4);
        r4 = com.tencent.connect.common.a.f;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.putString(r2, r3);
    L_0x00c9:
        r2 = "scope";
        r3 = r12.i;
        r1.putString(r2, r3);
        r2 = "client_id";
        r3 = r12.c;
        r3 = r3.a;
        r1.putString(r2, r3);
        r2 = g;
        if (r2 == 0) goto L_0x01a7;
    L_0x00dd:
        r2 = "pf";
        r3 = new java.lang.StringBuilder;
        r4 = "desktop_m_qq-";
        r3.<init>(r4);
        r4 = e;
        r3 = r3.append(r4);
        r4 = "-android-";
        r3 = r3.append(r4);
        r4 = d;
        r3 = r3.append(r4);
        r4 = "-";
        r3 = r3.append(r4);
        r4 = f;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.putString(r2, r3);
    L_0x010b:
        r2 = "need_pay";
        r3 = "1";
        r1.putString(r2, r3);
        r2 = "oauth_app_name";
        r3 = com.tencent.a.b.n.a();
        r4 = r3.getApplicationInfo();
        r3 = r3.getPackageManager();
        r3 = r4.loadLabel(r3);
        r3 = r3.toString();
        r1.putString(r2, r3);
        r2 = "key_action";
        r3 = "action_login";
        r0.putExtra(r2, r3);
        r2 = "key_params";
        r0.putExtra(r2, r1);
        r1 = com.tencent.a.b.n.a();
        r1 = com.tencent.a.b.d.a(r1, r0);
        if (r1 == 0) goto L_0x01b0;
    L_0x0141:
        r1 = new com.tencent.connect.b.e;
        r2 = r12.h;
        r1.<init>(r12, r2);
        r12.h = r1;
        r1 = com.tencent.connect.common.d.a();
        r2 = r12.h;
        r1.a(r2);
        r1 = "key_request_code";
        r2 = 11101; // 0x2b5d float:1.5556E-41 double:5.4846E-320;
        r0.putExtra(r1, r2);
        r1 = new android.content.Intent;
        r2 = r13.getApplicationContext();
        r3 = com.tencent.connect.common.AssistActivity.class;
        r1.<init>(r2, r3);
        r2 = "is_login";
        r3 = 1;
        r1.putExtra(r2, r3);
        r2 = "openSDK_LOG.AssistActivity.ExtraIntent";
        r1.putExtra(r2, r0);
        r2 = 11101; // 0x2b5d float:1.5556E-41 double:5.4846E-320;
        r13.startActivityForResult(r1, r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r0.toString();
        r1.append(r0);
        r0 = 1;
    L_0x0182:
        if (r0 == 0) goto L_0x020d;
    L_0x0184:
        r0 = 1;
    L_0x0185:
        return r0;
    L_0x0186:
        r2 = "com.tencent.mobileqq";
        r0.setClassName(r2, r1);
        r1 = com.tencent.a.b.n.a();
        r1 = com.tencent.a.b.d.a(r1, r0);
        if (r1 != 0) goto L_0x002b;
    L_0x0195:
        r0 = 0;
        goto L_0x002b;
    L_0x0198:
        r3 = "pf";
        r4 = "openmobile_android";
        r2 = r2.getString(r3, r4);
        r3 = "pf";
        r1.putString(r3, r2);
        goto L_0x00c9;
    L_0x01a7:
        r2 = "pf";
        r3 = "openmobile_android";
        r1.putString(r2, r3);
        goto L_0x010b;
    L_0x01b0:
        com.tencent.a.a.b.a();
        r4 = "LOGIN_CHECK_SDK";
        r5 = "1000";
        r0 = r12.c;
        r6 = r0.a;
        r7 = "";
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = java.lang.Long.valueOf(r0);
        r8 = "startActionActivity fail";
        r0 = android.os.SystemClock.elapsedRealtime();
        r10 = r2.longValue();
        r0 = r0 - r10;
        r2 = r2.longValue();
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x01e0;
    L_0x01da:
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x021e;
    L_0x01e0:
        r0 = 0;
        r2 = r0;
    L_0x01e3:
        r0 = new java.lang.StringBuffer;
        r1 = "http://c.isdspeed.qq.com/code.cgi?domain=mobile.opensdk.com&cgi=opensdk&type=1&code=0&time=";
        r0.<init>(r1);
        r0 = r0.append(r2);
        r1 = "&rate=1&uin=";
        r0 = r0.append(r1);
        r0 = r0.append(r5);
        r1 = "&data=";
        r0.append(r1);
        r0 = "1";
        r1 = "0";
        r2 = java.lang.String.valueOf(r2);
        r3 = "1";
        com.tencent.a.b.p.a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = 0;
        goto L_0x0182;
    L_0x020d:
        r0 = r12.h;
        r1 = new com.tencent.tauth.a;
        r2 = -6;
        r3 = "打开QQ失败!";
        r4 = 0;
        r1.<init>(r2, r3, r4);
        r0.a(r1);
        r0 = 2;
        goto L_0x0185;
    L_0x021e:
        r2 = r0;
        goto L_0x01e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.b.f.a(android.app.Activity, java.lang.String, com.tencent.tauth.b):int");
    }

    static /* synthetic */ Bundle a(f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", fVar.c.a);
        if (fVar.c.a()) {
            bundle.putString("keystr", fVar.c.b);
            bundle.putString("keytype", "0x80");
        }
        String str = fVar.c.c;
        if (str != null) {
            bundle.putString("hopenid", str);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = n.a().getSharedPreferences("pfStore", 0);
        if (a.g) {
            bundle.putString("pf", "desktop_m_qq-" + a.e + "-android-" + a.d + "-" + a.f);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "2.9.4.lite");
        bundle.putString("sdkp", "a");
        return bundle;
    }
}
