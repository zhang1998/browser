package com.ucpro.feature.video;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class MediaPlayerService extends Service {
    private boolean a;
    private Constructor<?> b;
    private Method c;
    private Method d;
    private IBinder e;

    private static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader == null) {
            return Class.forName(str);
        }
        try {
            return Class.forName(str, false, classLoader);
        } catch (Exception e) {
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = null;
        if (!this.a) {
            ClassLoader dexClassLoader;
            Class a;
            this.a = true;
            String stringExtra = intent.getStringExtra("dex.path");
            String stringExtra2 = intent.getStringExtra("odex.path");
            String stringExtra3 = intent.getStringExtra("lib.path");
            if (stringExtra == null || stringExtra.length() == 0 || stringExtra2 == null || stringExtra2.length() == 0) {
                Object obj = iBinder;
            } else {
                File file = new File(stringExtra2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                dexClassLoader = new DexClassLoader(stringExtra, stringExtra2, stringExtra3, MediaPlayerService.class.getClassLoader());
            }
            Class a2 = a("com.uc.apollo.media.service.BnMediaPlayerService", dexClassLoader);
            if (a2 == null) {
                a = a("com.uc.media.service.BnMediaPlayerService", dexClassLoader);
            } else {
                a = a2;
            }
            if (a != null) {
                try {
                    this.b = a.getDeclaredConstructor(new Class[0]);
                    this.b.setAccessible(true);
                    try {
                        this.c = a.getMethod("init", new Class[]{Context.class});
                        this.c.setAccessible(true);
                        try {
                            this.d = a.getMethod("onUnbind", new Class[0]);
                            this.d.setAccessible(true);
                            if (this.c != null) {
                                try {
                                    this.c.invoke(null, new Object[]{getApplicationContext()});
                                } catch (Exception e) {
                                }
                            }
                        } catch (Throwable th) {
                        }
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                }
            }
        }
        if (this.b == null) {
            return iBinder;
        }
        try {
            this.e = (IBinder) this.b.newInstance(new Object[0]);
            return this.e;
        } catch (Exception e2) {
            return iBinder;
        }
    }

    public boolean onUnbind(Intent intent) {
        if (this.e != null) {
            if (this.d != null) {
                try {
                    this.d.invoke(this.e, new Object[0]);
                } catch (Throwable th) {
                }
            }
            this.e = null;
        }
        return super.onUnbind(intent);
    }
}
