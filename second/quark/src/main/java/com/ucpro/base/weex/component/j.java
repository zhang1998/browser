package com.ucpro.base.weex.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class j extends BaseAdapter {
    final /* synthetic */ WXTextTable a;

    j(WXTextTable wXTextTable) {
        this.a = wXTextTable;
    }

    public final int getCount() {
        return this.a.mItems.size();
    }

    public final Object getItem(int i) {
        if (i >= this.a.mItems.size()) {
            return null;
        }
        return this.a.mItems.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View textView;
        if (view == null) {
            textView = new TextView(this.a.getContext());
            textView.setLayoutParams(new LayoutParams(-1, a.c((int) R.dimen.weex_table_item_height)));
            ((TextView) textView).setGravity(17);
            ((TextView) textView).setMaxLines(2);
            ((TextView) textView).setTextSize(0, (float) a.c((int) R.dimen.weex_table_item_textsize));
            ((TextView) textView).setTextColor(a.c("default_maintext_gray"));
            textView.setBackgroundResource(R.drawable.border_line_bg);
        } else {
            textView = view;
        }
        if (i < this.a.mItems.size()) {
            ((TextView) textView).setText((CharSequence) this.a.mItems.get(i));
        }
        return textView;
    }
}
