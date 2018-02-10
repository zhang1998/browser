package com.ucpro.feature.l.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.l.a.a.a;
import com.ucweb.common.util.c;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class b extends FrameLayout implements d, a, com.ucpro.feature.l.a.a.d {
    private g a = null;
    private RecyclerView b;
    private a c;
    private long d = 0;
    private m e;
    private com.ucpro.ui.a.a f = new com.ucpro.ui.a.a(getContext());

    public b(Context context) {
        super(context);
        this.f.setVisibility(8);
        this.b = new RecyclerView(getContext());
        this.b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.c = new a(getContext());
        this.c.e = this;
        this.b.setAdapter(this.c);
        addView(this.f);
        addView(this.b);
    }

    public final void a() {
        if (com.ucpro.c.b.b()) {
            Log.e("vanda", "onEnter");
        }
    }

    public final boolean b() {
        if (this.d == 0 || this.e == null) {
            return false;
        }
        this.d = this.e.d;
        this.e = null;
        if (this.a != null) {
            this.a.a(this.d, d());
        }
        return true;
    }

    public final String getPageTitle() {
        return com.ucpro.ui.c.a.d((int) R.string.discover_page_bookmark_page_title);
    }

    public final void c() {
        if (this.c != null) {
            this.c.b();
            this.c.a.a();
        }
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        c.b(bVar instanceof g);
        this.a = (g) bVar;
        this.a.a(this.d, d());
    }

    private ValueCallback<ArrayList<m>> d() {
        return new f(this);
    }

    public final void a(m mVar) {
        if (this.d == 0 && mVar != null) {
            this.e = mVar;
            this.d = mVar.b;
            if (this.a != null) {
                this.a.a(this.d, d());
            }
        }
    }

    public final void a(m mVar, View view, Drawable drawable, boolean z) {
        if (this.a == null) {
            return;
        }
        if (z) {
            this.a.a(mVar.e, mVar.f, view, drawable);
        } else {
            this.a.a(mVar.e, mVar.f, (ImageView) view);
        }
    }

    public final void a(String str, ImageView imageView, Drawable drawable) {
        if (this.a != null) {
            this.a.a(str, imageView, drawable, null);
        }
    }

    public final void b(m mVar) {
        if (this.a != null) {
            this.a.a(mVar);
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9514032");
    }

    public final String getPageName() {
        return "Page_find_bookmark";
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        int i;
        if (z && !bVar.f.b()) {
            bVar.f.a("lottie/bookmark_empty/data.json", "lottie/bookmark_empty/images", "lottie/bookmark_empty/images_night");
            bVar.f.setText(com.ucpro.ui.c.a.d((int) R.string.empty_error_anim_page_bookmark_empty));
        }
        com.ucpro.ui.a.a aVar = bVar.f;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        aVar.setVisibility(i);
    }
}
