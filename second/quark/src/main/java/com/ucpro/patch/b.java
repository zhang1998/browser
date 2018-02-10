package com.ucpro.patch;

import android.content.Context;
import com.d.a.b.a;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.x;
import com.ucpro.business.stat.m;
import com.ucweb.a.b.c;
import com.ucweb.a.u;
import java.util.List;

/* compiled from: ProGuard */
final class b implements c {
    final /* synthetic */ Context a;
    final /* synthetic */ PatchService b;

    b(PatchService patchService, Context context) {
        this.b = patchService;
        this.a = context;
    }

    public final void a(u uVar, boolean z) {
        if (z) {
            String str;
            String str2;
            int i;
            Object obj;
            int i2 = 0;
            String str3 = null;
            List<a> list = uVar.o;
            if (!(list == null || list.isEmpty())) {
                for (a aVar : list) {
                    if (aVar.b().equalsIgnoreCase("deployment")) {
                        String str4;
                        i2 = aVar.b;
                        if (aVar.c == null) {
                            str = null;
                        } else {
                            str = aVar.c.toString();
                        }
                        if (aVar.d == null) {
                            str2 = null;
                        } else {
                            str2 = aVar.d.toString();
                        }
                        i = aVar.e;
                        if (aVar.f == null) {
                            str4 = null;
                        } else {
                            str4 = aVar.f.toString();
                        }
                        str3 = str4;
                        obj = 1;
                        int i3 = i2;
                        i2 = i;
                        i = i3;
                        if (obj == null) {
                            m.a("patch", "comret", "stat", SettingsConst.FALSE);
                            x.a(4);
                        } else {
                            m.a("patch", "comret", "stat", SettingsConst.TRUE);
                            x.a(4);
                        }
                        if (i != 4) {
                            if (com.uc.aerie.updater.a.a().a.a()) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj == null) {
                                m.a("patch", "rb", "stat", SettingsConst.FALSE);
                                x.a(4);
                            } else {
                                m.a("patch", "rb", "stat", SettingsConst.TRUE);
                                x.a(4);
                            }
                            PatchService.b();
                            return;
                        } else if (i != 3 || i == 2 || i == 1) {
                            PatchService.a(this.b, str, str2, str3, i2, this.a);
                            return;
                        } else if (i == 0) {
                            PatchService.b();
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
            obj = null;
            str = null;
            i = -1;
            str2 = null;
            if (obj == null) {
                m.a("patch", "comret", "stat", SettingsConst.TRUE);
                x.a(4);
            } else {
                m.a("patch", "comret", "stat", SettingsConst.FALSE);
                x.a(4);
            }
            if (i != 4) {
                if (i != 3) {
                }
                PatchService.a(this.b, str, str2, str3, i2, this.a);
                return;
            }
            if (com.uc.aerie.updater.a.a().a.a()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                m.a("patch", "rb", "stat", SettingsConst.TRUE);
                x.a(4);
            } else {
                m.a("patch", "rb", "stat", SettingsConst.FALSE);
                x.a(4);
            }
            PatchService.b();
            return;
        }
        PatchService.b();
    }
}
