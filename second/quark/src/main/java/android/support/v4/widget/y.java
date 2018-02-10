package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

/* compiled from: ProGuard */
public final class y {
    private static final bz a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new o();
        } else if (i >= 21) {
            a = new bh();
        } else {
            a = new aa();
        }
    }

    public static void a(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(@NonNull CompoundButton compoundButton, @Nullable Mode mode) {
        a.a(compoundButton, mode);
    }

    @Nullable
    public static Drawable a(@NonNull CompoundButton compoundButton) {
        return a.a(compoundButton);
    }
}
