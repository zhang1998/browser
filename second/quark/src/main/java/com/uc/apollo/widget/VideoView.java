package com.uc.apollo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import com.UCMobile.Apollo.text.SubtitleHelper;
import com.uc.apollo.Initializer;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayer.OnBufferingUpdateListener;
import com.uc.apollo.media.MediaPlayer.OnCompletionListener;
import com.uc.apollo.media.MediaPlayer.OnErrorListener;
import com.uc.apollo.media.MediaPlayer.OnPreparedListener;
import com.uc.apollo.media.MediaPlayer.OnSeekCompleteListener;
import com.uc.apollo.media.MediaPlayerController;
import com.uc.apollo.media.MediaPlayerListener;
import com.uc.apollo.media.service.d;
import com.uc.apollo.media.widget.MediaView;
import com.uc.apollo.media.widget.MediaViewFactory;
import com.uc.apollo.media.widget.MediaViewImpl;
import com.uc.apollo.media.widget.SurfaceListener;
import com.uc.apollo.media.widget.a;
import com.uc.apollo.util.ReflectUtil;
import com.uc.apollo.util.c;
import com.uc.apollo.widget.MediaController.MediaControllerFactory;
import com.uc.apollo.widget.MediaController.MediaPlayerControl;
import com.uc.apollo.widget.MediaController.b;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public class VideoView extends FrameLayout implements MediaPlayerControl {
    private static final String BRIEF = "ucmedia.widget.VideoView";
    private static final int PRELOAD_STATES_IDLE = 0;
    private static final int PRELOAD_STATES_PRELOADING = 1;
    private static final int PRELOAD_STATES_PRELOAD_FAILURE = 3;
    private static final int PRELOAD_STATES_PRELOAD_SUCCESS = 2;
    public static final int VIDEO_INFO_ATTACH_LITTLEWIN = 1007;
    public static final int VIDEO_INFO_CACHED_POSITIONS = 1012;
    public static final int VIDEO_INFO_ENTER_FULLSCREEN = 1001;
    public static final int VIDEO_INFO_ENTER_LITTLEWIN = 1002;
    public static final int VIDEO_INFO_LITTLEWIN_FULLSCREEN = 1009;
    public static final int VIDEO_INFO_ON_DESTROY = 1016;
    public static final int VIDEO_INFO_ON_SET_PAGEURL = 1014;
    public static final int VIDEO_INFO_ON_SET_TITLE = 1013;
    public static final int VIDEO_INFO_ON_SET_URI = 1011;
    public static final int VIDEO_INFO_ON_STOP_PLAYBACK = 1015;
    public static final int VIDEO_INFO_PLAYER_TYPE = 1010;
    public static final int VIDEO_INFO_PLAY_PAUSE = 1004;
    public static final int VIDEO_INFO_PLAY_START = 1003;
    public static final int VIDEO_INFO_SEEKTO = 1006;
    public static final int VIDEO_INFO_SUPPORT_LITTLEWIN = 1008;
    public static final int VIDEO_INFO_TITLE_STRING = 1005;
    private static Class<?> sDefaultMediaControllerCls;
    private static boolean sIgnoreBackKeyEvent;
    private static int sInstanceCount = 0;
    protected static MediaControllerFactory sMeidaControllerFactory = null;
    protected static int sNextInstanceIndex = 2;
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    protected a mDefaultFullScreenExecutor;
    private a mFullScreenVideoView;
    protected String mLogTag;
    private MediaController mMediaController;
    private MediaPlayerListener mMediaPlayerListener;
    protected MediaView mMediaView;
    private c.a mNetworkListener;
    private ArrayList<OnBufferingUpdateListener> mOnBufferingUpdateListener;
    private ArrayList<OnCompletionListener> mOnCompletionListener;
    private ArrayList<OnErrorListener> mOnErrorListener;
    private ArrayList<OnExtraInfoListener> mOnExtraInfoListener;
    private ArrayList<OnInfoListener> mOnInfoListener;
    private ArrayList<OnPreparedListener> mOnPreparedListener;
    private ArrayList<OnSeekCompleteListener> mOnSeekCompleteListener;
    private int mPreloadErrorExtra;
    private int mPreloadErrorWhat;
    private int mPreloadStates;
    private boolean mStopped;
    private SubtitleHelper mSubtitleHelper;
    private SurfaceListener mSurfaceListener;
    private boolean mUILocked;

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnExtraInfoListener {
        void onExtraInfo(MediaPlayer mediaPlayer, int i, int i2, Object obj);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    VideoView(boolean z, Object obj) {
        this(z, (MediaView) obj);
    }

    VideoView(boolean z, MediaView mediaView) {
        super(mediaView.asView().getContext());
        this.mLogTag = BRIEF;
        this.mOnPreparedListener = new ArrayList();
        this.mOnCompletionListener = new ArrayList();
        this.mOnErrorListener = new ArrayList();
        this.mOnBufferingUpdateListener = new ArrayList();
        this.mOnInfoListener = new ArrayList();
        this.mOnExtraInfoListener = new ArrayList();
        this.mOnSeekCompleteListener = new ArrayList();
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.mPreloadStates = 0;
        this.mPreloadErrorWhat = 0;
        this.mPreloadErrorExtra = 0;
        this.mStopped = false;
        this.mNetworkListener = new c(this);
        this.mDefaultFullScreenExecutor = new d(this);
        this.mSurfaceListener = new e(this);
        this.mMediaPlayerListener = new f(this);
        this.mMediaView = mediaView;
        init(z);
    }

    VideoView(MediaView mediaView) {
        this(Settings.isUseDefaultController(), mediaView);
    }

    public VideoView(Context context) {
        this(new MediaViewImpl(context));
    }

    public VideoView(Context context, int i, boolean z) {
        this(new MediaViewImpl(context, i, z));
    }

    public VideoView(Context context, int i) {
        this(MediaViewFactory.create(context, i));
    }

    public VideoView(Context context, boolean z, int i) {
        this(z, new MediaViewImpl(context, i));
    }

    public VideoView(Context context, boolean z) {
        this(z, new MediaViewImpl(context));
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(this.mLogTag);
    }

    public static void onActivityPause() {
        d.d();
    }

    public static void onActivityResume() {
        d.e();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        MediaPlayer mediaPlayer = this.mMediaView.getMediaPlayer();
        switch (i) {
            case 0:
                this.mMediaView.show();
                if (mediaPlayer != null) {
                    mediaPlayer.setVisibility(true);
                    return;
                }
                return;
            case 4:
                this.mMediaView.showMini();
                if (mediaPlayer != null) {
                    mediaPlayer.setVisibility(false);
                    return;
                }
                return;
            case 8:
                this.mMediaView.hide();
                if (mediaPlayer != null) {
                    mediaPlayer.setVisibility(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void finalize() throws Throwable {
        StringBuilder stringBuilder = new StringBuilder("finalize, instance count ");
        int i = sInstanceCount - 1;
        sInstanceCount = i;
        stringBuilder.append(i);
        super.finalize();
    }

    protected void configController(boolean z) {
        MediaController mediaController;
        if (z && sMeidaControllerFactory == null) {
            if (sDefaultMediaControllerCls == null) {
                sDefaultMediaControllerCls = ReflectUtil.getClass("com.uc.apollo.default_shell.DefaultMediaController");
            }
            if (sDefaultMediaControllerCls != null) {
                try {
                    mediaController = (MediaController) ReflectUtil.newObject(ReflectUtil.getCtor2(sDefaultMediaControllerCls, Context.class, MediaView.class), getContext(), this.mMediaView);
                } catch (Exception e) {
                    mediaController = null;
                }
            }
            mediaController = null;
        } else {
            if (sMeidaControllerFactory != null) {
                mediaController = sMeidaControllerFactory.getMediaController(this);
            }
            mediaController = null;
        }
        if (mediaController != null) {
            setMediaController(mediaController);
        }
    }

    private void init(boolean z) {
        this.mLogTag = new StringBuilder(BRIEF).append(sNextInstanceIndex).toString();
        sNextInstanceIndex++;
        StringBuilder stringBuilder = new StringBuilder("created, instance count ");
        int i = sInstanceCount + 1;
        sInstanceCount = i;
        stringBuilder.append(i);
        setBackgroundColor(-16777216);
        Initializer.init(getContext());
        addView(this.mMediaView.asView(), new LayoutParams(-1, -1, 17));
        this.mMediaView.addListener(this.mMediaPlayerListener);
        this.mMediaView.addSurfaceListener(this.mSurfaceListener);
        this.mMediaView.setFullScreenExecutor(this.mDefaultFullScreenExecutor);
        configController(z);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setContentDescription("VideoView");
        initResource();
    }

    private void initResource() {
        SparseArray instanceSettings = Settings.getInstanceSettings();
        for (int i = 0; i < instanceSettings.size(); i++) {
            int keyAt = instanceSettings.keyAt(i);
            setOption(keyAt, (String) instanceSettings.get(keyAt));
        }
    }

    private void handleMobileNetwork() {
        if (this.mMediaView != null && this.mMediaView.getController() != null && isPlaying()) {
            pause();
            if (this.mMediaController != null && this.mMediaController.playInMobileNetwork()) {
                this.mMediaView.getController().start();
            }
        }
    }

    public void enterFullScreen(boolean z) {
        if (!z && Settings.getPausePlayAfterExitFullScreen()) {
            pause();
        }
        if (!z) {
            this.mMediaView.getListener().onEnterFullScreen(z);
        }
        if (!Settings.getEnableFullScreen()) {
            this.mMediaView.getController().enterFullScreen(z);
        } else if (z) {
            enterFullScreenWithOrientation(getVideoHeight() <= getVideoWidth() ? 6 : 7);
        } else if (this.mMediaView.getFullScreenExecutor() != null) {
            this.mMediaView.getFullScreenExecutor().a();
        }
        if (z) {
            this.mMediaView.getListener().onEnterFullScreen(z);
        }
        if (!sIgnoreBackKeyEvent) {
            if (z) {
                requestFocus();
            } else {
                clearFocus();
            }
        }
    }

    public void enterLittleWin(int i, int i2, int i3, int i4) {
        this.mMediaView.getController().enterLittleWin(i, i2, i3, i4, 0);
    }

    public void enterLittleWin() {
        this.mMediaView.getController().enterLittleWin();
    }

    public void enterFullScreenWithOrientation(int i) {
        if (Settings.getEnableFullScreen() && this.mMediaView.getFullScreenExecutor() != null) {
            this.mMediaView.getFullScreenExecutor().a(i);
        }
        this.mMediaView.getListener().onEnterFullScreen(true);
        requestFocus();
    }

    public void setFullScreenExecutor(a aVar) {
        this.mMediaView.setFullScreenExecutor(aVar);
    }

    public void setFullScreenExecutor(Object obj) {
        a aVar;
        if (obj instanceof a) {
            aVar = (a) obj;
        } else {
            aVar = a.a.a(obj);
        }
        this.mMediaView.setFullScreenExecutor(aVar);
    }

    public a fullScreenExecutor() {
        return this.mMediaView.getFullScreenExecutor();
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoPath(String str, String str2) {
        this.mMediaView.getController().setTitleAndPageURI(str2, null);
        setVideoPath(str);
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null, null);
    }

    public void setTitleAndPageURI(String str, String str2) {
        this.mMediaView.getController().setTitleAndPageURI(str, str2);
    }

    public void setVideoURI(Uri uri, String str) {
        setVideoURI(uri, null, str);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map, String str) {
        this.mMediaView.getController().setVideoURI(uri, map);
        if (str != null) {
            this.mMediaView.getController().setTitleAndPageURI(str, "");
        }
        this.mPreloadStates = 0;
    }

    public void stopPlayback() {
        this.mMediaView.getController().stop();
        this.mMediaView.getController().destroy();
        c.a().b(this.mNetworkListener);
        this.mStopped = true;
        onStopPlayback();
    }

    private void onStopPlayback() {
        Iterator it = this.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.mMediaView.getMediaPlayer(), VIDEO_INFO_ON_STOP_PLAYBACK, 0, null);
            }
        }
    }

    public void destroy() {
        if (!this.mStopped) {
            stopPlayback();
        }
        if (sMeidaControllerFactory != null) {
            sMeidaControllerFactory.recycleMediaController(this);
        } else if (this.mMediaController != null) {
            ReflectUtil.call(Void.class, this.mMediaController, "destroy", new Object[0]);
        }
        this.mMediaController = null;
        onDestroyed();
    }

    private void onDestroyed() {
        Iterator it = this.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.mMediaView.getMediaPlayer(), VIDEO_INFO_ON_DESTROY, 0, null);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        setMediaController(new b(mediaController));
    }

    public void setMediaController(MediaController mediaController) {
        if (this.mMediaController != null) {
            this.mMediaController.setAnchorView(null);
            this.mMediaController.setMediaPlayer(null);
            this.mMediaController.setEnabled(false);
        }
        this.mMediaController = mediaController;
        attachMediaController();
    }

    public static void setMediaControllerFactory(MediaControllerFactory mediaControllerFactory) {
        sMeidaControllerFactory = mediaControllerFactory;
    }

    protected boolean isInPlaybackState() {
        MediaPlayer mediaPlayer = this.mMediaView.getMediaPlayer();
        return mediaPlayer != null ? mediaPlayer.isInPlaybackState() : false;
    }

    private void attachMediaController() {
        if (this.mMediaController != null) {
            this.mMediaController.setAnchorView(this);
            this.mMediaController.setMediaPlayer(this);
            this.mMediaController.setEnabled(isInPlaybackState());
        }
    }

    public void suspend() {
        pause();
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener.add(onPreparedListener);
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener.add(onSeekCompleteListener);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener.add(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener.add(onErrorListener);
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener.add(onBufferingUpdateListener);
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener.add(onInfoListener);
    }

    public void setOnExtraInfoListener(OnExtraInfoListener onExtraInfoListener) {
        this.mOnExtraInfoListener.add(onExtraInfoListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isInPlaybackState() && this.mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (isInPlaybackState() && this.mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public void onUILocked() {
        this.mUILocked = true;
    }

    public void onUIUnlocked() {
        this.mUILocked = false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i != 4 || sIgnoreBackKeyEvent || !isFullScreen()) {
            MediaPlayer mediaPlayer = this.mMediaView.getMediaPlayer();
            if (!(i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6)) {
                z = true;
            }
            if (z && mediaPlayer != null && isInPlaybackState() && this.mMediaController != null) {
                if (i == 79 || i == 85) {
                    if (mediaPlayer.isPlaying()) {
                        pause();
                        this.mMediaController.show();
                        return true;
                    }
                    start();
                    this.mMediaController.hide();
                    return true;
                } else if (i == 126) {
                    if (mediaPlayer.isPlaying()) {
                        return true;
                    }
                    start();
                    this.mMediaController.hide();
                    return true;
                } else if (i != 86 && i != UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    toggleMediaControlsVisiblity();
                } else if (!mediaPlayer.isPlaying()) {
                    return true;
                } else {
                    pause();
                    this.mMediaController.show();
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else if (this.mUILocked) {
            return true;
        } else {
            this.mMediaView.getController().enterFullScreen(false);
            return true;
        }
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    public void preload() {
        if (this.mPreloadStates == 0 && this.mMediaView != null && this.mMediaView.getController() != null) {
            this.mPreloadStates = 1;
            this.mMediaView.getController().prepareAsync();
        }
    }

    public void start() {
        if (this.mFullScreenVideoView != null) {
            this.mFullScreenVideoView.start();
            return;
        }
        c.a().a(this.mNetworkListener);
        if (this.mMediaController == null || !c.a(getContext()) || this.mMediaController.playInMobileNetwork()) {
            int i = this.mPreloadStates;
            this.mPreloadStates = 0;
            if (i != 3 && i == 2) {
                i = getDuration();
                int videoWidth = getVideoWidth();
                int videoHeight = getVideoHeight();
                this.mMediaPlayerListener.onVideoSizeChanged(videoWidth, videoHeight);
                this.mMediaPlayerListener.onPrepared(i, videoWidth, videoHeight);
            }
            this.mMediaView.getController().start();
            this.mStopped = false;
        }
    }

    public void pause() {
        if (this.mPreloadStates == 0) {
            this.mMediaView.getController().pause();
        }
    }

    public int getDuration() {
        return this.mMediaView.getController().getDuration();
    }

    public int getVideoWidth() {
        return this.mMediaView.getController().getVideoWidth();
    }

    public int getVideoHeight() {
        return this.mMediaView.getController().getVideoHeight();
    }

    public int getCurrentPosition() {
        return this.mMediaView.getController().getCurrentPosition();
    }

    public void seekTo(int i) {
        this.mMediaView.getController().seekTo(i);
    }

    public boolean isPlaying() {
        return this.mPreloadStates == 0 && this.mMediaView.getController().isPlaying();
    }

    public int getBufferPercentage() {
        return 0;
    }

    public Bitmap getCurrentVideoFrame() {
        Bitmap currentVideoFrame = this.mMediaView.getController().getCurrentVideoFrame();
        if (currentVideoFrame != null || this.mMediaView.getMediaPlayer() == null) {
            return currentVideoFrame;
        }
        return this.mMediaView.getMediaPlayer().getCurrentVideoFrameSync();
    }

    public boolean canPause() {
        return this.mCanPause;
    }

    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public MediaView getMediaView() {
        return this.mMediaView;
    }

    public MediaPlayerController getController() {
        return this.mMediaView.getController();
    }

    public MediaPlayerListener getListener() {
        return this.mMediaView.getListener();
    }

    public boolean isFullScreen() {
        return this.mMediaView.getController().isFullScreen();
    }

    private a createFullscreenVideoView() {
        return new a(getContext(), this, this.mMediaView.getDomId(), isPlaying(), this.mMediaController != null);
    }

    public void showFloatingWindow(int i, int i2, int i3, int i4) {
        this.mMediaView.getController().enterLittleWin(i, i2, i3, i4, 1);
    }

    public void hideFloatingWindow() {
        this.mMediaView.getController().exitLittleWin(1);
    }

    public View asView() {
        return this;
    }

    public boolean setOption(int i, String str) {
        if (str == null) {
            return false;
        }
        String str2;
        switch (i) {
            case 1001:
                str2 = "rw.instance.business_unit";
                str = "as_" + str;
                break;
            case 1002:
                str2 = "rw.instance.stat_level";
                break;
            case 1003:
                str2 = "rw.instance.cache_in_cellular";
                break;
            case 1004:
                str2 = "ro.instance.vr_display_mode";
                break;
            case 1005:
                str2 = "ro.instance.vr_projection_mode";
                break;
            case 1006:
                str2 = "ro.instance.vr_enable";
                break;
            case 1007:
                str2 = "rw.instance.mute";
                break;
            case 1008:
                str2 = "rw.instance.ext_info";
                break;
            case 1009:
                str2 = "rw.instance.pause_preload";
                break;
            case 1010:
                str2 = "rw.instance.http_proxy";
                break;
            case 1011:
                str2 = "rw.instance.backup_dnsrecord";
                break;
            case 1012:
                str2 = "rw.instance.public_parameter";
                break;
            case 2001:
                str2 = "rw.global.prune_cache_expired";
                break;
            case 2002:
                str2 = "rw.global.cache_dir";
                break;
            default:
                return false;
        }
        if (!str2.startsWith("ro.instance.vr_") || this.mMediaView == null) {
            return this.mMediaView.setOption(str2, str);
        }
        return this.mMediaView.execCommand(110, 0, 0, new String[]{str2, str});
    }

    public boolean setOption(String str, String str2) {
        if (str == null || str2 == null || this.mMediaView == null) {
            return false;
        }
        return this.mMediaView.setOption(str, str2);
    }

    public static void setIgnoreBackKeyEvent(boolean z) {
        sIgnoreBackKeyEvent = z;
    }

    public View createSubtitle(Map<String, String> map) {
        this.mSubtitleHelper = SubtitleHelper.createSubtitle(map, getContext(), new g(this));
        return this.mSubtitleHelper.getSubtitleView();
    }

    public void pauseSubtitle(Map<String, String> map) {
        if (this.mSubtitleHelper != null) {
            this.mSubtitleHelper.pauseSubtitle(map);
        }
    }

    public void stopSubtitle() {
        if (this.mSubtitleHelper != null) {
            this.mSubtitleHelper.stopSubtitle();
        }
    }
}
