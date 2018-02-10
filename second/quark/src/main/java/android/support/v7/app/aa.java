package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/* compiled from: ProGuard */
public final class aa {
    TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public int E = -1;
    int F;
    int G;
    public int H;
    public int I;
    public int J;
    public int K;
    int L = 0;
    Handler M;
    final OnClickListener N = new af(this);
    public final Context a;
    final ax b;
    final Window c;
    CharSequence d;
    public CharSequence e;
    public ListView f;
    public View g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m = false;
    Button n;
    CharSequence o;
    Message p;
    Button q;
    CharSequence r;
    Message s;
    Button t;
    CharSequence u;
    Message v;
    NestedScrollView w;
    public int x = 0;
    public Drawable y;
    public ImageView z;

    static /* synthetic */ void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ViewCompat.b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ViewCompat.b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    public aa(Context context, ax axVar, Window window) {
        this.a = context;
        this.b = axVar;
        this.c = window;
        this.M = new k(axVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, h.AlertDialog, k.alertDialogStyle, 0);
        this.F = obtainStyledAttributes.getResourceId(h.AlertDialog_android_layout, 0);
        this.G = obtainStyledAttributes.getResourceId(h.AlertDialog_buttonPanelSideLayout, 0);
        this.H = obtainStyledAttributes.getResourceId(h.AlertDialog_listLayout, 0);
        this.I = obtainStyledAttributes.getResourceId(h.AlertDialog_multiChoiceItemLayout, 0);
        this.J = obtainStyledAttributes.getResourceId(h.AlertDialog_singleChoiceItemLayout, 0);
        this.K = obtainStyledAttributes.getResourceId(h.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        axVar.a().c(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void a(CharSequence charSequence) {
        this.d = charSequence;
        if (this.A != null) {
            this.A.setText(charSequence);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.u = charSequence;
                this.v = message;
                return;
            case -2:
                this.r = charSequence;
                this.s = message;
                return;
            case -1:
                this.o = charSequence;
                this.p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void a(int i) {
        this.y = null;
        this.x = i;
        if (this.z == null) {
            return;
        }
        if (i != 0) {
            this.z.setVisibility(0);
            this.z.setImageResource(this.x);
            return;
        }
        this.z.setVisibility(8);
    }

    @Nullable
    static ViewGroup a(@Nullable View view, @Nullable View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }
}
