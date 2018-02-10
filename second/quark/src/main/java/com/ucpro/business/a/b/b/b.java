package com.ucpro.business.a.b.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.ImageView;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.h;

/* compiled from: ProGuard */
public final class b extends ImageView implements c {
    public String a;
    public String b;
    public Bitmap c;
    public int d;
    public int e;
    public int f;

    public b(Context context) {
        super(context);
    }

    public final void a() {
        if (a.b()) {
            if (!TextUtils.isEmpty(this.b)) {
                setImageBitmap(this.b);
            } else if (!TextUtils.isEmpty(this.a)) {
                setImageBitmap(this.a);
            }
        } else if (!TextUtils.isEmpty(this.a)) {
            setImageBitmap(this.a);
        }
    }

    public final boolean b() {
        return getBitmap() != null;
    }

    private void setImageBitmap(String str) {
        Options options = new Options();
        options.inDensity = 480;
        this.c = BitmapFactory.decodeFile(str, options);
        setImageBitmap(this.c);
    }

    public final String getImagePath() {
        return this.a;
    }

    public final void setImagePath(String str) {
        this.a = str;
    }

    public final String getImageNightPath() {
        return this.b;
    }

    public final void setImageNightPath(String str) {
        this.b = str;
    }

    public final void a(int i, int i2) {
        this.d = h.a(i);
        this.e = h.a(i2);
    }

    public final void setInsetBottom(int i) {
        if (i != -1) {
            i = h.a(i);
        }
        this.f = i;
    }

    public final int getInsetBottom() {
        return this.f;
    }

    public final Bitmap getBitmap() {
        return this.c;
    }

    protected final void onMeasure(int i, int i2) {
        if (this.d == 0 || this.e == 0) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(this.d, this.e);
        }
    }
}
