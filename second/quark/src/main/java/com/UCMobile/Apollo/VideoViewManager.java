package com.UCMobile.Apollo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ProGuard */
public class VideoViewManager extends BroadcastReceiver {
    private static String d = "VideoViewManager";
    int a = 0;
    Context b;
    a c = null;

    /* compiled from: ProGuard */
    final class a extends TimerTask {
        final /* synthetic */ VideoViewManager a;
        private WeakReference<VideoView> b = null;
        private Timer c = null;

        public a(VideoViewManager videoViewManager, VideoView videoView) {
            this.a = videoViewManager;
            this.b = new WeakReference(videoView);
            this.c = new Timer();
            this.c.schedule(this, 600000);
        }

        public final void a() {
            if (this.c != null) {
                this.c.cancel();
                this.c = null;
                this.b = null;
            }
        }

        public final VideoView b() {
            if (this.b != null) {
                return (VideoView) this.b.get();
            }
            return null;
        }

        public final void run() {
            new StringBuilder("TimerTask run ").append(b());
            if (b() != null) {
                b().release(true);
                a();
            }
        }
    }

    VideoViewManager(Context context) {
        this.b = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        context.registerReceiver(this, intentFilter);
        b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
        r4 = this;
        r1 = 0;
        r4.a = r1;
        monitor-enter(r4);
        r0 = r4.b;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r4);	 Catch:{ all -> 0x0018 }
    L_0x0009:
        return;
    L_0x000a:
        r0 = r4.b;	 Catch:{ all -> 0x0018 }
        r2 = "connectivity";
        r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x0018 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x001b;
    L_0x0016:
        monitor-exit(r4);	 Catch:{ all -> 0x0018 }
        goto L_0x0009;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        monitor-exit(r4);	 Catch:{ all -> 0x0018 }
        r2 = r0.getActiveNetworkInfo();
        if (r2 == 0) goto L_0x0028;
    L_0x0022:
        r3 = r2.isConnected();
        if (r3 != 0) goto L_0x0058;
    L_0x0028:
        r3 = r0.getAllNetworkInfo();
        if (r3 == 0) goto L_0x0058;
    L_0x002e:
        r0 = r1;
    L_0x002f:
        r1 = r3.length;
        if (r0 >= r1) goto L_0x0058;
    L_0x0032:
        r1 = r3[r0];
        if (r1 == 0) goto L_0x004d;
    L_0x0036:
        r1 = r3[r0];
        r1 = r1.isConnected();
        if (r1 == 0) goto L_0x004d;
    L_0x003e:
        r0 = r3[r0];
    L_0x0040:
        if (r0 == 0) goto L_0x0009;
    L_0x0042:
        r0 = r0.getType();
        switch(r0) {
            case 0: goto L_0x0050;
            case 1: goto L_0x0054;
            default: goto L_0x0049;
        };
    L_0x0049:
        r0 = 1;
        r4.a = r0;
        goto L_0x0009;
    L_0x004d:
        r0 = r0 + 1;
        goto L_0x002f;
    L_0x0050:
        r0 = 2;
        r4.a = r0;
        goto L_0x0009;
    L_0x0054:
        r0 = 3;
        r4.a = r0;
        goto L_0x0009;
    L_0x0058:
        r0 = r2;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.UCMobile.Apollo.VideoViewManager.b():void");
    }

    public void onReceive(Context context, Intent intent) {
        b();
        new StringBuilder("onReceive ").append(this.a);
        if (this.a == 2) {
            VideoView videoView = null;
            synchronized (this) {
                if (this.c != null) {
                    this.c.a();
                    videoView = this.c.b();
                }
            }
            if (videoView != null) {
                videoView.release(true);
            }
        }
    }

    public final void a() {
        synchronized (this) {
            if (this.c != null) {
                this.c.a();
                this.c = null;
            }
        }
    }
}
