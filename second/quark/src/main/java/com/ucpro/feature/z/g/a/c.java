package com.ucpro.feature.z.g.a;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class c implements Callback {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ g c;

    c(g gVar, a aVar, String str) {
        this.c = gVar;
        this.a = aVar;
        this.b = str;
    }

    public final void onFailure(Call call, IOException iOException) {
    }

    public final void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            this.a.a(this.b, g.a(response.body().string()));
        }
    }
}
