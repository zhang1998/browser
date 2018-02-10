package com.uc.quark.filedownloader;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import com.uc.quark.filedownloader.model.FileDownloadHeader;

/* compiled from: ProGuard */
public interface am {
    void a(int i, Notification notification);

    void a(Context context);

    void a(Context context, Runnable runnable);

    void a(Bundle bundle);

    void a(Bundle bundle, boolean z);

    void a(boolean z);

    boolean a(int i);

    boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3, String str3, int i4, long j, String str4);

    long b(int i);

    void b();

    void b(Context context);

    long c(int i);

    boolean c();

    byte d(int i);

    boolean d();

    boolean e(int i);

    byte[] e();

    boolean f(int i);
}
