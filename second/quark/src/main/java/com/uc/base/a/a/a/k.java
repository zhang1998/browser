package com.uc.base.a.a.a;

import android.text.TextUtils;
import com.uc.base.a.a.a.b.b;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ProGuard */
public final class k {
    public static void a(String str) {
        new Thread(new f(str)).start();
    }

    public static String a(String str, String str2, String str3) {
        b bVar = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lt=account-sdk");
        stringBuilder.append("&");
        stringBuilder.append("uuid=&dn=&pg=");
        stringBuilder.append("&");
        stringBuilder.append("appid=27f65b2d60f7");
        stringBuilder.append("&");
        stringBuilder.append("client_id=" + bVar.a());
        stringBuilder.append("&");
        stringBuilder.append("device_id=" + bVar.i());
        stringBuilder.append("&");
        stringBuilder.append("lang=" + bVar.o());
        stringBuilder.append("&");
        stringBuilder.append("sdk_v=1.0.0");
        stringBuilder.append("&");
        stringBuilder.append("requst_id=");
        stringBuilder.append("&");
        stringBuilder.append("sn=");
        stringBuilder.append("&");
        stringBuilder.append("imsi=");
        stringBuilder.append("&");
        stringBuilder.append("imei=");
        stringBuilder.append("&");
        stringBuilder.append("mac=");
        stringBuilder.append("&");
        stringBuilder.append("idfa=");
        stringBuilder.append("&");
        stringBuilder.append("machine=");
        stringBuilder.append("&");
        stringBuilder.append("os=android");
        stringBuilder.append("&");
        stringBuilder.append("utdid=" + bVar.i());
        stringBuilder.append("&");
        stringBuilder.append("uid=");
        stringBuilder.append("&");
        stringBuilder.append("response_code=20000");
        stringBuilder.append("&");
        stringBuilder.append("t=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        stringBuilder.append("&");
        stringBuilder.append("action=" + str);
        stringBuilder.append("&");
        stringBuilder.append("e_c=" + str);
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append("&");
            stringBuilder.append("supplement_1=" + str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append("&");
            stringBuilder.append("supplement_2=" + str3);
        }
        return stringBuilder.toString();
    }
}
