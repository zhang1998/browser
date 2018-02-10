package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: ProGuard */
final class ai extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    ai(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        try {
            n nVar = new n(this.a, ao.b());
            List<aq> a = nVar.a(aq.a(this.b), aq.class, false);
            if (a.size() > 0) {
                for (aq aqVar : a) {
                    if (!this.c.equalsIgnoreCase(aqVar.c)) {
                        ak.b(this.a, nVar, aqVar.a);
                    }
                }
            }
        } catch (Throwable th) {
            es.a(th, "DexFileManager", "clearUnSuitableVersion");
        }
    }
}
