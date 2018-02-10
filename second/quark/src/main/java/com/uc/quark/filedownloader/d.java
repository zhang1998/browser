package com.uc.quark.filedownloader;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import com.uc.quark.ad;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.services.u;

/* compiled from: ProGuard */
public final class d implements am {
    ad a;
    private final am b;

    private d() {
        this.b = new ag();
    }

    public final u a() {
        return new u(this.a);
    }

    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3, String str3, int i4, long j, String str4) {
        return this.b.a(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3, str3, i4, j, str4);
    }

    public final boolean a(int i) {
        return this.b.a(i);
    }

    public final long b(int i) {
        return this.b.b(i);
    }

    public final long c(int i) {
        return this.b.c(i);
    }

    public final byte d(int i) {
        return this.b.d(i);
    }

    public final void b() {
        this.b.b();
    }

    public final boolean c() {
        return this.b.c();
    }

    public final boolean d() {
        return this.b.d();
    }

    public final void a(Context context) {
        this.b.a(context);
    }

    public final void a(Context context, Runnable runnable) {
        this.b.a(context, runnable);
    }

    public final void b(Context context) {
        this.b.b(context);
    }

    public final void a(int i, Notification notification) {
        this.b.a(i, notification);
    }

    public final void a(boolean z) {
        this.b.a(z);
    }

    public final boolean e(int i) {
        return this.b.e(i);
    }

    public final byte[] e() {
        return this.b.e();
    }

    public final void a(Bundle bundle) {
        this.b.a(bundle);
    }

    public final void a(Bundle bundle, boolean z) {
        this.b.a(bundle, z);
    }

    public final boolean f(int i) {
        return this.b.f(i);
    }
}
