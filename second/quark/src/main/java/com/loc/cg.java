package com.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.DPoint;
import com.amap.api.location.a;
import com.autonavi.aps.amapapi.model.AmapLoc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class cg {
    Context a = null;
    boolean b = true;
    dv c = null;
    ServiceConnection d = null;
    ServiceConnection e = null;
    ServiceConnection f = null;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    cf j = null;
    private String k = null;
    private Intent l = new Intent();
    private String m = "com.autonavi.minimap";
    private String n = "com.amap.api.service.AMapService";
    private String o = "com.autonavi.minimap.LBSConnectionService";
    private String p = "invaid type";
    private String q = "empty appkey";
    private String r = "refused";
    private String s = "failed";

    cg(Context context) {
        this.a = context;
        try {
            this.k = ej.a(cp.a(dx.f(context).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            cq.a(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    private AmapLoc a(Bundle bundle) {
        byte[] b;
        JSONObject jSONObject;
        if (bundle.containsKey("key")) {
            try {
                b = cp.b(ej.b(bundle.getString("key")), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
            } catch (Throwable th) {
                cq.a(th, "ConnectionServiceManager", "parseData part");
            }
            if (bundle.containsKey("result")) {
                return null;
            }
            try {
                jSONObject = new JSONObject(new String(cp.a(b, ej.b(bundle.getString("result"))), "utf-8"));
                if (jSONObject.has("error")) {
                    AmapLoc amapLoc;
                    amapLoc = new AmapLoc(jSONObject);
                    amapLoc.a = "lbs";
                    amapLoc.i = 7;
                    if ("WGS84".equals(amapLoc.f) && cq.a(amapLoc.c, amapLoc.b)) {
                        DPoint a = a.a(this.a, amapLoc.b, amapLoc.c);
                        amapLoc.b(a.getLatitude());
                        amapLoc.a(a.getLongitude());
                    }
                    return amapLoc;
                }
                String string;
                string = jSONObject.getString("error");
                if (this.p.equals(string)) {
                    this.b = false;
                }
                if (this.q.equals(string)) {
                    this.b = false;
                }
                if (this.r.equals(string)) {
                    this.b = false;
                }
                this.s.equals(string);
                return null;
            } catch (Throwable th2) {
                cq.a(th2, cg.class.getName(), "parseData");
                return null;
            }
        }
        b = null;
        if (bundle.containsKey("result")) {
            return null;
        }
        jSONObject = new JSONObject(new String(cp.a(b, ej.b(bundle.getString("result"))), "utf-8"));
        if (jSONObject.has("error")) {
            amapLoc = new AmapLoc(jSONObject);
            amapLoc.a = "lbs";
            amapLoc.i = 7;
            DPoint a2 = a.a(this.a, amapLoc.b, amapLoc.c);
            amapLoc.b(a2.getLatitude());
            amapLoc.a(a2.getLongitude());
            return amapLoc;
        }
        string = jSONObject.getString("error");
        if (this.p.equals(string)) {
            this.b = false;
        }
        if (this.q.equals(string)) {
            this.b = false;
        }
        if (this.r.equals(string)) {
            this.b = false;
        }
        this.s.equals(string);
        return null;
    }

    final boolean a() {
        ArrayList m;
        String str;
        if (de.p()) {
            this.l.putExtra("appkey", this.k);
            this.l.setComponent(new ComponentName(this.m, this.n));
            try {
                this.g = this.a.bindService(this.l, this.d, 1);
            } catch (Throwable th) {
            }
            try {
                if (!this.g) {
                    m = de.m();
                    if (m != null) {
                        Iterator it = m.iterator();
                        while (it.hasNext()) {
                            str = (String) it.next();
                            if (!str.equals(this.n)) {
                                this.l.setComponent(new ComponentName(this.m, str));
                                try {
                                    this.g = this.a.bindService(this.l, this.d, 1);
                                } catch (Throwable th2) {
                                }
                                if (this.g) {
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                return false;
            }
        }
        if (de.q()) {
            Intent intent = new Intent();
            intent.putExtra("appkey", this.k);
            intent.setComponent(new ComponentName(this.m, this.o));
            try {
                this.h = this.a.bindService(intent, this.e, 1);
            } catch (Throwable th4) {
            }
            if (!this.h) {
                m = de.n();
                if (m != null) {
                    Iterator it2 = m.iterator();
                    while (it2.hasNext()) {
                        str = (String) it2.next();
                        if (!str.equals(this.o)) {
                            intent.setComponent(new ComponentName(this.m, str));
                            try {
                                this.h = this.a.bindService(intent, this.e, 1);
                            } catch (Throwable th5) {
                            }
                            if (this.g) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        b();
        return this.g && this.h;
    }

    public final void b() {
        try {
            if (de.w()) {
                List<df> x = de.x();
                if (x != null && x.size() > 0) {
                    for (df dfVar : x) {
                        if (dfVar != null) {
                            if (dfVar.a) {
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName(dfVar.b, dfVar.c));
                                if (!TextUtils.isEmpty(dfVar.e)) {
                                    intent.setAction(dfVar.e);
                                }
                                List list = dfVar.d;
                                if (list != null && list.size() > 0) {
                                    for (int i = 0; i < list.size(); i++) {
                                        Iterator it = ((Map) list.get(i)).entrySet().iterator();
                                        if (it.hasNext()) {
                                            Entry entry = (Entry) it.next();
                                            intent.putExtra(((String) entry.getKey()).toString(), ((String) entry.getValue()).toString());
                                        }
                                    }
                                }
                                if (dfVar.f) {
                                    this.a.startService(intent);
                                }
                                boolean bindService = this.a.bindService(intent, this.f, 1);
                                if (bindService) {
                                    this.i = bindService;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            cq.a(th, "ConnectionServiceManager", "bindOtherService");
        }
    }

    final AmapLoc c() {
        AmapLoc amapLoc = null;
        try {
            if (this.b && this.g) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "corse");
                bundle.putString("appkey", this.k);
                if (this.c != null) {
                    this.c.a(bundle);
                    if (bundle.size() > 0) {
                        amapLoc = a(bundle);
                    }
                }
            }
        } catch (Throwable th) {
            cq.a(th, "ConnectionServiceManager", "sendCommand");
        }
        return amapLoc;
    }
}
