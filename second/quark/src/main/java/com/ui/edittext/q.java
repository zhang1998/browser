package com.ui.edittext;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* compiled from: ProGuard */
class q implements SpanWatcher, TextWatcher {
    final /* synthetic */ TextView a;
    private CharSequence b;
    private z c;

    private q(TextView textView) {
        this.a = textView;
        this.c = new z(textView);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!(!AccessibilityManager.getInstance(this.a.mContext).isEnabled() || TextView.e(this.a.at) || (this.a.ay instanceof PasswordTransformationMethod))) {
            this.b = charSequence.toString();
        }
        this.a.b(charSequence, i, i2, i3);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextView textView = this.a;
        ac acVar = textView.f;
        if (acVar == null || acVar.f == 0) {
            textView.g();
        }
        if (acVar != null) {
            acVar.i = true;
            if (acVar.j < 0) {
                acVar.j = i;
                acVar.k = i + i2;
            } else {
                acVar.j = Math.min(acVar.j, i);
                acVar.k = Math.max(acVar.k, (i + i2) - acVar.l);
            }
            acVar.l += i3 - i2;
        }
        textView.a(charSequence, i, i2, i3);
        textView.n();
        this.c.a(charSequence);
        if (!AccessibilityManager.getInstance(this.a.mContext).isEnabled()) {
            return;
        }
        if (this.a.isFocused() || (this.a.isSelected() && this.a.isShown())) {
            textView = this.a;
            CharSequence charSequence2 = this.b;
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16);
            obtain.setFromIndex(i);
            obtain.setRemovedCount(i2);
            obtain.setAddedCount(i3);
            obtain.setBeforeText(charSequence2);
            textView.sendAccessibilityEventUnchecked(obtain);
            this.b = null;
        }
    }

    public void afterTextChanged(Editable editable) {
        this.a.a(editable);
        if (g.a((CharSequence) editable, 2048) != 0) {
            g.e(editable);
        }
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        this.a.a((Spanned) spannable, obj, i, i3, i2, i4);
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        this.a.a((Spanned) spannable, obj, -1, i, -1, i2);
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        this.a.a((Spanned) spannable, obj, i, -1, i2, -1);
    }
}
