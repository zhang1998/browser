package com.ucpro.feature.collectpanel.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.framework.resources.q;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class TextViewWithCheckBox extends LinearLayout {
    boolean a = true;
    private ImageView b;
    private TextView c;

    public TextViewWithCheckBox(Context context, String str) {
        super(context);
        setGravity(16);
        a(str);
    }

    public TextViewWithCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setGravity(16);
        a("");
    }

    private void a(String str) {
        this.b = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = a.c((int) R.dimen.collect_panel_checkbox_rightmargin);
        addView(this.b, layoutParams);
        this.c = new TextView(getContext());
        this.c.setText(str);
        this.c.setTextSize(0, (float) a.c((int) R.dimen.collect_panel_content_textsize));
        addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        Drawable a = a.a("collect_checkbox_select.svg");
        Drawable a2 = a.a("collect_checkbox_not_select.svg");
        Drawable qVar = new q();
        qVar.a(new int[]{16842913}, a);
        qVar.a(new int[0], a2);
        this.b.setImageDrawable(qVar);
        a.a(this.b);
        if (this.a) {
            this.c.setTextColor(a.c("default_maintext_gray"));
        } else {
            this.c.setTextColor(a.c("collect_panel_inactive_text_color"));
        }
    }

    public void setCanSelected(boolean z) {
        this.a = z;
    }

    public boolean isSelected() {
        return this.b.isSelected();
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        this.b.setSelected(z);
    }

    public void setText(CharSequence charSequence) {
        this.c.setText(charSequence);
    }
}
