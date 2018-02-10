package com.uc.apollo.media.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.uc.apollo.annotation.KeepForSdk;
import java.util.Iterator;

@KeepForSdk
/* compiled from: ProGuard */
public interface SurfaceProvider {

    /* compiled from: ProGuard */
    public interface a {
        void onSurfaceInfo(int i, int i2);
    }

    /* compiled from: ProGuard */
    public abstract class b implements SurfaceProvider {
        protected i a = new i();
        private int b = -1;
        private int c = -1;
        private int d = 0;
        private int e = 17;
        private boolean f = true;

        abstract void a();

        abstract void b();

        public int getWidth() {
            return asView().getWidth();
        }

        public int getHeight() {
            return asView().getHeight();
        }

        public void addListener(SurfaceListener surfaceListener) {
            a();
            this.a.add(surfaceListener);
        }

        public void removeListener(SurfaceListener surfaceListener) {
            this.a.remove(surfaceListener);
            b();
        }

        public void addSurfaceListener(Object obj) {
            a();
            this.a.a(obj);
        }

        public void removeSurfaceListener(Object obj) {
            this.a.b(obj);
            b();
        }

        public void show() {
            showNormal();
        }

        public void hide() {
            asView().setVisibility(4);
        }

        public void showMini() {
            if (asView() != null) {
                LayoutParams layoutParams = asView().getLayoutParams();
                if (layoutParams != null && this.f) {
                    this.f = false;
                    this.b = layoutParams.width;
                    this.c = layoutParams.height;
                    layoutParams.width = 2;
                    layoutParams.height = 2;
                    if (layoutParams instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        this.d = layoutParams2.leftMargin;
                        this.e = layoutParams2.gravity;
                        layoutParams2.leftMargin = -4;
                        layoutParams2.gravity = 51;
                    }
                    if (asView().getParent() != null) {
                        asView().getParent().requestLayout();
                    }
                }
            }
        }

        public void showNormal() {
            if (asView() != null) {
                LayoutParams layoutParams = asView().getLayoutParams();
                if (!this.f) {
                    this.f = true;
                    if (layoutParams != null) {
                        layoutParams.width = this.b;
                        layoutParams.height = this.c;
                        if (layoutParams instanceof FrameLayout.LayoutParams) {
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                            layoutParams2.leftMargin = this.d;
                            layoutParams2.gravity = this.e;
                        }
                        if (asView().getParent() != null) {
                            asView().getParent().requestLayout();
                        }
                    }
                }
                asView().setVisibility(0);
            }
        }

        public void clear() {
        }

        public void setVideoSize(int i, int i2) {
        }

        public boolean execCommand(int i, int i2, int i3, Object obj) {
            return false;
        }

        public void setOnInfoListener(a aVar) {
        }
    }

    /* compiled from: ProGuard */
    public final class c extends b implements Callback {
        private SurfaceView b;

        public c(Context context) {
            this.b = new SurfaceView(context);
            this.b.getHolder().setFormat(1);
        }

        public final View asView() {
            return this.b;
        }

        public final void a() {
            if (this.a.size() == 0) {
                this.b.getHolder().addCallback(this);
            }
        }

        public final void b() {
            if (this.a.size() == 0) {
                this.b.getHolder().removeCallback(this);
            }
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceChanged(surfaceHolder.getSurface(), i, i2, i3);
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceCreated(surfaceHolder.getSurface());
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceDestroyed(surfaceHolder.getSurface());
            }
        }

        public final void showMini() {
            asView().setVisibility(4);
        }
    }

    /* compiled from: ProGuard */
    public final class d extends b implements SurfaceTextureListener {
        private TextureView b;
        private Surface c;

        public d(Context context) {
            this.b = new TextureView(context);
        }

        public final View asView() {
            return this.b;
        }

        public final void a() {
            if (this.a.size() == 0) {
                this.b.setSurfaceTextureListener(this);
            }
        }

        public final void b() {
            if (this.a.size() == 0) {
                this.b.setSurfaceTextureListener(null);
            }
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.c = new Surface(surfaceTexture);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceCreated(this.c);
            }
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceDestroyed(this.c);
            }
            this.c = null;
            return true;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceChanged(this.c, 1, i, i2);
            }
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    void addListener(SurfaceListener surfaceListener);

    void addSurfaceListener(Object obj);

    View asView();

    void clear();

    boolean execCommand(int i, int i2, int i3, Object obj);

    int getHeight();

    int getWidth();

    void hide();

    void removeListener(SurfaceListener surfaceListener);

    void removeSurfaceListener(Object obj);

    void setOnInfoListener(a aVar);

    void setVideoSize(int i, int i2);

    void show();

    void showMini();

    void showNormal();
}
