package com.ucpro.feature.webwindow.i;

import android.util.Log;
import com.ucweb.common.util.h.a;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
final class b extends a {
    final /* synthetic */ File a;
    final /* synthetic */ String[] b;
    final /* synthetic */ f c;

    b(f fVar, File file, String[] strArr) {
        this.c = fVar;
        this.a = file;
        this.b = strArr;
    }

    public final void run() {
        try {
            com.ucweb.common.util.k.a.a(this.a, this.b, true);
        } catch (IOException e) {
            Log.e("FavIcoManager", e.getMessage(), e.getCause());
        }
    }
}
