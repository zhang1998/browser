package com.ucpro.feature.inputenhance;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.inputenhance.b.a;
import com.ucpro.feature.inputenhance.b.b;
import com.ucpro.feature.inputenhance.b.c;
import com.ucpro.feature.inputenhance.b.d;
import com.ucpro.feature.inputenhance.b.e;
import com.ucpro.feature.inputenhance.b.f;
import com.ucpro.ui.widget.Button;
import com.ucpro.ui.widget.TextView;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public class s extends LinearLayout implements OnClickListener, j {
    private SliderView A;
    private ArrayList<TextView> B;
    private ImageView C;
    private LinearLayout D;
    private ATTextView E;
    private LinearLayout F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private ValueAnimator K;
    private ValueAnimator L;
    private int M;
    private int N;
    private v O;
    public c a;
    public a b;
    public f c;
    public b d;
    public d e;
    protected ViewGroup f;
    protected ViewGroup g;
    ArrayList<ValueAnimator> h;
    private e i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private FrameLayout m;
    private Button n;
    private Button o;
    private Button p;
    private Button q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public s(Context context) {
        super(context);
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.J = false;
        this.h = new ArrayList();
        this.B = new ArrayList();
        this.G = com.ucpro.ui.c.a.c((int) R.dimen.input_enhance_vertical_search_icon_width);
        this.H = com.ucpro.ui.c.a.c((int) R.dimen.input_enhance_vertical_search_icon_margin);
        LayoutInflater.from(getContext()).inflate(R.layout.input_enhance_layout, this, true);
        setOrientation(0);
        setBaselineAligned(false);
        this.f = (ViewGroup) findViewById(R.id.web_button_layout);
        this.g = (ViewGroup) findViewById(R.id.fun_button_layout);
        this.n = (Button) findViewById(R.id.previous_cursor_button);
        this.o = (Button) findViewById(R.id.next_cursor_button);
        this.p = (Button) findViewById(R.id.cliboard_button);
        this.q = (Button) findViewById(R.id.longtext_button);
        this.C = (ImageView) findViewById(R.id.cursor_imageview_split);
        this.j = (LinearLayout) findViewById(R.id.input_enhance_notinput_keyword_left);
        this.k = (LinearLayout) findViewById(R.id.input_enhance_input_keyword_left);
        this.l = (LinearLayout) findViewById(R.id.input_enhance_keyword_right);
        this.m = (FrameLayout) findViewById(R.id.input_enhance_improve_layout);
        this.r = (TextView) findViewById(R.id.keyword_www);
        this.s = (TextView) findViewById(R.id.keyword_m);
        this.t = (TextView) findViewById(R.id.keyword_wap);
        this.u = (TextView) findViewById(R.id.keyword_dot);
        this.v = (TextView) findViewById(R.id.keyword_slash);
        this.x = (TextView) findViewById(R.id.keyword_com);
        this.w = (TextView) findViewById(R.id.keyword_cn);
        this.y = (TextView) findViewById(R.id.keyword_clipboard);
        this.z = (TextView) findViewById(R.id.keyword_org);
        this.A = (SliderView) findViewById(R.id.slide_view);
        this.A.a = this;
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.add(this.r);
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.w);
        this.B.add(this.y);
        this.n.setText(com.ucpro.ui.c.a.d((int) R.string.input_enhance_previous));
        this.o.setText(com.ucpro.ui.c.a.d((int) R.string.input_enhance_next));
        this.p.setText(com.ucpro.ui.c.a.d((int) R.string.clip_board_title));
        this.q.setText(com.ucpro.ui.c.a.d((int) R.string.longtext_title));
        this.D = (LinearLayout) findViewById(R.id.vertical_search_layout);
        this.E = (ATTextView) findViewById(R.id.vertical_search_title);
        this.F = (LinearLayout) findViewById(R.id.vertical_search_container);
        c();
        this.a = new c(this);
        this.d = new b(this);
        this.b = new a(this);
        this.c = new f(this);
        this.e = new d(this);
    }

    public void setCallback(v vVar) {
        this.O = vVar;
    }

    private void c() {
        int i = 0;
        this.m.setBackgroundColor(com.ucpro.ui.c.a.c("input_enhance_background_color"));
        this.M = (int) com.ucpro.ui.c.a.a((int) R.dimen.inputenhance_height);
        this.C.setImageDrawable(com.ucpro.ui.c.a.a("inputenhance_alpha_line.png"));
        this.f.setBackgroundDrawable(com.ucpro.ui.c.a.a("input_enhance_button_n.9.png"));
        this.f.setPadding(0, 0, 0, 0);
        this.n.setBackgroundDrawable(com.ucpro.ui.c.a.a("input_enhance_previous.xml"));
        this.n.setTextColor(com.ucpro.ui.c.a.d("input_enhance_button_text_color_selector.xml"));
        this.o.setBackgroundDrawable(com.ucpro.ui.c.a.a("input_enhance_next.xml"));
        this.o.setTextColor(com.ucpro.ui.c.a.d("input_enhance_button_text_color_selector.xml"));
        int paddingLeft = this.p.getPaddingLeft();
        this.p.setBackgroundDrawable(com.ucpro.ui.c.a.a("input_enhance_button.xml"));
        this.p.setPadding(paddingLeft, 0, paddingLeft, 0);
        this.p.setTextColor(com.ucpro.ui.c.a.d("input_enhance_button_text_color_selector.xml"));
        this.q.setBackgroundDrawable(com.ucpro.ui.c.a.a("input_enhance_button.xml"));
        this.q.setPadding(paddingLeft, 0, paddingLeft, 0);
        this.q.setTextColor(com.ucpro.ui.c.a.d("input_enhance_button_text_color_selector.xml"));
        paddingLeft = (int) com.ucpro.ui.c.a.a((int) R.dimen.inputenhance_button_padding);
        this.n.setPadding(paddingLeft, 0, paddingLeft, 0);
        this.o.setPadding(paddingLeft, 0, paddingLeft, 0);
        if (!(this.B == null || this.B.isEmpty())) {
            Iterator it = this.B.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnTouchListener(new t(this));
            }
        }
        this.A.a();
        this.D.setBackgroundColor(com.ucpro.ui.c.a.c("input_enhance_vertical_search_bg_color"));
        this.E.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        if (this.F != null) {
            while (i < this.F.getChildCount()) {
                View childAt = this.F.getChildAt(i);
                if (childAt instanceof ImageView) {
                    com.ucpro.ui.c.a.a((ImageView) childAt);
                }
                i++;
            }
        }
    }

    public final void a(e eVar, int i) {
        this.i = eVar;
        this.i.a(i);
    }

    public final void a() {
        c();
        if (this.F != null) {
            int childCount = this.F.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.F.getChildAt(i);
                if (childAt != null && (childAt instanceof ImageView) && childAt.getTag() != null && (childAt.getTag() instanceof com.ucpro.feature.z.g.b.a)) {
                    ((ImageView) childAt).setImageDrawable(com.ucpro.ui.c.a.a(((com.ucpro.feature.z.g.b.a) childAt.getTag()).d));
                }
            }
        }
    }

    public final void a(boolean z) {
        int i = 1;
        if (this.O != null) {
            this.O.j();
        }
        if (this.i == this.a && this.k != null && this.l != null) {
            if (this.K != null && this.K.isRunning()) {
                this.K.cancel();
            }
            this.L = ValueAnimator.ofFloat(new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
            this.L.setDuration(300);
            this.L.setInterpolator(new com.ucpro.ui.animation.a.a());
            this.L.addUpdateListener(new ao(this));
            this.L.addListener(new q(this));
            this.L.start();
            this.h.add(this.L);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.A.getWidth(), com.ucpro.base.system.b.a.f() - ((int) (com.ucweb.common.util.a.a.a(getContext(), 15.0f) * 2.0f))});
            ofInt.setDuration(300);
            ofInt.setInterpolator(new com.ucpro.ui.animation.a.a());
            ofInt.addUpdateListener(new y(this));
            ofInt.addListener(new ap(this, ofInt));
            ofInt.start();
            this.h.add(ofInt);
            if (!z) {
                i = 0;
            }
            if (this.O != null) {
                m.a(2, new ab(this, i), 300);
            }
        }
    }

    public final void b(boolean z) {
        if (this.i == this.a && this.k != null && this.l != null) {
            if (this.L != null && this.L.isRunning()) {
                this.L.cancel();
            }
            if (this.I) {
                this.J = true;
                return;
            }
            this.K = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
            this.K.setDuration(300);
            this.K.setInterpolator(new com.ucpro.ui.animation.a.a());
            this.K.addUpdateListener(new c(this));
            this.K.addListener(new a(this));
            this.K.start();
            this.h.add(this.K);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{(int) (((float) com.ucpro.base.system.b.a.f()) - (com.ucweb.common.util.a.a.a(getContext(), 15.0f) * 2.0f)), (int) com.ucweb.common.util.a.a.a(getContext(), 44.0f)});
            ofInt.setDuration(200);
            ofInt.setInterpolator(new com.ucpro.ui.animation.a.a());
            ofInt.addUpdateListener(new ai(this));
            ofInt.addListener(new i(this, ofInt, z));
            ofInt.start();
            this.h.add(ofInt);
        }
    }

    public final void a(int i) {
        if (this.O != null) {
            this.O.a(i);
        }
    }

    public final void b(int i) {
        if (this.O != null) {
            this.O.b(i);
        }
    }

    public final void onClick(View view) {
        if (this.O != null) {
            switch (view.getId()) {
                case R.id.keyword_dot:
                    this.O.a(this.u.getText().toString());
                    break;
                case R.id.keyword_slash:
                    this.O.a(this.v.getText().toString());
                    break;
                case R.id.keyword_cn:
                    this.O.a(this.w.getText().toString());
                    break;
                case R.id.keyword_wap:
                    this.O.a(this.t.getText().toString());
                    break;
                case R.id.keyword_com:
                    this.O.a(this.x.getText().toString());
                    break;
                case R.id.keyword_clipboard:
                    this.O.d();
                    break;
                case R.id.keyword_org:
                    this.O.a(this.z.getText().toString());
                    break;
                case R.id.slide_view:
                    this.O.i();
                    break;
                case R.id.previous_cursor_button:
                    this.O.f();
                    break;
                case R.id.next_cursor_button:
                    this.O.e();
                    break;
                case R.id.cliboard_button:
                    this.O.c();
                    break;
                case R.id.longtext_button:
                    this.O.g();
                    a(this.c, -1);
                    break;
                case R.id.keyword_www:
                    this.O.a(this.r.getText().toString());
                    break;
                case R.id.keyword_m:
                    this.O.a(this.s.getText().toString());
                    break;
            }
            if (view.getTag() != null && (view.getTag() instanceof com.ucpro.feature.z.g.b.a)) {
                this.O.a((com.ucpro.feature.z.g.b.a) view.getTag());
            }
        }
    }

    public void clearFocus() {
        if (this.O != null) {
            this.O.h();
        }
    }

    public final void b() {
        this.k.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.j.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.l.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        if (this.A != null) {
            this.A.b();
            this.A.a((int) com.ucweb.common.util.a.a.a(getContext(), 44.0f));
        }
    }

    public void setVerticalSearchItems(List<com.ucpro.feature.z.g.b.a> list) {
        int size = list.size();
        this.F.removeAllViews();
        for (int i = 0; i < size; i++) {
            com.ucpro.feature.z.g.b.a aVar = (com.ucpro.feature.z.g.b.a) list.get(i);
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(com.ucpro.ui.c.a.a(aVar.d));
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.G + (this.H * 2), -1);
            layoutParams.gravity = 16;
            imageView.setLayoutParams(layoutParams);
            imageView.setPadding(this.H, 0, this.H, 0);
            imageView.setTag(aVar);
            imageView.setOnClickListener(this);
            this.F.addView(imageView);
        }
    }

    public Button getPreviousCursorButton() {
        return this.n;
    }

    public Button getNextCursorButton() {
        return this.o;
    }

    public Button getClipboardButton() {
        return this.p;
    }

    public Button getLongtextButton() {
        return this.q;
    }

    public ViewGroup getWebButtonLayout() {
        return this.f;
    }

    public ViewGroup getFunButtonLayout() {
        return this.g;
    }

    public int getInputEnhanceHeight() {
        if (this.M < 0) {
            return 0;
        }
        return this.M;
    }

    public int getInputEnhanceImproveHeight() {
        if (this.N <= 0) {
            this.N = com.ucpro.ui.c.a.c((int) R.dimen.input_enhance_layout_height);
        }
        return this.N;
    }

    public LinearLayout getNoinputKeywordLeftLayout() {
        return this.j;
    }

    public LinearLayout getInputKeywordLeftLayout() {
        return this.k;
    }

    public LinearLayout getKeywordRightLayout() {
        return this.l;
    }

    public FrameLayout getInputEnhanceImproveLayout() {
        return this.m;
    }

    public LinearLayout getVerticalSearchLayout() {
        return this.D;
    }

    public TextView getKeywordWap() {
        return this.t;
    }

    public TextView getKeywordCom() {
        return this.x;
    }

    public SliderView getSlideView() {
        return this.A;
    }

    public e getCurrentState() {
        return this.i;
    }

    public v getCallback() {
        return this.O;
    }
}
