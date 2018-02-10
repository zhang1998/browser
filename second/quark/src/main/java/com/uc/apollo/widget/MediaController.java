package com.uc.apollo.widget;

import android.view.ViewGroup;
import com.uc.apollo.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: ProGuard */
public interface MediaController {

    @KeepForSdk
    /* compiled from: ProGuard */
    public interface MediaControllerFactory {
        MediaController getMediaController(VideoView videoView);

        void recycleMediaController(VideoView videoView);
    }

    @KeepForSdk
    /* compiled from: ProGuard */
    public interface MediaPlayerControl {
        boolean canPause();

        boolean canSeekBackward();

        boolean canSeekForward();

        void enterFullScreen(boolean z);

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        int getVideoHeight();

        int getVideoWidth();

        boolean isPlaying();

        void pause();

        void seekTo(int i);

        void start();
    }

    /* compiled from: ProGuard */
    public final class a implements android.widget.MediaController.MediaPlayerControl {
        MediaPlayerControl a;

        a(MediaPlayerControl mediaPlayerControl) {
            this.a = mediaPlayerControl;
        }

        public final void start() {
            this.a.start();
        }

        public final void pause() {
            this.a.pause();
        }

        public final int getDuration() {
            return this.a.getDuration();
        }

        public final int getCurrentPosition() {
            return this.a.getCurrentPosition();
        }

        public final void seekTo(int i) {
            this.a.seekTo(i);
        }

        public final boolean isPlaying() {
            return this.a.isPlaying();
        }

        public final int getBufferPercentage() {
            return this.a.getBufferPercentage();
        }

        public final boolean canPause() {
            return this.a.canPause();
        }

        public final boolean canSeekBackward() {
            return this.a.canSeekBackward();
        }

        public final boolean canSeekForward() {
            return this.a.canSeekForward();
        }

        public final int getAudioSessionId() {
            return 0;
        }
    }

    /* compiled from: ProGuard */
    public final class b implements MediaController {
        private android.widget.MediaController a;

        b(android.widget.MediaController mediaController) {
            this.a = mediaController;
        }

        public final void hide() {
            this.a.hide();
        }

        public final boolean isShowing() {
            return this.a.isShowing();
        }

        public final void setAnchorView(ViewGroup viewGroup) {
            this.a.setAnchorView(viewGroup);
        }

        public final void setEnabled(boolean z) {
            this.a.setEnabled(z);
        }

        public final void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
            this.a.setMediaPlayer(new a(mediaPlayerControl));
        }

        public final void show(int i) {
            this.a.show(i);
        }

        public final void show() {
            this.a.show();
        }

        public final boolean playInMobileNetwork() {
            return true;
        }
    }

    void hide();

    boolean isShowing();

    boolean playInMobileNetwork();

    void setAnchorView(ViewGroup viewGroup);

    void setEnabled(boolean z);

    void setMediaPlayer(MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);
}
