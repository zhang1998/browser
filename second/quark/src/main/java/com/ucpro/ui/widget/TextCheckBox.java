package com.ucpro.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public class TextCheckBox extends LinearLayout {
    View a = new View(getContext());
    private ATTextView b;
    private b c;

    public TextCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dialog_selection_box_width);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = a.c((int) R.dimen.dialog_common_item_inner_margin);
        layoutParams.gravity = 16;
        addView(this.a, layoutParams);
        this.a.setBackgroundDrawable(a.a("dialog_checkbox_selector.xml"));
        this.b = new ATTextView(getContext());
        this.b.setTextSize(0, a.a((int) R.dimen.common_dialog_small_text_size));
        this.b.setTextColor(a.c("dialog_button_text_default_color"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        addView(this.b, layoutParams2);
        setOnClickListener(new k(this));
    }

    public void setSelected(boolean z) {
        this.a.setSelected(z);
    }

    public void setTextDesc(String str) {
        this.b.setText(str);
    }

    public final void setTextSize$255e752(float f) {
        this.b.setTextSize(0, f);
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setOnSelectClick(b bVar) {
        this.c = bVar;
    }
}
