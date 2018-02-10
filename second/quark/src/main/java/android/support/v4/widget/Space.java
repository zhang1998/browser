package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class Space extends View {
    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context) {
        this(context, null);
    }

    public void draw(Canvas canvas) {
    }

    private static int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case SectionHeader.SHT_LOUSER /*-2147483648*/:
                return Math.min(i, size);
            case UCCore.VERIFY_POLICY_QUICK /*1073741824*/:
                return size;
            default:
                return i;
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i), a(getSuggestedMinimumHeight(), i2));
    }
}
