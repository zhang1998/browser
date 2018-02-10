package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;

/* compiled from: ProGuard */
final class e implements ValueCallback<String> {
    final /* synthetic */ String a;
    final /* synthetic */ AddFavoriteActivity b;

    e(AddFavoriteActivity addFavoriteActivity, String str) {
        this.b = addFavoriteActivity;
        this.a = str;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            str = this.a;
        }
        long a = s.a().a(str, this.a);
        if (a >= 0) {
            AddFavoriteActivity.a(this.b, str, this.a, a);
        } else {
            this.b.b();
        }
    }
}
