package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.g;
import android.support.v4.view.e;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.support.v7.c.l;
import android.support.v7.view.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public class AppCompatSpinner extends Spinner implements e {
    private static final boolean a;
    private static final boolean b;
    private static final int[] c = new int[]{16843505};
    private fb d;
    private fc e;
    private Context f;
    private fm g;
    private SpinnerAdapter h;
    private boolean i;
    private ej j;
    private int k;
    private final Rect l;

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        a = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        b = z;
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        Context aVar;
        AppCompatSpinner appCompatSpinner;
        ej ejVar;
        dh a;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        Throwable th;
        TypedArray typedArray = null;
        super(context, attributeSet, i);
        this.l = new Rect();
        dh a2 = dh.a(context, attributeSet, h.Spinner, i);
        this.d = fb.a();
        this.e = new fc(this, this.d);
        int e = a2.e(h.Spinner_popupTheme, 0);
        if (e != 0) {
            aVar = new a(context, e);
            appCompatSpinner = this;
        } else if (a) {
            aVar = null;
            appCompatSpinner = this;
        } else {
            aVar = context;
            appCompatSpinner = this;
        }
        appCompatSpinner.f = aVar;
        if (this.f != null) {
            if (VERSION.SDK_INT >= 11) {
                TypedArray obtainStyledAttributes;
                try {
                    obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, i, 0);
                    try {
                        if (obtainStyledAttributes.hasValue(0)) {
                            i2 = obtainStyledAttributes.getInt(0, 0);
                        }
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception e2) {
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            ejVar = new ej(this, this.f, attributeSet, i);
                            a = dh.a(this.f, attributeSet, h.Spinner, i);
                            this.k = a.d(h.Spinner_android_dropDownWidth, -2);
                            ejVar.a(a.a(h.Spinner_android_popupBackground));
                            ejVar.l = a2.a.getString(h.Spinner_android_prompt);
                            a.a.recycle();
                            this.j = ejVar;
                            this.g = new cw(this, this, ejVar);
                        }
                        textArray = a2.a.getTextArray(h.Spinner_android_entries);
                        if (textArray != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                            arrayAdapter.setDropDownViewResource(l.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.a.recycle();
                        this.i = true;
                        if (this.h != null) {
                            setAdapter(this.h);
                            this.h = null;
                        }
                        this.e.a(attributeSet, i);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        typedArray = obtainStyledAttributes;
                        th = th3;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    if (i2 == 1) {
                        ejVar = new ej(this, this.f, attributeSet, i);
                        a = dh.a(this.f, attributeSet, h.Spinner, i);
                        this.k = a.d(h.Spinner_android_dropDownWidth, -2);
                        ejVar.a(a.a(h.Spinner_android_popupBackground));
                        ejVar.l = a2.a.getString(h.Spinner_android_prompt);
                        a.a.recycle();
                        this.j = ejVar;
                        this.g = new cw(this, this, ejVar);
                    }
                    textArray = a2.a.getTextArray(h.Spinner_android_entries);
                    if (textArray != null) {
                        arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                        arrayAdapter.setDropDownViewResource(l.support_simple_spinner_dropdown_item);
                        setAdapter(arrayAdapter);
                    }
                    a2.a.recycle();
                    this.i = true;
                    if (this.h != null) {
                        setAdapter(this.h);
                        this.h = null;
                    }
                    this.e.a(attributeSet, i);
                } catch (Throwable th4) {
                    th = th4;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            i2 = 1;
            if (i2 == 1) {
                ejVar = new ej(this, this.f, attributeSet, i);
                a = dh.a(this.f, attributeSet, h.Spinner, i);
                this.k = a.d(h.Spinner_android_dropDownWidth, -2);
                ejVar.a(a.a(h.Spinner_android_popupBackground));
                ejVar.l = a2.a.getString(h.Spinner_android_prompt);
                a.a.recycle();
                this.j = ejVar;
                this.g = new cw(this, this, ejVar);
            }
        }
        textArray = a2.a.getTextArray(h.Spinner_android_entries);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(l.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.a.recycle();
        this.i = true;
        if (this.h != null) {
            setAdapter(this.h);
            this.h = null;
        }
        this.e.a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.j != null) {
            return this.f;
        }
        if (a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
        } else if (b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(g.a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.j != null) {
            return this.j.a.getBackground();
        }
        if (b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.j != null) {
            ListPopupWindow listPopupWindow = this.j;
            listPopupWindow.e = i;
            listPopupWindow.f = true;
        } else if (b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.j != null) {
            ListPopupWindow listPopupWindow = this.j;
            if (listPopupWindow.f) {
                return listPopupWindow.e;
            }
            return 0;
        } else if (b) {
            return super.getDropDownVerticalOffset();
        } else {
            return 0;
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.j != null) {
            this.j.d = i;
        } else if (b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.j != null) {
            return this.j.d;
        }
        if (b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.j != null) {
            this.k = i;
        } else if (b) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.j != null) {
            return this.k;
        }
        if (b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.i) {
            super.setAdapter(spinnerAdapter);
            if (this.j != null) {
                this.j.a(new ex(spinnerAdapter, (this.f == null ? getContext() : this.f).getTheme()));
                return;
            }
            return;
        }
        this.h = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null && this.j.a.isShowing()) {
            this.j.c();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g == null || !this.g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j != null && MeasureSpec.getMode(i) == SectionHeader.SHT_LOUSER) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.j == null) {
            return super.performClick();
        }
        if (!this.j.a.isShowing()) {
            this.j.b();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.j != null) {
            this.j.l = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        if (this.j != null) {
            return this.j.l;
        }
        return super.getPrompt();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.e != null) {
            this.e.b(null);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.e != null) {
            this.e.a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return this.e != null ? this.e.a() : null;
    }

    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.e != null) {
            this.e.a(mode);
        }
    }

    @Nullable
    public Mode getSupportBackgroundTintMode() {
        return this.e != null ? this.e.b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.c();
        }
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.l);
        return (this.l.left + this.l.right) + i;
    }
}
