package com.uc.apollo.preload;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ StatisticUploadListener a;

    p(StatisticUploadListener statisticUploadListener) {
        this.a = statisticUploadListener;
    }

    public final void run() {
        i.a(this.a);
    }
}
