package com.uc.apollo.media;

import android.net.Uri;
import com.uc.apollo.media.MediaPlayerListener.a;
import com.uc.apollo.media.base.f;
import com.uc.apollo.util.ReflectUtil;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public final class c implements MediaPlayerListener {
    private static final String a = (f.a + "MediaPlayerListeners");
    private Object b;
    private ArrayList<MediaPlayerListener> c = new ArrayList();

    public final void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onSetDataSource(str, str2, uri, map);
        }
    }

    public final void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onSetDataSource(fileDescriptor, j, j2);
        }
    }

    public final MediaPlayerListener a(MediaPlayerListener mediaPlayerListener) {
        if (mediaPlayerListener != null) {
            this.c.add(mediaPlayerListener);
        }
        return mediaPlayerListener;
    }

    public final MediaPlayerListener b(MediaPlayerListener mediaPlayerListener) {
        if (mediaPlayerListener != null) {
            this.c.remove(mediaPlayerListener);
        }
        return mediaPlayerListener;
    }

    public final MediaPlayerListener a(Object obj) {
        if (obj == null) {
            return null;
        }
        MediaPlayerListener mediaPlayerListener;
        if (obj instanceof MediaPlayerListener) {
            mediaPlayerListener = (MediaPlayerListener) obj;
        } else {
            MediaPlayerListener a = a.a(obj);
            a.a(obj, a);
            mediaPlayerListener = a;
        }
        return a(mediaPlayerListener);
    }

    public final MediaPlayerListener b(Object obj) {
        MediaPlayerListener mediaPlayerListener;
        if (obj instanceof MediaPlayerListener) {
            mediaPlayerListener = (MediaPlayerListener) obj;
        } else {
            MediaPlayerListener mediaPlayerListener2 = (MediaPlayerListener) ReflectUtil.call(MediaPlayerListener.class, obj, "getSibling", new Object[0]);
            a.a(obj, null);
            mediaPlayerListener = mediaPlayerListener2;
        }
        return b(mediaPlayerListener);
    }

    public final void onStart() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onStart();
        }
    }

    public final void onPause() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onPause();
        }
    }

    public final void onEnterFullScreen(boolean z) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onEnterFullScreen(z);
        }
    }

    public final void onVideoSizeChanged(int i, int i2) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onVideoSizeChanged(i, i2);
        }
    }

    public final void onPrepared(int i, int i2, int i3) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onPrepared(i, i2, i3);
        }
    }

    public final void onDurationChanged(int i) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onDurationChanged(i);
        }
    }

    public final void onSeekComplete() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onSeekComplete();
        }
    }

    public final void onCompletion() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onCompletion();
        }
    }

    public final void onError(int i, int i2) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onError(i, i2);
        }
    }

    public final void onInfo(int i, int i2) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onInfo(i, i2);
        }
    }

    public final void onPrepareBegin() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onPrepareBegin();
        }
    }

    public final void onStop() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onStop();
        }
    }

    public final void onRelease() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onRelease();
        }
    }

    public final void onReset() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onReset();
        }
    }

    public final void onSeekTo(int i) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onSeekTo(i);
        }
    }

    public final void onMessage(int i, int i2, Object obj) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((MediaPlayerListener) it.next()).onMessage(i, i2, obj);
        }
    }

    public final Object getSibling() {
        return this.b;
    }

    public final void setSibling(Object obj) {
        this.b = obj;
    }
}
