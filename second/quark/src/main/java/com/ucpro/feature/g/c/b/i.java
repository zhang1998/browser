package com.ucpro.feature.g.c.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class i extends FrameLayout implements OnClickListener, l, n {
    public LinearLayout a = new LinearLayout(getContext());
    public k b;
    private View c = b(a.d((int) R.string.cloud_sync_qq_login), "cloud_centet_login_qq.svg");
    private View d;
    private o e;

    public i(Context context) {
        super(context);
        this.c.setOnClickListener(this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.a.addView(this.c, layoutParams);
        if (!com.ucpro.b.d.a.d()) {
            layoutParams.rightMargin = a.c((int) R.dimen.clound_sync_center_qq_login_margin_right);
            this.d = b(a.d((int) R.string.cloud_sync_wexin_login), "cloud_centet_login_wechat.svg");
            this.d.setOnClickListener(this);
            this.a.addView(this.d);
        }
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = a.c((int) R.dimen.clound_sync_margin_logo_top);
        this.b = new k(getContext());
        this.b.b = this;
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        addView(this.a, layoutParams);
        addView(this.b.a, layoutParams2);
        this.b.a.setVisibility(8);
    }

    private View b(String str, String str2) {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(a.a(str2));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = a.c((int) R.dimen.clound_sync_center_login_item_icon_margin_bottom);
        linearLayout.addView(imageView, layoutParams);
        imageView = new TextView(getContext());
        imageView.setText(str);
        imageView.setTextColor(a.c("default_maintext_gray"));
        imageView.setTextSize(0, (float) a.c((int) R.dimen.clound_sync_center_login_item_name_textsize));
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.addView(imageView, layoutParams);
        return linearLayout;
    }

    public final View a() {
        View aTTextView = new ATTextView(getContext());
        int c = a.c((int) R.dimen.clound_sync_login_shape_radius);
        aTTextView.setLayoutParams(new RecyclerView.LayoutParams(a.c((int) R.dimen.clound_sync_login_btn_width), a.c((int) R.dimen.clound_sync_login_btn_height)));
        aTTextView.setGravity(17);
        aTTextView.setClickable(true);
        aTTextView.setTextColor(a.c("cloud_login_btn_text_color"));
        aTTextView.setTextSize(0, a.b((int) R.dimen.clound_sync_login_btn_text_size));
        aTTextView.setPadding(c, 0, c, 0);
        aTTextView.setBackgroundDrawable(null);
        return aTTextView;
    }

    public final void a(View view, Object obj) {
        if ((obj instanceof com.ucpro.feature.g.c.a.a) && (view instanceof ATTextView)) {
            com.ucpro.feature.g.c.a.a aVar = (com.ucpro.feature.g.c.a.a) obj;
            ATTextView aTTextView = (ATTextView) view;
            aTTextView.setText((String) aVar.a);
            if (aTTextView.getBackground() == null) {
                Drawable drawable;
                if (aVar.c != null) {
                    drawable = aVar.c;
                } else {
                    drawable = a.a(aVar.b);
                }
                aTTextView.setBackgroundDrawable(drawable);
            }
        }
    }

    public final void a(Object obj) {
    }

    public final void onClick(View view) {
        if (this.e != null) {
            if (view == this.c) {
                this.e.a(b.QQ);
            } else if (view == this.d) {
                this.e.a(b.WECHAT);
            }
        }
    }

    public final void setIOtherLogin(o oVar) {
        this.e = oVar;
    }

    public final void a(String str) {
        if (this.e != null) {
            this.e.a(str);
        }
    }

    public final void a(String str, String str2) {
        if (this.e != null) {
            this.e.a(str, str2);
        }
    }
}
