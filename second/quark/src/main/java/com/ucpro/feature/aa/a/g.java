package com.ucpro.feature.aa.a;

import com.ucweb.common.util.h.m;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class g implements Callback {
    final /* synthetic */ e a;
    final /* synthetic */ h b;

    g(h hVar, e eVar) {
        this.b = hVar;
        this.a = eVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        m.a(2, new n(this));
    }

    public final void onResponse(Call call, Response response) throws IOException {
        m.a(2, new o(this));
    }
}
