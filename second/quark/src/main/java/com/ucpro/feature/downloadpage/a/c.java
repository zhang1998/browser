package com.ucpro.feature.downloadpage.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.Html;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.feature.b.a;
import com.ucpro.services.download.b;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class c extends a implements g {
    public int A = 0;
    public AppCompatSeekBar B;
    public ImageView b;
    public ImageView v;
    public ATTextView w;
    public ATTextView x;
    public ATTextView y;
    public boolean z = false;

    public c(Context context, boolean z, int i) {
        super(context);
        this.z = z;
        this.A = i;
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_corner_radius));
        gradientDrawable.setColor(com.ucpro.ui.c.a.c("default_warning"));
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        this.y = new ATTextView(getContext());
        this.y.setText(com.ucpro.ui.c.a.d((int) R.string.download_dialog_tips));
        this.y.setGravity(17);
        this.y.setSingleLine();
        this.y.setEllipsize(TruncateAt.END);
        this.y.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_title_desc));
        this.y.setTextColor(com.ucpro.ui.c.a.c("default_maintext_white"));
        int c = com.ucpro.ui.c.a.c((int) R.dimen.dir_manager_tips_padding);
        this.y.setPadding(com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_corner_radius), c, com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_corner_radius), c);
        linearLayout.setBackgroundDrawable(gradientDrawable);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.addView(this.y, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_inner_item_margin);
        this.a.addView(linearLayout, layoutParams);
        linearLayout = LayoutInflater.from(getContext()).inflate(R.layout.download_desc_item, null);
        this.b = (ImageView) linearLayout.findViewById(R.id.dialog_iv_icon);
        this.v = (ImageView) linearLayout.findViewById(R.id.dialog_iv_edit);
        this.v.setClickable(true);
        this.w = (ATTextView) linearLayout.findViewById(R.id.dialog_tv_content_title);
        this.x = (ATTextView) linearLayout.findViewById(R.id.dialog_tv_content_text);
        this.a.addView(linearLayout);
        if (this.z) {
            String str = com.ucpro.ui.c.a.d((int) R.string.download_setting_thread_num) + "<font color='%s'>（%s）</font>";
            c = b.f();
            String toHexString = Integer.toHexString(com.ucpro.ui.c.a.c("default_purpleblue"));
            String str2 = "#" + toHexString.substring(2, toHexString.length());
            Object[] objArr = new Object[2];
            objArr[0] = str2;
            objArr[1] = (this.A < c ? c : this.A);
            toHexString = String.format(str, objArr);
            View aTTextView = new ATTextView(getContext());
            aTTextView.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_title_desc));
            aTTextView.setText(Html.fromHtml(toHexString));
            aTTextView.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_margin);
            this.a.addView(aTTextView, layoutParams);
            this.B = (AppCompatSeekBar) LayoutInflater.from(getContext()).inflate(R.layout.download_seekbar, null);
            this.B.setMax(b.e());
            this.B.setThumbOffset(0);
            this.B.setProgress(this.A < c ? c : this.A);
            this.B.setOnSeekBarChangeListener(new i(this, c, aTTextView, str, str2));
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_inner_margin);
            layoutParams.leftMargin = -com.ucpro.ui.c.a.c((int) R.dimen.seek_bar_thumb_size);
            layoutParams.rightMargin = -com.ucpro.ui.c.a.c((int) R.dimen.seek_bar_thumb_size);
            layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_margin);
            this.a.addView(this.B, layoutParams);
        }
        h().b();
    }

    public final String k() {
        return this.w.getText().toString();
    }

    public final void a(CharSequence charSequence) {
        this.w.setText(charSequence);
    }
}
