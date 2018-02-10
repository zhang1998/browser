package com.uc.apollo.media.impl;

import com.uc.apollo.Settings;
import com.uc.apollo.media.base.Config;
import com.uc.apollo.media.base.e;
import com.uc.apollo.media.d;

/* compiled from: ProGuard */
public final class A {
    public static g a(int i) {
        if (!Settings.valid()) {
            return null;
        }
        int i2;
        if (Settings.mediaPlayerServiceEnable()) {
            i2 = 4;
        } else {
            i2 = e.a();
        }
        return a(i, i2);
    }

    public static g a(int i, int i2) {
        int i3 = false;
        g gVar = null;
        if (Settings.valid()) {
            int a = d.a(i2);
            String str = "";
            if (a == 5) {
                if (Config.get(3, false)) {
                    i3 = 1;
                } else {
                    try {
                        if (a.c()) {
                            gVar = h.i(i);
                        } else {
                            i3 = a.a();
                            str = a.b();
                        }
                    } catch (Throwable th) {
                        i3 = 2;
                        str = th.getMessage() + ";" + th.getCause();
                    }
                }
            } else if (a == 3) {
                gVar = v.i(i);
                i3 = 5;
            } else if (a == 4) {
                gVar = com.uc.apollo.media.service.d.a(i);
                i3 = 7;
            } else {
                i3 = 9;
            }
            if (gVar == null) {
                gVar = G.i(i);
            }
            gVar.a(i3, str);
        }
        return gVar;
    }
}
