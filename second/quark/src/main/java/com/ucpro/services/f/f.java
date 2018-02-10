package com.ucpro.services.f;

import android.util.Log;
import com.ucpro.c.b;
import com.ucweb.common.util.h.m;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class f implements Callback {
    final /* synthetic */ h a;

    f(h hVar) {
        this.a = hVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        m.a(2, new e(this, iOException));
    }

    public final void onResponse(Call call, Response response) throws IOException {
        if (b.b()) {
            Log.e("vanda", "onResponse thread name:" + Thread.currentThread().getName());
        }
        if (this.a.b != null) {
            m.a(2, new c(this, this.a.b.a(response.body().bytes())));
        }
        try {
            response.close();
        } catch (Exception e) {
        }
    }
}
