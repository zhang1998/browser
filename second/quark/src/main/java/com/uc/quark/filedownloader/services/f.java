package com.uc.quark.filedownloader.services;

import android.net.Uri;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.model.b;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ v b;

    f(v vVar, b bVar) {
        this.b = vVar;
        this.a = bVar;
    }

    public final void run() {
        try {
            e.a().getContentResolver().update(Uri.parse(e.a), b.a(this.a.c()), "_id = ? ", new String[]{String.valueOf(this.a.a)});
        } catch (Exception e) {
        }
    }
}
