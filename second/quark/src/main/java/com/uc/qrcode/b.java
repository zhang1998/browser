package com.uc.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import com.uc.qrcode.b.a;
import java.io.Closeable;

/* compiled from: ProGuard */
final class b implements OnErrorListener, Closeable {
    private static final String b = b.class.getSimpleName();
    int a = -1;
    private final Activity c;
    private MediaPlayer d;
    private boolean e;
    private boolean f;

    b(Activity activity) {
        this.c = activity;
        this.d = null;
        b();
    }

    private synchronized void b() {
        boolean z;
        PreferenceManager.getDefaultSharedPreferences(this.c);
        Context context = this.c;
        boolean z2 = a.KEY_PLAY_BEEP.r;
        if (!z2 || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            z = z2;
        } else {
            z = false;
        }
        this.e = z;
        this.f = a.KEY_VIBRATE.r;
        if (this.e && this.d == null) {
            this.c.setVolumeControlStream(3);
            this.d = a(this.c);
        }
    }

    final synchronized void a() {
        if (this.e && this.d != null) {
            this.d.start();
        }
        if (this.f) {
            ((Vibrator) this.c.getSystemService("vibrator")).vibrate(200);
        }
    }

    private MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        AssetFileDescriptor openRawResourceFd;
        try {
            openRawResourceFd = context.getResources().openRawResourceFd(this.a);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setLooping(false);
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Throwable e) {
            Log.w(b, e);
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
        }
    }

    public final synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.c.finish();
        } else {
            close();
            b();
        }
        return true;
    }

    public final synchronized void close() {
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
    }
}
