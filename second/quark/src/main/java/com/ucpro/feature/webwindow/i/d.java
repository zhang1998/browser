package com.ucpro.feature.webwindow.i;

import android.util.Log;
import com.ucweb.common.util.h.a;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
final class d extends a {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Object obj = null;
        a aVar = this.a;
        if (com.ucweb.common.util.k.a.h(a.b())) {
            try {
                for (String split : com.ucweb.common.util.k.a.a(new File(a.b()))) {
                    String split2;
                    String[] split3 = split2.split("[|]");
                    int i;
                    if (split3.length == 2) {
                        String str = split3[0];
                        split2 = split3[1];
                        if (!(com.ucweb.common.util.n.a.a(str) || com.ucweb.common.util.n.a.a(split2))) {
                            if (!com.ucweb.common.util.k.a.h(split2) || aVar.a.containsKey(str)) {
                                i = 1;
                            } else {
                                aVar.a.putIfAbsent(str, split2);
                            }
                        }
                    } else {
                        i = 1;
                    }
                }
                if (obj != null) {
                    com.ucweb.common.util.k.a.c(a.b());
                    com.ucweb.common.util.k.a.a(new File(a.b()), aVar.a);
                }
            } catch (IOException e) {
                Log.e("FavIcoManager", e.getMessage(), e.getCause());
                a.a();
            }
        }
    }
}
