package com.ucpro.feature.webwindow.g;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class b extends ViewGroup implements TextWatcher {
    CustomEditText a;
    private ATTextView b;
    private ImageView c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private int k;
    private k l;

    public b(Context context, int i) {
        super(context);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0;
        this.f = a.c((int) R.dimen.search_in_page_search_text_left_padding);
        this.g = a.c((int) R.dimen.search_in_page_search_text_right_padding);
        this.h = a.c((int) R.dimen.search_in_page_search_text_height);
        this.k = (i - this.h) / 2;
        this.i = a.a((int) R.dimen.search_in_page_search_text_size);
        this.j = a.a((int) R.dimen.search_in_page_index_text_size);
        this.c = new ImageView(getContext());
        addView(this.c);
        this.a = new CustomEditText(getContext());
        this.a.a(0, this.i);
        this.a.setSingleLine(true);
        this.a.a((TextWatcher) this);
        addView(this.a);
        this.b = new ATTextView(getContext());
        this.b.setTextSize(0, this.j);
        this.b.setPadding(this.g, 0, this.g, 0);
        this.b.setSingleLine();
        a(0, 0);
        addView(this.b);
        a();
    }

    public final int getSearchTextHeight() {
        return this.h;
    }

    public final void a() {
        this.a.setTextColor(a.c("default_maintext_gray"));
        this.a.setBackgroundColor(0);
        this.b.setTextColor(a.c("default_assisttext_gray"));
        this.c.setBackgroundDrawable(a.a("webpage_address_text_bg.xml"));
    }

    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        StringBuilder append = new StringBuilder().append(i).append("/").append(i2);
        if (this.b != null) {
            this.b.setText(append.toString());
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.k;
        this.c.layout(0, i5, getMeasuredWidth(), this.c.getMeasuredHeight() + i5);
        this.a.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredHeight = (getMeasuredHeight() - this.b.getMeasuredHeight()) / 2;
        this.b.layout(getMeasuredWidth() - this.b.getMeasuredWidth(), measuredHeight, getMeasuredWidth(), this.b.getMeasuredHeight() + measuredHeight);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
        this.a.setPadding(this.f, this.k, this.b.getMeasuredWidth(), this.k);
        makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK);
        this.a.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - this.b.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), makeMeasureSpec);
        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK);
        this.c.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - this.b.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), makeMeasureSpec);
    }

    public final void setSearchInPageTextCallback(k kVar) {
        this.l = kVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.l != null) {
            this.l.a(charSequence);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
