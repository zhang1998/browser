package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: ProGuard */
final class bg extends Filter {
    r a;

    bg(r rVar) {
        this.a = rVar;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.a.b((Cursor) obj);
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.a.a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.a.a();
        if (filterResults.values != null && filterResults.values != a) {
            this.a.a((Cursor) filterResults.values);
        }
    }
}
