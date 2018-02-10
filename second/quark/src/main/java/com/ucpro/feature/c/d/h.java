package com.ucpro.feature.c.d;

import android.text.TextUtils;
import com.ucpro.feature.c.a.a;
import com.ucweb.common.util.h.m;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
public final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ i b;

    public h(String str, i iVar) {
        this.a = str;
        this.b = iVar;
    }

    public final void run() {
        boolean z;
        String a = a.a(this.a);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(5000);
            Object headerField = httpURLConnection.getHeaderField("Location");
            z = TextUtils.isEmpty(headerField) || !headerField.contains("error");
        } catch (Exception e) {
            z = false;
        }
        m.a(2, new a(this, z, a));
    }
}
