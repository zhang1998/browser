package com.uc.quark.filedownloader.a;

import android.annotation.TargetApi;
import com.uc.quark.filedownloader.e.b;
import java.io.IOException;

/* compiled from: ProGuard */
public final class a extends IOException {
    private long a;
    private long b;
    private long c;

    @TargetApi(9)
    public a(long j, long j2, long j3, Throwable th) {
        super(b.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)), th);
        a(j, j2, j3);
    }

    public a(long j, long j2, long j3) {
        super(b.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
        a(j, j2, j3);
    }

    private void a(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }
}
