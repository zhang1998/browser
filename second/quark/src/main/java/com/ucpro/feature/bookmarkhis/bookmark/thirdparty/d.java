package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ AddFavoriteActivity a;

    d(AddFavoriteActivity addFavoriteActivity) {
        this.a = addFavoriteActivity;
    }

    public final void run() {
        this.a.a.removeCallbacks(this.a.c);
        this.a.finish();
    }
}
