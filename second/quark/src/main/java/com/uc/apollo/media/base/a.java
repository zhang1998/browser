package com.uc.apollo.media.base;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.util.SparseArray;
import com.uc.apollo.Settings;
import com.uc.apollo.media.impl.B;
import com.uc.apollo.media.impl.D;
import com.uc.apollo.util.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class a {
    private static boolean a = false;
    private static ArrayList<WeakReference<B>> b = new ArrayList();
    private static boolean c = false;
    private static OnAudioFocusChangeListener d;

    public static void a() {
        a = false;
        if (d != null) {
            AudioManager audioManager = (AudioManager) Settings.getContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.abandonAudioFocus(d);
            }
            d = null;
        }
    }

    public static boolean a(B b) {
        int i = 0;
        if (!a) {
            AudioManager audioManager = (AudioManager) Settings.getContext().getSystemService("audio");
            if (audioManager != null) {
                if (d == null) {
                    d = new b();
                }
                a = audioManager.requestAudioFocus(d, 3, 1) == 1;
            }
        }
        int a = b.a();
        SparseArray a2 = D.a();
        int size = a2.size();
        while (i < size) {
            B b2 = (B) a2.valueAt(i);
            if (!(b2 == null || a == b2.a())) {
                b2.t();
            }
            i++;
        }
        return a;
    }

    static /* synthetic */ void a(int i) {
        SparseArray a = D.a();
        int size;
        int i2;
        if (i == -1) {
            a = false;
            size = a.size();
            for (i2 = 0; i2 < size; i2++) {
                ((B) a.valueAt(i2)).q();
            }
        } else if (i == -2 || i == -3) {
            a = false;
            if (Settings.shouldPausePlayWhenAudioFocusLossTransient()) {
                b.clear();
                size = a.size();
                for (i2 = 0; i2 < size; i2++) {
                    r0 = (B) a.valueAt(i2);
                    if (r0.v()) {
                        b.add(new WeakReference(r0));
                    }
                    r0.t();
                }
                c = c.a(Settings.getContext());
            }
        } else if (i == 1) {
            a = true;
            if (Settings.shouldPausePlayWhenAudioFocusLossTransient()) {
                boolean a2 = c.a(Settings.getContext());
                if (Settings.shouldContinuePlayWhenAudioFocusGainAfterLossTransient() && (!a2 || (a2 && c))) {
                    int size2 = b.size();
                    for (i2 = 0; i2 < size2; i2++) {
                        r0 = (B) ((WeakReference) b.get(i2)).get();
                        if (r0 != null) {
                            if (r0.e() != null) {
                                r0.e().start();
                            }
                            r0.n();
                        }
                    }
                }
                b.clear();
            }
        }
    }
}
