package com.ucpro.ui.g;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public abstract class u extends s implements OnClickListener, h {
    protected static int o;
    protected static int p;
    protected static int r;
    public static String t;
    public static String u;
    private boolean a = false;
    protected final Context h;
    protected w i;
    protected List<q> j = new ArrayList();
    protected n k;
    protected l l;
    protected LayoutParams m = null;
    protected LayoutParams n = null;
    protected int q = 0;
    protected LayoutParams s = null;

    public u(Context context) {
        super(context, R.style.dialog_theme);
        this.h = context;
        t = a.d((int) R.string.dialog_yes_text);
        u = a.d((int) R.string.dialog_no_text);
        o = a.c((int) R.dimen.dialog_button_height);
        this.q = a.c((int) R.dimen.dialog_button_padding_left);
        p = a.c((int) R.dimen.dialog_button_text_size);
        r = a.c((int) R.dimen.dialog_item_text_size);
        this.m = new LayoutParams(-1, -2);
        this.n = new LayoutParams(-2, -2);
        this.s = new LayoutParams(0, 0);
        this.s.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.i = new w(this, this.h);
        int[] iArr = new int[]{0, 0, 0, 0};
        this.i.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        this.i.setOrientation(1);
        this.j.add(this.i);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int c = a.c((int) R.dimen.pro_dialog_margin);
        layoutParams.setMargins(c, c, c, c);
        View frameLayout = new FrameLayout(this.h);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        frameLayout.addView(this.i, layoutParams);
        setContentView(frameLayout, layoutParams2);
        Window window = getWindow();
        window.setWindowAnimations(R.style.dialog_pushpop);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().addFlags(2);
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    protected void onStart() {
        super.onStart();
        if (this.k != null) {
            this.k.a(this, 9507092);
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        a();
    }

    public void onStop() {
        if (this.k != null) {
            this.k.a(this, 9507094);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            this.a = true;
        }
        if (this.a && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4) {
            this.a = false;
            if (this.k != null) {
                this.k.a(this, 9508093);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onClick(View view) {
        boolean z = false;
        if (this.l != null) {
            z = this.l.a(this, view.getId(), null);
        }
        if (!z) {
            if (view.getId() == c || view.getId() == d) {
                dismiss();
            }
        }
    }

    public void a() {
        for (q a : this.j) {
            a.a();
        }
    }

    public void show() {
        try {
            a();
            super.show();
        } catch (Exception e) {
            c.b(false);
        }
    }

    public final void a(n nVar) {
        this.k = nVar;
    }

    public final void a(l lVar) {
        this.l = lVar;
    }

    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(this.h);
    }
}
