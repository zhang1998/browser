package com.ucpro.ui.g;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public class s extends Dialog {
    private Context a;

    public s(Context context, int i) {
        super(context, i);
        this.a = context;
    }

    public void onStart() {
        Context context = this.a;
        Window window = getWindow();
        if (window != null) {
            LayoutParams attributes = window.getAttributes();
            f.a(context, attributes);
            window.setAttributes(attributes);
        }
    }
}
