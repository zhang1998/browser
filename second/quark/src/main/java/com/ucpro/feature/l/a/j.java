package com.ucpro.feature.l.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import com.uc.apollo.android.GuideDialog;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class j implements g {
    private a a = null;

    public j(a aVar) {
        this.a = aVar;
        this.a.setPresenter(this);
    }

    public final void a(long j, ValueCallback<ArrayList<m>> valueCallback) {
        s.a().b(j, new h(this, valueCallback));
    }

    public final void a(String str, ImageView imageView, Drawable drawable, ValueCallback<Boolean> valueCallback) {
        c cVar = new c(this, imageView, drawable, valueCallback);
        g.a().b(e.d, new Object[]{str, cVar});
    }

    public final void a(String str, String str2, View view, Drawable drawable) {
        g.a().b(e.c, new i(this, str2, view, drawable, null, new e(this, view, str, str2)));
        HashMap hashMap = new HashMap();
        hashMap.put(GuideDialog.TITLE, str);
        hashMap.put("url", str2);
        com.ucpro.business.stat.m.a("discoverp_page", "dis_add_boo", hashMap);
    }

    public final void a(String str, String str2, ImageView imageView) {
        imageView.setTag(Boolean.valueOf(false));
        imageView.animate().rotation(0.0f).alpha(IPictureView.DEFAULT_MIN_SCALE);
        g.a().b(e.e, (Object) str2);
        HashMap hashMap = new HashMap();
        hashMap.put(GuideDialog.TITLE, str);
        hashMap.put("url", str2);
        com.ucpro.business.stat.m.a("discoverp_page", "dis_rem_boo", hashMap);
    }

    public final void a(m mVar) {
        if (mVar != null) {
            g.a().a(e.cS, mVar.f);
            String str = mVar.e;
            String str2 = mVar.f;
            HashMap hashMap = new HashMap();
            hashMap.put(GuideDialog.TITLE, str);
            hashMap.put("url", str2);
            com.ucpro.business.stat.m.a("discoverp_page", "dis_cli_boo", hashMap);
        }
    }
}
