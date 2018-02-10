package com.ucpro.feature.inputenhance;

import android.os.AsyncTask;

/* compiled from: ProGuard */
final class m extends AsyncTask {
    final /* synthetic */ af a;

    m(af afVar) {
        this.a = afVar;
    }

    protected final void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        this.a.a(this.a.d);
    }

    protected final Object doInBackground(Object... objArr) {
        for (int i = 0; i < 10; i++) {
            if (this.a.c.a() == null) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                }
            }
        }
        return null;
    }
}
