package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.aa;
import android.support.v7.app.ad;
import android.support.v7.app.ae;
import android.support.v7.app.ap;
import android.support.v7.app.at;
import android.support.v7.app.au;
import android.support.v7.app.av;
import android.support.v7.app.f;
import android.support.v7.c.l;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/* compiled from: ProGuard */
public final class b implements r, OnItemClickListener {
    Context a;
    public LayoutInflater b;
    u c;
    public ExpandedMenuView d;
    int e;
    int f;
    public m g;
    public x h;
    private int i;

    public b(Context context, int i) {
        this(i);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    private b(int i) {
        this.f = i;
        this.e = 0;
    }

    public final void a(Context context, u uVar) {
        if (this.e != 0) {
            this.a = new ContextThemeWrapper(context, this.e);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = uVar;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public final ListAdapter a() {
        if (this.h == null) {
            this.h = new x(this);
        }
        return this.h;
    }

    public final void a(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public final boolean a(a aVar) {
        if (!aVar.hasVisibleItems()) {
            return false;
        }
        w wVar = new w(aVar);
        u uVar = wVar.a;
        ae aeVar = new ae(uVar.b);
        wVar.c = new b(aeVar.a.a, l.abc_list_menu_item_layout);
        wVar.c.g = wVar;
        wVar.a.a(wVar.c);
        aeVar.a.t = wVar.c.a();
        aeVar.a.u = wVar;
        View view = uVar.i;
        if (view != null) {
            aeVar.a.g = view;
        } else {
            aeVar.a.d = uVar.h;
            aeVar.a.f = uVar.g;
        }
        aeVar.a.r = wVar;
        ap apVar = new ap(aeVar.a.a, aeVar.b);
        android.support.v7.app.b bVar = aeVar.a;
        aa a = apVar.a;
        if (bVar.g != null) {
            a.C = bVar.g;
        } else {
            if (bVar.f != null) {
                a.a(bVar.f);
            }
            if (bVar.d != null) {
                Drawable drawable = bVar.d;
                a.y = drawable;
                a.x = 0;
                if (a.z != null) {
                    if (drawable != null) {
                        a.z.setVisibility(0);
                        a.z.setImageDrawable(drawable);
                    } else {
                        a.z.setVisibility(8);
                    }
                }
            }
            if (bVar.c != 0) {
                a.a(bVar.c);
            }
            if (bVar.e != 0) {
                int i = bVar.e;
                TypedValue typedValue = new TypedValue();
                a.a.getTheme().resolveAttribute(i, typedValue, true);
                a.a(typedValue.resourceId);
            }
        }
        if (bVar.h != null) {
            CharSequence charSequence = bVar.h;
            a.e = charSequence;
            if (a.B != null) {
                a.B.setText(charSequence);
            }
        }
        if (bVar.i != null) {
            a.a(-1, bVar.i, bVar.j, null);
        }
        if (bVar.k != null) {
            a.a(-2, bVar.k, bVar.l, null);
        }
        if (bVar.m != null) {
            a.a(-3, bVar.m, bVar.n, null);
        }
        if (!(bVar.s == null && bVar.H == null && bVar.t == null)) {
            ListAdapter listAdapter;
            ListView listView = (ListView) bVar.b.inflate(a.H, null);
            Object simpleCursorAdapter;
            if (!bVar.D) {
                int i2;
                if (bVar.E) {
                    i2 = a.J;
                } else {
                    i2 = a.K;
                }
                if (bVar.H != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(bVar.a, i2, bVar.H, new String[]{bVar.I}, new int[]{16908308});
                } else if (bVar.t != null) {
                    listAdapter = bVar.t;
                } else {
                    listAdapter = new av(bVar.a, i2, bVar.s);
                }
            } else if (bVar.H == null) {
                listAdapter = new at(bVar, bVar.a, a.I, bVar.s, listView);
            } else {
                simpleCursorAdapter = new au(bVar, bVar.a, bVar.H, listView, a);
            }
            a.D = listAdapter;
            a.E = bVar.F;
            if (bVar.u != null) {
                listView.setOnItemClickListener(new f(bVar, a));
            } else if (bVar.G != null) {
                listView.setOnItemClickListener(new ad(bVar, listView, a));
            }
            if (bVar.K != null) {
                listView.setOnItemSelectedListener(bVar.K);
            }
            if (bVar.E) {
                listView.setChoiceMode(1);
            } else if (bVar.D) {
                listView.setChoiceMode(2);
            }
            a.f = listView;
        }
        if (bVar.w != null) {
            if (bVar.B) {
                View view2 = bVar.w;
                int i3 = bVar.x;
                int i4 = bVar.y;
                int i5 = bVar.z;
                int i6 = bVar.A;
                a.g = view2;
                a.h = 0;
                a.m = true;
                a.i = i3;
                a.j = i4;
                a.k = i5;
                a.l = i6;
            } else {
                a.g = bVar.w;
                a.h = 0;
                a.m = false;
            }
        } else if (bVar.v != 0) {
            i = bVar.v;
            a.g = null;
            a.h = i;
            a.m = false;
        }
        apVar.setCancelable(aeVar.a.o);
        if (aeVar.a.o) {
            apVar.setCanceledOnTouchOutside(true);
        }
        apVar.setOnCancelListener(aeVar.a.p);
        apVar.setOnDismissListener(aeVar.a.q);
        if (aeVar.a.r != null) {
            apVar.setOnKeyListener(aeVar.a.r);
        }
        wVar.b = apVar;
        wVar.b.setOnDismissListener(wVar);
        LayoutParams attributes = wVar.b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        wVar.b.show();
        if (this.g != null) {
            this.g.a(aVar);
        }
        return true;
    }

    public final void a(u uVar, boolean z) {
        if (this.g != null) {
            this.g.a(uVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.a(i), (r) this, 0);
    }

    public final boolean b() {
        return false;
    }

    public final boolean a(i iVar) {
        return false;
    }

    public final boolean b(i iVar) {
        return false;
    }
}
