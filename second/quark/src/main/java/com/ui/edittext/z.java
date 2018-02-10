package com.ui.edittext;

import android.text.Spannable;
import android.text.Spanned;
import android.text.style.EasyEditSpan;

/* compiled from: ProGuard */
final class z {
    final /* synthetic */ TextView a;
    private x b;
    private EasyEditSpan c;
    private Runnable d;

    private z(TextView textView) {
        this.a = textView;
    }

    static /* synthetic */ void a(z zVar) {
        int i = 0;
        if (zVar.b != null) {
            zVar.b.f();
            zVar.a.removeCallbacks(zVar.d);
        }
        CharSequence b = zVar.a.g;
        if (b instanceof Spannable) {
            Spannable spannable = (Spannable) b;
            EasyEditSpan[] easyEditSpanArr = (EasyEditSpan[]) spannable.getSpans(0, spannable.length(), EasyEditSpan.class);
            while (i < easyEditSpanArr.length) {
                spannable.removeSpan(easyEditSpanArr[i]);
                i++;
            }
        }
        zVar.c = null;
    }

    public final void a(CharSequence charSequence) {
        CharSequence b = this.a.g;
        if (b instanceof Spannable) {
            Spannable spannable = (Spannable) b;
            EasyEditSpan[] easyEditSpanArr = (EasyEditSpan[]) spannable.getSpans(0, spannable.length(), EasyEditSpan.class);
            for (int i = 0; i < easyEditSpanArr.length - 1; i++) {
                spannable.removeSpan(easyEditSpanArr[i]);
            }
        }
        if (this.a.getWindowVisibility() == 0 && this.a.h != null) {
            if (this.c != null) {
                if (this.a.g instanceof Spannable) {
                    ((Spannable) this.a.g).removeSpan(this.c);
                }
                this.c = null;
            }
            if (this.b != null && this.b.g()) {
                this.b.f();
            }
            if (charSequence instanceof Spanned) {
                EasyEditSpan easyEditSpan;
                Spanned spanned = (Spanned) charSequence;
                EasyEditSpan[] easyEditSpanArr2 = (EasyEditSpan[]) spanned.getSpans(0, spanned.length(), EasyEditSpan.class);
                if (easyEditSpanArr2.length == 0) {
                    easyEditSpan = null;
                } else {
                    easyEditSpan = easyEditSpanArr2[0];
                }
                this.c = easyEditSpan;
                if (this.c != null) {
                    if (this.b == null) {
                        this.b = new x(this.a);
                        this.d = new y(this);
                    }
                    this.b.a(this.c);
                    this.a.removeCallbacks(this.d);
                    this.a.postDelayed(this.d, 3000);
                }
            }
        }
    }
}
