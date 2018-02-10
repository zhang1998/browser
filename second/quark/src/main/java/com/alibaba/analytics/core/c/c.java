package com.alibaba.analytics.core.c;

import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.a.r;
import com.alibaba.analytics.b.a;
import com.alibaba.analytics.core.a.f;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.h.j;
import com.alibaba.analytics.core.h.q;
import com.alibaba.analytics.core.h.t;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.f.h;
import com.e.b.d.a.d;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class c implements q {
    private static c a = new c();

    public static c a() {
        return a;
    }

    public final void b(String str, String str2) {
        af.d("SelfChecker", "key", str, "value", str2);
        Runnable fVar = new f(this, str, str2);
        i.a();
        i.a(null, fVar, 5000);
    }

    public static String a(String str) {
        CharSequence charSequence = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("current_time", System.currentTimeMillis());
            jSONObject.put("is_init", b.a().m);
            StringBuilder stringBuilder = new StringBuilder();
            a.a();
            jSONObject.put("sdk_version", stringBuilder.append(a.b()).toString());
            jSONObject.put("appkey", b.a().c);
            jSONObject.put("secret", b.a().d);
            com.e.b.d.a.c cVar = b.a().e;
            if (cVar == null) {
                jSONObject.put("security_mode", "-1");
            } else if (cVar instanceof com.e.b.d.a.a) {
                jSONObject.put("security_mode", SettingsConst.TRUE);
            } else if (cVar instanceof d) {
                jSONObject.put("security_mode", Global.APOLLO_SERIES);
            } else if (cVar instanceof com.e.b.d.a.b) {
                jSONObject.put("security_mode", "3");
            }
            jSONObject.put("run_process", r.b(b.a().b));
            jSONObject.put("ut_realtime_debug_switch", b.a().h());
            jSONObject.put("ap_realtime_debug_switch", b.a().r);
            jSONObject.put("ap_sampling_seed", com.alibaba.appmonitor.a.d.a().b);
            jSONObject.put("upload_interval", f.a().b);
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String optString;
                        String optString2;
                        String optString3;
                        CharSequence optString4;
                        JSONObject optJSONObject = new JSONObject(str).optJSONObject("cp");
                        if (optJSONObject != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("ap");
                            if (optJSONObject2 != null) {
                                optString = optJSONObject2.optString("type");
                                optString2 = optJSONObject2.optString("module");
                                optString3 = optJSONObject2.optString("point");
                            } else {
                                optString3 = null;
                                optString = null;
                                optString2 = null;
                            }
                            JSONObject optJSONObject3 = optJSONObject.optJSONObject("ut");
                            if (optJSONObject3 != null) {
                                optString4 = optJSONObject3.optString("eventId");
                                charSequence = optJSONObject3.optString("arg1");
                            } else {
                                optString4 = null;
                            }
                        } else {
                            optString4 = null;
                            optString3 = null;
                            optString = null;
                            optString2 = null;
                        }
                        if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3))) {
                            jSONObject.put("ap_sampling_result", com.alibaba.appmonitor.a.d.a().a(h.a(optString), optString2, optString3));
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            Map hashMap = new HashMap();
                            hashMap.put(LogField.EVENTID.toString(), optString4);
                            if (!TextUtils.isEmpty(charSequence)) {
                                hashMap.put(LogField.ARG1.toString(), charSequence);
                            }
                            jSONObject.put("ut_sampling_result", t.a().a(hashMap));
                        }
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
            boolean a = com.alibaba.analytics.core.a.h.a();
            jSONObject.put("upload_success", a);
            jSONObject.put("upload_mode", f.a().c);
            boolean c = b.a().c();
            jSONObject.put("tnet_degrade", c);
            if (c) {
                jSONObject.put("tnet_error_code", com.alibaba.analytics.a.d.b);
            }
            if (!a) {
                jSONObject.put("http_error_code", com.alibaba.analytics.core.a.h.c);
            }
            List a2 = b.a().n.a(j.class, null, null, -1);
            if (a2 != null) {
                for (int i = 0; i < a2.size(); i++) {
                    j jVar = (j) a2.get(i);
                    jSONObject.put("entity.getGroupname()" + jVar.a, jVar.b);
                }
            }
        } catch (Throwable th3) {
            try {
                jSONObject.put("resport_error", th3.getLocalizedMessage());
            } catch (JSONException e) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        File externalFilesDir = b.a().b.getExternalFilesDir("logs");
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "analytics.log");
            if (file.exists()) {
                file.delete();
            } else {
                try {
                    if (!externalFilesDir.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(jSONObject2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th4) {
                af.c();
            }
        }
        return jSONObject2;
    }
}
