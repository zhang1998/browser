package com.ucpro.feature.s.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class f extends ViewGroup implements e {
    private String a;
    private String b;
    private TextView c = new TextView(getContext());
    private TextView d;
    private ImageView e;

    public f(Context context, j jVar) {
        super(context);
        setOnClickListener(jVar);
        this.c.setEllipsize(TruncateAt.END);
        this.c.setSingleLine();
        this.c.setTextSize(0, (float) a.c((int) R.dimen.discovery_navi_itemview_title_textsize));
        addView(this.c);
        this.d = new TextView(getContext());
        this.d.setEllipsize(TruncateAt.END);
        this.d.setMaxLines(2);
        this.d.setTextSize(0, (float) a.c((int) R.dimen.discovery_navi_itemview_description_textsize));
        addView(this.d);
        this.e = new ImageView(getContext());
        addView(this.e);
        this.c.setTextColor(a.c("default_maintext_gray"));
        this.d.setTextColor(a.c("default_assisttext_gray"));
        setBackgroundDrawable(a.a("siteview_bg_selector.xml"));
        int c = a.c((int) R.dimen.discovery_navi_itemview_padding);
        setPadding(c, c, c, a.c((int) R.dimen.discovery_navi_itemview_padding_bottom));
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int c = a.c((int) R.dimen.discovery_navi_itemview_iconsize);
        this.e.measure(MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - this.e.getMeasuredWidth()) - a.c((int) R.dimen.discovery_navi_itemview_title_marginright), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        c = a.c((int) R.dimen.discovery_navi_itemview_description_marginright);
        int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - this.c.getMeasuredHeight()) - a.c((int) R.dimen.discovery_navi_itemview_description_margintop)) - getPaddingBottom();
        this.d.measure(MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - this.e.getMeasuredWidth()) - c, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK));
    }

    public final void setTitle(String str) {
        this.b = str;
        this.c.setText(str);
    }

    public final void setDescription(String str) {
        this.d.setText(str);
    }

    public final void setIconDrawable(Drawable drawable) {
        this.e.setImageDrawable(a.a(drawable));
    }

    public final void setUrl(String str) {
        this.a = str;
    }

    public final String getUrl() {
        return this.a;
    }

    public final String getTitle() {
        return this.b;
    }

    public final ImageView getImageView() {
        return this.e;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() - getPaddingRight();
        int measuredWidth = width - this.e.getMeasuredWidth();
        int paddingTop = getPaddingTop();
        this.e.layout(measuredWidth, paddingTop, width, this.e.getMeasuredHeight() + paddingTop);
        width = getPaddingLeft();
        measuredWidth = getPaddingTop();
        int measuredWidth2 = this.c.getMeasuredWidth() + width;
        this.c.layout(width, measuredWidth, measuredWidth2, this.c.getMeasuredHeight() + measuredWidth);
        width = getPaddingLeft();
        paddingTop = getHeight() - getPaddingBottom();
        measuredWidth2 = paddingTop - this.d.getMeasuredHeight();
        this.d.layout(width, measuredWidth2, this.d.getMeasuredWidth() + width, paddingTop);
    }
}
