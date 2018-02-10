package com.ucpro.feature.downloadpage.e;

import com.ucweb.common.util.h.m;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: ProGuard */
final class g implements Callback {
    final /* synthetic */ af a;

    g(af afVar) {
        this.a = afVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        m.a(2, new r(this));
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Request request = response.request();
        this.a.b.d = response.header("Content-Type");
        this.a.b.a = request.url().toString();
        try {
            this.a.b.f = Long.parseLong(response.header("Content-Length"));
            response.close();
        } catch (Exception e) {
        }
        m.a(2, new aj(this));
    }
}
