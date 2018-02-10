package android.mini.support.v4.view.a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: ProGuard */
class i extends o {
    i() {
    }

    public final void a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public final int a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public final void a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public final void b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public final CharSequence b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public final CharSequence c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public final CharSequence d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public final CharSequence e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public final boolean f(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public final boolean g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public final boolean h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public final boolean i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public final boolean j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public final boolean k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public final boolean l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public final boolean m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public final boolean n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public final boolean o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public final void a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public final void a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }
}
