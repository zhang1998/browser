package com.ucpro.feature.setting.b.d.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.quark.browser.R;

/* compiled from: ProGuard */
public final class b implements OnCheckedChangeListener {
    final /* synthetic */ d a;

    public b(d dVar) {
        this.a = dVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.boolean_switch) {
            this.a.v.a(z);
            this.a.dismiss();
        }
    }
}
