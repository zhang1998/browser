package com.ucpro.feature.bookmarkhis.bookmark;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class r extends j {
    private Context g;
    private MaterialEditText h = ((MaterialEditText) this.i.findViewById(R.id.bm_et_folder_name));
    private View i = LayoutInflater.from(this.g).inflate(R.layout.bookmark_new_folder, null);

    public r(Context context) {
        super(context);
        this.g = context;
        this.f.a(a.d((int) R.string.bookmark_new_folder));
        this.f.a(a.a("bookmark_confirm.svg"), null);
        this.h.setHint(a.d((int) R.string.bookmark_new_folder));
        this.h.setFloatingLabelText(a.d((int) R.string.bookmark_new_folder));
        this.h.setShowClearButton(false);
        this.e.addView(this.i, new LayoutParams(-1, -1));
        l();
    }

    public final void l() {
        this.i.setBackgroundColor(a.c("default_background_white"));
        this.h.setMetTextColor(a.c("default_maintext_gray"));
        this.h.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.h.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.h.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.f.a(a.a("back.svg"));
    }

    public final void a(f fVar, View view, ad adVar) {
        com.ucweb.common.util.f.a(this.g, (View) this);
        g.a().a(e.aO);
    }

    public final void a(f fVar, View view, w wVar) {
        if (TextUtils.isEmpty(this.h.getText().toString())) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.bookmark_folder_not_null), 1);
            return;
        }
        m.a("bookmark", "bookmark_add_dir", new String[0]);
        com.ucweb.common.util.f.a(this.g, (View) this);
        g.a().a(e.aO, this.h.getText().toString());
    }
}
