package com.UCMobile.Apollo.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.UCMobile.Apollo.util.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class SubtitleLayout extends View {
    private final List<c> a;
    private List<b> b;
    private int c;
    private float d;
    private boolean e;
    private a f;
    private float g;

    public SubtitleLayout(Context context) {
        this(context, null);
    }

    public SubtitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        this.c = 0;
        this.d = 0.0533f;
        this.e = true;
        this.f = a.a;
        this.g = 0.08f;
    }

    public final void a(List<b> list) {
        if (this.b != list) {
            this.b = list;
            int size = list == null ? 0 : list.size();
            while (this.a.size() < size) {
                this.a.add(new c(getContext()));
            }
            invalidate();
        }
    }

    public final void setFixedTextSize(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setTextSize(2, TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    public final void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public final void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    private void setTextSize(int i, float f) {
        if (this.c != i || this.d != f) {
            this.c = i;
            this.d = f;
            invalidate();
        }
    }

    public final void setApplyEmbeddedStyles(boolean z) {
        if (this.e != z) {
            this.e = z;
            invalidate();
        }
    }

    public final void a(a aVar) {
        if (this.f != aVar) {
            this.f = aVar;
            invalidate();
        }
    }

    public final void setBottomPaddingFraction(float f) {
        if (this.g != f) {
            this.g = f;
            invalidate();
        }
    }

    public final void dispatchDraw(Canvas canvas) {
        int i;
        if (this.b == null) {
            i = 0;
        } else {
            i = this.b.size();
        }
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            float f;
            if (this.c == 2) {
                f = this.d;
            } else {
                f = ((float) (this.c == 0 ? paddingBottom - paddingTop : bottom - top)) * this.d;
            }
            if (f > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    c cVar = (c) this.a.get(i2);
                    b bVar = (b) this.b.get(i2);
                    boolean z = this.e;
                    a aVar = this.f;
                    float f2 = this.g;
                    CharSequence charSequence = bVar.a;
                    if (!TextUtils.isEmpty(charSequence)) {
                        Object obj;
                        if (!z) {
                            charSequence = charSequence.toString();
                        }
                        CharSequence charSequence2 = cVar.d;
                        if (charSequence2 == charSequence || (charSequence2 != null && charSequence2.equals(charSequence))) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null && e.a(cVar.e, bVar.b) && cVar.f == bVar.c && cVar.g == bVar.d && e.a(Integer.valueOf(cVar.h), Integer.valueOf(bVar.e)) && cVar.i == bVar.f && e.a(Integer.valueOf(cVar.j), Integer.valueOf(bVar.g)) && cVar.k == bVar.h && cVar.l == z && cVar.m == aVar.b && cVar.n == aVar.c && cVar.o == aVar.d && cVar.q == aVar.e && cVar.p == aVar.f && e.a(cVar.c.getTypeface(), aVar.g) && cVar.r == f && cVar.s == f2 && cVar.t == left && cVar.u == paddingTop && cVar.v == right && cVar.w == paddingBottom) {
                            cVar.a(canvas);
                        } else {
                            cVar.d = charSequence;
                            cVar.e = bVar.b;
                            cVar.f = bVar.c;
                            cVar.g = bVar.d;
                            cVar.h = bVar.e;
                            cVar.i = bVar.f;
                            cVar.j = bVar.g;
                            cVar.k = bVar.h;
                            cVar.l = z;
                            cVar.m = aVar.b;
                            cVar.n = aVar.c;
                            cVar.o = aVar.d;
                            cVar.q = aVar.e;
                            cVar.p = aVar.f;
                            cVar.c.setTypeface(aVar.g);
                            cVar.r = f;
                            cVar.s = f2;
                            cVar.t = left;
                            cVar.u = paddingTop;
                            cVar.v = right;
                            cVar.w = paddingBottom;
                            int i3 = cVar.v - cVar.t;
                            int i4 = cVar.w - cVar.u;
                            cVar.c.setTextSize(f);
                            int i5 = (int) ((0.125f * f) + 0.5f);
                            int i6 = i3 - (i5 * 2);
                            if (cVar.k != Float.MIN_VALUE) {
                                i6 = (int) (((float) i6) * cVar.k);
                            }
                            if (i6 > 0) {
                                int i7;
                                Alignment alignment = cVar.e == null ? Alignment.ALIGN_CENTER : cVar.e;
                                cVar.x = new StaticLayout(charSequence, cVar.c, i6, alignment, cVar.a, cVar.b, true);
                                i6 = cVar.x.getHeight();
                                int i8 = 0;
                                int lineCount = cVar.x.getLineCount();
                                for (top = 0; top < lineCount; top++) {
                                    i8 = Math.max((int) Math.ceil((double) cVar.x.getLineWidth(top)), i8);
                                }
                                i8 += i5 * 2;
                                if (cVar.i != Float.MIN_VALUE) {
                                    top = Math.round(((float) i3) * cVar.i) + cVar.t;
                                    if (cVar.j == 2) {
                                        top -= i8;
                                    } else if (cVar.j == 1) {
                                        top = ((top * 2) - i8) / 2;
                                    }
                                    top = Math.max(top, cVar.t);
                                    i3 = top;
                                    top = Math.min(i8 + top, cVar.v);
                                } else {
                                    top = (i3 - i8) / 2;
                                    i3 = top;
                                    top = i8 + top;
                                }
                                if (cVar.f != Float.MIN_VALUE) {
                                    if (cVar.g == 0) {
                                        i8 = Math.round(((float) i4) * cVar.f) + cVar.u;
                                    } else {
                                        i8 = cVar.x.getLineBottom(0) - cVar.x.getLineTop(0);
                                        if (cVar.f >= 0.0f) {
                                            i8 = Math.round(((float) i8) * cVar.f) + cVar.u;
                                        } else {
                                            i8 = Math.round(((float) i8) * cVar.f) + cVar.w;
                                        }
                                    }
                                    if (cVar.h == 2) {
                                        i8 -= i6;
                                    } else if (cVar.h == 1) {
                                        i8 = ((i8 * 2) - i6) / 2;
                                    }
                                    if (i8 + i6 > cVar.w) {
                                        i7 = cVar.w - i6;
                                    } else {
                                        if (i8 < cVar.u) {
                                            i8 = cVar.u;
                                        }
                                        i7 = i8;
                                    }
                                } else {
                                    i7 = (cVar.w - i6) - ((int) (((float) i4) * f2));
                                }
                                cVar.x = new StaticLayout(charSequence, cVar.c, top - i3, alignment, cVar.a, cVar.b, true);
                                cVar.y = i3;
                                cVar.z = i7;
                                cVar.A = i5;
                                cVar.a(canvas);
                            }
                        }
                    }
                }
            }
        }
    }
}
