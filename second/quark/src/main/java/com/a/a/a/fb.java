package com.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.IOException;

/* compiled from: ProGuard */
public final class fb {
    public static String a(Context context) {
        try {
            return b(context).a;
        } catch (Exception e) {
            return null;
        }
    }

    private static fs b(Context context) throws Exception {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnection foVar = new fo();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, foVar, 1)) {
                try {
                    if (foVar.a) {
                        throw new IllegalStateException();
                    }
                    foVar.a = true;
                    fn fnVar = new fn((IBinder) foVar.b.take());
                    fs fsVar = new fs(fnVar.a(), fnVar.b());
                    context.unbindService(foVar);
                    return fsVar;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(foVar);
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
