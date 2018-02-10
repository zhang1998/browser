package com.loc;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.uc.apollo.impl.SettingsConst;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class db {
    private StringBuilder a = new StringBuilder();

    public final AmapLoc a(String str) {
        AmapLoc amapLoc = new AmapLoc();
        amapLoc.a(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!(jSONObject.has(INoCaptchaComponent.status) && jSONObject.has("info"))) {
                this.a.append("json is error " + str);
            }
            String string = jSONObject.getString(INoCaptchaComponent.status);
            String string2 = jSONObject.getString("info");
            if (string.equals(SettingsConst.TRUE)) {
                this.a.append("json is error " + str);
            }
            if (string.equals(SettingsConst.FALSE)) {
                this.a.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            this.a.append("json exception error:" + th.getMessage());
            cq.a(th, "parser", "paseAuthFailurJson");
        }
        amapLoc.a(this.a.toString());
        return amapLoc;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AmapLoc a(byte[] r14) {
        /*
        r13 = this;
        r12 = 0;
        r4 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r11 = 1;
        r1 = 0;
        r0 = new com.autonavi.aps.amapapi.model.AmapLoc;	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r0.<init>();	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        if (r14 != 0) goto L_0x0035;
    L_0x000f:
        r2 = 5;
        r0.a(r2);	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r2 = r13.a;	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r3 = "byte[] is null";
        r2.append(r3);	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r2 = r13.a;	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r0.a(r2);	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r2 = r13.a;	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r3 = 0;
        r4 = r13.a;	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r4 = r4.length();	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r2.delete(r3, r4);	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.clear();
    L_0x0034:
        return r0;
    L_0x0035:
        r8 = java.nio.ByteBuffer.wrap(r14);	 Catch:{ Throwable -> 0x02a5, all -> 0x0298 }
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != 0) goto L_0x0052;
    L_0x003f:
        r1 = r8.getShort();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r0.l = r1;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.clear();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r8 == 0) goto L_0x0034;
    L_0x004e:
        r8.clear();
        goto L_0x0034;
    L_0x0052:
        r1 = r8.getInt();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = (double) r1;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = r2 / r4;
        r0.b = r2;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r8.getInt();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = (double) r1;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = r2 / r4;
        r0.c = r2;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r8.getShort();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = (float) r1;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r0.c(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r0.k = r1;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != r11) goto L_0x01ba;
    L_0x0085:
        r2 = "";
        r3 = "";
        r4 = "";
        r5 = "";
        r6 = "";
        r7 = "";
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r9 = new java.lang.String;	 Catch:{ Throwable -> 0x02cb, all -> 0x02a0 }
        r10 = "UTF-8";
        r9.<init>(r1, r10);	 Catch:{ Throwable -> 0x02cb, all -> 0x02a0 }
        r0.p = r9;	 Catch:{ Throwable -> 0x02cb, all -> 0x02a0 }
    L_0x00a5:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r9 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r9);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x0238, all -> 0x02a0 }
        r10 = "UTF-8";
        r1.<init>(r9, r10);	 Catch:{ Throwable -> 0x0238, all -> 0x02a0 }
        r0.q = r1;	 Catch:{ Throwable -> 0x02c8, all -> 0x02a0 }
        r10 = r1;
    L_0x00ba:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r2 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x023d, all -> 0x02a0 }
        r9 = "UTF-8";
        r1.<init>(r2, r9);	 Catch:{ Throwable -> 0x023d, all -> 0x02a0 }
        r0.r = r1;	 Catch:{ Throwable -> 0x02c5, all -> 0x02a0 }
        r9 = r1;
    L_0x00cf:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r2 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x0242, all -> 0x02a0 }
        r3 = "UTF-8";
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0242, all -> 0x02a0 }
        r0.s = r1;	 Catch:{ Throwable -> 0x02c3, all -> 0x02a0 }
        r4 = r1;
    L_0x00e4:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r2 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x0247, all -> 0x02a0 }
        r3 = "UTF-8";
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0247, all -> 0x02a0 }
        r0.u = r1;	 Catch:{ Throwable -> 0x02c1, all -> 0x02a0 }
        r0.t = r1;	 Catch:{ Throwable -> 0x02c1, all -> 0x02a0 }
        r3 = r1;
    L_0x00fb:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x02be, all -> 0x02a0 }
        r5 = "UTF-8";
        r2.<init>(r1, r5);	 Catch:{ Throwable -> 0x02be, all -> 0x02a0 }
        r0.z = r2;	 Catch:{ Throwable -> 0x02be, all -> 0x02a0 }
    L_0x010f:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r2 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x024c, all -> 0x02a0 }
        r5 = "UTF-8";
        r1.<init>(r2, r5);	 Catch:{ Throwable -> 0x024c, all -> 0x02a0 }
        r0.v = r1;	 Catch:{ Throwable -> 0x02bc, all -> 0x02a0 }
        r2 = r1;
    L_0x0124:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x02b9, all -> 0x02a0 }
        r6 = "UTF-8";
        r5.<init>(r1, r6);	 Catch:{ Throwable -> 0x02b9, all -> 0x02a0 }
        r0.A = r5;	 Catch:{ Throwable -> 0x02b9, all -> 0x02a0 }
    L_0x0138:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r5 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r5);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x02b2, all -> 0x02a0 }
        r6 = "UTF-8";
        r1.<init>(r5, r6);	 Catch:{ Throwable -> 0x02b2, all -> 0x02a0 }
        r0.o = r1;	 Catch:{ Throwable -> 0x02b6, all -> 0x02a0 }
    L_0x014c:
        r5 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r5 = r5 & 255;
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r5);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r6 = new java.lang.String;	 Catch:{ Throwable -> 0x02af, all -> 0x02a0 }
        r7 = "UTF-8";
        r6.<init>(r5, r7);	 Catch:{ Throwable -> 0x02af, all -> 0x02a0 }
        r0.m = r6;	 Catch:{ Throwable -> 0x02af, all -> 0x02a0 }
    L_0x0160:
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r5.<init>();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r6 = "市";
        r6 = r10.contains(r6);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r6 == 0) goto L_0x0251;
    L_0x016d:
        r6 = r10.equals(r9);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r6 == 0) goto L_0x0251;
    L_0x0173:
        r6 = r5.append(r10);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r7 = " ";
        r6.append(r7);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x017c:
        r6 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r6 != 0) goto L_0x018b;
    L_0x0182:
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r6 = " ";
        r4.append(r6);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x018b:
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r4 != 0) goto L_0x019a;
    L_0x0191:
        r3 = r5.append(r3);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r4 = " ";
        r3.append(r4);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x019a:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r3 != 0) goto L_0x01b4;
    L_0x01a0:
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != 0) goto L_0x01ab;
    L_0x01a6:
        r1 = "靠近";
        r5.append(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x01ab:
        r1 = r5.append(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = " ";
        r1.append(r2);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x01b4:
        r1 = r5.toString();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r0.n = r1;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x01ba:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != r11) goto L_0x01d4;
    L_0x01cb:
        r8.getInt();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.getInt();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.getShort();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x01d4:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != r11) goto L_0x0203;
    L_0x01da:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x02ac, all -> 0x02a0 }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x02ac, all -> 0x02a0 }
        r0.w = r2;	 Catch:{ Throwable -> 0x02ac, all -> 0x02a0 }
    L_0x01ee:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get(r1);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x02a9, all -> 0x02a0 }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x02a9, all -> 0x02a0 }
        r0.b(r2);	 Catch:{ Throwable -> 0x02a9, all -> 0x02a0 }
    L_0x0203:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != r11) goto L_0x0212;
    L_0x0209:
        r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.getInt();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x0212:
        r1 = r8.get();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        if (r1 != r11) goto L_0x021e;
    L_0x0218:
        r2 = r8.getLong();	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r0.e = r2;	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
    L_0x021e:
        if (r8 == 0) goto L_0x0223;
    L_0x0220:
        r8.clear();
    L_0x0223:
        r1 = r13.a;
        r1 = r1.length();
        if (r1 <= 0) goto L_0x0034;
    L_0x022b:
        r1 = r13.a;
        r2 = r13.a;
        r2 = r2.length();
        r1.delete(r12, r2);
        goto L_0x0034;
    L_0x0238:
        r1 = move-exception;
        r1 = r2;
    L_0x023a:
        r10 = r1;
        goto L_0x00ba;
    L_0x023d:
        r1 = move-exception;
        r1 = r3;
    L_0x023f:
        r9 = r1;
        goto L_0x00cf;
    L_0x0242:
        r1 = move-exception;
        r1 = r4;
    L_0x0244:
        r4 = r1;
        goto L_0x00e4;
    L_0x0247:
        r1 = move-exception;
        r1 = r5;
    L_0x0249:
        r3 = r1;
        goto L_0x00fb;
    L_0x024c:
        r1 = move-exception;
        r1 = r6;
    L_0x024e:
        r2 = r1;
        goto L_0x0124;
    L_0x0251:
        r6 = r5.append(r10);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r7 = " ";
        r6.append(r7);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r6 = r5.append(r9);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        r7 = " ";
        r6.append(r7);	 Catch:{ Throwable -> 0x0265, all -> 0x02a0 }
        goto L_0x017c;
    L_0x0265:
        r0 = move-exception;
        r1 = r0;
        r2 = r8;
    L_0x0268:
        r0 = new com.autonavi.aps.amapapi.model.AmapLoc;	 Catch:{ all -> 0x02a2 }
        r0.<init>();	 Catch:{ all -> 0x02a2 }
        r3 = 5;
        r0.a(r3);	 Catch:{ all -> 0x02a2 }
        r3 = r13.a;	 Catch:{ all -> 0x02a2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02a2 }
        r5 = "parser data error:";
        r4.<init>(r5);	 Catch:{ all -> 0x02a2 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02a2 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x02a2 }
        r1 = r1.toString();	 Catch:{ all -> 0x02a2 }
        r3.append(r1);	 Catch:{ all -> 0x02a2 }
        r1 = r13.a;	 Catch:{ all -> 0x02a2 }
        r1 = r1.toString();	 Catch:{ all -> 0x02a2 }
        r0.a(r1);	 Catch:{ all -> 0x02a2 }
        if (r2 == 0) goto L_0x0223;
    L_0x0294:
        r2.clear();
        goto L_0x0223;
    L_0x0298:
        r0 = move-exception;
        r8 = r1;
    L_0x029a:
        if (r8 == 0) goto L_0x029f;
    L_0x029c:
        r8.clear();
    L_0x029f:
        throw r0;
    L_0x02a0:
        r0 = move-exception;
        goto L_0x029a;
    L_0x02a2:
        r0 = move-exception;
        r8 = r2;
        goto L_0x029a;
    L_0x02a5:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        goto L_0x0268;
    L_0x02a9:
        r1 = move-exception;
        goto L_0x0203;
    L_0x02ac:
        r1 = move-exception;
        goto L_0x01ee;
    L_0x02af:
        r5 = move-exception;
        goto L_0x0160;
    L_0x02b2:
        r1 = move-exception;
        r1 = r7;
        goto L_0x014c;
    L_0x02b6:
        r5 = move-exception;
        goto L_0x014c;
    L_0x02b9:
        r1 = move-exception;
        goto L_0x0138;
    L_0x02bc:
        r2 = move-exception;
        goto L_0x024e;
    L_0x02be:
        r1 = move-exception;
        goto L_0x010f;
    L_0x02c1:
        r2 = move-exception;
        goto L_0x0249;
    L_0x02c3:
        r2 = move-exception;
        goto L_0x0244;
    L_0x02c5:
        r2 = move-exception;
        goto L_0x023f;
    L_0x02c8:
        r2 = move-exception;
        goto L_0x023a;
    L_0x02cb:
        r1 = move-exception;
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.db.a(byte[]):com.autonavi.aps.amapapi.model.AmapLoc");
    }
}
