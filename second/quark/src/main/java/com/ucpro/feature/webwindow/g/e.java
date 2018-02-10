package com.ucpro.feature.webwindow.g;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucpro.ui.edittext.f;

/* compiled from: ProGuard */
public final class e extends j implements OnClickListener, k {
    private d a;
    private b b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private View f = null;
    private View g = null;
    private int h;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o;

    public e(Context context, int i) {
        super(context);
        this.h = i;
        this.i = a.c((int) R.dimen.search_in_page_close_padding);
        this.j = a.c((int) R.dimen.search_in_page_backward_left_margin);
        this.k = a.c((int) R.dimen.search_in_page_forward_right_margin);
        this.l = a.c((int) R.dimen.search_in_page_backwark_padding);
        this.m = a.c((int) R.dimen.search_in_page_forward_padding);
        this.n = a.c((int) R.dimen.search_in_page_image_size);
        this.o = a.c((int) R.dimen.search_address_bar_shadow_height);
        setClickable(true);
        this.f = new View(getContext());
        addView(this.f);
        this.c = new ImageView(getContext());
        this.c.setPadding(this.i, 0, this.i, 0);
        this.c.setClickable(true);
        this.c.setOnClickListener(this);
        addView(this.c);
        this.b = new b(getContext(), this.h);
        this.b.setSearchInPageTextCallback(this);
        addView(this.b);
        this.d = new ImageView(getContext());
        this.d.setPadding(this.l, 0, this.l, 0);
        this.d.setClickable(true);
        this.d.setOnClickListener(this);
        addView(this.d);
        this.e = new ImageView(getContext());
        this.e.setPadding(this.m, 0, this.m, 0);
        this.e.setClickable(true);
        this.e.setOnClickListener(this);
        addView(this.e);
        this.g = new View(getContext());
        addView(this.g);
        c();
    }

    public final int getSearchPageHeight() {
        return this.h + this.o;
    }

    public final void a() {
        this.b.a.requestFocus();
    }

    public final void b() {
        CustomEditText customEditText = this.b.a;
        customEditText.postDelayed(new f(customEditText), 80);
    }

    public final void c() {
        this.g.setBackgroundDrawable(a.a("searchpage_address_bar_input_shadow.png"));
        this.c.setImageDrawable(a.a("search_in_page_close.svg"));
        this.d.setImageDrawable(a.a("search_in_page_backward.svg"));
        this.e.setImageDrawable(a.a("search_in_page_forward.svg"));
        this.b.a();
        this.f.setBackgroundColor(a.c("search_in_page_bg_color"));
        a(false, false);
    }

    public final void setPresenter(b bVar) {
        this.a = (d) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.h + this.o, UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec((this.i + this.n) + this.i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK));
        this.d.measure(MeasureSpec.makeMeasureSpec((this.l + this.n) + this.l, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK));
        this.e.measure(MeasureSpec.makeMeasureSpec((this.m + this.n) + this.m, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK));
        this.b.measure(MeasureSpec.makeMeasureSpec(((((getMeasuredWidth() - this.c.getMeasuredWidth()) - this.e.getMeasuredWidth()) - this.d.getMeasuredWidth()) - this.j) - this.k, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK));
        this.g.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.o, UCCore.VERIFY_POLICY_QUICK));
        this.f.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK));
    }

    public final void a(int i, int i2) {
        int i3 = false;
        if (i2 > 0) {
            i3 = i + 1;
            a(true, true);
        } else {
            a(false, false);
        }
        this.b.a(i3, i2);
    }

    private void a(boolean z, boolean z2) {
        if (z) {
            if (this.e.getBackground() != null) {
                this.e.getBackground().setAlpha(255);
            }
        } else if (this.e.getBackground() != null) {
            this.e.getBackground().setAlpha(128);
        }
        if (z2) {
            if (this.d.getBackground() != null) {
                this.d.getBackground().setAlpha(255);
            }
        } else if (this.d.getBackground() != null) {
            this.d.getBackground().setAlpha(128);
        }
        this.e.setEnabled(z);
        this.d.setEnabled(z2);
    }

    public final void onClick(View view) {
        if (this.a == null) {
            return;
        }
        d dVar;
        if (view == this.c) {
            dVar = this.a;
            if (dVar.a != null) {
                dVar.a.p();
            }
        } else if (view == this.d) {
            dVar = this.a;
            com.ucweb.common.util.f.a(dVar.a.getContext(), dVar.a);
            dVar.a.a(false);
        } else if (view == this.e) {
            dVar = this.a;
            com.ucweb.common.util.f.a(dVar.a.getContext(), dVar.a);
            dVar.a.a(true);
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight = this.g.getMeasuredHeight();
        this.f.layout(0, measuredHeight, getMeasuredWidth() + 0, this.f.getMeasuredHeight() + measuredHeight);
        this.g.layout(0, 0, getMeasuredWidth(), this.g.getMeasuredHeight());
        measuredHeight = this.g.getMeasuredHeight();
        this.c.layout(0, measuredHeight, this.c.getMeasuredWidth(), this.c.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.c.getMeasuredWidth();
        int measuredHeight2 = this.g.getMeasuredHeight();
        this.b.layout(measuredHeight, measuredHeight2, this.c.getMeasuredWidth() + this.b.getMeasuredWidth(), this.b.getMeasuredHeight() + measuredHeight2);
        measuredHeight = (this.c.getMeasuredWidth() + this.b.getMeasuredWidth()) + this.j;
        measuredHeight2 = this.g.getMeasuredHeight();
        this.d.layout(measuredHeight, measuredHeight2, this.d.getMeasuredWidth() + measuredHeight, this.d.getMeasuredHeight() + measuredHeight2);
        measuredHeight = ((this.c.getMeasuredWidth() + this.b.getMeasuredWidth()) + this.j) + this.e.getMeasuredWidth();
        measuredHeight2 = this.g.getMeasuredHeight();
        this.e.layout(measuredHeight, measuredHeight2, this.e.getMeasuredWidth() + measuredHeight, this.e.getMeasuredHeight() + measuredHeight2);
    }

    public final void a(CharSequence charSequence) {
        if (this.a != null) {
            d dVar = this.a;
            if (com.ucweb.common.util.n.a.a(String.valueOf(charSequence))) {
                dVar.b.a(0, 0);
            }
            if (charSequence != null) {
                dVar.a.a(String.valueOf(charSequence).trim());
            }
        }
    }
}
