package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.c.h;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: ProGuard */
public class DialogTitle extends TextView {
    public DialogTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null) {
            int lineCount = layout.getLineCount();
            if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                setSingleLine(false);
                setMaxLines(2);
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, h.TextAppearance, 16842817, 16973892);
                lineCount = obtainStyledAttributes.getDimensionPixelSize(h.TextAppearance_android_textSize, 0);
                if (lineCount != 0) {
                    setTextSize(0, (float) lineCount);
                }
                obtainStyledAttributes.recycle();
                super.onMeasure(i, i2);
            }
        }
    }
}
