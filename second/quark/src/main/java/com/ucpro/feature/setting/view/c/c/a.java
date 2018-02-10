package com.ucpro.feature.setting.view.c.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.a.g;
import com.ucpro.c.d;
import com.ucpro.feature.setting.a.b;
import com.ucpro.feature.setting.a.h;
import com.ucpro.feature.setting.view.c.c;

/* compiled from: ProGuard */
public final class a extends FrameLayout implements OnClickListener, c {
    private View a = null;
    private View b = null;
    private TextView c = null;
    private TextView d = null;
    private View e = null;
    private TextView f = null;
    private View g = null;
    private TextView h = null;
    private View i = null;
    private TextView j = null;
    private View k = null;
    private TextView l = null;
    private TextView m = null;
    private TextView n = null;
    private View o = null;
    private TextView p = null;
    private LinearLayout q = null;
    private LinearLayout r = null;
    private LinearLayout s = null;
    private com.ucpro.feature.setting.view.c.a t;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.setting_about, this, true);
        this.a = findViewById(R.id.setting_about_head_blue);
        this.b = findViewById(R.id.setting_about_logo);
        this.c = (TextView) findViewById(R.id.setting_about_version);
        this.c.setText((d.a() ? com.ucpro.ui.c.a.d((int) R.string.about_version_prefix) : "") + "2.4.1.985");
        this.d = (TextView) findViewById(R.id.setting_about_core_stat);
        String d = com.ucpro.ui.c.a.d((int) R.string.about_setting_view_webcore_info);
        Object[] objArr = new Object[1];
        objArr[0] = g.h() ? "2.0" : "1.0";
        this.d.setText(String.format(d, objArr));
        this.e = findViewById(R.id.setting_about_function_icon);
        this.f = (TextView) findViewById(R.id.setting_about_function_text);
        this.f.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_window_function));
        this.g = findViewById(R.id.setting_about_version_check_icon);
        this.h = (TextView) findViewById(R.id.setting_about_version_check_text);
        this.h.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_window_upgrade));
        this.i = findViewById(R.id.setting_about_share_icon);
        this.j = (TextView) findViewById(R.id.setting_about_share_text);
        this.j.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_window_share));
        this.k = findViewById(R.id.setting_about_bottom_green);
        this.l = (TextView) findViewById(R.id.setting_about_agreement);
        this.l.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_view_useragreement));
        this.m = (TextView) findViewById(R.id.setting_about_privacy_agreement);
        this.m.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_view_privacy_agreement));
        if (d.b()) {
            this.m.setText("| " + this.m.getText());
        }
        this.n = (TextView) findViewById(R.id.setting_about_forum);
        this.n.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_view_forum));
        if (d.b()) {
            this.n.setText("| " + this.n.getText());
        }
        this.q = (LinearLayout) findViewById(R.id.setting_about_function_container);
        this.s = (LinearLayout) findViewById(R.id.setting_about_version_check_container);
        this.r = (LinearLayout) findViewById(R.id.setting_about_share_container);
        this.o = findViewById(R.id.setting_about_uc_icon);
        this.p = (TextView) findViewById(R.id.setting_about_uc_text);
        this.p.setText(com.ucpro.ui.c.a.d((int) R.string.about_setting_view_uc));
        this.b.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        a();
    }

    public final void setAdapter(b bVar) {
    }

    public final b getAdapter() {
        return null;
    }

    public final void a() {
        this.a.setBackgroundDrawable(com.ucpro.ui.c.a.a("setting_about_head.svg"));
        this.b.setBackgroundDrawable(com.ucpro.ui.c.a.a("home_logo.svg"));
        this.c.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.d.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.e.setBackgroundDrawable(com.ucpro.ui.c.a.a("setting_about_function_icon.svg"));
        this.f.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.g.setBackgroundDrawable(com.ucpro.ui.c.a.a("setting_about_update.svg"));
        this.h.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.i.setBackgroundDrawable(com.ucpro.ui.c.a.a("setting_about_share.svg"));
        this.j.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.k.setBackgroundDrawable(com.ucpro.ui.c.a.a("setting_about_foot.svg"));
        this.l.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.m.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.n.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.o.setBackgroundDrawable(com.ucpro.ui.c.a.a("setting_about_uc.svg"));
        this.p.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
    }

    public final void setSettingViewCallback(com.ucpro.feature.setting.view.c.a aVar) {
        this.t = aVar;
    }

    public final View getSettingView() {
        return this;
    }

    public final void onClick(View view) {
        int i = -1;
        if (view == this.s) {
            i = h.m;
        } else if (view == this.r) {
            i = h.n;
        } else if (view == this.q) {
            i = h.o;
        } else if (view == this.b) {
            i = h.t;
        } else if (view == this.l) {
            i = h.p;
        } else if (view == this.m) {
            i = h.q;
        } else if (view == this.n) {
            i = h.r;
        }
        if (this.t != null) {
            this.t.a(null, i, Integer.valueOf(i));
        }
    }
}
