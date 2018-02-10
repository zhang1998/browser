package com.ucpro.feature.bookmarkhis.bookmark;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.category.CategoryEditBar;
import com.ucpro.feature.bookmarkhis.bookmark.category.CategorySelectContainer;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import com.ucweb.common.util.c;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class m extends j implements OnClickListener, OnFocusChangeListener {
    CategoryEditBar g;
    private Context h;
    private MaterialEditText i;
    private MaterialEditText j;
    private CategorySelectContainer k;
    private com.ucpro.feature.bookmarkhis.bookmark.a.m l;
    private long m;
    private o n;

    public m(Context context, com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        this(context);
        this.h = context;
        if (mVar == null) {
            c.a("BookmarkReviseBarView BookmarkNode is null!!!");
        }
        this.l = mVar;
        this.f.a(a.d((int) R.string.bookmark_edit));
        this.f.a(a.a("bookmark_confirm.svg"), null);
        View frameLayout = new FrameLayout(getContext());
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.h).inflate(R.layout.bookmark_new_folder, null);
        this.i = (MaterialEditText) linearLayout.findViewById(R.id.bm_et_folder_name);
        this.j = (MaterialEditText) linearLayout.findViewById(R.id.bm_et_folder_content);
        this.i.setOnFocusChangeListener(this);
        this.j.setOnFocusChangeListener(this);
        this.i.setHint(a.d((int) R.string.bookmark_revise_name));
        this.i.setFloatingLabelText(a.d((int) R.string.bookmark_revise_name));
        this.i.setShowClearButton(false);
        this.i.setText(this.l.e);
        this.i.requestFocus();
        this.j.setHint(a.d((int) R.string.bookmark_revise_web));
        this.j.setFloatingLabelText(a.d((int) R.string.bookmark_revise_web));
        this.j.setShowClearButton(false);
        this.j.setText(this.l.f);
        this.k = new CategorySelectContainer(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = a.c((int) R.dimen.bookmark_revise_item_margin_left);
        layoutParams.rightMargin = a.c((int) R.dimen.bookmark_revise_item_margin_left);
        layoutParams.topMargin = a.c((int) R.dimen.bookmark_revise_item_margin_top);
        linearLayout.addView(this.k, layoutParams);
        frameLayout.addView(linearLayout);
        this.g = new CategoryEditBar(getContext());
        this.g.setVisibility(8);
        this.g.setEditMode(true);
        this.g.setOnClickListener(this);
        frameLayout.addView(this.g, new FrameLayout.LayoutParams(-1, -2));
        this.e.addView(frameLayout, new LinearLayout.LayoutParams(-1, -1));
        if (this.l.g()) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        }
        l();
    }

    private m(Context context) {
        super(context);
        this.m = -1;
    }

    public final void l() {
        super.l();
        this.e.setBackgroundColor(a.c("default_background_white"));
        this.i.setMetTextColor(a.c("default_maintext_gray"));
        this.i.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.i.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.i.setBaseColor(a.c("default_assisttext_gray"));
        this.j.setMetTextColor(a.c("default_maintext_gray"));
        this.j.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.j.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.j.setBaseColor(a.c("default_assisttext_gray"));
        this.f.a(a.a("back.svg"));
        this.k.a();
        this.g.setBackgroundColor(a.c("default_background_white"));
    }

    public final void a(com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        if (mVar == null) {
            this.m = -1;
        } else {
            this.m = mVar.b;
        }
    }

    public final void a(f fVar, View view, ad adVar) {
        com.ucweb.common.util.f.a(this.h, (View) this);
        g.a().a(e.aM, -1);
    }

    public final void a(f fVar, View view, w wVar) {
        int i = 1;
        com.ucweb.common.util.f.a(this.h, (View) this);
        int i2 = !com.ucweb.common.util.n.a.c(this.l.e, this.i.getText().toString()) ? 1 : 0;
        if (com.ucweb.common.util.n.a.c(this.l.f, this.j.getText().toString())) {
            i = 0;
        }
        if (!(i2 == 0 && i == 0)) {
            this.l.e = this.i.getText().toString();
            this.l.f = this.j.getText().toString();
            if (i2 != 0) {
                com.ucpro.business.stat.m.a("bookmark", "bookmark_revise_revise_title", new String[0]);
            }
            if (i != 0) {
                com.ucpro.business.stat.m.a("bookmark", "bookmark_revise_revise_address", new String[0]);
            }
        }
        com.ucpro.feature.bookmarkhis.bookmark.a.m mVar = this.l;
        if (!com.ucweb.common.util.n.a.c(this.l.e, this.i.getText().toString())) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_revise_dir_revise_title", new String[0]);
        }
        if (mVar != null && mVar.h()) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_move_from_revise", new String[0]);
        }
        g.a().a(e.aM, (int) this.m, (int) this.m, mVar);
    }

    public final void onClick(View view) {
        o oVar;
        if (view == this.g.getCancelBtn()) {
            if (this.g.a) {
                oVar = this.n;
            } else {
                return;
            }
        } else if (view == this.g.getAddBtn()) {
            oVar = this.n;
            CharSequence editCategory = oVar.b.getEditCategory();
            if (editCategory == null || TextUtils.isEmpty(editCategory.toString().trim())) {
                com.ucpro.ui.b.e.a().a(a.d((int) R.string.bookmark_folder_not_null), 0);
            } else {
                s.a().a(com.ucpro.feature.bookmarkhis.bookmark.a.m.a(editCategory.toString()), new ag(oVar));
            }
        } else {
            return;
        }
        com.ucweb.common.util.f.a(oVar.a, oVar.b);
    }

    public final void onFocusChange(View view, boolean z) {
        if (view.getId() == R.id.bm_et_folder_name && z) {
            com.ucpro.business.stat.m.a("bookmark", this.m != -1 ? "bookmark_revise_dir_click_title" : "bookmark_revise_click_title", new String[0]);
        } else if (view.getId() == R.id.bm_et_folder_content && z) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_revise_click_address", new String[0]);
        }
    }

    public final void setPresenter(o oVar) {
        this.n = oVar;
    }

    public final void setAdapter(com.ucpro.feature.bookmarkhis.bookmark.category.f fVar) {
        this.k.setAdapter(fVar);
    }

    public final void a(int i) {
        this.g.setVisibility(0);
        this.g.setAlpha(0.0f);
        if (this.g.getMeasuredHeight() == 0) {
            this.g.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        }
        this.g.setTranslationY((float) ((i - this.f.a.getMeasuredHeight()) - this.g.getMeasuredHeight()));
        this.g.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).setListener(null).start();
        this.g.a(false);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        o oVar = this.n;
        oVar.g = new ad(oVar);
        oVar.a.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(oVar.g);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o oVar = this.n;
        oVar.a.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(oVar.g);
    }

    public final void a() {
        com.ucweb.common.util.f.c(this.g.getContext());
        this.g.getEditView().requestFocus();
    }

    public final CharSequence getEditCategory() {
        return this.g.getEditView().getEditText().getText();
    }
}
