package com.ucpro.feature.video.player.c;

import android.os.Build.VERSION;
import com.uc.a.d.l;
import com.uc.base.b.c.b.c;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.business.d.e;
import com.ucweb.common.util.n.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
public final class m {
    List<String> a;
    boolean b = false;
    boolean c = false;
    List<String> d;
    boolean e = false;
    boolean f = false;
    int g;
    boolean h;
    boolean i;
    int j;
    String k;
    private List<String> l;
    private boolean m = false;
    private boolean n = false;

    public m() {
        c eVar = new e();
        String str = "";
        if (com.uc.a.d.e.a(l.a(SettingKeys.VideoSoUpgradeRule), eVar) && !a.a(eVar.c())) {
            String c = eVar.c();
            if (c == null) {
                str = null;
            } else {
                String str2 = "<body>";
                int indexOf = c.indexOf(str2);
                int indexOf2 = c.indexOf("</body>");
                str = (indexOf <= 0 || indexOf2 <= 0 || indexOf2 <= indexOf) ? (indexOf <= 0 || indexOf2 != -1) ? (indexOf != -1 || indexOf2 <= 0) ? null : new String(c.substring(0, indexOf2).trim()) : new String(c.substring(str2.length() + indexOf).trim()) : new String(c.substring(str2.length() + indexOf, indexOf2).trim());
            }
        }
        Map a = a(str);
        if (a == null || a.isEmpty()) {
            this.l = null;
            this.m = false;
            this.n = false;
            this.a = null;
            this.b = false;
            this.c = false;
            this.d = null;
            this.e = false;
            this.f = false;
            this.g = 512;
            this.j = 3;
            this.h = false;
            this.i = false;
            this.k = null;
            return;
        }
        str = (String) a.get("country");
        if (a.b(str)) {
            this.m = str.startsWith("!");
            this.n = b(str);
            if (!this.n) {
                this.l = c(str);
            }
        }
        str = (String) a.get("device1");
        if (a.b(str)) {
            this.b = str.startsWith("!");
            this.c = b(str);
            if (!this.c) {
                this.a = c(str);
            }
        }
        str = (String) a.get("device2");
        if (a.b(str)) {
            this.e = str.startsWith("!");
            this.f = b(str);
            if (!this.f) {
                this.d = c(str);
            }
        }
        str = (String) a.get("mem");
        if (a.b(str)) {
            str.trim();
            try {
                this.g = Integer.parseInt(str);
            } catch (Exception e) {
            }
        }
        str = (String) a.get("rom1");
        if (a.b(str)) {
            this.h = d(str);
        } else {
            this.h = false;
        }
        str = (String) a.get("rom2");
        if (a.b(str)) {
            this.i = d(str);
        } else {
            this.i = false;
        }
        this.k = (String) a.get("soType");
        if (!a.a(this.k)) {
            this.k = this.k.toUpperCase(Locale.ENGLISH);
        }
        if (this.g <= 0) {
            this.g = 512;
        }
        str = (String) a.get("cy");
        if (a.b(str)) {
            str.trim();
            try {
                this.j = Integer.parseInt(str);
            } catch (Exception e2) {
            }
        }
        if (this.j <= 0) {
            this.j = 3;
        }
    }

    public final boolean a() {
        if (this.n) {
            return true;
        }
        String a = com.ucpro.model.a.a.a.a(SettingKeys.UBICpParam, "");
        if (a.a(a)) {
            a = null;
        } else {
            String[] b = a.b(a, ";");
            HashMap hashMap = new HashMap();
            for (String b2 : b) {
                String[] b3 = a.b(b2, ":");
                if (b3.length > 1) {
                    hashMap.put(b3[0], b3[1]);
                }
            }
            a = (String) hashMap.get("cc");
        }
        if (a.a(a) || this.l == null || this.l.isEmpty()) {
            return false;
        }
        boolean contains = this.l.contains(a);
        if (this.m) {
            return !contains;
        } else {
            return contains;
        }
    }

    private static Map<String, String> a(String str) {
        if (a.a(str)) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (String str2 : a.b(str, "\\|\\|")) {
            if (!a.a(str2)) {
                String[] b = a.b(str2, ":");
                if (b.length == 2) {
                    hashMap.put(b[0], b[1]);
                }
            }
        }
        return hashMap;
    }

    private static boolean b(String str) {
        return str.length() == 1 && str.startsWith("*");
    }

    private static boolean d(String str) {
        if (str.startsWith(",")) {
            str = "-2147483648" + str;
        }
        if (str.endsWith(",")) {
            str = str + Integer.MAX_VALUE;
        }
        String[] b = a.b(str, ",");
        if (b.length < 3) {
            return false;
        }
        int[] iArr = new int[b.length];
        int i = 0;
        while (i < iArr.length) {
            try {
                iArr[i] = Integer.parseInt(b[i].trim());
                if (i > 0 && iArr[i] < iArr[i - 1]) {
                    return false;
                }
                i++;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        int i2 = VERSION.SDK_INT;
        if (i2 < iArr[0]) {
            return true;
        }
        for (i = 1; i < iArr.length - 1; i++) {
            if (i2 == iArr[i]) {
                return true;
            }
        }
        if (i2 > iArr[iArr.length - 1]) {
            return true;
        }
        return false;
    }

    private static List<String> c(String str) {
        if (str.startsWith("!")) {
            str = str.substring(1);
        }
        return Arrays.asList(a.b(str, ","));
    }
}
