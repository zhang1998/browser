package com.ucweb.a;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class e implements Callback {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        if (this.a.b != null) {
            b bVar = this.a.b;
            if (iOException != null) {
                iOException.getMessage();
            }
            bVar.b();
        }
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Object obj = null;
        if (this.a.b != null) {
            obj = this.a.b.a(response.body().bytes());
        }
        if (this.a.b != null) {
            this.a.b.a(obj);
        }
    }
}
