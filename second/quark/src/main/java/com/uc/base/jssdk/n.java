package com.uc.base.jssdk;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class n {
    LinkedList<f> a = new LinkedList();
    m b;

    n(m mVar) {
        this.b = mVar;
    }

    final String a() {
        int size = this.a.size();
        if (size <= 0) {
            return "empty";
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < size) {
            try {
                f fVar = (f) this.a.getFirst();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callbackId", fVar.b);
                jSONObject.put(INoCaptchaComponent.status, fVar.d);
                jSONObject.put("result", URLEncoder.encode(fVar.a(), "UTF-8"));
                jSONArray.put(jSONObject);
                this.a.removeFirst();
                i++;
            } catch (Exception e) {
            }
        }
        return jSONArray.toString();
    }
}
