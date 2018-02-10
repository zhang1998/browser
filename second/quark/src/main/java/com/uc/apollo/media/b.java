package com.uc.apollo.media;

import android.net.Uri;
import java.io.FileDescriptor;
import java.util.Map;

/* compiled from: ProGuard */
public class b implements MediaPlayerListener {
    private Object a;

    public void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
    }

    public void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
    }

    public void onStart() {
    }

    public void onPause() {
    }

    public void onEnterFullScreen(boolean z) {
    }

    public void onVideoSizeChanged(int i, int i2) {
    }

    public void onPrepared(int i, int i2, int i3) {
    }

    public void onDurationChanged(int i) {
    }

    public void onSeekComplete() {
    }

    public void onCompletion() {
    }

    public void onError(int i, int i2) {
    }

    public void onInfo(int i, int i2) {
    }

    public void onPrepareBegin() {
    }

    public void onStop() {
    }

    public void onRelease() {
    }

    public void onReset() {
    }

    public void onSeekTo(int i) {
    }

    public void onMessage(int i, int i2, Object obj) {
    }

    public Object getSibling() {
        return this.a;
    }

    public void setSibling(Object obj) {
        this.a = obj;
    }
}
