package com.ucpro.feature.z.e;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.BaseAdapter;
import com.ucpro.ui.widget.ListViewEx;

/* compiled from: ProGuard */
public final class b extends ListViewEx {
    private i a = null;

    public b(Context context) {
        super(context);
        setStackFromBottom(true);
        setDivider(null);
        setSelector(17170445);
        setVerticalScrollBarEnabled(false);
        a();
    }

    public final void a() {
        if (getAdapter() != null && (getAdapter() instanceof BaseAdapter)) {
            ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.a != null) {
            this.a.a();
        }
        return super.onTouchEvent(motionEvent);
    }
}
