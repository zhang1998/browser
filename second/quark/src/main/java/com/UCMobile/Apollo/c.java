package com.UCMobile.Apollo;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
final class c {
    MediaPlayer a = null;

    /* compiled from: ProGuard */
    final class a extends Thread {
        int a;
        String b;
        final /* synthetic */ c c;
        private MediaPlayer d = null;
        private Handler e = null;
        private OnPreparedListener f = new OnPreparedListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                Message obtainMessage = this.a.e.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.obj = mediaPlayer;
                this.a.e.sendMessage(obtainMessage);
            }
        };
        private OnErrorListener g = new OnErrorListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Message obtainMessage = this.a.e.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i;
                obtainMessage.arg2 = i2;
                obtainMessage.obj = mediaPlayer;
                this.a.e.sendMessage(obtainMessage);
                return true;
            }
        };

        public a(c cVar, MediaPlayer mediaPlayer) {
            this.c = cVar;
            this.d = mediaPlayer;
        }

        public final void run() {
            this.d.setOnErrorListener(this.g);
            this.d.setOnPreparedListener(this.f);
            Looper.prepare();
            this.e = new Handler(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public final void handleMessage(Message message) {
                    if (message.what == 65535) {
                        try {
                            this.a.d.prepareAsync();
                            return;
                        } catch (IllegalStateException e) {
                            this.a.a = 2;
                            this.a.b = e.getMessage();
                            Looper.myLooper().quit();
                            return;
                        }
                    }
                    this.a.a = message.what;
                    this.a.b = "";
                    Looper.myLooper().quit();
                }
            };
            Message obtainMessage = this.e.obtainMessage();
            obtainMessage.what = 65535;
            this.e.sendMessage(obtainMessage);
            Looper.loop();
        }
    }

    public c(MediaPlayer mediaPlayer) {
        this.a = mediaPlayer;
    }
}
