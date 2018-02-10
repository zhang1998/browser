package com.ucpro.services.f;

import com.ucpro.c.b;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

/* compiled from: ProGuard */
public class g {
    private static OkHttpClient a;

    private static OkHttpClient b() {
        synchronized (g.class) {
            if (a == null) {
                Builder readTimeout = new Builder().connectTimeout(15000, TimeUnit.MILLISECONDS).readTimeout(30000, TimeUnit.MILLISECONDS);
                if (b.b()) {
                    Interceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(Level.BASIC);
                    readTimeout.addInterceptor(httpLoggingInterceptor);
                }
                try {
                    SSLContext instance = SSLContext.getInstance("SSL");
                    instance.init(null, new TrustManager[]{com.uc.quark.filedownloader.e.b.f()}, new SecureRandom());
                    readTimeout.sslSocketFactory(instance.getSocketFactory(), r3);
                    readTimeout.hostnameVerifier(com.uc.quark.filedownloader.e.b.g());
                } catch (Exception e) {
                }
                a = readTimeout.build();
            }
        }
        return a;
    }

    public static OkHttpClient a() {
        return a == null ? b() : a;
    }
}
