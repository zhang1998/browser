package com.uc.apollo.media.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.media.MediaDefines;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayerController;
import com.uc.apollo.media.MediaPlayerListener;
import com.uc.apollo.media.base.e;
import com.uc.apollo.media.base.g;
import com.uc.apollo.media.c;
import com.uc.apollo.media.impl.B;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.DataSourceFD;
import com.uc.apollo.media.impl.DataSourceURI;
import com.uc.apollo.media.impl.F;
import com.uc.apollo.media.impl.MediaPlayerClient;
import com.uc.apollo.util.f;
import com.uc.imagecodec.export.IPictureView;
import java.io.FileDescriptor;
import java.util.Map;

@KeepForSdk
/* compiled from: ProGuard */
public class MediaViewImpl extends FrameLayout implements MediaView, com.uc.apollo.media.widget.SurfaceProvider.a {
    private static final int VIEW_AND_VIDEO_MIN_HEIGHT_DIFF = 2;
    private static final int VIEW_AND_VIDEO_MIN_WIDTH_DIFF = 2;
    private static final float VIEW_AND_VIDEO_WH_RATIO_MIN_DIFF = 0.1f;
    private static final int VIEW_FOR_VIDEO_MIN_HEIGHT = 10;
    private static final int VIEW_FOR_VIDEO_MIN_WIDTH = 10;
    protected static int sNextInstanceIndex = 2;
    private int mDomId;
    protected int mDuration = 0;
    private a mFullScreenExecutor;
    private Map<String, String> mHttpHeader;
    private b mInnerListener = new b(this, this.mLogTag);
    private boolean mIsFullScreen;
    private int mLittleWindowStyle = -1;
    private String mLogTag = (c.a + "MediaViewImpl");
    protected MediaPlayer mMediaPlayer;
    private boolean mOnDestroiedState;
    private boolean mOnPreparedFired;
    private boolean mOnPreparedPending;
    protected c mOuterListeners = new c();
    private boolean mPlayByNative = false;
    private com.uc.apollo.a.a mPowerSaveBlocker;
    private Surface mSurface;
    private SurfaceListener mSurfaceListener = new g(this);
    private j mSurfaceProvider;
    private LayoutParams mSurfaceViewLayoutParams;
    private Uri mUri;
    private boolean mUserWantToStart;
    private MediaPlayerController mVideoController = new a();
    protected int mVideoHeight = 0;
    protected int mVideoWidth = 0;

    /* compiled from: ProGuard */
    final class a implements MediaPlayerController {
        final /* synthetic */ MediaViewImpl a;
        private Object b;

        private a(MediaViewImpl mediaViewImpl) {
            this.a = mediaViewImpl;
        }

        public final void setVideoURI(Uri uri, Map<String, String> map) {
            this.a.setVideoURI(uri, map);
        }

        public final void setTitleAndPageURI(String str, String str2) {
            this.a.setTitleAndPageUri(str, str2);
        }

        public final void prepareAsync() {
            this.a.prepareAsync();
        }

        public final void start() {
            this.a.start();
        }

        public final void pause() {
            this.a.pause();
        }

        public final void stop() {
            this.a.stop();
        }

        public final void seekTo(int i) {
            this.a.seekTo(i);
        }

        public final void enterFullScreen(boolean z) {
            this.a.mLogTag;
            if (this.a.mFullScreenExecutor == null) {
                return;
            }
            if (z) {
                this.a.mFullScreenExecutor.a(-1);
            } else {
                this.a.mFullScreenExecutor.a();
            }
        }

        public final void enterLittleWin() {
            enterLittleWin(0, 0, 0, 0);
        }

        public final void enterLittleWin(int i, int i2, int i3, int i4) {
            enterLittleWin(i, i2, i3, i4, 0);
        }

        public final void enterLittleWin(int i, int i2, int i3, int i4, int i5) {
            this.a.enterLittleWin(i, i2, i3, i4, i5);
        }

        public final void exitLittleWin(int i) {
            this.a.exitLittleWin(i);
        }

        public final void destroy() {
            this.a.destroy();
        }

        public final boolean isPlaying() {
            return this.a.isPlaying();
        }

        public final boolean isFullScreen() {
            return this.a.mIsFullScreen;
        }

        public final int getDuration() {
            return this.a.getDuration();
        }

        public final int getCurrentPosition() {
            return this.a.getCurrentPosition();
        }

        public final int getVideoWidth() {
            return this.a.getVideoWidth();
        }

        public final int getVideoHeight() {
            return this.a.getVideoHeight();
        }

        public final void getCurrentVideoFrame(Rect rect, int i) {
            this.a.getCurrentVideoFrame(rect, i);
        }

        public final Bitmap getCurrentVideoFrame() {
            return this.a.getCurrentVideoFrameSync();
        }

        public final boolean execCommand(int i, int i2, int i3, Object obj) {
            return this.a.mSurfaceProvider.execCommand(i, i2, i3, obj);
        }

        public final Object getSibling() {
            return this.b;
        }

        public final void setSibling(Object obj) {
            this.b = obj;
        }
    }

    /* compiled from: ProGuard */
    final class b implements MediaPlayerListener {
        final /* synthetic */ MediaViewImpl a;
        private String b;
        private Object c;

        b(MediaViewImpl mediaViewImpl, String str) {
            this.a = mediaViewImpl;
            this.b = str;
        }

        public final void onVideoSizeChanged(int i, int i2) {
            if (this.a.mVideoWidth != i || this.a.mVideoHeight != i2) {
                this.a.mVideoWidth = i;
                this.a.mVideoHeight = i2;
                this.a.updateSurfaceViewSize();
            }
        }

        public final void onSeekComplete() {
            this.a.mOuterListeners.onSeekComplete();
        }

        public final void onPrepared(int i, int i2, int i3) {
            this.a.onPrepared(i, i2, i3);
            this.a.mOuterListeners.onMessage(53, 0, null);
        }

        public final void onDurationChanged(int i) {
            this.a.onDurationChanged(i);
        }

        public final void onError(int i, int i2) {
            this.a.onError(i, i2);
            this.a.mPowerSaveBlocker.b();
        }

        public final void onInfo(int i, int i2) {
            this.a.onInfo(i, i2);
        }

        public final void onCompletion() {
            this.a.mOuterListeners.onCompletion();
            this.a.mPowerSaveBlocker.b();
        }

        public final void onPrepareBegin() {
            this.a.mOuterListeners.onMessage(52, 0, null);
        }

        public final void onStart() {
            this.a.mOuterListeners.onStart();
            this.a.mPowerSaveBlocker.a();
        }

        public final void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
            this.a.mOuterListeners.onSetDataSource(str, str2, uri, map);
            this.a.mOnPreparedFired = false;
        }

        public final void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
            this.a.mOuterListeners.onSetDataSource(fileDescriptor, j, j2);
            this.a.mOnPreparedFired = false;
        }

        public final void onSeekTo(int i) {
            this.a.mOuterListeners.onSeekTo(i);
        }

        public final void onStop() {
            onPause();
        }

        public final void onReset() {
            this.a.mOuterListeners.onReset();
            onPause();
        }

        public final void onRelease() {
            this.a.mOuterListeners.onRelease();
            onPause();
        }

        public final void onPause() {
            this.a.mOuterListeners.onPause();
            this.a.mUserWantToStart = false;
            this.a.mPowerSaveBlocker.b();
        }

        public final void onEnterFullScreen(boolean z) {
            this.a.mIsFullScreen = z;
            this.a.mOuterListeners.onEnterFullScreen(z);
        }

        public final void onMessage(int i, int i2, Object obj) {
            this.a.mOuterListeners.onMessage(i, i2, obj);
        }

        public final Object getSibling() {
            return this.c;
        }

        public final void setSibling(Object obj) {
            this.c = obj;
        }
    }

    public MediaViewImpl(Context context) {
        super(context);
        init(-1);
    }

    public MediaViewImpl(Context context, int i) {
        super(context);
        init(i);
    }

    public MediaViewImpl(Context context, int i, boolean z) {
        super(context);
        this.mPlayByNative = z;
        init(i);
    }

    public int getDomId() {
        return this.mDomId;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(this.mLogTag);
    }

    private void init(int i) {
        this.mLogTag += sNextInstanceIndex;
        sNextInstanceIndex++;
        this.mInnerListener.b = this.mLogTag;
        Settings.init(getContext());
        this.mOnPreparedFired = false;
        this.mDomId = i;
        if (g.a(this.mDomId)) {
            this.mDomId = g.a();
        }
        this.mSurfaceProvider = j.a(getContext(), e.b());
        this.mSurfaceProvider.setOnInfoListener(this);
        this.mSurfaceProvider.addListener(this.mSurfaceListener);
        this.mSurfaceViewLayoutParams = new LayoutParams(-1, -1, 17);
        addView(this.mSurfaceProvider.asView(), this.mSurfaceViewLayoutParams);
        this.mPowerSaveBlocker = new com.uc.apollo.a.a(this);
        createMediaPlayer();
    }

    protected void finalize() throws Throwable {
        destroyMediaPlayer();
        super.finalize();
    }

    public View asView() {
        return this;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateSurfaceViewSize();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        if (this.mOnDestroiedState) {
            destroyMediaPlayer();
            resetLayout();
        }
        super.onDetachedFromWindow();
    }

    private void updateSurfaceViewSize() {
        int i = -1;
        int width = getWidth();
        int height = getHeight();
        if (this.mSurfaceViewLayoutParams != null && this.mVideoWidth > 0 && this.mVideoHeight > 0 && width > 0 && height > 0) {
            int i2;
            float f = (((float) width) * IPictureView.DEFAULT_MIN_SCALE) / ((float) height);
            float f2 = (((float) this.mVideoWidth) * IPictureView.DEFAULT_MIN_SCALE) / ((float) this.mVideoHeight);
            if ((width <= 10 && height <= 10) || Math.abs(f - f2) < VIEW_AND_VIDEO_WH_RATIO_MIN_DIFF) {
                i2 = -1;
            } else if (f >= f2) {
                i2 = (int) (((float) height) * f2);
                if (Math.abs(i2 - width) <= 2) {
                    i2 = -1;
                }
            } else {
                i2 = (int) (((float) width) / f2);
                if (Math.abs(i2 - height) <= 2) {
                    i2 = -1;
                } else {
                    int i3 = i2;
                    i2 = -1;
                    i = i3;
                }
            }
            if (i2 != this.mSurfaceViewLayoutParams.width || i != this.mSurfaceViewLayoutParams.height || this.mSurfaceViewLayoutParams.gravity != 17) {
                new StringBuilder("updateSurfaceViewSize, view w/h ").append(width).append("/").append(height).append("(").append(f).append(") video w/h ").append(this.mVideoWidth).append("/").append(this.mVideoHeight).append("(").append(f2).append(") layoutParams width/height ").append(i2).append("/").append(i);
                this.mSurfaceViewLayoutParams.gravity = 17;
                this.mSurfaceViewLayoutParams.width = i2;
                this.mSurfaceViewLayoutParams.height = i;
                new Handler().post(new e(this));
            }
        }
    }

    public void release() {
        this.mPowerSaveBlocker.b();
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
        }
    }

    private void destroy() {
        this.mOnDestroiedState = true;
        if (this.mMediaPlayer != null && getWindowToken() == null) {
            destroyMediaPlayer();
            resetLayout();
        }
    }

    private void destroyMediaPlayer() {
        if (this.mMediaPlayer != null) {
            this.mPowerSaveBlocker.b();
            deleteMediaPlayer();
        }
    }

    private void pauseMediaPlayer() {
        if (this.mMediaPlayer != null && this.mMediaPlayer.state() != F.IDLE) {
            MediaPlayerController controller = this.mMediaPlayer.getController();
            if (controller != null) {
                controller.pause();
            }
            this.mMediaPlayer.pause();
        }
    }

    public void show() {
        this.mSurfaceProvider.show();
    }

    public void hide() {
        this.mSurfaceProvider.hide();
    }

    public void showMini() {
        this.mSurfaceProvider.showMini();
    }

    public void showNormal() {
        this.mSurfaceProvider.showNormal();
    }

    public void clear() {
        this.mSurfaceProvider.clear();
    }

    public void setFullScreenExecutor(a aVar) {
        this.mFullScreenExecutor = aVar;
    }

    public void setFullScreenExecutor(Object obj) {
        if (obj instanceof a) {
            this.mFullScreenExecutor = (a) obj;
        } else {
            this.mFullScreenExecutor = com.uc.apollo.media.widget.a.a.a(obj);
        }
    }

    public a getFullScreenExecutor() {
        return this.mFullScreenExecutor;
    }

    private void deleteMediaPlayer() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setListener(null);
            this.mMediaPlayer.destroy();
            this.mMediaPlayer = null;
        }
    }

    private void changeDomId(int i) {
        MediaPlayerClient create = MediaPlayer.create(true, i);
        create.setFront();
        if (this.mMediaPlayer != null) {
            pause();
            this.mMediaPlayer.moveSurfaceTo(create);
            this.mMediaPlayer.setListener(null);
            this.mMediaPlayer.destroy();
        }
        this.mDomId = i;
        create.setListener(this.mInnerListener);
        this.mMediaPlayer = create;
    }

    private void createMediaPlayer() {
        int i = 0;
        this.mOnDestroiedState = false;
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = MediaPlayer.create(true, this.mDomId);
            if (this.mSurface != null) {
                this.mMediaPlayer.setSurface(this.mSurface);
            }
            this.mMediaPlayer.setFront();
            this.mMediaPlayer.setListener(this.mInnerListener);
            c cVar = this.mOuterListeners;
            if (this.mMediaPlayer.hadAttachedToLittleWindow()) {
                i = 1;
            }
            cVar.onMessage(51, i, null);
            B holder = this.mMediaPlayer.getHolder();
            if (holder.j() != null) {
                DataSource j = holder.j();
                if (j instanceof DataSourceURI) {
                    DataSourceURI dataSourceURI = (DataSourceURI) j;
                    this.mInnerListener.onSetDataSource(dataSourceURI.title, dataSourceURI.pageUri, dataSourceURI.uri, dataSourceURI.headers);
                } else if (j instanceof DataSourceFD) {
                    DataSourceFD dataSourceFD = (DataSourceFD) j;
                    this.mInnerListener.onSetDataSource(dataSourceFD.fd, dataSourceFD.offset, dataSourceFD.length);
                }
            }
            if (holder.i() == F.IDLE) {
                Log.w(this.mLogTag, "MediaPlayerHolder state is idle, dataSource is " + holder.j() + ", prepared " + holder.w());
            } else if (holder.w()) {
                this.mInnerListener.onStart();
                if (!this.mOnPreparedFired) {
                    this.mOuterListeners.onPrepared(holder.x(), holder.z(), holder.y());
                    this.mOnPreparedFired = true;
                }
                if (!this.mUserWantToStart) {
                    this.mInnerListener.onPause();
                }
                onPrepared(holder.x(), holder.z(), holder.y());
            }
        }
    }

    private boolean isPlaying() {
        return (this.mMediaPlayer == null || this.mMediaPlayer.state() != F.STARTED) ? false : this.mMediaPlayer.isPlaying();
    }

    private int getDuration() {
        return this.mDuration;
    }

    private int getVideoWidth() {
        return this.mVideoWidth;
    }

    private int getVideoHeight() {
        return this.mVideoHeight;
    }

    private int getCurrentPosition() {
        return this.mMediaPlayer != null ? this.mMediaPlayer.getCurrentPosition() : 0;
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            new StringBuilder("setUrl - url: ").append(uri);
        } else {
            new StringBuilder("setUrl - url: ").append(uri).append(", http header: ").append(f.a((Map) map));
        }
        this.mUri = uri;
        this.mHttpHeader = map;
        this.mOnPreparedPending = false;
        this.mOnPreparedFired = false;
        if (!(this.mMediaPlayer == null || uri == null)) {
            uri = Uri.parse(uri.toString().trim());
            if (uri.equals(this.mMediaPlayer.getUri())) {
                new StringBuilder("try to set same media uri: ").append(uri);
                this.mOnPreparedPending = true;
                return;
            }
            if (this.mMediaPlayer.getUri() != null) {
                new StringBuilder("try to change media uri to ").append(uri).append(", origin ").append(this.mMediaPlayer.getUri());
            }
            if (this.mPlayByNative && this.mMediaPlayer.getHolder().g() > 1 && !g.b(this.mDomId)) {
                changeDomId(g.a());
            }
        }
        Uri uri2 = uri;
        if (!(this.mMediaPlayer == null || this.mMediaPlayer.state() == F.IDLE)) {
            pause();
            this.mMediaPlayer.reset();
        }
        if (this.mMediaPlayer == null) {
            createMediaPlayer();
        }
        try {
            this.mMediaPlayer.setDataSource(getContext(), uri2, this.mHttpHeader, null, null);
        } catch (Exception e) {
            onError(-1, -1);
        }
    }

    private void setTitleAndPageUri(String str, String str2) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setTitleAndPageUri(str, str2);
        }
    }

    public void start() {
        if (this.mMediaPlayer == null) {
            if (this.mUri != null) {
                setVideoURI(this.mUri, this.mHttpHeader);
            } else {
                return;
            }
        }
        if (!(this.mSurfaceProvider == null || this.mSurfaceProvider.asView().getVisibility() == 0)) {
            this.mSurfaceProvider.asView().setVisibility(0);
        }
        MediaPlayerController controller = this.mMediaPlayer.getController();
        if (controller == null) {
            switch (this.mMediaPlayer.state()) {
                case COMPLETED:
                    this.mMediaPlayer.start();
                    break;
                case IDLE:
                    if (this.mMediaPlayer.getDataSource() != null) {
                        this.mMediaPlayer.prepareAsync();
                        this.mUserWantToStart = true;
                        this.mMediaPlayer.getHolder().p();
                        break;
                    }
                    break;
                case INITIALIZED:
                    this.mMediaPlayer.prepareAsync();
                    this.mUserWantToStart = true;
                    this.mMediaPlayer.getHolder().p();
                    break;
                case PAUSED:
                case PREPARED:
                    this.mMediaPlayer.start();
                    break;
                case PREPARING:
                    this.mUserWantToStart = true;
                    this.mMediaPlayer.getHolder().p();
                    break;
                case STARTED:
                    this.mOuterListeners.onStart();
                    break;
                default:
                    new StringBuilder("ignore start action, current MediaPlayer state is ").append(this.mMediaPlayer.state());
                    break;
            }
        }
        this.mMediaPlayer.start();
        controller.start();
        if (this.mOnPreparedPending) {
            this.mOnPreparedPending = false;
            if (this.mMediaPlayer.getHolder().w()) {
                new Handler().post(new f(this));
            }
        }
    }

    private void prepareAsync() {
        if (this.mMediaPlayer != null && this.mMediaPlayer.state() == F.INITIALIZED) {
            this.mMediaPlayer.prepareAsync();
        }
    }

    public void pause() {
        this.mUserWantToStart = false;
        if (this.mMediaPlayer != null) {
            MediaPlayerController controller = this.mMediaPlayer.getController();
            if (controller != null) {
                controller.pause();
            }
            this.mMediaPlayer.pause();
        }
    }

    public void seekTo(int i) {
        if (this.mMediaPlayer != null) {
            MediaPlayerController controller = this.mMediaPlayer.getController();
            if (controller != null) {
                controller.seekTo(i);
            } else {
                this.mMediaPlayer.seekTo(i);
            }
        }
    }

    protected void stop() {
        if (this.mMediaPlayer != null && this.mMediaPlayer.getHolder().g() <= 1) {
            reset();
        }
    }

    public void getCurrentVideoFrame(Rect rect, int i) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.getCurrentVideoFrameAsync(rect, i);
        }
    }

    public Bitmap getCurrentVideoFrameSync() {
        if (this.mMediaPlayer == null) {
            return null;
        }
        return this.mMediaPlayer.getCurrentVideoFrameSync();
    }

    private void setSurface(Surface surface) {
        this.mSurface = surface;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setSurface(this.mSurface);
            if (this.mUserWantToStart && this.mSurface != null) {
                start();
                return;
            }
            return;
        }
        pause();
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setSurface(null);
        }
    }

    private void onPrepared(int i, int i2, int i3) {
        this.mSurfaceProvider.setVideoSize(i2, i3);
        this.mDuration = i;
        if (!this.mOnPreparedFired) {
            this.mOuterListeners.onPrepared(i, i2, i3);
            this.mOnPreparedFired = true;
        }
        if (!(this.mVideoWidth == i2 && this.mVideoHeight == i3)) {
            this.mVideoWidth = i2;
            this.mVideoHeight = i3;
            updateSurfaceViewSize();
        }
        if (!this.mUserWantToStart) {
            this.mOuterListeners.onPause();
        } else if (this.mSurface != null) {
            this.mUserWantToStart = false;
            this.mMediaPlayer.start();
        } else {
            this.mOuterListeners.onPause();
        }
    }

    private void onDurationChanged(int i) {
        this.mDuration = i;
        this.mOuterListeners.onDurationChanged(i);
    }

    private void reset() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
        }
        this.mDuration = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mUserWantToStart = false;
        this.mOnPreparedPending = false;
        this.mOnPreparedFired = false;
    }

    private void resetLayout() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mSurfaceViewLayoutParams.width = -1;
        this.mSurfaceViewLayoutParams.height = -1;
        requestLayout();
    }

    private void onError(int i, int i2) {
        this.mOuterListeners.onMessage(53, 0, null);
        this.mOuterListeners.onError(i, i2);
        reset();
    }

    private void onInfo(int i, int i2) {
        this.mOuterListeners.onInfo(i, i2);
    }

    private void enterLittleWin(int i, int i2, int i3, int i4, int i5) {
        if (this.mMediaPlayer != null) {
            if (!hadAttachedToLittleWindow() || this.mLittleWindowStyle == i5) {
                this.mLittleWindowStyle = i5;
                this.mMediaPlayer.enterLittleWin(i, i2, i3, i4, i5);
            }
        }
    }

    public void exitLittleWin(int i) {
        if (!hadAttachedToLittleWindow() || this.mLittleWindowStyle == i) {
            this.mMediaPlayer.exitLittleWin();
        }
    }

    public void moveToScreen(int i, int i2, int i3, int i4, boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.moveToScreen(i, i2, i3, i4, z);
        }
    }

    public boolean hadAttachedToLittleWindow() {
        return this.mMediaPlayer.hadAttachedToLittleWindow();
    }

    public DataSource getDataSource() {
        return this.mMediaPlayer != null ? this.mMediaPlayer.getDataSource() : null;
    }

    public int getMediaPlayerClientCount() {
        return this.mMediaPlayer == null ? 0 : this.mMediaPlayer.getMediaPlayerClientCount();
    }

    public void setVideoSize(int i, int i2) {
        this.mSurfaceProvider.setVideoSize(i, i2);
    }

    public MediaPlayerController getController() {
        return this.mVideoController;
    }

    public void setController(MediaPlayerController mediaPlayerController) {
        this.mVideoController = mediaPlayerController;
    }

    public MediaPlayerListener getListener() {
        return this.mInnerListener;
    }

    public void addListener(MediaPlayerListener mediaPlayerListener) {
        this.mOuterListeners.a(mediaPlayerListener);
        if (mediaPlayerListener != null && this.mMediaPlayer != null) {
            mediaPlayerListener.onMessage(51, this.mMediaPlayer.hadAttachedToLittleWindow() ? 1 : 0, null);
        }
    }

    public void removeListener(MediaPlayerListener mediaPlayerListener) {
        this.mOuterListeners.b(mediaPlayerListener);
    }

    public void setMediaPlayerController(Object obj) {
        if (obj == null) {
            this.mVideoController = null;
        } else if (obj instanceof MediaPlayerController) {
            this.mVideoController = (MediaPlayerController) obj;
        } else {
            this.mVideoController = com.uc.apollo.media.MediaPlayerController.a.a(obj);
            com.uc.apollo.media.MediaPlayerController.a.a(obj, this.mVideoController);
        }
    }

    public void addMediaPlayerListener(Object obj) {
        MediaPlayerListener a = this.mOuterListeners.a(obj);
        if (a != null && this.mMediaPlayer != null) {
            a.onMessage(51, this.mMediaPlayer.hadAttachedToLittleWindow() ? 1 : 0, null);
        }
    }

    public void removeMediaPlayerListener(Object obj) {
        this.mOuterListeners.b(obj);
    }

    public boolean execCommand(int i, int i2, int i3, Object obj) {
        return this.mSurfaceProvider.execCommand(i, i2, i3, obj);
    }

    public boolean setOption(String str, String str2) {
        if (this.mMediaPlayer == null) {
            createMediaPlayer();
        }
        return this.mMediaPlayer.setOption(str, str2);
    }

    public void addSurfaceListener(SurfaceListener surfaceListener) {
        this.mSurfaceProvider.addListener(surfaceListener);
    }

    public void removeSurfaceListener(SurfaceListener surfaceListener) {
        this.mSurfaceProvider.removeListener(surfaceListener);
    }

    public void addSurfaceListener(Object obj) {
        this.mSurfaceProvider.addSurfaceListener(obj);
    }

    public void removeSurfaceListener(Object obj) {
        this.mSurfaceProvider.removeSurfaceListener(obj);
    }

    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    public void onSurfaceInfo(int i, int i2) {
        getListener().onMessage(i, i2, null);
        if (i == MediaDefines.MSG_ENABLE_VR_MODE && getMediaPlayer() != null) {
            getMediaPlayer().setOption("ro.instance.vr_mode", String.valueOf(i2));
        }
    }
}
