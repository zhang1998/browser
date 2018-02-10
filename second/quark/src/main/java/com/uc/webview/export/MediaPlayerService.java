package com.uc.webview.export;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.Log;
import com.uc.webview.export.annotations.Reflection;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class MediaPlayerService extends Service {
    private static final String a = MediaPlayerService.class.getSimpleName();
    private Constructor<?> b;
    private Method c;
    private Method d;
    private IBinder e;

    private static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return Class.forName(str, false, classLoader);
            } catch (Exception e) {
                new StringBuilder("can not find class ").append(str).append(" in ").append(classLoader).append(", try to find in default class loader");
            }
        }
        try {
            try {
                Class.forName("com.uc.browser.media.dex.VideoDex");
            } catch (Exception e2) {
            }
            return Class.forName(str);
        } catch (Exception e3) {
            Log.e(a, "can not find class " + str + " in default class loader");
            return null;
        }
    }

    private boolean a(Intent intent) {
        ClassLoader classLoader = null;
        String stringExtra = intent.getStringExtra("dex.path");
        String stringExtra2 = intent.getStringExtra("odex.path");
        String stringExtra3 = intent.getStringExtra("lib.path");
        new StringBuilder().append(this).append("init, dexPath: ").append(stringExtra).append(", odexPath: ").append(stringExtra2).append(", libPath: ").append(stringExtra3);
        if (!(stringExtra == null || stringExtra.length() == 0 || stringExtra2 == null || stringExtra2.length() == 0)) {
            File file = new File(stringExtra2);
            if (!file.exists()) {
                file.mkdirs();
            }
            classLoader = new DexClassLoader(stringExtra, stringExtra2, stringExtra3, MediaPlayerService.class.getClassLoader());
            new StringBuilder("class loader ").append(classLoader);
        }
        Class a = a("com.uc.apollo.media.service.BnMediaPlayerService", classLoader);
        if (a == null) {
            return false;
        }
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
                            Log.e(a, "exec " + this.c + " failure: " + e);
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    Log.e(a, a + " has not onUnbind function");
                    return false;
                }
            } catch (Throwable th2) {
                Log.e(a, "init failure: can not find BnMediaPlayerService.init(Context) ");
                return false;
            }
        } catch (Throwable th3) {
            Log.e(a, a + " has not constructor function");
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        new StringBuilder("onBind, intent ").append(intent);
        if (!a(intent)) {
            return null;
        }
        if (this.b != null) {
            try {
                this.e = (IBinder) this.b.newInstance(new Object[0]);
                return this.e;
            } catch (Exception e) {
            }
        }
        return null;
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

    @Reflection
    public static Drawable getDrawable(String str) {
        return null;
    }
}
