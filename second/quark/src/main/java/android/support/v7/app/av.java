package android.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

/* compiled from: ProGuard */
public final class av extends ArrayAdapter<CharSequence> {
    public av(Context context, int i, CharSequence[] charSequenceArr) {
        super(context, i, 16908308, charSequenceArr);
    }

    public final boolean hasStableIds() {
        return true;
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
