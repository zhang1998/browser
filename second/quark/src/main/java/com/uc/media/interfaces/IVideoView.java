package com.uc.media.interfaces;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.uc.media.interfaces.IMediaPlayerUC.OnBufferingUpdateListener;
import com.uc.media.interfaces.IMediaPlayerUC.OnCompletionListener;
import com.uc.media.interfaces.IMediaPlayerUC.OnDurationUpdateListener;
import com.uc.media.interfaces.IMediaPlayerUC.OnErrorListener;
import com.uc.media.interfaces.IMediaPlayerUC.OnInfoListener;
import com.uc.media.interfaces.IMediaPlayerUC.OnPreparedListener;
import com.uc.media.interfaces.IMediaPlayerUC.OnSeekCompleteListener;
import com.uc.media.interfaces.PosterView.ImageFrame;
import com.uc.webview.export.annotations.Api;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Api
/* compiled from: ProGuard */
public interface IVideoView {

    /* compiled from: ProGuard */
    public class DefaultImpl implements IVideoView {
        public void start() {
        }

        public void pause() {
        }

        public void seekTo(int i) {
        }

        public void stop() {
        }

        public void setPoster(Poster poster) {
        }

        public void attachPosterView(FrameLayout frameLayout) {
        }

        public boolean isPlaying() {
            return false;
        }

        public void enterFullScreen() {
        }

        public void exitFullScreen() {
        }

        public int getDuration() {
            return 0;
        }

        public PlayerSetter getPlayerSetter() {
            return null;
        }

        public int getCurrentPosition() {
            return 0;
        }

        public int getBufferPercentage() {
            return 0;
        }

        public boolean canPause() {
            return false;
        }

        public boolean canSeekBackward() {
            return false;
        }

        public boolean canSeekForward() {
            return false;
        }

        public PlayerType getVideoViewType() {
            return PlayerType.UNKNOWN;
        }

        public void resume() {
        }

        public void suspend() {
        }

        public View getView() {
            return null;
        }

        public void getCurrentVideoFrame(Rect rect, int i, OnGetCurrentVideoFrameCompletionListener onGetCurrentVideoFrameCompletionListener) {
        }

        public void destroy() {
        }

        public void setAudioManager(IAudioManagerEx iAudioManagerEx) {
        }

        public void setVideoPath(String str, String str2) {
        }

        public void setVideoURI(Uri uri, Uri uri2, String str) {
        }

        public void setVideoURI(String str, Map<String, String> map) {
        }

        public void setTitleAndPageUrl(String str, String str2) {
        }

        public void onVideoViewChange(VideoViewState videoViewState) {
        }

        public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        }

        public void setOnErrorListener(OnErrorListener onErrorListener) {
        }

        public void setOnInfoListener(OnInfoListener onInfoListener) {
        }

        public void setOnDurationUpdateListener(OnDurationUpdateListener onDurationUpdateListener) {
        }

        public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        }

        public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        }

        public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        }

        public void setOnVideoUrlSettedListener(OnVideoUrlSettedListener onVideoUrlSettedListener) {
        }

        public void setMediaControllerListener(IMediaControllerListener iMediaControllerListener) {
        }
    }

    /* compiled from: ProGuard */
    public interface OnGetCurrentVideoFrameCompletionListener {
        void onGetCurrentVideoFrameCompletion(Rect rect, Rect rect2, Bitmap bitmap);
    }

    /* compiled from: ProGuard */
    public interface OnVideoUrlSettedListener {
        void onVideoUrlSetted();
    }

    /* compiled from: ProGuard */
    public interface PlayerSetter {
        String getPlayerAllSettings();

        String getPlayerDefaultSettings(String str);

        String getPlayerSettings(String str);

        int removePlayerAllSettings();

        int removePlayerSettings(String str);

        void setInitPlaybackTime(int i);

        int setPlayerSettings(String str);

        int setPlayerSettings(String str, String str2);
    }

    /* compiled from: ProGuard */
    public class Poster {
        private List<ImageFrame> mImageFrameList = null;

        public Poster(ImageFrame[] imageFrameArr, int i) {
            this.mImageFrameList = Arrays.asList(imageFrameArr);
            new StringBuilder("A Poster has ").append(i).append(" frames.");
        }

        public void draw(PosterView posterView) {
            posterView.setFrameData(this.mImageFrameList);
        }
    }

    /* compiled from: ProGuard */
    public enum VideoViewState {
        S_SHOW_NORMAL,
        S_SHOW_MINI,
        S_SHOW_HIDE,
        S_SIZE_CHANGE
    }

    /* compiled from: ProGuard */
    public class ViewInfo {
        private static int MIN_VISIBLE_SIZE = 5;
        public int height;
        public boolean isDynamicContentPosition;
        public int layerId;
        public int layerPosX;
        public int layerPosY;
        View view;
        public int width;
        public int x;
        public int y;

        public ViewInfo(View view, boolean z, int i, int i2, int i3, int i4) {
            this.view = view;
            this.isDynamicContentPosition = z;
            this.x = i;
            this.y = i2;
            this.width = i3;
            this.height = i4;
        }

        public ViewInfo(View view, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this(view, z, i, i2, i3, i4);
            this.layerId = i5;
            this.layerPosX = i6;
            this.layerPosY = i7;
        }

        public void assign(ViewInfo viewInfo) {
            this.view = viewInfo.view;
            this.isDynamicContentPosition = viewInfo.isDynamicContentPosition;
            this.x = viewInfo.x;
            this.y = viewInfo.y;
            this.width = viewInfo.width;
            this.height = viewInfo.height;
            this.layerId = viewInfo.layerId;
            this.layerPosX = viewInfo.layerPosX;
            this.layerPosY = viewInfo.layerPosY;
        }

        public boolean visible() {
            boolean z = this.width >= MIN_VISIBLE_SIZE && this.height >= MIN_VISIBLE_SIZE;
            if (z) {
                if (this.x < 0 && this.width + this.x <= 0) {
                    z = false;
                }
                if (z && this.y < 0 && this.height + this.y <= 0) {
                    return false;
                }
            }
            return z;
        }

        public String toString() {
            return "view info: x/y/w/h - " + this.x + "/" + this.y + "/" + this.width + "/" + this.height + " - layer info fixed/id/x/y - " + this.isDynamicContentPosition + "/" + this.layerId + "/" + this.layerPosX + "/" + this.layerPosY;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ViewInfo)) {
                return false;
            }
            ViewInfo viewInfo = (ViewInfo) obj;
            if (this.view == viewInfo.view && this.x == viewInfo.x && this.y == viewInfo.y && this.width == viewInfo.width && this.height == viewInfo.height && this.isDynamicContentPosition == viewInfo.isDynamicContentPosition && this.layerId == viewInfo.layerId && this.layerPosX == viewInfo.layerPosX && this.layerPosY == viewInfo.layerPosY) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 0;
        }
    }

    void attachPosterView(FrameLayout frameLayout);

    boolean canPause();

    boolean canSeekBackward();

    boolean canSeekForward();

    void destroy();

    void enterFullScreen();

    void exitFullScreen();

    int getBufferPercentage();

    int getCurrentPosition();

    void getCurrentVideoFrame(Rect rect, int i, OnGetCurrentVideoFrameCompletionListener onGetCurrentVideoFrameCompletionListener);

    int getDuration();

    PlayerSetter getPlayerSetter();

    PlayerType getVideoViewType();

    View getView();

    boolean isPlaying();

    void onVideoViewChange(VideoViewState videoViewState);

    void pause();

    void resume();

    void seekTo(int i);

    void setAudioManager(IAudioManagerEx iAudioManagerEx);

    void setMediaControllerListener(IMediaControllerListener iMediaControllerListener);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnDurationUpdateListener(OnDurationUpdateListener onDurationUpdateListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoUrlSettedListener(OnVideoUrlSettedListener onVideoUrlSettedListener);

    void setPoster(Poster poster);

    void setTitleAndPageUrl(String str, String str2);

    void setVideoPath(String str, String str2);

    void setVideoURI(Uri uri, Uri uri2, String str);

    void setVideoURI(String str, Map<String, String> map);

    void start();

    void stop();

    void suspend();
}
