package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.UCMobile.Apollo.ApolloMetaData;
import com.a.a.b;
import com.a.a.j;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class eg implements ed, ee {
    static Context f;
    ec a = null;
    dz b = null;
    ea c = null;
    eb d = null;
    ar e = null;
    String g = null;
    private fi h = null;
    private ek i = null;
    private long j = 0;
    private int k = 10;
    private JSONArray l = new JSONArray();
    private final int m = 5000;
    private int n = 0;
    private int o = 0;
    private long p = 0;
    private final long q = 28800000;

    public eg(Context context) {
        f = context;
        this.a = new ec(context);
        this.h = fi.a(context);
        this.e = bb.a(context).c;
        this.i = new ek(this);
        this.c = ea.a(f);
        this.b = dz.a(f);
        this.d = eb.a(f, this.a);
        SharedPreferences sharedPreferences = f.getSharedPreferences("umeng_general_config", 0);
        this.p = sharedPreferences.getLong("thtstart", 0);
        this.n = sharedPreferences.getInt("gkvc", 0);
        this.o = sharedPreferences.getInt("ekvc", 0);
        this.g = this.e.a();
    }

    public final void a() {
        if (ey.i(f)) {
            c();
        } else {
            fw.a("network is unavailable");
        }
    }

    public final void a(Object obj) {
        boolean z;
        int i = 1;
        int i2 = 0;
        if (this.a.a()) {
            ec ecVar = this.a;
            SharedPreferences sharedPreferences = ecVar.f.getSharedPreferences("umeng_general_config", 0);
            ecVar.e = ecVar.f.getSharedPreferences("umeng_general_config", 0).getLong("first_activate_time", 0);
            if (ecVar.e == 0) {
                ecVar.e = System.currentTimeMillis();
                sharedPreferences.edit().putLong("first_activate_time", ecVar.e).commit();
            }
            this.j = ecVar.e;
        }
        if (obj instanceof JSONObject) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    if (2050 == jSONObject.getInt("__t")) {
                        if (a(this.n)) {
                            this.n++;
                        } else {
                            z = false;
                        }
                    } else if (2049 == jSONObject.getInt("__t")) {
                        if (a(this.o)) {
                            this.o++;
                        } else {
                            z = false;
                        }
                    }
                    if (this.l.length() > this.k) {
                        aj.a(f);
                        aj.a(this.l);
                        this.l = new JSONArray();
                    }
                    if (this.p == 0) {
                        this.p = System.currentTimeMillis();
                    }
                    this.l.put(jSONObject);
                    z = false;
                } catch (Throwable th) {
                    z = false;
                }
            } catch (Throwable th2) {
                z = false;
            }
        } else {
            z = true;
        }
        if (!ey.i(f)) {
            fw.d("network is unavailable");
        } else if (this.a.a()) {
            i2 = 1;
        } else {
            ek ekVar = this.i;
            if (ekVar.f.b.a()) {
                fd fdVar;
                if (!((ekVar.a instanceof fm) && ekVar.a.a())) {
                    i = 0;
                }
                if (i != 0) {
                    fdVar = ekVar.a;
                } else {
                    fdVar = new fm(ekVar.f.a, ekVar.f.b);
                }
                ekVar.a = fdVar;
            } else {
                int i3 = ((ekVar.a instanceof fl) && ekVar.a.a()) ? 1 : 0;
                if (i3 == 0) {
                    if (z) {
                        eg egVar;
                        int currentTimeMillis;
                        eb ebVar = ekVar.f.d;
                        if (!(ebVar.a.e() || ebVar.b.a())) {
                            long currentTimeMillis2 = System.currentTimeMillis() - ebVar.b.d;
                            if (currentTimeMillis2 > ebVar.c) {
                                ebVar.e = (long) fg.a(ebVar.d, bd.a(ebVar.g));
                                ebVar.f = currentTimeMillis2;
                                i3 = 1;
                            } else if (currentTimeMillis2 > 129600000) {
                                ebVar.e = 0;
                                ebVar.f = currentTimeMillis2;
                                i3 = 1;
                            }
                            if (i3 != 0) {
                                ekVar.a = new fl((int) ekVar.f.d.e);
                                egVar = ekVar.f;
                                currentTimeMillis = (int) (System.currentTimeMillis() - egVar.a.d);
                                egVar.a(egVar.a((int) ekVar.f.d.e, currentTimeMillis));
                                fj.a(new ev(egVar), (long) r5);
                            }
                        }
                        i3 = 0;
                        if (i3 != 0) {
                            ekVar.a = new fl((int) ekVar.f.d.e);
                            egVar = ekVar.f;
                            currentTimeMillis = (int) (System.currentTimeMillis() - egVar.a.d);
                            egVar.a(egVar.a((int) ekVar.f.d.e, currentTimeMillis));
                            fj.a(new ev(egVar), (long) r5);
                        }
                    }
                    if (fw.a) {
                        if (ekVar.f.e.e == 1) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            ekVar.a = new fe(ekVar.f.a);
                        }
                    }
                    if (ekVar.f.c.a && "RPT".equals(ekVar.f.c.d)) {
                        if (ekVar.f.c.b == 6) {
                            if (ekVar.f.e.c == -1) {
                                i = 0;
                            }
                            if (i != 0) {
                                i2 = ekVar.f.e.a(90000);
                            } else if (ekVar.c > 0) {
                                i2 = ekVar.c;
                            } else {
                                i2 = ekVar.e;
                            }
                        }
                        ekVar.a = ekVar.a(ekVar.f.c.b, i2);
                    } else {
                        i = ekVar.d;
                        i2 = ekVar.e;
                        if (ekVar.b != -1) {
                            i = ekVar.b;
                            i2 = ekVar.c;
                        }
                        ekVar.a = ekVar.a(i, i2);
                    }
                }
            }
            i2 = ekVar.a.a(z);
        }
        if (i2 != 0) {
            c();
        }
    }

    public final void b() {
        a(a(new int[0]));
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                bc a = bc.a(f);
                a.a();
                try {
                    CharSequence encodeToString = Base64.encodeToString(new e().a(a.a), 0);
                    if (!TextUtils.isEmpty(encodeToString)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(ApolloMetaData.KEY_HEADER);
                        jSONObject2.put("id_tracking", encodeToString);
                        jSONObject.put(ApolloMetaData.KEY_HEADER, jSONObject2);
                    }
                } catch (Exception e) {
                }
                byte[] bytes = String.valueOf(jSONObject).getBytes();
                if (bytes != null && !fg.a(f, bytes)) {
                    bd b;
                    if (d()) {
                        b = bd.b(f, b.a(f), bytes);
                    } else {
                        b = bd.a(f, b.a(f), bytes);
                    }
                    bytes = b.a();
                    fi a2 = fi.a(f);
                    a2.d();
                    a2.a(bytes);
                    a.b();
                }
            } catch (Exception e2) {
            }
        }
    }

    private JSONObject a(int... iArr) {
        if (TextUtils.isEmpty(b.a(f))) {
            fw.d("Appkey is missing ,Please check AndroidManifest.xml");
            return new JSONObject();
        }
        JSONObject jSONObject;
        a(f);
        JSONObject a = aj.a(f).a();
        try {
            jSONObject = a.getJSONObject("body");
        } catch (Throwable th) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2;
        try {
            CharSequence string;
            JSONObject jSONObject3;
            SharedPreferences sharedPreferences;
            int[] n;
            CharSequence b;
            String[] g;
            c a2;
            Object obj;
            Editor edit;
            JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
            SharedPreferences sharedPreferences2 = f.getSharedPreferences("umeng_general_config", 0);
            if (sharedPreferences2 != null) {
                string = sharedPreferences2.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            if (this.a.a() && this.j != 0) {
                jSONObject3 = new JSONObject();
                jSONObject3.put("ts", this.j);
                jSONObject.put("activate_msg", jSONObject3);
                jSONObject4.put("activate_msg", jSONObject3);
            }
            jSONObject3 = new JSONObject();
            bx.c = f;
            JSONObject a3 = bv.a.a();
            if (a3 != null && a3.length() > 0) {
                jSONObject3.put("ag", a3);
            }
            bx.c = f;
            a3 = bv.a.b();
            if (a3 != null && a3.length() > 0) {
                jSONObject3.put("ve_meta", a3);
            }
            if (jSONObject3.length() > 0) {
                jSONObject.put("cc", jSONObject3);
                jSONObject4.put("cc", jSONObject3);
            }
            String[] a4 = j.a(f);
            if (!(a4 == null || TextUtils.isEmpty(a4[0]) || TextUtils.isEmpty(a4[1]))) {
                a3 = new JSONObject();
                a3.put("provider", a4[0]);
                a3.put("puid", a4[1]);
                if (a3.length() > 0) {
                    jSONObject.put("active_user", a3);
                    jSONObject4.put("active_user", a3);
                }
            }
            if (ea.a(f).a) {
                Object valueOf;
                a3 = new JSONObject();
                String str = ea.a(f).d;
                ea a5 = ea.a(f);
                if (a5.a) {
                    valueOf = String.valueOf(a5.c);
                } else {
                    valueOf = "error";
                }
                a3.put(str, valueOf);
                jSONObject.put("group_info", a3);
            }
            this.b.a(jSONObject, f);
            if (iArr.length == 2) {
                jSONObject3 = new JSONObject();
                a3 = new JSONObject();
                a3.put("interval", iArr[0] / 1000);
                a3.put("latency", iArr[1]);
                jSONObject3.put("latent", a3);
                jSONObject.put("control_policy", jSONObject3);
            }
            if (jSONObject.length() > 0) {
                a.put("body", jSONObject);
            } else {
                try {
                    a.remove("body");
                } catch (Throwable th2) {
                }
            }
            jSONObject = new JSONObject();
            jSONObject.put("appkey", b.a(f));
            jSONObject.put("channel", b.b(f));
            string = fu.a(b.c(f));
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("secret", string);
            }
            jSONObject.put("display_name", ey.s(f));
            jSONObject.put("package_name", ey.p(f));
            jSONObject.put("app_signature", ey.q(f));
            if (sharedPreferences2 == null) {
                try {
                    sharedPreferences2 = f.getSharedPreferences("umeng_general_config", 0);
                } catch (Throwable th3) {
                    jSONObject.put("app_version", ey.b(f));
                    jSONObject.put("version_code", Integer.parseInt(ey.a(f)));
                    sharedPreferences = sharedPreferences2;
                }
            }
            if (sharedPreferences2 != null) {
                string = sharedPreferences2.getString("vers_name", "");
                if (TextUtils.isEmpty(string)) {
                    jSONObject.put("app_version", ey.b(f));
                    jSONObject.put("version_code", Integer.parseInt(ey.a(f)));
                } else {
                    jSONObject.put("app_version", string);
                    jSONObject.put("version_code", sharedPreferences2.getInt("vers_code", 0));
                    sharedPreferences = sharedPreferences2;
                    if (!(b.a == null || b.b == null)) {
                        jSONObject.put("wrapper_type", b.a);
                        jSONObject.put("wrapper_version", b.b);
                    }
                    jSONObject.put("sdk_type", "Android");
                    jSONObject.put("sdk_version", b.b());
                    jSONObject.put("vertical_type", b.d(f));
                    jSONObject.put("idmd5", ey.d(f));
                    jSONObject.put("cpu", ey.a());
                    jSONObject.put("os", "Android");
                    jSONObject.put("os_version", VERSION.RELEASE);
                    n = ey.n(f);
                    if (n != null) {
                        jSONObject.put("resolution", n[1] + "*" + n[0]);
                    }
                    jSONObject.put("mc", ey.m(f));
                    jSONObject.put("device_id", ey.c(f));
                    jSONObject.put("device_model", Build.MODEL);
                    jSONObject.put("device_board", Build.BOARD);
                    jSONObject.put("device_brand", Build.BRAND);
                    jSONObject.put("device_manutime", Build.TIME);
                    jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                    jSONObject.put("device_manuid", Build.ID);
                    jSONObject.put("device_name", Build.DEVICE);
                    b = ey.b();
                    if (!TextUtils.isEmpty(b)) {
                        jSONObject.put("sub_os_name", b);
                    }
                    b = ey.c();
                    if (!TextUtils.isEmpty(b)) {
                        jSONObject.put("sub_os_version", b);
                    }
                    g = ey.g(f);
                    if ("Wi-Fi".equals(g[0])) {
                        jSONObject.put("access", "wifi");
                    } else if ("2G/3G".equals(g[0])) {
                        jSONObject.put("access", "unknow");
                    } else {
                        jSONObject.put("access", "2G/3G");
                    }
                    if (!"".equals(g[1])) {
                        jSONObject.put("access_subtype", g[1]);
                    }
                    b = ey.e(f);
                    if (TextUtils.isEmpty(b)) {
                        jSONObject.put("mccmnc", b);
                    } else {
                        jSONObject.put("mccmnc", "");
                    }
                    g = ey.k(f);
                    jSONObject.put("country", g[0]);
                    jSONObject.put("language", g[1]);
                    jSONObject.put("timezone", ey.j(f));
                    jSONObject.put("carrier", ey.f(f));
                    jSONObject.put("successful_requests", sharedPreferences.getInt("successful_request", 0));
                    jSONObject.put("failed_requests", sharedPreferences.getInt("failed_requests", 0));
                    jSONObject.put("req_time", sharedPreferences.getInt("last_request_spent_ms", 0));
                    a2 = bb.a(f).a();
                    if (a2 != null) {
                        jSONObject.put("imprint", Base64.encodeToString(new e().a(a2), 0));
                    }
                    a.put(ApolloMetaData.KEY_HEADER, jSONObject);
                    if (jSONObject.has("sdk_version")) {
                        jSONObject4.put("sdk_version", jSONObject.getString("sdk_version"));
                    }
                    if (jSONObject.has("device_id")) {
                        jSONObject4.put("device_id", jSONObject.getString("device_id"));
                    }
                    if (jSONObject.has("device_model")) {
                        jSONObject4.put("device_model", jSONObject.getString("device_model"));
                    }
                    if (jSONObject.has("version")) {
                        jSONObject4.put("version", jSONObject.getInt("version_code"));
                    }
                    if (jSONObject.has("appkey")) {
                        jSONObject4.put("appkey", jSONObject.getString("appkey"));
                    }
                    if (jSONObject.has("channel")) {
                        jSONObject4.put("channel", jSONObject.getString("channel"));
                    }
                    if (!TextUtils.isEmpty("device_id") || TextUtils.isEmpty("mc") || TextUtils.isEmpty("resolution") || TextUtils.isEmpty("appkey") || TextUtils.isEmpty("channel") || TextUtils.isEmpty("app_signature") || TextUtils.isEmpty("package_name") || TextUtils.isEmpty("app_version")) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = a;
                    }
                    if (fw.a && jSONObject4.length() > 0) {
                        fw.a(String.valueOf(jSONObject4));
                    }
                    if (sharedPreferences != null) {
                        return jSONObject2;
                    }
                    edit = sharedPreferences.edit();
                    edit.remove("vers_name");
                    edit.remove("vers_code");
                    edit.remove("vers_date");
                    edit.remove("vers_pre_version");
                    edit.commit();
                    return jSONObject2;
                }
            }
            sharedPreferences = sharedPreferences2;
            jSONObject.put("wrapper_type", b.a);
            jSONObject.put("wrapper_version", b.b);
            jSONObject.put("sdk_type", "Android");
            jSONObject.put("sdk_version", b.b());
            jSONObject.put("vertical_type", b.d(f));
            jSONObject.put("idmd5", ey.d(f));
            jSONObject.put("cpu", ey.a());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", VERSION.RELEASE);
            n = ey.n(f);
            if (n != null) {
                jSONObject.put("resolution", n[1] + "*" + n[0]);
            }
            jSONObject.put("mc", ey.m(f));
            jSONObject.put("device_id", ey.c(f));
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_board", Build.BOARD);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manutime", Build.TIME);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("device_manuid", Build.ID);
            jSONObject.put("device_name", Build.DEVICE);
            b = ey.b();
            if (TextUtils.isEmpty(b)) {
                jSONObject.put("sub_os_name", b);
            }
            b = ey.c();
            if (TextUtils.isEmpty(b)) {
                jSONObject.put("sub_os_version", b);
            }
            g = ey.g(f);
            if ("Wi-Fi".equals(g[0])) {
                jSONObject.put("access", "wifi");
            } else if ("2G/3G".equals(g[0])) {
                jSONObject.put("access", "unknow");
            } else {
                jSONObject.put("access", "2G/3G");
            }
            if ("".equals(g[1])) {
                jSONObject.put("access_subtype", g[1]);
            }
            b = ey.e(f);
            if (TextUtils.isEmpty(b)) {
                jSONObject.put("mccmnc", "");
            } else {
                jSONObject.put("mccmnc", b);
            }
            g = ey.k(f);
            jSONObject.put("country", g[0]);
            jSONObject.put("language", g[1]);
            jSONObject.put("timezone", ey.j(f));
            jSONObject.put("carrier", ey.f(f));
            try {
                jSONObject.put("successful_requests", sharedPreferences.getInt("successful_request", 0));
                jSONObject.put("failed_requests", sharedPreferences.getInt("failed_requests", 0));
                jSONObject.put("req_time", sharedPreferences.getInt("last_request_spent_ms", 0));
            } catch (Exception e) {
            }
            try {
                a2 = bb.a(f).a();
                if (a2 != null) {
                    jSONObject.put("imprint", Base64.encodeToString(new e().a(a2), 0));
                }
            } catch (Exception e2) {
            }
            a.put(ApolloMetaData.KEY_HEADER, jSONObject);
            if (jSONObject.has("sdk_version")) {
                jSONObject4.put("sdk_version", jSONObject.getString("sdk_version"));
            }
            if (jSONObject.has("device_id")) {
                jSONObject4.put("device_id", jSONObject.getString("device_id"));
            }
            if (jSONObject.has("device_model")) {
                jSONObject4.put("device_model", jSONObject.getString("device_model"));
            }
            if (jSONObject.has("version")) {
                jSONObject4.put("version", jSONObject.getInt("version_code"));
            }
            if (jSONObject.has("appkey")) {
                jSONObject4.put("appkey", jSONObject.getString("appkey"));
            }
            if (jSONObject.has("channel")) {
                jSONObject4.put("channel", jSONObject.getString("channel"));
            }
            if (TextUtils.isEmpty("device_id")) {
            }
            obj = null;
            if (obj != null) {
                jSONObject2 = a;
            } else {
                jSONObject2 = null;
            }
            fw.a(String.valueOf(jSONObject4));
            if (sharedPreferences != null) {
                return jSONObject2;
            }
            edit = sharedPreferences.edit();
            edit.remove("vers_name");
            edit.remove("vers_code");
            edit.remove("vers_date");
            edit.remove("vers_pre_version");
            edit.commit();
            return jSONObject2;
        } catch (Throwable th4) {
            fi.a(f).d();
            return new JSONObject();
        }
    }

    private void c() {
        try {
            if (this.h.e()) {
                et etVar = new et(f, this.a);
                etVar.a((ed) this);
                if (this.b.a()) {
                    etVar.e = true;
                }
                etVar.a();
                return;
            }
            JSONObject a = a(new int[0]);
            if (a != null && a.length() > 0) {
                et etVar2 = new et(f, this.a);
                etVar2.a((ed) this);
                if (this.b.a()) {
                    etVar2.e = true;
                }
                etVar2.c = a;
                etVar2.d = d();
                etVar2.a();
            }
        } catch (Throwable th) {
        }
    }

    private boolean d() {
        int i = -1;
        ar arVar = this.e;
        if (arVar.b == 0 || arVar.b == 1 || arVar.b == -1) {
            i = arVar.b;
        }
        switch (i) {
            case -1:
                return b.h;
            case 0:
                return false;
            case 1:
                return true;
            default:
                return false;
        }
    }

    public final void a(ar arVar) {
        this.c.a(arVar);
        this.b.a(arVar);
        this.d.a(arVar);
        ek ekVar = this.i;
        int[] c = arVar.c();
        ekVar.b = c[0];
        ekVar.c = c[1];
        this.g = bb.a(f).c.a();
    }

    private boolean a(int i) {
        if (this.p == 0) {
            return true;
        }
        if (System.currentTimeMillis() - this.p > 28800000) {
            this.n = 0;
            this.o = 0;
            this.p = System.currentTimeMillis();
            return true;
        } else if (i > 5000) {
            return false;
        } else {
            return true;
        }
    }

    public final void a(Context context) {
        try {
            if (f == null) {
                f = context;
            }
            if (this.l.length() > 0) {
                aj.a(f);
                aj.a(this.l);
                this.l = new JSONArray();
            }
            f.getSharedPreferences("umeng_general_config", 0).edit().putLong("thtstart", this.p).putInt("gkvc", this.n).putInt("ekvc", this.o).commit();
        } catch (Throwable th) {
        }
    }
}
