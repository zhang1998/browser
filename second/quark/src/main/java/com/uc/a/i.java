package com.uc.a;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class i implements Callback {
    final /* synthetic */ b a;

    i(b bVar) {
        this.a = bVar;
    }

    public final void onFailure(Call call, IOException iOException) {
        String message;
        PrintStream printStream = System.out;
        b bVar = this.a;
        if (iOException != null) {
            message = iOException.getMessage();
        } else {
            message = "";
        }
        Iterator it = bVar.b.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(message, bVar.a);
        }
        bVar.a();
    }

    public final void onResponse(Call call, Response response) throws IOException {
        PrintStream printStream = System.out;
        response.code();
        response.message();
        response.protocol().toString();
        byte[] bytes = response.body().bytes();
        b bVar = this.a;
        try {
            String str = new String(bytes, Charset.forName("UTF-8"));
        } catch (Exception e) {
        }
        bVar.a(bytes);
    }
}
