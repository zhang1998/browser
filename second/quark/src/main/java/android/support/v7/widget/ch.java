package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
final class ch {
    Method a;
    Method b;
    Method c;
    private Method d;

    ch() {
        try {
            this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.d = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.d.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.c = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.c.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    final void a(AutoCompleteTextView autoCompleteTextView) {
        if (this.d != null) {
            try {
                this.d.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
    }
}
