package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/* compiled from: ProGuard */
public final class ap extends ax implements DialogInterface {
    private aa a = new aa(getContext(), this, getWindow());

    public ap(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(k.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }

    protected final void onCreate(Bundle bundle) {
        int i;
        View view;
        int indexOfChild;
        Object obj;
        int i2;
        super.onCreate(bundle);
        aa aaVar = this.a;
        if (aaVar.G == 0 || aaVar.L != 1) {
            i = aaVar.F;
        } else {
            i = aaVar.G;
        }
        aaVar.b.setContentView(i);
        View findViewById = aaVar.c.findViewById(j.parentPanel);
        View findViewById2 = findViewById.findViewById(j.topPanel);
        View findViewById3 = findViewById.findViewById(j.contentPanel);
        View findViewById4 = findViewById.findViewById(j.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(j.customPanel);
        if (aaVar.g != null) {
            view = aaVar.g;
        } else if (aaVar.h != 0) {
            view = LayoutInflater.from(aaVar.a).inflate(aaVar.h, viewGroup, false);
        } else {
            view = null;
        }
        Object obj2 = view != null ? 1 : null;
        if (obj2 == null || !aa.a(view)) {
            aaVar.c.setFlags(131072, 131072);
        }
        if (obj2 != null) {
            FrameLayout frameLayout = (FrameLayout) aaVar.c.findViewById(j.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (aaVar.m) {
                frameLayout.setPadding(aaVar.i, aaVar.j, aaVar.k, aaVar.l);
            }
            if (aaVar.f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(j.topPanel);
        view = viewGroup.findViewById(j.contentPanel);
        View findViewById6 = viewGroup.findViewById(j.buttonPanel);
        ViewGroup a = aa.a(findViewById5, findViewById2);
        ViewGroup a2 = aa.a(view, findViewById3);
        ViewGroup a3 = aa.a(findViewById6, findViewById4);
        aaVar.w = (NestedScrollView) aaVar.c.findViewById(j.scrollView);
        aaVar.w.setFocusable(false);
        aaVar.w.setNestedScrollingEnabled(false);
        aaVar.B = (TextView) a2.findViewById(16908299);
        if (aaVar.B != null) {
            if (aaVar.e != null) {
                aaVar.B.setText(aaVar.e);
            } else {
                aaVar.B.setVisibility(8);
                aaVar.w.removeView(aaVar.B);
                if (aaVar.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) aaVar.w.getParent();
                    indexOfChild = viewGroup2.indexOfChild(aaVar.w);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(aaVar.f, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    a2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        aaVar.n = (Button) a3.findViewById(16908313);
        aaVar.n.setOnClickListener(aaVar.N);
        if (TextUtils.isEmpty(aaVar.o)) {
            aaVar.n.setVisibility(8);
        } else {
            aaVar.n.setText(aaVar.o);
            aaVar.n.setVisibility(0);
            indexOfChild = 1;
        }
        aaVar.q = (Button) a3.findViewById(16908314);
        aaVar.q.setOnClickListener(aaVar.N);
        if (TextUtils.isEmpty(aaVar.r)) {
            aaVar.q.setVisibility(8);
        } else {
            aaVar.q.setText(aaVar.r);
            aaVar.q.setVisibility(0);
            indexOfChild |= 2;
        }
        aaVar.t = (Button) a3.findViewById(16908315);
        aaVar.t.setOnClickListener(aaVar.N);
        if (TextUtils.isEmpty(aaVar.u)) {
            aaVar.t.setVisibility(8);
        } else {
            aaVar.t.setText(aaVar.u);
            aaVar.t.setVisibility(0);
            indexOfChild |= 4;
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            a3.setVisibility(8);
        }
        if (aaVar.C != null) {
            a.addView(aaVar.C, 0, new LayoutParams(-1, -2));
            aaVar.c.findViewById(j.title_template).setVisibility(8);
        } else {
            aaVar.z = (ImageView) aaVar.c.findViewById(16908294);
            if ((!TextUtils.isEmpty(aaVar.d) ? 1 : null) != null) {
                aaVar.A = (TextView) aaVar.c.findViewById(j.alertTitle);
                aaVar.A.setText(aaVar.d);
                if (aaVar.x != 0) {
                    aaVar.z.setImageResource(aaVar.x);
                } else if (aaVar.y != null) {
                    aaVar.z.setImageDrawable(aaVar.y);
                } else {
                    aaVar.A.setPadding(aaVar.z.getPaddingLeft(), aaVar.z.getPaddingTop(), aaVar.z.getPaddingRight(), aaVar.z.getPaddingBottom());
                    aaVar.z.setVisibility(8);
                }
            } else {
                aaVar.c.findViewById(j.title_template).setVisibility(8);
                aaVar.z.setVisibility(8);
                a.setVisibility(8);
            }
        }
        Object obj3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        obj2 = (a == null || a.getVisibility() == 8) ? null : 1;
        if (a3 == null || a3.getVisibility() == 8) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null && a2 != null) {
            findViewById = a2.findViewById(j.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (!(obj2 == null || aaVar.w == null)) {
            aaVar.w.setClipToPadding(true);
        }
        if (obj3 == null) {
            view = aaVar.f != null ? aaVar.f : aaVar.w;
            if (view != null) {
                if (obj2 != null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (obj != null) {
                    i = 2;
                } else {
                    i = 0;
                }
                int i3 = i2 | i;
                findViewById5 = aaVar.c.findViewById(j.scrollIndicatorUp);
                findViewById = aaVar.c.findViewById(j.scrollIndicatorDown);
                if (VERSION.SDK_INT >= 23) {
                    ViewCompat.f(view, i3);
                    if (findViewById5 != null) {
                        a2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        a2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i3 & 1) == 0) {
                        a2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i3 & 2) == 0) {
                        a2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (aaVar.e != null) {
                            aaVar.w.setOnScrollChangeListener(new x(aaVar, findViewById5, findViewById));
                            aaVar.w.post(new g(aaVar, findViewById5, findViewById));
                        } else if (aaVar.f != null) {
                            aaVar.f.setOnScrollListener(new s(aaVar, findViewById5, findViewById));
                            aaVar.f.post(new al(aaVar, findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                a2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                a2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = aaVar.f;
        if (listView != null && aaVar.D != null) {
            listView.setAdapter(aaVar.D);
            i2 = aaVar.E;
            if (i2 >= 0) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        aa aaVar = this.a;
        if (aaVar.w == null || !aaVar.w.a(keyEvent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        aa aaVar = this.a;
        if (aaVar.w == null || !aaVar.w.a(keyEvent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
