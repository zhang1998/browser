package com.alibaba.analytics.a;

import java.util.Random;

/* compiled from: ProGuard */
public final class v {
    private static final Random a = new Random();

    private static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = a.nextInt();
        int nextInt2 = a.nextInt();
        Object a = l.a(currentTimeMillis);
        Object a2 = l.a(nanoTime);
        Object a3 = l.a(nextInt);
        Object a4 = l.a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return s.b(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r5) {
        /*
        r1 = 0;
        if (r5 == 0) goto L_0x003e;
    L_0x0003:
        r0 = "UTCommon";
        r2 = 0;
        r0 = r5.getSharedPreferences(r0, r2);	 Catch:{ Exception -> 0x002e }
        r2 = "_ie";
        r3 = "";
        r2 = r0.getString(r2, r3);	 Catch:{ Exception -> 0x002e }
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x002e }
        if (r0 != 0) goto L_0x002f;
    L_0x0018:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x002e }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x002e }
        r2 = com.alibaba.analytics.a.s.a(r2);	 Catch:{ Exception -> 0x002e }
        r3 = "UTF-8";
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x002e }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002e }
        if (r2 != 0) goto L_0x002f;
    L_0x002d:
        return r0;
    L_0x002e:
        r0 = move-exception;
    L_0x002f:
        r0 = "phone";
        r0 = r5.getSystemService(r0);	 Catch:{ Exception -> 0x006f }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x0073;
    L_0x0039:
        r0 = r0.getDeviceId();	 Catch:{ Exception -> 0x006f }
    L_0x003d:
        r1 = r0;
    L_0x003e:
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0071;
    L_0x0044:
        r0 = a();
    L_0x0048:
        if (r5 == 0) goto L_0x002d;
    L_0x004a:
        r1 = "UTCommon";
        r2 = 0;
        r1 = r5.getSharedPreferences(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r1 = r1.edit();	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r2 = "_ie";
        r3 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r4 = "UTF-8";
        r4 = r0.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r4 = com.alibaba.analytics.a.s.c(r4);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r1.putString(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r1.commit();	 Catch:{ UnsupportedEncodingException -> 0x006d }
        goto L_0x002d;
    L_0x006d:
        r1 = move-exception;
        goto L_0x002d;
    L_0x006f:
        r0 = move-exception;
        goto L_0x003e;
    L_0x0071:
        r0 = r1;
        goto L_0x0048;
    L_0x0073:
        r0 = r1;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.a.v.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r5) {
        /*
        r1 = 0;
        if (r5 == 0) goto L_0x003e;
    L_0x0003:
        r0 = "UTCommon";
        r2 = 0;
        r0 = r5.getSharedPreferences(r0, r2);	 Catch:{ Exception -> 0x002e }
        r2 = "_is";
        r3 = "";
        r2 = r0.getString(r2, r3);	 Catch:{ Exception -> 0x002e }
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x002e }
        if (r0 != 0) goto L_0x002f;
    L_0x0018:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x002e }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x002e }
        r2 = com.alibaba.analytics.a.s.a(r2);	 Catch:{ Exception -> 0x002e }
        r3 = "UTF-8";
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x002e }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002e }
        if (r2 != 0) goto L_0x002f;
    L_0x002d:
        return r0;
    L_0x002e:
        r0 = move-exception;
    L_0x002f:
        r0 = "phone";
        r0 = r5.getSystemService(r0);	 Catch:{ Exception -> 0x006f }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x0073;
    L_0x0039:
        r0 = r0.getSubscriberId();	 Catch:{ Exception -> 0x006f }
    L_0x003d:
        r1 = r0;
    L_0x003e:
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0071;
    L_0x0044:
        r0 = a();
    L_0x0048:
        if (r5 == 0) goto L_0x002d;
    L_0x004a:
        r1 = "UTCommon";
        r2 = 0;
        r1 = r5.getSharedPreferences(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r1 = r1.edit();	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r2 = "_is";
        r3 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r4 = "UTF-8";
        r4 = r0.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r4 = com.alibaba.analytics.a.s.c(r4);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r1.putString(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x006d }
        r1.commit();	 Catch:{ UnsupportedEncodingException -> 0x006d }
        goto L_0x002d;
    L_0x006d:
        r1 = move-exception;
        goto L_0x002d;
    L_0x006f:
        r0 = move-exception;
        goto L_0x003e;
    L_0x0071:
        r0 = r1;
        goto L_0x0048;
    L_0x0073:
        r0 = r1;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.a.v.b(android.content.Context):java.lang.String");
    }
}
