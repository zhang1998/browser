package com.ucpro.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/* compiled from: ProGuard */
public class ExpandableListViewEx extends ExpandableListView {
    public ExpandableListViewEx(Context context) {
        super(context);
        a();
    }

    public ExpandableListViewEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public ExpandableListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setRecyclerListener(new ai(this));
    }
}
