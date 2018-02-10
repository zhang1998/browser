package com.uc.apollo.media.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayerController;
import com.uc.apollo.media.MediaPlayerListener;
import com.uc.apollo.media.c;
import com.uc.apollo.media.impl.B;
import com.uc.apollo.media.impl.D;
import com.uc.apollo.util.f;
import java.lang.ref.WeakReference;

@KeepForRuntime
/* compiled from: ProGuard */
public interface MediaView {

    /* compiled from: ProGuard */
    public abstract class a extends FrameLayout implements MediaView {
        private static int b = 2;
        protected String a = "";
        private com.uc.apollo.a.a c;
        private a d;
        private int e;
        private WeakReference<MediaPlayer> f;
        private MediaPlayerController g = null;
        private c h = new c();
        private MediaPlayerListener i = new d(this);

        protected abstract SurfaceProvider b();

        public a(String str, Context context, int i) {
            super(context);
            Settings.init(context);
            this.a = str + b;
            b++;
            this.e = i;
            new StringBuilder("created, domId ").append(f.a(i));
            this.h.a(this.i);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            if (this.c != null) {
                this.c.b();
            }
        }

        public int getDomId() {
            return this.e;
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(this.a);
        }

        public View asView() {
            return this;
        }

        public MediaPlayerController getController() {
            if (this.g == null) {
                this.g = new com.uc.apollo.media.a();
            }
            return this.g;
        }

        public void setController(MediaPlayerController mediaPlayerController) {
            this.g = mediaPlayerController;
        }

        public void setMediaPlayerController(Object obj) {
            new StringBuilder("setMediaPlayerController ").append(obj);
            if (obj == null) {
                this.g = null;
            } else if (obj instanceof MediaPlayerController) {
                this.g = (MediaPlayerController) obj;
            } else {
                this.g = com.uc.apollo.media.MediaPlayerController.a.a(obj);
                com.uc.apollo.media.MediaPlayerController.a.a(obj, this.g);
            }
        }

        public final c a() {
            return this.h;
        }

        public void addListener(MediaPlayerListener mediaPlayerListener) {
            this.h.a(mediaPlayerListener);
        }

        public void removeListener(MediaPlayerListener mediaPlayerListener) {
            this.h.b(mediaPlayerListener);
        }

        public void addMediaPlayerListener(Object obj) {
            this.h.a(obj);
        }

        public void removeMediaPlayerListener(Object obj) {
            this.h.b(obj);
        }

        public boolean setOption(String str, String str2) {
            boolean a = D.a(this.e, str, str2);
            new StringBuilder("setOption(").append(str).append(", ").append(str2).append(") result: ").append(a);
            return a;
        }

        public MediaPlayer getMediaPlayer() {
            MediaPlayer mediaPlayer = null;
            if (this.f != null) {
                mediaPlayer = (MediaPlayer) this.f.get();
            }
            if (mediaPlayer == null) {
                B a = D.a(this.e);
                if (a != null) {
                    mediaPlayer = a.d();
                    if (mediaPlayer != null) {
                        this.f = new WeakReference(mediaPlayer);
                    }
                }
            }
            return mediaPlayer;
        }

        public int getMediaPlayerClientCount() {
            MediaPlayer mediaPlayer = getMediaPlayer();
            return mediaPlayer != null ? mediaPlayer.getMediaPlayerClientCount() : 0;
        }

        public void show() {
            b().show();
        }

        public void showMini() {
            b().showMini();
        }

        public void showNormal() {
            b().showNormal();
        }

        public void hide() {
            b().hide();
        }

        public void clear() {
            b().clear();
        }

        public void setFullScreenExecutor(a aVar) {
            this.d = aVar;
        }

        public void setFullScreenExecutor(Object obj) {
            new StringBuilder("setFullScreenExecutor ").append(obj);
            if (obj instanceof a) {
                this.d = (a) obj;
            } else {
                this.d = com.uc.apollo.media.widget.a.a.a(obj);
            }
        }

        public a getFullScreenExecutor() {
            return this.d;
        }

        public void addSurfaceListener(SurfaceListener surfaceListener) {
            b().addListener(surfaceListener);
        }

        public void removeSurfaceListener(SurfaceListener surfaceListener) {
            b().removeListener(surfaceListener);
        }

        public void addSurfaceListener(Object obj) {
            b().addSurfaceListener(obj);
        }

        public void removeSurfaceListener(Object obj) {
            b().removeSurfaceListener(obj);
        }

        public void setVideoSize(int i, int i2) {
            b().setVideoSize(i, i2);
        }

        public boolean execCommand(int i, int i2, int i3, Object obj) {
            return b().execCommand(i, i2, i3, obj);
        }

        public /* bridge */ /* synthetic */ MediaPlayerListener getListener() {
            return this.h;
        }
    }

    /* compiled from: ProGuard */
    public final class b extends a {
        private SurfaceProvider b;

        b(Context context, int i, boolean z) {
            super(c.a + "MediaViewSimpleImpl", context, i);
            this.b = j.a(getContext(), z);
            addView(this.b.asView(), new LayoutParams(-2, -2, 17));
        }

        protected final SurfaceProvider b() {
            return this.b;
        }
    }

    void addListener(MediaPlayerListener mediaPlayerListener);

    void addMediaPlayerListener(Object obj);

    void addSurfaceListener(SurfaceListener surfaceListener);

    void addSurfaceListener(Object obj);

    View asView();

    void clear();

    boolean execCommand(int i, int i2, int i3, Object obj);

    MediaPlayerController getController();

    int getDomId();

    a getFullScreenExecutor();

    int getHeight();

    MediaPlayerListener getListener();

    MediaPlayer getMediaPlayer();

    int getMediaPlayerClientCount();

    int getWidth();

    void hide();

    void removeListener(MediaPlayerListener mediaPlayerListener);

    void removeMediaPlayerListener(Object obj);

    void removeSurfaceListener(SurfaceListener surfaceListener);

    void removeSurfaceListener(Object obj);

    void setController(MediaPlayerController mediaPlayerController);

    void setFullScreenExecutor(a aVar);

    void setFullScreenExecutor(Object obj);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);

    void setMediaPlayerController(Object obj);

    boolean setOption(String str, String str2);

    void setVideoSize(int i, int i2);

    void show();

    void showMini();

    void showNormal();
}
