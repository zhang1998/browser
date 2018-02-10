package com.ui.edittext;

import android.os.Handler;
import android.os.Message;
import com.uc.imagecodec.export.IPictureView;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class ah extends Handler {
    byte a = (byte) 0;
    float b;
    float c;
    float d;
    float e;
    float f;
    private final WeakReference<TextView> g;
    private final float h;
    private float i;
    private int j;

    ah(TextView textView) {
        this.h = (textView.getContext().getResources().getDisplayMetrics().density * 30.0f) / 33.0f;
        this.g = new WeakReference(textView);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a = (byte) 2;
                c();
                return;
            case 2:
                c();
                return;
            case 3:
                if (this.a == (byte) 2) {
                    if (this.j >= 0) {
                        this.j--;
                    }
                    a(this.j);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void c() {
        if (this.a == (byte) 2) {
            removeMessages(2);
            TextView textView = (TextView) this.g.get();
            if (textView == null) {
                return;
            }
            if (textView.isFocused() || textView.isSelected()) {
                this.f += this.h;
                if (this.f > this.i) {
                    this.f = this.i;
                    sendEmptyMessageDelayed(3, 1200);
                } else {
                    sendEmptyMessageDelayed(2, 33);
                }
                textView.invalidate();
            }
        }
    }

    final void a() {
        this.a = (byte) 0;
        removeMessages(1);
        removeMessages(3);
        removeMessages(2);
        this.f = 0.0f;
        TextView textView = (TextView) this.g.get();
        if (textView != null) {
            textView.invalidate();
        }
    }

    final void a(int i) {
        if (i == 0) {
            a();
            return;
        }
        this.j = i;
        TextView textView = (TextView) this.g.get();
        if (textView != null && textView.h != null) {
            this.a = (byte) 1;
            this.f = 0.0f;
            int width = (textView.getWidth() - textView.getCompoundPaddingLeft()) - textView.getCompoundPaddingRight();
            float lineWidth = textView.h.getLineWidth(0);
            float f = ((float) width) / IPictureView.DEFAULT_MAX_SCALE;
            this.c = (lineWidth - ((float) width)) + f;
            this.i = this.c + ((float) width);
            this.d = f + lineWidth;
            this.e = (((float) width) / 6.0f) + lineWidth;
            this.b = (this.c + lineWidth) + lineWidth;
            textView.invalidate();
            sendEmptyMessageDelayed(1, 1200);
        }
    }

    final boolean b() {
        return this.a == (byte) 0;
    }
}
