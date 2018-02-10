package com.ucpro.feature.z.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.c;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.b.b;
import com.ucpro.feature.z.e.a.d;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.i;

/* compiled from: ProGuard */
public final class g extends FrameLayout implements h {
    private b a;
    private View b;
    private LinearLayout c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private Interpolator h;
    private Interpolator i;
    private int j;
    private boolean k;
    private long l;
    private long m;
    private i n;

    public g(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new DecelerateInterpolator();
        this.i = new AccelerateInterpolator();
        this.j = 0;
        this.k = false;
        this.l = 300;
        this.m = 100;
        this.n = null;
        this.j = (int) a.a((int) R.dimen.qusou_item_height);
        this.a = new b(getContext());
        addView(this.a);
        this.b = LayoutInflater.from(getContext()).inflate(R.layout.qusou_item_layout, this, false);
        this.c = (LinearLayout) this.b.findViewById(R.id.qusou_container);
        this.d = (ImageView) this.b.findViewById(R.id.qusou_icon);
        this.d = (ImageView) this.b.findViewById(R.id.qusou_icon);
        this.e = (TextView) this.b.findViewById(R.id.qusou_title);
        this.f = (TextView) this.b.findViewById(R.id.qusou_content);
        this.g = (ImageView) this.b.findViewById(R.id.qusou_arrow);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        addView(this.b, layoutParams);
        this.b.setOnClickListener(new k(this));
        c();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b.getTop() != 0 && !this.k) {
            this.k = true;
            this.b.setTranslationY((float) this.j);
        }
    }

    public final void setListAdapter(BaseAdapter baseAdapter) {
        this.a.setAdapter(baseAdapter);
    }

    public final void a() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    public final void b() {
        if (getVisibility() != 0) {
            if (getLayoutAnimation() != null) {
                getLayoutAnimation().getAnimation().setDuration(200);
                scheduleLayoutAnimation();
            }
            setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            setVisibility(0);
        }
    }

    public final LayoutAnimationController getLayoutAnimation() {
        return this.a.getLayoutAnimation();
    }

    public final void scheduleLayoutAnimation() {
        this.a.scheduleLayoutAnimation();
    }

    public final void setLayoutAnimation(LayoutAnimationController layoutAnimationController) {
        this.a.setLayoutAnimation(layoutAnimationController);
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.a.setOnScrollListener(onScrollListener);
    }

    public final long getLayoutAnimationDurtion() {
        if (getLayoutAnimation() != null) {
            return getLayoutAnimation().getAnimation().getDuration();
        }
        return 0;
    }

    public final void c() {
        this.a.a();
        this.g.setImageDrawable(a.a("qusou_enter.png"));
        this.e.setTextColor(a.c("default_maintext_gray"));
        this.f.setTextColor(a.c("default_commentstext_gray"));
        this.d.setImageDrawable(a.a("qusou_default_icon.png"));
        this.c.setBackgroundDrawable(new i(a.c((int) R.dimen.multi_window_cardview2_corner_radius), a.c("default_frame_gray")));
        if (a.b()) {
            this.d.setColorFilter(a.a);
        } else {
            this.d.setColorFilter(null);
        }
    }

    public final void a(d dVar) {
        if (dVar != null) {
            this.e.setText(dVar.c);
            this.f.setText(dVar.d);
            ((b) c.b(getContext())).b(dVar.g).d().a(this.d);
            this.a.animate().translationY((float) (-this.j)).setDuration(this.l).setStartDelay(this.m).start();
            this.b.animate().translationY(0.0f).setDuration(this.l).setStartDelay(this.m).setInterpolator(this.h).start();
        }
    }

    public final void d() {
        this.a.animate().translationY(0.0f).setDuration(this.l).setStartDelay(this.m).start();
        this.b.animate().translationY((float) this.j).setDuration(this.l).setStartDelay(this.m).setInterpolator(this.i).start();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        com.ucweb.common.util.c.a((Object) bVar);
        com.ucweb.common.util.c.b(bVar instanceof i);
        this.n = (i) bVar;
    }
}
