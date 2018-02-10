package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: ProGuard */
final class by extends ct {
    private static final int[] c = new int[]{16843074};
    private final SeekBar d;

    by(SeekBar seekBar, fb fbVar) {
        super(seekBar, fbVar);
        this.d = seekBar;
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        dh a = dh.a(this.d.getContext(), attributeSet, c, i);
        Drawable b = a.b(0);
        if (b != null) {
            this.d.setThumb(b);
        }
        a.a.recycle();
    }
}
