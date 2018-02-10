package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: ProGuard */
class d implements Factory {
    final a a;

    d(a aVar) {
        this.a = aVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.a.a(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.a + "}";
    }
}
