package com.ucpro.feature.setting.view.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.SystemClock;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.feature.setting.a.d;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class a extends ViewGroup implements h {
    private static long g;
    private ATTextView a = new ATTextView(getContext());
    private ImageView b;
    private ImageView c;
    private int d = getTitleTextSize();
    private int e = com.ucpro.ui.c.a.c((int) R.dimen.mainmenu_item_icon_tips_size);
    private int f = com.ucpro.ui.c.a.c((int) R.dimen.main_setting_dot_size_margin_left);
    private c h;
    private d i;
    private String j;
    private int k;
    private String l;
    private String m;
    private boolean n;

    public a(Context context, int i, String str, String str2, boolean z, String str3) {
        int i2 = 0;
        super(context);
        setTitle(str);
        setValue(str2);
        setKey(i);
        setStatus(z);
        setUiAutoTag(str3);
        setOnClickListener(this);
        this.a.setTextSize(0, (float) this.d);
        this.a.setText(getTitle());
        this.a.setGravity(1);
        addView(this.a);
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(this.e);
        shapeDrawable.setIntrinsicWidth(this.e);
        shapeDrawable.getPaint().setColor(com.ucpro.ui.c.a.c("main_menu_icon_tips_color"));
        this.b = new ImageView(getContext());
        this.b.setBackgroundDrawable(shapeDrawable);
        ImageView imageView = this.b;
        if (!getStatus()) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        addView(this.b);
        this.c = new ImageView(getContext());
        this.c.setImageDrawable(com.ucpro.ui.c.a.a("open_sub_setting.svg"));
        addView(this.c);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        this.a.measure(makeMeasureSpec, makeMeasureSpec2);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    public final int getTitleTextColor() {
        return com.ucpro.ui.c.a.c("default_maintext_gray");
    }

    public final int getTitleTextSize() {
        return com.ucpro.ui.c.a.c((int) R.dimen.setting_item_view_default_title_text_size);
    }

    public final int getItemLeftPadding() {
        return com.ucpro.ui.c.a.c((int) R.dimen.setting_item_view_default_padding_left);
    }

    public final int getItemRightPadding() {
        return com.ucpro.ui.c.a.c((int) R.dimen.setting_item_view_default_padding_right);
    }

    public final byte getSettingItemViewType() {
        return (byte) 0;
    }

    public final void a(String str) {
    }

    public final void a() {
    }

    public final int getKey() {
        return this.k;
    }

    public final void setKey(int i) {
        this.k = i;
    }

    public final String getTitle() {
        return this.m;
    }

    public final void setTitle(String str) {
        this.m = str;
    }

    public final void setValue(String str) {
        this.l = str;
    }

    public final String getValue() {
        return this.l;
    }

    public final void setStatus(boolean z) {
        this.n = z;
    }

    public final boolean getStatus() {
        return this.n;
    }

    public final void onClick(View view) {
        g = SystemClock.uptimeMillis();
        this.b.setVisibility(8);
        if (this.h != null) {
            this.h.a(this, getKey(), getValue());
        }
    }

    public final void setSettingItemViewCallback(c cVar) {
        this.h = cVar;
    }

    public final String getUiAutoTag() {
        return this.j;
    }

    public final void setUiAutoTag(String str) {
        this.j = str;
    }

    public final View getSettingItemView() {
        return this;
    }

    public final long getClickCoolingTime() {
        return 300;
    }

    public final void setViewVisibility(int i) {
        setVisibility(i);
    }

    public final d getSettingItemData() {
        return this.i;
    }

    public final void setSettingItemData(d dVar) {
        this.i = dVar;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int itemLeftPadding = getItemLeftPadding();
        int height = (getHeight() / 2) - (this.a.getMeasuredHeight() / 2);
        this.a.layout(itemLeftPadding, height, this.a.getMeasuredWidth() + itemLeftPadding, this.a.getMeasuredHeight() + height);
        itemLeftPadding = (itemLeftPadding + this.a.getMeasuredWidth()) + this.f;
        this.b.layout(itemLeftPadding, height - this.e, this.e + itemLeftPadding, height);
        itemLeftPadding = getWidth() - getItemRightPadding();
        int height2 = (getHeight() / 2) - (this.c.getMeasuredHeight() / 2);
        this.c.layout(itemLeftPadding - this.c.getMeasuredWidth(), height2, itemLeftPadding, this.c.getMeasuredHeight() + height2);
    }
}
