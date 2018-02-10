package com.uc.base.a.a.a.d;

import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class b {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;

    public final int a() {
        if (!TextUtils.isEmpty(this.c)) {
            try {
                return new JSONObject(this.c).getInt(INoCaptchaComponent.status);
            } catch (Exception e) {
            }
        }
        return -1;
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.c)) {
            try {
                return new JSONObject(this.c).getJSONObject("data").optString("tips");
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(this.e)) {
            return "";
        }
        return this.e;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.c)) {
            try {
                return new JSONObject(this.c).getJSONObject("data").optString("result");
            } catch (Exception e) {
            }
        }
        return "";
    }
}
