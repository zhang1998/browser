package com.ucpro.feature.g.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.feature.g.b.a.b;
import com.ucpro.feature.g.c.b.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import hugo.weaving.DebugLog;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class d extends j implements OnClickListener, c, com.ucpro.business.stat.a.d, com.ucpro.feature.g.b.a.c, l, com.ucpro.ui.e.a.c {
    private n g;
    private View h = findViewById(R.id.sync_page_logo);
    private TextView i = ((TextView) findViewById(R.id.sync_page_allow_tip));
    private FrameLayout j;
    private b k;
    private TextView l;
    private LinearLayout m;
    private TextView n;
    private TextView o;

    public d(Context context) {
        super(context);
        setWindowCallBacks(this);
        this.f.a(a.d((int) R.string.cloud_sync));
        this.f.a(a.a("back.svg"));
        LayoutInflater.from(getContext()).inflate(R.layout.cloud_sync_page, this.e, true);
        this.i.setText(a.d((int) R.string.cloud_sync_sync_content) + ": " + a.d((int) R.string.cloud_sync_sync_desc));
        this.i.setOnClickListener(this);
        this.j = (FrameLayout) findViewById(R.id.sync_page_sync_btn_container);
        this.k = new b(getContext());
        this.k.setOnSyncClick(this);
        this.j.addView(this.k);
        this.l = (TextView) findViewById(R.id.sync_page_import_uc);
        this.l.setOnClickListener(this);
        this.m = (LinearLayout) findViewById(R.id.sync_page_exit_container);
        this.n = (TextView) findViewById(R.id.sync_page_exit_account);
        this.o = (TextView) findViewById(R.id.sync_page_exit_stat);
        this.m.setOnClickListener(this);
        this.e.setBackgroundColor(a.c("default_background_white"));
        this.i.setTextColor(a.c("default_maintext_gray"));
        this.h.setBackgroundDrawable(a.a("cloud_logo.svg"));
        Drawable gVar = new g();
        gVar.setColor(a.c("default_purpleblue"));
        this.l.setBackgroundDrawable(gVar);
        this.l.setTextColor(a.c("default_background_white"));
        this.n.setTextColor(a.c("default_maintext_gray"));
        this.o.setTextColor(a.c("default_purpleblue"));
    }

    public final void a(f fVar, View view, ad adVar) {
        com.ucpro.base.a.g.a().a(e.bS, Boolean.valueOf(true));
    }

    public final void a(f fVar, View view, w wVar) {
    }

    @DebugLog
    public final void a(boolean z) {
        this.g.a(z);
    }

    @DebugLog
    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    @DebugLog
    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof d) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.g.b();
        return true;
    }

    @DebugLog
    public final View a(View view) {
        if (view instanceof com.ucpro.base.c.b.g) {
            return this.g.a((com.ucpro.base.c.b.g) view);
        }
        return null;
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.g = (n) bVar;
        if (this.g.a()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.k.a(this.g.f());
        if (!this.g.g()) {
            c();
        }
    }

    private void c() {
        this.l.setVisibility(8);
    }

    public final ArrayList<com.ucpro.ui.e.e> getConfig() {
        return null;
    }

    public final void a() {
        this.g.d();
    }

    public final void a(String str) {
        this.k.a(str);
    }

    public final void b(String str) {
        b bVar = this.k;
        bVar.c = false;
        bVar.b.a();
        bVar.a.setText(a.d((int) R.string.cloud_sync_sync));
        bVar.a.setClickable(true);
        if (this.n != null) {
            this.n.setText(str);
        }
    }

    public final void b() {
        c();
    }

    public final void onClick(View view) {
        if (view == this.i) {
            return;
        }
        if (view == this.m) {
            this.g.c();
        } else if (view == this.l) {
            this.g.e();
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102078");
    }

    public final String getPageName() {
        return "Page_cloud_sync";
    }
}
