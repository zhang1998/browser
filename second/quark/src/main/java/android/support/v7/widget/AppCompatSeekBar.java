package android.support.v7.widget;

import android.content.Context;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: ProGuard */
public class AppCompatSeekBar extends SeekBar {
    private by a;
    private fb b;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = fb.a();
        this.a = new by(this, this.b);
        this.a.a(attributeSet, i);
    }
}
