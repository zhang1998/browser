package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.Settings.Global;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.BaseSavedState;
import com.uc.imagecodec.export.IPictureView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class LottieAnimationView extends AppCompatImageView {
    private static final String b = LottieAnimationView.class.getSimpleName();
    private static final Map<String, k> c = new HashMap();
    private static final Map<String, WeakReference<k>> d = new HashMap();
    public final cu a = new cu();
    private final t e = new ad(this);
    private int f;
    private String g;
    private boolean h = false;
    private boolean i = false;
    @Nullable
    private c j;
    @Nullable
    private k k;

    /* compiled from: ProGuard */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new di();
        String a;
        float b;
        boolean c;
        boolean d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            super(parcel);
            this.a = parcel.readString();
            this.b = parcel.readFloat();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.d = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeFloat(this.b);
            if (this.c) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.d) {
                i3 = 0;
            }
            parcel.writeInt(i3);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        a(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, dx.LottieAnimationView);
        String string = obtainStyledAttributes.getString(dx.LottieAnimationView_lottie_fileName);
        if (!(isInEditMode() || string == null)) {
            setAnimation(string);
        }
        if (obtainStyledAttributes.getBoolean(dx.LottieAnimationView_lottie_autoPlay, false)) {
            this.a.b(false);
            this.i = true;
        }
        this.a.a(obtainStyledAttributes.getBoolean(dx.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(dx.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(dx.LottieAnimationView_lottie_progress, 0.0f));
        boolean z = obtainStyledAttributes.getBoolean(dx.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        cu cuVar = this.a;
        if (VERSION.SDK_INT < 19) {
            Log.w(cu.a, "Merge paths are not supported pre-Kit Kat.");
        } else {
            cuVar.m = z;
            if (cuVar.b != null) {
                cuVar.b();
            }
        }
        int i = obtainStyledAttributes.getInt(dx.LottieAnimationView_lottie_cacheStrategy, at.a - 1);
        obtainStyledAttributes.recycle();
        this.f = at.a()[i];
        try {
            if (VERSION.SDK_INT >= 17 && Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", IPictureView.DEFAULT_MIN_SCALE) == 0.0f) {
                this.a.l = true;
            }
        } catch (Throwable th) {
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        g();
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.a) {
            g();
        }
        super.setImageDrawable(drawable);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.a) {
            super.invalidateDrawable(this.a);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected Parcelable onSaveInstanceState() {
        boolean z;
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.g;
        savedState.b = this.a.f;
        savedState.c = this.a.c.isRunning();
        if (this.a.c.getRepeatCount() == -1) {
            z = true;
        } else {
            z = false;
        }
        savedState.d = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.g = savedState.a;
            if (!TextUtils.isEmpty(this.g)) {
                setAnimation(this.g);
            }
            setProgress(savedState.b);
            a(savedState.d);
            if (savedState.c) {
                b();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.h) {
            b();
        }
    }

    @VisibleForTesting
    private void g() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void setAnimation(String str) {
        int i = this.f;
        this.g = str;
        if (d.containsKey(str)) {
            WeakReference weakReference = (WeakReference) d.get(str);
            if (weakReference.get() != null) {
                setComposition((k) weakReference.get());
                return;
            }
        } else if (c.containsKey(str)) {
            setComposition((k) c.get(str));
            return;
        }
        this.g = str;
        this.a.d();
        h();
        this.j = ds.a(getContext(), str, new ca(this, i, str));
    }

    public void setAnimation(JSONObject jSONObject) {
        h();
        this.j = ds.a(getResources(), jSONObject, this.e);
    }

    public final void a(JSONObject jSONObject, int i) {
        h();
        this.j = ds.a(getResources(), jSONObject, this.e, i);
    }

    private void h() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
    }

    public void setComposition(@NonNull k kVar) {
        this.a.setCallback(this);
        cu cuVar = this.a;
        if (cuVar.getCallback() == null) {
            throw new IllegalStateException("You or your view must set a Drawable.Callback before setting the composition. This gets done automatically when added to an ImageView. Either call ImageView.setImageDrawable() before setComposition() or call setCallback(yourView.getCallback()) first.");
        }
        boolean z;
        if (cuVar.b == kVar) {
            z = false;
        } else {
            cuVar.a();
            cuVar.n = null;
            cuVar.g = null;
            cuVar.invalidateSelf();
            cuVar.b = kVar;
            cuVar.a(cuVar.d);
            cuVar.c(IPictureView.DEFAULT_MIN_SCALE);
            cuVar.c();
            cuVar.b();
            cuVar.b(cuVar.f);
            if (cuVar.j) {
                cuVar.j = false;
                cuVar.b(false);
            }
            if (cuVar.k) {
                cuVar.k = false;
                if (cuVar.n == null) {
                    cuVar.j = false;
                    cuVar.k = true;
                } else {
                    cuVar.c.reverse();
                }
            }
            z = true;
        }
        if (z) {
            int a = dn.a(getContext());
            int b = dn.b(getContext());
            int width = kVar.e.width();
            int height = kVar.e.height();
            if (width > a || height > b) {
                setScale(Math.min(((float) a) / ((float) width), ((float) b) / ((float) height)));
                Log.w("LOTTIE", String.format("Composition larger than the screen %dx%d vs %dx%d. Scaling down.", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(a), Integer.valueOf(b)}));
            }
            setImageDrawable(null);
            setImageDrawable(this.a);
            this.k = kVar;
            requestLayout();
        }
    }

    @Nullable
    public k getComposition() {
        return this.k;
    }

    public void setImageAssetsFolder(String str) {
        this.a.h = str;
    }

    public final void a(AnimatorListener animatorListener) {
        this.a.c.addListener(animatorListener);
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public void setRepeatCount(int i) {
        this.a.c.setRepeatCount(i);
    }

    public final boolean a() {
        return this.a.c.isRunning();
    }

    public void b() {
        this.a.b(false);
    }

    public void c() {
        this.a.b(true);
    }

    public void setSpeed(float f) {
        this.a.a(f);
    }

    public void setImageAssetDelegate(bz bzVar) {
        cu cuVar = this.a;
        cuVar.i = bzVar;
        if (cuVar.g != null) {
            cuVar.g.b = bzVar;
        }
    }

    void setScale(float f) {
        this.a.c(f);
        if (getDrawable() == this.a) {
            setImageDrawable(null);
            setImageDrawable(this.a);
        }
    }

    public final void d() {
        float progress = getProgress();
        this.a.d();
        setProgress(progress);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.a.b(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.a.f;
    }

    public long getDuration() {
        return this.k != null ? this.k.a() : 0;
    }

    protected void onDetachedFromWindow() {
        if (this.a.c.isRunning()) {
            this.a.d();
            this.h = true;
        }
        g();
        super.onDetachedFromWindow();
    }
}
