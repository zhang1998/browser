package com.ucpro.business.a;

import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.business.a.c.b;
import com.ucpro.business.a.d.a;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class c extends e implements com.ucpro.base.c.b.c, com.ucpro.business.e.d.e {
    private List<String> c = null;
    private List<String> d = null;
    private List<a> e = null;
    private b f;
    private com.ucpro.business.a.e.a g = null;

    protected final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
        m.a(0, new d(this));
    }

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.ci == i) {
            if (this.f == null || this.f.getParent() == null) {
                if (this.f == null) {
                    if (message.obj != null && (message.obj instanceof String)) {
                        this.f = new b(this.b, (String) message.obj);
                        this.f.setWindowCallBacks(this);
                    } else {
                        return;
                    }
                }
                this.a.b().a(this.f, true);
                com.ucpro.business.stat.m.a("promotion", "enter_h5_page", new String[0]);
            }
        } else if (com.ucpro.base.a.e.cj == i) {
            com.ucweb.common.util.c.b(message.obj instanceof Object[]);
            Object[] objArr = (Object[]) message.obj;
            com.ucweb.common.util.c.b(objArr[0] instanceof String);
            com.ucweb.common.util.c.b(objArr[1] instanceof ValueCallback);
            String str = (String) objArr[0];
            ValueCallback valueCallback = (ValueCallback) objArr[1];
            if (com.ucpro.business.a.a.b.a()) {
                valueCallback.onReceiveValue(b(str));
            }
            if (com.ucpro.business.a.a.b.b()) {
                a c = c(str);
                if (c != null) {
                    this.g = new com.ucpro.business.a.e.a(this.b, c);
                    this.g.setCallback(new b(this, c));
                    m.a(2, new a(this), 1500);
                }
            }
        }
    }

    public final void b(int i, Message message) {
        if (j.r != i && j.f == i && this.f != null) {
            this.f.l();
        }
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final void g() {
        super.g();
        com.ucpro.business.e.d.g.a().d("ky_code");
        com.ucpro.business.e.d.g.a().d("kCode_Activity_Json_Data");
    }

    public final void a(com.ucpro.business.e.d.j jVar, String str, String str2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1964506568:
                if (str.equals("kCode_Activity_Json_Data")) {
                    obj = 1;
                    break;
                }
                break;
            case -266432994:
                if (str.equals("ky_code")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        boolean z = jSONObject.getBoolean("enable");
                        String string = jSONObject.getString("starttime");
                        String string2 = jSONObject.getString("endtime");
                        long a = com.ucpro.business.a.a.a.a(string, TimeZone.getTimeZone("GMT+8:00"));
                        long a2 = com.ucpro.business.a.a.a.a(string2, TimeZone.getTimeZone("GMT+8:00"));
                        String string3 = jSONObject.getString("code");
                        String string4 = jSONObject.getString("url");
                        com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "enable", z);
                        com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "starttime", a);
                        com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "endtime", a2);
                        com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "code", string3);
                        com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "url", string4);
                        this.c = null;
                        this.d = null;
                        com.ucpro.business.a.a.b.c();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            case 1:
                a(str2);
                return;
            default:
                return;
        }
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("startTime");
                String string2 = jSONObject.getString("endTime");
                long a = com.ucpro.business.a.a.a.a(string, TimeZone.getTimeZone("GMT+8:00"));
                long a2 = com.ucpro.business.a.a.a.a(string2, TimeZone.getTimeZone("GMT+8:00"));
                String string3 = jSONObject.getString("data");
                com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "startTime", a);
                com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "endTime", a2);
                com.ucweb.common.util.j.a.a(d.a(), "75766F5CC857E09B", "data", string3);
                this.e = null;
                com.ucpro.business.a.a.b.c();
            } catch (Exception e) {
            }
        }
    }

    private List<String> i() {
        if (this.d == null) {
            this.d = new ArrayList();
            for (Object add : com.ucweb.common.util.j.a.b(d.a(), "75766F5CC857E09B", "url", "https://activity.uc.cn/actplat/frontend/page/show/644/index.html?entry=a&uc_param_str=dsdnfrpfbivesscpgimibtbmnijblauputogpintnwkt&uc_biz_str=S%3Acustom%7CC%3Atitlebar_hover_2&UC_ACT").split(",")) {
                this.d.add(add);
            }
        }
        return this.d;
    }

    private List<a> j() {
        if (this.e == null) {
            this.e = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(com.ucweb.common.util.j.a.b(d.a(), "75766F5CC857E09B", "data", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    a aVar = new a();
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    aVar.a = jSONObject.getString("code");
                    aVar.b = jSONObject.getString("brand");
                    aVar.c = jSONObject.getString("url");
                    this.e.add(aVar);
                }
            } catch (Exception e) {
            }
        }
        return this.e;
    }

    private String b(String str) {
        String str2 = "";
        if (this.c == null) {
            this.c = new ArrayList();
            for (Object add : com.ucweb.common.util.j.a.b(d.a(), "75766F5CC857E09B", "code", "重拾专注力").split(",")) {
                this.c.add(add);
            }
        }
        List list = this.c;
        List i = i();
        int i2 = 0;
        while (i2 < list.size()) {
            String str3 = (String) list.get(i2);
            try {
                if (str.equals(str3) || str.equals(URLEncoder.encode(str3, "utf-8"))) {
                    break;
                }
                i2++;
            } catch (UnsupportedEncodingException e) {
                i2 = -1;
            }
        }
        if (i2 < 0 || i2 >= i.size()) {
            return str2;
        }
        return (String) i.get(i2);
    }

    private a c(String str) {
        List j = j();
        int i = 0;
        a aVar = null;
        while (i < j.size()) {
            aVar = (a) j.get(i);
            try {
                if (str.equals(aVar.a) || str.equals(URLEncoder.encode(aVar.a, "utf-8"))) {
                    break;
                }
                i++;
            } catch (UnsupportedEncodingException e) {
                i = -1;
            }
        }
        if (i < 0 || i >= j.size()) {
            return null;
        }
        return aVar;
    }

    public final View a(View view) {
        return this.a.b().b(this.a.b().a());
    }

    static /* synthetic */ void a(c cVar) {
        com.ucpro.business.a.e.a aVar = cVar.g;
        com.ucpro.ui.animation.g fVar = new f(cVar);
        if (!aVar.b) {
            aVar.a.animate().y((float) (-aVar.a.getMeasuredHeight())).setListener(new com.ucpro.business.a.e.d(aVar, fVar)).setDuration(300).start();
            aVar.b = true;
        }
    }
}
