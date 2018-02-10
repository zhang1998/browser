package com.ucpro.feature.aa.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.base.c.b.c;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucpro.ui.edittext.j;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.af;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public final class d extends p implements com.ucpro.business.stat.a.d, af {
    private c e;
    private LinearLayout f = new LinearLayout(getContext());
    private j g;
    private CustomEditText h;
    private f i;
    private TextView j;

    public d(Context context) {
        super(context);
        this.f.setOrientation(1);
        b(this.f);
        f fVar = new f(getContext());
        this.i = fVar;
        fVar.a(a.a("back.svg"), null);
        fVar.a(a.a("bookmark_confirm.svg"), null);
        fVar.a(a.d((int) R.string.user_feedback_title));
        fVar.f = this;
        this.f.addView(fVar.a, new LayoutParams(-1, -2));
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        this.f.addView(linearLayout, new LayoutParams(-1, -2));
        int c = a.c((int) R.dimen.user_feedback_content_textsize);
        this.h = new CustomEditText(getContext());
        this.h.setBackgroundColor(0);
        this.h.setGravity(51);
        this.h.a(0, (float) c);
        this.h.setHint(a.d((int) R.string.user_feedback_content_inputbox_hint_text));
        this.h.a(new m(this));
        int c2 = a.c((int) R.dimen.user_feedback_content_input_box_padding_x);
        int c3 = a.c((int) R.dimen.user_feedback_content_input_box_padding_y);
        this.h.setPadding(c2, c3, c2, c3);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, a.c((int) R.dimen.user_feedback_content_input_box_height));
        layoutParams.topMargin = a.c((int) R.dimen.user_feedback_content_input_box_margin_top);
        c2 = a.c((int) R.dimen.user_feedback_content_input_box_margin_x);
        layoutParams.bottomMargin = a.c((int) R.dimen.user_feedback_content_input_box_margin_bottom);
        layoutParams.rightMargin = c2;
        layoutParams.leftMargin = c2;
        linearLayout.addView(this.h, layoutParams);
        this.g = new j(getContext());
        this.g.a(0, (float) c);
        this.g.setPadding(0, 0, 0, 0);
        this.g.setSingleLine(true);
        this.g.setGravity(16);
        this.g.setBackgroundColor(0);
        this.g.setHint(a.d((int) R.string.user_feedback_contact_inputbox_hint_text));
        layoutParams = new LayoutParams(-1, a.c((int) R.dimen.user_feedback_contact_input_box_height));
        layoutParams.rightMargin = c2;
        layoutParams.leftMargin = c2;
        linearLayout.addView(this.g, layoutParams);
        if (!com.ucpro.b.a.a.b()) {
            this.j = new TextView(getContext());
            String d = a.d((int) R.string.user_feedback_bbs_tip);
            CharSequence spannableString = new SpannableString(d + a.d((int) R.string.bbs_name));
            spannableString.setSpan(new ForegroundColorSpan(a.c("user_feedback_bbs_name_highlight_color")), d.length(), spannableString.length(), 33);
            this.j.setTextColor(a.c("user_feedback_bbs_tip_color"));
            this.j.setText(spannableString);
            this.j.setTextSize(0, (float) a.c((int) R.dimen.user_feedback_bbs_tip_textsize));
            this.j.setOnClickListener(new k(this));
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
            layoutParams2.rightMargin = c2;
            layoutParams2.leftMargin = c2;
            layoutParams2.topMargin = c2 / 2;
            this.f.addView(this.j, layoutParams2);
        }
        l();
    }

    public final String getContent() {
        return this.h.getText().toString();
    }

    public final String getContact() {
        return this.g.getText().toString();
    }

    public final void a() {
        this.h.setText((CharSequence) "");
    }

    public final void b() {
        this.h.requestFocus();
        com.ucweb.common.util.f.c(getContext());
    }

    public final void c() {
        if (this.i != null) {
            f fVar = this.i;
            fVar.d.setImageDrawableWithClipAnimation(a.a("bookmark_confirm.svg"));
        }
    }

    public final void l() {
        super.l();
        this.f.setBackgroundColor(a.c("default_background_white"));
        int c = a.c("default_maintext_gray");
        int c2 = a.c("user_feedback_hint_text_color");
        this.h.setTextColor(c);
        this.h.setBackgroundDrawable(a.a("user_feedback_content_input_box_bg.xml"));
        this.h.setHintTextColor(c2);
        this.g.setTextColor(c);
        this.g.setHintTextColor(c2);
        this.g.setBottomLineColor(a.c("user_feedback_contact_input_box_bottom_line_color"));
    }

    public final void setPresenter(b bVar) {
        this.e = (c) bVar;
        setWindowCallBacks((c) bVar);
    }

    public final void a(f fVar, View view, ad adVar) {
        this.e.a();
    }

    public final void a(f fVar, View view, w wVar) {
        this.e.c();
    }

    public final void setTitle(String str) {
        if (this.i != null) {
            this.i.a(str);
        }
    }

    public final void setContentTip(String str) {
        if (this.h != null) {
            this.h.setHint((CharSequence) str);
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102289");
    }

    public final String getPageName() {
        return "Page_quark_feedback";
    }
}
