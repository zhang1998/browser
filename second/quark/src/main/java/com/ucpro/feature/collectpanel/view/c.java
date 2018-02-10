package com.ucpro.feature.collectpanel.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.d.b;
import com.ucpro.feature.bookmarkhis.bookmark.category.CategoryEditBar;
import com.ucpro.feature.bookmarkhis.bookmark.category.CategorySelectContainer;
import com.ucpro.feature.collectpanel.a;
import com.ucpro.feature.collectpanel.l;
import com.ucpro.ui.f.e;
import com.ucpro.ui.widget.i;

/* compiled from: ProGuard */
public final class c extends FrameLayout implements OnClickListener, l {
    private a a;
    private View b;
    private LinearLayout c;
    private TextViewWithCheckBox d;
    private InputTextBox e;
    private TextView f;
    private CategorySelectContainer g;
    private CategoryEditBar h;
    private String i;
    private boolean j;
    private int k;

    public c(Context context) {
        this(context, 0);
    }

    public c(Context context, int i) {
        super(context);
        this.g = null;
        this.h = null;
        this.k = 0;
        this.k = i;
        setOnClickListener(this);
        this.b = new View(getContext());
        addView(this.b, -1, -1);
        this.c = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.collect_panel, this, false);
        this.c.setOrientation(1);
        this.c.setOnClickListener(new b(this));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        int c = com.ucpro.ui.c.a.c((int) R.dimen.collect_panel_content_margin_x);
        layoutParams.setMargins(c, 0, c, c);
        addView(this.c, layoutParams);
        this.d = (TextViewWithCheckBox) this.c.findViewById(R.id.collect_panel_checkbox);
        this.d.setOnClickListener(new d(this));
        this.f = (TextView) this.c.findViewById(R.id.collect_panel_title);
        this.f.setText(com.ucpro.ui.c.a.d((int) R.string.bookmark_revise_name));
        this.e = (InputTextBox) this.c.findViewById(R.id.collect_panel_input);
        this.e.setBottomLineVisibility(8);
        this.e.setActiveTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.e.setInactiveTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.g = (CategorySelectContainer) this.c.findViewById(R.id.collect_panel_category_container);
        this.h = (CategoryEditBar) this.c.findViewById(R.id.collect_panel_footer);
        this.h.setOnClickListener(this);
        if (this.k == 1) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
        } else if (this.k == 2) {
            this.d.setVisibility(8);
        }
        this.f.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.b.setBackgroundColor(com.ucpro.ui.c.a.c("main_menu_bg_color"));
        this.c.setBackgroundDrawable(new i(com.ucpro.ui.c.a.c((int) R.dimen.mainmenu_bg_radius), com.ucpro.ui.c.a.c("main_menu_content_bg_color")));
        this.g.a();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.j) {
            this.j = false;
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).start();
            this.c.setTranslationY((float) this.c.getMeasuredHeight());
            this.c.animate().translationY(0.0f).setDuration(300).start();
        }
    }

    public final void a(String str, String str2, boolean z) {
        this.i = str2;
        if (z) {
            this.d.setText(com.ucpro.ui.c.a.d((int) R.string.home_navigation_full));
            this.d.setCanSelected(false);
        } else {
            this.d.setText(com.ucpro.ui.c.a.d((int) R.string.home_navigation));
            this.d.setCanSelected(true);
        }
        this.e.setText(str);
        this.j = true;
    }

    public final void a() {
        this.b.animate().alpha(0.0f).setDuration(300).start();
        this.c.animate().translationY(this.k == 1 ? (float) this.b.getMeasuredHeight() : (float) this.c.getMeasuredHeight()).setDuration(300).setListener(new f(this)).start();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        this.a.i();
        return true;
    }

    public final boolean b() {
        return this.d.isSelected();
    }

    public final String getTitle() {
        return this.e.getText();
    }

    public final String getUrl() {
        return this.i;
    }

    public final void setPresenter(b bVar) {
        this.a = (a) bVar;
    }

    public final void setAdapter(e eVar) {
        this.g.setAdapter(eVar);
    }

    public final void c() {
        this.h.setEditMode(true);
        this.h.a(true);
    }

    public final void d() {
        this.h.setEditMode(false);
        CategoryEditBar categoryEditBar = this.h;
        categoryEditBar.setClickable(false);
        categoryEditBar.b.animate().alpha(0.0f).setDuration(300).start();
    }

    public final View getContent() {
        return this.c;
    }

    public final void e() {
        this.h.getEditView().getEditText().requestFocus();
    }

    public final CharSequence getEditCategory() {
        return this.h.getEditView().getEditText().getText();
    }

    public final void setHandleDirectory(boolean z) {
        if (z) {
            this.g.setTitle(com.ucpro.ui.c.a.d((int) R.string.merge_classification));
        } else {
            this.g.setTitle(com.ucpro.ui.c.a.d((int) R.string.select_classification));
        }
    }

    public final void onClick(View view) {
        if (view == this) {
            this.a.c();
        } else if (view == this.h.getCancelBtn()) {
            if (this.h.a) {
                this.a.g();
            } else {
                this.a.d();
            }
        } else if (view == this.h.getConfimBtn()) {
            this.a.e();
        } else if (view == this.h.getAddBtn()) {
            this.a.f();
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.j();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.k();
    }
}
