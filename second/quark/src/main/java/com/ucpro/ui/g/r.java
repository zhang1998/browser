package com.ucpro.ui.g;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.system.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import java.util.List;

/* compiled from: ProGuard */
public final class r extends o {
    public c a;
    private LinearLayout b;
    private ATTextView v;
    private boolean w;

    public r(Context context, boolean z) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.select_setting_dialog_content, null);
        this.b = (LinearLayout) inflate.findViewById(R.id.selection_container);
        this.w = z;
        if (this.w) {
            this.b.setOrientation(0);
        } else {
            this.b.setOrientation(1);
        }
        this.v = (ATTextView) inflate.findViewById(R.id.select_dialog_title);
        h().a(inflate);
        a();
    }

    public final void a(CharSequence charSequence) {
        this.v.setText(charSequence);
    }

    public final void a(List<String> list, int i) {
        int i2;
        Paint paint = new Paint();
        paint.setTextSize((float) a.c((int) R.dimen.common_dialog_text_size));
        int i3 = 0;
        for (i2 = 0; i2 < list.size(); i2++) {
            String str = (String) list.get(i2);
            if (!TextUtils.isEmpty(str)) {
                i3 = (int) ((paint.measureText(str) + IPictureView.DEFAULT_MIN_SCALE) + ((float) i3));
            }
        }
        int c = a.c((int) R.dimen.common_dialog_margin_left);
        int f = (((b.a.f() - (a.c((int) R.dimen.pro_dialog_margin) * 2)) - (c * 2)) - i3) / (list.size() - 1);
        int c2 = a.c((int) R.dimen.common_dialog_margin_top);
        int[] iArr = new int[4];
        String str2;
        if (this.w) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            iArr[1] = c2;
            iArr[3] = c2;
            for (i2 = 0; i2 < list.size(); i2++) {
                str2 = (String) list.get(i2);
                if (!TextUtils.isEmpty(str2)) {
                    if (i2 == 0) {
                        iArr[0] = c;
                        iArr[2] = (f / 2) - 2;
                    } else if (i2 == list.size() - 1) {
                        iArr[0] = (f / 2) - 2;
                        iArr[2] = c;
                    } else {
                        iArr[0] = (f / 2) - 2;
                        iArr[2] = (f / 2) - 2;
                    }
                    this.b.addView(a(i2, str2, i, iArr, (int) (paint.measureText(str2) + IPictureView.DEFAULT_MIN_SCALE), true), layoutParams);
                }
            }
            return;
        }
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        for (i2 = 0; i2 < list.size(); i2++) {
            str2 = (String) list.get(i2);
            int i4 = c2 / 2;
            iArr[3] = i4;
            iArr[1] = i4;
            iArr[2] = c;
            iArr[0] = c;
            if (!TextUtils.isEmpty(str2)) {
                if (list.size() == 1) {
                    iArr[3] = c2;
                    iArr[1] = c2;
                } else if (i2 == 0) {
                    iArr[1] = c2;
                } else if (i2 == list.size() - 1) {
                    iArr[3] = c2;
                }
                this.b.addView(a(i2, str2, i, iArr, (int) (paint.measureText(str2) + IPictureView.DEFAULT_MIN_SCALE), false), layoutParams2);
            }
        }
    }

    private View a(int i, String str, int i2, int[] iArr, int i3, boolean z) {
        p pVar = new p(this);
        pVar.a = i;
        View inflate = getLayoutInflater().inflate(R.layout.select_setting_dialog_item, null);
        pVar.d = inflate;
        pVar.b = (ATTextView) inflate.findViewById(R.id.select_dialog_item_text);
        pVar.b.setText(str);
        pVar.b.setTextColor(a.d("searchpage_address_bar_action_btn_bg.xml"));
        pVar.b.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        pVar.c = inflate.findViewById(R.id.select_dialog_select_checkbox);
        pVar.c.setBackgroundDrawable(a.a("select_dialog_blue_dot.xml"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) pVar.c.getLayoutParams();
        layoutParams.topMargin = iArr[1];
        layoutParams.leftMargin = (iArr[0] + i3) - a.c((int) R.dimen.select_setting_dialog_blue_dot_margin);
        if (i2 == i) {
            pVar.c.setVisibility(0);
        }
        View frameLayout = new FrameLayout(getContext());
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.gravity = 1;
        }
        frameLayout.addView(inflate, layoutParams2);
        frameLayout.setTag(pVar);
        frameLayout.setOnClickListener(this);
        return frameLayout;
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof p)) {
            super.onClick(view);
            return;
        }
        p pVar = (p) view.getTag();
        if (this.a != null) {
            this.a.a(pVar.a);
        }
        dismiss();
    }

    public final void a() {
        super.a();
        this.v.setTextColor(a.c("default_maintext_gray"));
        this.v.getPaint().setFakeBoldText(true);
    }
}
