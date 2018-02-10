package com.ucpro.ui.widget;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.RecyclerListener;

/* compiled from: ProGuard */
final class c implements RecyclerListener {
    final /* synthetic */ ListViewEx a;

    c(ListViewEx listViewEx) {
        this.a = listViewEx;
    }

    public final void onMovedToScrapHeap(View view) {
        if (view != null && view.hasFocus()) {
            view.clearFocus();
            if (view instanceof EditText) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
