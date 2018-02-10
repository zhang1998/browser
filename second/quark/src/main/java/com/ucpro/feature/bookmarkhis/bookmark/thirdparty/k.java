package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.view.View;
import android.view.View.OnClickListener;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class k implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ AddFavoriteActivity d;

    k(AddFavoriteActivity addFavoriteActivity, String str, String str2, long j) {
        this.d = addFavoriteActivity;
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public final void onClick(View view) {
        if (!this.d.b) {
            this.d.b = true;
            this.d.a.removeCallbacks(this.d.c);
            AddFavoriteActivity.b(this.d, this.a, this.b, this.c);
            m.a("bookmark", "bookmark_thirdparty_toast_click", new String[0]);
        }
    }
}
