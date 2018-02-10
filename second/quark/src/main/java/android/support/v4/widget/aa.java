package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* compiled from: ProGuard */
class aa implements bz {
    aa() {
    }

    public Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof b) {
            ((b) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public void a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof b) {
            ((b) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
