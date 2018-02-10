package com.ucpro.feature.setting.view.c.b;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ucpro.ui.e.a.f;
import com.ucpro.ui.e.a.g;
import com.ucpro.ui.e.b;
import com.ucpro.ui.e.d;
import com.ucpro.ui.e.e;

/* compiled from: ProGuard */
final class a extends d implements OnCheckedChangeListener {
    private String b;
    private b c;
    private com.ucpro.feature.setting.a.d d;

    public a(b bVar, com.ucpro.feature.setting.a.d dVar) {
        super(dVar.a);
        this.b = dVar.b;
        this.c = bVar;
        this.d = dVar;
    }

    public final void a(e eVar, b bVar) {
        if (eVar instanceof a) {
            int intValue = Integer.valueOf(((a) eVar).a).intValue();
            if (intValue == -1) {
                ((com.ucpro.ui.e.a.b) bVar).l.setText(this.b);
            } else if (intValue == 0) {
                ((f) bVar).l.setText(this.b);
                ((f) bVar).n.setOnCheckedChangeListener(null);
                ((f) bVar).n.setChecked(Boolean.valueOf(this.c.c.a(this.d.c)).booleanValue());
                ((f) bVar).n.setOnCheckedChangeListener(this);
            } else {
                ((g) bVar).l.setText(this.b);
                CharSequence charSequence = "";
                if (intValue == 6) {
                    charSequence = this.c.c.a(this.d.c);
                }
                ((g) bVar).n.setText(charSequence);
            }
        }
    }

    public final void a(e eVar, int i, b bVar) {
        if (!(eVar instanceof a)) {
            return;
        }
        if (Integer.valueOf(((a) eVar).a).intValue() == 0) {
            ((f) bVar).n.a();
        } else {
            b.a(this.c, this.d.c);
        }
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.c.b != null) {
            this.c.b.a(null, this.d.c, Boolean.valueOf(z));
        }
    }

    public final com.ucpro.ui.e.a.d c() {
        int intValue = Integer.valueOf(this.a).intValue();
        if (intValue == -1) {
            return com.ucpro.ui.e.a.d.VIEW_TYPE_ITEM_DESC;
        }
        if (intValue == 0) {
            return com.ucpro.ui.e.a.d.VIEW_TYPE_CHECKBOX;
        }
        return com.ucpro.ui.e.a.d.VIEW_TYPE_NORMAL;
    }
}
