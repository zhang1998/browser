package com.uc.base.wa.component;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.uc.base.wa.a.c;
import com.uc.base.wa.x;
import java.util.HashMap;

/* compiled from: ProGuard */
public class WaStatService extends IntentService {
    private static j a = new j();
    private static k b = new k();
    private boolean c = false;

    public WaStatService() {
        super("StatService");
    }

    public void onCreate() {
        super.onCreate();
        this.c = true;
        if (!this.c) {
            a();
        }
    }

    public void a() {
        x.a();
        stopSelf();
    }

    protected void onHandleIntent(Intent intent) {
        if (!this.c) {
            return;
        }
        if (intent == null) {
            a();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Context b = c.b();
            c a = c.a();
            if (a instanceof k) {
                a = b.b;
            }
            b.b = a;
            b.c = extras.getString("savedDir");
            b.d = extras.getString("uuid");
            b.e = extras.getStringArray("urls");
            b.f = (HashMap) extras.getSerializable("publicHead");
            c.a(b, b);
        }
        x.a(1, 1, new i(this));
    }
}
