package com.uc.apollo.media.base;

import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
final class b implements OnAudioFocusChangeListener {
    b() {
    }

    public final void onAudioFocusChange(int i) {
        switch (i) {
            case -3:
            case -2:
            case -1:
            case 1:
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    a.a(i);
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).post(new c(this, i));
                    return;
                }
            default:
                return;
        }
    }
}
