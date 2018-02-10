package com.uc.apollo.android;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ GuideDialog a;
    final /* synthetic */ String b;

    d(GuideDialog guideDialog, String str) {
        this.a = guideDialog;
        this.b = str;
    }

    public final void run() {
        SystemAlertWindowPermission.b(this.a, this.b);
    }
}
