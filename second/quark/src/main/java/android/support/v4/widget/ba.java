package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ProGuard */
public abstract class ba extends az {
    private int a;
    private int k;
    private LayoutInflater l;

    public ba(Context context, int i) {
        super(context);
        this.k = i;
        this.a = i;
        this.l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.a, viewGroup, false);
    }

    public final View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.k, viewGroup, false);
    }
}
