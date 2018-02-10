package com.ucpro.feature.video.a;

import android.content.ContentValues;
import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public final class e implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    public e(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final void run() {
        a aVar = this.b;
        b bVar = this.a;
        b a = aVar.a(bVar);
        ContentValues contentValues = new ContentValues();
        contentValues.put("video_type", Integer.valueOf(bVar.b));
        contentValues.put("page_url", bVar.c);
        contentValues.put("video_uri", bVar.d);
        contentValues.put(GuideDialog.TITLE, bVar.e);
        contentValues.put("current_pos", Integer.valueOf(bVar.f));
        contentValues.put("duration", Long.valueOf(bVar.g));
        contentValues.put("visit_time", Long.valueOf(bVar.h));
        contentValues.put("quality", bVar.i);
        if (a == null) {
            aVar.a.insert("video_history", null, contentValues);
            return;
        }
        aVar.a.update("video_history", contentValues, "id=?", new String[]{String.valueOf(a.a)});
    }
}
