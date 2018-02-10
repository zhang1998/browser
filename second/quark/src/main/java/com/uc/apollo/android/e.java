package com.uc.apollo.android;

import java.util.Map;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ GuideDialog a;
    final /* synthetic */ Map b;

    e(GuideDialog guideDialog, Map map) {
        this.a = guideDialog;
        this.b = map;
    }

    public final void run() {
        try {
            SystemUtils.startActivity(this.a.getContext(), this.b);
        } catch (Throwable th) {
        }
    }
}
