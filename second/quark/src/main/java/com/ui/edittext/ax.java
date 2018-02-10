package com.ui.edittext;

import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: ProGuard */
public final class ax {
    public static void a(TextView textView, Layout layout, int i, int i2) {
        int i3;
        int i4 = 0;
        int width = textView.getWidth() - (textView.getTotalPaddingLeft() + textView.getTotalPaddingRight());
        int lineForVertical = layout.getLineForVertical(i2);
        Alignment paragraphAlignment = layout.getParagraphAlignment(lineForVertical);
        int i5 = layout.getParagraphDirection(lineForVertical) > 0 ? 1 : 0;
        if (textView.getHorizontallyScrolling()) {
            i3 = Integer.MAX_VALUE;
            while (lineForVertical <= layout.getLineForVertical((textView.getHeight() + i2) - (textView.getTotalPaddingTop() + textView.getTotalPaddingBottom()))) {
                i3 = (int) Math.min((float) i3, layout.getLineLeft(lineForVertical));
                i4 = (int) Math.max((float) i4, layout.getLineRight(lineForVertical));
                lineForVertical++;
            }
            int i6 = i4;
            i4 = i3;
            i3 = i6;
        } else {
            i3 = width;
        }
        lineForVertical = i3 - i4;
        i5 = lineForVertical < width ? paragraphAlignment == Alignment.ALIGN_CENTER ? i4 - ((width - lineForVertical) / 2) : ((i5 == 0 || paragraphAlignment != Alignment.ALIGN_OPPOSITE) && paragraphAlignment != Alignment.ALIGN_RIGHT) ? i4 : i4 - (width - lineForVertical) : Math.max(Math.min(i, i3 - width), i4);
        textView.scrollTo(i5, i2);
    }

    public static boolean a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        aw[] awVarArr;
        int scaledTouchSlop;
        switch (motionEvent.getActionMasked()) {
            case 0:
                awVarArr = (aw[]) spannable.getSpans(0, spannable.length(), aw.class);
                for (Object removeSpan : awVarArr) {
                    spannable.removeSpan(removeSpan);
                }
                spannable.setSpan(new aw(motionEvent.getX(), motionEvent.getY(), textView.getScrollX(), textView.getScrollY()), 0, 0, 17);
                return true;
            case 1:
                awVarArr = (aw[]) spannable.getSpans(0, spannable.length(), aw.class);
                for (Object removeSpan2 : awVarArr) {
                    spannable.removeSpan(removeSpan2);
                }
                if (awVarArr.length <= 0 || !awVarArr[0].f) {
                    return false;
                }
                return true;
            case 2:
                awVarArr = (aw[]) spannable.getSpans(0, spannable.length(), aw.class);
                if (awVarArr.length <= 0) {
                    return false;
                }
                if (!awVarArr[0].e) {
                    scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                    if (Math.abs(motionEvent.getX() - awVarArr[0].a) >= ((float) scaledTouchSlop) || Math.abs(motionEvent.getY() - awVarArr[0].b) >= ((float) scaledTouchSlop)) {
                        awVarArr[0].e = true;
                    }
                }
                if (!awVarArr[0].e) {
                    return false;
                }
                float x;
                float y;
                awVarArr[0].f = true;
                boolean z = ((motionEvent.getMetaState() & 1) == 0 && g.a((CharSequence) spannable, 1) != 1 && g.a((CharSequence) spannable, 2048) == 0) ? false : true;
                if (z) {
                    x = motionEvent.getX() - awVarArr[0].a;
                    y = motionEvent.getY() - awVarArr[0].b;
                } else {
                    x = awVarArr[0].a - motionEvent.getX();
                    y = awVarArr[0].b - motionEvent.getY();
                }
                awVarArr[0].a = motionEvent.getX();
                awVarArr[0].b = motionEvent.getY();
                int scrollX = textView.getScrollX() + ((int) x);
                scaledTouchSlop = ((int) y) + textView.getScrollY();
                int totalPaddingTop = textView.getTotalPaddingTop() + textView.getTotalPaddingBottom();
                Layout layout = textView.getLayout();
                scaledTouchSlop = Math.max(Math.min(scaledTouchSlop, layout.getHeight() - (textView.getHeight() - totalPaddingTop)), 0);
                int scrollX2 = textView.getScrollX();
                totalPaddingTop = textView.getScrollY();
                a(textView, layout, scrollX, scaledTouchSlop);
                if (!(scrollX2 == textView.getScrollX() && totalPaddingTop == textView.getScrollY())) {
                    textView.cancelLongPress();
                }
                return true;
            default:
                return false;
        }
    }
}
