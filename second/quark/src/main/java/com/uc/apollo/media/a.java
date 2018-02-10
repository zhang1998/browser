package com.uc.apollo.media;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.util.Map;

/* compiled from: ProGuard */
public final class a implements MediaPlayerController {
    protected Object a;

    public final void setVideoURI(Uri uri, Map<String, String> map) {
    }

    public final void setTitleAndPageURI(String str, String str2) {
    }

    public final void prepareAsync() {
    }

    public final void start() {
    }

    public final void pause() {
    }

    public final void stop() {
    }

    public final void seekTo(int i) {
    }

    public final void enterFullScreen(boolean z) {
    }

    public final void enterLittleWin() {
        enterLittleWin(0, 0, 0, 0);
    }

    public final void enterLittleWin(int i, int i2, int i3, int i4) {
        enterLittleWin(i, i2, i3, i4, 0);
    }

    public final void enterLittleWin(int i, int i2, int i3, int i4, int i5) {
    }

    public final void exitLittleWin(int i) {
    }

    public final void destroy() {
    }

    public final boolean isPlaying() {
        return false;
    }

    public final boolean isFullScreen() {
        return false;
    }

    public final int getDuration() {
        return 0;
    }

    public final int getCurrentPosition() {
        return 0;
    }

    public final int getVideoWidth() {
        return 0;
    }

    public final int getVideoHeight() {
        return 0;
    }

    public final void getCurrentVideoFrame(Rect rect, int i) {
    }

    public final Bitmap getCurrentVideoFrame() {
        return null;
    }

    public final boolean execCommand(int i, int i2, int i3, Object obj) {
        return false;
    }

    public final Object getSibling() {
        return this.a;
    }

    public final void setSibling(Object obj) {
        this.a = obj;
    }
}
