package com.uc.apollo.media.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;

@KeepForRuntime
/* compiled from: ProGuard */
public class MediaPlayerService extends Service {
    private static final String TAG = "[MPSvc]ucmedia.MediaPlayerService";
    private BnMediaPlayerService mImpl;

    public MediaPlayerService() {
        Settings.setIsSvcProcess();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public IBinder onBind(Intent intent) {
        String stringExtra = intent.getStringExtra("dex.path");
        String stringExtra2 = intent.getStringExtra("odex.path");
        new StringBuilder("onBind, dexPath: ").append(stringExtra).append(", odexPath: ").append(stringExtra2).append(", libPath: ").append(intent.getStringExtra("lib.path")).append(", intent ").append(intent);
        this.mImpl = new BnMediaPlayerService();
        return this.mImpl;
    }

    public void onRebind(Intent intent) {
        new StringBuilder("onRebind, intent ").append(intent);
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        new StringBuilder("onUnbind, intent ").append(intent);
        if (this.mImpl != null) {
            this.mImpl.onUnbind();
        }
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
        BnMediaPlayerService.init(getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
