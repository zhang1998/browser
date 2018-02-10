package com.ucpro.patch;

import android.content.Context;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.x;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.k.a;
import java.io.File;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ PatchService f;
    private final int g = 307200;

    d(PatchService patchService, int i, Context context, String str, String str2, String str3) {
        this.f = patchService;
        this.a = i;
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final void run() {
        int i;
        File file;
        if (this.a < 307200) {
            i = 1;
        } else {
            i = 0;
        }
        File a = PatchService.a(this.b, this.c, this.f.i, i);
        if (a.a(a, this.d, this.f.y)) {
            file = a;
        } else {
            file = PatchService.a(this.b, this.e, this.f.i, i);
            if (!a.a(file, this.d, this.f.y)) {
                a = file;
                i = 0;
                if (i != 0) {
                    if (a == null && a.exists()) {
                        a.delete();
                    } else {
                        new StringBuilder("Download patch ").append(this.f.i).append(" not exists");
                    }
                    m.a("patch", "dl", "stat", SettingsConst.TRUE);
                    x.a(4);
                    PatchService.b();
                }
                m.a("patch", "dl", "stat", SettingsConst.FALSE);
                x.a(4);
                PatchService.b(a);
                return;
            }
        }
        a = file;
        i = 1;
        if (i != 0) {
            m.a("patch", "dl", "stat", SettingsConst.FALSE);
            x.a(4);
            PatchService.b(a);
            return;
        }
        if (a == null) {
        }
        new StringBuilder("Download patch ").append(this.f.i).append(" not exists");
        m.a("patch", "dl", "stat", SettingsConst.TRUE);
        x.a(4);
        PatchService.b();
    }
}
