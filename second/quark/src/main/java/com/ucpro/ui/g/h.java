package com.ucpro.ui.g;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.ucweb.common.util.a.a;

/* compiled from: ProGuard */
public interface h {
    public static final int c = a.a();
    public static final int d = a.a();
    public static final int e = a.a();
    public static final int f = a.a();
    public static final int g = a.a();

    h a(int i, CharSequence charSequence);

    h a(int i, CharSequence charSequence, LayoutParams layoutParams);

    h a(View view);

    h a(View view, LayoutParams layoutParams);

    h a(CharSequence charSequence, int i);

    h a(CharSequence charSequence, int i, LayoutParams layoutParams);

    h a(CharSequence charSequence, LayoutParams layoutParams);

    h b();

    h b(String str, String str2);

    h c();

    h d();

    void dismiss();

    void e();

    View findViewById(int i);
}
