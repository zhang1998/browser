package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.s;
import android.support.v7.c.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class AppCompatPopupWindow extends PopupWindow {
    private static final boolean a = (VERSION.SDK_INT < 21);
    private boolean b;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dh a = dh.a(context, attributeSet, h.PopupWindow, i);
        if (a.e(h.PopupWindow_overlapAnchor)) {
            boolean a2 = a.a(h.PopupWindow_overlapAnchor, false);
            if (a) {
                this.b = a2;
            } else {
                s.a((PopupWindow) this, a2);
            }
        }
        setBackgroundDrawable(a.a(h.PopupWindow_android_popupBackground));
        a.a.recycle();
        if (VERSION.SDK_INT < 14) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                declaredField2.set(this, new et(declaredField, this, (OnScrollChangedListener) declaredField2.get(this)));
            } catch (Exception e) {
            }
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (a && this.b) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }
}
