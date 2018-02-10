package com.a.a.a;

import android.text.TextUtils;
import com.uc.webview.browser.interfaces.SettingKeys;

/* compiled from: ProGuard */
public final class ar {
    int a = -1;
    int b = -1;
    int c = -1;
    String d = null;
    int e = -1;
    int f = -1;
    String g = null;
    String h = null;
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private String l = null;
    private String m = null;
    private String n = null;
    private String o = null;

    ar() {
    }

    public final void a(dx dxVar) {
        if (dxVar != null) {
            this.i = a(dxVar, "defcon");
            this.a = a(dxVar, "latent");
            this.b = a(dxVar, "codex");
            this.j = a(dxVar, "report_policy");
            this.k = a(dxVar, "report_interval");
            this.l = b(dxVar, "client_test");
            this.c = a(dxVar, "test_report_interval");
            this.d = b(dxVar, SettingKeys.UserMachineID);
            this.e = a(dxVar, "integrated_test");
            this.f = a(dxVar, "latent_hours");
            this.m = b(dxVar, "country");
            this.g = b(dxVar, "domain_p");
            this.h = b(dxVar, "domain_s");
            this.n = b(dxVar, "initial_view_time");
            this.o = b(dxVar, "track_list");
        }
    }

    public final String a() {
        if (this.o != null) {
            return this.o;
        }
        return null;
    }

    public final int b() {
        if (this.i != -1 && this.i <= 3 && this.i >= 0) {
            return this.i;
        }
        return 0;
    }

    public final int[] c() {
        if (this.j != -1) {
            int i;
            switch (this.j) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 8:
                    i = 1;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i != 0) {
                if (this.k == -1 || this.k < 90 || this.k > 86400) {
                    this.k = 90;
                }
                return new int[]{this.j, this.k * 1000};
            }
        }
        return new int[]{-1, -1};
    }

    public final String d() {
        if (this.l == null || !ea.a(this.l)) {
            return null;
        }
        return this.l;
    }

    public final int a(int i) {
        return (this.c == -1 || this.c < 90 || this.c > 86400) ? i : this.c * 1000;
    }

    private static int a(dx dxVar, String str) {
        if (dxVar != null) {
            try {
                if (dxVar.a()) {
                    dr drVar = (dr) dxVar.a.get(str);
                    if (drVar == null || TextUtils.isEmpty(drVar.a)) {
                        return -1;
                    }
                    try {
                        return Integer.parseInt(drVar.a.trim());
                    } catch (Exception e) {
                        return -1;
                    }
                }
            } catch (Exception e2) {
                return -1;
            }
        }
        return -1;
    }

    private static String b(dx dxVar, String str) {
        if (dxVar == null) {
            return null;
        }
        String str2;
        try {
            if (!dxVar.a()) {
                return null;
            }
            dr drVar = (dr) dxVar.a.get(str);
            if (drVar == null || TextUtils.isEmpty(drVar.a)) {
                return null;
            }
            str2 = drVar.a;
            return str2;
        } catch (Exception e) {
            str2 = null;
        }
    }
}
