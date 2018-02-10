package com.ui.edittext;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.AllCapsTransformationMethod;
import android.text.method.DateKeyListener;
import android.text.method.DateTimeKeyListener;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TextKeyListener.Capitalize;
import android.text.method.TimeKeyListener;
import android.text.method.TransformationMethod;
import android.text.method.TransformationMethod2;
import android.text.method.WordIterator;
import android.text.style.ClickableSpan;
import android.text.style.ParagraphStyle;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.URLSpan;
import android.text.style.UpdateAppearance;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.SpellCheckerSubtype;
import android.view.textservice.TextServicesManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RemoteViews.RemoteView;
import android.widget.Scroller;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.internal.util.FastMath;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;
import org.xmlpull.v1.XmlPullParserException;

@RemoteView
@TargetApi(18)
/* compiled from: ProGuard */
public class TextView extends View implements OnPreDrawListener {
    private static final Metrics am = new Metrics();
    private static int bA = 20;
    private static long bB;
    private static final int[] bC = new int[]{16843597};
    private static final RectF bo = new RectF();
    private static final float[] bp = new float[2];
    private static final InputFilter[] bx = new InputFilter[0];
    private static final Spanned bz = new SpannedString("");
    private float A;
    private int B;
    private TruncateAt C;
    private w D;
    private boolean E;
    private r F;
    private boolean G;
    private ah H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private at O;
    private SuggestionRangeSpan P;
    private int Q;
    private final Drawable[] R;
    private int S;
    private Drawable T;
    private Drawable U;
    private Drawable V;
    private Drawable W;
    final int[] a;
    private q aA;
    private ArrayList<TextWatcher> aB;
    private final TextPaint aC;
    private boolean aD;
    private final Paint aE;
    private int aF;
    private long aG;
    private o aH;
    private boolean aI;
    private af aJ;
    private an aK;
    private ActionMode aL;
    private boolean aM;
    private boolean aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ;
    private boolean aR;
    private int aS;
    private boolean aT;
    private int aU;
    private boolean aV;
    private float aW;
    private float aX;
    private boolean aY;
    private int aZ;
    private ak aa;
    private float ab;
    private float ac;
    private final int ad;
    private boolean ae;
    private WordIterator af;
    private boolean ag;
    private Alignment ah;
    private int ai;
    private boolean aj;
    private int ak;
    private Layout al;
    private PopupWindow an;
    private LinearLayout ao;
    private ag ap;
    private Runnable aq;
    private CharSequence ar;
    private int as;
    private int at;
    private CharSequence au;
    private Layout av;
    private KeyListener aw;
    private h ax;
    private TransformationMethod ay;
    private boolean az;
    Rect b;
    private int ba;
    private int bb;
    private int bc;
    private int bd;
    private int be;
    private int bf;
    private int bg;
    private int bh;
    private int bi;
    private boolean bj;
    private int bk;
    private boolean bl;
    private Path bm;
    private boolean bn;
    private long bq;
    private Scroller br;
    private Metrics bs;
    private Metrics bt;
    private BoringLayout bu;
    private BoringLayout bv;
    private TextDirectionHeuristic bw;
    private InputFilter[] by;
    boolean c;
    boolean d;
    ab e;
    ac f;
    @ExportedProperty(category = "text")
    CharSequence g;
    protected Layout h;
    boolean i;
    s j;
    private d k;
    private int l;
    private ColorStateList m;
    private int n;
    private ColorStateList o;
    private ColorStateList p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Factory w;
    private Spannable.Factory x;
    private float y;
    private float z;

    /* compiled from: ProGuard */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new al();
        int a;
        int b;
        CharSequence c;
        boolean d;
        CharSequence e;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.d ? 1 : 0);
            TextUtils.writeToParcel(this.c, parcel, i);
            if (this.e == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            TextUtils.writeToParcel(this.e, parcel, i);
        }

        public String toString() {
            String str = "TextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.a + " end=" + this.b;
            if (this.c != null) {
                str = str + " text=" + this.c;
            }
            return str + "}";
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.d = parcel.readInt() != 0;
            this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                this.e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            }
        }
    }

    static /* synthetic */ void l(TextView textView) {
        if (textView.bn) {
            textView.r();
            return;
        }
        int compoundPaddingLeft = textView.getCompoundPaddingLeft();
        int extendedPaddingTop = textView.getExtendedPaddingTop() + textView.a(true);
        if (textView.S == 0) {
            synchronized (bo) {
                float ceil = FloatMath.ceil(textView.aC.getStrokeWidth());
                if (ceil < IPictureView.DEFAULT_MIN_SCALE) {
                    ceil = IPictureView.DEFAULT_MIN_SCALE;
                }
                ceil /= 2.0f;
                textView.bm.computeBounds(bo, false);
                textView.invalidate((int) FloatMath.floor((((float) compoundPaddingLeft) + bo.left) - ceil), (int) FloatMath.floor((((float) extendedPaddingTop) + bo.top) - ceil), (int) FloatMath.ceil((((float) compoundPaddingLeft) + bo.right) + ceil), (int) FloatMath.ceil(ceil + (((float) extendedPaddingTop) + bo.bottom)));
            }
            return;
        }
        for (int i = 0; i < textView.S; i++) {
            Rect bounds = textView.R[i].getBounds();
            textView.invalidate(bounds.left + compoundPaddingLeft, bounds.top + extendedPaddingTop, bounds.right + compoundPaddingLeft, bounds.bottom + extendedPaddingTop);
        }
    }

    static /* synthetic */ void q() {
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }

    public TextView(Context context) {
        this(context, null);
    }

    public TextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextView(android.content.Context r50, android.util.AttributeSet r51, int r52) {
        /*
        r49 = this;
        r49.<init>(r50, r51, r52);
        r5 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r0 = r49;
        r0.l = r5;
        r5 = 2;
        r5 = new int[r5];
        r0 = r49;
        r0.a = r5;
        r5 = 0;
        r0 = r49;
        r0.v = r5;
        r5 = 0;
        r0 = r49;
        r0.c = r5;
        r5 = android.text.Editable.Factory.getInstance();
        r0 = r49;
        r0.w = r5;
        r5 = android.text.Spannable.Factory.getInstance();
        r0 = r49;
        r0.x = r5;
        r5 = 0;
        r0 = r49;
        r0.B = r5;
        r5 = 0;
        r0 = r49;
        r0.C = r5;
        r5 = 0;
        r0 = r49;
        r0.F = r5;
        r5 = 0;
        r0 = r49;
        r0.G = r5;
        r5 = 0;
        r0 = r49;
        r0.d = r5;
        r5 = 3;
        r0 = r49;
        r0.J = r5;
        r5 = 2;
        r5 = new android.graphics.drawable.Drawable[r5];
        r0 = r49;
        r0.R = r5;
        r5 = 0;
        r0 = r49;
        r0.ae = r5;
        r5 = 1;
        r0 = r49;
        r0.ag = r5;
        r5 = com.ui.edittext.au.a;
        r0 = r49;
        r0.ai = r5;
        r5 = 0;
        r0 = r49;
        r0.aj = r5;
        r5 = 0;
        r0 = r49;
        r0.ak = r5;
        r5 = "";
        r0 = r49;
        r0.g = r5;
        r5 = com.ui.edittext.p.a;
        r0 = r49;
        r0.as = r5;
        r5 = 0;
        r0 = r49;
        r0.at = r5;
        r5 = 0;
        r0 = r49;
        r0.aB = r5;
        r5 = 1714664933; // 0x6633b5e5 float:2.1216474E23 double:8.471570375E-315;
        r0 = r49;
        r0.aF = r5;
        r5 = 1;
        r0 = r49;
        r0.aI = r5;
        r5 = 0;
        r0 = r49;
        r0.aR = r5;
        r5 = 8388659; // 0x800033 float:1.1755015E-38 double:4.144548E-317;
        r0 = r49;
        r0.aS = r5;
        r5 = 1;
        r0 = r49;
        r0.aV = r5;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r49;
        r0.aW = r5;
        r5 = 0;
        r0 = r49;
        r0.aX = r5;
        r5 = 0;
        r0 = r49;
        r0.aY = r5;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r0 = r49;
        r0.aZ = r5;
        r5 = 1;
        r0 = r49;
        r0.ba = r5;
        r5 = 0;
        r0 = r49;
        r0.bb = r5;
        r5 = 1;
        r0 = r49;
        r0.bc = r5;
        r0 = r49;
        r5 = r0.aZ;
        r0 = r49;
        r0.bd = r5;
        r0 = r49;
        r5 = r0.ba;
        r0 = r49;
        r0.be = r5;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r0 = r49;
        r0.bf = r5;
        r5 = 2;
        r0 = r49;
        r0.bg = r5;
        r5 = 0;
        r0 = r49;
        r0.bh = r5;
        r5 = 2;
        r0 = r49;
        r0.bi = r5;
        r5 = -1;
        r0 = r49;
        r0.bk = r5;
        r5 = 1;
        r0 = r49;
        r0.bl = r5;
        r5 = 1;
        r0 = r49;
        r0.bn = r5;
        r5 = 0;
        r0 = r49;
        r0.br = r5;
        r5 = android.text.TextDirectionHeuristics.LTR;
        r0 = r49;
        r0.bw = r5;
        r5 = bx;
        r0 = r49;
        r0.by = r5;
        r5 = r49.getResources();
        r6 = r5.getCompatibilityInfo();
        r7 = new android.text.TextPaint;
        r8 = 1;
        r7.<init>(r8);
        r0 = r49;
        r0.aC = r7;
        r0 = r49;
        r7 = r0.aC;
        r5 = r5.getDisplayMetrics();
        r5 = r5.density;
        r7.density = r5;
        r0 = r49;
        r5 = r0.aC;
        r7 = r6.applicationScale;
        r5.setCompatibilityScaling(r7);
        r5 = new android.graphics.Paint;
        r7 = 1;
        r5.<init>(r7);
        r0 = r49;
        r0.aE = r5;
        r0 = r49;
        r5 = r0.aE;
        r6 = r6.applicationScale;
        r5.setCompatibilityScaling(r6);
        r5 = r49.getDefaultMovementMethod();
        r0 = r49;
        r0.ax = r5;
        r5 = 0;
        r0 = r49;
        r0.ay = r5;
        r12 = 0;
        r11 = 0;
        r10 = 0;
        r9 = 0;
        r8 = 15;
        r7 = -1;
        r6 = -1;
        r5 = 0;
        r41 = r50.getTheme();
        r13 = com.android.internal.R.styleable.TextViewAppearance;
        r14 = 0;
        r0 = r41;
        r1 = r51;
        r2 = r52;
        r14 = r0.obtainStyledAttributes(r1, r13, r2, r14);
        r13 = 0;
        r15 = 0;
        r16 = -1;
        r15 = r14.getResourceId(r15, r16);
        r14.recycle();
        r14 = -1;
        if (r15 == r14) goto L_0x1ca1;
    L_0x0177:
        r13 = com.android.internal.R.styleable.TextAppearance;
        r0 = r41;
        r13 = r0.obtainStyledAttributes(r15, r13);
        r14 = r13;
    L_0x0180:
        if (r14 == 0) goto L_0x01d1;
    L_0x0182:
        r15 = r14.getIndexCount();
        r13 = 0;
    L_0x0187:
        if (r13 >= r15) goto L_0x01ce;
    L_0x0189:
        r16 = r14.getIndex(r13);
        switch(r16) {
            case 0: goto L_0x01af;
            case 1: goto L_0x01b6;
            case 2: goto L_0x01be;
            case 3: goto L_0x019a;
            case 4: goto L_0x0193;
            case 5: goto L_0x01a1;
            case 6: goto L_0x01a8;
            case 7: goto L_0x0190;
            case 8: goto L_0x0190;
            case 9: goto L_0x0190;
            case 10: goto L_0x0190;
            case 11: goto L_0x01c6;
            default: goto L_0x0190;
        };
    L_0x0190:
        r13 = r13 + 1;
        goto L_0x0187;
    L_0x0193:
        r0 = r16;
        r12 = r14.getColor(r0, r12);
        goto L_0x0190;
    L_0x019a:
        r0 = r16;
        r11 = r14.getColorStateList(r0);
        goto L_0x0190;
    L_0x01a1:
        r0 = r16;
        r10 = r14.getColorStateList(r0);
        goto L_0x0190;
    L_0x01a8:
        r0 = r16;
        r9 = r14.getColorStateList(r0);
        goto L_0x0190;
    L_0x01af:
        r0 = r16;
        r8 = r14.getDimensionPixelSize(r0, r8);
        goto L_0x0190;
    L_0x01b6:
        r7 = -1;
        r0 = r16;
        r7 = r14.getInt(r0, r7);
        goto L_0x0190;
    L_0x01be:
        r6 = -1;
        r0 = r16;
        r6 = r14.getInt(r0, r6);
        goto L_0x0190;
    L_0x01c6:
        r5 = 0;
        r0 = r16;
        r5 = r14.getBoolean(r0, r5);
        goto L_0x0190;
    L_0x01ce:
        r14.recycle();
    L_0x01d1:
        r39 = r49.getDefaultEditable();
        r38 = 0;
        r37 = 0;
        r40 = 0;
        r36 = 0;
        r35 = 0;
        r34 = -1;
        r33 = 0;
        r32 = 0;
        r31 = 0;
        r30 = 0;
        r29 = 0;
        r28 = 0;
        r27 = 0;
        r26 = 0;
        r25 = 0;
        r24 = -1;
        r23 = 0;
        r22 = -1;
        r21 = "";
        r20 = 0;
        r19 = 0;
        r18 = 0;
        r17 = 0;
        r16 = 0;
        r15 = 0;
        r14 = 0;
        r13 = com.android.internal.R.styleable.TextView;
        r42 = 0;
        r0 = r41;
        r1 = r51;
        r2 = r52;
        r3 = r42;
        r42 = r0.obtainStyledAttributes(r1, r13, r2, r3);
        r43 = r42.getIndexCount();
        r13 = 0;
        r41 = r13;
        r13 = r21;
        r21 = r29;
        r29 = r37;
        r37 = r9;
        r9 = r17;
        r17 = r25;
        r25 = r33;
        r33 = r5;
        r46 = r22;
        r22 = r30;
        r30 = r38;
        r38 = r10;
        r10 = r18;
        r18 = r26;
        r26 = r34;
        r34 = r6;
        r6 = r14;
        r14 = r46;
        r47 = r31;
        r31 = r39;
        r39 = r11;
        r11 = r19;
        r19 = r27;
        r27 = r35;
        r35 = r7;
        r7 = r15;
        r15 = r23;
        r23 = r47;
        r48 = r40;
        r40 = r12;
        r12 = r20;
        r20 = r28;
        r28 = r36;
        r36 = r8;
        r8 = r16;
        r16 = r24;
        r24 = r32;
        r32 = r48;
    L_0x0268:
        r0 = r41;
        r1 = r43;
        if (r0 >= r1) goto L_0x1846;
    L_0x026e:
        r0 = r42;
        r1 = r41;
        r5 = r0.getIndex(r1);
        switch(r5) {
            case 0: goto L_0x104e;
            case 1: goto L_0x0279;
            case 2: goto L_0x11bb;
            case 3: goto L_0x1204;
            case 4: goto L_0x124d;
            case 5: goto L_0x10e6;
            case 6: goto L_0x109d;
            case 7: goto L_0x112d;
            case 8: goto L_0x1174;
            case 9: goto L_0x0d14;
            case 10: goto L_0x0ba2;
            case 11: goto L_0x057d;
            case 12: goto L_0x05c9;
            case 13: goto L_0x0a21;
            case 14: goto L_0x0853;
            case 15: goto L_0x0b55;
            case 16: goto L_0x0987;
            case 17: goto L_0x04ed;
            case 18: goto L_0x0c36;
            case 19: goto L_0x0bef;
            case 20: goto L_0x0e95;
            case 21: goto L_0x0dfd;
            case 22: goto L_0x0806;
            case 23: goto L_0x08a0;
            case 24: goto L_0x08ed;
            case 25: goto L_0x093a;
            case 26: goto L_0x09d4;
            case 27: goto L_0x0a6e;
            case 28: goto L_0x0abb;
            case 29: goto L_0x0b08;
            case 30: goto L_0x0c7d;
            case 31: goto L_0x1296;
            case 32: goto L_0x0ccd;
            case 33: goto L_0x0535;
            case 34: goto L_0x0dad;
            case 35: goto L_0x0e4d;
            case 36: goto L_0x0f2e;
            case 37: goto L_0x0f76;
            case 38: goto L_0x0fbe;
            case 39: goto L_0x1006;
            case 40: goto L_0x0386;
            case 41: goto L_0x03ce;
            case 42: goto L_0x0415;
            case 43: goto L_0x0340;
            case 44: goto L_0x04a5;
            case 45: goto L_0x045d;
            case 46: goto L_0x02f7;
            case 47: goto L_0x0ee2;
            case 48: goto L_0x065b;
            case 49: goto L_0x06e9;
            case 50: goto L_0x0615;
            case 51: goto L_0x06a2;
            case 52: goto L_0x07be;
            case 53: goto L_0x12dd;
            case 54: goto L_0x1333;
            case 55: goto L_0x0d5c;
            case 56: goto L_0x1383;
            case 57: goto L_0x1509;
            case 58: goto L_0x1552;
            case 59: goto L_0x13ca;
            case 60: goto L_0x1439;
            case 61: goto L_0x149a;
            case 62: goto L_0x167f;
            case 63: goto L_0x16cb;
            case 64: goto L_0x1717;
            case 65: goto L_0x0279;
            case 66: goto L_0x0279;
            case 67: goto L_0x17af;
            case 68: goto L_0x0279;
            case 69: goto L_0x0279;
            case 70: goto L_0x1633;
            case 71: goto L_0x1763;
            case 72: goto L_0x17fb;
            case 73: goto L_0x0730;
            case 74: goto L_0x0777;
            default: goto L_0x0279;
        };
    L_0x0279:
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
    L_0x02b5:
        r40 = r41 + 1;
        r41 = r40;
        r40 = r39;
        r39 = r38;
        r38 = r37;
        r37 = r36;
        r36 = r35;
        r35 = r34;
        r34 = r33;
        r33 = r32;
        r32 = r31;
        r31 = r30;
        r30 = r29;
        r29 = r28;
        r28 = r27;
        r27 = r26;
        r26 = r25;
        r25 = r24;
        r24 = r23;
        r23 = r22;
        r22 = r21;
        r21 = r20;
        r20 = r19;
        r19 = r18;
        r18 = r17;
        r17 = r16;
        r16 = r15;
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        goto L_0x0268;
    L_0x02f7:
        r0 = r42;
        r1 = r31;
        r5 = r0.getBoolean(r5, r1);
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r46;
        goto L_0x02b5;
    L_0x0340:
        r0 = r42;
        r5 = r0.getText(r5);
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r46;
        goto L_0x02b5;
    L_0x0386:
        r0 = r42;
        r1 = r29;
        r5 = r0.getInt(r5, r1);
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r46;
        goto L_0x02b5;
    L_0x03ce:
        r0 = r42;
        r5 = r0.getText(r5);
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r46;
        goto L_0x02b5;
    L_0x0415:
        r0 = r42;
        r1 = r28;
        r5 = r0.getBoolean(r5, r1);
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r46;
        goto L_0x02b5;
    L_0x045d:
        r0 = r42;
        r1 = r27;
        r5 = r0.getBoolean(r5, r1);
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r46;
        goto L_0x02b5;
    L_0x04a5:
        r0 = r42;
        r1 = r26;
        r5 = r0.getInt(r5, r1);
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r46;
        goto L_0x02b5;
    L_0x04ed:
        r0 = r42;
        r1 = r25;
        r5 = r0.getInt(r5, r1);
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r46;
        goto L_0x02b5;
    L_0x0535:
        r0 = r42;
        r1 = r24;
        r5 = r0.getBoolean(r5, r1);
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r22;
        r22 = r23;
        r23 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r46;
        goto L_0x02b5;
    L_0x057d:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.aU = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x05c9:
        r44 = 1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        r0 = r49;
        r0.aV = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0615:
        r0 = r42;
        r5 = r0.getDrawable(r5);
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r46;
        goto L_0x02b5;
    L_0x065b:
        r0 = r42;
        r5 = r0.getDrawable(r5);
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r5;
        r5 = r6;
        r6 = r46;
        goto L_0x02b5;
    L_0x06a2:
        r0 = r42;
        r5 = r0.getDrawable(r5);
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r46;
        goto L_0x02b5;
    L_0x06e9:
        r0 = r42;
        r5 = r0.getDrawable(r5);
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r46;
        goto L_0x02b5;
    L_0x0730:
        r0 = r42;
        r5 = r0.getDrawable(r5);
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r46;
        goto L_0x02b5;
    L_0x0777:
        r0 = r42;
        r5 = r0.getDrawable(r5);
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r46;
        goto L_0x02b5;
    L_0x07be:
        r0 = r42;
        r1 = r17;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r46;
        goto L_0x02b5;
    L_0x0806:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setMaxLines(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0853:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r0 = r49;
        r0.setMaxHeight(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x08a0:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setLines(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x08ed:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r0 = r49;
        r0.setHeight(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x093a:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setMinLines(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0987:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r0 = r49;
        r0.setMinHeight(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x09d4:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setMaxEms(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0a21:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r0 = r49;
        r0.setMaxWidth(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0a6e:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setEms(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0abb:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r0 = r49;
        r0.setWidth(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0b08:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setMinEms(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0b55:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r0 = r49;
        r0.setMinWidth(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0ba2:
        r44 = -1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setGravity(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0bef:
        r0 = r42;
        r5 = r0.getText(r5);
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r5;
        r5 = r46;
        goto L_0x02b5;
    L_0x0c36:
        r0 = r42;
        r5 = r0.getText(r5);
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r46;
        goto L_0x02b5;
    L_0x0c7d:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        if (r5 == 0) goto L_0x0279;
    L_0x0c89:
        r5 = 1;
        r0 = r49;
        r0.setHorizontallyScrolling(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0ccd:
        r0 = r42;
        r5 = r0.getBoolean(r5, r15);
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r46;
        goto L_0x02b5;
    L_0x0d14:
        r0 = r42;
        r1 = r16;
        r5 = r0.getInt(r5, r1);
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r46;
        goto L_0x02b5;
    L_0x0d5c:
        r0 = r49;
        r0 = r0.J;
        r44 = r0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getInt(r5, r1);
        r0 = r49;
        r0.setMarqueeRepeatLimit(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0dad:
        r44 = 1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        if (r5 != 0) goto L_0x0279;
    L_0x0db9:
        r5 = 0;
        r0 = r49;
        r0.setIncludeFontPadding(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0dfd:
        r44 = 1;
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        if (r5 != 0) goto L_0x0279;
    L_0x0e09:
        r5 = 0;
        r0 = r49;
        r0.setCursorVisible(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0e4d:
        r14 = -1;
        r0 = r42;
        r5 = r0.getInt(r5, r14);
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r46;
        goto L_0x02b5;
    L_0x0e95:
        r44 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r42;
        r1 = r44;
        r5 = r0.getFloat(r5, r1);
        r0 = r49;
        r0.setTextScaleX(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0ee2:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        r0 = r49;
        r0.r = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x0f2e:
        r11 = 0;
        r0 = r42;
        r5 = r0.getInt(r5, r11);
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r46;
        goto L_0x02b5;
    L_0x0f76:
        r10 = 0;
        r0 = r42;
        r5 = r0.getFloat(r5, r10);
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r5;
        r5 = r46;
        goto L_0x02b5;
    L_0x0fbe:
        r9 = 0;
        r0 = r42;
        r5 = r0.getFloat(r5, r9);
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r46;
        goto L_0x02b5;
    L_0x1006:
        r8 = 0;
        r0 = r42;
        r5 = r0.getFloat(r5, r8);
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r46;
        goto L_0x02b5;
    L_0x104e:
        r44 = r49.isEnabled();
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        r0 = r49;
        r0.setEnabled(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x109d:
        r0 = r42;
        r1 = r40;
        r5 = r0.getColor(r5, r1);
        r46 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r5;
        r5 = r46;
        goto L_0x02b5;
    L_0x10e6:
        r0 = r42;
        r5 = r0.getColorStateList(r5);
        r39 = r40;
        r46 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r5;
        r5 = r6;
        r6 = r46;
        goto L_0x02b5;
    L_0x112d:
        r0 = r42;
        r5 = r0.getColorStateList(r5);
        r38 = r39;
        r39 = r40;
        r46 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r46;
        goto L_0x02b5;
    L_0x1174:
        r0 = r42;
        r5 = r0.getColorStateList(r5);
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r46;
        goto L_0x02b5;
    L_0x11bb:
        r0 = r42;
        r1 = r36;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r46;
        goto L_0x02b5;
    L_0x1204:
        r0 = r42;
        r1 = r35;
        r5 = r0.getInt(r5, r1);
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r46;
        goto L_0x02b5;
    L_0x124d:
        r0 = r42;
        r1 = r34;
        r5 = r0.getInt(r5, r1);
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r46;
        goto L_0x02b5;
    L_0x1296:
        r0 = r42;
        r5 = r0.getBoolean(r5, r7);
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r5;
        r5 = r6;
        r6 = r46;
        goto L_0x02b5;
    L_0x12dd:
        r0 = r49;
        r0 = r0.aX;
        r44 = r0;
        r0 = r44;
        r0 = (int) r0;
        r44 = r0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getDimensionPixelSize(r5, r1);
        r5 = (float) r5;
        r0 = r49;
        r0.aX = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1333:
        r0 = r49;
        r0 = r0.aW;
        r44 = r0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getFloat(r5, r1);
        r0 = r49;
        r0.aW = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1383:
        r0 = r49;
        r6 = r0.at;
        r0 = r42;
        r5 = r0.getInt(r5, r6);
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x13ca:
        r0 = r49;
        r0 = r0.e;
        r44 = r0;
        if (r44 != 0) goto L_0x13dd;
    L_0x13d2:
        r44 = new com.ui.edittext.ab;
        r44.<init>();
        r0 = r44;
        r1 = r49;
        r1.e = r0;
    L_0x13dd:
        r0 = r49;
        r0 = r0.e;
        r44 = r0;
        r0 = r49;
        r0 = r0.e;
        r45 = r0;
        r0 = r45;
        r0 = r0.a;
        r45 = r0;
        r0 = r42;
        r1 = r45;
        r5 = r0.getInt(r5, r1);
        r0 = r44;
        r0.a = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1439:
        r0 = r49;
        r0 = r0.e;
        r44 = r0;
        if (r44 != 0) goto L_0x144c;
    L_0x1441:
        r44 = new com.ui.edittext.ab;
        r44.<init>();
        r0 = r44;
        r1 = r49;
        r1.e = r0;
    L_0x144c:
        r0 = r49;
        r0 = r0.e;
        r44 = r0;
        r0 = r42;
        r5 = r0.getText(r5);
        r0 = r44;
        r0.c = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x149a:
        r0 = r49;
        r0 = r0.e;
        r44 = r0;
        if (r44 != 0) goto L_0x14ad;
    L_0x14a2:
        r44 = new com.ui.edittext.ab;
        r44.<init>();
        r0 = r44;
        r1 = r49;
        r1.e = r0;
    L_0x14ad:
        r0 = r49;
        r0 = r0.e;
        r44 = r0;
        r0 = r49;
        r0 = r0.e;
        r45 = r0;
        r0 = r45;
        r0 = r0.d;
        r45 = r0;
        r0 = r42;
        r1 = r45;
        r5 = r0.getInt(r5, r1);
        r0 = r44;
        r0.d = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1509:
        r0 = r42;
        r5 = r0.getString(r5);
        r0 = r49;
        r0.setPrivateImeOptions(r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1552:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getResourceId(r5, r1);	 Catch:{ XmlPullParserException -> 0x159f, IOException -> 0x15e9 }
        r0 = r49;
        r0.setInputExtras(r5);	 Catch:{ XmlPullParserException -> 0x159f, IOException -> 0x15e9 }
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x159f:
        r5 = move-exception;
        r44 = "TextView";
        r45 = "Failure reading input extras";
        r0 = r44;
        r1 = r45;
        android.util.Log.w(r0, r1, r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x15e9:
        r5 = move-exception;
        r44 = "TextView";
        r45 = "Failure reading input extras";
        r0 = r44;
        r1 = r45;
        android.util.Log.w(r0, r1, r5);
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1633:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getResourceId(r5, r1);
        r0 = r49;
        r0.Q = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x167f:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getResourceId(r5, r1);
        r0 = r49;
        r0.K = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x16cb:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getResourceId(r5, r1);
        r0 = r49;
        r0.L = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1717:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getResourceId(r5, r1);
        r0 = r49;
        r0.M = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x1763:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getResourceId(r5, r1);
        r0 = r49;
        r0.N = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x17af:
        r44 = 0;
        r0 = r42;
        r1 = r44;
        r5 = r0.getBoolean(r5, r1);
        r0 = r49;
        r0.aY = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r33;
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        goto L_0x02b5;
    L_0x17fb:
        r33 = 0;
        r0 = r42;
        r1 = r33;
        r5 = r0.getBoolean(r5, r1);
        r33 = r34;
        r34 = r35;
        r35 = r36;
        r36 = r37;
        r37 = r38;
        r38 = r39;
        r39 = r40;
        r46 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r27;
        r27 = r28;
        r28 = r29;
        r29 = r30;
        r30 = r31;
        r31 = r32;
        r32 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r46;
        goto L_0x02b5;
    L_0x1846:
        r42.recycle();
        r41 = com.ui.edittext.p.c;
        r0 = r6 & 4095;
        r42 = r0;
        r5 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        r0 = r42;
        if (r0 != r5) goto L_0x1aa5;
    L_0x1855:
        r5 = 1;
        r44 = r5;
    L_0x1858:
        r5 = 225; // 0xe1 float:3.15E-43 double:1.11E-321;
        r0 = r42;
        if (r0 != r5) goto L_0x1aaa;
    L_0x185e:
        r5 = 1;
        r43 = r5;
    L_0x1861:
        r5 = 18;
        r0 = r42;
        if (r0 != r5) goto L_0x1aaf;
    L_0x1867:
        r5 = 1;
        r42 = r5;
    L_0x186a:
        if (r30 == 0) goto L_0x1add;
    L_0x186c:
        r5 = r30.toString();	 Catch:{ ClassNotFoundException -> 0x1ab4 }
        r5 = java.lang.Class.forName(r5);	 Catch:{ ClassNotFoundException -> 0x1ab4 }
        r5 = r5.newInstance();	 Catch:{ InstantiationException -> 0x1abb, IllegalAccessException -> 0x1ac2 }
        r5 = (android.text.method.KeyListener) r5;	 Catch:{ InstantiationException -> 0x1abb, IllegalAccessException -> 0x1ac2 }
        r0 = r49;
        r0.aw = r5;	 Catch:{ InstantiationException -> 0x1abb, IllegalAccessException -> 0x1ac2 }
        if (r6 == 0) goto L_0x1ac9;
    L_0x1880:
        r0 = r49;
        r0.at = r6;	 Catch:{ IncompatibleClassChangeError -> 0x1ad3 }
        r5 = r41;
    L_0x1886:
        r0 = r49;
        r6 = r0.at;
        r6 = r6 & 15;
        r25 = 1;
        r0 = r25;
        if (r6 != r0) goto L_0x1bcb;
    L_0x1892:
        if (r7 != 0) goto L_0x1896;
    L_0x1894:
        if (r44 == 0) goto L_0x18a2;
    L_0x1896:
        r0 = r49;
        r6 = r0.at;
        r6 = r6 & -4081;
        r6 = r6 | 128;
        r0 = r49;
        r0.at = r6;
    L_0x18a2:
        if (r43 == 0) goto L_0x18b0;
    L_0x18a4:
        r0 = r49;
        r6 = r0.at;
        r6 = r6 & -4081;
        r6 = r6 | 224;
        r0 = r49;
        r0.at = r6;
    L_0x18b0:
        if (r24 == 0) goto L_0x1c9e;
    L_0x18b2:
        r6 = 1;
        r0 = r49;
        r0.aR = r6;
        r6 = com.ui.edittext.p.a;
        if (r5 != r6) goto L_0x1c9e;
    L_0x18bb:
        r5 = com.ui.edittext.p.b;
        r6 = r5;
    L_0x18be:
        if (r23 == 0) goto L_0x18d6;
    L_0x18c0:
        r5 = 0;
        r24 = 0;
        r25 = r23.getIntrinsicWidth();
        r26 = r23.getIntrinsicHeight();
        r0 = r23;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r0.setBounds(r5, r1, r2, r3);
    L_0x18d6:
        if (r21 == 0) goto L_0x18ee;
    L_0x18d8:
        r5 = 0;
        r24 = 0;
        r25 = r21.getIntrinsicWidth();
        r26 = r21.getIntrinsicHeight();
        r0 = r21;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r0.setBounds(r5, r1, r2, r3);
    L_0x18ee:
        if (r22 == 0) goto L_0x1906;
    L_0x18f0:
        r5 = 0;
        r24 = 0;
        r25 = r22.getIntrinsicWidth();
        r26 = r22.getIntrinsicHeight();
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r0.setBounds(r5, r1, r2, r3);
    L_0x1906:
        if (r20 == 0) goto L_0x191e;
    L_0x1908:
        r5 = 0;
        r24 = 0;
        r25 = r20.getIntrinsicWidth();
        r26 = r20.getIntrinsicHeight();
        r0 = r20;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r0.setBounds(r5, r1, r2, r3);
    L_0x191e:
        r0 = r49;
        r1 = r23;
        r2 = r22;
        r3 = r21;
        r4 = r20;
        r0.a(r1, r2, r3, r4);
        if (r19 != 0) goto L_0x192f;
    L_0x192d:
        if (r18 == 0) goto L_0x1be7;
    L_0x192f:
        r5 = 1;
    L_0x1930:
        if (r5 == 0) goto L_0x19cd;
    L_0x1932:
        r0 = r49;
        r5 = r0.D;
        if (r5 != 0) goto L_0x1941;
    L_0x1938:
        r5 = new com.ui.edittext.w;
        r5.<init>();
        r0 = r49;
        r0.D = r5;
    L_0x1941:
        r0 = r5.a;
        r20 = r0;
        r21 = r49.getDrawableState();
        if (r19 == 0) goto L_0x1bea;
    L_0x194b:
        r22 = 0;
        r23 = 0;
        r24 = r19.getIntrinsicWidth();
        r25 = r19.getIntrinsicHeight();
        r0 = r19;
        r1 = r22;
        r2 = r23;
        r3 = r24;
        r4 = r25;
        r0.setBounds(r1, r2, r3, r4);
        r0 = r19;
        r1 = r21;
        r0.setState(r1);
        r19.copyBounds(r20);
        r0 = r19;
        r1 = r49;
        r0.setCallback(r1);
        r0 = r19;
        r5.f = r0;
        r19 = r20.width();
        r0 = r19;
        r5.l = r0;
        r19 = r20.height();
        r0 = r19;
        r5.r = r0;
    L_0x1989:
        if (r18 == 0) goto L_0x1bf6;
    L_0x198b:
        r19 = 0;
        r22 = 0;
        r23 = r18.getIntrinsicWidth();
        r24 = r18.getIntrinsicHeight();
        r0 = r18;
        r1 = r19;
        r2 = r22;
        r3 = r23;
        r4 = r24;
        r0.setBounds(r1, r2, r3, r4);
        r0 = r18;
        r1 = r21;
        r0.setState(r1);
        r0 = r18;
        r1 = r20;
        r0.copyBounds(r1);
        r0 = r18;
        r1 = r49;
        r0.setCallback(r1);
        r0 = r18;
        r5.g = r0;
        r18 = r20.width();
        r0 = r18;
        r5.m = r0;
        r18 = r20.height();
        r0 = r18;
        r5.s = r0;
    L_0x19cd:
        r0 = r49;
        r1 = r17;
        r0.setCompoundDrawablePadding(r1);
        r0 = r49;
        r0.setInputTypeSingleLine(r15);
        r0 = r49;
        r0.a(r15, r15, r15);
        if (r15 == 0) goto L_0x19ea;
    L_0x19e0:
        r0 = r49;
        r5 = r0.aw;
        if (r5 != 0) goto L_0x19ea;
    L_0x19e6:
        if (r16 >= 0) goto L_0x19ea;
    L_0x19e8:
        r16 = 3;
    L_0x19ea:
        switch(r16) {
            case 1: goto L_0x1c02;
            case 2: goto L_0x1c0b;
            case 3: goto L_0x1c14;
            case 4: goto L_0x1c1d;
            default: goto L_0x19ed;
        };
    L_0x19ed:
        if (r39 == 0) goto L_0x1c47;
    L_0x19ef:
        r0 = r49;
        r1 = r39;
        r0.setTextColor(r1);
        r0 = r49;
        r1 = r38;
        r0.setHintTextColor(r1);
        r0 = r49;
        r1 = r37;
        r0.setLinkTextColor(r1);
        if (r40 == 0) goto L_0x1a0d;
    L_0x1a06:
        r0 = r49;
        r1 = r40;
        r0.setHighlightColor(r1);
    L_0x1a0d:
        r0 = r36;
        r5 = (float) r0;
        r0 = r49;
        r0.setRawTextSize(r5);
        if (r33 == 0) goto L_0x1a25;
    L_0x1a17:
        r5 = new android.text.method.AllCapsTransformationMethod;
        r15 = r49.getContext();
        r5.<init>(r15);
        r0 = r49;
        r0.setTransformationMethod(r5);
    L_0x1a25:
        if (r7 != 0) goto L_0x1a2d;
    L_0x1a27:
        if (r44 != 0) goto L_0x1a2d;
    L_0x1a29:
        if (r43 != 0) goto L_0x1a2d;
    L_0x1a2b:
        if (r42 == 0) goto L_0x1c4f;
    L_0x1a2d:
        r5 = android.text.method.PasswordTransformationMethod.getInstance();
        r0 = r49;
        r0.setTransformationMethod(r5);
        r35 = 3;
    L_0x1a38:
        r0 = r49;
        r1 = r35;
        r2 = r34;
        r0.a(r1, r2);
        if (r11 == 0) goto L_0x1a59;
    L_0x1a43:
        r0 = r49;
        r5 = r0.aC;
        r5.setShadowLayer(r8, r10, r9, r11);
        r0 = r49;
        r0.y = r8;
        r0 = r49;
        r0.z = r10;
        r0 = r49;
        r0.A = r9;
        r49.invalidate();
    L_0x1a59:
        if (r14 < 0) goto L_0x1c5d;
    L_0x1a5b:
        r5 = 1;
        r5 = new android.text.InputFilter[r5];
        r7 = 0;
        r8 = new android.text.InputFilter$LengthFilter;
        r8.<init>(r14);
        r5[r7] = r8;
        r0 = r49;
        r0.setFilters(r5);
    L_0x1a6b:
        r0 = r49;
        r0.a(r13, r6);
        if (r12 == 0) goto L_0x1a77;
    L_0x1a72:
        r0 = r49;
        r0.setHint(r12);
    L_0x1a77:
        r5 = com.android.internal.R.styleable.View;
        r6 = 0;
        r0 = r50;
        r1 = r51;
        r2 = r52;
        r9 = r0.obtainStyledAttributes(r1, r5, r2, r6);
        r0 = r49;
        r5 = r0.ax;
        if (r5 != 0) goto L_0x1a90;
    L_0x1a8a:
        r0 = r49;
        r5 = r0.aw;
        if (r5 == 0) goto L_0x1c66;
    L_0x1a90:
        r5 = 1;
    L_0x1a91:
        r10 = r9.getIndexCount();
        r6 = 0;
        r8 = r6;
        r7 = r5;
        r6 = r5;
    L_0x1a99:
        if (r8 >= r10) goto L_0x1c7b;
    L_0x1a9b:
        r11 = r9.getIndex(r8);
        switch(r11) {
            case 18: goto L_0x1c69;
            case 29: goto L_0x1c6f;
            case 30: goto L_0x1c75;
            default: goto L_0x1aa2;
        };
    L_0x1aa2:
        r8 = r8 + 1;
        goto L_0x1a99;
    L_0x1aa5:
        r5 = 0;
        r44 = r5;
        goto L_0x1858;
    L_0x1aaa:
        r5 = 0;
        r43 = r5;
        goto L_0x1861;
    L_0x1aaf:
        r5 = 0;
        r42 = r5;
        goto L_0x186a;
    L_0x1ab4:
        r5 = move-exception;
        r6 = new java.lang.RuntimeException;
        r6.<init>(r5);
        throw r6;
    L_0x1abb:
        r5 = move-exception;
        r6 = new java.lang.RuntimeException;
        r6.<init>(r5);
        throw r6;
    L_0x1ac2:
        r5 = move-exception;
        r6 = new java.lang.RuntimeException;
        r6.<init>(r5);
        throw r6;
    L_0x1ac9:
        r0 = r49;
        r5 = r0.aw;	 Catch:{ IncompatibleClassChangeError -> 0x1ad3 }
        r6 = r5.getInputType();	 Catch:{ IncompatibleClassChangeError -> 0x1ad3 }
        goto L_0x1880;
    L_0x1ad3:
        r5 = move-exception;
        r5 = 1;
        r0 = r49;
        r0.at = r5;
        r5 = r41;
        goto L_0x1886;
    L_0x1add:
        if (r32 == 0) goto L_0x1af7;
    L_0x1adf:
        r5 = r32.toString();
        r5 = android.text.method.DigitsKeyListener.getInstance(r5);
        r0 = r49;
        r0.aw = r5;
        if (r6 == 0) goto L_0x1af5;
    L_0x1aed:
        r0 = r49;
        r0.at = r6;
        r5 = r41;
        goto L_0x1886;
    L_0x1af5:
        r6 = 1;
        goto L_0x1aed;
    L_0x1af7:
        if (r6 == 0) goto L_0x1b0d;
    L_0x1af9:
        r5 = 1;
        r0 = r49;
        r0.a(r6, r5);
        r5 = d(r6);
        if (r5 != 0) goto L_0x1b0b;
    L_0x1b05:
        r5 = 1;
    L_0x1b06:
        r15 = r5;
        r5 = r41;
        goto L_0x1886;
    L_0x1b0b:
        r5 = 0;
        goto L_0x1b06;
    L_0x1b0d:
        if (r28 == 0) goto L_0x1b20;
    L_0x1b0f:
        r5 = android.text.method.DialerKeyListener.getInstance();
        r0 = r49;
        r0.aw = r5;
        r5 = 3;
        r0 = r49;
        r0.at = r5;
        r5 = r41;
        goto L_0x1886;
    L_0x1b20:
        if (r29 == 0) goto L_0x1b4f;
    L_0x1b22:
        r5 = r29 & 2;
        if (r5 == 0) goto L_0x1b4a;
    L_0x1b26:
        r5 = 1;
        r6 = r5;
    L_0x1b28:
        r5 = r29 & 4;
        if (r5 == 0) goto L_0x1b4d;
    L_0x1b2c:
        r5 = 1;
    L_0x1b2d:
        r5 = android.text.method.DigitsKeyListener.getInstance(r6, r5);
        r0 = r49;
        r0.aw = r5;
        r5 = 2;
        r6 = r29 & 2;
        if (r6 == 0) goto L_0x1b3c;
    L_0x1b3a:
        r5 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
    L_0x1b3c:
        r6 = r29 & 4;
        if (r6 == 0) goto L_0x1b42;
    L_0x1b40:
        r5 = r5 | 8192;
    L_0x1b42:
        r0 = r49;
        r0.at = r5;
        r5 = r41;
        goto L_0x1886;
    L_0x1b4a:
        r5 = 0;
        r6 = r5;
        goto L_0x1b28;
    L_0x1b4d:
        r5 = 0;
        goto L_0x1b2d;
    L_0x1b4f:
        if (r27 != 0) goto L_0x1b56;
    L_0x1b51:
        r5 = -1;
        r0 = r26;
        if (r0 == r5) goto L_0x1b7d;
    L_0x1b56:
        r5 = 1;
        switch(r26) {
            case 1: goto L_0x1b6e;
            case 2: goto L_0x1b73;
            case 3: goto L_0x1b78;
            default: goto L_0x1b5a;
        };
    L_0x1b5a:
        r6 = android.text.method.TextKeyListener.Capitalize.NONE;
    L_0x1b5c:
        r0 = r27;
        r6 = android.text.method.TextKeyListener.getInstance(r0, r6);
        r0 = r49;
        r0.aw = r6;
        r0 = r49;
        r0.at = r5;
        r5 = r41;
        goto L_0x1886;
    L_0x1b6e:
        r6 = android.text.method.TextKeyListener.Capitalize.SENTENCES;
        r5 = 16385; // 0x4001 float:2.296E-41 double:8.0953E-320;
        goto L_0x1b5c;
    L_0x1b73:
        r6 = android.text.method.TextKeyListener.Capitalize.WORDS;
        r5 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
        goto L_0x1b5c;
    L_0x1b78:
        r6 = android.text.method.TextKeyListener.Capitalize.CHARACTERS;
        r5 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        goto L_0x1b5c;
    L_0x1b7d:
        r0 = r49;
        r5 = r0.aY;
        if (r5 == 0) goto L_0x1ba0;
    L_0x1b83:
        r5 = 0;
        r0 = r49;
        r0.at = r5;
        r5 = 0;
        r0 = r49;
        r0.aw = r5;
        r5 = com.ui.edittext.p.b;
        r6 = 1;
        r0 = r49;
        r0.setFocusableInTouchMode(r6);
        r6 = com.ui.edittext.a.b();
        r0 = r49;
        r0.setMovementMethod(r6);
        goto L_0x1886;
    L_0x1ba0:
        if (r31 == 0) goto L_0x1bb3;
    L_0x1ba2:
        r5 = android.text.method.TextKeyListener.getInstance();
        r0 = r49;
        r0.aw = r5;
        r5 = 1;
        r0 = r49;
        r0.at = r5;
        r5 = r41;
        goto L_0x1886;
    L_0x1bb3:
        r5 = 0;
        r0 = r49;
        r0.aw = r5;
        switch(r25) {
            case 0: goto L_0x1bbf;
            case 1: goto L_0x1bc3;
            case 2: goto L_0x1bc7;
            default: goto L_0x1bbb;
        };
    L_0x1bbb:
        r5 = r41;
        goto L_0x1886;
    L_0x1bbf:
        r5 = com.ui.edittext.p.a;
        goto L_0x1886;
    L_0x1bc3:
        r5 = com.ui.edittext.p.b;
        goto L_0x1886;
    L_0x1bc7:
        r5 = com.ui.edittext.p.c;
        goto L_0x1886;
    L_0x1bcb:
        r0 = r49;
        r6 = r0.at;
        r6 = r6 & 15;
        r25 = 2;
        r0 = r25;
        if (r6 != r0) goto L_0x18b0;
    L_0x1bd7:
        if (r42 == 0) goto L_0x18b0;
    L_0x1bd9:
        r0 = r49;
        r6 = r0.at;
        r6 = r6 & -4081;
        r6 = r6 | 16;
        r0 = r49;
        r0.at = r6;
        goto L_0x18b0;
    L_0x1be7:
        r5 = 0;
        goto L_0x1930;
    L_0x1bea:
        r19 = 0;
        r0 = r19;
        r5.r = r0;
        r0 = r19;
        r5.l = r0;
        goto L_0x1989;
    L_0x1bf6:
        r18 = 0;
        r0 = r18;
        r5.s = r0;
        r0 = r18;
        r5.m = r0;
        goto L_0x19cd;
    L_0x1c02:
        r5 = android.text.TextUtils.TruncateAt.START;
        r0 = r49;
        r0.setEllipsize(r5);
        goto L_0x19ed;
    L_0x1c0b:
        r5 = android.text.TextUtils.TruncateAt.MIDDLE;
        r0 = r49;
        r0.setEllipsize(r5);
        goto L_0x19ed;
    L_0x1c14:
        r5 = android.text.TextUtils.TruncateAt.END;
        r0 = r49;
        r0.setEllipsize(r5);
        goto L_0x19ed;
    L_0x1c1d:
        r5 = android.view.ViewConfiguration.get(r50);
        r5 = r5.isFadingMarqueeEnabled();
        if (r5 == 0) goto L_0x1c3b;
    L_0x1c27:
        r5 = 1;
        r0 = r49;
        r0.setHorizontalFadingEdgeEnabled(r5);
        r5 = 0;
        r0 = r49;
        r0.ak = r5;
    L_0x1c32:
        r5 = android.text.TextUtils.TruncateAt.MARQUEE;
        r0 = r49;
        r0.setEllipsize(r5);
        goto L_0x19ed;
    L_0x1c3b:
        r5 = 0;
        r0 = r49;
        r0.setHorizontalFadingEdgeEnabled(r5);
        r5 = 1;
        r0 = r49;
        r0.ak = r5;
        goto L_0x1c32;
    L_0x1c47:
        r5 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r39 = android.content.res.ColorStateList.valueOf(r5);
        goto L_0x19ef;
    L_0x1c4f:
        r0 = r49;
        r5 = r0.at;
        r5 = r5 & 4095;
        r7 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        if (r5 != r7) goto L_0x1a38;
    L_0x1c59:
        r35 = 3;
        goto L_0x1a38;
    L_0x1c5d:
        r5 = bx;
        r0 = r49;
        r0.setFilters(r5);
        goto L_0x1a6b;
    L_0x1c66:
        r5 = 0;
        goto L_0x1a91;
    L_0x1c69:
        r5 = r9.getBoolean(r11, r5);
        goto L_0x1aa2;
    L_0x1c6f:
        r7 = r9.getBoolean(r11, r7);
        goto L_0x1aa2;
    L_0x1c75:
        r6 = r9.getBoolean(r11, r6);
        goto L_0x1aa2;
    L_0x1c7b:
        r9.recycle();
        r0 = r49;
        r0.setFocusable(r5);
        r0 = r49;
        r0.setClickable(r7);
        r0 = r49;
        r0.setLongClickable(r6);
        r49.G();
        r5 = android.view.ViewConfiguration.get(r50);
        r5 = r5.getScaledTouchSlop();
        r5 = r5 * r5;
        r0 = r49;
        r0.ad = r5;
        return;
    L_0x1c9e:
        r6 = r5;
        goto L_0x18be;
    L_0x1ca1:
        r14 = r13;
        goto L_0x0180;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ui.edittext.TextView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a(int i, int i2) {
        boolean z = false;
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        if (i2 > 0) {
            int style;
            float f;
            if (typeface == null) {
                typeface = Typeface.defaultFromStyle(i2);
            } else {
                typeface = Typeface.create(typeface, i2);
            }
            setTypeface(typeface);
            if (typeface != null) {
                style = typeface.getStyle();
            } else {
                style = 0;
            }
            style = (style ^ -1) & i2;
            TextPaint textPaint = this.aC;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.aC;
            if ((style & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.aC.setFakeBoldText(false);
        this.aC.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            InputMethodManager peekInstance;
            if (!z) {
                peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null && peekInstance.isActive(this)) {
                    peekInstance.hideSoftInputFromWindow(getWindowToken(), 0);
                }
            }
            super.setEnabled(z);
            G();
            if (z) {
                peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null) {
                    peekInstance.restartInput(this);
                }
            }
            J();
        }
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    protected h getDefaultMovementMethod() {
        return null;
    }

    @CapturedViewProperty
    public CharSequence getText() {
        return this.g;
    }

    public final int a() {
        return this.g.length();
    }

    public Editable getEditableText() {
        return this.g instanceof Editable ? (Editable) this.g : null;
    }

    public int getLineHeight() {
        return FastMath.round((((float) this.aC.getFontMetricsInt(null)) * this.aW) + this.aX);
    }

    public final Layout getLayout() {
        return this.h;
    }

    public final KeyListener getKeyListener() {
        return this.aw;
    }

    public void setKeyListener(KeyListener keyListener) {
        setKeyListenerOnly(keyListener);
        d();
        if (keyListener != null) {
            try {
                this.at = this.aw.getInputType();
            } catch (IncompatibleClassChangeError e) {
                this.at = 1;
            }
            setInputTypeSingleLine(this.bj);
        } else {
            this.at = 0;
        }
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (peekInstance != null) {
            peekInstance.restartInput(this);
        }
    }

    private void setKeyListenerOnly(KeyListener keyListener) {
        this.aw = keyListener;
        if (!(this.aw == null || (this.g instanceof Editable))) {
            setText(this.g);
        }
        a((Editable) this.g, this.by);
    }

    public final h getMovementMethod() {
        return this.ax;
    }

    public final void setMovementMethod(h hVar) {
        this.ax = hVar;
        if (!(this.ax == null || (this.g instanceof Spannable))) {
            setText(this.g);
        }
        d();
        G();
    }

    private void d() {
        if (this.ax == null && this.aw == null) {
            setFocusable(false);
            setClickable(false);
            setLongClickable(false);
            return;
        }
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
    }

    public final TransformationMethod getTransformationMethod() {
        return this.ay;
    }

    public final void setTransformationMethod(TransformationMethod transformationMethod) {
        if (transformationMethod != this.ay) {
            if (this.ay != null && (this.g instanceof Spannable)) {
                ((Spannable) this.g).removeSpan(this.ay);
            }
            this.ay = transformationMethod;
            if (transformationMethod instanceof TransformationMethod2) {
                TransformationMethod2 transformationMethod2 = (TransformationMethod2) transformationMethod;
                boolean z = (this.aY || (this.g instanceof Editable)) ? false : true;
                this.az = z;
                transformationMethod2.setLengthChangesAllowed(this.az);
            } else {
                this.az = false;
            }
            setText(this.g);
        }
    }

    public int getCompoundPaddingTop() {
        w wVar = this.D;
        if (wVar == null || wVar.b == null) {
            return this.mPaddingTop;
        }
        return wVar.h + (this.mPaddingTop + wVar.t);
    }

    public int getCompoundPaddingBottom() {
        w wVar = this.D;
        if (wVar == null || wVar.c == null) {
            return this.mPaddingBottom;
        }
        return wVar.i + (this.mPaddingBottom + wVar.t);
    }

    public int getCompoundPaddingLeft() {
        w wVar = this.D;
        if (wVar == null || wVar.d == null) {
            return this.mPaddingLeft;
        }
        return wVar.j + (this.mPaddingLeft + wVar.t);
    }

    public int getCompoundPaddingRight() {
        w wVar = this.D;
        if (wVar == null || wVar.e == null) {
            return this.mPaddingRight;
        }
        return wVar.k + (this.mPaddingRight + wVar.t);
    }

    public int getCompoundPaddingStart() {
        U();
        switch (getResolvedLayoutDirection()) {
            case 1:
                return getCompoundPaddingRight();
            default:
                return getCompoundPaddingLeft();
        }
    }

    public int getCompoundPaddingEnd() {
        U();
        switch (getResolvedLayoutDirection()) {
            case 1:
                return getCompoundPaddingLeft();
            default:
                return getCompoundPaddingRight();
        }
    }

    public int getExtendedPaddingTop() {
        if (this.ba != 1) {
            return getCompoundPaddingTop();
        }
        if (this.h.getLineCount() <= this.aZ) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.h.getLineTop(this.aZ);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i = this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        if (i == 48) {
            return compoundPaddingTop;
        }
        if (i == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    public int getExtendedPaddingBottom() {
        if (this.ba != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.h.getLineCount() <= this.aZ) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.h.getLineTop(this.aZ);
        if (lineTop >= compoundPaddingTop) {
            return compoundPaddingBottom;
        }
        int i = this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        if (i == 48) {
            return (compoundPaddingBottom + compoundPaddingTop) - lineTop;
        }
        return i != 80 ? compoundPaddingBottom + ((compoundPaddingTop - lineTop) / 2) : compoundPaddingBottom;
    }

    public int getTotalPaddingLeft() {
        return getCompoundPaddingLeft();
    }

    public int getTotalPaddingRight() {
        return getCompoundPaddingRight();
    }

    public int getTotalPaddingStart() {
        return getCompoundPaddingStart();
    }

    public int getTotalPaddingEnd() {
        return getCompoundPaddingEnd();
    }

    public int getTotalPaddingTop() {
        return getExtendedPaddingTop() + a(true);
    }

    public int getTotalPaddingBottom() {
        int measuredHeight;
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i = this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        Layout layout = this.h;
        if (i != 80) {
            if (layout == this.av) {
                measuredHeight = (getMeasuredHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
            } else {
                measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            }
            int height = layout.getHeight();
            if (height < measuredHeight) {
                measuredHeight = i == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
                return measuredHeight + extendedPaddingBottom;
            }
        }
        measuredHeight = 0;
        return measuredHeight + extendedPaddingBottom;
    }

    public final void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        w wVar = this.D;
        int i = (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) ? 0 : 1;
        if (i != 0) {
            if (wVar == null) {
                wVar = new w();
                this.D = wVar;
            }
            if (!(wVar.d == drawable || wVar.d == null)) {
                wVar.d.setCallback(null);
            }
            wVar.d = drawable;
            if (!(wVar.b == drawable2 || wVar.b == null)) {
                wVar.b.setCallback(null);
            }
            wVar.b = drawable2;
            if (!(wVar.e == drawable3 || wVar.e == null)) {
                wVar.e.setCallback(null);
            }
            wVar.e = drawable3;
            if (!(wVar.c == drawable4 || wVar.c == null)) {
                wVar.c.setCallback(null);
            }
            wVar.c = drawable4;
            Rect rect = wVar.a;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                wVar.j = rect.width();
                wVar.p = rect.height();
            } else {
                wVar.p = 0;
                wVar.j = 0;
            }
            if (drawable3 != null) {
                drawable3.setState(drawableState);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                wVar.k = rect.width();
                wVar.q = rect.height();
            } else {
                wVar.q = 0;
                wVar.k = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                wVar.h = rect.height();
                wVar.n = rect.width();
            } else {
                wVar.n = 0;
                wVar.h = 0;
            }
            if (drawable4 != null) {
                drawable4.setState(drawableState);
                drawable4.copyBounds(rect);
                drawable4.setCallback(this);
                wVar.i = rect.height();
                wVar.o = rect.width();
            }
            wVar.o = 0;
            wVar.i = 0;
        } else if (wVar != null) {
            if (wVar.t == 0) {
                this.D = null;
            } else {
                if (wVar.d != null) {
                    wVar.d.setCallback(null);
                }
                wVar.d = null;
                if (wVar.b != null) {
                    wVar.b.setCallback(null);
                }
                wVar.b = null;
                if (wVar.e != null) {
                    wVar.e.setCallback(null);
                }
                wVar.e = null;
                if (wVar.c != null) {
                    wVar.c.setCallback(null);
                }
                wVar.c = null;
                wVar.p = 0;
                wVar.j = 0;
                wVar.q = 0;
                wVar.k = 0;
                wVar.n = 0;
                wVar.h = 0;
                wVar.o = 0;
                wVar.i = 0;
            }
        }
        invalidate();
        requestLayout();
    }

    public Drawable[] getCompoundDrawables() {
        if (this.D != null) {
            return new Drawable[]{this.D.d, this.D.b, this.D.e, this.D.c};
        }
        return new Drawable[]{null, null, null, null};
    }

    public Drawable[] getCompoundDrawablesRelative() {
        if (this.D != null) {
            return new Drawable[]{this.D.f, this.D.b, this.D.g, this.D.c};
        }
        return new Drawable[]{null, null, null, null};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCompoundDrawablePadding(int r2) {
        /*
        r1 = this;
        r0 = r1.D;
        if (r2 != 0) goto L_0x000f;
    L_0x0004:
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r0.t = r2;
    L_0x0008:
        r1.invalidate();
        r1.requestLayout();
        return;
    L_0x000f:
        if (r0 != 0) goto L_0x0006;
    L_0x0011:
        r0 = new com.ui.edittext.w;
        r0.<init>();
        r1.D = r0;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ui.edittext.TextView.setCompoundDrawablePadding(int):void");
    }

    public int getCompoundDrawablePadding() {
        w wVar = this.D;
        return wVar != null ? wVar.t : 0;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == this.mPaddingLeft && i3 == this.mPaddingRight && i2 == this.mPaddingTop && i4 == this.mPaddingBottom)) {
            v();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public final int getAutoLinkMask() {
        return this.aU;
    }

    public float getTextSize() {
        return this.aC.getTextSize();
    }

    @RemotableViewMethod
    public void setTextSize(float f) {
        a(2, f);
    }

    public final void a(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (f != this.aC.getTextSize()) {
            this.aC.setTextSize(f);
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    public float getTextScaleX() {
        return this.aC.getTextScaleX();
    }

    @RemotableViewMethod
    public void setTextScaleX(float f) {
        if (f != this.aC.getTextScaleX()) {
            this.aD = true;
            this.aC.setTextScaleX(f);
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setTypeface(Typeface typeface) {
        if (this.aC.getTypeface() != typeface) {
            this.aC.setTypeface(typeface);
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    public Typeface getTypeface() {
        return this.aC.getTypeface();
    }

    @RemotableViewMethod
    public void setTextColor(int i) {
        this.m = ColorStateList.valueOf(i);
        e();
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        }
        this.m = colorStateList;
        e();
    }

    public final ColorStateList getTextColors() {
        return this.m;
    }

    public final int getCurrentTextColor() {
        return this.n;
    }

    @RemotableViewMethod
    public void setHighlightColor(int i) {
        if (this.aF != i) {
            this.aF = i;
            invalidate();
        }
    }

    public TextPaint getPaint() {
        return this.aC;
    }

    @RemotableViewMethod
    public final void setAutoLinkMask(int i) {
        this.aU = i;
    }

    @RemotableViewMethod
    public final void setLinksClickable(boolean z) {
        this.aV = z;
    }

    public final boolean getLinksClickable() {
        return this.aV;
    }

    @RemotableViewMethod
    public final void setSoftInputShownOnFocus(boolean z) {
        this.ag = z;
    }

    public final boolean getSoftInputShownOnFocus() {
        return this.ag;
    }

    public URLSpan[] getUrls() {
        if (this.g instanceof Spanned) {
            return (URLSpan[]) ((Spanned) this.g).getSpans(0, this.g.length(), URLSpan.class);
        }
        return new URLSpan[0];
    }

    @RemotableViewMethod
    public final void setHintTextColor(int i) {
        this.o = ColorStateList.valueOf(i);
        e();
    }

    public final void setHintTextColor(ColorStateList colorStateList) {
        this.o = colorStateList;
        e();
    }

    public final ColorStateList getHintTextColors() {
        return this.o;
    }

    public final int getCurrentHintTextColor() {
        return this.o != null ? this.q : this.n;
    }

    @RemotableViewMethod
    public final void setLinkTextColor(int i) {
        this.p = ColorStateList.valueOf(i);
        e();
    }

    public final void setLinkTextColor(ColorStateList colorStateList) {
        this.p = colorStateList;
        e();
    }

    public final ColorStateList getLinkTextColors() {
        return this.p;
    }

    public void setGravity(int i) {
        int i2;
        int i3 = 0;
        if ((i & 8388615) == 0) {
            i2 = 8388611 | i;
        } else {
            i2 = i;
        }
        if ((i2 & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) == 0) {
            i2 |= 48;
        }
        boolean z;
        if ((i2 & 8388615) != (this.aS & 8388615)) {
            z = true;
        } else {
            z = false;
        }
        if (i2 != this.aS) {
            invalidate();
            this.ah = null;
        }
        this.aS = i2;
        if (this.h != null && r1) {
            int width = this.h.getWidth();
            if (this.av != null) {
                i3 = this.av.getWidth();
            }
            a(width, i3, am, am, ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), true);
        }
    }

    public int getGravity() {
        return this.aS;
    }

    public int getPaintFlags() {
        return this.aC.getFlags();
    }

    @RemotableViewMethod
    public void setPaintFlags(int i) {
        if (this.aC.getFlags() != i) {
            this.aC.setFlags(i);
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setHorizontallyScrolling(boolean z) {
        if (this.aT != z) {
            this.aT = z;
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    public boolean getHorizontallyScrolling() {
        return this.aT;
    }

    @RemotableViewMethod
    public void setMinLines(int i) {
        this.bb = i;
        this.bc = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinHeight(int i) {
        this.bb = i;
        this.bc = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxLines(int i) {
        this.aZ = i;
        this.ba = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxHeight(int i) {
        this.aZ = i;
        this.ba = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setLines(int i) {
        this.bb = i;
        this.aZ = i;
        this.bc = 1;
        this.ba = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setHeight(int i) {
        this.bb = i;
        this.aZ = i;
        this.bc = 2;
        this.ba = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinEms(int i) {
        this.bh = i;
        this.bi = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinWidth(int i) {
        this.bh = i;
        this.bi = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxEms(int i) {
        this.bf = i;
        this.bg = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxWidth(int i) {
        this.bf = i;
        this.bg = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setEms(int i) {
        this.bh = i;
        this.bf = i;
        this.bi = 1;
        this.bg = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setWidth(int i) {
        this.bh = i;
        this.bf = i;
        this.bi = 2;
        this.bg = 2;
        requestLayout();
        invalidate();
    }

    private void e() {
        if (this.m != null) {
            int colorForState = this.m.getColorForState(getDrawableState(), 0);
            if (colorForState != this.n) {
                this.n = colorForState;
                colorForState = 1;
            } else {
                colorForState = 0;
            }
            if (this.p != null) {
                int colorForState2 = this.p.getColorForState(getDrawableState(), 0);
                if (colorForState2 != this.aC.linkColor) {
                    this.aC.linkColor = colorForState2;
                    colorForState = 1;
                }
            }
            if (this.o != null) {
                int colorForState3 = this.o.getColorForState(getDrawableState(), 0);
                if (colorForState3 != this.q && this.g.length() == 0) {
                    this.q = colorForState3;
                    colorForState = 1;
                }
            }
            if (colorForState != 0) {
                invalidate();
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.m != null && this.m.isStateful()) || ((this.o != null && this.o.isStateful()) || (this.p != null && this.p.isStateful()))) {
            e();
        }
        w wVar = this.D;
        if (wVar != null) {
            int[] drawableState = getDrawableState();
            if (wVar.b != null && wVar.b.isStateful()) {
                wVar.b.setState(drawableState);
            }
            if (wVar.c != null && wVar.c.isStateful()) {
                wVar.c.setState(drawableState);
            }
            if (wVar.d != null && wVar.d.isStateful()) {
                wVar.d.setState(drawableState);
            }
            if (wVar.e != null && wVar.e.isStateful()) {
                wVar.e.setState(drawableState);
            }
            if (wVar.f != null && wVar.f.isStateful()) {
                wVar.f.setState(drawableState);
            }
            if (wVar.g != null && wVar.g.isStateful()) {
                wVar.g.setState(drawableState);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        int selectionStart;
        int i;
        boolean z;
        int i2 = 0;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        boolean z2 = this.r;
        if (this.g != null) {
            selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            if (selectionStart >= 0 || selectionEnd >= 0) {
                i = selectionStart;
                selectionStart = selectionEnd;
                z = true;
            } else {
                int i3 = selectionEnd;
                z = z2;
                i = selectionStart;
                selectionStart = i3;
            }
        } else {
            selectionStart = 0;
            z = z2;
            i = 0;
        }
        if (!z) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.a = i;
        savedState.b = selectionStart;
        if (this.g instanceof Spanned) {
            Spannable spannableString = new SpannableString(this.g);
            q[] qVarArr = (q[]) spannableString.getSpans(0, spannableString.length(), q.class);
            int length = qVarArr.length;
            while (i2 < length) {
                spannableString.removeSpan(qVarArr[i2]);
                i2++;
            }
            a(spannableString);
            spannableString.removeSpan(this.P);
            savedState.c = spannableString;
        } else if (this.g != null) {
            savedState.c = this.g.toString();
        }
        if (isFocused() && i >= 0 && selectionStart >= 0) {
            savedState.d = true;
        }
        return savedState;
    }

    private static void a(Spannable spannable) {
        int i = 0;
        SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(0, spannable.length(), SuggestionSpan.class);
        while (i < suggestionSpanArr.length) {
            int flags = suggestionSpanArr[i].getFlags();
            if (!((flags & 1) == 0 || (flags & 2) == 0)) {
                spannable.removeSpan(suggestionSpanArr[i]);
            }
            i++;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.c != null) {
                setText(savedState.c);
            }
            if (savedState.a >= 0 && savedState.b >= 0 && (this.g instanceof Spannable)) {
                int length = this.g.length();
                if (savedState.a > length || savedState.b > length) {
                    String str = "";
                    if (savedState.c != null) {
                        str = "(restored) ";
                    }
                    Log.e("TextView", "Saved cursor position " + savedState.a + "/" + savedState.b + " out of range for " + str + "text " + this.g);
                    return;
                }
                Selection.setSelection((Spannable) this.g, savedState.a, savedState.b);
                if (savedState.d) {
                    this.s = true;
                    return;
                }
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @RemotableViewMethod
    public void setFreezesText(boolean z) {
        this.r = z;
    }

    public boolean getFreezesText() {
        return this.r;
    }

    public final void setEditableFactory(Factory factory) {
        this.w = factory;
        setText(this.g);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        this.x = factory;
        setText(this.g);
    }

    @RemotableViewMethod
    public final void setText(CharSequence charSequence) {
        a(charSequence, this.as);
    }

    @RemotableViewMethod
    public final void setTextKeepState(CharSequence charSequence) {
        int i = this.as;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        a(charSequence, i);
        if ((selectionStart >= 0 || selectionEnd >= 0) && (this.g instanceof Spannable)) {
            Selection.setSelection((Spannable) this.g, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
    }

    public void a(CharSequence charSequence, int i) {
        CharSequence charSequence2;
        int i2;
        boolean z;
        if (charSequence == null) {
            charSequence = "";
        }
        if (O()) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = a(charSequence);
        }
        if (!this.aD) {
            this.aC.setTextScaleX(IPictureView.DEFAULT_MIN_SCALE);
        }
        if ((charSequence2 instanceof Spanned) && ((Spanned) charSequence2).getSpanStart(TruncateAt.MARQUEE) >= 0) {
            if (ViewConfiguration.get(this.mContext).isFadingMarqueeEnabled()) {
                setHorizontalFadingEdgeEnabled(true);
                this.ak = 0;
            } else {
                setHorizontalFadingEdgeEnabled(false);
                this.ak = 1;
            }
            setEllipsize(TruncateAt.MARQUEE);
        }
        for (InputFilter filter : this.by) {
            CharSequence filter2 = filter.filter(charSequence2, 0, charSequence2.length(), bz, 0, 0);
            if (filter2 != null) {
                charSequence2 = filter2;
            }
        }
        if (this.g != null) {
            int length = this.g.length();
            b(this.g, 0, length, charSequence2.length());
            i2 = length;
        } else {
            b("", 0, 0, charSequence2.length());
            i2 = 0;
        }
        if (this.aB == null || this.aB.size() == 0) {
            z = false;
        } else {
            z = true;
        }
        if (i == p.c || this.aw != null || z) {
            charSequence2 = this.w.newEditable(charSequence2);
            a((Editable) charSequence2, this.by);
            InputMethodManager peekInstance = InputMethodManager.peekInstance();
            if (peekInstance != null) {
                peekInstance.restartInput(this);
            }
        } else if (i == p.b || this.ax != null) {
            charSequence2 = this.x.newSpannable(charSequence2);
        } else if (!(charSequence2 instanceof r)) {
            charSequence2 = TextUtils.stringOrSpannedString(charSequence2);
        }
        if (this.aU != 0) {
            if (i == p.c || (charSequence2 instanceof Spannable)) {
                filter2 = (Spannable) charSequence2;
            } else {
                filter2 = this.x.newSpannable(charSequence2);
            }
            if (Linkify.addLinks(filter2, this.aU)) {
                int i3 = i == p.c ? p.c : p.b;
                this.g = filter2;
                if (this.aV && !L()) {
                    setMovementMethod(f.b());
                }
                i = i3;
                charSequence2 = filter2;
            }
        }
        this.as = i;
        this.g = charSequence2;
        if (this.ay == null) {
            this.ar = charSequence2;
        } else {
            this.ar = this.ay.getTransformation(charSequence2, this);
        }
        int length2 = charSequence2.length();
        if ((charSequence2 instanceof Spannable) && !this.az) {
            Spannable spannable = (Spannable) charSequence2;
            for (Object removeSpan : (q[]) spannable.getSpans(0, spannable.length(), q.class)) {
                spannable.removeSpan(removeSpan);
            }
            if (this.aA == null) {
                this.aA = new q();
            }
            spannable.setSpan(this.aA, 0, length2, 6553618);
            if (this.aw != null) {
                spannable.setSpan(this.aw, 0, length2, 18);
            }
            if (this.ay != null) {
                spannable.setSpan(this.ay, 0, length2, 18);
            }
            if (this.ax != null) {
                this.ax.a((Spannable) charSequence2);
                this.G = false;
            }
        }
        if (this.h != null) {
            y();
        }
        a(charSequence2, 0, i2, length2);
        n();
        if (z) {
            a((Editable) charSequence2);
        }
        G();
        if (this.F != null) {
            this.F.a = null;
        }
    }

    @RemotableViewMethod
    public final void setText(int i) {
        setText(getContext().getResources().getText(i));
    }

    @RemotableViewMethod
    public final void setHint(CharSequence charSequence) {
        this.au = TextUtils.stringOrSpannedString(charSequence);
        if (this.h != null) {
            y();
        }
        if (this.g.length() == 0) {
            invalidate();
        }
    }

    @RemotableViewMethod
    public final void setHint(int i) {
        setHint(getContext().getResources().getText(i));
    }

    @CapturedViewProperty
    public CharSequence getHint() {
        return this.au;
    }

    private static boolean d(int i) {
        return (131087 & i) == 131073;
    }

    public void setInputType(int i) {
        boolean z = false;
        boolean e = e(this.at);
        boolean f = f(this.at);
        a(i, false);
        boolean e2 = e(i);
        boolean f2 = f(i);
        int i2;
        if (e2) {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            a(3, 0);
            i2 = 0;
        } else if (f2) {
            if (this.ay == PasswordTransformationMethod.getInstance()) {
                i2 = true;
            } else {
                i2 = 0;
            }
            a(3, 0);
        } else {
            if (e || f) {
                a(-1, -1);
                if (this.ay == PasswordTransformationMethod.getInstance()) {
                    e = true;
                }
            }
            i2 = 0;
        }
        if (d(i)) {
            f = false;
        } else {
            f = true;
        }
        if (!(this.bj == f && r0 == 0)) {
            if (!e2) {
                z = true;
            }
            a(f, z, true);
        }
        if (!O()) {
            this.g = a(this.g);
        }
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (peekInstance != null) {
            peekInstance.restartInput(this);
        }
    }

    private static boolean e(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    private static boolean f(int i) {
        return (i & 4095) == 145;
    }

    public void setRawInputType(int i) {
        this.at = i;
    }

    private void a(int i, boolean z) {
        KeyListener instance;
        boolean z2 = false;
        boolean z3 = true;
        int i2 = i & 15;
        if (i2 == 1) {
            Capitalize capitalize;
            if ((WXMediaMessage.THUMB_LENGTH_LIMIT & i) != 0) {
                z2 = true;
            }
            if ((i & SpdyProtocol.SLIGHTSSL_0_RTT_MODE) != 0) {
                capitalize = Capitalize.CHARACTERS;
            } else if ((i & SpdyProtocol.SLIGHTSSL_1_RTT_MODE) != 0) {
                capitalize = Capitalize.WORDS;
            } else if ((i & 16384) != 0) {
                capitalize = Capitalize.SENTENCES;
            } else {
                capitalize = Capitalize.NONE;
            }
            instance = TextKeyListener.getInstance(z2, capitalize);
        } else if (i2 == 2) {
            boolean z4 = (i & SpdyProtocol.SLIGHTSSL_0_RTT_MODE) != 0;
            if ((i & SpdyProtocol.SLIGHTSSL_1_RTT_MODE) == 0) {
                z3 = false;
            }
            instance = DigitsKeyListener.getInstance(z4, z3);
        } else if (i2 == 4) {
            switch (i & 4080) {
                case 16:
                    instance = DateKeyListener.getInstance();
                    break;
                case 32:
                    instance = TimeKeyListener.getInstance();
                    break;
                default:
                    instance = DateTimeKeyListener.getInstance();
                    break;
            }
        } else if (i2 == 3) {
            instance = DialerKeyListener.getInstance();
        } else {
            instance = TextKeyListener.getInstance();
        }
        setRawInputType(i);
        if (z) {
            this.aw = instance;
        } else {
            setKeyListenerOnly(instance);
        }
    }

    public int getInputType() {
        return this.at;
    }

    public void setImeOptions(int i) {
        if (this.e == null) {
            this.e = new ab();
        }
        this.e.a = i;
    }

    public int getImeOptions() {
        return this.e != null ? this.e.a : 0;
    }

    public CharSequence getImeActionLabel() {
        return this.e != null ? this.e.c : null;
    }

    public int getImeActionId() {
        return this.e != null ? this.e.d : 0;
    }

    public void setOnEditorActionListener(ai aiVar) {
        if (this.e == null) {
            this.e = new ab();
        }
        this.e.f = aiVar;
    }

    public void setPrivateImeOptions(String str) {
        if (this.e == null) {
            this.e = new ab();
        }
        this.e.b = str;
    }

    public String getPrivateImeOptions() {
        return this.e != null ? this.e.b : null;
    }

    public void setInputExtras(int i) throws XmlPullParserException, IOException {
        XmlResourceParser xml = getResources().getXml(i);
        if (this.e == null) {
            this.e = new ab();
        }
        this.e.e = new Bundle();
        getResources().parseBundleExtras(xml, this.e.e);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        if (inputFilterArr == null) {
            throw new IllegalArgumentException();
        }
        this.by = inputFilterArr;
        if (this.g instanceof Editable) {
            a((Editable) this.g, inputFilterArr);
        }
    }

    private void a(Editable editable, InputFilter[] inputFilterArr) {
        if (this.aw instanceof InputFilter) {
            Object obj = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, obj, 0, inputFilterArr.length);
            obj[inputFilterArr.length] = (InputFilter) this.aw;
            editable.setFilters(obj);
            return;
        }
        editable.setFilters(inputFilterArr);
    }

    public InputFilter[] getFilters() {
        return this.by;
    }

    private int a(boolean z) {
        Layout layout;
        int i = this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        Layout layout2 = this.h;
        if (z || this.g.length() != 0 || this.av == null) {
            layout = layout2;
        } else {
            layout = this.av;
        }
        if (i != 48) {
            int measuredHeight;
            if (layout == this.av) {
                measuredHeight = (getMeasuredHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
            } else {
                measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            }
            int height = layout.getHeight();
            if (height < measuredHeight) {
                if (i == 80) {
                    return measuredHeight - height;
                }
                return (measuredHeight - height) >> 1;
            }
        }
        return 0;
    }

    private void r() {
        int selectionEnd = getSelectionEnd();
        a(selectionEnd, selectionEnd, selectionEnd);
    }

    private void a(int i, int i2, int i3) {
        if (i >= 0 || i2 >= 0 || i3 >= 0) {
            int min = Math.min(Math.min(i, i2), i3);
            int max = Math.max(Math.max(i, i2), i3);
            if (this.h == null) {
                invalidate();
                return;
            }
            int lineForOffset = this.h.getLineForOffset(min);
            int lineTop = this.h.getLineTop(lineForOffset);
            if (lineForOffset > 0) {
                lineTop -= this.h.getLineDescent(lineForOffset - 1);
            }
            if (min != max) {
                lineForOffset = this.h.getLineForOffset(max);
            }
            min = this.h.getLineBottom(lineForOffset);
            int i4 = lineTop;
            lineForOffset = i4;
            for (lineTop = 0; lineTop < this.S; lineTop++) {
                Rect bounds = this.R[lineTop].getBounds();
                lineForOffset = Math.min(lineForOffset, bounds.top);
                min = Math.max(min, bounds.bottom);
            }
            max = getExtendedPaddingTop() + a(true);
            invalidate(getCompoundPaddingLeft() + this.mScrollX, lineForOffset + max, (getWidth() - getCompoundPaddingRight()) + this.mScrollX, min + max);
        }
    }

    private void s() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.B == 0) {
            viewTreeObserver.addOnPreDrawListener(this);
            this.B = 1;
        } else if (this.B == 2) {
            this.B = 1;
        }
    }

    public boolean onPreDraw() {
        if (this.B != 1) {
            return true;
        }
        boolean a;
        if (this.h == null) {
            w();
        }
        int selectionEnd;
        if (this.ax != null) {
            selectionEnd = getSelectionEnd();
            if (this.aK != null) {
                boolean z;
                an anVar = this.aK;
                if (anVar.a == null || !anVar.a.h) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    selectionEnd = getSelectionStart();
                }
            }
            if (selectionEnd < 0 && (this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) == 80) {
                selectionEnd = this.g.length();
            }
            if (selectionEnd >= 0) {
                a = a(selectionEnd);
            } else {
                a = false;
            }
        } else {
            int floor;
            if ((this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) == 80) {
                selectionEnd = this.h.getLineCount() - 1;
            } else {
                selectionEnd = 0;
            }
            Alignment paragraphAlignment = this.h.getParagraphAlignment(selectionEnd);
            int paragraphDirection = this.h.getParagraphDirection(selectionEnd);
            int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            int extendedPaddingTop = ((this.mBottom - this.mTop) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = this.h.getHeight();
            if (paragraphAlignment == Alignment.ALIGN_NORMAL) {
                paragraphAlignment = paragraphDirection == 1 ? Alignment.ALIGN_LEFT : Alignment.ALIGN_RIGHT;
            } else if (paragraphAlignment == Alignment.ALIGN_OPPOSITE) {
                paragraphAlignment = paragraphDirection == 1 ? Alignment.ALIGN_RIGHT : Alignment.ALIGN_LEFT;
            }
            if (paragraphAlignment == Alignment.ALIGN_CENTER) {
                floor = (int) FloatMath.floor(this.h.getLineLeft(selectionEnd));
                selectionEnd = (int) FloatMath.ceil(this.h.getLineRight(selectionEnd));
                if (selectionEnd - floor < compoundPaddingLeft) {
                    floor = ((selectionEnd + floor) / 2) - (compoundPaddingLeft / 2);
                } else if (paragraphDirection < 0) {
                    floor = selectionEnd - compoundPaddingLeft;
                }
            } else if (paragraphAlignment == Alignment.ALIGN_RIGHT) {
                floor = ((int) FloatMath.ceil(this.h.getLineRight(selectionEnd))) - compoundPaddingLeft;
            } else {
                floor = (int) FloatMath.floor(this.h.getLineLeft(selectionEnd));
            }
            if (height < extendedPaddingTop || (this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) != 80) {
                selectionEnd = 0;
            } else {
                selectionEnd = height - extendedPaddingTop;
            }
            if (floor == this.mScrollX && selectionEnd == this.mScrollY) {
                a = false;
            } else {
                scrollTo(floor, selectionEnd);
                a = true;
            }
        }
        if (this.ae) {
            j();
            this.ae = false;
        }
        this.B = 2;
        if (a) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t = false;
        if (this.E) {
            this.E = false;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.aJ != null) {
            viewTreeObserver.addOnTouchModeChangeListener(this.aJ);
        }
        if (this.aK != null) {
            viewTreeObserver.addOnTouchModeChangeListener(this.aK);
        }
        U();
        this.g.length();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.B != 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            this.B = 0;
        }
        if (this.aH != null) {
            this.aH.removeCallbacks(this.aH);
        }
        if (this.aJ != null) {
            this.aJ.d();
        }
        if (this.aK != null) {
            this.aK.d();
        }
        k();
        n();
        this.aj = false;
    }

    protected boolean isPaddingOffsetRequired() {
        return (this.y == 0.0f && this.D == null) ? false : true;
    }

    protected int getLeftPaddingOffset() {
        return (getCompoundPaddingLeft() - this.mPaddingLeft) + ((int) Math.min(0.0f, this.z - this.y));
    }

    protected int getTopPaddingOffset() {
        return (int) Math.min(0.0f, this.A - this.y);
    }

    protected int getBottomPaddingOffset() {
        return (int) Math.max(0.0f, this.A + this.y);
    }

    protected int getRightPaddingOffset() {
        return (-(getCompoundPaddingRight() - this.mPaddingRight)) + ((int) Math.max(0.0f, this.z + this.y));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.D == null) {
            return verifyDrawable;
        }
        return drawable == this.D.d || drawable == this.D.b || drawable == this.D.e || drawable == this.D.c || drawable == this.D.f || drawable == this.D.g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.D != null) {
            if (this.D.d != null) {
                this.D.d.jumpToCurrentState();
            }
            if (this.D.b != null) {
                this.D.b.jumpToCurrentState();
            }
            if (this.D.e != null) {
                this.D.e.jumpToCurrentState();
            }
            if (this.D.c != null) {
                this.D.c.jumpToCurrentState();
            }
            if (this.D.f != null) {
                this.D.f.jumpToCurrentState();
            }
            if (this.D.g != null) {
                this.D.g.jumpToCurrentState();
            }
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            w wVar = this.D;
            if (wVar != null) {
                int compoundPaddingTop;
                if (drawable == wVar.d) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    i += this.mPaddingLeft;
                    i2 += (((((this.mBottom - this.mTop) - getCompoundPaddingBottom()) - compoundPaddingTop) - wVar.p) / 2) + compoundPaddingTop;
                } else if (drawable == wVar.e) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    i += ((this.mRight - this.mLeft) - this.mPaddingRight) - wVar.k;
                    i2 += (((((this.mBottom - this.mTop) - getCompoundPaddingBottom()) - compoundPaddingTop) - wVar.q) / 2) + compoundPaddingTop;
                } else if (drawable == wVar.b) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    i += (((((this.mRight - this.mLeft) - getCompoundPaddingRight()) - compoundPaddingTop) - wVar.n) / 2) + compoundPaddingTop;
                    i2 += this.mPaddingTop;
                } else if (drawable == wVar.c) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    i += compoundPaddingTop + (((((this.mRight - this.mLeft) - getCompoundPaddingRight()) - compoundPaddingTop) - wVar.o) / 2);
                    i2 += ((this.mBottom - this.mTop) - this.mPaddingBottom) - wVar.i;
                }
            }
            invalidate(bounds.left + i, bounds.top + i2, i + bounds.right, i2 + bounds.bottom);
        }
    }

    protected boolean onSetAlpha(int i) {
        if (getBackground() == null) {
            this.l = i;
            w wVar = this.D;
            if (wVar != null) {
                if (wVar.d != null) {
                    wVar.d.mutate().setAlpha(i);
                }
                if (wVar.b != null) {
                    wVar.b.mutate().setAlpha(i);
                }
                if (wVar.e != null) {
                    wVar.e.mutate().setAlpha(i);
                }
                if (wVar.c != null) {
                    wVar.c.mutate().setAlpha(i);
                }
                if (wVar.f != null) {
                    wVar.f.mutate().setAlpha(i);
                }
                if (wVar.g != null) {
                    wVar.g.mutate().setAlpha(i);
                }
            }
            return true;
        }
        this.l = 255;
        return false;
    }

    public void setTextIsSelectable(boolean z) {
        if (this.aY != z) {
            this.aY = z;
            setFocusableInTouchMode(z);
            setFocusable(z);
            setClickable(z);
            setLongClickable(z);
            setMovementMethod(z ? a.b() : null);
            a(getText(), z ? p.b : p.a);
            G();
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState;
        if (this.bj) {
            onCreateDrawableState = super.onCreateDrawableState(i);
        } else {
            onCreateDrawableState = super.onCreateDrawableState(i + 1);
            mergeDrawableStates(onCreateDrawableState, bC);
        }
        if (!this.aY) {
            return onCreateDrawableState;
        }
        int length = onCreateDrawableState.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (onCreateDrawableState[i2] == 16842919) {
                Object obj = new int[(length - 1)];
                System.arraycopy(onCreateDrawableState, 0, obj, 0, i2);
                System.arraycopy(onCreateDrawableState, i2 + 1, obj, i2, (length - i2) - 1);
                return obj;
            }
        }
        return onCreateDrawableState;
    }

    public void setFocusableInTouchMode(boolean z) {
        super.setFocusableInTouchMode(z);
    }

    public void onDraw(Canvas canvas) {
        if (this.B == 2) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.B = 0;
        }
        if (this.l > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
            Layout layout;
            int a;
            Object obj;
            if (this.I && this.C == TruncateAt.MARQUEE) {
                this.I = false;
                E();
            }
            super.onDraw(canvas);
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingTop = getCompoundPaddingTop();
            int compoundPaddingRight = getCompoundPaddingRight();
            int compoundPaddingBottom = getCompoundPaddingBottom();
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            int i3 = this.mRight;
            int i4 = this.mLeft;
            int i5 = this.mBottom;
            int i6 = this.mTop;
            w wVar = this.D;
            if (wVar != null) {
                compoundPaddingBottom = ((i5 - i6) - compoundPaddingBottom) - compoundPaddingTop;
                int i7 = ((i3 - i4) - compoundPaddingRight) - compoundPaddingLeft;
                if (wVar.d != null) {
                    canvas.save();
                    canvas.translate((float) (this.mPaddingLeft + i), (float) ((i2 + compoundPaddingTop) + ((compoundPaddingBottom - wVar.p) / 2)));
                    wVar.d.draw(canvas);
                    canvas.restore();
                }
                if (wVar.e != null) {
                    canvas.save();
                    canvas.translate((float) ((((i + i3) - i4) - this.mPaddingRight) - wVar.k), (float) ((compoundPaddingTop + i2) + ((compoundPaddingBottom - wVar.q) / 2)));
                    wVar.e.draw(canvas);
                    canvas.restore();
                }
                if (wVar.b != null) {
                    canvas.save();
                    canvas.translate((float) ((i + compoundPaddingLeft) + ((i7 - wVar.n) / 2)), (float) (this.mPaddingTop + i2));
                    wVar.b.draw(canvas);
                    canvas.restore();
                }
                if (wVar.c != null) {
                    canvas.save();
                    canvas.translate((float) ((i + compoundPaddingLeft) + ((i7 - wVar.o) / 2)), (float) ((((i2 + i5) - i6) - this.mPaddingBottom) - wVar.i));
                    wVar.c.draw(canvas);
                    canvas.restore();
                }
            }
            compoundPaddingBottom = this.n;
            if (this.h == null) {
                w();
            }
            Layout layout2 = this.h;
            if (this.au == null || this.g.length() != 0) {
                layout = layout2;
                compoundPaddingTop = compoundPaddingBottom;
            } else {
                if (this.o != null) {
                    compoundPaddingTop = this.q;
                } else {
                    compoundPaddingTop = compoundPaddingBottom;
                }
                layout = this.av;
            }
            this.aC.setColor(compoundPaddingTop);
            if (this.l != 255) {
                this.aC.setAlpha((Color.alpha(compoundPaddingTop) * this.l) / 255);
            }
            this.aC.drawableState = getDrawableState();
            canvas.save();
            int extendedPaddingTop = getExtendedPaddingTop();
            float f = (float) (compoundPaddingLeft + i);
            float f2 = (float) (extendedPaddingTop + i2);
            float f3 = (float) (((i3 - i4) - compoundPaddingRight) + i);
            float extendedPaddingBottom = (float) (((i5 - i6) - getExtendedPaddingBottom()) + i2);
            if (this.y != 0.0f) {
                f += Math.min(0.0f, this.z - this.y);
                f3 += Math.max(0.0f, this.z + this.y);
                f2 += Math.min(0.0f, this.A - this.y);
                extendedPaddingBottom += Math.max(0.0f, this.A + this.y);
            }
            canvas.clipRect(f, f2, f3, extendedPaddingBottom);
            compoundPaddingTop = 0;
            if ((this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) != 48) {
                a = a(false);
                compoundPaddingTop = a(true);
                i = a;
            } else {
                i = 0;
            }
            canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + i));
            a = Gravity.getAbsoluteGravity(this.aS, getResolvedLayoutDirection());
            if (this.C == TruncateAt.MARQUEE && this.ak != 1) {
                if (!this.bj && getLineCount() == 1 && D() && (a & 7) != 3) {
                    canvas.translate(this.h.getLineRight(0) - ((float) (((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight())), 0.0f);
                }
                if (this.H != null) {
                    Object obj2;
                    if (this.H.a == (byte) 2) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        canvas.translate(-this.H.f, 0.0f);
                    }
                }
            }
            Path path = null;
            compoundPaddingRight = -1;
            if (this.ax == null || !(isFocused() || isPressed())) {
                obj = null;
                a = -1;
            } else {
                i2 = getSelectionStart();
                compoundPaddingLeft = getSelectionEnd();
                if (i2 >= 0) {
                    if (this.bm == null) {
                        this.bm = new Path();
                    }
                    if (i2 == compoundPaddingLeft) {
                        if (C() && (SystemClock.uptimeMillis() - this.aG) % 1000 < 500) {
                            Object obj3;
                            if (this.bn) {
                                this.bm.reset();
                                this.h.getCursorPath(i2, this.bm, this.g);
                                if (this.Q == 0) {
                                    this.S = 0;
                                } else {
                                    i3 = getSelectionStart();
                                    a = this.h.getLineForOffset(i3);
                                    i4 = this.h.getLineTop(a);
                                    compoundPaddingRight = this.h.getLineTop(a + 1);
                                    this.S = this.h.isLevelBoundary(i3) ? 2 : 1;
                                    if (this.S == 2) {
                                        a = (i4 + compoundPaddingRight) >> 1;
                                    } else {
                                        a = compoundPaddingRight;
                                    }
                                    a(0, i4, a, this.h.getPrimaryHorizontal(i3));
                                    if (this.S == 2) {
                                        a(1, a, compoundPaddingRight, this.h.getSecondaryHorizontal(i3));
                                    }
                                }
                                this.bn = false;
                            }
                            this.aE.setColor(compoundPaddingBottom);
                            if (this.l != 255) {
                                this.aE.setAlpha((Color.alpha(compoundPaddingBottom) * this.l) / 255);
                            }
                            this.aE.setStyle(Style.STROKE);
                            Path path2 = this.bm;
                            if (this.S > 0) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            compoundPaddingRight = compoundPaddingLeft;
                            path = path2;
                            a = i2;
                            obj = obj3;
                        }
                    } else if (L()) {
                        if (this.bn) {
                            this.bm.reset();
                            this.h.getSelectionPath(i2, compoundPaddingLeft, this.bm);
                            this.bn = false;
                        }
                        this.aE.setColor(this.aF);
                        if (this.l != 255) {
                            this.aE.setAlpha((this.l * Color.alpha(this.aF)) / 255);
                        }
                        this.aE.setStyle(Style.FILL);
                        compoundPaddingRight = compoundPaddingLeft;
                        path = this.bm;
                        int i8 = i2;
                        obj = null;
                        a = i8;
                    }
                }
                compoundPaddingRight = compoundPaddingLeft;
                a = i2;
                obj = null;
            }
            ac acVar = this.f;
            i5 = compoundPaddingTop - i;
            if (acVar != null && acVar.f == 0) {
                InputMethodManager peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null) {
                    if (peekInstance.isActive(this)) {
                        boolean z = false;
                        if (acVar.i || acVar.h) {
                            z = u();
                        }
                        if (!(z || path == null)) {
                            i = -1;
                            compoundPaddingLeft = -1;
                            if (this.g instanceof Spannable) {
                                Spannable spannable = (Spannable) this.g;
                                i = e.getComposingSpanStart(spannable);
                                compoundPaddingLeft = e.getComposingSpanEnd(spannable);
                            }
                            peekInstance.updateSelection(this, a, compoundPaddingRight, i, compoundPaddingLeft);
                        }
                    }
                    if (peekInstance.isWatchingCursor(this) && path != null) {
                        path.computeBounds(acVar.b, true);
                        float[] fArr = acVar.c;
                        acVar.c[1] = 0.0f;
                        fArr[0] = 0.0f;
                        canvas.getMatrix().mapPoints(acVar.c);
                        acVar.b.offset(acVar.c[0], acVar.c[1]);
                        acVar.b.offset(0.0f, (float) i5);
                        acVar.a.set((int) (((double) acVar.b.left) + 0.5d), (int) (((double) acVar.b.top) + 0.5d), (int) (((double) acVar.b.right) + 0.5d), (int) (((double) acVar.b.bottom) + 0.5d));
                        peekInstance.updateCursor(this, acVar.a.left, acVar.a.top, acVar.a.right, acVar.a.bottom);
                    }
                }
            }
            if (this.j != null) {
                this.j.a(canvas, i5);
            }
            if (obj != null) {
                a(canvas, i5);
                path = null;
            }
            layout.draw(canvas, path, this.aE, i5);
            if (this.H != null) {
                Object obj4;
                ah ahVar = this.H;
                if (ahVar.a != (byte) 2 || ahVar.f <= ahVar.c) {
                    obj4 = null;
                } else {
                    obj4 = 1;
                }
                if (obj4 != null) {
                    canvas.translate((float) ((int) this.H.d), 0.0f);
                    layout.draw(canvas, path, this.aE, i5);
                }
            }
            canvas.restore();
        }
    }

    private void a(int i, int i2, int i3, float f) {
        if (this.R[i] == null) {
            this.R[i] = this.mContext.getResources().getDrawable(this.Q);
        }
        if (this.b == null) {
            this.b = new Rect();
        }
        this.R[i].getPadding(this.b);
        int max = ((int) Math.max(0.5f, f - 0.5f)) - this.b.left;
        this.R[i].setBounds(max, i2 - this.b.top, this.R[i].getIntrinsicWidth() + max, this.b.bottom + i3);
    }

    private void a(Canvas canvas, int i) {
        int i2;
        int i3 = 0;
        if (i != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            canvas.translate(0.0f, (float) i);
        }
        while (i3 < this.S) {
            this.R[i3].draw(canvas);
            i3++;
        }
        if (i2 != 0) {
            canvas.translate(0.0f, (float) (-i));
        }
    }

    public void getFocusedRect(Rect rect) {
        if (this.h == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionStart = getSelectionStart();
        if (selectionStart < 0 || selectionStart >= selectionEnd) {
            selectionStart = this.h.getLineForOffset(selectionEnd);
            rect.top = this.h.getLineTop(selectionStart);
            rect.bottom = this.h.getLineBottom(selectionStart);
            rect.left = ((int) this.h.getPrimaryHorizontal(selectionEnd)) - 2;
            rect.right = rect.left + 4;
        } else {
            int lineForOffset = this.h.getLineForOffset(selectionStart);
            int lineForOffset2 = this.h.getLineForOffset(selectionEnd);
            rect.top = this.h.getLineTop(lineForOffset);
            rect.bottom = this.h.getLineBottom(lineForOffset2);
            if (lineForOffset == lineForOffset2) {
                rect.left = (int) this.h.getPrimaryHorizontal(selectionStart);
                rect.right = (int) this.h.getPrimaryHorizontal(selectionEnd);
            } else {
                if (this.bm == null) {
                    this.bm = new Path();
                }
                if (this.bn) {
                    this.bm.reset();
                    this.h.getSelectionPath(selectionStart, selectionEnd, this.bm);
                    this.bn = false;
                }
                synchronized (bo) {
                    this.bm.computeBounds(bo, true);
                    rect.left = ((int) bo.left) - 1;
                    rect.right = ((int) bo.right) + 1;
                }
            }
        }
        selectionStart = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) != 48) {
            selectionEnd += a(false);
        }
        rect.offset(selectionStart, selectionEnd);
    }

    public int getLineCount() {
        return this.h != null ? this.h.getLineCount() : 0;
    }

    public int getBaseline() {
        if (this.h == null) {
            return super.getBaseline();
        }
        int a;
        if ((this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) != 48) {
            a = a(true);
        } else {
            a = 0;
        }
        return (a + getExtendedPaddingTop()) + this.h.getLineBaseline(0);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aL != null) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        Q();
                        return true;
                    }
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent, null) == 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        KeyEvent changeAction = KeyEvent.changeAction(keyEvent, 0);
        int a = a(i, changeAction, keyEvent);
        if (a == 0) {
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        if (a == -1) {
            return true;
        }
        int i3 = i2 - 1;
        KeyEvent changeAction2 = KeyEvent.changeAction(keyEvent, 1);
        if (a == 1) {
            this.aw.onKeyUp(this, (Editable) this.g, i, changeAction2);
            while (true) {
                i3--;
                if (i3 <= 0) {
                    break;
                }
                this.aw.onKeyDown(this, (Editable) this.g, i, changeAction);
                this.aw.onKeyUp(this, (Editable) this.g, i, changeAction2);
            }
        } else if (a == 2) {
            a = i3;
            while (true) {
                i3 = a - 1;
                if (i3 <= 0) {
                    break;
                }
                this.ax.a(this, (Spannable) this.g, i, changeAction);
                a = i3;
            }
        }
        return true;
    }

    private boolean t() {
        if (this.aw == null) {
            return false;
        }
        if (this.bj) {
            return true;
        }
        if ((this.at & 15) != 1) {
            return false;
        }
        int i = this.at & 4080;
        if (i == 32 || i == 48) {
            return true;
        }
        return false;
    }

    @TargetApi(15)
    private int a(int i, KeyEvent keyEvent, KeyEvent keyEvent2) {
        boolean z = true;
        if (!isEnabled()) {
            return 0;
        }
        int i2;
        switch (i) {
            case 4:
                if (this.aL != null) {
                    Q();
                    return -1;
                }
                break;
            case 23:
                if (keyEvent.hasNoModifiers() && t()) {
                    return 0;
                }
            case 61:
                if (keyEvent.hasNoModifiers() || keyEvent.hasModifiers(1)) {
                    if (!(this.aw == null || this.bj || (this.at & 15) != 1)) {
                        i2 = this.at & 4080;
                        if (i2 == 262144 || i2 == 131072) {
                            i2 = 0;
                            if (i2 != 0) {
                                return 0;
                            }
                        }
                    }
                    boolean z2 = true;
                    if (i2 != 0) {
                        return 0;
                    }
                }
                break;
            case 66:
                if (keyEvent.hasNoModifiers()) {
                    if (this.e != null && this.e.f != null) {
                        this.e.f.a(0);
                        this.e.g = true;
                        return -1;
                    } else if ((keyEvent.getFlags() & 16) != 0 || t()) {
                        if (hasOnClickListeners()) {
                            return 0;
                        }
                        return -1;
                    }
                }
                break;
        }
        if (this.aw != null) {
            if (keyEvent2 != null) {
                try {
                    c();
                    if (this.aw.onKeyOther(this, (Editable) this.g, keyEvent2)) {
                        return -1;
                    }
                    f();
                    i2 = 0;
                } catch (AbstractMethodError e) {
                    z2 = true;
                    if (i2 != 0) {
                        c();
                        z2 = this.aw.onKeyDown(this, (Editable) this.g, i, keyEvent);
                        f();
                        if (z2) {
                            return 1;
                        }
                    }
                    if (keyEvent2 != null) {
                        try {
                            if (this.ax.a(this, (Spannable) this.g, keyEvent2)) {
                                return -1;
                            }
                            z = false;
                        } catch (AbstractMethodError e2) {
                        }
                    }
                    return 2;
                } finally {
                    f();
                }
            } else {
                z2 = true;
            }
            if (i2 != 0) {
                c();
                z2 = this.aw.onKeyDown(this, (Editable) this.g, i, keyEvent);
                f();
                if (z2) {
                    return 1;
                }
            }
        }
        if (!(this.ax == null || this.h == null)) {
            if (keyEvent2 != null) {
                if (this.ax.a(this, (Spannable) this.g, keyEvent2)) {
                    return -1;
                }
                z = false;
            }
            if (z && this.ax.a(this, (Spannable) this.g, i, keyEvent)) {
                return 2;
            }
        }
        return 0;
    }

    @TargetApi(15)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyUp(i, keyEvent);
        }
        InputMethodManager peekInstance;
        switch (i) {
            case 23:
                if (keyEvent.hasNoModifiers() && !hasOnClickListeners() && this.ax != null && (this.g instanceof Editable) && this.h != null && onCheckIsTextEditor()) {
                    peekInstance = InputMethodManager.peekInstance();
                    a(peekInstance);
                    if (peekInstance != null && this.ag) {
                        peekInstance.showSoftInput(this, 0);
                    }
                }
                return super.onKeyUp(i, keyEvent);
            case 66:
                if (keyEvent.hasNoModifiers()) {
                    if (this.e == null || this.e.f == null || !this.e.g) {
                        if (((keyEvent.getFlags() & 16) != 0 || t()) && !hasOnClickListeners()) {
                            View focusSearch = focusSearch(130);
                            if (focusSearch != null) {
                                if (focusSearch.requestFocus(130)) {
                                    super.onKeyUp(i, keyEvent);
                                    return true;
                                }
                                throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                            } else if ((keyEvent.getFlags() & 16) != 0) {
                                peekInstance = InputMethodManager.peekInstance();
                                if (peekInstance != null && peekInstance.isActive(this)) {
                                    peekInstance.hideSoftInputFromWindow(getWindowToken(), 0);
                                }
                            }
                        }
                        return super.onKeyUp(i, keyEvent);
                    }
                    this.e.g = false;
                    this.e.f.a(0);
                    return true;
                }
                break;
        }
        if (this.aw == null || !this.aw.onKeyUp(this, (Editable) this.g, i, keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onCheckIsTextEditor() {
        return this.at != 0;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (onCheckIsTextEditor() && isEnabled()) {
            if (this.f == null) {
                this.f = new ac();
            }
            editorInfo.inputType = this.at;
            if (this.e != null) {
                editorInfo.imeOptions = this.e.a;
                editorInfo.privateImeOptions = this.e.b;
                editorInfo.actionLabel = this.e.c;
                editorInfo.actionId = this.e.d;
                editorInfo.extras = this.e.e;
            } else {
                editorInfo.imeOptions = 0;
            }
            if (focusSearch(130) != null) {
                editorInfo.imeOptions |= 134217728;
            }
            if (focusSearch(33) != null) {
                editorInfo.imeOptions |= 67108864;
            }
            if ((editorInfo.imeOptions & 255) == 0) {
                if ((editorInfo.imeOptions & 134217728) != 0) {
                    editorInfo.imeOptions |= 5;
                } else {
                    editorInfo.imeOptions |= 6;
                }
                if (!t()) {
                    editorInfo.imeOptions |= UCCore.VERIFY_POLICY_QUICK;
                }
            }
            if (d(editorInfo.inputType)) {
                editorInfo.imeOptions |= UCCore.VERIFY_POLICY_QUICK;
            }
            editorInfo.hintText = this.au;
            if (this.g instanceof Editable) {
                InputConnection eVar = new e(this);
                editorInfo.initialSelStart = getSelectionStart();
                editorInfo.initialSelEnd = getSelectionEnd();
                editorInfo.initialCapsMode = eVar.getCursorCapsMode(this.at);
                return eVar;
            }
        }
        return null;
    }

    final boolean a(ExtractedTextRequest extractedTextRequest, int i, int i2, int i3, ExtractedText extractedText) {
        CharSequence charSequence = this.g;
        if (charSequence == null) {
            return false;
        }
        if (i != -2) {
            int i4;
            int i5;
            int length = charSequence.length();
            if (i < 0) {
                extractedText.partialEndOffset = -1;
                extractedText.partialStartOffset = -1;
                i4 = length;
                i5 = 0;
            } else {
                int i6;
                i4 = i2 + i3;
                if (charSequence instanceof Spanned) {
                    Spanned spanned = (Spanned) charSequence;
                    Object[] spans = spanned.getSpans(i, i4, ParcelableSpan.class);
                    int length2 = spans.length;
                    i6 = i;
                    while (length2 > 0) {
                        int i7 = length2 - 1;
                        length2 = spanned.getSpanStart(spans[i7]);
                        if (length2 >= i6) {
                            length2 = i6;
                        }
                        i6 = spanned.getSpanEnd(spans[i7]);
                        if (i6 <= i4) {
                            i6 = i4;
                        }
                        i4 = i6;
                        i6 = length2;
                        length2 = i7;
                    }
                } else {
                    i6 = i;
                }
                extractedText.partialStartOffset = i6;
                extractedText.partialEndOffset = i4 - i3;
                if (i6 > length) {
                    i5 = length;
                } else if (i6 < 0) {
                    i5 = 0;
                } else {
                    i5 = i6;
                }
                if (i4 > length) {
                    i4 = length;
                } else if (i4 < 0) {
                    i4 = 0;
                }
            }
            if ((extractedTextRequest.flags & 1) != 0) {
                extractedText.text = charSequence.subSequence(i5, i4);
            } else {
                extractedText.text = TextUtils.substring(charSequence, i5, i4);
            }
        } else {
            extractedText.partialStartOffset = 0;
            extractedText.partialEndOffset = 0;
            extractedText.text = "";
        }
        extractedText.flags = 0;
        if (g.a(this.g, 2048) != 0) {
            extractedText.flags |= 2;
        }
        if (this.bj) {
            extractedText.flags |= 1;
        }
        extractedText.startOffset = 0;
        extractedText.selectionStart = getSelectionStart();
        extractedText.selectionEnd = getSelectionEnd();
        return true;
    }

    private boolean u() {
        ac acVar = this.f;
        if (acVar != null) {
            boolean z = acVar.i;
            if (z || acVar.h) {
                acVar.i = false;
                acVar.h = false;
                ExtractedTextRequest extractedTextRequest = this.f.d;
                if (extractedTextRequest != null) {
                    InputMethodManager peekInstance = InputMethodManager.peekInstance();
                    if (peekInstance != null) {
                        if (acVar.j < 0 && !z) {
                            acVar.j = -2;
                        }
                        if (a(extractedTextRequest, acVar.j, acVar.k, acVar.l, acVar.e)) {
                            peekInstance.updateExtractedText(this, extractedTextRequest.token, this.f.e);
                            acVar.j = -1;
                            acVar.k = -1;
                            acVar.l = 0;
                            acVar.i = false;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void a(Spannable spannable, int i, int i2) {
        Object[] spans = spannable.getSpans(i, i2, ParcelableSpan.class);
        int length = spans.length;
        while (length > 0) {
            length--;
            spannable.removeSpan(spans[length]);
        }
    }

    public void setExtractedText(ExtractedText extractedText) {
        int length;
        int i;
        int i2 = 0;
        Spannable editableText = getEditableText();
        if (extractedText.text != null) {
            if (editableText == null) {
                a(extractedText.text, p.c);
            } else if (extractedText.partialStartOffset < 0) {
                a(editableText, 0, editableText.length());
                editableText.replace(0, editableText.length(), extractedText.text);
            } else {
                length = editableText.length();
                int i3 = extractedText.partialStartOffset;
                if (i3 > length) {
                    i3 = length;
                }
                i = extractedText.partialEndOffset;
                if (i <= length) {
                    length = i;
                }
                a(editableText, i3, length);
                editableText.replace(i3, length, extractedText.text);
            }
        }
        Spannable spannable = (Spannable) getText();
        i = spannable.length();
        length = extractedText.selectionStart;
        if (length < 0) {
            length = 0;
        } else if (length > i) {
            length = i;
        }
        int i4 = extractedText.selectionEnd;
        if (i4 >= 0) {
            if (i4 > i) {
                i2 = i;
            } else {
                i2 = i4;
            }
        }
        Selection.setSelection(spannable, length, i2);
        if ((extractedText.flags & 2) != 0) {
            g.d(spannable);
        } else {
            g.e(spannable);
        }
    }

    public void setExtracting(ExtractedTextRequest extractedTextRequest) {
        if (this.f != null) {
            this.f.d = extractedTextRequest;
        }
        k();
    }

    public static void b() {
    }

    public final void c() {
        this.aQ = true;
        ac acVar = this.f;
        if (acVar != null) {
            int i = acVar.f + 1;
            acVar.f = i;
            if (i == 1) {
                acVar.g = false;
                acVar.l = 0;
                if (acVar.i) {
                    acVar.j = 0;
                    acVar.k = this.g.length();
                    return;
                }
                acVar.j = -1;
                acVar.k = -1;
                acVar.i = false;
            }
        }
    }

    public final void f() {
        this.aQ = false;
        ac acVar = this.f;
        if (acVar != null) {
            int i = acVar.f - 1;
            acVar.f = i;
            if (i == 0) {
                a(acVar);
            }
        }
    }

    private void a(ac acVar) {
        if (acVar.i || acVar.h) {
            g();
            u();
        } else if (acVar.g) {
            r();
        }
    }

    final void g() {
        invalidate();
        int selectionStart = getSelectionStart();
        if (selectionStart >= 0 || (this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) == 80) {
            s();
        }
        if (selectionStart >= 0) {
            this.bn = true;
            J();
            a(selectionStart);
        }
        x();
    }

    public static boolean h() {
        return false;
    }

    private void v() {
        if ((this.h instanceof BoringLayout) && this.bu == null) {
            this.bu = (BoringLayout) this.h;
        }
        if ((this.av instanceof BoringLayout) && this.bv == null) {
            this.bv = (BoringLayout) this.av;
        }
        this.av = null;
        this.h = null;
        this.al = null;
        G();
    }

    private void w() {
        int i;
        int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        if (this.aT) {
            i = 1048576;
        } else {
            i = compoundPaddingLeft;
        }
        a(i, compoundPaddingLeft, am, am, compoundPaddingLeft, false);
    }

    private Alignment getLayoutAlignment() {
        if (this.ah == null) {
            Alignment alignment;
            switch (n.a[this.ai - 1]) {
                case 1:
                case 2:
                    switch (this.aS & 8388615) {
                        case 1:
                            alignment = Alignment.ALIGN_CENTER;
                            break;
                        case 3:
                            alignment = Alignment.ALIGN_LEFT;
                            break;
                        case 5:
                            alignment = Alignment.ALIGN_RIGHT;
                            break;
                        case 8388611:
                            alignment = Alignment.ALIGN_NORMAL;
                            break;
                        case 8388613:
                            alignment = Alignment.ALIGN_OPPOSITE;
                            break;
                        default:
                            alignment = Alignment.ALIGN_NORMAL;
                            break;
                    }
                case 3:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
                case 4:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                case 5:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                case 6:
                    alignment = Alignment.ALIGN_LEFT;
                    break;
                case 7:
                    alignment = Alignment.ALIGN_LEFT;
                    break;
                default:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
            }
            this.ah = alignment;
        }
        return this.ah;
    }

    private void a(int i, int i2, Metrics metrics, Metrics metrics2, int i3, boolean z) {
        int i4;
        Object obj;
        F();
        this.bd = this.aZ;
        this.be = this.ba;
        this.bn = true;
        if (i < 0) {
            i4 = 0;
        } else {
            i4 = i;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        Alignment layoutAlignment = getLayoutAlignment();
        boolean z2 = this.C != null && this.aw == null;
        if (this.C != TruncateAt.MARQUEE || this.ak == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        TruncateAt truncateAt = this.C;
        if (this.C == TruncateAt.MARQUEE && this.ak == 1) {
            truncateAt = TruncateAt.END_SMALL;
        }
        this.h = a(i4, metrics, i3, layoutAlignment, z2, truncateAt, truncateAt == this.C);
        if (obj != null) {
            this.al = a(i4, metrics, i3, layoutAlignment, z2, truncateAt == TruncateAt.MARQUEE ? TruncateAt.END : TruncateAt.MARQUEE, truncateAt != this.C);
        }
        Object obj2 = this.C != null ? 1 : null;
        this.av = null;
        if (this.au != null) {
            int i5;
            Metrics isBoring;
            if (obj2 != null) {
                i5 = i4;
            } else {
                i5 = i2;
            }
            if (metrics2 == am) {
                isBoring = BoringLayout.isBoring(this.au, this.aC, this.bw, this.bt);
                if (isBoring != null) {
                    this.bt = isBoring;
                }
            } else {
                isBoring = metrics2;
            }
            if (isBoring != null) {
                if (isBoring.width <= i5 && (obj2 == null || isBoring.width <= i3)) {
                    if (this.bv != null) {
                        this.av = this.bv.replaceOrMake(this.au, this.aC, i5, layoutAlignment, this.aW, this.aX, isBoring, this.bl);
                    } else {
                        this.av = BoringLayout.make(this.au, this.aC, i5, layoutAlignment, this.aW, this.aX, isBoring, this.bl);
                    }
                    this.bv = (BoringLayout) this.av;
                } else if (obj2 == null || isBoring.width > i5) {
                    if (obj2 != null) {
                        this.av = new StaticLayout(this.au, 0, this.au.length(), this.aC, i5, layoutAlignment, this.bw, this.aW, this.aX, this.bl, this.C, i3, this.ba == 1 ? this.aZ : Integer.MAX_VALUE);
                    } else {
                        this.av = new StaticLayout(this.au, this.aC, i5, layoutAlignment, this.bw, this.aW, this.aX, this.bl);
                    }
                } else if (this.bv != null) {
                    this.av = this.bv.replaceOrMake(this.au, this.aC, i5, layoutAlignment, this.aW, this.aX, isBoring, this.bl, this.C, i3);
                } else {
                    this.av = BoringLayout.make(this.au, this.aC, i5, layoutAlignment, this.aW, this.aX, isBoring, this.bl, this.C, i3);
                }
            } else if (obj2 != null) {
                this.av = new StaticLayout(this.au, 0, this.au.length(), this.aC, i5, layoutAlignment, this.bw, this.aW, this.aX, this.bl, this.C, i3, this.ba == 1 ? this.aZ : Integer.MAX_VALUE);
            } else {
                this.av = new StaticLayout(this.au, this.aC, i5, layoutAlignment, this.bw, this.aW, this.aX, this.bl);
            }
        }
        if (z) {
            s();
        }
        if (this.C == TruncateAt.MARQUEE) {
            if (!a((float) i3)) {
                int i6 = this.mLayoutParams.height;
                if (i6 == -2 || i6 == -1) {
                    this.I = true;
                } else {
                    E();
                }
            }
        }
        G();
    }

    private Layout a(int i, Metrics metrics, int i2, Alignment alignment, boolean z, TruncateAt truncateAt, boolean z2) {
        if (this.g instanceof Spannable) {
            TruncateAt truncateAt2;
            CharSequence charSequence = this.g;
            CharSequence charSequence2 = this.ar;
            TextPaint textPaint = this.aC;
            float f = this.aW;
            float f2 = this.aX;
            boolean z3 = this.bl;
            if (this.aw == null) {
                truncateAt2 = truncateAt;
            } else {
                truncateAt2 = null;
            }
            return new DynamicLayout(charSequence, charSequence2, textPaint, i, alignment, f, f2, z3, truncateAt2, i2);
        }
        Metrics isBoring;
        if (metrics == am) {
            isBoring = BoringLayout.isBoring(this.ar, this.aC, this.bw, this.bs);
            if (isBoring != null) {
                this.bs = isBoring;
            }
        } else {
            isBoring = metrics;
        }
        if (isBoring != null) {
            if (isBoring.width <= i && (truncateAt == null || isBoring.width <= i2)) {
                Layout make;
                if (!z2 || this.bu == null) {
                    make = BoringLayout.make(this.ar, this.aC, i, alignment, this.aW, this.aX, isBoring, this.bl);
                } else {
                    make = this.bu.replaceOrMake(this.ar, this.aC, i, alignment, this.aW, this.aX, isBoring, this.bl);
                }
                if (!z2) {
                    return make;
                }
                this.bu = (BoringLayout) make;
                return make;
            } else if (!z || isBoring.width > i) {
                if (z) {
                    return new StaticLayout(this.ar, 0, this.ar.length(), this.aC, i, alignment, this.bw, this.aW, this.aX, this.bl, truncateAt, i2, this.ba == 1 ? this.aZ : Integer.MAX_VALUE);
                }
                return new StaticLayout(this.ar, this.aC, i, alignment, this.bw, this.aW, this.aX, this.bl);
            } else if (!z2 || this.bu == null) {
                return BoringLayout.make(this.ar, this.aC, i, alignment, this.aW, this.aX, isBoring, this.bl, truncateAt, i2);
            } else {
                return this.bu.replaceOrMake(this.ar, this.aC, i, alignment, this.aW, this.aX, isBoring, this.bl, truncateAt, i2);
            }
        } else if (z) {
            return new StaticLayout(this.ar, 0, this.ar.length(), this.aC, i, alignment, this.bw, this.aW, this.aX, this.bl, truncateAt, i2, this.ba == 1 ? this.aZ : Integer.MAX_VALUE);
        } else {
            return new StaticLayout(this.ar, this.aC, i, alignment, this.bw, this.aW, this.aX, this.bl);
        }
    }

    private boolean a(float f) {
        if (isHardwareAccelerated() || f <= 0.0f || this.h == null || getLineCount() != 1 || this.aD || this.aC.getTextScaleX() != IPictureView.DEFAULT_MIN_SCALE) {
            return false;
        }
        float lineWidth = ((this.h.getLineWidth(0) + IPictureView.DEFAULT_MIN_SCALE) - f) / f;
        if (lineWidth <= 0.0f || lineWidth > 0.07f) {
            return false;
        }
        this.aC.setTextScaleX((IPictureView.DEFAULT_MIN_SCALE - lineWidth) - 0.005f);
        post(new j(this));
        return true;
    }

    private static int a(Layout layout) {
        int i = 0;
        int lineCount = layout.getLineCount();
        CharSequence text = layout.getText();
        float f = 0.0f;
        for (int i2 = 0; i2 < lineCount - 1; i2++) {
            if (text.charAt(layout.getLineEnd(i2) - 1) != '\n') {
                return -1;
            }
        }
        while (i < lineCount) {
            f = Math.max(f, layout.getLineWidth(i));
            i++;
        }
        return (int) FloatMath.ceil(f);
    }

    public void setIncludeFontPadding(boolean z) {
        if (this.bl != z) {
            this.bl = z;
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        Metrics metrics;
        int i3;
        Object obj;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        Metrics metrics2 = am;
        Metrics metrics3 = am;
        int i5 = -1;
        if (mode == UCCore.VERIFY_POLICY_QUICK) {
            metrics = metrics3;
            mode = size;
            metrics3 = metrics2;
            i3 = -1;
            obj = null;
        } else {
            Metrics isBoring;
            Object obj2;
            Metrics metrics4;
            if (this.h != null && this.C == null) {
                i5 = a(this.h);
            }
            if (i5 < 0) {
                isBoring = BoringLayout.isBoring(this.ar, this.aC, this.bw, this.bs);
                if (isBoring != null) {
                    this.bs = isBoring;
                    obj2 = null;
                } else {
                    obj2 = null;
                }
            } else {
                int i6 = 1;
                isBoring = metrics2;
            }
            if (isBoring == null || isBoring == am) {
                if (i5 < 0) {
                    i5 = (int) FloatMath.ceil(Layout.getDesiredWidth(this.ar, this.aC));
                }
                i4 = i5;
            } else {
                i4 = isBoring.width;
            }
            w wVar = this.D;
            if (wVar != null) {
                i4 = Math.max(Math.max(i4, wVar.n), wVar.o);
            }
            if (this.au != null) {
                i3 = -1;
                if (this.av != null && this.C == null) {
                    i3 = a(this.av);
                }
                if (i3 < 0) {
                    metrics3 = BoringLayout.isBoring(this.au, this.aC, this.bt);
                    if (metrics3 != null) {
                        this.bt = metrics3;
                    }
                }
                if (metrics3 != null && metrics3 != am) {
                    i3 = metrics3.width;
                } else if (i3 < 0) {
                    i3 = (int) FloatMath.ceil(Layout.getDesiredWidth(this.au, this.aC));
                }
                if (i3 > i4) {
                    metrics4 = metrics3;
                    i3 += getCompoundPaddingLeft() + getCompoundPaddingRight();
                    if (this.bg != 1) {
                        i3 = Math.min(i3, this.bf * getLineHeight());
                    } else {
                        i3 = Math.min(i3, this.bf);
                    }
                    if (this.bi != 1) {
                        i3 = Math.max(i3, this.bh * getLineHeight());
                    } else {
                        i3 = Math.max(i3, this.bh);
                    }
                    i3 = Math.max(i3, getSuggestedMinimumWidth());
                    if (mode != SectionHeader.SHT_LOUSER) {
                        metrics3 = isBoring;
                        mode = Math.min(size, i3);
                        i3 = i5;
                        obj = obj2;
                        metrics = metrics4;
                    } else {
                        metrics3 = isBoring;
                        mode = i3;
                        i3 = i5;
                        obj = obj2;
                        metrics = metrics4;
                    }
                }
            }
            i3 = i4;
            metrics4 = metrics3;
            i3 += getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.bg != 1) {
                i3 = Math.min(i3, this.bf);
            } else {
                i3 = Math.min(i3, this.bf * getLineHeight());
            }
            if (this.bi != 1) {
                i3 = Math.max(i3, this.bh);
            } else {
                i3 = Math.max(i3, this.bh * getLineHeight());
            }
            i3 = Math.max(i3, getSuggestedMinimumWidth());
            if (mode != SectionHeader.SHT_LOUSER) {
                metrics3 = isBoring;
                mode = i3;
                i3 = i5;
                obj = obj2;
                metrics = metrics4;
            } else {
                metrics3 = isBoring;
                mode = Math.min(size, i3);
                i3 = i5;
                obj = obj2;
                metrics = metrics4;
            }
        }
        int compoundPaddingLeft = (mode - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (this.aT) {
            i4 = 1048576;
        } else {
            i4 = compoundPaddingLeft;
        }
        int width = this.av == null ? i4 : this.av.getWidth();
        if (this.h != null) {
            Object obj3 = (this.h.getWidth() == i4 && width == i4 && this.h.getEllipsizedWidth() == (mode - getCompoundPaddingLeft()) - getCompoundPaddingRight()) ? null : 1;
            obj = (this.au != null || this.C != null || i4 <= this.h.getWidth() || (!(this.h instanceof BoringLayout) && (obj == null || i3 < 0 || i3 > i4))) ? null : 1;
            Object obj4 = (this.ba == this.be && this.aZ == this.bd) ? null : 1;
            if (!(obj3 == null && obj4 == null)) {
                if (obj4 == null && obj != null) {
                    this.h.increaseWidthTo(i4);
                }
            }
            if (mode2 != UCCore.VERIFY_POLICY_QUICK) {
                this.bk = -1;
                i5 = size2;
            } else {
                i5 = getDesiredHeight();
                this.bk = i5;
                if (mode2 == SectionHeader.SHT_LOUSER) {
                    i5 = Math.min(i5, size2);
                }
            }
            i4 = (i5 - getCompoundPaddingTop()) - getCompoundPaddingBottom();
            if (this.ba == 1 && this.h.getLineCount() > this.aZ) {
                i4 = Math.min(i4, this.h.getLineTop(this.aZ));
            }
            if (this.ax == null || this.h.getWidth() > compoundPaddingLeft || this.h.getHeight() > r1) {
                s();
            } else {
                scrollTo(0, 0);
            }
            setMeasuredDimension(mode, i5);
        }
        a(i4, i4, metrics3, metrics, (mode - getCompoundPaddingLeft()) - getCompoundPaddingRight(), false);
        if (mode2 != UCCore.VERIFY_POLICY_QUICK) {
            i5 = getDesiredHeight();
            this.bk = i5;
            if (mode2 == SectionHeader.SHT_LOUSER) {
                i5 = Math.min(i5, size2);
            }
        } else {
            this.bk = -1;
            i5 = size2;
        }
        i4 = (i5 - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        i4 = Math.min(i4, this.h.getLineTop(this.aZ));
        if (this.ax == null) {
        }
        s();
        setMeasuredDimension(mode, i5);
    }

    private int getDesiredHeight() {
        boolean z = true;
        int a = a(this.h, true);
        Layout layout = this.av;
        if (this.C == null) {
            z = false;
        }
        return Math.max(a, a(layout, z));
    }

    private int a(Layout layout, boolean z) {
        if (layout == null) {
            return 0;
        }
        int lineCount = layout.getLineCount();
        int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
        int lineTop = layout.getLineTop(lineCount);
        w wVar = this.D;
        if (wVar != null) {
            lineTop = Math.max(Math.max(lineTop, wVar.p), wVar.q);
        }
        lineTop += compoundPaddingBottom;
        if (this.ba != 1) {
            lineTop = Math.min(lineTop, this.aZ);
        } else if (z && lineCount > this.aZ) {
            lineTop = layout.getLineTop(this.aZ);
            if (wVar != null) {
                lineTop = Math.max(Math.max(lineTop, wVar.p), wVar.q);
            }
            lineTop += compoundPaddingBottom;
            lineCount = this.aZ;
        }
        if (this.bc != 1) {
            lineTop = Math.max(lineTop, this.bb);
        } else if (lineCount < this.bb) {
            lineTop += (this.bb - lineCount) * getLineHeight();
        }
        return Math.max(lineTop, getSuggestedMinimumHeight());
    }

    private void x() {
        Object obj = 1;
        Object obj2 = null;
        if (this.h != null) {
            if (this.mLayoutParams.width == -2) {
                invalidate();
                obj2 = 1;
            }
            if (this.mLayoutParams.height == -2) {
                if (getDesiredHeight() == getHeight()) {
                    obj = obj2;
                }
                obj2 = obj;
            } else if (this.mLayoutParams.height == -1 && this.bk >= 0 && getDesiredHeight() != this.bk) {
                int i = 1;
            }
        }
        if (obj2 != null) {
            requestLayout();
        }
    }

    private void y() {
        if ((this.mLayoutParams.width != -2 || (this.bg == this.bi && this.bf == this.bh)) && ((this.au == null || this.av != null) && ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight() > 0)) {
            int i;
            int height = this.h.getHeight();
            int width = this.h.getWidth();
            if (this.av == null) {
                i = 0;
            } else {
                i = this.av.getWidth();
            }
            a(width, i, am, am, ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), false);
            if (this.C != TruncateAt.MARQUEE) {
                if (this.mLayoutParams.height != -2 && this.mLayoutParams.height != -1) {
                    invalidate();
                    return;
                } else if (this.h.getHeight() == height && (this.av == null || this.av.getHeight() == height)) {
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
            return;
        }
        v();
        requestLayout();
        invalidate();
    }

    public final boolean a(int i) {
        if (this.h == null) {
            return false;
        }
        int i2;
        int i3;
        boolean z;
        int lineForOffset = this.h.getLineForOffset(i);
        int primaryHorizontal = (int) this.h.getPrimaryHorizontal(i);
        int lineTop = this.h.getLineTop(lineForOffset);
        int lineTop2 = this.h.getLineTop(lineForOffset + 1);
        int floor = (int) FloatMath.floor(this.h.getLineLeft(lineForOffset));
        int ceil = (int) FloatMath.ceil(this.h.getLineRight(lineForOffset));
        int height = this.h.getHeight();
        switch (n.b[this.h.getParagraphAlignment(lineForOffset).ordinal()]) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = -1;
                break;
            case 3:
                i2 = this.h.getParagraphDirection(lineForOffset);
                break;
            case 4:
                i2 = -this.h.getParagraphDirection(lineForOffset);
                break;
            default:
                i2 = 0;
                break;
        }
        int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int extendedPaddingTop = ((this.mBottom - this.mTop) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int i4 = (lineTop2 - lineTop) / 2;
        if (i4 > extendedPaddingTop / 4) {
            i3 = extendedPaddingTop / 4;
        } else {
            i3 = i4;
        }
        if (i4 > compoundPaddingLeft / 4) {
            i4 = compoundPaddingLeft / 4;
        }
        int i5 = this.mScrollX;
        int i6 = this.mScrollY;
        if (lineTop - i6 < i3) {
            i6 = lineTop - i3;
        }
        if (lineTop2 - i6 > extendedPaddingTop - i3) {
            i3 = lineTop2 - (extendedPaddingTop - i3);
        } else {
            i3 = i6;
        }
        if (height - i3 < extendedPaddingTop) {
            i3 = height - extendedPaddingTop;
        }
        if (0 - i3 > 0) {
            i6 = 0;
        } else {
            i6 = i3;
        }
        if (i2 != 0) {
            if (primaryHorizontal - i5 < i4) {
                i3 = primaryHorizontal - i4;
            } else {
                i3 = i5;
            }
            if (primaryHorizontal - i3 > compoundPaddingLeft - i4) {
                i3 = primaryHorizontal - (compoundPaddingLeft - i4);
            }
        } else {
            i3 = i5;
        }
        if (i2 < 0) {
            if (floor - i3 > 0) {
                i2 = floor;
            } else {
                i2 = i3;
            }
            if (ceil - i2 < compoundPaddingLeft) {
                i2 = ceil - compoundPaddingLeft;
            }
        } else if (i2 > 0) {
            if (ceil - i3 < compoundPaddingLeft) {
                i2 = ceil - compoundPaddingLeft;
            } else {
                i2 = i3;
            }
            if (floor - i2 > 0) {
                i2 = floor;
            }
        } else if (ceil - floor <= compoundPaddingLeft) {
            i2 = floor - ((compoundPaddingLeft - (ceil - floor)) / 2);
        } else if (primaryHorizontal > ceil - i4) {
            i2 = ceil - compoundPaddingLeft;
        } else if (primaryHorizontal < floor + i4) {
            i2 = floor;
        } else if (floor > i3) {
            i2 = floor;
        } else if (ceil < i3 + compoundPaddingLeft) {
            i2 = ceil - compoundPaddingLeft;
        } else {
            if (primaryHorizontal - i3 < i4) {
                i2 = primaryHorizontal - i4;
            } else {
                i2 = i3;
            }
            if (primaryHorizontal - i2 > compoundPaddingLeft - i4) {
                i2 = primaryHorizontal - (compoundPaddingLeft - i4);
            }
        }
        if (i2 == this.mScrollX && i6 == this.mScrollY) {
            z = false;
        } else {
            if (this.br == null) {
                scrollTo(i2, i6);
            } else {
                i2 -= this.mScrollX;
                i3 = i6 - this.mScrollY;
                if (AnimationUtils.currentAnimationTimeMillis() - this.bq > 250) {
                    this.br.startScroll(this.mScrollX, this.mScrollY, i2, i3);
                    awakenScrollBars(this.br.getDuration());
                    invalidate();
                } else {
                    if (!this.br.isFinished()) {
                        this.br.abortAnimation();
                    }
                    scrollBy(i2, i3);
                }
                this.bq = AnimationUtils.currentAnimationTimeMillis();
            }
            z = true;
        }
        if (!isFocused()) {
            return z;
        }
        if (this.b == null) {
            this.b = new Rect();
        }
        this.b.set(primaryHorizontal - 2, lineTop, primaryHorizontal + 2, lineTop2);
        Rect rect = this.b;
        i4 = z();
        rect.left += i4;
        rect.right = i4 + rect.right;
        i4 = A();
        rect.top += i4;
        rect.bottom = i4 + rect.bottom;
        if (lineForOffset == 0) {
            rect.top -= getExtendedPaddingTop();
        }
        if (lineForOffset == this.h.getLineCount() - 1) {
            rect.bottom += getExtendedPaddingBottom();
        }
        this.b.offset(this.mScrollX, this.mScrollY);
        if (requestRectangleOnScreen(this.b)) {
            return true;
        }
        return z;
    }

    public final boolean i() {
        if (!(this.g instanceof Spannable)) {
            return false;
        }
        int selectionStart = getSelectionStart();
        if (selectionStart != getSelectionEnd()) {
            return false;
        }
        int lineForOffset = this.h.getLineForOffset(selectionStart);
        int lineTop = this.h.getLineTop(lineForOffset);
        int lineTop2 = this.h.getLineTop(lineForOffset + 1);
        int extendedPaddingTop = ((this.mBottom - this.mTop) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int i = (lineTop2 - lineTop) / 2;
        if (i > extendedPaddingTop / 4) {
            i = extendedPaddingTop / 4;
        }
        int i2 = this.mScrollY;
        if (lineTop < i2 + i) {
            i = this.h.getLineForVertical((i + i2) + (lineTop2 - lineTop));
        } else if (lineTop2 > (extendedPaddingTop + i2) - i) {
            i = this.h.getLineForVertical(((extendedPaddingTop + i2) - i) - (lineTop2 - lineTop));
        } else {
            i = lineForOffset;
        }
        lineTop = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        lineTop2 = this.mScrollX;
        lineForOffset = this.h.getOffsetForHorizontal(i, (float) lineTop2);
        lineTop = this.h.getOffsetForHorizontal(i, (float) (lineTop + lineTop2));
        i = lineForOffset < lineTop ? lineForOffset : lineTop;
        if (lineForOffset <= lineTop) {
            lineForOffset = lineTop;
        }
        if (selectionStart < i) {
            lineForOffset = i;
        } else if (selectionStart <= lineForOffset) {
            lineForOffset = selectionStart;
        }
        if (lineForOffset == selectionStart) {
            return false;
        }
        Selection.setSelection((Spannable) this.g, lineForOffset);
        return true;
    }

    public void computeScroll() {
        if (this.br != null && this.br.computeScrollOffset()) {
            this.mScrollX = this.br.getCurrX();
            this.mScrollY = this.br.getCurrY();
            invalidateParentCaches();
            postInvalidate();
        }
    }

    private int z() {
        return getCompoundPaddingLeft() - this.mScrollX;
    }

    private int A() {
        int extendedPaddingTop = getExtendedPaddingTop() - this.mScrollY;
        if ((this.aS & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) != 48) {
            return extendedPaddingTop + a(false);
        }
        return extendedPaddingTop;
    }

    @ExportedProperty(category = "text")
    public int getSelectionStart() {
        return Selection.getSelectionStart(getText());
    }

    @ExportedProperty(category = "text")
    public int getSelectionEnd() {
        return Selection.getSelectionEnd(getText());
    }

    private boolean B() {
        int selectionStart = getSelectionStart();
        return selectionStart >= 0 && selectionStart != getSelectionEnd();
    }

    public void setAllCaps(boolean z) {
        if (z) {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } else {
            setTransformationMethod(null);
        }
    }

    @RemotableViewMethod
    public void setSingleLine(boolean z) {
        setInputTypeSingleLine(z);
        a(z, true, true);
    }

    private void setInputTypeSingleLine(boolean z) {
        if ((this.at & 15) != 1) {
            return;
        }
        if (z) {
            this.at &= -131073;
        } else {
            this.at |= 131072;
        }
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.bj = z;
        if (z) {
            setLines(1);
            setHorizontallyScrolling(true);
            if (z2) {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
                return;
            }
            return;
        }
        if (z3) {
            setMaxLines(Integer.MAX_VALUE);
        }
        setHorizontallyScrolling(false);
        if (z2) {
            setTransformationMethod(null);
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        if (this.C != truncateAt) {
            this.C = truncateAt;
            if (this.h != null) {
                v();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setMarqueeRepeatLimit(int i) {
        this.J = i;
    }

    @ExportedProperty
    public TruncateAt getEllipsize() {
        return this.C;
    }

    @RemotableViewMethod
    public void setSelectAllOnFocus(boolean z) {
        this.aR = z;
        if (z && !(this.g instanceof Spannable)) {
            a(this.g, p.b);
        }
    }

    @RemotableViewMethod
    public void setCursorVisible(boolean z) {
        if (this.aI != z) {
            this.aI = z;
            invalidate();
            J();
            G();
        }
    }

    private boolean C() {
        return this.aI && H();
    }

    private boolean D() {
        int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (compoundPaddingLeft <= 0) {
            return false;
        }
        if (this.h.getLineWidth(0) > ((float) compoundPaddingLeft) || (this.ak != 0 && this.al != null && this.al.getLineWidth(0) > ((float) compoundPaddingLeft))) {
            return true;
        }
        return false;
    }

    private void E() {
        if (this.aw != null || a((float) ((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()))) {
            return;
        }
        if (this.H != null && !this.H.b()) {
            return;
        }
        if ((isFocused() || isSelected()) && getLineCount() == 1 && D()) {
            if (this.ak == 1) {
                this.ak = 2;
                Layout layout = this.h;
                this.h = this.al;
                this.al = layout;
                setHorizontalFadingEdgeEnabled(true);
                requestLayout();
                invalidate();
            }
            if (this.H == null) {
                this.H = new ah(this);
            }
            this.H.a(this.J);
        }
    }

    private void F() {
        if (!(this.H == null || this.H.b())) {
            this.H.a();
        }
        if (this.ak == 2) {
            this.ak = 1;
            Layout layout = this.al;
            this.al = this.h;
            this.h = layout;
            setHorizontalFadingEdgeEnabled(false);
            requestLayout();
            invalidate();
        }
    }

    private void b(boolean z) {
        if (this.C != TruncateAt.MARQUEE) {
            return;
        }
        if (z) {
            E();
        } else {
            F();
        }
    }

    public final void a(TextWatcher textWatcher) {
        if (this.aB == null) {
            this.aB = new ArrayList();
        }
        this.aB.add(textWatcher);
    }

    private void b(CharSequence charSequence, int i, int i2, int i3) {
        if (this.aB != null) {
            ArrayList arrayList = this.aB;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((TextWatcher) arrayList.get(i4)).beforeTextChanged(charSequence, i, i2, i3);
            }
        }
        a(i, i + i2, SpellCheckSpan.class);
        a(i, i + i2, SuggestionSpan.class);
    }

    private <T> void a(int i, int i2, Class<T> cls) {
        if (this.g instanceof Editable) {
            Editable editable = (Editable) this.g;
            Object[] spans = editable.getSpans(i, i2, cls);
            int length = spans.length;
            int i3 = 0;
            while (i3 < length) {
                int spanStart = editable.getSpanStart(spans[i3]);
                if (editable.getSpanEnd(spans[i3]) != i && spanStart != i2) {
                    editable.removeSpan(spans[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    final void a(CharSequence charSequence, int i, int i2, int i3) {
        if (this.aB != null) {
            ArrayList arrayList = this.aB;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((TextWatcher) arrayList.get(i4)).onTextChanged(charSequence, i, i2, i3);
            }
        }
        S();
    }

    final void a(Editable editable) {
        if (this.aB != null) {
            ArrayList arrayList = this.aB;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((TextWatcher) arrayList.get(i)).afterTextChanged(editable);
            }
        }
    }

    final void a(Spanned spanned, Object obj, int i, int i2, int i3, int i4) {
        int i5;
        boolean z;
        int i6 = -1;
        ac acVar = this.f;
        if (obj == Selection.SELECTION_END) {
            this.bn = true;
            if (!isFocused()) {
                this.G = true;
            }
            if (i >= 0 || i2 >= 0) {
                a(Selection.getSelectionStart(spanned), i, i2);
                s();
                J();
            }
            i5 = i2;
            z = true;
        } else {
            z = false;
            i5 = -1;
        }
        if (obj == Selection.SELECTION_START) {
            this.bn = true;
            if (!isFocused()) {
                this.G = true;
            }
            if (i >= 0 || i2 >= 0) {
                a(Selection.getSelectionEnd(spanned), i, i2);
            }
            i6 = i2;
            z = true;
        }
        if (z && (spanned.getSpanFlags(obj) & 512) == 0) {
            if (i6 < 0) {
                Selection.getSelectionStart(spanned);
            }
            if (i5 < 0) {
                Selection.getSelectionEnd(spanned);
            }
            sendAccessibilityEvent(SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        }
        if ((obj instanceof UpdateAppearance) || (obj instanceof ParagraphStyle)) {
            if (acVar == null || acVar.f == 0) {
                invalidate();
                this.bn = true;
                x();
            } else {
                acVar.i = true;
            }
        }
        if (g.a(obj)) {
            this.bn = true;
            if (acVar != null && g.b(obj)) {
                acVar.h = true;
            }
            if (Selection.getSelectionStart(spanned) >= 0) {
                if (acVar == null || acVar.f == 0) {
                    r();
                } else {
                    acVar.g = true;
                }
            }
        }
        if ((obj instanceof ParcelableSpan) && acVar != null && acVar.d != null) {
            if (acVar.f != 0) {
                if (i >= 0) {
                    if (acVar.j > i) {
                        acVar.j = i;
                    }
                    if (acVar.j > i3) {
                        acVar.j = i3;
                    }
                }
                if (i2 >= 0) {
                    if (acVar.j > i2) {
                        acVar.j = i2;
                    }
                    if (acVar.j > i4) {
                        acVar.j = i4;
                        return;
                    }
                    return;
                }
                return;
            }
            acVar.i = true;
        }
    }

    public void dispatchFinishTemporaryDetach() {
        this.u = true;
        super.dispatchFinishTemporaryDetach();
        this.u = false;
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (!this.u) {
            this.t = true;
        }
        k();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (!this.u) {
            this.t = false;
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = 0;
        if (this.t) {
            super.onFocusChanged(z, i, rect);
            return;
        }
        this.aG = SystemClock.uptimeMillis();
        ac acVar = this.f;
        if (!(acVar == null || acVar.f == 0)) {
            acVar.f = 0;
            a(acVar);
        }
        if (z) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            boolean z2 = this.aR && selectionStart == 0 && selectionEnd == this.g.length();
            if (this.s && B() && !z2) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.ae = z2;
            if (!this.s || selectionStart < 0 || selectionEnd < 0) {
                int lastTapPosition = getLastTapPosition();
                if (lastTapPosition >= 0) {
                    Selection.setSelection((Spannable) this.g, lastTapPosition);
                }
                if (this.ax != null) {
                    this.ax.a(this, (Spannable) this.g, i);
                }
                if (this.G && selectionStart >= 0 && selectionEnd >= 0) {
                    Selection.setSelection((Spannable) this.g, selectionStart, selectionEnd);
                }
                if (this.aR) {
                    M();
                }
                this.d = true;
            }
            this.s = false;
            this.G = false;
            if (this.g instanceof Spannable) {
                g.a((Spannable) this.g);
            }
            J();
        } else {
            k();
            if (this.g instanceof Spannable) {
                Spannable spannable = (Spannable) this.g;
                SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(0, spannable.length(), SuggestionSpan.class);
                while (i2 < suggestionSpanArr.length) {
                    int flags = suggestionSpanArr[i2].getFlags();
                    if ((flags & 1) != 0 && (flags & 2) == 0) {
                        suggestionSpanArr[i2].setFlags(flags & -2);
                    }
                    i2++;
                }
            }
            if (this.aK != null) {
                this.aK.c();
            }
        }
        b(z);
        if (this.ay != null) {
            this.ay.onFocusChanged(this, this.g, z, i, rect);
        }
        super.onFocusChanged(z, i, rect);
    }

    private int getLastTapPosition() {
        if (this.aK != null) {
            int i = this.aK.b;
            if (i >= 0) {
                if (i <= this.g.length()) {
                    return i;
                }
                Log.e("TextView", "Invalid tap focus position (" + i + " vs " + this.g.length() + ")");
                return this.g.length();
            }
        }
        return -1;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            if (this.aH != null) {
                Object obj = this.aH;
                if (!obj.a) {
                    obj.removeCallbacks(obj);
                    obj.a = true;
                }
            }
            if (this.e != null) {
                this.e.g = false;
            }
            k();
            n();
            if (this.O != null) {
                this.O.a = false;
            }
        } else if (this.aH != null) {
            this.aH.a = false;
            J();
        }
        b(z);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            k();
            n();
        }
    }

    public void setSelected(boolean z) {
        boolean isSelected = isSelected();
        super.setSelected(z);
        if (z != isSelected && this.C == TruncateAt.MARQUEE) {
            if (z) {
                E();
            } else {
                F();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int actionMasked = motionEvent.getActionMasked();
        if (this.aN) {
            an selectionController = getSelectionController();
            int a;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    a = selectionController.g.a(x, y);
                    selectionController.c = a;
                    selectionController.b = a;
                    if (SystemClock.uptimeMillis() - selectionController.d <= ((long) ViewConfiguration.getDoubleTapTimeout()) && selectionController.g.b(x, y)) {
                        float f = x - selectionController.e;
                        float f2 = y - selectionController.f;
                        if ((f * f) + (f2 * f2) < ((float) (selectionController.g.ad * 4))) {
                            if (selectionController.g.j() && selectionController.g.ap != null) {
                                selectionController.g.ap.a(u.DOUBLE_CLICK_SELECTED);
                            }
                            selectionController.g.v = true;
                        }
                    }
                    selectionController.e = x;
                    selectionController.f = y;
                    break;
                case 1:
                    selectionController.d = SystemClock.uptimeMillis();
                    break;
                case 5:
                case 6:
                    if (selectionController.g.mContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct")) {
                        int pointerCount = motionEvent.getPointerCount();
                        for (int i = 0; i < pointerCount; i++) {
                            a = selectionController.g.a(motionEvent.getX(i), motionEvent.getY(i));
                            if (a < selectionController.b) {
                                selectionController.b = a;
                            }
                            if (a > selectionController.c) {
                                selectionController.c = a;
                            }
                        }
                        break;
                    }
                    break;
            }
        }
        if (actionMasked == 0) {
            this.ab = motionEvent.getX();
            this.ac = motionEvent.getY();
            this.d = false;
            this.c = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.v && actionMasked == 1) {
            this.v = false;
            return onTouchEvent;
        }
        boolean z2 = actionMasked == 1 && !this.c && isFocused();
        if ((this.ax != null || onCheckIsTextEditor()) && isEnabled() && (this.g instanceof Spannable) && this.h != null) {
            boolean a2;
            boolean z3;
            InputMethodManager peekInstance;
            SuggestionSpan[] suggestionSpanArr;
            if (this.ax != null) {
                a2 = this.ax.a(this, (Spannable) this.g, motionEvent) | 0;
            } else {
                a2 = false;
            }
            if (z2 && this.aV && this.aU != 0 && this.aY) {
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) this.g).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(this);
                    z3 = true;
                    if (z2 && (H() || this.aY)) {
                        peekInstance = InputMethodManager.peekInstance();
                        a(peekInstance);
                        if (!(this.aY || !this.ag || peekInstance == null)) {
                            peekInstance.showSoftInput(this, 0);
                        }
                        z3 = this.aR && this.d;
                        k();
                        if (this.g.length() != 0) {
                            if (this.ap != null) {
                                this.ap.a(u.EMPTY_CLICK);
                            }
                        } else if (!(z3 || P())) {
                            suggestionSpanArr = (SuggestionSpan[]) ((Spannable) this.g).getSpans(getSelectionStart(), getSelectionEnd(), SuggestionSpan.class);
                            actionMasked = 0;
                            while (actionMasked < suggestionSpanArr.length) {
                                if ((suggestionSpanArr[actionMasked].getFlags() & 1) == 0) {
                                    z = true;
                                    if (!z) {
                                        if (this.O == null) {
                                            this.O = new at(this);
                                        }
                                        k();
                                        this.O.d();
                                    } else if (this.i) {
                                        getInsertionController().a();
                                        if (this.ap != null) {
                                            this.ap.a(u.FILL_CLICK);
                                        }
                                    }
                                } else {
                                    actionMasked++;
                                }
                            }
                            if (!z) {
                                if (this.O == null) {
                                    this.O = new at(this);
                                }
                                k();
                                this.O.d();
                            } else if (this.i) {
                                getInsertionController().a();
                                if (this.ap != null) {
                                    this.ap.a(u.FILL_CLICK);
                                }
                            }
                        }
                        z3 = true;
                    }
                    if (z3) {
                        return true;
                    }
                }
            }
            z3 = a2;
            peekInstance = InputMethodManager.peekInstance();
            a(peekInstance);
            peekInstance.showSoftInput(this, 0);
            if (!this.aR) {
            }
            k();
            if (this.g.length() != 0) {
                suggestionSpanArr = (SuggestionSpan[]) ((Spannable) this.g).getSpans(getSelectionStart(), getSelectionEnd(), SuggestionSpan.class);
                actionMasked = 0;
                while (actionMasked < suggestionSpanArr.length) {
                    if ((suggestionSpanArr[actionMasked].getFlags() & 1) == 0) {
                        actionMasked++;
                    } else {
                        z = true;
                        if (!z) {
                            if (this.O == null) {
                                this.O = new at(this);
                            }
                            k();
                            this.O.d();
                        } else if (this.i) {
                            getInsertionController().a();
                            if (this.ap != null) {
                                this.ap.a(u.FILL_CLICK);
                            }
                        }
                    }
                }
                if (!z) {
                    if (this.O == null) {
                        this.O = new at(this);
                    }
                    k();
                    this.O.d();
                } else if (this.i) {
                    getInsertionController().a();
                    if (this.ap != null) {
                        this.ap.a(u.FILL_CLICK);
                    }
                }
            } else if (this.ap != null) {
                this.ap.a(u.EMPTY_CLICK);
            }
            z3 = true;
            if (z3) {
                return true;
            }
        }
        return onTouchEvent;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.ax == null || !(this.g instanceof Spannable) || this.h == null)) {
            try {
                if (this.ax.a(this, motionEvent)) {
                    return true;
                }
            } catch (AbstractMethodError e) {
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    private void G() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        LayoutParams layoutParams = getRootView().getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
            z = layoutParams2.type < 1000 || layoutParams2.type > 1999;
            z2 = z;
        } else {
            z2 = false;
        }
        if (z2 && C() && this.h != null) {
            z = true;
        } else {
            z = false;
        }
        this.i = z;
        if (!(z2 && L() && this.h != null)) {
            z3 = false;
        }
        this.aN = z3;
        if (!this.i) {
            R();
            if (this.aJ != null) {
                this.aJ.d();
                this.aJ = null;
            }
        }
        if (!this.aN) {
            Q();
            if (this.aK != null) {
                this.aK.d();
                this.aK = null;
            }
        }
    }

    private boolean H() {
        return (this.g instanceof Editable) && onCheckIsTextEditor() && isEnabled();
    }

    public void cancelLongPress() {
        super.cancelLongPress();
        this.c = true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    public void setScroller(Scroller scroller) {
        this.br = scroller;
    }

    private boolean I() {
        if (!isFocused()) {
            return false;
        }
        int selectionStart = getSelectionStart();
        if (selectionStart < 0) {
            return false;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0 || selectionStart != selectionEnd) {
            return false;
        }
        return true;
    }

    private void J() {
        if (C()) {
            if (I()) {
                this.aG = SystemClock.uptimeMillis();
                if (this.aH == null) {
                    this.aH = new o(this);
                }
                this.aH.removeCallbacks(this.aH);
                this.aH.postAtTime(this.aH, this.aG + 500);
            }
        } else if (this.aH != null) {
            this.aH.removeCallbacks(this.aH);
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int i = 1;
        if (this.l <= UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
            return 0.0f;
        }
        if (this.C == TruncateAt.MARQUEE && this.ak != 1) {
            if (this.H != null && !this.H.b()) {
                ah ahVar = this.H;
                if (ahVar.f > ahVar.e) {
                    i = 0;
                }
                if (i != 0) {
                    return ahVar.f / ((float) getHorizontalFadingEdgeLength());
                }
                return 0.0f;
            } else if (getLineCount() == 1) {
                switch (Gravity.getAbsoluteGravity(this.aS, getResolvedLayoutDirection()) & 7) {
                    case 1:
                    case 3:
                        return 0.0f;
                    case 5:
                        return ((((this.h.getLineRight(0) - ((float) (this.mRight - this.mLeft))) - ((float) getCompoundPaddingLeft())) - ((float) getCompoundPaddingRight())) - this.h.getLineLeft(0)) / ((float) getHorizontalFadingEdgeLength());
                }
            }
        }
        return super.getLeftFadingEdgeStrength();
    }

    protected float getRightFadingEdgeStrength() {
        if (this.l <= 117) {
            return 0.0f;
        }
        if (this.C == TruncateAt.MARQUEE && this.ak != 1) {
            if (this.H != null && !this.H.b()) {
                ah ahVar = this.H;
                return (ahVar.b - ahVar.f) / ((float) getHorizontalFadingEdgeLength());
            } else if (getLineCount() == 1) {
                switch (Gravity.getAbsoluteGravity(this.aS, getResolvedLayoutDirection()) & 7) {
                    case 1:
                    case 7:
                        return (this.h.getLineWidth(0) - ((float) (((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight()))) / ((float) getHorizontalFadingEdgeLength());
                    case 3:
                        return (this.h.getLineWidth(0) - ((float) (((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight()))) / ((float) getHorizontalFadingEdgeLength());
                    case 5:
                        return 0.0f;
                }
            }
        }
        return super.getRightFadingEdgeStrength();
    }

    protected int computeHorizontalScrollRange() {
        if (this.h != null) {
            return (this.bj && (this.aS & 7) == 3) ? (int) this.h.getLineWidth(0) : this.h.getWidth();
        } else {
            return super.computeHorizontalScrollRange();
        }
    }

    protected int computeVerticalScrollRange() {
        if (this.h != null) {
            return this.h.getHeight();
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    public void findViewsWithText(ArrayList<View> arrayList, CharSequence charSequence, int i) {
        super.findViewsWithText(arrayList, charSequence, i);
        if (!arrayList.contains(this) && (i & 1) != 0 && !TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.g)) {
            if (this.g.toString().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                arrayList.add(this);
            }
        }
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Object obj = 1;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState() & -28673)) {
            switch (i) {
                case 29:
                    if (K()) {
                        return b(16908319);
                    }
                    break;
                case 31:
                    if ((this.ay instanceof PasswordTransformationMethod) || this.g.length() <= 0 || !B()) {
                        obj = null;
                    }
                    if (obj != null) {
                        return b(16908321);
                    }
                    break;
                case 50:
                    Object obj2;
                    if (!(this.g instanceof Editable) || this.aw == null || getSelectionStart() < 0 || getSelectionEnd() < 0 || !((ClipboardManager) getContext().getSystemService("clipboard")).hasPrimaryClip()) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return b(16908322);
                    }
                    break;
                case 52:
                    if ((this.ay instanceof PasswordTransformationMethod) || this.g.length() <= 0 || !B() || !(this.g instanceof Editable) || this.aw == null) {
                        obj = null;
                    }
                    if (obj != null) {
                        return b(16908320);
                    }
                    break;
            }
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    private boolean L() {
        if (this.ax == null || !this.ax.a()) {
            return false;
        }
        if (H() || (this.aY && (this.g instanceof Spannable) && isEnabled())) {
            return true;
        }
        return false;
    }

    private static long c(int i, int i2) {
        return (((long) i) << 32) | ((long) i2);
    }

    private boolean M() {
        int length = this.g.length();
        Selection.setSelection((Spannable) this.g, 0, length);
        return length > 0;
    }

    private boolean N() {
        if (!K()) {
            return false;
        }
        if (this.ay instanceof PasswordTransformationMethod) {
            return M();
        }
        int i = this.at & 15;
        int i2 = this.at & 4080;
        if (i == 2 || i == 3 || i == 4 || i2 == 16 || i2 == 32 || i2 == SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY || i2 == 176) {
            return M();
        }
        long lastTouchOffsets = getLastTouchOffsets();
        int i3 = (int) (lastTouchOffsets >>> 32);
        int i4 = (int) (lastTouchOffsets & 4294967295L);
        if (i3 < 0 || i3 > this.g.length()) {
            return false;
        }
        if (i4 < 0 || i4 > this.g.length()) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) ((Spanned) this.g).getSpans(i3, i4, URLSpan.class);
        if (uRLSpanArr.length > 0) {
            Object obj = uRLSpanArr[0];
            i2 = ((Spanned) this.g).getSpanStart(obj);
            i = ((Spanned) this.g).getSpanEnd(obj);
            i3 = i2;
            i2 = i;
        } else {
            WordIterator wordIterator = getWordIterator();
            wordIterator.setCharSequence(this.g, i3, i4);
            i2 = wordIterator.getBeginning(i3);
            if (i2 == -1) {
                return false;
            }
            i = wordIterator.getEnd(i4);
            if (i == -1) {
                return false;
            }
            if (i2 == i) {
                i = this.g.length();
                if (i2 + 1 < i && Character.isSurrogatePair(this.g.charAt(i2), this.g.charAt(i2 + 1))) {
                    lastTouchOffsets = c(i2, i2 + 2);
                } else if (i2 < i) {
                    lastTouchOffsets = c(i2, i2 + 1);
                } else {
                    if (i2 - 2 >= 0) {
                        if (Character.isSurrogatePair(this.g.charAt(i2 - 2), this.g.charAt(i2 - 1))) {
                            lastTouchOffsets = c(i2 - 2, i2);
                        }
                    }
                    if (i2 - 1 >= 0) {
                        lastTouchOffsets = c(i2 - 1, i2);
                    } else {
                        lastTouchOffsets = c(i2, i2);
                    }
                }
                i3 = (int) (lastTouchOffsets >>> 32);
                i2 = (int) (lastTouchOffsets & 4294967295L);
            } else {
                i3 = i2;
                i2 = i;
            }
        }
        Selection.setSelection((Spannable) this.g, i3, i2);
        if (i2 > i3) {
            return true;
        }
        return false;
    }

    public Locale getTextServicesLocale() {
        Locale locale = Locale.getDefault();
        SpellCheckerSubtype currentSpellCheckerSubtype = ((TextServicesManager) this.mContext.getSystemService("textservices")).getCurrentSpellCheckerSubtype(true);
        if (currentSpellCheckerSubtype != null) {
            return new Locale(currentSpellCheckerSubtype.getLocale());
        }
        return locale;
    }

    public WordIterator getWordIterator() {
        if (this.af == null) {
            this.af = new WordIterator(getTextServicesLocale());
        }
        return this.af;
    }

    private long getLastTouchOffsets() {
        an selectionController = getSelectionController();
        return c(selectionController.b, selectionController.c);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!(this.ay instanceof PasswordTransformationMethod)) {
            CharSequence textForAccessibility = getTextForAccessibility();
            if (!TextUtils.isEmpty(textForAccessibility)) {
                accessibilityEvent.getText().add(textForAccessibility);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setPassword(this.ay instanceof PasswordTransformationMethod);
        if (accessibilityEvent.getEventType() == SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(this.g));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(this.g));
            accessibilityEvent.setItemCount(this.g.length());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        boolean z = this.ay instanceof PasswordTransformationMethod;
        if (!z) {
            accessibilityNodeInfo.setText(getTextForAccessibility());
        }
        accessibilityNodeInfo.setPassword(z);
    }

    public void sendAccessibilityEvent(int i) {
        if (i != SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
            super.sendAccessibilityEvent(i);
        }
    }

    private CharSequence getTextForAccessibility() {
        CharSequence text = getText();
        if (TextUtils.isEmpty(text)) {
            return getHint();
        }
        return text;
    }

    public final boolean b(int i) {
        int max;
        int i2 = 0;
        int length = this.g.length();
        if (isFocused()) {
            int selectionStart = getSelectionStart();
            length = getSelectionEnd();
            max = Math.max(0, Math.min(selectionStart, length));
            length = Math.max(0, Math.max(selectionStart, length));
        } else {
            max = 0;
        }
        switch (i) {
            case 16908319:
                M();
                return true;
            case 16908320:
                setPrimaryClip(ClipData.newPlainText(null, d(max, length)));
                b(max, length);
                Q();
                return true;
            case 16908321:
                setPrimaryClip(ClipData.newPlainText(null, d(max, length)));
                Q();
                return true;
            case 16908322:
                ClipData primaryClip = ((ClipboardManager) getContext().getSystemService("clipboard")).getPrimaryClip();
                if (primaryClip == null) {
                    return true;
                }
                int i3 = max;
                max = length;
                length = 0;
                while (i2 < primaryClip.getItemCount()) {
                    CharSequence coerceToText = primaryClip.getItemAt(i2).coerceToText(getContext());
                    if (coerceToText != null) {
                        if (length == 0) {
                            long b = b(i3, max, coerceToText);
                            i3 = (int) (b >>> 32);
                            max = (int) (b & 4294967295L);
                            Selection.setSelection((Spannable) this.g, max);
                            ((Editable) this.g).replace(i3, max, coerceToText);
                            length = true;
                        } else {
                            ((Editable) this.g).insert(getSelectionEnd(), "\n");
                            ((Editable) this.g).insert(getSelectionEnd(), coerceToText);
                        }
                    }
                    i2++;
                }
                Q();
                bB = 0;
                return true;
            default:
                return false;
        }
    }

    private CharSequence d(int i, int i2) {
        return a(this.ar.subSequence(i, i2));
    }

    private long b(int i, int i2, CharSequence charSequence) {
        if (charSequence.length() > 0) {
            char charAt;
            char charAt2;
            if (i > 0) {
                charAt = this.ar.charAt(i - 1);
                charAt2 = charSequence.charAt(0);
                int length;
                if (Character.isSpaceChar(charAt) && Character.isSpaceChar(charAt2)) {
                    length = this.g.length();
                    b(i - 1, i);
                    length = this.g.length() - length;
                    i += length;
                    i2 += length;
                } else if (!(Character.isSpaceChar(charAt) || charAt == '\n' || Character.isSpaceChar(charAt2) || charAt2 == '\n')) {
                    length = this.g.length();
                    a(i, i, (CharSequence) " ");
                    length = this.g.length() - length;
                    i += length;
                    i2 += length;
                }
            }
            if (i2 < this.g.length()) {
                charAt = charSequence.charAt(charSequence.length() - 1);
                charAt2 = this.ar.charAt(i2);
                if (Character.isSpaceChar(charAt) && Character.isSpaceChar(charAt2)) {
                    b(i2, i2 + 1);
                } else if (!(Character.isSpaceChar(charAt) || charAt == '\n' || Character.isSpaceChar(charAt2) || charAt2 == '\n')) {
                    a(i2, i2, (CharSequence) " ");
                }
            }
        }
        return c(i, i2);
    }

    public boolean performLongClick() {
        boolean z;
        int a;
        if (super.performLongClick()) {
            this.v = true;
            z = true;
        } else {
            z = false;
        }
        if (!(z || b(this.ab, this.ac) || !this.i)) {
            a = a(this.ab, this.ac);
            Q();
            if (this.g.length() > 0) {
                Selection.setSelection((Spannable) this.g, a);
                getInsertionController().c().g();
            }
            z = true;
        }
        if (!z) {
            int i;
            v vVar;
            a = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            if (a != selectionEnd) {
                if (a > selectionEnd) {
                    Selection.setSelection((Spannable) this.g, selectionEnd, a);
                    i = a;
                } else {
                    i = selectionEnd;
                    selectionEnd = a;
                }
                an selectionController = getSelectionController();
                int i2 = selectionController.b;
                a = selectionController.c;
                if (i2 >= selectionEnd && a < r0) {
                    z = true;
                    if (z) {
                        getSelectionController().b();
                        N();
                        getSelectionController().a();
                    } else {
                        i = getSelectionStart();
                        a = getSelectionEnd();
                        ClipData.newPlainText(null, d(i, a));
                        vVar = new v(this, i, a);
                    }
                }
            }
            z = false;
            if (z) {
                getSelectionController().b();
                N();
                getSelectionController().a();
            } else {
                i = getSelectionStart();
                a = getSelectionEnd();
                ClipData.newPlainText(null, d(i, a));
                vVar = new v(this, i, a);
            }
        }
        this.v = true;
        float totalPaddingLeft = ((float) getTotalPaddingLeft()) + (this.h.getLineRight(this.h.getLineForOffset(this.g.length())) + ((float) getScrollX()));
        if (this.ap != null) {
            u uVar = this.g.length() == 0 ? u.EMPTY_LONG_CLICK : u.FILL_LONG_CLICK;
            if (this.g.length() > 0 && totalPaddingLeft < this.ab) {
                uVar = u.FILL_LONG_VACANT_CLICK;
            }
            this.ap.a(uVar);
        }
        return true;
    }

    private ak getPositionListener() {
        if (this.aa == null) {
            this.aa = new ak();
        }
        return this.aa;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r10, int r11) {
        /*
        r9 = this;
        r8 = 0;
        r2 = 1;
        r1 = 0;
        r3 = bp;
        monitor-enter(r3);
        r4 = bp;	 Catch:{ all -> 0x008b }
        r0 = 0;
        r5 = (float) r10;	 Catch:{ all -> 0x008b }
        r4[r0] = r5;	 Catch:{ all -> 0x008b }
        r0 = 1;
        r5 = (float) r11;	 Catch:{ all -> 0x008b }
        r4[r0] = r5;	 Catch:{ all -> 0x008b }
        r0 = r9;
    L_0x0011:
        if (r0 == 0) goto L_0x0088;
    L_0x0013:
        if (r0 == r9) goto L_0x002b;
    L_0x0015:
        r5 = 0;
        r6 = r4[r5];	 Catch:{ all -> 0x008b }
        r7 = r0.getScrollX();	 Catch:{ all -> 0x008b }
        r7 = (float) r7;	 Catch:{ all -> 0x008b }
        r6 = r6 - r7;
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
        r5 = 1;
        r6 = r4[r5];	 Catch:{ all -> 0x008b }
        r7 = r0.getScrollY();	 Catch:{ all -> 0x008b }
        r7 = (float) r7;	 Catch:{ all -> 0x008b }
        r6 = r6 - r7;
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
    L_0x002b:
        r5 = r0.getWidth();	 Catch:{ all -> 0x008b }
        r6 = r0.getHeight();	 Catch:{ all -> 0x008b }
        r7 = 0;
        r7 = r4[r7];	 Catch:{ all -> 0x008b }
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0051;
    L_0x003a:
        r7 = 1;
        r7 = r4[r7];	 Catch:{ all -> 0x008b }
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0051;
    L_0x0041:
        r7 = 0;
        r7 = r4[r7];	 Catch:{ all -> 0x008b }
        r5 = (float) r5;	 Catch:{ all -> 0x008b }
        r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r5 > 0) goto L_0x0051;
    L_0x0049:
        r5 = 1;
        r5 = r4[r5];	 Catch:{ all -> 0x008b }
        r6 = (float) r6;	 Catch:{ all -> 0x008b }
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x0054;
    L_0x0051:
        monitor-exit(r3);	 Catch:{ all -> 0x008b }
        r0 = r1;
    L_0x0053:
        return r0;
    L_0x0054:
        r5 = r0.getMatrix();	 Catch:{ all -> 0x008b }
        r5 = r5.isIdentity();	 Catch:{ all -> 0x008b }
        if (r5 != 0) goto L_0x0065;
    L_0x005e:
        r5 = r0.getMatrix();	 Catch:{ all -> 0x008b }
        r5.mapPoints(r4);	 Catch:{ all -> 0x008b }
    L_0x0065:
        r5 = 0;
        r6 = r4[r5];	 Catch:{ all -> 0x008b }
        r7 = r0.getLeft();	 Catch:{ all -> 0x008b }
        r7 = (float) r7;	 Catch:{ all -> 0x008b }
        r6 = r6 + r7;
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
        r5 = 1;
        r6 = r4[r5];	 Catch:{ all -> 0x008b }
        r7 = r0.getTop();	 Catch:{ all -> 0x008b }
        r7 = (float) r7;	 Catch:{ all -> 0x008b }
        r6 = r6 + r7;
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
        r0 = r0.getParent();	 Catch:{ all -> 0x008b }
        r5 = r0 instanceof android.view.View;	 Catch:{ all -> 0x008b }
        if (r5 == 0) goto L_0x0086;
    L_0x0083:
        r0 = (android.view.View) r0;	 Catch:{ all -> 0x008b }
        goto L_0x0011;
    L_0x0086:
        r0 = 0;
        goto L_0x0011;
    L_0x0088:
        monitor-exit(r3);	 Catch:{ all -> 0x008b }
        r0 = r2;
        goto L_0x0053;
    L_0x008b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x008b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ui.edittext.TextView.e(int, int):boolean");
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.aa != null) {
            this.aa.c = true;
        }
    }

    private static CharSequence a(CharSequence charSequence) {
        int i = 0;
        if (charSequence instanceof Spanned) {
            Spannable spannable;
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                CharSequence spannableString = new SpannableString(charSequence);
                CharSequence charSequence2 = spannableString;
                charSequence = spannableString;
            }
            SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(0, charSequence.length(), SuggestionSpan.class);
            while (i < suggestionSpanArr.length) {
                spannable.removeSpan(suggestionSpanArr[i]);
                i++;
            }
        }
        return charSequence;
    }

    private boolean O() {
        if ((this.at & 15) != 1 || (this.at & 524288) > 0) {
            return false;
        }
        int i = this.at & 4080;
        if (i == 0 || i == 48 || i == 80 || i == 64 || i == 160) {
            return true;
        }
        return false;
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
    }

    public Callback getCustomSelectionActionModeCallback() {
        return null;
    }

    public final boolean j() {
        if (this.aL != null) {
            return false;
        }
        if (K() && requestFocus()) {
            if (!(B() || N())) {
                if (this.g.length() <= 0) {
                    return false;
                }
                M();
            }
            boolean P = P();
            if (!P) {
                getSelectionController().a();
            }
            P = (this.aL == null && P) ? false : true;
            if (P && !this.aY && this.ag) {
                InputMethodManager peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null) {
                    peekInstance.showSoftInput(this, 0, null);
                }
            }
            return P;
        }
        Log.w("TextView", "TextView does not support text selection. Action mode cancelled.");
        return false;
    }

    private static boolean P() {
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        return peekInstance != null && peekInstance.isFullscreenMode();
    }

    private void Q() {
        if (this.g != null) {
            Selection.setSelection((Spannable) this.g, getSelectionEnd());
            if (this.aK != null) {
                this.aK.b();
            }
        }
    }

    private void setPrimaryClip(ClipData clipData) {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(clipData);
        bB = SystemClock.uptimeMillis();
    }

    private void R() {
        if (this.aJ != null) {
            this.aJ.b();
        }
    }

    public final void k() {
        S();
        if (this.aA != null) {
            z.a(this.aA.c);
        }
    }

    private void S() {
        if (!(this.O == null || this.O.a)) {
            this.O.f();
        }
        R();
        if (this.aK != null) {
            this.aK.b();
        }
    }

    public final int a(float f, float f2) {
        if (getLayout() == null) {
            return -1;
        }
        return getLayout().getOffsetForHorizontal(c(f2), b(f));
    }

    private float b(float f) {
        return Math.min((float) ((getWidth() - getTotalPaddingRight()) - 1), Math.max(0.0f, f - ((float) getTotalPaddingLeft()))) + ((float) getScrollX());
    }

    private int c(float f) {
        return getLayout().getLineForVertical((int) (Math.min((float) ((getHeight() - getTotalPaddingBottom()) - 1), Math.max(0.0f, f - ((float) getTotalPaddingTop()))) + ((float) getScrollY())));
    }

    private boolean b(float f, float f2) {
        if (getLayout() == null) {
            return false;
        }
        int c = c(f2);
        float b = b(f);
        if (b < getLayout().getLineLeft(c) || b > getLayout().getLineRight(c)) {
            return false;
        }
        return true;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        Object obj = null;
        switch (dragEvent.getAction()) {
            case 1:
                return this.i;
            case 2:
                Selection.setSelection((Spannable) this.g, a(dragEvent.getX(), dragEvent.getY()));
                return true;
            case 3:
                int i;
                CharSequence stringBuilder = new StringBuilder("");
                ClipData clipData = dragEvent.getClipData();
                int itemCount = clipData.getItemCount();
                for (i = 0; i < itemCount; i++) {
                    stringBuilder.append(clipData.getItemAt(i).coerceToText(this.mContext));
                }
                itemCount = a(dragEvent.getX(), dragEvent.getY());
                Object localState = dragEvent.getLocalState();
                v vVar = null;
                if (localState instanceof v) {
                    vVar = (v) localState;
                }
                if (vVar != null && vVar.a == this) {
                    obj = 1;
                }
                if (obj == null || itemCount < vVar.b || itemCount >= vVar.c) {
                    int length = this.g.length();
                    long b = b(itemCount, itemCount, stringBuilder);
                    itemCount = (int) (b >>> 32);
                    int i2 = (int) (b & 4294967295L);
                    Selection.setSelection((Spannable) this.g, i2);
                    a(itemCount, i2, stringBuilder);
                    if (obj != null) {
                        i = vVar.b;
                        int i3 = vVar.c;
                        if (i2 <= i) {
                            int length2 = this.g.length() - length;
                            i += length2;
                            i3 += length2;
                        }
                        b(i, i3);
                        if ((i == 0 || Character.isSpaceChar(this.ar.charAt(i - 1))) && (i == this.g.length() || Character.isSpaceChar(this.ar.charAt(i)))) {
                            if (i == this.g.length()) {
                                i--;
                            }
                            b(i, i + 1);
                        }
                    }
                }
                return true;
            case 5:
                requestFocus();
                return true;
            default:
                return true;
        }
    }

    private af getInsertionController() {
        if (!this.i) {
            return null;
        }
        if (this.aJ == null) {
            this.aJ = new af();
            getViewTreeObserver().addOnTouchModeChangeListener(this.aJ);
        }
        return this.aJ;
    }

    public final boolean l() {
        return Math.abs(getSelectionEnd() - getSelectionStart()) == this.g.length();
    }

    private boolean T() {
        return getSelectionStart() != getSelectionEnd();
    }

    public String getTextSelected() {
        return this.g.subSequence(Math.min(getSelectionStart(), getSelectionEnd()), Math.max(getSelectionStart(), getSelectionEnd())).toString();
    }

    public final void m() {
        an selectionController = getSelectionController();
        if (selectionController != null && T()) {
            selectionController.a();
        }
    }

    public void setSelectHandleLeft(Drawable drawable) {
        this.T = drawable;
    }

    public void setSelectHandleRight(Drawable drawable) {
        this.U = drawable;
    }

    public void setSelectHandleCenter(Drawable drawable) {
        this.V = drawable;
    }

    public void setCustomContextMenuBackground(Drawable drawable) {
        this.W = drawable;
    }

    public void setOnCustomActionListener(ag agVar) {
        this.ap = agVar;
    }

    public void setContextMenuListener(d dVar) {
        this.k = dVar;
    }

    public final void n() {
        if (this.an != null && this.an.isShowing()) {
            this.an.dismiss();
        }
        if (this.k != null) {
            this.k.e();
        }
        this.aP = false;
    }

    public final void a(u uVar, c... cVarArr) {
        if (cVarArr.length != 0) {
            getLocationOnScreen(this.a);
            int totalPaddingLeft = this.a[0] + getTotalPaddingLeft();
            int height = ((this.a[1] + getHeight()) + getTotalPaddingTop()) + d(12.0f);
            if (cVarArr.length > 1) {
                totalPaddingLeft = this.a[0];
            }
            a((float) totalPaddingLeft, (float) height, uVar, cVarArr);
        }
    }

    public final void b(u uVar, c... cVarArr) {
        if (cVarArr.length != 0) {
            getLocationOnScreen(this.a);
            a(this.ab, (float) (((this.a[1] + getHeight()) + getTotalPaddingTop()) + d(22.0f)), uVar, cVarArr);
        }
    }

    private void a(float f, float f2, u uVar, c... cVarArr) {
        if (this.k != null) {
            this.k.d();
        }
        this.aP = true;
        if (this.aq != null) {
            removeCallbacks(this.aq);
        }
        if (!T()) {
            this.aq = new k(this);
            postDelayed(this.aq, 4000);
        }
        int d = d(15.0f);
        if (this.an == null) {
            this.an = new l(this, this);
            this.an.setWidth(-2);
            this.an.setHeight(-2);
            this.an.setWindowLayoutType(1002);
            this.ao = new LinearLayout(getContext());
            this.ao.setOrientation(0);
            if (this.W == null) {
                this.W = new ColorDrawable(-12303292);
            }
            this.ao.setBackgroundDrawable(this.W);
            View linearLayout = new LinearLayout(getContext());
            linearLayout.setBackgroundDrawable(new ColorDrawable(0));
            linearLayout.setPadding(d, 0, d, 0);
            linearLayout.addView(this.ao);
            this.an.setContentView(linearLayout);
        }
        if (this.an.isShowing()) {
            this.an.dismiss();
        }
        this.ao.removeAllViews();
        OnClickListener mVar = new m(this, uVar);
        for (c cVar : cVarArr) {
            int d2 = d(10.0f);
            int d3 = d(12.0f);
            int d4 = d(13.0f);
            View textView = new android.widget.TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, IPictureView.DEFAULT_MIN_SCALE));
            textView.setGravity(17);
            textView.setPadding(d3, d2, d3, d2);
            textView.setTextSize(0, (float) d4);
            textView.setTextColor(-1);
            textView.setSingleLine();
            textView.setTag(cVar);
            textView.setText(cVar.c);
            textView.setOnClickListener(mVar);
            this.ao.addView(textView);
        }
        if (this.an.isShowing()) {
            this.an.update(((int) f) - d, (int) f2, -1, -1, false);
        } else {
            this.an.showAtLocation(this, 0, ((int) f) - d, (int) f2);
        }
    }

    public int getOrderSelectionStart() {
        return Math.min(getSelectionStart(), getSelectionEnd());
    }

    public int getOrderSelectionEnd() {
        return Math.max(getSelectionStart(), getSelectionEnd());
    }

    public final void a(String str) {
        int min = Math.min(getSelectionStart(), getSelectionEnd());
        int max = Math.max(getSelectionStart(), getSelectionEnd());
        if (min != -1 && max != -1) {
            ((Editable) getText()).replace(Math.min(min, max), Math.max(min, max), str);
        }
    }

    private an getSelectionController() {
        if (!this.aN) {
            return null;
        }
        if (this.aK == null) {
            this.aK = new an(this);
            getViewTreeObserver().addOnTouchModeChangeListener(this.aK);
        }
        return this.aK;
    }

    private int d(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    final boolean o() {
        ac acVar = this.f;
        if (acVar != null) {
            return acVar.f > 0;
        } else {
            return this.aQ;
        }
    }

    private int getResolvedLayoutDirection() {
        return 0;
    }

    private void U() {
        if (!this.aj && this.D != null) {
            if (this.D.f == null && this.D.g == null) {
                this.aj = true;
                return;
            }
            w wVar = this.D;
            switch (getResolvedLayoutDirection()) {
                case 1:
                    if (wVar.f != null) {
                        wVar.e = wVar.f;
                        wVar.k = wVar.l;
                        wVar.q = wVar.r;
                    }
                    if (wVar.g != null) {
                        wVar.d = wVar.g;
                        wVar.j = wVar.m;
                        wVar.p = wVar.s;
                        break;
                    }
                    break;
                default:
                    if (wVar.f != null) {
                        wVar.d = wVar.f;
                        wVar.j = wVar.l;
                        wVar.p = wVar.r;
                    }
                    if (wVar.g != null) {
                        wVar.e = wVar.g;
                        wVar.k = wVar.m;
                        wVar.q = wVar.s;
                        break;
                    }
                    break;
            }
            this.aj = true;
        }
    }

    private void a(InputMethodManager inputMethodManager) {
        if (inputMethodManager != null) {
            inputMethodManager.viewClicked(this);
        }
    }

    protected final void b(int i, int i2) {
        ((Editable) this.g).delete(i, i2);
    }

    protected final void a(int i, int i2, CharSequence charSequence) {
        ((Editable) this.g).replace(i, i2, charSequence);
    }

    public void setCursorDrawable(Drawable[] drawableArr) {
        this.R[0] = drawableArr[0];
        this.R[1] = drawableArr[1];
    }

    public void setCursorRes(int i) {
        this.Q = i;
    }

    private boolean K() {
        return this.aN && this.g.length() != 0;
    }
}
