package com.ucpro.feature.c.c;

import android.text.TextUtils;
import android.util.Base64;
import com.ucpro.b.b.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ProGuard */
public final class a {
    public static final String a = ("quark/img/" + new SimpleDateFormat("yyyy_MM_dd", Locale.CHINA).format(new Date()));
    public static final String b = ("http://image.uc.cn/s/uae/g/2v/" + a + "/");
    public static final String c = ("http://pfdev.uodoo.com/s/uae/g/2v/" + a + "/");

    public static String a(String str) {
        long j = 1466424000;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= 1466424000) {
            j = currentTimeMillis;
        }
        j += 63072000;
        String valueOf = String.valueOf(j);
        return "http://write.image.uc.cn:8080/e/uaeext/NnY2R3YWJqdGFtc2h6eWdqMjJ2ZHu?expires=" + j + "&op=tkclient&tkclient=PUT&name=" + str + "&dir=" + a + "&expired=600&md5=" + Base64.encodeToString(b.b("gyunuae1qwXeQWEQ" + valueOf + str + "tkclient" + "600" + a), 0).replace("+", "-").replace("/", "_").replace("=", "").replace("\n", "");
    }
}
