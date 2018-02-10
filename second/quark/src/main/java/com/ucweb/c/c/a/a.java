package com.ucweb.c.c.a;

import android.content.Intent;
import android.text.TextUtils;
import com.ucweb.c.b.b;

/* compiled from: ProGuard */
public final class a implements com.ucweb.c.a.a {
    public final void a(b bVar) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.setFlags(524288);
        intent.putExtra("android.intent.extra.SUBJECT", bVar.b);
        intent.putExtra("android.intent.extra.TEXT", bVar.a);
        try {
            com.ucweb.c.c.b.a().startActivity(Intent.createChooser(intent, TextUtils.isEmpty(bVar.i) ? "分享" : bVar.i));
        } catch (Exception e) {
        }
    }
}
