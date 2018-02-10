package android.support.v7.widget;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: ProGuard */
final class fy implements Runnable {
    final /* synthetic */ SearchView a;

    fy(SearchView searchView) {
        this.a = searchView;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            ch chVar = SearchView.a;
            View view = this.a;
            if (chVar.c != null) {
                try {
                    chVar.c.invoke(inputMethodManager, new Object[]{Integer.valueOf(0), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, 0);
        }
    }
}
