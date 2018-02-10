package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ProGuard */
final class ck implements OnItemSelectedListener {
    final /* synthetic */ ListPopupWindow a;

    ck(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != -1) {
            dk a = this.a.b;
            if (a != null) {
                a.h = false;
            }
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
