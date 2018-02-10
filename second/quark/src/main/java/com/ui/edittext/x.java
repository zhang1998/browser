package com.ui.edittext;

import android.text.Editable;
import android.text.style.EasyEditSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/* compiled from: ProGuard */
final class x extends aj implements OnClickListener {
    final /* synthetic */ TextView a;
    private TextView g;
    private EasyEditSpan h;

    private x(TextView textView) {
        this.a = textView;
        super(textView);
    }

    protected final void a() {
        this.b = new PopupWindow(this.a.mContext, null, 16843464);
        this.b.setInputMethodMode(2);
        this.b.setClippingEnabled(true);
    }

    protected final void b() {
        ViewGroup linearLayout = new LinearLayout(this.a.getContext());
        linearLayout.setOrientation(0);
        this.c = linearLayout;
        this.c.setBackgroundResource(17303089);
        LayoutInflater layoutInflater = (LayoutInflater) this.a.mContext.getSystemService("layout_inflater");
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        this.g = (TextView) layoutInflater.inflate(17367210, null);
        this.g.setLayoutParams(layoutParams);
        this.g.setText(17040361);
        this.g.setOnClickListener(this);
        this.c.addView(this.g);
    }

    public final void a(EasyEditSpan easyEditSpan) {
        this.h = easyEditSpan;
        super.d();
    }

    public final void onClick(View view) {
        if (view == this.g) {
            Editable editable = (Editable) this.a.g;
            int spanStart = editable.getSpanStart(this.h);
            int spanEnd = editable.getSpanEnd(this.h);
            if (spanStart >= 0 && spanEnd >= 0) {
                this.a.b(spanStart, spanEnd);
            }
        }
    }

    protected final int c() {
        return ((Editable) this.a.g).getSpanEnd(this.h);
    }

    protected final int a(int i) {
        return this.a.h.getLineBottom(i);
    }

    protected final int b(int i) {
        return i;
    }
}
