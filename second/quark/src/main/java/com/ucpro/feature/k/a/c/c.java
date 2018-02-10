package com.ucpro.feature.k.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public final class c extends j implements h {
    private d g = new d(getContext());
    private e h;

    public c(Context context) {
        super(context);
        this.f.a(a.d((int) R.string.quark_lab_wallper_preview_title));
        this.f.b.setTextColor(-1);
        this.f.c.setColorFilter(-1);
        this.f.a(a.a("back.svg"));
        this.f.a.setBackgroundColor(a.c("default_background_dark"));
        this.e.addView(this.g, new LayoutParams(-1, -1));
    }

    public final void setPresenter(b bVar) {
        this.h = (e) bVar;
        this.g.setPresenter(this.h);
    }

    public final void a(f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
        this.h.a();
    }

    public final void a(f fVar, View view, w wVar) {
    }

    public final void a(Bitmap bitmap, int i) {
        d dVar = this.g;
        a aVar = dVar.a;
        aVar.a.setSrcBitmap(bitmap);
        aVar.b = i;
        aVar.a();
        dVar.b = bitmap;
        dVar.c = i;
    }

    public final d getPreviewPage() {
        return this.g;
    }

    @Deprecated
    public final void setBg(Bitmap bitmap) {
        this.e.setBackgroundDrawable(new BitmapDrawable(bitmap));
        this.e.removeAllViews();
    }
}
