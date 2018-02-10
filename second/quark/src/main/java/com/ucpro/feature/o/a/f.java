package com.ucpro.feature.o.a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.feature.g.a.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.i;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class f extends j implements TextWatcher, OnClickListener, g {
    private View g = LayoutInflater.from(getContext()).inflate(R.layout.personal_login_page, this.e, false);
    private ImageView h;
    private TextView i;
    private TextView j;
    private View k;
    private MaterialEditText l;
    private TextView m;
    private View n;
    private MaterialEditText o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private b u;
    private String v;
    private a w;

    public f(Context context) {
        super(context);
        this.f.a("");
        this.f.a(a.a("back.svg"));
        this.e.addView(this.g, new LayoutParams(-1, -1));
        this.h = (ImageView) this.g.findViewById(R.id.personal_login_image);
        this.i = (TextView) this.g.findViewById(R.id.personal_login_title);
        this.i.setTypeface(null, 1);
        this.j = (TextView) this.g.findViewById(R.id.personal_login_subtitle);
        this.k = this.g.findViewById(R.id.personal_login_phone_container);
        this.l = (MaterialEditText) this.g.findViewById(R.id.personal_login_phone_edit);
        this.l.setHint(a.d((int) R.string.cloud_sync_phone_number));
        this.l.setFloatingLabelText(a.d((int) R.string.cloud_sync_phone_number));
        this.l.setShowClearButton(false);
        this.l.setUnderLineHight(a.c((int) R.dimen.clound_sync_edit_under_line_height));
        this.l.setUnderLineSelectHight(a.c((int) R.dimen.clound_sync_edit_under_line_select_height));
        this.l.setInputType(2);
        this.m = (TextView) this.g.findViewById(R.id.personal_login_get_idcode_btn);
        this.m.setTypeface(null, 1);
        this.n = this.g.findViewById(R.id.personal_login_idcode_container);
        this.o = (MaterialEditText) this.g.findViewById(R.id.personal_login_idcode_edit);
        this.o.setHint(a.d((int) R.string.cloud_sync_verif_code));
        this.o.setFloatingLabelText(a.d((int) R.string.cloud_sync_verif_code));
        this.o.setShowClearButton(false);
        this.o.setUnderLineHight(a.c((int) R.dimen.clound_sync_edit_under_line_height));
        this.o.setUnderLineSelectHight(a.c((int) R.dimen.clound_sync_edit_under_line_select_height));
        this.o.setInputType(2);
        this.p = (TextView) this.g.findViewById(R.id.personal_login_retrieve_idcode_btn);
        this.p.setTypeface(null, 1);
        this.q = (TextView) this.g.findViewById(R.id.personal_login_send_tip);
        this.r = (ImageView) this.g.findViewById(R.id.personal_login_weibo);
        this.s = (ImageView) this.g.findViewById(R.id.personal_login_weixin);
        this.t = (ImageView) this.g.findViewById(R.id.personal_login_qq);
        this.t.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.o.addTextChangedListener(this);
        this.v = a.d((int) R.string.cloud_sync_again_verif_code);
        this.u = new i(this);
        l();
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
        com.ucweb.common.util.f.a(getContext(), (View) this);
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, w wVar) {
    }

    public final void l() {
        super.l();
        this.g.setBackgroundColor(a.c("default_background_white"));
        this.h.setImageDrawable(a.a("personal_default_icon.png"));
        this.i.setTextColor(a.c("default_maintext_gray"));
        this.j.setTextColor(a.c("default_assisttext_gray"));
        this.m.setTextColor(a.c("default_purpleblue"));
        this.l.setMetTextColor(a.c("default_maintext_gray"));
        this.l.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.l.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.l.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.l.setUnderlineColor(a.c("default_icon_gray"));
        this.o.setMetTextColor(a.c("default_maintext_gray"));
        this.o.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.o.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.o.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.o.setUnderlineColor(a.c("default_icon_gray"));
        this.q.setTextColor(a.c("default_commentstext_gray"));
        this.q.setBackgroundDrawable(new i(a.c((int) R.dimen.personal_send_tip_radius), a.c("default_frame_gray")));
        this.r.setImageDrawable(a.a("cloud_weibo.svg"));
        this.s.setImageDrawable(a.a("cloud_weixin.svg"));
        this.t.setImageDrawable(a.a("cloud_qq.svg"));
    }

    public final void onClick(View view) {
        if (this.w != null) {
            if (view == this.r) {
                this.w.a();
            } else if (view == this.t) {
                this.w.b();
            } else if (view == this.s) {
                this.w.c();
            } else if (view == this.m) {
                r0 = this.l.getText();
                this.w.a(r0 != null ? r0.toString() : "");
            } else if (view == this.p) {
                r0 = this.l.getText();
                this.w.a(r0 != null ? r0.toString() : "");
            }
        }
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.w = (a) bVar;
    }

    public final void a() {
        this.s.setVisibility(8);
    }

    public final void a(String str) {
        this.k.setVisibility(8);
        this.n.setVisibility(0);
        this.q.setText(a.d((int) R.string.personal_login_send_tip_pre) + str);
        this.p.setTextColor(a.c("default_icon_gray"));
        this.p.setEnabled(false);
        this.u.b();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (this.w != null && editable == this.o.getEditableText() && editable.length() == 4) {
            com.ucweb.common.util.f.a(this.o.getContext(), this.o);
            Editable text = this.l.getText();
            Editable text2 = this.o.getText();
            this.w.a(text != null ? text.toString() : "", text2 != null ? text2.toString() : "");
        }
    }
}
