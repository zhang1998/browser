package com.uc.quark.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.uc.quark.filedownloader.e.j;
import java.lang.ref.WeakReference;

@SuppressLint({"Registered"})
/* compiled from: ProGuard */
public class FileDownloadService extends Service {
    private q a;

    /* compiled from: ProGuard */
    public class SeparateProcessService extends FileDownloadService {
    }

    public void onCreate() {
        super.onCreate();
        this.a = new d(new WeakReference(this));
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (j.a) {
            String str = "vanda";
            StringBuilder stringBuilder = new StringBuilder("onStartCommand intent ------> ");
            if (intent != null) {
                intent = intent.getAction();
            }
            Log.e(str, stringBuilder.append(intent).toString());
        }
        return 1;
    }

    public void onDestroy() {
        this.a.h();
        this.a.f();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        if (j.a) {
            String str = "vanda";
            StringBuilder stringBuilder = new StringBuilder("onBind intent ------> ");
            if (intent != null) {
                intent = intent.getAction();
            }
            Log.e(str, stringBuilder.append(intent).toString());
        }
        return this.a.g();
    }
}
