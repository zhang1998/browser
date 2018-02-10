package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class cb extends ImageView {
    AnimationListener a;
    private int b;

    public cb(Context context) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) ((20.0f * f) * 2.0f);
        int i2 = (int) (IPictureView.DEFAULT_MID_SCALE * f);
        int i3 = (int) (0.0f * f);
        this.b = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.f((View) this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new bi(this, this.b, i));
            ViewCompat.a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.b, (float) i3, (float) i2, 503316480);
            int i4 = this.b;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(-328966);
        setBackgroundDrawable(shapeDrawable);
    }

    private static boolean a() {
        return VERSION.SDK_INT >= 21;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.b * 2), getMeasuredHeight() + (this.b * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.a != null) {
            this.a.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.a != null) {
            this.a.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
