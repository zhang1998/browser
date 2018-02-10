package com.tencent.a.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.b.h;
import com.tencent.tauth.c;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

/* compiled from: ProGuard */
public final class e extends Thread {
    private final /* synthetic */ h a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ String c;
    private final /* synthetic */ Bundle d;
    private final /* synthetic */ String e;
    private final /* synthetic */ c f = null;

    public e(h hVar, Context context, String str, Bundle bundle, String str2) {
        this.a = hVar;
        this.b = context;
        this.c = str;
        this.d = bundle;
        this.e = str2;
    }

    public final void run() {
        try {
            k.a(this.a, this.b, this.c, this.d, this.e);
        } catch (MalformedURLException e) {
        } catch (ConnectTimeoutException e2) {
        } catch (SocketTimeoutException e3) {
        } catch (j e4) {
        } catch (g e5) {
        } catch (IOException e6) {
        } catch (JSONException e7) {
        } catch (Exception e8) {
        }
    }
}
