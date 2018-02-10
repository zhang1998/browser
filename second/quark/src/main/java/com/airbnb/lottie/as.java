package com.airbnb.lottie;

import android.content.res.Resources;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class as extends bk<JSONObject> {
    private final Resources a;
    private final t b;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return ds.a(this.a, ((JSONObject[]) objArr)[0]);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.b.a((k) obj);
    }

    as(Resources resources, t tVar) {
        this.a = resources;
        this.b = tVar;
    }
}
