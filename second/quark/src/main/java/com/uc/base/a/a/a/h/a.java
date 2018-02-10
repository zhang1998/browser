package com.uc.base.a.a.a.h;

import android.text.TextUtils;
import com.uc.base.a.a.a.c;
import com.uc.base.a.a.a.e.i;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;

    public static String a() {
        return c.a().b(i.d);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            aVar.a = optJSONObject.optString("nickname");
            aVar.b = optJSONObject.optString("gender");
            optJSONObject = optJSONObject.optJSONObject("avatar");
            aVar.c = optJSONObject.optString("avatar_id");
            String optString = optJSONObject.optString("avatar_uri");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("http")) {
                aVar.d = optString;
            }
            aVar.i = optJSONObject.optInt("avatar_state");
            aVar.g = optJSONObject.optString("avatar_state");
            aVar.h = optJSONObject.optString("unaudited_avatar_uri");
        } catch (JSONException e) {
        }
        return aVar;
    }

    public static a b(String str) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            aVar.a = optJSONObject.optString("nickname");
            String optString = optJSONObject.optString("avatar_uri");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("http")) {
                aVar.d = optString;
            }
        } catch (JSONException e) {
        }
        return aVar;
    }

    public static a c(String str) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            aVar.a = optJSONObject.optString("nickname");
            String optString = optJSONObject.optString("avatar_uri");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("http")) {
                aVar.d = optString;
            }
            aVar.e = optJSONObject.optString("third_party_avatar_uri");
            aVar.f = optJSONObject.optString("third_party_nickname");
        } catch (JSONException e) {
        }
        return aVar;
    }

    public static void a(a aVar) {
        com.uc.base.a.a.a.f.a a = c.a();
        if (!TextUtils.isEmpty(aVar.a)) {
            a.a("nickname", aVar.a);
        }
        if (!TextUtils.isEmpty(aVar.b)) {
            a.a("gender", aVar.b);
        }
        if (!TextUtils.isEmpty(aVar.c)) {
            a.a("avatar_id", aVar.c);
        }
        if (!TextUtils.isEmpty(aVar.d)) {
            a.a("avatar_url", aVar.d);
        }
        a.a("avatar_state", aVar.i);
        if (!TextUtils.isEmpty(aVar.g)) {
            a.a("unaudited_avatar_id", aVar.g);
        }
        if (!TextUtils.isEmpty(aVar.h)) {
            a.a("unaudited_avatar_uri", aVar.h);
        }
        if (!TextUtils.isEmpty(aVar.e)) {
            a.a("thirdPartyAvatar_url", aVar.e);
        }
        if (!TextUtils.isEmpty(aVar.f)) {
            a.a("thirdPartyNickName", aVar.f);
        }
    }
}
