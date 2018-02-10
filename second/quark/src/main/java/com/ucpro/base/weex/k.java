package com.ucpro.base.weex;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.ucpro.base.b.b;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ int c;
    final /* synthetic */ com.taobao.weex.common.k d;
    final /* synthetic */ b e;

    k(b bVar, String str, ImageView imageView, int i, com.taobao.weex.common.k kVar) {
        this.e = bVar;
        this.a = str;
        this.b = imageView;
        this.c = i;
        this.d = kVar;
    }

    public final void run() {
        b bVar = this.e;
        String str = this.a;
        ImageView imageView = this.b;
        com.taobao.weex.common.k kVar = this.d;
        Object obj = (kVar == null || TextUtils.isEmpty(kVar.d)) ? null : 1;
        ((b) c.b(imageView.getContext())).b(str).b(obj != null ? ((b) c.b(imageView.getContext())).b(kVar.d) : null).b(new i(bVar, str, imageView, kVar)).a(imageView);
    }
}
