package com.ucpro.services.location;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.uc.encrypt.a;
import com.uc.encrypt.f;
import com.ucpro.services.location.a.b;
import com.ucpro.services.location.a.c;
import com.ucweb.common.util.h.m;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class j {
    private static volatile j b;
    UcLocation a;
    private Handler c;
    private final List<Message> d = new ArrayList();
    private c e = new b(this);

    private j() {
    }

    public static j a() {
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    b = new j();
                }
            }
        }
        return b;
    }

    private void b() {
        synchronized (this.d) {
            this.d.clear();
        }
    }

    final void a(Message message) {
        if (this.c == null) {
            synchronized (this.d) {
                this.d.add(message);
            }
            m.a(new b("location", "com.amap.api.location.AMapLocation", this.e));
            return;
        }
        this.c.sendMessage(message);
    }

    static String a(String str) {
        if (str != null) {
            try {
                byte[] a = f.a(str.getBytes("UTF-8"), a.a);
                if (a != null) {
                    return com.ucpro.b.b.a.a(a);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    static boolean b(String str) {
        if (str != null) {
            try {
                new URL(str).getHost();
            } catch (MalformedURLException e) {
            }
        }
        return true;
    }

    static /* synthetic */ void a(j jVar) {
        try {
            jVar.c = (Handler) Class.forName("com.ucpro.services.location.LocationDex").getConstructor(new Class[]{Looper.class}).newInstance(new Object[]{Looper.getMainLooper()});
            synchronized (jVar.d) {
                for (Message sendMessage : jVar.d) {
                    jVar.c.sendMessage(sendMessage);
                }
                jVar.d.clear();
            }
        } catch (Exception e) {
            jVar.b();
        }
    }
}
