package com.uc.weex;

import android.util.Log;
import com.uc.weex.e.a;
import com.uc.weex.e.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: ProGuard */
final class k implements a<Object> {
    final /* synthetic */ p a;

    k(p pVar) {
        this.a = pVar;
    }

    public final void a(e eVar, boolean z, Object obj, Throwable th) {
        if (!z && th != null) {
            Log.e("WeexManager", "", th);
            if ((th instanceof Throwable) && g.b != null) {
                f fVar = g.b.b;
                if (fVar != null) {
                    try {
                        String str;
                        Writer stringWriter = new StringWriter();
                        th.printStackTrace(new PrintWriter(stringWriter));
                        String str2 = "null";
                        String str3 = "createPageThenRender() failed";
                        StringBuilder stringBuilder = new StringBuilder("task = ");
                        if (eVar == null) {
                            str = "null";
                        } else {
                            str = eVar.getClass().getName();
                        }
                        fVar.a(str2, str3, stringBuilder.append(str).append(": ").append(stringWriter.toString()).toString());
                    } catch (Throwable th2) {
                        Log.e("WeexManager", "", th2);
                    }
                }
            }
        }
    }
}
