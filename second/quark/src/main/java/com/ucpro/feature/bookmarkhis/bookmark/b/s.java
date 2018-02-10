package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.browser.IField;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.a.ab;
import com.ucweb.common.util.i.f;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class s extends ViewGroup implements OnClickListener, OnLongClickListener, ab {
    static int a;
    static int b;
    static int c;
    static int d;
    private static final Map<String, Integer> h = new HashMap();
    private static boolean i;
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static int o;
    private Drawable A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private int E;
    private String F;
    private n G;
    private int H;
    int e = 0;
    ValueAnimator f;
    ValueAnimator g;
    private ImageView p;
    @IField("mTitleView")
    private TextView q;
    private TextView r;
    private c s;
    private View t;
    private TextView u;
    @IField("mCheckBox")
    private c v;
    private float w;
    private float x;
    private int y;
    private m z;

    public s(Context context) {
        super(context);
        if (!i) {
            i = true;
            j = (int) a.a((int) R.dimen.bookmarkitem_fav_icon_size);
            k = (int) a.a((int) R.dimen.bookmarkitem_paddingtop);
            l = (int) a.a((int) R.dimen.bookmarkitem_paddingbottom);
            m = (int) a.a((int) R.dimen.bookmarkitem_height);
            a = (int) a.a((int) R.dimen.bookmarkmgntitem_checkbox_width);
            b = (int) a.a((int) R.dimen.bookmarkitem_right_icon_size);
            c = (int) a.a((int) R.dimen.bookmarkmgntitem_common_padding);
            n = (int) a.a((int) R.dimen.bookmarkmgntitem_lefticon_padding);
            d = (int) a.a((int) R.dimen.bookmarkmgntitem_lefticon_padding);
            o = (int) a.a((int) R.dimen.bookmarkmgntitem_favicon_padding);
        }
        setBackgroundDrawable(a.c());
        this.p = new ImageView(getContext());
        addView(this.p);
        int a = (int) a.a((int) R.dimen.bookmarkitem_title);
        this.q = new TextView(getContext());
        this.q.setTextSize(0, (float) a);
        this.q.setSingleLine();
        this.q.setEllipsize(TruncateAt.END);
        this.q.setIncludeFontPadding(false);
        addView(this.q);
        a = (int) a.a((int) R.dimen.bookmarkitem_desc);
        this.r = new TextView(getContext());
        this.r.setSingleLine();
        this.r.setTextSize(0, (float) a);
        this.r.setEllipsize(TruncateAt.END);
        this.r.setIncludeFontPadding(false);
        addView(this.r);
        this.r.setVisibility(8);
        this.t = new View(getContext());
        this.t.setVisibility(8);
        addView(this.t);
        this.u = new TextView(getContext());
        this.u.setTextSize(0, (float) a);
        this.u.setVisibility(8);
        this.u.setText(a.d((int) R.string.bookmark_top_stick));
        addView(this.u);
        this.C = a.a("bookmark_open_folder.svg");
        this.D = a.a("bookmark_category.svg");
        k();
        n();
        m();
        if (this.q != null) {
            this.q.setTextColor(a.c("default_maintext_gray"));
        }
        if (this.r != null) {
            this.r.setTextColor(a.c("default_commentstext_gray"));
        }
        if (this.u != null) {
            this.u.setTextColor(a.c("default_purpleblue"));
        }
        if (this.t != null) {
            this.t.setBackgroundDrawable(a.a("bookmark_top.svg"));
        }
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public final void setTextViewTitleColor(int i) {
        this.q.setTextColor(i);
    }

    public final void setTextViewDescriptionColor(int i) {
        this.r.setTextColor(i);
    }

    public final void setListener(n nVar) {
        this.G = nVar;
    }

    final void a(boolean z) {
        if (!c() || z) {
            setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        } else {
            setAlpha(0.5f);
        }
    }

    protected final void setRigtIconTranX(float f) {
        this.x = f;
    }

    final void a() {
        if (this.f != null && this.f.isRunning()) {
            this.f.cancel();
        }
        if (this.g != null && this.g.isRunning()) {
            this.g.cancel();
        }
    }

    protected static void a(View view, float f) {
        if (view != null && view.getVisibility() == 0) {
            view.setTranslationX(f);
        }
    }

    private int getTextRightBound() {
        return this.y;
    }

    private void setTextRightBound(int i) {
        this.y = i;
    }

    private float getRightIconTranX() {
        return this.x;
    }

    private void setRightIconTranX(float f) {
        this.x = f;
    }

    final void b() {
        if (this.v == null) {
            this.v = new c(getContext());
            this.v.setPadding(0, 0, n, 0);
            if (getLeftIconTranX() != 0.0f) {
                a(this.v, getLeftIconTranX());
            }
            addView(this.v);
            n();
        }
        this.v.setVisibility(0);
    }

    private float getLeftIconTranX() {
        return this.w;
    }

    protected final void setLeftIconTranX(float f) {
        this.w = f;
    }

    final boolean c() {
        return this.e == 1;
    }

    final boolean d() {
        return this.g != null && this.g.isRunning();
    }

    final void e() {
        if (this.v != null) {
            this.v.setVisibility(8);
        }
    }

    final boolean f() {
        return this.e == 0;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), m);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(j, UCCore.VERIFY_POLICY_QUICK);
        this.p.measure(makeMeasureSpec, makeMeasureSpec);
        makeMeasureSpec = (((getMeasuredWidth() - (c * 2)) - j) - n) - getExtraPaddingRight();
        if (c()) {
            makeMeasureSpec = (((makeMeasureSpec - a) - c) - (b * 2)) - (d * 2);
        } else if (l()) {
            makeMeasureSpec = (makeMeasureSpec - b) - d;
        }
        this.q.measure(MeasureSpec.makeMeasureSpec(makeMeasureSpec, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        if (this.r.getVisibility() == 0) {
            makeMeasureSpec = (((getMeasuredWidth() - (c * 2)) - j) - n) - getExtraPaddingRight();
            if (c()) {
                makeMeasureSpec = (((makeMeasureSpec - a) - c) - (b * 2)) - (d * 2);
            } else if (l()) {
                makeMeasureSpec = (makeMeasureSpec - b) - d;
            }
            this.r.measure(MeasureSpec.makeMeasureSpec(makeMeasureSpec, SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.s != null && this.s.getVisibility() == 0) {
            this.s.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.v != null && this.v.getVisibility() == 0) {
            this.v.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.t != null && this.t.getVisibility() == 0) {
            makeMeasureSpec = a.c((int) R.dimen.bookmark_item_top_icon_width);
            this.t.measure(MeasureSpec.makeMeasureSpec(makeMeasureSpec, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(makeMeasureSpec, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.u != null && this.u.getVisibility() == 0) {
            this.u.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int measuredWidth;
        if (this.s != null && this.s.getVisibility() == 0) {
            int height = getHeight();
            if (f()) {
                width = getWidth() - d;
                measuredWidth = width - this.s.getMeasuredWidth();
            } else {
                width = ((getWidth() - d) - (d * 2)) - (b * 2);
                measuredWidth = width - this.s.getMeasuredWidth();
            }
            this.s.layout(measuredWidth, 0, width, height);
        }
        if (this.v != null && this.v.getVisibility() == 0) {
            if (c()) {
                width = c;
            } else {
                width = -a;
            }
            this.v.layout(width, 0, this.v.getMeasuredWidth() + width, getHeight());
        }
        if (f()) {
            width = c;
            height = (getHeight() - j) / 2;
            this.p.layout(width, height, j + width, j + height);
        } else {
            width = (c + a) + c;
            height = (getHeight() - j) / 2;
            this.p.layout(width, height, j + width, j + height);
        }
        if (this.q.getVisibility() == 0) {
            if (f()) {
                width = (c + j) + n;
            } else {
                width = (((c + a) + c) + j) + n;
            }
            height = width + this.q.getMeasuredWidth();
            if (TextUtils.isEmpty(this.F)) {
                measuredWidth = (getHeight() - this.q.getMeasuredHeight()) / 2;
            } else {
                measuredWidth = k;
            }
            this.q.layout(width, measuredWidth, height, this.q.getMeasuredHeight() + measuredWidth);
        }
        if (this.r.getVisibility() == 0) {
            if (f()) {
                measuredWidth = n + (c + j);
                width = getHeight() - l;
            } else {
                measuredWidth = n + (((c + a) + c) + j);
                width = getHeight() - l;
            }
            this.r.layout(measuredWidth, width - this.r.getMeasuredHeight(), this.r.getMeasuredWidth() + measuredWidth, width);
        }
        if (this.t != null && this.t.getVisibility() == 0) {
            width = this.r.getRight() + a.c((int) R.dimen.bookmark_item_desc_margin_right);
            height = this.r.getTop() + ((this.r.getMeasuredHeight() - this.t.getMeasuredHeight()) / 2);
            this.t.layout(width, height, this.t.getMeasuredWidth() + width, this.t.getMeasuredHeight() + height);
        }
        if (this.u != null && this.u.getVisibility() == 0) {
            width = this.t.getRight() + a.c((int) R.dimen.bookmark_item_top_icon_margin_right);
            height = this.r.getTop() + ((this.r.getMeasuredHeight() - this.u.getMeasuredHeight()) / 2);
            this.u.layout(width, height, this.u.getMeasuredWidth() + width, this.u.getMeasuredHeight() + height);
        }
    }

    public final void setDescription(String str) {
        if (this.r != null) {
            String str2;
            if (com.ucweb.common.util.n.a.a(str)) {
                str2 = str;
            } else {
                str2 = f.g(str);
                if (str2.contains("://")) {
                    str2 = str2.substring(str2.indexOf("://") + 3);
                }
                int indexOf = str2.indexOf("/");
                if (!(indexOf == -1 || indexOf == str2.length() - 1)) {
                    str2 = str2.substring(0, indexOf) + "/...";
                }
            }
            this.F = str2;
            this.r.setText(this.F);
            if (TextUtils.isEmpty(str)) {
                this.r.setVisibility(8);
                this.t.setVisibility(8);
                this.u.setVisibility(8);
                return;
            }
            this.r.setVisibility(0);
        }
    }

    public final void setFavIcon(Drawable drawable) {
        if (this.p != null) {
            this.p.setImageDrawable(drawable);
        }
    }

    public final void g() {
        if (this.p != null) {
            this.p.setPadding(o, o, o, o);
        }
    }

    public final void h() {
        if (this.p != null) {
            this.p.setPadding(0, 0, 0, 0);
        }
    }

    public final ImageView getFavIconView() {
        return this.p;
    }

    public final void setTitle(String str) {
        if (this.q != null) {
            this.q.setText(str);
        }
    }

    public final m getData() {
        return this.z;
    }

    public final void setData(m mVar) {
        this.z = mVar;
        if (this.z != null) {
            setTitle(this.z.e);
            setDescription(null);
            k();
            if (this.z.g() && this.s == null) {
                this.s = new c(getContext());
                this.s.setImageSize(b);
                this.s.setDisplayWithIntrinsicSize(true);
                addView(this.s);
                m();
            }
            if (f()) {
                if (this.z.h()) {
                    i();
                } else {
                    j();
                }
            }
            if (c()) {
                i();
            }
            if (this.z != null) {
                if (this.z.h() && this.z.i()) {
                    this.t.setVisibility(0);
                    this.u.setVisibility(0);
                } else {
                    this.t.setVisibility(8);
                    this.u.setVisibility(8);
                }
            }
            if (this.z.h()) {
                try {
                    long j = this.z.l / 1000;
                    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    simpleDateFormat.setTimeZone(TimeZone.getDefault());
                    setDescription(simpleDateFormat.format(Long.valueOf(j)));
                } catch (ParseException e) {
                    setDescription(" ");
                }
            }
        }
    }

    private void k() {
        if (this.z != null) {
            if (this.z.g()) {
                h();
                setFavIcon(this.D);
                if (!this.z.g()) {
                    i();
                    return;
                }
                return;
            }
            i();
        }
    }

    final void i() {
        if (this.s != null && this.s.getVisibility() == 0) {
            this.s.setVisibility(8);
        }
    }

    final void j() {
        if (this.z.g() && this.e != 1) {
            this.s.setVisibility(0);
        }
    }

    private boolean l() {
        return this.s != null && this.s.getVisibility() == 0;
    }

    private void m() {
        if (this.s != null) {
            this.s.setNormalImage(this.C);
        }
    }

    protected final boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        if ((view == this.q || view == this.r) && d()) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            canvas.save();
            canvas.clipRect(0, 0, getTextRightBound(), getHeight());
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        if (i != 0) {
            canvas.restore();
        }
        return drawChild;
    }

    private void n() {
        if (this.v != null) {
            this.A = a.a("setting_item_checkbox_on.svg");
            this.B = a.a("setting_item_checkbox_off.svg");
            this.v.setNormalImage(this.B);
            this.v.setSelectedImage(this.A);
            this.v.setImageSize(a);
        }
    }

    public final boolean onLongClick(View view) {
        if (this.G != null) {
            this.G.b(getData());
        }
        return true;
    }

    public final void onClick(View view) {
        if (c()) {
            setCheckBoxelected(!this.v.isSelected());
            if (this.G != null) {
                n nVar = this.G;
                getData();
                nVar.a(this.v.isSelected(), this.E);
            }
        } else if (this.G != null) {
            this.G.a(getData());
        }
    }

    public final void setCheckBoxelected(boolean z) {
        if (this.v != null) {
            this.v.setSelected(z);
            a(z);
        }
    }

    public final void setPosition(int i) {
        this.E = i;
    }

    public final ab getSwapView() {
        return null;
    }

    public final void setSwapView(ab abVar) {
        invalidate();
    }

    private int getExtraPaddingRight() {
        return this.H;
    }

    public final void setExtraPaddingRight(int i) {
        this.H = i;
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            setClickable(true);
            return;
        }
        setAlpha(0.4f);
        setClickable(false);
    }
}
