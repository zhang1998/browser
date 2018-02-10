package com.ucpro.feature.inputenhance.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ucpro.feature.inputenhance.SliderView;
import com.ucpro.feature.inputenhance.s;
import com.ucpro.ui.widget.Button;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public abstract class e {
    protected s a;
    protected Button b;
    protected Button c;
    protected Button d;
    protected Button e;
    protected TextView f;
    protected TextView g;
    protected SliderView h;
    protected ViewGroup i;
    protected ViewGroup j;
    protected LinearLayout k;
    protected LinearLayout l;
    protected LinearLayout m;
    protected FrameLayout n;
    protected LinearLayout o;

    public abstract void a(int i);

    public e(s sVar) {
        this.a = sVar;
        if (this.a != null) {
            this.b = this.a.getPreviousCursorButton();
            this.c = this.a.getNextCursorButton();
            this.d = this.a.getClipboardButton();
            this.e = this.a.getLongtextButton();
            this.j = this.a.getFunButtonLayout();
            this.i = this.a.getWebButtonLayout();
            this.k = this.a.getNoinputKeywordLeftLayout();
            this.l = this.a.getInputKeywordLeftLayout();
            this.m = this.a.getKeywordRightLayout();
            this.n = this.a.getInputEnhanceImproveLayout();
            this.o = this.a.getVerticalSearchLayout();
            this.f = this.a.getKeywordWap();
            this.g = this.a.getKeywordCom();
            this.h = this.a.getSlideView();
        }
    }
}
