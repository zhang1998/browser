package com.ucpro.feature.r;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import com.UCMobile.Apollo.MediaPlayer;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucweb.a.a.c;
import com.ucweb.common.util.d;
import hugo.weaving.DebugLog;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class a extends e {
    private Activity c;

    @DebugLog
    protected final void a(b bVar) {
        super.a(bVar);
        this.c = bVar.a();
    }

    @DebugLog
    public final void a(int i, Message message) {
        Intent intent;
        if (message != null) {
            if (i == com.ucpro.base.a.e.bz) {
                if (com.ucpro.b.a.a.a()) {
                    Context a = d.a();
                    String packageName = a.getPackageName();
                    try {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
                        intent.setFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                        a.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
                        intent.setFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                        a.startActivity(intent);
                    }
                } else if (message.obj instanceof Boolean) {
                    com.ucweb.a.b.d hVar = new h(this.c);
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    if (hVar.b == null) {
                        hVar.b = new com.ucpro.feature.r.a.b(hVar.a);
                    }
                    com.ucpro.feature.r.a.b bVar = hVar.b;
                    CharSequence d = com.ucpro.ui.c.a.d((int) R.string.upgrade_loading_info);
                    bVar.c.setVisibility(0);
                    if (com.ucweb.common.util.n.a.b(d)) {
                        bVar.a.setText(d);
                    }
                    bVar.b.setVisibility(8);
                    bVar.show();
                    hVar.c = System.currentTimeMillis();
                    c.a(hVar, booleanValue);
                }
            } else if (i == com.ucpro.base.a.e.bA && !com.ucpro.b.a.a.a()) {
                c.a(new i(new WeakReference(this.c)), true);
            }
        }
    }

    public final void b(int i, Message message) {
        if (i == j.r) {
            g.a().a(com.ucpro.base.a.e.bA);
        }
    }
}
