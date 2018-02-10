package com.ucpro.feature.setting.b.d.a;

import android.content.Context;
import android.view.View;
import android.widget.Switch;
import com.quark.browser.R;
import com.ucpro.ui.g.o;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class d extends o {
    public Switch a;
    public ATTextView b;
    public e v;

    public d(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.dev_switching_dialog, null);
        this.a = (Switch) inflate.findViewById(R.id.boolean_switch);
        c.a(this.a);
        this.b = (ATTextView) inflate.findViewById(R.id.edit_tip);
        c.a(this.b);
        h().a(inflate);
    }
}
