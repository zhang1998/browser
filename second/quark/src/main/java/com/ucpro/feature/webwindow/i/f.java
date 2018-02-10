package com.ucpro.feature.webwindow.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.ucweb.common.util.h.a;
import com.ucweb.common.util.h.m;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ProGuard */
final class f extends a {
    final /* synthetic */ String a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;

    f(a aVar, String str, Bitmap bitmap, String str2) {
        this.d = aVar;
        this.a = str;
        this.b = bitmap;
        this.c = str2;
    }

    public final void run() {
        Closeable fileOutputStream;
        FileNotFoundException e;
        Throwable th;
        IOException e2;
        try {
            fileOutputStream = new FileOutputStream(new File(this.a));
            try {
                this.b.compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                com.ucweb.common.util.o.a.a(fileOutputStream);
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    Log.e("FavIcoManager", e.getMessage(), e.getCause());
                    com.ucweb.common.util.o.a.a(fileOutputStream);
                    m.a(0, new b(this, new File(a.b()), new String[]{this.c.toString()}));
                } catch (Throwable th2) {
                    th = th2;
                    com.ucweb.common.util.o.a.a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                e2 = e4;
                Log.e("FavIcoManager", e2.getMessage(), e2.getCause());
                com.ucweb.common.util.o.a.a(fileOutputStream);
                m.a(0, new b(this, new File(a.b()), new String[]{this.c.toString()}));
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileOutputStream = null;
            Log.e("FavIcoManager", e.getMessage(), e.getCause());
            com.ucweb.common.util.o.a.a(fileOutputStream);
            m.a(0, new b(this, new File(a.b()), new String[]{this.c.toString()}));
        } catch (IOException e6) {
            e2 = e6;
            fileOutputStream = null;
            Log.e("FavIcoManager", e2.getMessage(), e2.getCause());
            com.ucweb.common.util.o.a.a(fileOutputStream);
            m.a(0, new b(this, new File(a.b()), new String[]{this.c.toString()}));
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            com.ucweb.common.util.o.a.a(fileOutputStream);
            throw th;
        }
        m.a(0, new b(this, new File(a.b()), new String[]{this.c.toString()}));
    }
}
