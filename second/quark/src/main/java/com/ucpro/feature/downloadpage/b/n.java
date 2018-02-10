package com.ucpro.feature.downloadpage.b;

import android.graphics.Paint;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.e.b;
import com.ucpro.ui.e.d;
import com.ucpro.ui.e.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class n extends d {
    private String b;
    private String c;
    private boolean d;
    private a e;
    private long f;
    private long g;

    public n(String str, String str2, String str3, boolean z, a aVar) {
        super(str);
        this.c = str2;
        this.d = z;
        this.e = aVar;
        this.b = str3;
    }

    public final com.ucpro.ui.e.a.d c() {
        return com.ucpro.ui.e.a.d.VIEW_TYPE_TIP_ITEM_SELECT;
    }

    public final void a(e eVar, b bVar) {
        if ((eVar instanceof n) && (bVar instanceof com.ucpro.ui.e.a.e)) {
            com.ucpro.ui.e.a.e eVar2 = (com.ucpro.ui.e.a.e) bVar;
            n nVar = (n) eVar;
            eVar2.l.setText(nVar.b);
            if (nVar.d) {
                Paint paint = new Paint();
                paint.setTextSize((float) a.c((int) R.dimen.common_dialog_text_size));
                int measureText = (int) (paint.measureText(eVar2.l.getText().toString()) + IPictureView.DEFAULT_MIN_SCALE);
                eVar2.n.setBackgroundDrawable(a.a("select_dialog_blue_dot.xml"));
                ((LayoutParams) eVar2.n.getLayoutParams()).leftMargin = measureText - a.c((int) R.dimen.select_setting_dialog_blue_dot_margin);
                eVar2.n.setVisibility(0);
            } else {
                eVar2.n.setVisibility(8);
            }
            m.a(new k(this, nVar), new i(this, eVar2));
        }
    }

    public final void a(e eVar, int i, b bVar) {
        if (i < this.e.x.size()) {
            this.e.dismiss();
            this.e.v.a(((n) this.e.x.get(i)).c, i);
        }
    }
}
