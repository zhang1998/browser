package com.uc.apollo.media.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.MediaPlayerController;
import com.uc.apollo.media.MediaPlayerListener;
import com.uc.apollo.media.service.d;
import com.uc.apollo.util.f;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public class MediaPlayerClient {
    public static final int INVALID_CLIENT_ID = -1;
    public static final int LITTLE_WIN_ID = 1;
    private static final int VIDEO_CAPTURE_ERROR_MSG = 100;
    private static final int VIDEO_CAPTURE_TIMEOUT_MSG = 101;
    private static MediaPlayerClient sLittleWinInstance;
    protected static int sNextInstanceIndex = 2;
    private String mBrief;
    private MediaPlayerController mController;
    private int mCurrentPosition;
    private Rect mCurrentVideoFramemDestRect;
    private boolean mDoNotUseAutioFocusLIstener;
    private int mDomID;
    private int mDuration;
    protected B mHolder;
    private final int mID;
    private boolean mIsVideo;
    protected float mLeftVolume;
    private String mLogTag;
    private MediaPlayerListener mMediaPlayerListener;
    protected float mRightVolume;
    private Handler mVideoFrameCaptureHandler;
    private boolean mVisible;
    private boolean mWaitingCurrentVideoFrame;

    /* compiled from: ProGuard */
    final class a extends Handler {
        private final WeakReference<MediaPlayerClient> a;

        public a(MediaPlayerClient mediaPlayerClient) {
            this.a = new WeakReference(mediaPlayerClient);
        }

        public final void handleMessage(Message message) {
            MediaPlayerClient mediaPlayerClient = (MediaPlayerClient) this.a.get();
            if (message != null && mediaPlayerClient != null) {
                switch (message.what) {
                    case 100:
                    case 101:
                        if (mediaPlayerClient.mWaitingCurrentVideoFrame) {
                            if (mediaPlayerClient.mMediaPlayerListener != null) {
                                Rect rect = new Rect(0, 0, 0, 0);
                                mediaPlayerClient.mMediaPlayerListener.onMessage(64, 0, new Object[]{rect, rect, null});
                            }
                            mediaPlayerClient.mWaitingCurrentVideoFrame = false;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static int nextClientID() {
        int i = sNextInstanceIndex;
        sNextInstanceIndex = i + 1;
        while (true) {
            if (i != 1 && i != -1) {
                return i;
            }
            i = sNextInstanceIndex;
            sNextInstanceIndex = i + 1;
        }
    }

    public MediaPlayerClient(boolean z, int i) {
        this(z, nextClientID(), i);
    }

    private MediaPlayerClient(boolean z, int i, int i2) {
        this.mDomID = -1;
        this.mVisible = true;
        this.mDuration = SectionHeader.SHT_LOUSER;
        this.mCurrentPosition = 0;
        this.mWaitingCurrentVideoFrame = false;
        this.mVideoFrameCaptureHandler = null;
        this.mCurrentVideoFramemDestRect = null;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mID = i;
        this.mIsVideo = z;
        this.mDomID = i2;
        this.mBrief = e.a + getClass().getSimpleName() + this.mID + "/" + f.a(i2);
        this.mLogTag = this.mBrief;
        createHolder();
        if (prepared()) {
            this.mDuration = this.mHolder.x();
        }
    }

    public int getID() {
        return this.mID;
    }

    public int getDomID() {
        return this.mDomID;
    }

    public void setGroupID(int i) {
        if (this.mHolder != null) {
            this.mHolder.b(i);
        }
    }

    public void setVisibility(boolean z) {
        this.mVisible = z;
        if (this.mHolder != null) {
            new StringBuilder("setVisibility - ").append(z).append(", id ").append(getID());
            this.mHolder.a(this, z);
        }
    }

    public boolean getVisibility() {
        return this.mVisible;
    }

    void changeDomID(int i) {
        new StringBuilder("changeDomID, old/new ").append(f.a(this.mDomID)).append("/").append(f.a(i));
        this.mBrief = e.a + "MediaPlayerClient" + this.mID + "/" + f.a(i);
        this.mDomID = i;
    }

    private void attach(int i) {
        if (this.mDomID == i) {
            Log.w(this.mLogTag, "ignore attach command: try to attach same MediaPlayer, domID " + i);
            return;
        }
        if (!(i == -1 || this.mDomID == -1 || this.mHolder == null)) {
            this.mHolder.r();
        }
        detach();
        changeDomID(i);
        createHolder();
    }

    private void createHolder() {
        this.mHolder = D.a(this, this.mIsVideo, this.mDomID);
        if (this.mHolder.G() != 0) {
            this.mLogTag = this.mBrief + "(" + this.mHolder.G() + ")";
        }
        if (this.mDoNotUseAutioFocusLIstener) {
            this.mHolder.H();
        }
        if (this.mHolder.f() == null) {
            setFront();
        }
        if (this.mLeftVolume >= 0.0f && this.mRightVolume >= 0.0f) {
            setVolume(this.mLeftVolume, this.mRightVolume);
        }
    }

    private void detach() {
        if (this.mHolder != null) {
            new StringBuilder("detach from ").append(this.mDomID);
            destroy();
        }
    }

    public Uri getUri() {
        return this.mHolder == null ? null : this.mHolder.l();
    }

    public void setTitleAndPageUri(String str, String str2) {
        if (this.mHolder != null) {
            this.mHolder.a(str, str2);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public void destroy() {
        if (this.mHolder != null) {
            B b = this.mHolder;
            this.mHolder = null;
            boolean z = false;
            if (isFront()) {
                z = b.v();
                if (z) {
                    b.r();
                }
            }
            D.a(this, b);
            if (z && b.b() > 0) {
                MediaPlayerClient f = b.f();
                if (f == null || !f.getVisibility()) {
                    b.t();
                } else if (f.getSurface() != null) {
                    b.o();
                } else {
                    b.t();
                }
            }
            this.mDomID = -1;
        }
    }

    MediaPlayerController getControllerInClient() {
        return this.mController;
    }

    public MediaPlayerController getController() {
        return this.mHolder == null ? null : this.mHolder.e();
    }

    public void setController(MediaPlayerController mediaPlayerController) {
        this.mController = mediaPlayerController;
    }

    public void setMediaPlayerController(Object obj) {
        if (obj == null) {
            this.mController = null;
        } else if (obj instanceof MediaPlayerController) {
            this.mController = (MediaPlayerController) obj;
        } else {
            this.mController = com.uc.apollo.media.MediaPlayerController.a.a(obj);
        }
    }

    public void setListener(MediaPlayerListener mediaPlayerListener) {
        this.mMediaPlayerListener = mediaPlayerListener;
    }

    public void setMediaPlayerListener(Object obj) {
        if (obj == null) {
            this.mMediaPlayerListener = null;
        } else if (obj instanceof MediaPlayerListener) {
            this.mMediaPlayerListener = (MediaPlayerListener) obj;
        } else {
            this.mMediaPlayerListener = com.uc.apollo.media.MediaPlayerListener.a.a(obj);
        }
    }

    public boolean prepared() {
        return this.mHolder != null ? this.mHolder.w() : false;
    }

    public B getHolder() {
        return this.mHolder;
    }

    private g getMediaPlayer() {
        return this.mHolder != null ? this.mHolder.k() : null;
    }

    public F state() {
        return this.mHolder != null ? this.mHolder.i() : F.IDLE;
    }

    public void onVideoSizeChanged(int i, int i2) {
        new StringBuilder("onVideoSizeChanged - width/height ").append(i).append("/").append(i2);
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onVideoSizeChanged(i, i2);
        }
    }

    public void onSeekComplete() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onSeekComplete();
        }
    }

    public void onPrepared(int i, int i2, int i3) {
        new StringBuilder("onPrepared - duration/width/height ").append(f.b(i)).append("/").append(i2).append("/").append(i3);
        this.mDuration = i;
        this.mCurrentPosition = 0;
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onPrepared(i, i2, i3);
        }
    }

    public void onDurationChanged(int i) {
        new StringBuilder("onDurationChanged - from/to ").append(f.b(this.mDuration)).append("/").append(f.b(i));
        this.mDuration = i;
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onDurationChanged(i);
        }
    }

    public boolean onError(int i, int i2) {
        new StringBuilder("onError - ").append(d.a(this.mHolder != null ? this.mHolder.G() : 0, i, i2));
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onError(i, i2);
        }
        reset();
        return true;
    }

    public boolean onInfo(int i, int i2) {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onInfo(i, i2);
        }
        return true;
    }

    public void onCompletion() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onCompletion();
        }
    }

    public void onMessage(int i, int i2, Object obj) {
        if (i == 75) {
            if (sLittleWinInstance != null && sLittleWinInstance.getHolder() != null && !sLittleWinInstance.getHolder().equals(getHolder())) {
                if (this.mIsVideo) {
                    exitLittleWinAnyway();
                } else if (sLittleWinInstance.mHolder != null) {
                    sLittleWinInstance.mHolder.t();
                } else {
                    sLittleWinInstance.pause();
                }
            }
        } else if (i == 64) {
            Bitmap bitmap = (Bitmap) obj;
            Rect rect;
            if (bitmap == null && this.mWaitingCurrentVideoFrame) {
                rect = new Rect(0, 0, 0, 0);
                Rect rect2 = new Rect(0, 0, 0, 0);
                if (this.mMediaPlayerListener != null) {
                    this.mMediaPlayerListener.onMessage(i, 0, new Object[]{rect, rect2, null});
                }
            } else if (this.mWaitingCurrentVideoFrame) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                if (this.mCurrentVideoFramemDestRect != null && this.mCurrentVideoFramemDestRect.width() != 0 && this.mCurrentVideoFramemDestRect.height() != 0) {
                    try {
                        new Canvas(Bitmap.createBitmap(this.mCurrentVideoFramemDestRect.width(), this.mCurrentVideoFramemDestRect.height(), Config.ARGB_8888)).drawBitmap(bitmap, rect, this.mCurrentVideoFramemDestRect, null);
                        if (this.mMediaPlayerListener != null) {
                            this.mMediaPlayerListener.onMessage(i, 0, new Object[]{this.mCurrentVideoFramemDestRect, rect, r1});
                        }
                    } catch (OutOfMemoryError e) {
                    } catch (Exception e2) {
                    }
                } else if (this.mMediaPlayerListener != null) {
                    this.mMediaPlayerListener.onMessage(i, 0, new Object[]{this.mCurrentVideoFramemDestRect, rect, bitmap});
                }
            }
            if (this.mVideoFrameCaptureHandler != null) {
                this.mVideoFrameCaptureHandler.removeMessages(101);
            }
            this.mWaitingCurrentVideoFrame = false;
        } else if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onMessage(i, i2, obj);
        }
    }

    public void start() {
        if (this.mHolder != null) {
            this.mHolder.o();
        }
    }

    public boolean isPlaying() {
        return this.mHolder != null ? this.mHolder.v() : false;
    }

    public void pause() {
        if (this.mHolder != null) {
            this.mHolder.s();
        }
    }

    public void stop() {
        if (this.mHolder != null) {
            this.mHolder.u();
        }
    }

    public void setAudioStreamType(int i) {
        if (this.mHolder != null) {
            B.A();
        }
    }

    public DataSource getDataSource() {
        return this.mHolder != null ? this.mHolder.j() : null;
    }

    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        setDataSource(context, uri, null, null, null);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map, String str, String str2) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        DataSource dataSource = null;
        if (uri != null && f.b(uri.toString().trim())) {
            dataSource = new DataSourceURI(str2, str, uri, map);
        }
        setDataSourceImpl(context, dataSource);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalArgumentException, IllegalStateException, IOException {
        DataSource dataSource = null;
        if (fileDescriptor != null) {
            dataSource = new DataSourceFD(fileDescriptor, j, j2);
        }
        setDataSourceImpl(Settings.getContext(), dataSource);
    }

    private void setDataSourceImpl(Context context, DataSource dataSource) throws IllegalArgumentException, IllegalStateException, IOException {
        if (this.mHolder != null) {
            this.mHolder.a(this, context, dataSource);
            this.mDuration = SectionHeader.SHT_LOUSER;
            this.mCurrentPosition = 0;
            this.mLogTag = this.mBrief + "(" + this.mHolder.G() + ")";
        }
    }

    public int getMediaPlayerClientCount() {
        return this.mHolder == null ? 0 : this.mHolder.b();
    }

    public void prepareAsync() throws IllegalStateException {
        if (this.mHolder != null) {
            this.mDuration = SectionHeader.SHT_LOUSER;
            this.mCurrentPosition = 0;
            this.mHolder.F();
        }
    }

    public boolean release() {
        if (this.mHolder == null) {
            return true;
        }
        if (this.mHolder.b() > 1) {
            return false;
        }
        D.a(this, this.mHolder);
        this.mHolder = null;
        this.mDuration = SectionHeader.SHT_LOUSER;
        return true;
    }

    public void seekTo(int i) throws IllegalStateException {
        this.mCurrentPosition = i;
        if (this.mHolder != null) {
            new StringBuilder("seekTo ").append(f.b(i));
            this.mHolder.a(this, i);
        }
    }

    public int getCurrentPosition() {
        if (this.mHolder != null) {
            this.mCurrentPosition = this.mHolder.B();
        }
        return this.mCurrentPosition;
    }

    public void getCurrentVideoFrameAsync(Rect rect, int i) {
        if (this.mVideoFrameCaptureHandler == null) {
            this.mVideoFrameCaptureHandler = new a(this);
        }
        if (i < 0 || this.mHolder == null) {
            this.mVideoFrameCaptureHandler.sendEmptyMessageDelayed(100, 100);
            return;
        }
        this.mHolder.C();
        this.mCurrentVideoFramemDestRect = rect;
        this.mWaitingCurrentVideoFrame = true;
        if (i > 0) {
            this.mVideoFrameCaptureHandler.sendEmptyMessageDelayed(101, (long) i);
        }
    }

    public Bitmap getCurrentVideoFrameSync() {
        if (this.mHolder == null) {
            return null;
        }
        return this.mHolder.D();
    }

    public void setSurface(Surface surface) {
        if (this.mHolder != null) {
            new StringBuilder("setSurface - ").append(surface).append(", id ").append(getID());
            this.mHolder.a(this, surface);
        }
    }

    public void moveSurfaceTo(MediaPlayerClient mediaPlayerClient) {
        g mediaPlayer = getMediaPlayer();
        g mediaPlayer2 = mediaPlayerClient.getMediaPlayer();
        if (mediaPlayer != null && mediaPlayer2 != null) {
            new StringBuilder("moveSurfaceTo - ").append(mediaPlayerClient);
            mediaPlayer.a(getID(), mediaPlayer2, mediaPlayerClient.getID());
        }
    }

    public void setVolume(float f, float f2) {
        this.mLeftVolume = f;
        this.mRightVolume = f2;
        if (this.mHolder != null) {
            new StringBuilder("setVolume - left/right ").append(f).append("/").append(f2);
            this.mHolder.a(f, f2);
        }
    }

    public int getVideoWidth() {
        return this.mHolder != null ? this.mHolder.z() : 0;
    }

    public int getVideoHeight() {
        return this.mHolder != null ? this.mHolder.y() : 0;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void reset() {
        if (this.mHolder != null) {
            this.mHolder.e(this);
            this.mDuration = SectionHeader.SHT_LOUSER;
        }
    }

    public void setFront() {
        if (this.mHolder != null) {
            this.mHolder.c(this);
        }
    }

    Surface getSurface() {
        return this.mHolder == null ? null : this.mHolder.d(this);
    }

    public boolean isFront() {
        return (this.mHolder == null || this.mHolder.f() == null) ? false : this.mHolder.f().equals(this);
    }

    public boolean hadAttachedToLittleWindow() {
        return (sLittleWinInstance == null || sLittleWinInstance.getHolder() == null || !sLittleWinInstance.getHolder().equals(getHolder())) ? false : true;
    }

    public void detachFromLittleWindow() {
        if (hadAttachedToLittleWindow() && !equals(sLittleWinInstance)) {
            destroy();
            D.b(sLittleWinInstance.mDomID);
        }
    }

    public void enterLittleWin(int i, int i2, int i3, int i4) {
        enterLittleWin(i, i2, i3, i4, 0);
    }

    public void enterLittleWin(int i, int i2, int i3, int i4, int i5) {
        if (!hadAttachedToLittleWindow()) {
            if (sLittleWinInstance == null) {
                sLittleWinInstance = new MediaPlayerClient(this.mIsVideo, 1, this.mDomID);
            } else {
                sLittleWinInstance.attach(this.mDomID);
            }
            if (i3 == 0 || i4 == 0) {
                sLittleWinInstance.setFront();
            }
        }
        if (i3 != 0 && i4 != 0) {
            d.a(i, i2, i3, i4, false, i5);
            sLittleWinInstance.setFront();
        }
    }

    public void exitLittleWin() {
        if (hadAttachedToLittleWindow()) {
            exitLittleWinAnyway();
        }
    }

    public void moveToScreen(int i, int i2, int i3, int i4, boolean z) {
        d.a(i, i2, i3, i4, z, 0);
    }

    public static void exitLittleWinAnyway() {
        if (sLittleWinInstance != null) {
            d.c();
            sLittleWinInstance.destroy();
        }
    }

    public void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onSetDataSource(str, str2, uri, map);
        }
    }

    public void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onSetDataSource(fileDescriptor, j, j2);
        }
    }

    void onPrepareBegin() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onPrepareBegin();
        }
    }

    void onStart() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onStart();
        }
    }

    void onPause() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onPause();
        }
    }

    void onStop() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onStop();
        }
    }

    void onRelease() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onRelease();
        }
    }

    void onReset() {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onReset();
        }
    }

    void onSeekTo(int i) {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onSeekTo(i);
        }
    }

    void onHadAttachedToLittleWindow(boolean z) {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onMessage(51, z ? 1 : 0, null);
        }
    }

    void onBuddyCountHadChanged(int i) {
        if (this.mMediaPlayerListener != null) {
            this.mMediaPlayerListener.onMessage(70, i, null);
        }
    }

    public int getBuddyCount() {
        return this.mHolder != null ? this.mHolder.b() - 1 : 0;
    }

    public String toString() {
        return this.mLogTag;
    }

    public boolean setOption(String str, String str2) {
        if (this.mHolder != null) {
            return this.mHolder.b(str, str2);
        }
        return false;
    }

    public String getOption(String str) {
        if (this.mHolder != null) {
            return this.mHolder.a(str);
        }
        return null;
    }

    public void doNotUseAudioFocusListener() {
        this.mDoNotUseAutioFocusLIstener = true;
        if (this.mHolder != null) {
            this.mHolder.H();
        }
    }

    public Object[] getSourceInfo() {
        DataSource dataSource = getDataSource();
        if (!(dataSource instanceof DataSourceURI)) {
            return null;
        }
        DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
        return new Object[]{dataSourceURI.title, dataSourceURI.pageUri, dataSourceURI.uri, dataSourceURI.headers};
    }
}
