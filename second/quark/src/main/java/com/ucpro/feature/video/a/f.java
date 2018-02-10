package com.ucpro.feature.video.a;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - 1296000000;
        this.a.a.delete("video_history", "visit_time<?", new String[]{String.valueOf(currentTimeMillis)});
    }
}
