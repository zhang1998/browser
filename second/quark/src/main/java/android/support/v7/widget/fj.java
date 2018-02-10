package android.support.v7.widget;

import android.graphics.Outline;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
final class fj extends db {
    public fj(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public final void getOutline(@NonNull Outline outline) {
        if (this.a.d) {
            if (this.a.c != null) {
                this.a.c.getOutline(outline);
            }
        } else if (this.a.a != null) {
            this.a.a.getOutline(outline);
        }
    }
}
