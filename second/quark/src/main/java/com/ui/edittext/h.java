package com.ui.edittext;

import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* compiled from: ProGuard */
public interface h {
    void a(Spannable spannable);

    void a(TextView textView, Spannable spannable, int i);

    boolean a();

    boolean a(TextView textView, Spannable spannable, int i, KeyEvent keyEvent);

    boolean a(TextView textView, Spannable spannable, KeyEvent keyEvent);

    boolean a(TextView textView, Spannable spannable, MotionEvent motionEvent);

    boolean a(TextView textView, MotionEvent motionEvent);
}
