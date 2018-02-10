package com.ucpro.a;

import android.text.TextUtils;
import com.uc.a.d.e;
import com.uc.base.b.c.b.c;
import com.ucpro.a.e.a;
import com.ucpro.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class an implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ am b;

    an(am amVar, byte[] bArr) {
        this.b = amVar;
        this.a = bArr;
    }

    public final void run() {
        c aVar = new a();
        if (e.a(this.a, aVar)) {
            ArrayList arrayList = aVar.a;
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object obj;
                com.ucpro.a.e.c cVar = (com.ucpro.a.e.c) it.next();
                if (cVar.a == null) {
                    obj = null;
                } else {
                    obj = cVar.a.toString();
                }
                if (!TextUtils.isEmpty(obj)) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    if (cVar.b == null) {
                        str = null;
                    } else {
                        str = cVar.b.toString();
                    }
                    if (cVar.c == null) {
                        str2 = null;
                    } else {
                        str2 = cVar.c.toString();
                    }
                    if (cVar.d == null) {
                        str3 = null;
                    } else {
                        str3 = cVar.d.toString();
                    }
                    if (cVar.e == null) {
                        str4 = null;
                    } else {
                        str4 = cVar.e.toString();
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("||");
                    if (str == null) {
                        str = "";
                    }
                    stringBuilder.append(str);
                    stringBuilder.append("||");
                    if (str2 == null) {
                        str2 = "";
                    }
                    stringBuilder.append(str2);
                    stringBuilder.append("||");
                    if (str3 == null) {
                        str3 = "";
                    }
                    stringBuilder.append(str3);
                    stringBuilder.append("||");
                    if (str4 == null) {
                        str4 = "";
                    }
                    stringBuilder.append(str4);
                    stringBuilder.append("||");
                    CharSequence stringBuilder2 = new StringBuilder();
                    Iterator it2 = cVar.f.iterator();
                    while (it2.hasNext()) {
                        String str5;
                        b bVar = (b) it2.next();
                        if (bVar.a == null) {
                            str5 = null;
                        } else {
                            str5 = bVar.a.toString();
                        }
                        if (str5 == null) {
                            str5 = "";
                        }
                        stringBuilder2.append(str5);
                        stringBuilder2.append(",");
                    }
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append("^^");
                } else {
                    return;
                }
            }
            at.a(stringBuilder.toString());
        }
    }
}
