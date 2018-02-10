package com.ucpro.ui.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class HeaderGridView extends GridView {
    public ArrayList<c> a = new ArrayList();

    public HeaderGridView(Context context) {
        super(context);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof b)) {
            ((b) adapter).a(getNumColumns());
        }
    }

    public void setClipChildren(boolean z) {
    }

    public int getHeaderViewCount() {
        return this.a.size();
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.a.size() > 0) {
            ListAdapter bVar = new b(this.a, listAdapter);
            int numColumns = getNumColumns();
            if (numColumns > 1) {
                bVar.a(numColumns);
            }
            super.setAdapter(bVar);
            return;
        }
        super.setAdapter(listAdapter);
    }
}
