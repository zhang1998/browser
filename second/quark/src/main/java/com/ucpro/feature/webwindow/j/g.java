package com.ucpro.feature.webwindow.j;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.d.b;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class g extends m implements d, v {
    private ATTextView e;
    private RecyclerView f;
    private r g;
    private LinearLayout h;
    private ATTextView i;

    public g(Context context) {
        super(context);
    }

    public final void setPresenter(b bVar) {
        this.g = (r) bVar;
    }

    public final String getTitleText() {
        return a.d((int) R.string.ad_block_rule_window_title);
    }

    public final void a() {
        this.h = new LinearLayout(getContext());
        this.h.setOrientation(1);
        getContentLayer().addView(this.h, new LayoutParams(-1, -1));
        this.i = new ATTextView(getContext());
        this.i.setTextSize(0, a.a((int) R.dimen.setting_item_view_default_title_text_size));
        this.i.setText(R.string.ad_block_rule_title_view_text);
        this.i.setPadding(a.c((int) R.dimen.setting_item_view_default_padding_left), 0, a.c((int) R.dimen.setting_item_view_default_padding_right), 0);
        this.i.setGravity(16);
        this.h.addView(this.i, new LinearLayout.LayoutParams(-1, a.c((int) R.dimen.main_setting_view_item_height)));
        this.i.setTextColorResName("default_maintext_gray");
        this.i.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
    }

    public final void b() {
        if (!(this.f == null || this.f.getParent() == null)) {
            this.h.removeView(this.f);
        }
        this.e = new ATTextView(getContext());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 48;
        this.e.setTextColor(a.c("default_assisttext_gray"));
        this.e.setTextSize(0, a.a((int) R.dimen.ad_block_rule_view_empty_text_size));
        this.e.setText(a.d((int) R.string.ad_block_rule_empty_view_text));
        this.e.setPadding(a.c((int) R.dimen.setting_item_view_default_padding_left), 0, a.c((int) R.dimen.setting_item_view_default_padding_right), 0);
        this.h.addView(this.e, layoutParams);
    }

    public final void a(a aVar) {
        if (!(this.e == null || this.e.getParent() == null)) {
            this.h.removeView(this.e);
        }
        this.f = new RecyclerView(getContext());
        this.f.setOverScrollMode(2);
        this.f.setAdapter(aVar);
        this.f.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f.a(new e(this, a.c((int) R.dimen.ad_block_rule_view_list_divider_height)));
        this.h.addView(this.f, new LayoutParams(-1, -1));
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102193");
    }

    public final String getPageName() {
        return "Page_adblock";
    }
}
