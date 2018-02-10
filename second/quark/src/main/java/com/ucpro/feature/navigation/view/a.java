package com.ucpro.feature.navigation.view;

import android.graphics.Rect;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class a implements aw {
    l a;
    final /* synthetic */ k b;

    a(k kVar) {
        this.b = kVar;
    }

    public final void a() {
        if (this.b.e() != null && this.a != null) {
            s e;
            Object obj;
            int i;
            int i2;
            int i3;
            View childAt;
            Rect a;
            int i4;
            l lVar = this.a;
            Rect rect = new Rect();
            if (lVar.g != null) {
                rect.set(lVar.g);
                Rect rect2 = new Rect();
                t.a(this.b.e(), this.b.a, rect2);
                rect.offset(-rect2.left, -rect2.top);
            }
            k kVar = this.b;
            int i5 = rect.left;
            int i6 = rect.top;
            if (((float) i6) < ((float) kVar.e().getHeight()) * 0.1f) {
                e = kVar.e();
                if (e.getChildCount() > 1 && e.getFirstVisiblePosition() == 0 && e.getChildAt(0).getTop() == e.getPaddingTop()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    kVar.e().a(ai.a);
                    obj = 1;
                    if (obj != null) {
                        this.b.e().c();
                        i = -1;
                        i6 = 0;
                        i2 = 0;
                        i3 = -1;
                        while (i2 < this.b.e().getChildCount()) {
                            childAt = this.b.e().getChildAt(i2);
                            if (((j) childAt).getWidgetInfo().a == this.a.i.a) {
                                i3 = i2;
                            }
                            if (i == -1) {
                                a = t.a(childAt);
                                i5 = ((j) childAt).getWidgetInfo().b;
                                if (i5 != 1 || i5 == 2) {
                                    i5 = 0;
                                } else {
                                    float width = (float) (a.width() * a.height());
                                    Rect a2 = t.a(rect, a);
                                    width = ((float) (a2.width() * a2.height())) / width;
                                    float width2 = ((float) a2.width()) / ((float) a.width());
                                    if (width > 0.0f && width < IPictureView.DEFAULT_MIN_SCALE) {
                                        if (width > 0.48f || width2 > 0.8f) {
                                            i5 = 1;
                                        } else if (width > 0.35f) {
                                            i5 = 1;
                                        }
                                    }
                                    i5 = 0;
                                }
                                if (i5 > 0) {
                                    this.a.d = childAt;
                                    i4 = i2;
                                    i2++;
                                    i6 = i5;
                                    i = i4;
                                }
                            }
                            i5 = i6;
                            i4 = i;
                            i2++;
                            i6 = i5;
                            i = i4;
                        }
                        if (i6 != 1) {
                            this.b.a(this.a, i3, i);
                        } else if (i6 != 2) {
                            this.b.d = -1;
                        }
                    }
                }
            }
            if (((float) i6) > ((float) kVar.e().getHeight()) * 0.8f) {
                e = kVar.e();
                if (e.getLastVisiblePosition() != e.getAdapter().getCount() - 1 || e.getChildAt(e.getChildCount() - 1).getBottom() > e.getHeight() - e.getPaddingBottom()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    kVar.e().a(ai.b);
                    obj = 1;
                    if (obj != null) {
                        this.b.e().c();
                        i = -1;
                        i6 = 0;
                        i2 = 0;
                        i3 = -1;
                        while (i2 < this.b.e().getChildCount()) {
                            childAt = this.b.e().getChildAt(i2);
                            if (((j) childAt).getWidgetInfo().a == this.a.i.a) {
                                i3 = i2;
                            }
                            if (i == -1) {
                                a = t.a(childAt);
                                i5 = ((j) childAt).getWidgetInfo().b;
                                if (i5 != 1) {
                                }
                                i5 = 0;
                                if (i5 > 0) {
                                    this.a.d = childAt;
                                    i4 = i2;
                                    i2++;
                                    i6 = i5;
                                    i = i4;
                                }
                            }
                            i5 = i6;
                            i4 = i;
                            i2++;
                            i6 = i5;
                            i = i4;
                        }
                        if (i6 != 1) {
                            this.b.a(this.a, i3, i);
                        } else if (i6 != 2) {
                            this.b.d = -1;
                        }
                    }
                }
            }
            obj = null;
            if (obj != null) {
                this.b.e().c();
                i = -1;
                i6 = 0;
                i2 = 0;
                i3 = -1;
                while (i2 < this.b.e().getChildCount()) {
                    childAt = this.b.e().getChildAt(i2);
                    if (((j) childAt).getWidgetInfo().a == this.a.i.a) {
                        i3 = i2;
                    }
                    if (i == -1) {
                        a = t.a(childAt);
                        i5 = ((j) childAt).getWidgetInfo().b;
                        if (i5 != 1) {
                        }
                        i5 = 0;
                        if (i5 > 0) {
                            this.a.d = childAt;
                            i4 = i2;
                            i2++;
                            i6 = i5;
                            i = i4;
                        }
                    }
                    i5 = i6;
                    i4 = i;
                    i2++;
                    i6 = i5;
                    i = i4;
                }
                if (i6 != 1) {
                    this.b.a(this.a, i3, i);
                } else if (i6 != 2) {
                    this.b.d = -1;
                }
            }
        }
    }
}
