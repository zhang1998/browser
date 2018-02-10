package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;

/* compiled from: ProGuard */
public final class b {
    public int A;
    public boolean B = false;
    public boolean[] C;
    public boolean D;
    public boolean E;
    public int F = -1;
    public OnMultiChoiceClickListener G;
    public Cursor H;
    public String I;
    public String J;
    public OnItemSelectedListener K;
    public boolean L = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public OnClickListener j;
    public CharSequence k;
    public OnClickListener l;
    public CharSequence m;
    public OnClickListener n;
    public boolean o;
    public OnCancelListener p;
    public OnDismissListener q;
    public OnKeyListener r;
    public CharSequence[] s;
    public ListAdapter t;
    public OnClickListener u;
    public int v;
    public View w;
    public int x;
    public int y;
    public int z;

    public b(Context context) {
        this.a = context;
        this.o = true;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
