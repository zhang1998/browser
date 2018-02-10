package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

/* compiled from: ProGuard */
public final class bg extends as {
    private Context d = null;
    private String e = null;
    private String f = null;

    public bg(Context context) {
        super("uuid");
        this.d = context;
        this.e = null;
        this.f = null;
    }

    public final String b() {
        try {
            if (!(TextUtils.isEmpty(a("ro.yunos.version", "")) || this.d == null)) {
                SharedPreferences sharedPreferences = this.d.getSharedPreferences("umeng_general_config", 0);
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString("yosuid", "");
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                    this.f = c();
                    if (!(TextUtils.isEmpty(this.f) || this.d == null || sharedPreferences == null)) {
                        Editor edit = sharedPreferences.edit();
                        if (edit != null) {
                            edit.putString("yosuid", this.f).commit();
                        }
                    }
                    return this.f;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c() {
        /*
        r8 = this;
        r2 = 0;
        r0 = "ro.yunos.openuuid";
        r1 = "";
        r0 = a(r0, r1);
        r8.f = r0;
        r0 = r8.f;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0016;
    L_0x0013:
        r0 = r8.f;
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = "ro.aliyun.clouduuid";
        r1 = "";
        r0 = a(r0, r1);
        r8.e = r0;
        r0 = r8.e;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0032;
    L_0x0028:
        r0 = "ro.sys.aliyun.clouduuid";
        r1 = "";
        r0 = a(r0, r1);
        r8.e = r0;
    L_0x0032:
        r0 = r8.e;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x00e4;
    L_0x003a:
        r3 = 0;
        r5 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x00f0, all -> 0x0108 }
        r1 = "https://cmnsguider.yunos.com:443/genDeviceToken";
        r0.<init>(r1);	 Catch:{ Exception -> 0x00f0, all -> 0x0108 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x00f0, all -> 0x0108 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x00f0, all -> 0x0108 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = 1;
        r0.setDoInput(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = "Content-Type";
        r4 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r1, r4);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = new com.a.a.a.be;	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r0.setHostnameVerifier(r1);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4 = "appKey=";
        r1.<init>(r4);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4 = "23338940";
        r6 = "UTF-8";
        r4 = java.net.URLEncoder.encode(r4, r6);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4 = "&uuid=";
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4 = "FC1FE84794417B1BEF276234F6FB4E63";
        r6 = "UTF-8";
        r4 = java.net.URLEncoder.encode(r4, r6);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r6 = r0.getOutputStream();	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4.<init>(r6);	 Catch:{ Exception -> 0x014b, all -> 0x0133 }
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x014f, all -> 0x013a }
        r4.flush();	 Catch:{ Exception -> 0x014f, all -> 0x013a }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x014f, all -> 0x013a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r3) goto L_0x015c;
    L_0x00b3:
        r3 = r0.getInputStream();	 Catch:{ Exception -> 0x0153, all -> 0x013a }
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0157, all -> 0x0140 }
        r5 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0157, all -> 0x0140 }
        r5.<init>(r3);	 Catch:{ Exception -> 0x0157, all -> 0x0140 }
        r1.<init>(r5);	 Catch:{ Exception -> 0x0157, all -> 0x0140 }
        r2 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00d0, all -> 0x0145 }
        r2.<init>();	 Catch:{ Exception -> 0x00d0, all -> 0x0145 }
    L_0x00c6:
        r5 = r1.readLine();	 Catch:{ Exception -> 0x00d0, all -> 0x0145 }
        if (r5 == 0) goto L_0x00e8;
    L_0x00cc:
        r2.append(r5);	 Catch:{ Exception -> 0x00d0, all -> 0x0145 }
        goto L_0x00c6;
    L_0x00d0:
        r2 = move-exception;
        r2 = r3;
    L_0x00d2:
        r4.close();	 Catch:{ Exception -> 0x0121 }
    L_0x00d5:
        if (r1 == 0) goto L_0x00da;
    L_0x00d7:
        r1.close();	 Catch:{ Exception -> 0x0123 }
    L_0x00da:
        if (r2 == 0) goto L_0x00df;
    L_0x00dc:
        r2.close();	 Catch:{ Exception -> 0x0125 }
    L_0x00df:
        if (r0 == 0) goto L_0x00e4;
    L_0x00e1:
        r0.disconnect();
    L_0x00e4:
        r0 = r8.f;
        goto L_0x0015;
    L_0x00e8:
        r2 = r2.toString();	 Catch:{ Exception -> 0x00d0, all -> 0x0145 }
        r8.f = r2;	 Catch:{ Exception -> 0x00d0, all -> 0x0145 }
        r2 = r3;
        goto L_0x00d2;
    L_0x00f0:
        r0 = move-exception;
        r0 = r2;
        r1 = r2;
    L_0x00f3:
        if (r0 == 0) goto L_0x00f8;
    L_0x00f5:
        r0.close();	 Catch:{ Exception -> 0x0127 }
    L_0x00f8:
        if (r2 == 0) goto L_0x00fd;
    L_0x00fa:
        r5.close();	 Catch:{ Exception -> 0x0129 }
    L_0x00fd:
        if (r2 == 0) goto L_0x0102;
    L_0x00ff:
        r3.close();	 Catch:{ Exception -> 0x012b }
    L_0x0102:
        if (r1 == 0) goto L_0x00e4;
    L_0x0104:
        r1.disconnect();
        goto L_0x00e4;
    L_0x0108:
        r0 = move-exception;
        r4 = r2;
        r3 = r2;
        r1 = r2;
    L_0x010c:
        if (r4 == 0) goto L_0x0111;
    L_0x010e:
        r4.close();	 Catch:{ Exception -> 0x012d }
    L_0x0111:
        if (r2 == 0) goto L_0x0116;
    L_0x0113:
        r2.close();	 Catch:{ Exception -> 0x012f }
    L_0x0116:
        if (r3 == 0) goto L_0x011b;
    L_0x0118:
        r3.close();	 Catch:{ Exception -> 0x0131 }
    L_0x011b:
        if (r1 == 0) goto L_0x0120;
    L_0x011d:
        r1.disconnect();
    L_0x0120:
        throw r0;
    L_0x0121:
        r3 = move-exception;
        goto L_0x00d5;
    L_0x0123:
        r1 = move-exception;
        goto L_0x00da;
    L_0x0125:
        r1 = move-exception;
        goto L_0x00df;
    L_0x0127:
        r0 = move-exception;
        goto L_0x00f8;
    L_0x0129:
        r0 = move-exception;
        goto L_0x00fd;
    L_0x012b:
        r0 = move-exception;
        goto L_0x0102;
    L_0x012d:
        r4 = move-exception;
        goto L_0x0111;
    L_0x012f:
        r2 = move-exception;
        goto L_0x0116;
    L_0x0131:
        r2 = move-exception;
        goto L_0x011b;
    L_0x0133:
        r1 = move-exception;
        r4 = r2;
        r3 = r2;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x010c;
    L_0x013a:
        r1 = move-exception;
        r3 = r2;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x010c;
    L_0x0140:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x010c;
    L_0x0145:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x010c;
    L_0x014b:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x00f3;
    L_0x014f:
        r1 = move-exception;
        r1 = r0;
        r0 = r4;
        goto L_0x00f3;
    L_0x0153:
        r1 = move-exception;
        r1 = r2;
        goto L_0x00d2;
    L_0x0157:
        r1 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x00d2;
    L_0x015c:
        r1 = r2;
        goto L_0x00d2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.bg.c():java.lang.String");
    }

    private static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Exception e) {
            return str2;
        }
    }
}
