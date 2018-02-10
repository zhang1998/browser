package com.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.uc.crashsdk.export.LogType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class eh {
    private final int a = 128;
    private final int b = LogType.UNEXP;
    private final int c = 10;
    private Context d;
    private ef e = null;
    private eg f = null;
    private JSONObject g = null;
    private ef h;

    public eh(Context context) {
        if (context == null) {
            try {
                fw.d("Context is null, can't track event");
            } catch (Exception e) {
                return;
            }
        }
        this.h = ef.a(context);
        this.d = context;
        this.e = ef.a(this.d);
        this.f = this.e.c();
        if (this.g == null) {
            try {
                Object string = this.d.getSharedPreferences("umeng_general_config", 0).getString("fs_lc_tl", null);
                if (!TextUtils.isEmpty(string)) {
                    this.g = new JSONObject(string);
                }
                a();
            } catch (Exception e2) {
            }
        }
    }

    private void a() {
        int i = 0;
        try {
            if (!TextUtils.isEmpty(this.f.g)) {
                String[] split = this.f.g.split("!");
                JSONObject jSONObject = new JSONObject();
                if (this.g != null) {
                    for (String a : split) {
                        String a2 = fu.a(a2, 128);
                        if (this.g.has(a2)) {
                            jSONObject.put(a2, this.g.get(a2));
                        }
                    }
                }
                this.g = new JSONObject();
                if (split.length >= 10) {
                    while (i < 10) {
                        a(split[i], jSONObject);
                        i++;
                    }
                } else {
                    while (i < split.length) {
                        a(split[i], jSONObject);
                        i++;
                    }
                }
                try {
                    if (this.g != null) {
                        this.d.getSharedPreferences("umeng_general_config", 0).edit().putString("fs_lc_tl", this.g.toString()).commit();
                    }
                } catch (Exception e) {
                }
                this.f.g = null;
            }
        } catch (Exception e2) {
        }
    }

    private void a(String str, JSONObject jSONObject) throws JSONException {
        String a = fu.a(str, 128);
        if (jSONObject.has(a)) {
            a(a, ((Boolean) jSONObject.get(a)).booleanValue());
        } else {
            a(a, false);
        }
    }

    private void a(String str, boolean z) {
        try {
            if (!"$st_fl".equals(str) && !"dplus_st".equals(str) && !"du".equals(str) && !"id".equals(str) && !"ts".equals(str) && !this.g.has(str)) {
                this.g.put(str, z);
            }
        } catch (Exception e) {
        }
    }
}
