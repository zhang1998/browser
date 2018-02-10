package com.ucpro.feature.k.a.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.mini.support.annotation.Nullable;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.m;

/* compiled from: ProGuard */
public final class g implements e {
    public h a;
    private Activity b;

    public g(h hVar, Activity activity) {
        this.a = hVar;
        this.b = activity;
        hVar.setPresenter(this);
    }

    public final void a() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("image/*");
            this.b.startActivityForResult(intent, 3);
        } catch (Exception e) {
        }
    }

    public final void a(boolean z, @Nullable Bitmap bitmap, int i) {
        m mVar = new m(((View) this.a).getContext());
        mVar.a(3);
        mVar.a(a.d((int) R.string.quark_lab_wallpaper_share_dialog_title));
        mVar.a(a.d((int) R.string.quark_lab_wallpaper_share_dialog_yes), a.d((int) R.string.quark_lab_wallpaper_share_dialog_no));
        mVar.a(new b(this, z, bitmap, i));
        mVar.show();
        com.ucpro.business.stat.m.a("quark_lab", com.ucpro.feature.k.a.g, new String[0]);
    }

    static /* synthetic */ void b(boolean z, Bitmap bitmap, int i) {
        com.ucpro.model.a.a.a.b("setting_enable_logo", z);
        com.ucpro.base.a.g.a().b(e.O, new Object[]{bitmap, Integer.valueOf(i)});
    }
}
