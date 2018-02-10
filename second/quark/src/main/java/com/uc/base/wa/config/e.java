package com.uc.base.wa.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/* compiled from: ProGuard */
public final class e {
    private static long a = ((28800000 - ((long) Calendar.getInstance().get(15))) + 0);
    private static String b = null;
    private boolean c;
    private boolean d;
    private long e;
    private String f;
    private d g;
    private int h;
    private long i;

    public static String a() {
        return b;
    }

    private synchronized boolean b() {
        boolean z = true;
        synchronized (this) {
            long nanoTime = System.nanoTime();
            long currentTimeMillis = System.currentTimeMillis() + a;
            if (this.c) {
                if (b == null) {
                    b = new SimpleDateFormat("yyyy-MM-dd").format(new Date(currentTimeMillis));
                }
                if (this.d) {
                    if (nanoTime - this.e > this.i) {
                        b = new SimpleDateFormat("yyyy-MM-dd").format(new Date(currentTimeMillis));
                        this.c = true;
                        this.d = a(nanoTime, 0);
                    }
                } else if (nanoTime - this.e > this.i) {
                    this.c = false;
                    this.d = false;
                    z = false;
                }
            } else {
                if (this.d) {
                    if (nanoTime - this.e > this.i - 900000000000L) {
                        b = new SimpleDateFormat("yyyy-MM-dd").format(new Date(currentTimeMillis + 900000));
                        this.c = true;
                        this.d = a(nanoTime, 900000000000L);
                    }
                } else if (nanoTime - this.e >= this.i) {
                    this.c = false;
                    this.d = a(nanoTime, 0);
                }
                z = false;
            }
        }
        return z;
    }

    private boolean a(long j, long j2) {
        this.e = j;
        long currentTimeMillis = (System.currentTimeMillis() + 28800000) + a;
        this.i = (86400000000000L + j2) - (((currentTimeMillis * 1000000) + j2) % 86400000000000L);
        return new Random((long) new StringBuilder().append(a.a()).append(this.f).append(((currentTimeMillis + (j2 / 1000000)) / 86400000) + 1).toString().hashCode()).nextInt() % this.h == 0;
    }
}
