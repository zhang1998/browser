package com.uc.apollo.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.uc.apollo.android.SystemUtils;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.DataSourceFD;
import com.uc.apollo.media.impl.DataSourceURI;

/* compiled from: ProGuard */
final class a extends VideoView {
    protected FrameLayout a;
    int b;
    int c;
    boolean d;
    float e;
    boolean f;
    VideoView g;
    private BroadcastReceiver h;
    private int i;

    /* compiled from: ProGuard */
    final class a extends BroadcastReceiver {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                this.a.mMediaView.getController().pause();
            }
        }
    }

    /* compiled from: ProGuard */
    final class b extends FrameLayout {
        final /* synthetic */ a a;

        public b(a aVar, Context context) {
            this.a = aVar;
            super(context);
            setBackgroundColor(-16777216);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public a(Context context, VideoView videoView, int i, boolean z, boolean z2) {
        super(context, z2, Integer.valueOf(i).intValue());
        this.h = new a();
        this.b = 0;
        this.c = 0;
        this.e = 0.0f;
        this.mLogTag = "ucmedia.widget.FullScreenVideoView" + sNextInstanceIndex;
        this.d = z;
        this.g = videoView;
        this.mDefaultFullScreenExecutor = new b(this);
        this.mMediaView.setFullScreenExecutor(this.mDefaultFullScreenExecutor);
        setContentDescription("FullScreenVideoView");
    }

    public final boolean isFullScreen() {
        return true;
    }

    protected final void a(int i) {
        if (!this.f) {
            if (i == -1) {
                i = getVideoHeight() <= getVideoWidth() ? 6 : 7;
            }
            if (this.g != null) {
                this.g.mMediaView.hide();
            }
            this.f = true;
            Context a = SystemUtils.a(getContext());
            Window window = a.getWindow();
            this.b = window.getAttributes().flags;
            this.c = window.getDecorView().getSystemUiVisibility();
            this.i = a.getRequestedOrientation();
            Window window2 = a.getWindow();
            if (window2 != null) {
                this.e = window2.getAttributes().screenBrightness;
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.a = new b(this, a);
            this.a.addView(this, layoutParams);
            this.a.setBackgroundColor(-16777216);
            ((FrameLayout) window.getDecorView()).addView(this.a, layoutParams);
            a.setRequestedOrientation(i);
            window.clearFlags(2048);
            window.setFlags(1024, 1024);
            int i2 = 1284;
            if (VERSION.SDK_INT >= 19) {
                i2 = 5894;
            }
            window.getDecorView().setSystemUiVisibility(i2);
            getListener().onEnterFullScreen(true);
            MediaPlayer mediaPlayer = this.mMediaView.getMediaPlayer();
            if (mediaPlayer != null) {
                DataSource dataSource = mediaPlayer.getDataSource();
                if (dataSource instanceof DataSourceURI) {
                    DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
                    getListener().onSetDataSource(dataSourceURI.title, dataSourceURI.pageUri, dataSourceURI.uri, dataSourceURI.headers);
                } else if (dataSource instanceof DataSourceFD) {
                    DataSourceFD dataSourceFD = (DataSourceFD) dataSource;
                    getListener().onSetDataSource(dataSourceFD.fd, dataSourceFD.offset, dataSourceFD.length);
                }
                if (mediaPlayer.prepared()) {
                    getListener().onPrepared(mediaPlayer.getDuration(), mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                }
            }
            requestFocus();
            if (this.d) {
                getListener().onStart();
            }
            getContext().registerReceiver(this.h, new IntentFilter("android.intent.action.SCREEN_OFF"));
        }
    }

    protected final void a() {
        if (this.f) {
            try {
                getContext().unregisterReceiver(this.h);
            } catch (Throwable th) {
            }
            this.f = false;
            Activity a = SystemUtils.a(getContext());
            Window window = a.getWindow();
            FrameLayout frameLayout = (FrameLayout) window.getDecorView();
            a.setRequestedOrientation(this.i);
            Window window2 = a.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.screenBrightness = this.e;
            window2.setAttributes(attributes);
            this.mMediaView.getController().destroy();
            frameLayout.removeView(this.a);
            this.a = null;
            window.getDecorView().setSystemUiVisibility(this.c);
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.flags = this.b;
            window.setAttributes(attributes2);
            if (this.g != null) {
                this.g.mMediaView.show();
                this.g.getListener().onEnterFullScreen(false);
            }
            getListener().onEnterFullScreen(false);
        }
    }
}
