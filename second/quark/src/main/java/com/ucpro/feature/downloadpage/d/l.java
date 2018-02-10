package com.ucpro.feature.downloadpage.d;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.c.b.c;
import com.ucpro.base.d.b;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.a.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class l extends j implements d, f, w {
    t g;
    protected ValueCallback h = new s(this);
    private Context i;
    private q j;
    private RecyclerView k;
    private a l;
    private c m = new e(this);

    public l(Context context) {
        super(context);
        this.i = context;
        this.f.a(com.ucpro.ui.c.a.d((int) R.string.m3u8_cache));
        this.f.a(null, null);
        setWindowCallBacks(this.m);
        this.l = new a(this.i);
        this.l.setVisibility(8);
        this.k = new RecyclerView(this.i);
        this.k.setLayoutParams(new LayoutParams(-1, -1));
        this.k.setLayoutManager(new LinearLayoutManager(this.i));
        this.g = new t(getContext());
        this.g.e = this;
        this.k.setAdapter(this.g);
        this.e.addView(this.l, new LayoutParams(-1, -1));
        this.e.addView(this.k, new LayoutParams(-1, -2));
        LayoutParams layoutParams = (LayoutParams) this.k.getLayoutParams();
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.download_store_height);
        this.k.setLayoutParams(layoutParams);
        new FrameLayout.LayoutParams(-1, -2).gravity = 80;
    }

    public final void f() {
        super.f();
    }

    public final void l() {
        super.l();
    }

    public final void setPresenter(b bVar) {
        this.j = (q) bVar;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void a(boolean z) {
        com.ucpro.feature.video.d.a.a();
        this.j.a(this.h, z);
    }

    public final Activity getActivity() {
        return (Activity) this.i;
    }

    public final void a(f fVar, View view, ad adVar) {
        this.j.a();
    }

    public final void a(f fVar, View view, w wVar) {
    }

    @DebugLog
    public final void a(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.j.a(bVar, false);
    }

    @DebugLog
    public final void b(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.j.a(bVar, true);
    }

    @DebugLog
    public final void c(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.j.b(bVar);
    }

    @DebugLog
    public final void d(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.j.c(bVar);
    }

    @DebugLog
    public final void e(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.j.a(bVar);
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9457494");
    }

    public final String getPageName() {
        return "Page_video_cache";
    }
}
