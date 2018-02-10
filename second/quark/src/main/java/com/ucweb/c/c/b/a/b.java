package com.ucweb.c.c.b.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.uc.apollo.android.GuideDialog;
import com.ucweb.c.a.a;
import com.ucweb.c.a.c;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class b implements a {
    private final c a = new c();
    private final int b;

    public b(int i) {
        this.b = i;
    }

    public final void a(com.ucweb.c.b.b bVar) {
        if (!c.a()) {
            Toast.makeText(com.ucweb.c.c.b.a(), com.ucweb.c.b.not_install_app, 0).show();
        } else if (this.b == a.a) {
            int i = bVar.d;
            if (i == c.e) {
                if (!com.ucweb.c.d.c.b("com.tencent.mobileqq")) {
                    c.b();
                } else if (c.a("4.2.0")) {
                    c.c();
                } else {
                    c.e(bVar);
                }
            } else if (i == c.d) {
                if (!com.ucweb.c.d.c.b("com.tencent.mobileqq")) {
                    c.b();
                } else if (c.a("4.2.0")) {
                    c.c();
                } else {
                    r1 = new Bundle();
                    r1.putString(GuideDialog.TITLE, bVar.b);
                    r0 = bVar.c;
                    if (r0 == null) {
                        r0 = "uc share";
                    }
                    r1.putString("summary", r0);
                    r0 = bVar.a;
                    if (r0 == null) {
                        r0 = "http://uc.cn";
                    }
                    r1.putString("targetUrl", r0);
                    r0 = bVar.g;
                    if (r0 != null && r0.startsWith("file://")) {
                        r0 = r0.substring(7);
                    }
                    r1.putString("imageLocalUrl", r0);
                    r1.putInt("req_type", 5);
                    c.a(c.a(r1));
                }
            } else if (!com.ucweb.c.d.c.b("com.tencent.mobileqq")) {
                c.d(bVar);
            } else if (c.a("4.2.0")) {
                c.d(bVar);
            } else {
                c.e(bVar);
            }
        } else if (bVar.d == c.d) {
            if (!c.a("4.7.0")) {
                c.c(bVar);
            } else if (!c.b("2.0")) {
                c.a(bVar);
            } else if (com.ucweb.c.d.c.b("com.qzone")) {
                c.c();
            } else {
                c.b();
            }
        } else if (!c.a("4.7.0")) {
            c.c(bVar);
        } else if (!c.b("3.4")) {
            c.a(bVar);
        } else if (c.b("2.0")) {
            r1 = new Bundle();
            r1.putString(GuideDialog.TITLE, bVar.b);
            r0 = bVar.c;
            if (r0 == null) {
                r0 = "uc share";
            }
            r1.putString("summary", r0);
            r0 = bVar.a;
            if (r0 == null) {
                r0 = "http://uc.cn";
            }
            r1.putString("targetUrl", r0);
            CharSequence charSequence = bVar.g;
            if (charSequence != null && charSequence.startsWith("file://")) {
                charSequence = charSequence.substring(7);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(charSequence);
                r1.putStringArrayList("imageUrl", arrayList);
            }
            r1.putInt("req_type", 1);
            r0 = "http://openmobile.qq.com/api/check2?page=qzProvide.html&loginpage=loginindex.html&logintype=qzone";
            r1.putString("appId", com.ucweb.c.a.b.QQ.i);
            r1.putString("sdkp", "a");
            r1.putString("sdkv", "1.7");
            r1.putString("status_os", VERSION.RELEASE);
            r1.putString("status_machine", Build.MODEL);
            Object a = c.a(com.ucweb.c.c.b.a());
            if (a != null) {
                r1.putString("appName", a);
            }
            String string = r1.getString(GuideDialog.TITLE);
            String string2 = r1.getString("summary");
            if (!TextUtils.isEmpty(string) && string.length() > 40) {
                r1.putString(GuideDialog.TITLE, string.substring(0, 40) + "...");
            }
            if (!TextUtils.isEmpty(string2) && string2.length() > 80) {
                r1.putString("summary", string2.substring(0, 80) + "...");
            }
            if (!TextUtils.isEmpty(a)) {
                r1.putString("site", a);
            }
            r1.putString("type", String.valueOf(r1.getInt("req_type", 1)));
            String a2 = com.ucweb.c.d.c.a(r1);
            if (a2 != null) {
                new StringBuilder().append(r0).append("&").append(a2.replaceAll("\\+", "%20"));
                return;
            }
            throw new AssertionError("result is null");
        } else {
            c.b(bVar);
        }
    }
}
