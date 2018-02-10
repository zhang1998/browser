package android.support.v4.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: ProGuard */
class o extends aa {
    o() {
    }

    public final Object a(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public final void a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public final void a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public final int b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public final void a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public final void b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public final CharSequence c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public final CharSequence d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public final CharSequence e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public final CharSequence f(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public final boolean g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public final boolean h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public final boolean i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public final boolean j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public final boolean k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public final boolean l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public final boolean m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public final boolean n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public final boolean o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public final boolean p(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public final void c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public final void d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public final void a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public final void a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public final void b(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public final void b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public final void c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public final void d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public final void e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public final void c(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public final void b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public final void f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public final void g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public final void c(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public final void q(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
