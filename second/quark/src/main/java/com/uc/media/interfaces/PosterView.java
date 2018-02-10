package com.uc.media.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.uc.webview.export.annotations.Jni;
import java.lang.ref.WeakReference;
import java.util.List;

@Jni
/* compiled from: ProGuard */
public class PosterView extends View {
    private static final String LOGTAG = "PosterView";
    private static int mThreadID = 0;
    private DrawThread drawThread;
    private boolean drawThreadExit;
    private List<ImageFrame> mImageFrameList;
    private boolean mLayoutValid;
    private Bitmap mPoster;
    private MyHandler mRedrawHandler;

    /* compiled from: ProGuard */
    class DrawThread extends Thread {
        private WeakReference<PosterView> mOwner;

        public DrawThread(String str, PosterView posterView) {
            super(str);
            this.mOwner = new WeakReference(posterView);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void run() {
            /*
            r6 = this;
            monitor-enter(r6);
            r0 = r6.mOwner;	 Catch:{ all -> 0x0076 }
            r0 = r0.get();	 Catch:{ all -> 0x0076 }
            r0 = (com.uc.media.interfaces.PosterView) r0;	 Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x000d;
        L_0x000b:
            monitor-exit(r6);
            return;
        L_0x000d:
            r1 = r0.mImageFrameList;	 Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x000b;
        L_0x0013:
            r1 = r0.mImageFrameList;	 Catch:{ all -> 0x0076 }
            r1 = r1.size();	 Catch:{ all -> 0x0076 }
            r2 = 1;
            if (r1 <= r2) goto L_0x000b;
        L_0x001e:
            r1 = r0.drawThreadExit;	 Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x0052;
        L_0x0024:
            r1 = 0;
            r2 = r1;
        L_0x0026:
            r1 = r0.mImageFrameList;	 Catch:{ Exception -> 0x0051 }
            r1 = r1.size();	 Catch:{ Exception -> 0x0051 }
            if (r2 >= r1) goto L_0x001e;
        L_0x0030:
            r1 = r0.mImageFrameList;	 Catch:{ Exception -> 0x0051 }
            r1 = r1.get(r2);	 Catch:{ Exception -> 0x0051 }
            r1 = (com.uc.media.interfaces.PosterView.ImageFrame) r1;	 Catch:{ Exception -> 0x0051 }
            r3 = r1.mBitmap;	 Catch:{ Exception -> 0x0051 }
            r0.mPoster = r3;	 Catch:{ Exception -> 0x0051 }
            r3 = r0.mPoster;	 Catch:{ Exception -> 0x0051 }
            if (r3 == 0) goto L_0x004d;
        L_0x0045:
            r0.reDraw();	 Catch:{ Exception -> 0x0051 }
            r4 = r1.delayTime;	 Catch:{ Exception -> 0x0051 }
            android.os.SystemClock.sleep(r4);	 Catch:{ Exception -> 0x0051 }
        L_0x004d:
            r1 = r2 + 1;
            r2 = r1;
            goto L_0x0026;
        L_0x0051:
            r0 = move-exception;
        L_0x0052:
            com.uc.media.interfaces.PosterView.access$406();	 Catch:{ Exception -> 0x0074 }
            r0 = "PosterView";
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0074 }
            r2 = "GIF draw thread [";
            r1.<init>(r2);	 Catch:{ Exception -> 0x0074 }
            r2 = com.uc.media.interfaces.PosterView.mThreadID;	 Catch:{ Exception -> 0x0074 }
            r1 = r1.append(r2);	 Catch:{ Exception -> 0x0074 }
            r2 = "] exit.";
            r1 = r1.append(r2);	 Catch:{ Exception -> 0x0074 }
            r1 = r1.toString();	 Catch:{ Exception -> 0x0074 }
            android.util.Log.e(r0, r1);	 Catch:{ Exception -> 0x0074 }
            goto L_0x000b;
        L_0x0074:
            r0 = move-exception;
            goto L_0x000b;
        L_0x0076:
            r0 = move-exception;
            monitor-exit(r6);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.media.interfaces.PosterView.DrawThread.run():void");
        }
    }

    @Jni
    /* compiled from: ProGuard */
    public class ImageFrame {
        long delayTime = 0;
        int height = 0;
        Bitmap mBitmap = null;
        int width = 0;

        ImageFrame() {
        }
    }

    /* compiled from: ProGuard */
    class MyHandler extends Handler {
        private WeakReference<PosterView> mOwner;

        public MyHandler(PosterView posterView) {
            this.mOwner = new WeakReference(posterView);
        }

        public void handleMessage(Message message) {
            PosterView posterView = (PosterView) this.mOwner.get();
            if (posterView != null) {
                posterView.invalidate();
            }
        }
    }

    static /* synthetic */ int access$406() {
        int i = mThreadID - 1;
        mThreadID = i;
        return i;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
        Log.e(LOGTAG, "finalize: PosterView destructor.");
    }

    public void destroy() {
        this.drawThreadExit = true;
        if (this.mRedrawHandler != null) {
            this.mRedrawHandler.removeCallbacksAndMessages(null);
            this.mRedrawHandler = null;
        }
        this.drawThread = null;
        this.mImageFrameList = null;
        this.mPoster = null;
    }

    public PosterView(Context context) {
        super(context);
        this.mPoster = null;
        this.mLayoutValid = false;
        this.drawThread = null;
        this.drawThreadExit = true;
        this.mImageFrameList = null;
        this.mRedrawHandler = new MyHandler(this);
        this.drawThreadExit = true;
    }

    public PosterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PosterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPoster = null;
        this.mLayoutValid = false;
        this.drawThread = null;
        this.drawThreadExit = true;
        this.mImageFrameList = null;
        this.mRedrawHandler = new MyHandler(this);
        this.drawThreadExit = true;
    }

    public synchronized void setImageDrawable(Drawable drawable) {
        this.mPoster = drawable2Bitmap(drawable);
        if (this.mPoster == null) {
            Log.e(LOGTAG, "setImageDrawable error : drawable bitmap is null");
        } else {
            reDraw();
        }
    }

    public synchronized void setFrameData(List<ImageFrame> list) {
        if (list == null) {
            Log.e(LOGTAG, "setFrameData error : Image frame list is null.");
        } else {
            this.mImageFrameList = list;
            if (1 == this.mImageFrameList.size()) {
                this.drawThreadExit = true;
                if (this.drawThread != null) {
                    this.drawThread = null;
                }
                ImageFrame imageFrame = (ImageFrame) this.mImageFrameList.get(0);
                if (imageFrame != null && imageFrame.mBitmap != null && imageFrame.width > 0 && imageFrame.height > 0) {
                    if (imageFrame.mBitmap.getWidth() <= 0 || imageFrame.mBitmap.getHeight() <= 0) {
                        Log.e(LOGTAG, "invalid poster image Bitmap: " + imageFrame.width + " X " + imageFrame.height);
                    } else {
                        this.mPoster = imageFrame.mBitmap;
                        this.mImageFrameList = null;
                        new StringBuilder("set poster: ").append(this.mPoster.getWidth()).append(" X ").append(this.mPoster.getHeight());
                        reDraw();
                    }
                }
            } else if (this.drawThread == null) {
                this.drawThreadExit = false;
                StringBuilder stringBuilder = new StringBuilder("DrawThread");
                int i = mThreadID;
                mThreadID = i + 1;
                this.drawThread = new DrawThread(stringBuilder.append(i).toString(), this);
                this.drawThread.start();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        float f = 0.0f;
        super.onDraw(canvas);
        if (!this.mLayoutValid) {
            Log.e(LOGTAG, "layout is invalid.");
        } else if (this.mPoster == null) {
            Log.e(LOGTAG, "current poster Image is null.");
        } else {
            float width = ((float) getWidth()) / ((float) this.mPoster.getWidth());
            float height = ((((float) this.mPoster.getHeight()) / ((float) this.mPoster.getWidth())) * ((float) getWidth())) / ((float) this.mPoster.getHeight());
            float round = (float) Math.round(((float) this.mPoster.getHeight()) * height);
            float height2 = (float) getHeight();
            if (height2 > round) {
                f = ((height2 - round) / 2.0f) / height;
            }
            new StringBuilder("ratiox: ").append(width).append("; ratioy: ").append(height);
            new StringBuilder("Bitmap source: ").append(this.mPoster.getWidth()).append(" X ").append(this.mPoster.getHeight()).append("; After transformation: ").append(Math.round(((float) this.mPoster.getWidth()) * width)).append(" X ").append(round);
            Paint paint = new Paint();
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            try {
                canvas.scale(width, height);
                canvas.drawBitmap(this.mPoster, 0.0f, f, paint);
            } catch (Exception e) {
            }
            canvas.restoreToCount(saveCount);
        }
    }

    protected void onMeasure(int i, int i2) {
        int paddingTop = (getPaddingTop() + getPaddingBottom()) + 1;
        setMeasuredDimension(resolveSize(Math.max((getPaddingLeft() + getPaddingRight()) + 1, getSuggestedMinimumWidth()), i), resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        String.format("on Layout: changed %s position: (%d,%d,%d,%d)", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        this.mLayoutValid = true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == i3 && i2 == i4) && i >= 10 && i2 >= 10) {
            new StringBuilder("onSizeChanged : ").append(i3).append(" X ").append(i4).append(" ----> ").append(i).append(" X ").append(i2);
            reDraw();
        }
    }

    private Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable == null) {
            Log.e(LOGTAG, "convert Drawable to Bitmap error : drawable is null.");
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private synchronized void reDraw() {
        if (this.mRedrawHandler != null) {
            this.mRedrawHandler.sendMessage(this.mRedrawHandler.obtainMessage());
        }
    }
}
