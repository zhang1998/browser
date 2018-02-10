package com.loc;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;

/* compiled from: ProGuard */
final class dk extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Editor a;

    dk(Editor editor) {
        this.a = editor;
    }

    private Void a() {
        try {
            if (this.a != null) {
                this.a.commit();
            }
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "commit");
        }
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }
}
