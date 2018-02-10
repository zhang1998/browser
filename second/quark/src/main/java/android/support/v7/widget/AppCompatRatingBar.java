package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* compiled from: ProGuard */
public class AppCompatRatingBar extends RatingBar {
    private ct a;
    private fb b;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = fb.a();
        this.a = new ct(this, this.b);
        this.a.a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.a.b;
        if (bitmap != null) {
            setMeasuredDimension(ViewCompat.a(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
