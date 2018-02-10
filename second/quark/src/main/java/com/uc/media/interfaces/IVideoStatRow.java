package com.uc.media.interfaces;

/* compiled from: ProGuard */
public interface IVideoStatRow {

    /* compiled from: ProGuard */
    public class NullVideoStatRow implements IVideoStatRow {
        public static NullVideoStatRow mInstance = new NullVideoStatRow();

        public void onError(int i, int i2) {
        }

        public void onTeardown() {
        }

        public void onReset() {
        }

        public void onSrc(String str) {
        }

        public void onPageUrl(String str) {
        }

        public void onStart() {
        }

        public void onTimeupdate(int i) {
        }

        public void onProgressUpdate(int i) {
        }

        public void onPause() {
        }

        public void onSeek() {
        }

        public void onEnterFullScreen() {
        }

        public void onExitFullScreen() {
        }

        public void onDuration(int i) {
        }

        public void onComplete() {
        }

        public void onPrepared(IMediaPlayerUC iMediaPlayerUC) {
        }

        public void onStopPlayback() {
        }

        public void onVideoType(String str) {
        }

        public void onHttpStatus(String str) {
        }

        public void onVideoViewType(PlayerType playerType) {
        }

        public void onInfo(int i, int i2) {
        }

        public void onRetryOpenVideo(int i) {
        }

        public void onPreload(boolean z) {
        }

        public void onPreloadCompletion() {
        }

        public void onVisibilityChangeStat(int i) {
        }

        public void onResetStat() {
        }

        public void onSeekComplete() {
        }

        public void setPlayFrom(int i) {
        }
    }

    void onComplete();

    void onDuration(int i);

    void onEnterFullScreen();

    void onError(int i, int i2);

    void onExitFullScreen();

    void onHttpStatus(String str);

    void onInfo(int i, int i2);

    void onPageUrl(String str);

    void onPause();

    void onPreload(boolean z);

    void onPreloadCompletion();

    void onPrepared(IMediaPlayerUC iMediaPlayerUC);

    void onProgressUpdate(int i);

    void onReset();

    void onResetStat();

    void onRetryOpenVideo(int i);

    void onSeek();

    void onSeekComplete();

    void onSrc(String str);

    void onStart();

    void onStopPlayback();

    void onTeardown();

    void onTimeupdate(int i);

    void onVideoType(String str);

    void onVideoViewType(PlayerType playerType);

    void onVisibilityChangeStat(int i);

    void setPlayFrom(int i);
}
