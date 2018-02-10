package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.q;
import android.support.v7.c.k;

/* compiled from: ProGuard */
final class fg extends AppCompatImageView implements eu {
    final /* synthetic */ ActionMenuPresenter a;
    private final float[] b = new float[2];

    public fg(ActionMenuPresenter actionMenuPresenter, Context context) {
        this.a = actionMenuPresenter;
        super(context, null, k.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new dq(this, this, actionMenuPresenter));
    }

    public final boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.a.c();
        }
        return true;
    }

    public final boolean c() {
        return false;
    }

    public final boolean d() {
        return false;
    }

    protected final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            q.a(background, width - max, height - max, width + max, height + max);
        }
        return frame;
    }
}
