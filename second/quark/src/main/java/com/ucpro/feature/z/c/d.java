package com.ucpro.feature.z.c;

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
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class d extends ViewGroup implements OnClickListener, e {
    public boolean a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Drawable j;
    private b k;

    public d(Context context) {
        super(context);
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
        this.a = false;
        this.e = a.c((int) R.dimen.search_associate_item_height);
        this.f = a.c((int) R.dimen.search_associate_item_serch_margin_left);
        this.g = a.c((int) R.dimen.search_associate_item_copy_margin_left);
        this.h = a.c((int) R.dimen.search_associate_item_copy_padding_left);
        this.i = a.c((int) R.dimen.search_associate_item_url_margin_top);
        this.b = new ImageView(getContext());
        this.b.setScaleType(ScaleType.CENTER);
        addView(this.b);
        this.c = new TextView(getContext());
        this.c.setGravity(16);
        this.c.setTextSize(0, (float) a.c((int) R.dimen.search_address_bar_text_size));
        this.c.setSingleLine();
        this.c.setEllipsize(TruncateAt.END);
        addView(this.c);
        this.d = new ImageView(getContext());
        this.d.setScaleType(ScaleType.CENTER);
        this.d.setPadding(this.h, 0, this.h, 0);
        this.d.setClickable(true);
        this.d.setDuplicateParentStateEnabled(false);
        this.d.setBackgroundDrawable(a.c());
        this.d.setOnClickListener(this);
        addView(this.d);
        setOnClickListener(this);
        a();
    }

    public final void a() {
        setBackgroundDrawable(a.c());
        this.j = a.a("searchpage_copy_tip_icon.svg");
        this.b.setImageDrawable(this.j);
        this.c.setTextColor(a.c("default_maintext_gray"));
        this.d.setImageDrawable(a.a("searchpage_search_associate_list_fill.svg"));
    }

    public final void setPresenter(b bVar) {
        c.a((Object) bVar);
        c.b(bVar instanceof b);
        this.k = (b) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.d.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(this.e, UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - this.b.getMeasuredWidth()) - this.d.getMeasuredWidth()) - (this.f * 2)) - this.g, SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(this.e, SectionHeader.SHT_LOUSER));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.f;
        int measuredHeight = (getMeasuredHeight() - this.b.getMeasuredHeight()) / 2;
        this.b.layout(i5, measuredHeight, this.b.getMeasuredWidth() + i5, this.b.getMeasuredHeight() + measuredHeight);
        i5 = this.b.getRight() + this.f;
        measuredHeight = (getMeasuredHeight() - this.c.getMeasuredHeight()) / 2;
        this.c.layout(i5, measuredHeight, this.c.getMeasuredWidth() + i5, this.c.getMeasuredHeight() + measuredHeight);
        i5 = getMeasuredWidth();
        measuredHeight = (getMeasuredHeight() - this.d.getMeasuredHeight()) / 2;
        this.d.layout(i5 - this.d.getMeasuredWidth(), measuredHeight, i5, this.d.getMeasuredHeight() + measuredHeight);
    }

    public final TextView getAssociateText() {
        return this.c;
    }

    public final void onClick(View view) {
        if (this.k != null) {
            b bVar;
            if (view == this.d) {
                bVar = this.k;
                this.c.getText();
                bVar.a();
            } else if (view == this) {
                bVar = this.k;
                this.c.getText();
                bVar.b();
            }
        }
    }

    public final void b() {
        setVisibility(8);
    }

    public final void c() {
        setVisibility(0);
        setAlpha(IPictureView.DEFAULT_MIN_SCALE);
    }

    public final void setText(String str) {
        this.c.setText(str);
    }

    public final void setIsCanShow(boolean z) {
        this.a = z;
    }

    public final boolean d() {
        return this.a;
    }
}
