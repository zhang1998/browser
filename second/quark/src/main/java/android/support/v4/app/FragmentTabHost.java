package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<bd> a = new ArrayList();
    private Context b;
    private be c;
    private int d;
    private OnTabChangeListener e;
    private bd f;
    private boolean g;

    /* compiled from: ProGuard */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ag();
        String a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        ay ayVar = null;
        for (int i = 0; i < this.a.size(); i++) {
            bd bdVar = (bd) this.a.get(i);
            bdVar.d = this.c.a(bdVar.a);
            if (!(bdVar.d == null || bdVar.d.E)) {
                if (bdVar.a.equals(currentTabTag)) {
                    this.f = bdVar;
                } else {
                    if (ayVar == null) {
                        ayVar = this.c.a();
                    }
                    ayVar.a(bdVar.d);
                }
            }
        }
        this.g = true;
        ay a = a(currentTabTag, ayVar);
        if (a != null) {
            a.a();
            this.c.b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.a);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.g) {
            ay a = a(str, null);
            if (a != null) {
                a.a();
            }
        }
        if (this.e != null) {
            this.e.onTabChanged(str);
        }
    }

    private ay a(String str, ay ayVar) {
        bd bdVar = null;
        int i = 0;
        while (i < this.a.size()) {
            bd bdVar2 = (bd) this.a.get(i);
            if (!bdVar2.a.equals(str)) {
                bdVar2 = bdVar;
            }
            i++;
            bdVar = bdVar2;
        }
        if (bdVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f != bdVar) {
            if (ayVar == null) {
                ayVar = this.c.a();
            }
            if (!(this.f == null || this.f.d == null)) {
                ayVar.a(this.f.d);
            }
            if (bdVar != null) {
                if (bdVar.d == null) {
                    bdVar.d = Fragment.a(this.b, bdVar.b.getName(), bdVar.c);
                    ayVar.a(this.d, bdVar.d, bdVar.a);
                } else {
                    ayVar.b(bdVar.d);
                }
            }
            this.f = bdVar;
        }
        return ayVar;
    }
}
