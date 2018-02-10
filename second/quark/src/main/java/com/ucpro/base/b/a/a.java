package com.ucpro.base.b.a;

import android.util.Log;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.e;
import com.bumptech.glide.util.d;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class a implements Callback {
    final /* synthetic */ b a;
    final /* synthetic */ c b;

    a(c cVar, b bVar) {
        this.b = cVar;
        this.a = bVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        Log.isLoggable("OkHttpFetcher", 3);
        this.a.a((Exception) iOException);
    }

    public final void onResponse(Call call, Response response) throws IOException {
        this.b.b = response.body();
        if (response.isSuccessful()) {
            long contentLength = this.b.b.contentLength();
            this.b.a = d.a(this.b.b.byteStream(), contentLength);
            this.a.a(this.b.a);
            return;
        }
        this.a.a(new e(response.message(), response.code()));
    }
}
