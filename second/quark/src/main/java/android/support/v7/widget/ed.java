package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class ed implements AnimationListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchCompat b;

    ed(SwitchCompat switchCompat, boolean z) {
        this.b = switchCompat;
        this.a = z;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.b.C == animation) {
            this.b.setThumbPosition(this.a ? IPictureView.DEFAULT_MIN_SCALE : 0.0f);
            this.b.C = null;
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
