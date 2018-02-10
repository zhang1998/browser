package com.ucpro.feature.bookmarkhis.bookmark.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.f.b;
import com.ucpro.ui.f.e;
import com.ucpro.ui.scrollview.ScrollViewWithMaxHeight;

/* compiled from: ProGuard */
public class CategorySelectContainer extends LinearLayout {
    private ScrollViewWithMaxHeight a = null;
    private TextView b = null;
    private b c = null;

    public CategorySelectContainer(Context context) {
        super(context);
        b();
        a();
    }

    public CategorySelectContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
        a();
    }

    private void b() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.category_select_container, this, true);
        this.b = (TextView) findViewById(R.id.category_title);
        this.b.setText(a.d((int) R.string.select_classification));
        this.a = (ScrollViewWithMaxHeight) findViewById(R.id.category_scroll);
        this.a.setMaxHeight(a.c((int) R.dimen.collect_panel_category_scroll_max_height));
        this.c = new b(getContext());
        ((FrameLayout) findViewById(R.id.category_container)).addView(this.c);
    }

    public final void a() {
        this.b.setTextColor(a.c("default_assisttext_gray"));
        this.c.c();
    }

    public void setAdapter(e eVar) {
        this.c.setAdapter(eVar);
    }

    public void setTitle(String str) {
        this.b.setText(str);
    }
}
