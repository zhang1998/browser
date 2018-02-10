package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class ci implements AnimationListener {
    final /* synthetic */ ag a;
    final /* synthetic */ MaterialProgressDrawable b;

    ci(MaterialProgressDrawable materialProgressDrawable, ag agVar) {
        this.b = materialProgressDrawable;
        this.a = agVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.b.k = 0.0f;
    }

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
        this.a.b();
        ag agVar = this.a;
        agVar.a(agVar.a());
        this.a.a(this.a.e);
        if (this.b.b) {
            this.b.b = false;
            animation.setDuration(1332);
            this.a.a(false);
            return;
        }
        this.b.k = (this.b.k + IPictureView.DEFAULT_MIN_SCALE) % 5.0f;
    }
}
