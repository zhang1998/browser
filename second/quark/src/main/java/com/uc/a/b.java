package com.uc.a;

import android.text.TextUtils;
import com.uc.base.b.c.c.a;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class b {
    n a;
    ArrayList<l> b = new ArrayList();
    private LinkedList<n> c = new LinkedList();
    private OkHttpClient d;

    public b(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            throw new RuntimeException("OkHttpBusinessHandler OkHttpClient is null");
        }
        this.d = okHttpClient;
    }

    public final void a(l lVar) {
        if (lVar != null && !this.b.contains(lVar)) {
            this.b.add(lVar);
        }
    }

    final void a(byte[] bArr) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(this.a, bArr);
        }
        a();
    }

    public final boolean a(n nVar) {
        boolean z = true;
        if (nVar != null) {
            synchronized (this.c) {
                this.c.add(nVar);
            }
        } else {
            z = false;
        }
        if (this.a == null) {
            return a();
        }
        return z;
    }

    private n b() {
        n nVar;
        synchronized (this.c) {
            nVar = (n) this.c.poll();
        }
        return nVar;
    }

    final boolean a() {
        this.a = null;
        boolean z = false;
        do {
            n b = b();
            if (b == null) {
                break;
            }
            z = b(b);
        } while (!z);
        return z;
    }

    private boolean b(n nVar) {
        try {
            Object b = nVar.b("method");
            PrintStream printStream;
            if (TextUtils.isEmpty(b)) {
                printStream = System.out;
                return false;
            }
            String toUpperCase = b.toUpperCase();
            String a = nVar.a();
            if (TextUtils.isEmpty(a)) {
                printStream = System.out;
                return false;
            }
            RequestBody create;
            new HttpLoggingInterceptor(new a(this)).setLevel(Level.BODY);
            a.a(nVar.b("conn_timeout"), 20000);
            a.a(nVar.b("socket_timeout"), 60000);
            Builder builder = new Builder();
            for (Entry entry : nVar.d().entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
            Headers build = builder.build();
            if (SpdyRequest.POST_METHOD.equals(toUpperCase)) {
                create = RequestBody.create(null, nVar.f());
            } else {
                create = null;
            }
            this.d.newCall(new Request.Builder().url(a).method(toUpperCase, create).headers(build).build()).enqueue(new i(this));
            this.a = nVar;
            return true;
        } catch (Throwable th) {
            com.uc.base.b.b.a.a(th);
            return false;
        }
    }
}
