package com.ucpro.feature.downloadpage.b;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.d.b;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.e.a;
import com.ucpro.ui.e.e;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class p extends j implements c, d, l, com.ucpro.ui.e.a.c {
    a g = new a(getContext(), this);
    private m h;

    public p(Context context) {
        super(context);
        setWindowCallBacks(this);
        this.f.a(com.ucpro.ui.c.a.d((int) R.string.download_setting));
        this.f.a(com.ucpro.ui.c.a.a("back.svg"));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.e.addView(this.g, layoutParams);
        this.e.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_white"));
    }

    public final void setPresenter(b bVar) {
        this.h = (m) bVar;
        this.g.j();
    }

    public final void a(f fVar, View view, ad adVar) {
        this.h.b();
    }

    public final void a(f fVar, View view, w wVar) {
    }

    public final ArrayList<e> getConfig() {
        ArrayList<e> arrayList = new ArrayList();
        arrayList.add(new r(r.b, com.ucpro.ui.c.a.d((int) R.string.download_path_desc), this));
        return arrayList;
    }

    public final void a(boolean z) {
        this.h.a();
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof p) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.h.b();
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.h.a((g) view);
        }
        return null;
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102168");
    }

    public final String getPageName() {
        return "Page_download_seting";
    }
}
