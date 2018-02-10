package com.ucpro.feature.setting.view.c.a;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.quark.browser.R;

/* compiled from: ProGuard */
public final class a extends FrameLayout {
    private ImageView a = new ImageView(getContext());
    private ImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private TextView f;
    private ListView g;
    private View h;

    public a(Context context) {
        super(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_big_lab_icon_width), com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_big_lab_icon_height));
        layoutParams.gravity = 5;
        addView(this.a, layoutParams);
        this.g = new ListView(getContext());
        layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.common_titlebar_height);
        addView(this.g, layoutParams);
        this.g.setDivider(null);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setFastScrollEnabled(false);
        this.g.setSelector(new ColorDrawable(0));
        this.g.addHeaderView(getHeaderView());
        this.g.addFooterView(getFooterView());
        this.a.setImageDrawable(com.ucpro.ui.c.a.a("lab_big_icon.png"));
        this.b.setImageDrawable(com.ucpro.ui.c.a.a("lab_icon.svg"));
        this.c.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.c.setTypeface(Typeface.defaultFromStyle(1));
        this.d.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.d.setTypeface(Typeface.defaultFromStyle(1));
        this.e.setBackgroundDrawable(com.ucpro.ui.c.a.a("quark_lab_color_bar.xml"));
        this.f.setTextColor(com.ucpro.ui.c.a.c("default_commentstext_gray"));
    }

    private View getHeaderView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.quark_lab_header, this.g, false);
        this.b = (ImageView) inflate.findViewById(R.id.quark_lab_icon);
        this.c = (TextView) inflate.findViewById(R.id.quark_lab_title);
        this.d = (TextView) inflate.findViewById(R.id.quark_lab_subtitle);
        this.e = inflate.findViewById(R.id.quark_lab_tip_color_bar);
        this.f = (TextView) inflate.findViewById(R.id.quark_lab_tip);
        return inflate;
    }

    public final View getFooterView() {
        if (this.h != null) {
            return this.h;
        }
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        View textView = new TextView(getContext());
        textView.setTextColor(com.ucpro.ui.c.a.c("default_commentstext_gray"));
        textView.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_list_footer_textsize));
        textView.setText(com.ucpro.ui.c.a.d((int) R.string.quark_lab_list_footer_text1));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        textView = new TextView(getContext());
        textView.setTextColor(com.ucpro.ui.c.a.c("default_purpleblue"));
        textView.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_list_footer_textsize));
        textView.setText(com.ucpro.ui.c.a.d((int) R.string.quark_lab_list_footer_text2));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_list_footer_margin_bottom);
        linearLayout.addView(textView, layoutParams);
        this.h = linearLayout;
        return this.h;
    }

    public final ListView getListView() {
        return this.g;
    }
}
