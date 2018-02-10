package com.airbnb.lottie;

import android.content.res.Resources;
import java.io.InputStream;

/* compiled from: ProGuard */
final class ct extends bk<InputStream> {
    private final Resources a;
    private final t b;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return ds.a(this.a, ((InputStream[]) objArr)[0]);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.b.a((k) obj);
    }

    ct(Resources resources, t tVar) {
        this.a = resources;
        this.b = tVar;
    }
}
