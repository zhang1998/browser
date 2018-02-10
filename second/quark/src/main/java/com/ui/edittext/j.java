package com.ui.edittext;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ TextView a;

    j(TextView textView) {
        this.a = textView;
    }

    public final void run() {
        this.a.requestLayout();
    }
}
