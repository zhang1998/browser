package com.taobao.weex.a;

import android.mini.support.annotation.NonNull;
import android.text.TextUtils;
import com.taobao.weex.common.r;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class e implements j {
    private static final c a = new d();
    private ExecutorService b;

    static /* synthetic */ byte[] a(InputStream inputStream, i iVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                i += read;
                if (iVar != null) {
                    iVar.a(i);
                }
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public final void a(r rVar, i iVar) {
        if (iVar != null) {
            iVar.a();
        }
        Runnable bVar = new b(this, rVar, iVar);
        if (this.b == null) {
            this.b = Executors.newFixedThreadPool(3);
        }
        this.b.execute(bVar);
    }

    @NonNull
    public static c a() {
        return a;
    }

    static /* synthetic */ HttpURLConnection a(r rVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(rVar.b).openConnection();
        httpURLConnection.setConnectTimeout(rVar.e);
        httpURLConnection.setReadTimeout(rVar.e);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (rVar.a != null) {
            for (String str : rVar.a.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) rVar.a.get(str));
            }
        }
        if (SpdyRequest.POST_METHOD.equals(rVar.c) || "PUT".equals(rVar.c) || "PATCH".equals(rVar.c)) {
            httpURLConnection.setRequestMethod(rVar.c);
            if (rVar.d != null) {
                httpURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(rVar.d);
                dataOutputStream.close();
            }
        } else if (TextUtils.isEmpty(rVar.c)) {
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
        } else {
            httpURLConnection.setRequestMethod(rVar.c);
        }
        return httpURLConnection;
    }

    static /* synthetic */ String b(InputStream inputStream, i iVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] cArr = new char[2048];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                stringBuilder.append(cArr, 0, read);
                if (iVar != null) {
                    iVar.a(stringBuilder.length());
                }
            } else {
                bufferedReader.close();
                return stringBuilder.toString();
            }
        }
    }
}
