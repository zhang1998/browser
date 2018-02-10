package com.ucweb.a;

import com.ucweb.a.b.c;
import com.ucweb.a.b.d;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class l implements c {
    public boolean a = false;
    public String b;
    public d c;

    private void a(u uVar) {
        if (uVar != null && uVar.h == 4) {
            h.a().b(new ArrayList());
            h a = h.a();
            a.a.clear();
            a.b.clear();
            a.c.clear();
        } else if (this.c != null) {
            this.c.a();
        }
    }

    private void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    public final void a(u uVar, boolean z) {
        boolean z2 = false;
        String str = uVar.a;
        if (str == null || !com.ucweb.a.a.c.c().r().equalsIgnoreCase(str)) {
            return;
        }
        if (!z) {
            a(uVar);
        } else if (!this.a) {
            if (uVar == null) {
                a(uVar);
                return;
            }
            int i;
            boolean z3;
            if (uVar.a()) {
                i = uVar.l;
                if (!"true".equalsIgnoreCase(uVar.a("hide_redpoint")) || i == 4) {
                    a(true);
                    k.b(uVar.a, true);
                } else {
                    a(false);
                    k.b(uVar.a, false);
                }
                k.a(uVar.a, true);
            } else {
                a(false);
                k.a(uVar.a, false);
            }
            if (uVar.h == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            com.ucweb.a.a.c.c();
            if (z3) {
                new StringBuilder("[").append(uVar.a).append("]显示强制更新对话框.");
                return;
            }
            i = uVar.i;
            if (i == 1) {
                z2 = true;
            }
            if (uVar.a()) {
                if (this.c != null) {
                    this.c.a(uVar);
                }
                com.ucweb.a.a.c.c().a("VerifyHost", uVar.c);
                if (1 == i) {
                    long j;
                    if (com.ucweb.a.a.c.c().J()) {
                        j = -1;
                    } else {
                        j = System.currentTimeMillis();
                    }
                    com.ucweb.a.a.c.c().a("wifi_force_upgrade", j);
                    return;
                }
                return;
            }
            r.a();
            r.a(uVar);
            if (!z2) {
            }
        }
    }
}
