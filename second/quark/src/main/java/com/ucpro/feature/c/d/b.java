package com.ucpro.feature.c.d;

import com.ucweb.common.util.o.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class b implements Callback {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    b(d dVar, String str) {
        this.b = dVar;
        this.a = str;
    }

    public final void onFailure(Call call, IOException iOException) {
        this.b.b.b("auth success but put file upload http failed.." + iOException.getMessage());
    }

    public final void onResponse(Call call, Response response) throws IOException {
        if (response.code() == 200) {
            this.b.b.a(this.a);
            return;
        }
        this.b.b.b("auth success but put file upload response code is=" + response.code());
        if (com.ucpro.c.b.b()) {
            response.toString();
            response.message();
            List d = a.d(response.body().byteStream());
            if (d != null && d.size() > 0) {
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
