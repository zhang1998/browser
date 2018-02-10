package com.ucpro.feature.downloadpage.e.c;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class t extends FrameLayout implements OnClickListener, OnLongClickListener {
    private int A;
    private DecelerateInterpolator B;
    private int C;
    private long D = 0;
    ProgressBar a;
    ATTextView b;
    ImageView c;
    Drawable d;
    Drawable e;
    int f;
    boolean g = false;
    public boolean h = false;
    boolean i = false;
    float j = 0.0f;
    private Context k;
    private View l;
    private ImageView m;
    private ATTextView n;
    private ATTextView o;
    private ImageView p;
    private LayerDrawable q;
    private LayerDrawable r;
    private Drawable s;
    private Drawable t;
    private Drawable u;
    private int v;
    private u w;
    private int x = e.a;
    private int y = 1000;
    private int z = p.a;

    public t(Context context) {
        super(context);
        this.k = context;
        ClipDrawable clipDrawable = new ClipDrawable(new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{a.c("download_item_progress_start_color"), a.c("download_item_progress_end_color")}), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{a.c("download_item_progress_fail_color"), a.c("download_item_progress_fail_color")}), 3, 1);
        Drawable[] drawableArr = new Drawable[]{new ColorDrawable(0), clipDrawable, clipDrawable};
        Drawable[] drawableArr2 = new Drawable[]{new ColorDrawable(0), clipDrawable2, clipDrawable2};
        this.q = new LayerDrawable(drawableArr);
        this.r = new LayerDrawable(drawableArr2);
        this.s = a.a("download_begin.svg");
        this.t = a.a("download_pause.svg");
        this.u = a.a("download_file_type_unknown.svg");
        this.A = a.c("download_item_download_normal_text_color");
        this.f = a.c("default_warning");
        this.l = LayoutInflater.from(this.k).inflate(R.layout.progressbarview, null);
        setBackgroundDrawable(a.c());
        setOnLongClickListener(this);
        setOnClickListener(this);
        this.a = (ProgressBar) this.l.findViewById(R.id.download_progress);
        this.a.setMax(this.y);
        setProgressDrawable$4dfd987c(p.a);
        this.p = (ImageView) this.l.findViewById(R.id.download_status);
        this.m = (ImageView) this.l.findViewById(R.id.download_icon);
        this.n = (ATTextView) this.l.findViewById(R.id.download_title);
        this.o = (ATTextView) this.l.findViewById(R.id.download_total_progress);
        this.b = (ATTextView) this.l.findViewById(R.id.download_speed);
        this.n.getPaint().setFakeBoldText(true);
        this.n.setTextColor(a.c("default_maintext_gray"));
        this.o.setTextColor(a.c("download_item_progress_text_color"));
        this.b.setTextColor(a.c("download_item_progress_text_color"));
        this.p.setImageDrawable(this.s);
        setImageIcon(this.u);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        addView(this.l, layoutParams);
        this.c = new ImageView(getContext());
        this.d = a.a("setting_item_checkbox_off.svg");
        this.e = a.a("setting_item_checkbox_on.svg");
        this.c.setImageDrawable(this.d);
        layoutParams = new FrameLayout.LayoutParams(a.c((int) R.dimen.download_list_item_checkbox_icon_size), a.c((int) R.dimen.download_list_item_checkbox_icon_size));
        layoutParams.gravity = 16;
        layoutParams.leftMargin = a.c((int) R.dimen.download_list_item_checkbox_icon_margin_left);
        addView(this.c, layoutParams);
        this.C = (-a.c((int) R.dimen.download_list_item_checkbox_icon_margin_left)) + a.c((int) R.dimen.download_list_item_checkbox_icon_size);
    }

    public final void setProgressDrawable$4dfd987c(int i) {
        this.z = i;
        Drawable drawable = null;
        if (i == 0 || i == p.a) {
            this.z = p.a;
            drawable = this.q;
        } else if (i == p.b) {
            drawable = this.r;
        }
        this.a.setProgressDrawable(drawable);
    }

    public final void setImageIcon(Drawable drawable) {
        this.m.setImageDrawable(drawable);
    }

    public final boolean onLongClick(View view) {
        if (!(this.w == null || this.g)) {
            u uVar = this.w;
            int i = this.v;
            getTag();
            uVar.b(i);
        }
        return true;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (this.g) {
            if (this.c.isSelected()) {
                z = false;
            }
            this.c.setSelected(z);
            this.c.setImageDrawable(z ? this.e : this.d);
            if (this.w != null) {
                u uVar = this.w;
                getTag();
                uVar.a(this.c.isSelected(), this.v);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.D > 800) {
            this.D = currentTimeMillis;
            if (this.w != null) {
                if (!this.h) {
                    setStatus$3a0cd121(this.x == e.a ? e.b : e.a);
                }
                u uVar2 = this.w;
                int i = this.v;
                Object tag = getTag();
                if (this.p.getDrawable() != this.s) {
                    z = false;
                }
                uVar2.a(i, tag, z);
            }
        }
    }

    public final void a() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new c(this));
        ofFloat.addListener(new f(this));
        ofFloat.start();
    }

    public final void b() {
        this.i = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new o(this));
        ofFloat.addListener(new q(this));
        ofFloat.start();
    }

    protected static void a(View view, float f) {
        if (view != null && view.getVisibility() == 0) {
            view.setTranslationX(f);
        }
    }

    public final void setTextSpeed(String str) {
        this.b.setText(str);
    }

    @DebugLog
    public final void setStatus$3a0cd121(int i) {
        this.p.setVisibility(0);
        if (this.x != i) {
            if (i == 0 || i == e.a) {
                this.x = i;
                this.p.setImageDrawable(this.s);
            } else if (i == e.b) {
                this.x = i;
                this.p.setImageDrawable(this.t);
            } else {
                int i2 = e.c;
            }
        }
    }

    private void e() {
        this.b.setTextColor(this.A);
    }

    public final synchronized void setProgress(float f) {
        boolean z = true;
        int i = 0;
        synchronized (this) {
            int i2 = (int) f;
            if (((float) this.a.getProgress()) > f) {
                this.a.setProgress(0);
            }
            if (i2 < this.y) {
                z = false;
            }
            this.h = z;
            if (this.h) {
                setIsDownloadComplete(true);
            } else {
                if (this.z == p.c) {
                    setProgressDrawable$4dfd987c(p.a);
                }
                i = i2;
            }
            this.a.setProgress(i);
        }
    }

    public final void setIsDownloadComplete(boolean z) {
        int i;
        int i2;
        if (z) {
            i = 8;
            i2 = p.c;
            setTextSpeed("");
        } else {
            i2 = p.a;
            i = 0;
        }
        this.p.setVisibility(i);
        setProgressDrawable$4dfd987c(i2);
        if (z) {
            this.a.setProgress(0);
        }
    }

    public final int getPosition() {
        return this.v;
    }

    public final void setPosition(int i) {
        this.v = i;
    }

    public final void setListener(u uVar) {
        this.w = uVar;
    }

    public final void setProgressWithAnimation(float f) {
        boolean z = false;
        if (((float) this.a.getProgress()) > f) {
            this.a.setProgress(0);
        }
        if (this.B == null) {
            this.B = new DecelerateInterpolator();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a, "progress", new int[]{this.a.getProgress(), (int) f});
        ofInt.setDuration(900);
        ofInt.setInterpolator(this.B);
        ofInt.start();
        if (f >= ((float) this.y)) {
            z = true;
        }
        this.h = z;
        if (this.h) {
            setIsDownloadComplete(true);
        }
    }

    public final ImageView getIconImageView() {
        return this.m;
    }

    public final void setImageIcon(Bitmap bitmap) {
        this.m.setImageBitmap(bitmap);
    }

    public final void setTitle(String str) {
        this.n.setText(str);
    }

    public final void setTextProgress(String str) {
        this.o.setText(str);
    }

    @DebugLog
    public final void c() {
        setStatus$3a0cd121(e.b);
        e();
        if (this.z != p.a) {
            setProgressDrawable$4dfd987c(p.a);
        }
    }

    public final void d() {
        e();
        setProgress((float) (this.a.getProgress() - 1));
        setProgress((float) this.a.getProgress());
        if (this.z != p.a) {
            setProgressDrawable$4dfd987c(p.a);
        }
        setStatus$3a0cd121(e.a);
    }
}
