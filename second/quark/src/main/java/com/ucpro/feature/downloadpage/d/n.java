package com.ucpro.feature.downloadpage.d;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class n extends FrameLayout implements OnClickListener, OnLongClickListener {
    int a = b.a;
    private Context b;
    private View c;
    private ProgressBar d;
    private ImageView e;
    private ATTextView f;
    private ATTextView g;
    private ATTextView h;
    private ImageView i;
    private LayerDrawable j;
    private LayerDrawable k;
    private Drawable l;
    private Drawable m;
    private Drawable n;
    private Drawable o;
    private int p;
    private r q;
    private int r = d.b;
    private int s;
    private int t;
    private DecelerateInterpolator u;

    public n(Context context) {
        super(context);
        this.b = context;
        ClipDrawable clipDrawable = new ClipDrawable(new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{a.c("download_item_progress_start_color"), a.c("download_item_progress_end_color")}), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{a.c("download_item_progress_fail_color"), a.c("download_item_progress_fail_color")}), 3, 1);
        Drawable[] drawableArr = new Drawable[]{new ColorDrawable(0), clipDrawable, clipDrawable};
        Drawable[] drawableArr2 = new Drawable[]{new ColorDrawable(0), clipDrawable2, clipDrawable2};
        this.j = new LayerDrawable(drawableArr);
        this.k = new LayerDrawable(drawableArr2);
        this.l = a.a("download_begin.svg");
        this.m = a.a("download_pause.svg");
        this.n = a.a("searchpage_search_associate_list_search.svg");
        this.o = a.a("bookmark_warning.svg");
        this.s = a.c("download_item_download_normal_text_color");
        this.t = a.c("default_warning");
        this.c = LayoutInflater.from(this.b).inflate(R.layout.progressbarview, null);
        this.c.setBackgroundDrawable(a.c());
        this.c.setOnLongClickListener(this);
        this.c.setOnClickListener(this);
        this.d = (ProgressBar) this.c.findViewById(R.id.download_progress);
        this.d.setMax(100);
        setProgressDrawable$3cf8fc87(b.a);
        this.i = (ImageView) this.c.findViewById(R.id.download_status);
        this.e = (ImageView) this.c.findViewById(R.id.download_icon);
        this.f = (ATTextView) this.c.findViewById(R.id.download_title);
        this.g = (ATTextView) this.c.findViewById(R.id.download_total_progress);
        this.h = (ATTextView) this.c.findViewById(R.id.download_speed);
        this.f.setTextColor(a.c("default_maintext_gray"));
        this.g.setTextColor(a.c("download_item_progress_text_color"));
        this.h.setTextColor(a.c("download_item_progress_text_color"));
        this.i.setImageDrawable(this.l);
        this.i.setOnClickListener(this);
        setImageIcon(this.n);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        addView(this.c, layoutParams);
    }

    public final void setProgressDrawable$3cf8fc87(int i) {
        this.a = i;
        Drawable drawable = null;
        if (i == 0 || i == b.a) {
            this.a = b.a;
            drawable = this.j;
        } else if (i == b.b) {
            drawable = this.k;
        }
        this.d.setProgressDrawable(drawable);
    }

    public final void setImageIcon(Drawable drawable) {
        this.e.setImageDrawable(drawable);
    }

    public final boolean onLongClick(View view) {
        if (this.q != null) {
            r rVar = this.q;
            int i = this.p;
            getTag();
            rVar.b(i);
        }
        return true;
    }

    public final void onClick(View view) {
        if (this.q != null) {
            r rVar = this.q;
            int i = this.p;
            getTag();
            rVar.c_(i);
        }
    }

    public final int getPosition() {
        return this.p;
    }

    public final void setPosition(int i) {
        this.p = i;
    }

    public final void setListener(r rVar) {
        this.q = rVar;
    }

    public final void setProgressWithAnimation(float f) {
        if (((float) this.d.getProgress()) > f) {
            this.d.setProgress(0);
        }
        if (this.u == null) {
            this.u = new DecelerateInterpolator();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.d, "progress", new int[]{this.d.getProgress(), (int) f});
        ofInt.setDuration(1900);
        ofInt.setInterpolator(this.u);
        ofInt.start();
    }

    public final void setIsDownloadComplete(boolean z) {
        int i;
        int i2;
        if (z) {
            i = 8;
            i2 = b.c;
            setStatusText("");
        } else {
            i2 = b.a;
            i = 0;
        }
        this.i.setVisibility(i);
        setProgressDrawable$3cf8fc87(i2);
        if (z) {
            this.d.setProgress(0);
        }
    }

    public final void setStatusText(String str) {
        this.h.setText(str);
    }

    public final ImageView getIconImageView() {
        return this.e;
    }

    public final void setImageIcon(Bitmap bitmap) {
        this.e.setImageBitmap(bitmap);
    }

    public final void setTitle(String str) {
        this.f.setText(str);
    }

    public final void setTextProgress(String str) {
        this.g.setText(str);
    }

    public final void a() {
        b();
        this.i.setVisibility(0);
        int progress = this.d.getProgress();
        setProgressDrawable$3cf8fc87(b.a);
        setProgress((float) (progress - 1));
        setProgress((float) progress);
    }

    public final void b() {
        this.h.setTextColor(this.s);
    }

    public final synchronized void setProgress(float f) {
        int i = 0;
        synchronized (this) {
            int i2 = (int) f;
            if (((float) this.d.getProgress()) > f) {
                this.d.setProgress(0);
            }
            if (i2 < 100) {
                if (this.a == b.c) {
                    setProgressDrawable$3cf8fc87(b.a);
                }
                i = i2;
            }
            this.d.setProgress(i);
        }
    }

    public final void a(String str) {
        int progress = this.d.getProgress();
        setProgressDrawable$3cf8fc87(b.b);
        setProgress((float) (progress - 1));
        setProgress((float) progress);
        this.h.setTextColor(this.t);
        setStatus$437ed75e(d.e);
        this.h.setText(str);
    }

    final void setStatus$437ed75e(int i) {
        this.i.setVisibility(0);
        if (i == d.a) {
            this.r = i;
            this.i.setImageDrawable(this.m);
            this.h.setText("准备缓存种子");
        } else if (i == d.b) {
            this.r = i;
            this.i.setImageDrawable(this.m);
            this.h.setText("正在缓存");
        } else if (i == d.c) {
            this.r = i;
            this.i.setImageDrawable(this.l);
            this.h.setText("暂停缓存");
        } else if (i == d.d) {
            this.r = i;
            this.i.setImageDrawable(this.n);
            this.h.setText("缓存完成");
        } else if (i == d.e) {
            this.r = i;
            this.i.setImageDrawable(this.l);
        }
    }

    public final void c() {
        b();
        if (this.a != b.a) {
            setProgressDrawable$3cf8fc87(b.a);
        }
        setStatus$437ed75e(d.b);
    }

    public final void d() {
        b();
        if (this.a != b.a) {
            setProgressDrawable$3cf8fc87(b.a);
        }
        setStatus$437ed75e(d.d);
    }

    public final void e() {
        b();
        setProgress((float) (this.d.getProgress() - 1));
        setProgress((float) this.d.getProgress());
        if (this.a != b.a) {
            setProgressDrawable$3cf8fc87(b.a);
        }
        setStatus$437ed75e(d.c);
    }
}
