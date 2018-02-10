package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.uc.webview.export.cyclone.UCElapseTime;

/* compiled from: ProGuard */
public final class bf {
    boolean a = false;
    private Pair<Integer, Object> b = new Pair(Integer.valueOf(-1), null);

    public final void a(int i, Object obj) {
        synchronized (this) {
            this.b = new Pair(Integer.valueOf(i), obj);
            try {
                notify();
            } catch (Exception e) {
            }
        }
    }

    public final Pair<Integer, Object> a(long j) {
        UCElapseTime uCElapseTime = new UCElapseTime();
        synchronized (this) {
            if (((Integer) this.b.first).intValue() != -1) {
                Pair<Integer, Object> pair = this.b;
                return pair;
            }
            long j2;
            if (j <= 0) {
                j2 = 0;
            } else {
                j2 = 100;
            }
            this.a = true;
            while (true) {
                if (uCElapseTime.getMilis() < j || j <= 0) {
                    try {
                        wait(Math.max(j2, j - uCElapseTime.getMilis()));
                        if (((Integer) this.b.first).intValue() != -1) {
                            this.a = false;
                            pair = this.b;
                            return pair;
                        }
                    } catch (InterruptedException e) {
                    }
                } else {
                    this.a = false;
                    return new Pair(Integer.valueOf(1), null);
                }
            }
        }
    }
}
