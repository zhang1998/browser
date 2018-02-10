package com.ucpro.ui.widget;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.RecyclerListener;

/* compiled from: ProGuard */
final class ai implements RecyclerListener {
    final /* synthetic */ ExpandableListViewEx a;

    ai(ExpandableListViewEx expandableListViewEx) {
        this.a = expandableListViewEx;
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
