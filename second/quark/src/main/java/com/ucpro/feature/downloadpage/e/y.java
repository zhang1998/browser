package com.ucpro.feature.downloadpage.e;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.d.b;
import com.ucpro.feature.downloadpage.a.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class y extends j implements OnClickListener, OnFocusChangeListener, OnEditorActionListener, c, m {
    private MaterialEditText g;
    private String h;
    private g i;
    private j j;

    public y(Context context, g gVar) {
        this(context);
        this.i = gVar;
        this.h = this.i.k();
        this.i.dismiss();
        setWindowCallBacks(this);
        this.f.a(a.d((int) R.string.download_rename));
        this.f.a(a.a("bookmark_confirm.svg"), null);
        this.g = new MaterialEditText(getContext());
        this.g.setImeOptions(2);
        this.g.setOnEditorActionListener(this);
        this.g.setPaddings(a.c((int) R.dimen.bookmark_edittext_margin_left), a.c((int) R.dimen.bookmark_edittext_margin_top), a.c((int) R.dimen.bookmark_edittext_margin_right), 0);
        this.g.setTextSize(0, a.a((int) R.dimen.bookmark_edittext_text_size));
        this.g.setClickable(true);
        this.g.setFloatingLabel(2);
        this.g.setSingleLine();
        this.g.setSingleLineEllipsis();
        this.g.setHint(a.d((int) R.string.bookmark_revise_name));
        this.g.setFloatingLabelText(a.d((int) R.string.bookmark_revise_name));
        this.g.setShowClearButton(false);
        this.g.setText(this.h);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        this.e.addView(this.g, layoutParams);
        this.g.requestFocus();
        this.g.postDelayed(new w(this), 120);
        l();
    }

    private y(Context context) {
        super(context);
        this.h = "";
    }

    public final void setPresenter(b bVar) {
        this.j = (j) bVar;
    }

    public final void l() {
        super.l();
        this.e.setBackgroundColor(a.c("default_background_white"));
        this.g.setMetTextColor(a.c("default_maintext_gray"));
        this.g.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.g.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.g.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.f.a(a.a("back.svg"));
    }

    public final void a(f fVar, View view, ad adVar) {
        com.ucweb.common.util.f.a(getContext(), (View) this);
        com.ucpro.base.a.g.a().a(e.cX);
        c();
    }

    public final void a(f fVar, View view, w wVar) {
        com.ucweb.common.util.f.a(getContext(), (View) this);
        b();
    }

    private void b() {
        Object obj = 1;
        if ((!com.ucweb.common.util.n.a.c(this.h, this.g.getText().toString()) ? 1 : null) == null || !this.j.a(this.g.getText().toString())) {
            obj = null;
        }
        if (obj == null) {
            if (this.i != null) {
                this.i.a(this.g.getText());
            }
            com.ucpro.base.a.g.a().a(e.cX);
            c();
        }
    }

    public final void onClick(View view) {
        com.ucweb.common.util.f.a(getContext(), view);
    }

    public final void onFocusChange(View view, boolean z) {
    }

    public final void a() {
    }

    public final void a(long j, long j2) {
    }

    public final Activity getActivity() {
        while (true) {
        }
    }

    public final void a(boolean z) {
        com.ucpro.base.a.g.a().a(e.cX, Boolean.valueOf(false));
        c();
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cX, Boolean.valueOf(false));
        c();
        return true;
    }

    public final View a(View view) {
        if (view instanceof com.ucpro.base.c.b.g) {
            return this.j.a((com.ucpro.base.c.b.g) view);
        }
        return null;
    }

    private void c() {
        if (this.i != null) {
            this.i.show();
        }
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        switch (i) {
            case 2:
                b();
                break;
        }
        return true;
    }
}
