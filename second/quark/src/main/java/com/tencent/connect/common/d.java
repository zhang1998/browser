package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.a.b.p;
import com.tencent.tauth.a;
import com.tencent.tauth.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class d {
    private static d a = null;
    private Map<String, c> b = Collections.synchronizedMap(new HashMap());

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private d() {
        if (this.b == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    public final Object a(b bVar) {
        String a = com.tencent.a.b.d.a(11101);
        if (a == null) {
            return null;
        }
        synchronized (this.b) {
            c cVar = (c) this.b.put(a, new c(this, bVar));
        }
        if (cVar == null) {
            return null;
        }
        return cVar.b;
    }

    private b a(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.b) {
            c cVar = (c) this.b.get(str);
            this.b.remove(str);
        }
        if (cVar == null) {
            return null;
        }
        return cVar.b;
    }

    public final boolean a(int i, int i2, Intent intent, b bVar) {
        b bVar2;
        new StringBuilder("onActivityResult req=").append(i).append(" res=").append(i2);
        String a = com.tencent.a.b.d.a(i);
        if (a == null) {
            bVar2 = null;
        } else {
            bVar2 = a(a);
        }
        if (bVar2 != null) {
            bVar = bVar2;
        } else if (bVar == null) {
            return false;
        }
        if (i2 != -1) {
            bVar.a();
        } else if (intent == null) {
            bVar.a(new a(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            a = intent.getStringExtra("key_action");
            String stringExtra;
            if ("action_login".equals(a)) {
                int intExtra = intent.getIntExtra("key_error_code", 0);
                if (intExtra == 0) {
                    stringExtra = intent.getStringExtra("key_response");
                    if (stringExtra != null) {
                        try {
                            bVar.a(p.c(stringExtra));
                        } catch (JSONException e) {
                            bVar.a(new a(-4, "服务器返回数据格式有误!", stringExtra));
                        }
                    } else {
                        bVar.a(new JSONObject());
                    }
                } else {
                    bVar.a(new a(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                }
            } else if ("action_share".equals(a)) {
                stringExtra = intent.getStringExtra("result");
                a = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra)) {
                    bVar.a();
                } else if ("error".equals(stringExtra)) {
                    bVar.a(new a(-6, "unknown error", new StringBuilder(String.valueOf(a)).toString()));
                } else if ("complete".equals(stringExtra)) {
                    try {
                        if (a == null) {
                            stringExtra = "{\"ret\": 0}";
                        } else {
                            stringExtra = a;
                        }
                        bVar.a(new JSONObject(stringExtra));
                    } catch (JSONException e2) {
                        bVar.a(new a(-4, "json error", new StringBuilder(String.valueOf(a)).toString()));
                    }
                }
            } else {
                int intExtra2 = intent.getIntExtra("key_error_code", 0);
                if (intExtra2 == 0) {
                    stringExtra = intent.getStringExtra("key_response");
                    if (stringExtra != null) {
                        try {
                            bVar.a(p.c(stringExtra));
                        } catch (JSONException e3) {
                            bVar.a(new a(-4, "服务器返回数据格式有误!", stringExtra));
                        }
                    } else {
                        bVar.a(new JSONObject());
                    }
                } else {
                    bVar.a(new a(intExtra2, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                }
            }
        }
        return true;
    }
}
