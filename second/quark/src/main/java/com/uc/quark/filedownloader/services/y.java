package com.uc.quark.filedownloader.services;

import android.content.ContentValues;
import android.net.Uri;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.model.b;

/* compiled from: ProGuard */
final class y implements Runnable {
    final /* synthetic */ ContentValues a;
    final /* synthetic */ int b;
    final /* synthetic */ v c;

    y(v vVar, ContentValues contentValues, int i) {
        this.c = vVar;
        this.a = contentValues;
        this.b = i;
    }

    public final void run() {
        try {
            this.c.b.update("filedownloader", this.a, "_id = ? ", new String[]{String.valueOf(this.b)});
            e.a().getContentResolver().update(Uri.parse(e.a), b.a(this.a), "_id = ?", new String[]{String.valueOf(this.b)});
        } catch (Exception e) {
        }
    }
}
