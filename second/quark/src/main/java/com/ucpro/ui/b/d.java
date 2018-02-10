package com.ucpro.ui.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class d extends FrameLayout {
    private int a;
    private LinearLayout b;
    private ImageView c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private TextView g;

    public d(Context context) {
        super(context);
        this.a = -1;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.b = new LinearLayout(getContext());
        this.b.setOrientation(0);
        this.b.setGravity(17);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, a.c((int) R.dimen.toast_height));
        layoutParams.rightMargin = a.c((int) R.dimen.toast_margin_right);
        addView(this.b, layoutParams);
        this.c = new ImageView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(a.c((int) R.dimen.toast_icon_margin_left), 0, 0, 0);
        this.b.addView(this.c, layoutParams);
        this.d = new LinearLayout(getContext());
        this.d.setOrientation(1);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.b.addView(this.d, layoutParams);
        this.e = new TextView(getContext());
        this.e.setSingleLine();
        this.e.setEllipsize(TruncateAt.END);
        this.d.addView(this.e, new LinearLayout.LayoutParams(-2, -2));
        this.f = new TextView(getContext());
        this.f.setSingleLine();
        this.f.setEllipsize(TruncateAt.END);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f.setTextSize(0, (float) a.c((int) R.dimen.toast_subtitle_textsize));
        layoutParams.setMargins(0, a.c((int) R.dimen.toast_subtitle_margin_top), 0, 0);
        this.d.addView(this.f, layoutParams);
        this.g = new TextView(getContext());
        this.g.setGravity(17);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.g.setPadding(0, 0, a.c((int) R.dimen.toast_title_action_margin_right), 0);
        this.g.setTextSize(0, (float) a.c((int) R.dimen.toast_action_textsize));
        this.g.setClickable(true);
        this.b.addView(this.g, layoutParams);
        setType(1);
        a();
    }

    private void setTitleStyle(boolean z) {
        if (this.e == null) {
            return;
        }
        if (z) {
            this.e.setTextSize(0, (float) a.c((int) R.dimen.toast_title_textsize));
        } else {
            this.e.setTextSize(0, (float) a.c((int) R.dimen.toast_action_textsize));
        }
    }

    private void setTitleContainerStyle(boolean z) {
        if (this.d == null) {
            return;
        }
        if (z) {
            ((LinearLayout.LayoutParams) this.d.getLayoutParams()).setMargins(a.c((int) R.dimen.toast_title_container_margin_left), 0, a.c((int) R.dimen.toast_title_container_margin_right), 0);
        } else {
            ((LinearLayout.LayoutParams) this.d.getLayoutParams()).setMargins(a.c((int) R.dimen.toast_title_container_margin_left), 0, a.c((int) R.dimen.toast_title_action_margin_right), 0);
        }
    }

    public final void setIconName(String str) {
        setIconDrawable(a.a(str));
    }

    public final void setIconDrawable(Drawable drawable) {
        this.c.setImageDrawable(drawable);
    }

    public final void setTitle(CharSequence charSequence) {
        this.e.setText(charSequence);
    }

    public final void setSubTitle(CharSequence charSequence) {
        this.f.setText(charSequence);
    }

    public final void setActionText(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    public final void setActionListener(OnClickListener onClickListener) {
        this.g.setOnClickListener(onClickListener);
    }

    public final void setType(int i) {
        if (i != this.a) {
            this.a = i;
            if (this.a == 1) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                setTitleStyle(false);
                setTitleContainerStyle(false);
            } else if (this.a == 2) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                setTitleStyle(true);
                setTitleContainerStyle(false);
            } else if (this.a == 3) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                setTitleStyle(false);
                setTitleContainerStyle(true);
            } else if (this.a == 4) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                setTitleStyle(true);
                setTitleContainerStyle(true);
            }
        }
    }

    public final void a() {
        if (a.b()) {
            this.b.setBackgroundResource(R.drawable.toast_bg_night);
        } else {
            this.b.setBackgroundResource(R.drawable.toast_bg);
        }
        this.e.setTextColor(a.c("toast_title_color"));
        this.f.setTextColor(a.c("toast_subtitle_color"));
        this.g.setTextColor(a.c("default_green"));
    }
}
