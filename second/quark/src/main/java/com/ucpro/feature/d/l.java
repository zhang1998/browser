package com.ucpro.feature.d;

import android.graphics.drawable.Drawable;
import com.quark.browser.R;
import com.ucweb.c.a.b;

/* compiled from: ProGuard */
public enum l {
    WE_CHAT_FRIENDS("share_wechat_friends.svg", R.string.share_we_chat_friends, r5),
    WE_CHAT_TIME_LINE("share_wechat_timelines.svg", R.string.share_we_chat_time_line, r8),
    QQ_FRIENDS("share_qq_friends.svg", R.string.share_qq_friends, r8),
    QQ_Z("share_qq_zone.svg", R.string.share_qq_z, r8),
    COPY_LINK("share_copy_link.svg", R.string.share_copy_url, b.CLIPBOARD),
    MORE("share_more.svg", R.string.share_more, b.SHARE_MORE);
    
    Drawable g;
    String h;
    String i;
    int j;
    b k;

    private l(String str, int i, b bVar) {
        this.h = str;
        this.j = i;
        if (bVar == null) {
            throw new RuntimeException("ShareType sharePlatform is null!");
        }
        this.k = bVar;
    }
}
