package com.ucpro.feature.video.player.view;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.video.p;
import com.ucpro.feature.video.player.a;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.y;
import com.ucpro.feature.video.player.e;
import com.ucpro.feature.video.player.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class ah extends q<Boolean> implements OnClickListener, a {
    public FrameLayout a = null;
    private View b = null;
    private FrameLayout c = null;
    private FrameLayout d = null;
    private c e = null;
    private c f = null;
    private List<c> g = null;
    private int h = 0;
    private int i = 0;
    private boolean j = false;
    private d k = null;
    private j l = null;
    private Map<View, d> m = new HashMap();
    private Map<View, j> n = new HashMap();

    public ah(Context context, g gVar, com.ucpro.feature.video.player.e.a aVar, boolean z) {
        super(context, gVar, aVar);
        this.j = z;
        this.r.f().a((a) this);
        this.h = com.ucpro.ui.c.a.c((int) R.dimen.player_more_item_margin_bottom);
        this.i = com.ucpro.ui.c.a.c((int) R.dimen.player_more_item_margin_left);
        this.a = new as(this, this.q);
        if (this.j) {
            this.b = new View(this.q);
            this.a.addView(this.b, new LayoutParams(-1, -1));
            this.b.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_more_layer_half_bg.xml"));
            this.a.setBackgroundColor(SectionHeader.SHT_LOUSER);
        } else {
            this.a.setBackgroundColor(-436207616);
        }
        this.a.setOnClickListener(this);
        this.c = f();
        this.a.addView(this.c);
        this.d = f();
        this.d.setVisibility(8);
        this.a.addView(this.d);
        this.e = a(com.ucpro.ui.c.a.a("new_video_cache.svg"), com.ucpro.ui.c.a.d((int) R.string.video_cache));
        this.e.setVisibility(8);
        this.e.setOnClickListener(this);
        this.e.setId(45);
        this.c.addView(this.e, new LayoutParams(-2, -2));
        this.f = a(com.ucpro.ui.c.a.a("new_video_litter_win.svg"), com.ucpro.ui.c.a.d((int) R.string.little_window_button));
        this.f.setOnClickListener(this);
        this.f.setVisibility(8);
        this.c.addView(this.f, new LayoutParams(-2, -2));
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    private c a(Drawable drawable, CharSequence charSequence) {
        c cVar = new c(this, this.q);
        cVar.a.setImageDrawable(drawable);
        cVar.b.setText(charSequence);
        return cVar;
    }

    private FrameLayout f() {
        FrameLayout atVar;
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (this.j) {
            atVar = new at(this, this.q);
            layoutParams.gravity = 21;
        } else {
            atVar = new y(this, this.q);
            layoutParams.gravity = 17;
        }
        atVar.setLayoutParams(layoutParams);
        return atVar;
    }

    public final void b(boolean z) {
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public final void b() {
        if (this.j) {
            this.c.setTranslationX((float) this.c.getMeasuredWidth());
            this.d.setTranslationX((float) this.c.getMeasuredWidth());
            a(this.c);
        } else {
            this.c.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            this.c.setVisibility(0);
            this.d.setAlpha(0.0f);
        }
        this.d.setVisibility(8);
    }

    public final void onClick(View view) {
        if (view == this.a) {
            this.p.a(10099, null, null);
        } else if (view == this.e) {
            this.c.setVisibility(8);
            a(this.d);
        } else if (view == this.f) {
            this.p.a(10091, null, null);
        }
    }

    protected final void a(List<Class<?>> list) {
        list.add(y.class);
    }

    protected final void a(h<Boolean> hVar) {
        hVar.a(45).b(y.RequestSuccess.e).a(Boolean.valueOf(true)).b(y.RequestFail.e).a(Boolean.valueOf(true)).b(y.Requesting.e).a(Boolean.valueOf(false)).b(y.Idle.e).a(Boolean.valueOf(false));
        hVar.a(new r(this));
    }

    private void g() {
        boolean booleanValue;
        e f = this.r.f();
        if (this.e.getTag() != null) {
            booleanValue = ((Boolean) this.e.getTag()).booleanValue();
        } else {
            booleanValue = false;
        }
        if (!booleanValue || f == null || f.g <= 0) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        e f2 = this.r.f();
        if (f2 != null) {
            List list = f2.x;
            if (list != null && list.size() > 0) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.clear();
                this.d.removeAllViews();
                for (int size = list.size() - 1; size >= 0; size--) {
                    String str = (String) list.get(size);
                    View view = null;
                    boolean z = true;
                    switch (str.hashCode()) {
                        case -1039745817:
                            if (str.equals("normal")) {
                                z = false;
                                break;
                            }
                            break;
                        case 3202466:
                            if (str.equals("high")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109801339:
                            if (str.equals("super")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            view = a(com.ucpro.ui.c.a.a("new_video_resolution_normal.svg"), p.a(str, false));
                            break;
                        case true:
                            view = a(com.ucpro.ui.c.a.a("new_video_resolution_high.svg"), p.a(str, false));
                            break;
                        case true:
                            view = a(com.ucpro.ui.c.a.a("new_video_resolution_super.svg"), p.a(str, false));
                            break;
                    }
                    if (view != null) {
                        view.setTag(str);
                        view.setOnClickListener(new z(this));
                        this.g.add(view);
                        this.d.addView(view, new LayoutParams(-2, -2));
                    }
                }
            }
        }
    }

    public final boolean b(int i, b bVar, b bVar2) {
        return false;
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return false;
    }

    public final void a(boolean z) {
        g();
    }

    public final void d() {
        this.a.animate().cancel();
        if (this.k == null) {
            this.k = new d(this.a);
        }
        this.a.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).setListener(this.k).start();
    }

    public final void e() {
        if (this.j) {
            b(this.c);
            b(this.d);
        }
        this.a.animate().cancel();
        if (this.l == null) {
            this.l = new j(this.a);
        }
        this.a.animate().alpha(0.0f).setDuration(300).setListener(this.l).start();
    }

    private void a(View view) {
        AnimatorListener animatorListener;
        if (this.m.containsKey(view)) {
            animatorListener = (d) this.m.get(view);
        } else {
            animatorListener = new d(view);
            this.m.put(view, animatorListener);
        }
        view.animate().cancel();
        if (this.j) {
            view.animate().translationX(0.0f).setListener(animatorListener).setDuration(300).start();
        } else {
            view.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setListener(animatorListener).setDuration(300).start();
        }
    }

    private void b(View view) {
        AnimatorListener animatorListener;
        if (this.n.containsKey(view)) {
            animatorListener = (j) this.n.get(view);
        } else {
            animatorListener = new j(view);
            this.n.put(view, animatorListener);
        }
        view.animate().cancel();
        if (this.j) {
            view.animate().translationX((float) view.getMeasuredWidth()).setListener(animatorListener).setDuration(300).start();
        } else {
            view.animate().alpha(0.0f).setListener(animatorListener).setDuration(300).start();
        }
    }
}
