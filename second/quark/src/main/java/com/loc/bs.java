package com.loc;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;

/* compiled from: ProGuard */
final class bs implements Runnable {
    final /* synthetic */ br a;
    final /* synthetic */ Context b;

    bs(br brVar, Context context) {
        this.a = brVar;
        this.b = context;
    }

    public final void run() {
        Throwable th;
        OutputStream outputStream = null;
        bc a;
        try {
            br brVar = this.a;
            Context context = brVar.a;
            byte[] a2 = eq.a(eg.a(context, eq.a(br.a(context, brVar.b, brVar.c))));
            a = bc.a(new File(ew.a(this.b, ew.f)), 204800);
            try {
                az b = a.b(Long.toString(System.currentTimeMillis()));
                outputStream = b.a();
                outputStream.write(a2);
                b.b();
                a.b();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                    }
                }
                if (a != null) {
                    try {
                        a.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    es.a(th, "OfflineLocManager", "applyOfflineLocEntity");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th7) {
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th8) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th9) {
            th = th9;
            a = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }
}
