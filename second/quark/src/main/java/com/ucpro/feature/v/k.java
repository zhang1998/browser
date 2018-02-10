package com.ucpro.feature.v;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.i;
import com.ucpro.ui.g.o;
import com.ucpro.ui.scrollview.ScrollViewWithMaxHeight;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class k extends o implements OnDismissListener {
    ATTextView a;
    ATTextView b;
    private View v;
    private ScrollViewWithMaxHeight w;

    public k(Context context) {
        super(context);
        this.v = getLayoutInflater().inflate(a.b() ? R.layout.translate_dialog_night : R.layout.translate_dialog, null);
        this.a = (ATTextView) this.v.findViewById(R.id.translate_source);
        this.b = (ATTextView) this.v.findViewById(R.id.translate_target);
        this.w = (ScrollViewWithMaxHeight) this.v.findViewById(R.id.translate_sv);
        this.w.setMaxHeight(b.a.g() / 2);
        this.w.setScrollBarStyle(33554432);
        this.a.setTextColor(a.c("default_assisttext_gray"));
        this.b.setTextColor(a.c("default_maintext_gray"));
        ((ATTextView) this.v.findViewById(R.id.translate_source_text)).setTextColor(a.c("default_assisttext_gray"));
        ((ATTextView) this.v.findViewById(R.id.translate_target_text)).setTextColor(a.c("default_purpleblue"));
        h().a(this.v);
        h().b();
        setOnDismissListener(this);
        CharSequence d = a.d((int) R.string.translate_copy_result);
        CharSequence d2 = a.d((int) R.string.translate_ok_text);
        i i = i();
        if (i != null) {
            i.setText(d);
            i.setTag(R.id.ui_auto, com.ucweb.common.util.p.b.a);
        }
        i j = j();
        if (j != null) {
            j.setText(d2);
            j.setTag(R.id.ui_auto, com.ucweb.common.util.p.b.c);
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
    }
}
