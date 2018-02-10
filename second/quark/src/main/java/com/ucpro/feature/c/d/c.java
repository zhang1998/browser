package com.ucpro.feature.c.d;

import android.text.TextUtils;
import com.ucpro.c.b;
import com.ucpro.feature.c.b.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class c implements Callback {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        this.a.a("http fail.." + iOException.getMessage());
    }

    public final void onResponse(Call call, Response response) throws IOException {
        if (response.code() == 200) {
            Reader charStream = response.body().charStream();
            if (charStream == null) {
                this.a.a("char stream is null");
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(charStream);
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                this.a.a("tokenUrl is empty");
                return;
            }
            Object readLine2 = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine2)) {
                this.a.a("fileUrl is empty");
                return;
            }
            b.b();
            this.a.a(readLine, readLine2);
            return;
        }
        this.a.a("http response code not 200..");
    }
}
