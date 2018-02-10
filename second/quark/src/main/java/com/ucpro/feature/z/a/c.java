package com.ucpro.feature.z.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucpro.ui.widget.TextView;
import com.ucweb.common.util.p.b;

/* compiled from: ProGuard */
public final class c extends ViewGroup implements OnClickListener, e {
    private CustomEditText a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private j k;

    public c(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.d = a.c((int) R.dimen.search_address_bar_url_edittext_margin_left);
        this.e = a.c((int) R.dimen.search_address_bar_url_edittext_height);
        this.h = a.c((int) R.dimen.search_address_bar_clear_btn_width);
        this.i = a.c((int) R.dimen.search_address_url_action_btn_width);
        this.j = a.c((int) R.dimen.search_address_bar_padding_top);
        this.f = a.c((int) R.dimen.search_address_bar_url_edittext_padding_left);
        this.g = a.c((int) R.dimen.search_address_bar_url_edittext_padding_right);
        this.a = new CustomEditText(getContext());
        this.a.a(0, (float) a.c((int) R.dimen.search_address_bar_text_size));
        this.a.setSingleLine(true);
        this.a.setPadding(this.f, 0, (this.g + this.h) + this.f, 0);
        this.a.setTag(R.id.ui_auto, b.g);
        this.a.setHint(a.d((int) R.string.search_address_bar_hint_text));
        addView(this.a);
        this.b = new ImageView(getContext());
        this.b.setClickable(true);
        this.b.setPadding(this.f, 0, this.g, 0);
        this.b.setVisibility(8);
        this.b.setOnClickListener(this);
        addView(this.b);
        this.c = new TextView(getContext());
        this.c.setTextSize(0, (float) a.c((int) R.dimen.search_address_bar_text_size));
        this.c.setText(a.d((int) R.string.search_address_bar_text_cancel));
        this.c.setGravity(17);
        this.c.setClickable(true);
        this.c.setOnClickListener(this);
        this.c.setTag(R.id.ui_auto, b.d);
        addView(this.c);
        setOnClickListener(this);
        a();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        com.ucweb.common.util.c.a((Object) bVar);
        com.ucweb.common.util.c.b(bVar instanceof j);
        this.k = (j) bVar;
    }

    public final void a() {
        setBackgroundColor(a.c("search_address_bar_bg_color"));
        this.a.r();
        this.a.setTextColor(a.c("default_maintext_gray"));
        this.a.setHintTextColor(a.c("default_commentstext_gray"));
        this.a.setBackgroundDrawable(null);
        this.b.setImageDrawable(a.a("searchpage_search_bar_delete.svg"));
        this.c.setTextColor(a.d("searchpage_address_bar_action_btn_bg.xml"));
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.d) - this.i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.e, UCCore.VERIFY_POLICY_QUICK));
        this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(this.e, UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec(this.i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
    }

    public final void onClick(View view) {
        if (view == this.b) {
            if (this.k != null) {
                this.k.a();
            }
        } else if (view == this.c) {
            TextUtils.isEmpty(this.a.getText());
            if (this.k != null) {
                this.k.a(this.a.getText());
            }
        }
    }

    public final int getUrlEditTextWidth() {
        return this.a.getMeasuredWidth();
    }

    public final int getUrlEditTextHeight() {
        return this.a.getMeasuredHeight();
    }

    public final CustomEditText getUrlEditText() {
        return this.a;
    }

    public final ImageView getClearUrlButton() {
        return this.b;
    }

    public final TextView getUrlActionButton() {
        return this.c;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null && this.a.getVisibility() == 0) {
            int i5 = this.d;
            int measuredWidth = this.a.getMeasuredWidth() + i5;
            int i6 = this.j;
            this.a.layout(i5, i6, measuredWidth, this.a.getMeasuredHeight() + i6);
        }
        if (this.c != null && this.c.getVisibility() == 0) {
            i5 = getMeasuredWidth();
            i6 = (getMeasuredHeight() - this.c.getMeasuredHeight()) / 2;
            this.c.layout(i5 - this.c.getMeasuredWidth(), i6, i5, this.c.getMeasuredHeight() + i6);
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            i5 = this.c.getLeft();
            i6 = (getMeasuredHeight() - this.b.getMeasuredHeight()) / 2;
            this.b.layout(i5 - this.b.getMeasuredWidth(), i6, i5, this.b.getMeasuredHeight() + i6);
        }
    }
}
