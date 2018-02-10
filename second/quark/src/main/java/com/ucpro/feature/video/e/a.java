package com.ucpro.feature.video.e;

import android.util.Log;
import com.ucpro.feature.video.e.a.b;
import com.ucweb.common.util.c;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
public final class a implements Callback {
    private b a;

    public a(b bVar) {
        this.a = bVar;
        c.a(this.a);
    }

    public final void onFailure(Call call, IOException iOException) {
        Object obj;
        Log.e("hjw-okhttp", "request failed", iOException);
        Object obj2 = this.a.b;
        c.a(obj2);
        b bVar = this.a;
        if (bVar.d < bVar.c) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            bVar = this.a;
            bVar.d++;
            b.a().a(this.a);
            return;
        }
        obj2.a(-1, "fail after retry\n" + iOException.getMessage());
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Object obj = this.a.b;
        c.a(obj);
        int code = response.code();
        String message = response.message();
        response.protocol().toString();
        com.ucpro.c.b.b();
        obj.a(response.headers());
        if (code != 200) {
            obj.a(code, "statusCode=" + code + "\n" + message);
        } else {
            obj.a(response.body().bytes());
        }
    }
}
