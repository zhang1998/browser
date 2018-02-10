package com.loc;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;
import java.util.Random;

/* compiled from: ProGuard */
final class bv implements Runnable {
    final /* synthetic */ bu a;
    final /* synthetic */ Context b;

    bv(bu buVar, Context context) {
        this.a = buVar;
        this.b = context;
    }

    public final void run() {
        Throwable th;
        OutputStream outputStream = null;
        Random random = new Random();
        bc a;
        try {
            byte[] a2 = this.a.a();
            a = bc.a(new File(ew.a(this.b, ew.e)), 102400);
            try {
                az b = a.b(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()));
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
                    es.a(th, "StatisticsManager", "applyStatics");
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
