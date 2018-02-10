package com.ucpro.feature.downloadpage.e;

import android.webkit.ValueCallback;
import com.uc.quark.x;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: ProGuard */
final class aa implements Callback {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ ah b;

    aa(ah ahVar, ValueCallback valueCallback) {
        this.b = ahVar;
        this.a = valueCallback;
    }

    public final void onFailure(Call call, IOException iOException) {
        m.a(2, new u(this, iOException));
    }

    public final void onResponse(Call call, Response response) throws IOException {
        m.a(2, new i(this, response.header("Content-Disposition"), response.header("Content-Type"), response.header("Content-Length"), a.i(new File(x.b()).getPath()).b));
        response.close();
    }
}
