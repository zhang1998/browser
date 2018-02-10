package com.ucpro.feature.z.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class e extends ViewGroup implements OnClickListener {
    private ImageView a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private boolean l;
    private j m;

    public e(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = null;
        this.l = true;
        this.m = null;
        this.e = a.c((int) R.dimen.search_associate_item_height);
        this.f = a.c((int) R.dimen.search_associate_item_serch_margin_left);
        this.g = a.c((int) R.dimen.search_associate_item_copy_margin_left);
        this.h = a.c((int) R.dimen.search_associate_item_copy_padding_left);
        this.i = a.c((int) R.dimen.search_associate_item_url_margin_top);
        setBackgroundDrawable(a.c());
        this.a = new ImageView(getContext());
        this.j = a.a("searchpage_search_associate_list_search.svg");
        this.k = a.a("default_fav_icon.svg");
        this.a.setImageDrawable(this.j);
        this.a.setScaleType(ScaleType.CENTER);
        addView(this.a);
        this.b = new TextView(getContext());
        this.b.setGravity(16);
        this.b.setTextSize(0, (float) a.c((int) R.dimen.search_address_bar_text_size));
        this.b.setTextColor(a.c("default_maintext_gray"));
        this.b.setSingleLine();
        this.b.setEllipsize(TruncateAt.END);
        addView(this.b);
        this.c = new TextView(getContext());
        this.c.setGravity(16);
        this.c.setTextSize(0, (float) a.c((int) R.dimen.search_associate_item_url_textsize));
        this.c.setTextColor(a.c("search_input_associate_link_color"));
        this.c.setSingleLine();
        this.c.setEllipsize(TruncateAt.END);
        addView(this.c);
        this.d = new ImageView(getContext());
        this.d.setImageDrawable(a.a("searchpage_search_associate_list_fill.svg"));
        this.d.setScaleType(ScaleType.CENTER);
        this.d.setPadding(this.h, 0, this.h, 0);
        this.d.setClickable(true);
        this.d.setDuplicateParentStateEnabled(false);
        this.d.setBackgroundDrawable(a.c());
        this.d.setOnClickListener(this);
        addView(this.d);
        setOnClickListener(this);
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        this.a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.d.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(this.e, UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - this.a.getMeasuredWidth()) - this.d.getMeasuredWidth()) - (this.f * 2)) - this.g, SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(this.e, SectionHeader.SHT_LOUSER));
        this.b.measure(MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - this.a.getMeasuredWidth()) - this.d.getMeasuredWidth()) - (this.f * 2)) - this.g, SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(this.e, SectionHeader.SHT_LOUSER));
        int childCount = getChildCount();
        int i4 = 0;
        while (i3 < childCount) {
            i4 = Math.max(i4, getChildAt(i3).getMeasuredHeight());
            i3++;
        }
        setMeasuredDimension(getMeasuredWidth(), i4);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.f;
        int measuredHeight = (getMeasuredHeight() - this.a.getMeasuredHeight()) / 2;
        this.a.layout(i5, measuredHeight, this.a.getMeasuredWidth() + i5, this.a.getMeasuredHeight() + measuredHeight);
        int right = this.f + this.a.getRight();
        measuredHeight = right + this.b.getMeasuredWidth();
        if (this.c.getVisibility() == 8) {
            i5 = (getMeasuredHeight() - this.b.getMeasuredHeight()) / 2;
        } else {
            i5 = (((getMeasuredHeight() - this.b.getMeasuredHeight()) - this.i) - this.c.getMeasuredHeight()) / 2;
        }
        this.b.layout(right, i5, measuredHeight, this.b.getMeasuredHeight() + i5);
        if (this.c.getVisibility() != 8) {
            i5 = this.a.getRight() + this.f;
            measuredHeight = this.b.getBottom() + this.i;
            this.c.layout(i5, measuredHeight, this.c.getMeasuredWidth() + i5, this.c.getMeasuredHeight() + measuredHeight);
        }
        i5 = getMeasuredWidth();
        measuredHeight = (getMeasuredHeight() - this.d.getMeasuredHeight()) / 2;
        this.d.layout(i5 - this.d.getMeasuredWidth(), measuredHeight, i5, this.d.getMeasuredHeight() + measuredHeight);
    }

    public final TextView getAssociateText() {
        return this.b;
    }

    public final TextView getAssociateUrl() {
        return this.c;
    }

    public final void setIsSearch(boolean z) {
        this.l = z;
        if (z) {
            this.a.setImageDrawable(this.j);
        } else {
            this.a.setImageDrawable(this.k);
        }
    }

    public final void setCallback(j jVar) {
        this.m = jVar;
    }

    public final void onClick(View view) {
        if (this.m != null) {
            if (view == this.d) {
                this.m.a(this.b.getText(), this.c.getText());
            } else if (view == this) {
                this.m.a(this.b.getText(), this.c.getText(), this.l);
            }
        }
    }
}
