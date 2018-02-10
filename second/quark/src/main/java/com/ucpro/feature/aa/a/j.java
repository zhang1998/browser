package com.ucpro.feature.aa.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.b.b.b;
import com.ucpro.services.f.g;
import java.net.URLEncoder;
import okhttp3.MediaType;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ e d;
    final /* synthetic */ h e;

    j(h hVar, String str, String str2, String str3, e eVar) {
        this.e = hVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = eVar;
    }

    public final void run() {
        h hVar = this.e;
        String str = this.a;
        String str2 = this.b;
        Object obj = this.c;
        e eVar = this.d;
        try {
            String str3;
            if (TextUtils.isEmpty(obj)) {
                str3 = "";
            } else {
                str3 = obj + "  ";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("instance=" + URLEncoder.encode("ucpro", "UTF-8"));
            stringBuffer.append("&code=" + URLEncoder.encode(b.c("ucpro4gssnRETYZ" + str).toLowerCase(), "UTF-8"));
            stringBuffer.append("&content=" + URLEncoder.encode(str3 + str, "UTF-8"));
            stringBuffer.append("&type=" + URLEncoder.encode(Global.APOLLO_SERIES, "UTF-8"));
            stringBuffer.append("&feedback_type=" + URLEncoder.encode(SettingsConst.TRUE, "UTF-8"));
            stringBuffer.append("&other_contact=" + URLEncoder.encode(str2, "UTF-8"));
            stringBuffer.append("&rom=" + URLEncoder.encode(VERSION.RELEASE, "UTF-8"));
            stringBuffer.append("&uc_param=" + URLEncoder.encode(com.ucpro.model.b.a("https://feedback.uc.cn/feedback/api/submit_record&uc_param_str=einivesvuamifxcppfipbintcunwssdsosdi").split("einivesvuamifxcppfipbintcunwssdsosdi&")[1], "UTF-8"));
            g.a().newCall(new Builder().url("https://feedback.uc.cn/feedback/api/submit_record").addHeader("Content-Type", "application/x-www-form-urlencoded").post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), stringBuffer.toString())).build()).enqueue(new g(hVar, eVar));
        } catch (Exception e) {
            if (eVar != null) {
                eVar.e();
            }
        }
    }
}
