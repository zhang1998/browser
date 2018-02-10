package com.ucpro.ui.contextmenu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.g.s;
import com.ucpro.ui.widget.ListViewEx;
import com.ui.edittext.c;

/* compiled from: ProGuard */
public final class a extends s implements OnItemClickListener {
    ListViewEx a;
    d b;
    b c;
    private LinearLayout d;

    public a(Context context) {
        super(context, R.style.contextmenu);
        Context context2 = getContext();
        this.d = new LinearLayout(context2);
        this.a = new ListViewEx(context2);
        this.d.addView(this.a);
        this.a.setVerticalFadingEdgeEnabled(false);
        this.a.setFooterDividersEnabled(false);
        this.a.setHeaderDividersEnabled(false);
        this.a.setOnItemClickListener(this);
        this.a.setCacheColorHint(0);
        this.a.setDividerHeight(0);
        this.d.setBackgroundDrawable(com.ucpro.ui.c.a.a("context_menu_bg.9.png"));
        this.a.setSelector(new ColorDrawable(0));
        this.a.setDividerHeight(0);
        setContentView(this.d);
        setCanceledOnTouchOutside(true);
        getWindow().setWindowAnimations(R.style.contextmenu_anim);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
        if (this.c != null) {
            this.c.a((c) this.b.getItem(i), this.b.d());
        }
    }

    protected final void onStart() {
        super.onStart();
        if (this.c != null) {
            this.c.d();
        }
        int b = (int) this.b.b();
        this.a.setLayoutParams(new LayoutParams(b, -2));
        int width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindow().getWindowManager().getDefaultDisplay().getHeight();
        this.a.measure(MeasureSpec.makeMeasureSpec(b, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(height, SectionHeader.SHT_LOUSER));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = this.b.a;
        attributes.x = point.x - this.d.getPaddingLeft();
        attributes.y = point.y - this.d.getPaddingTop();
        attributes.gravity = 51;
        int measuredWidth = this.a.getMeasuredWidth() + (this.d.getPaddingLeft() * 2);
        int measuredHeight = this.a.getMeasuredHeight() + (this.d.getPaddingTop() * 2);
        if (attributes.x + measuredWidth > width) {
            attributes.x -= measuredWidth;
            if (attributes.x < 0) {
                attributes.x = width - measuredWidth;
            }
        }
        if (attributes.y + measuredHeight > height) {
            attributes.y = height - measuredHeight;
        }
    }

    protected final void onStop() {
        if (this.c != null) {
            this.c.e();
        }
    }
}
