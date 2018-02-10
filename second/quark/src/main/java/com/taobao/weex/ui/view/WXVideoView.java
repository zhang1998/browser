package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.mini.support.annotation.Nullable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.utils.af;

/* compiled from: ProGuard */
public final class WXVideoView extends VideoView implements c {
    private b a;
    private u b;

    /* compiled from: ProGuard */
    public class Wrapper extends FrameLayout implements OnGlobalLayoutListener {
        public WXVideoView a;
        private ProgressBar b;
        private MediaController c;
        private Uri d;
        private OnPreparedListener e;
        private OnErrorListener f;
        private OnCompletionListener g;
        private u h;

        public Wrapper(Context context) {
            super(context);
            a(context);
        }

        public Wrapper(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context);
        }

        public Wrapper(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            a(context);
        }

        private void a(Context context) {
            setBackgroundColor(af.a("#ee000000"));
            this.b = new ProgressBar(context);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.b.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(this.b);
            getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public ProgressBar getProgressBar() {
            return this.b;
        }

        @Nullable
        public WXVideoView getVideoView() {
            return this.a;
        }

        @Nullable
        public MediaController getMediaController() {
            return this.c;
        }

        public void setVideoURI(Uri uri) {
            this.d = uri;
            if (this.a != null) {
                this.a.setVideoURI(uri);
            }
        }

        public final void a() {
            if (this.a != null) {
                this.a.start();
            }
        }

        public void setOnErrorListener(OnErrorListener onErrorListener) {
            this.f = onErrorListener;
            if (this.a != null) {
                this.a.setOnErrorListener(onErrorListener);
            }
        }

        public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
            this.e = onPreparedListener;
            if (this.a != null) {
                this.a.setOnPreparedListener(onPreparedListener);
            }
        }

        public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
            this.g = onCompletionListener;
            if (this.a != null) {
                this.a.setOnCompletionListener(onCompletionListener);
            }
        }

        public void setOnVideoPauseListener(u uVar) {
            this.h = uVar;
            if (this.a != null) {
                this.a.setOnVideoPauseListener(uVar);
            }
        }

        public final synchronized void b() {
            if (this.a == null) {
                Context context = getContext();
                WXVideoView wXVideoView = new WXVideoView(context);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                wXVideoView.setLayoutParams(layoutParams);
                addView(wXVideoView, 0);
                wXVideoView.setOnErrorListener(this.f);
                wXVideoView.setOnPreparedListener(this.e);
                wXVideoView.setOnCompletionListener(this.g);
                wXVideoView.setOnVideoPauseListener(this.h);
                MediaController mediaController = new MediaController(context);
                mediaController.setAnchorView(this);
                wXVideoView.setMediaController(mediaController);
                mediaController.setMediaPlayer(wXVideoView);
                this.c = mediaController;
                this.a = wXVideoView;
                if (this.d != null) {
                    setVideoURI(this.d);
                }
            }
        }

        public final boolean c() {
            Rect rect = new Rect();
            if (this.a != null) {
                return true;
            }
            if (!getGlobalVisibleRect(rect) || rect.isEmpty()) {
                return false;
            }
            b();
            return true;
        }

        public void onGlobalLayout() {
            if (!c()) {
                return;
            }
            if (VERSION.SDK_INT >= 16) {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    public WXVideoView(Context context) {
        super(context);
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    public final void setOnVideoPauseListener(u uVar) {
        this.b = uVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.a != null) {
            return onTouchEvent | this.a.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public final void start() {
        super.start();
        if (this.b != null) {
            this.b.b();
        }
    }

    public final void pause() {
        super.pause();
        if (this.b != null) {
            this.b.a();
        }
    }
}
