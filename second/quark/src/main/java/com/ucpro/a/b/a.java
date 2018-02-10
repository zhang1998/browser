package com.ucpro.a.b;

import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.IAccessControl;
import com.ucpro.a.a.d;
import com.ucpro.a.a.e;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/* compiled from: ProGuard */
public final class a {
    private static boolean c = false;
    private com.ucpro.a.a.a a;
    private IAccessControl b;

    public a(com.ucpro.a.a.a aVar, IAccessControl iAccessControl) {
        this.a = aVar;
        this.b = iAccessControl;
    }

    public final void a() {
        String b = this.a.b.b();
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(b)) {
            int lastIndexOf = b.lastIndexOf("^^");
            if (lastIndexOf != -1) {
                String str = new String(b.substring(0, lastIndexOf));
                m.a(2, new b(this));
                String[] a = com.ucweb.common.util.n.a.a(str, "^^");
                Vector vector = new Vector();
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                for (String str2 : a) {
                    if (!com.ucweb.common.util.n.a.a(str2)) {
                        String[] a2 = com.ucweb.common.util.n.a.a(str2, "||");
                        if (a2.length == 6) {
                            new StringBuilder("setEnableHuc parts = ").append(Arrays.toString(a2));
                            String str3 = a2[0];
                            String str4 = a2[1];
                            if (!SettingsConst.FALSE.equals(a2[3])) {
                                arrayList.remove(str3);
                            } else if (!arrayList.contains(str3)) {
                                arrayList2.add(str3);
                                arrayList.add(str3);
                            }
                            if (com.ucweb.common.util.n.a.b(str4)) {
                                new StringBuilder("setEnableHuc setUserAgent domain = uc_").append(str3).append(", userAgent = ").append(str4);
                                vector.add(str3);
                                this.a.a("uc_" + str3, str4);
                            }
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    b = com.ucweb.common.util.n.a.a(arrayList2, ",");
                    com.ucpro.a.a.a aVar = this.a;
                    c.a(aVar.a);
                    m.a(2, new d(aVar, "clearhuclist", b));
                }
                if (!vector.isEmpty()) {
                    com.ucpro.a.a.a aVar2 = this.a;
                    c.a(aVar2.a);
                    m.a(2, new e(aVar2, "hucspecialhostlist", vector));
                }
            }
        }
    }
}
