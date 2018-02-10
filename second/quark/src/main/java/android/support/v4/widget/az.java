package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* compiled from: ProGuard */
public abstract class az extends BaseAdapter implements r, Filterable {
    protected boolean b = false;
    protected boolean c = true;
    public Cursor d = null;
    public Context e;
    protected int f;
    protected x g;
    protected DataSetObserver h;
    protected bg i;
    protected FilterQueryProvider j;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Cursor cursor);

    public az(Context context) {
        this.e = context;
        this.f = -1;
        this.g = new x(this);
        this.h = new ay();
    }

    public final Cursor a() {
        return this.d;
    }

    public int getCount() {
        if (!this.b || this.d == null) {
            return 0;
        }
        return this.d.getCount();
    }

    public Object getItem(int i) {
        if (!this.b || this.d == null) {
            return null;
        }
        this.d.moveToPosition(i);
        return this.d;
    }

    public long getItemId(int i) {
        if (this.b && this.d != null && this.d.moveToPosition(i)) {
            return this.d.getLong(this.f);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.d.moveToPosition(i)) {
            if (view == null) {
                view = a(this.e, this.d, viewGroup);
            }
            a(view, this.d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.d.moveToPosition(i);
        if (view == null) {
            view = b(this.e, this.d, viewGroup);
        }
        a(view, this.d);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        if (this.j != null) {
            return this.j.runQuery(charSequence);
        }
        return this.d;
    }

    public Filter getFilter() {
        if (this.i == null) {
            this.i = new bg(this);
        }
        return this.i;
    }

    protected final void b() {
        if (this.c && this.d != null && !this.d.isClosed()) {
            this.b = this.d.requery();
        }
    }

    public void a(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.d) {
            cursor2 = null;
        } else {
            cursor2 = this.d;
            if (cursor2 != null) {
                if (this.g != null) {
                    cursor2.unregisterContentObserver(this.g);
                }
                if (this.h != null) {
                    cursor2.unregisterDataSetObserver(this.h);
                }
            }
            this.d = cursor;
            if (cursor != null) {
                if (this.g != null) {
                    cursor.registerContentObserver(this.g);
                }
                if (this.h != null) {
                    cursor.registerDataSetObserver(this.h);
                }
                this.f = cursor.getColumnIndexOrThrow("_id");
                this.b = true;
                notifyDataSetChanged();
            } else {
                this.f = -1;
                this.b = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
