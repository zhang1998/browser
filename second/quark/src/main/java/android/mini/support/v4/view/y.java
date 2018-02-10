package android.mini.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: ProGuard */
class y implements Factory {
    final ac a;

    y(ac acVar) {
        this.a = acVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.a.a(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.a + "}";
    }
}
