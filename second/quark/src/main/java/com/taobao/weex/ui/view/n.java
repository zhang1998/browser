package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.taobao.weex.ui.component.ao;
import com.taobao.weex.ui.component.ap;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: ProGuard */
public class n extends ImageView implements ao, a<ap>, c {
    private WeakReference<ap> a;
    private b b;
    private float[] c;
    private boolean d;

    public n(Context context) {
        super(context);
    }

    public void setImageResource(int i) {
        setImageDrawable(getResources().getDrawable(i));
    }

    private void a(@Nullable Drawable drawable, boolean z) {
        this.d = z;
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            Drawable a = h.a(drawable, getScaleType(), (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom(), z);
            if (a instanceof h) {
                h hVar = (h) a;
                if (!Arrays.equals(hVar.a, this.c)) {
                    hVar.setCornerRadii(this.c);
                }
            }
            super.setImageDrawable(a);
            if (this.a != null) {
                ap apVar = (ap) this.a.get();
                if (apVar != null) {
                    apVar.readyToRender();
                }
            }
        }
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        a(drawable, false);
    }

    public void setImageBitmap(@Nullable Bitmap bitmap) {
        setImageDrawable(bitmap == null ? null : new BitmapDrawable(getResources(), bitmap));
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.b != null) {
            return onTouchEvent | this.b.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void setBorderRadius(@NonNull float[] fArr) {
        this.c = fArr;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getDrawable(), this.d);
        }
    }

    public final void a(ap apVar) {
        this.a = new WeakReference(apVar);
    }

    @Nullable
    public ap getComponent() {
        return this.a != null ? (ap) this.a.get() : null;
    }

    public int getNaturalWidth() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof h) {
                return ((h) drawable).c;
            }
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getWidth();
                }
                WXLogUtils.w("WXImageView", "Bitmap on " + drawable.toString() + " is null");
            } else {
                WXLogUtils.w("WXImageView", "Not supported drawable type: " + drawable.getClass().getSimpleName());
            }
        }
        return -1;
    }

    public int getNaturalHeight() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof h) {
                return ((h) drawable).b;
            }
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getHeight();
                }
                WXLogUtils.w("WXImageView", "Bitmap on " + drawable.toString() + " is null");
            } else {
                WXLogUtils.w("WXImageView", "Not supported drawable type: " + drawable.getClass().getSimpleName());
            }
        }
        return -1;
    }
}
