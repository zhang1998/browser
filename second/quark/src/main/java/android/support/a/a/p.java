package android.support.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.b.a.q;
import android.support.v4.d.b;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* compiled from: ProGuard */
public final class p extends j implements Animatable {
    private o a;
    private Context b;
    private ArgbEvaluator c;
    private final Callback e;

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private p() {
        this(null, (byte) 0);
    }

    private p(@Nullable Context context) {
        this(context, (byte) 0);
    }

    private p(@Nullable Context context, @Nullable byte b) {
        this.c = null;
        this.e = new r(this);
        this.b = context;
        this.a = new o();
    }

    public final Drawable mutate() {
        if (this.d != null) {
            this.d.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static p a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        p pVar = new p(context);
        pVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return pVar;
    }

    public final ConstantState getConstantState() {
        if (this.d != null) {
            return new q(this.d.getConstantState());
        }
        return null;
    }

    public final int getChangingConfigurations() {
        if (this.d != null) {
            return this.d.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.a.a;
    }

    public final void draw(Canvas canvas) {
        if (this.d != null) {
            this.d.draw(canvas);
            return;
        }
        this.a.b.draw(canvas);
        if (a()) {
            invalidateSelf();
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        } else {
            this.a.b.setBounds(rect);
        }
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.d != null) {
            return this.d.setState(iArr);
        }
        return this.a.b.setState(iArr);
    }

    protected final boolean onLevelChange(int i) {
        if (this.d != null) {
            return this.d.setLevel(i);
        }
        return this.a.b.setLevel(i);
    }

    public final int getAlpha() {
        if (this.d != null) {
            return q.c(this.d);
        }
        return this.a.b.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.d != null) {
            this.d.setAlpha(i);
        } else {
            this.a.b.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.d != null) {
            this.d.setColorFilter(colorFilter);
        } else {
            this.a.b.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.d != null) {
            q.a(this.d, i);
        } else {
            this.a.b.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.d != null) {
            q.a(this.d, colorStateList);
        } else {
            this.a.b.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.d != null) {
            q.a(this.d, mode);
        } else {
            this.a.b.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.d != null) {
            return this.d.setVisible(z, z2);
        }
        this.a.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.d != null) {
            return this.d.isStateful();
        }
        return this.a.b.isStateful();
    }

    public final int getOpacity() {
        if (this.d != null) {
            return this.d.getOpacity();
        }
        return this.a.b.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.d != null) {
            return this.d.getIntrinsicWidth();
        }
        return this.a.b.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.d != null) {
            return this.d.getIntrinsicHeight();
        }
        return this.a.b.getIntrinsicHeight();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.d != null) {
            q.a(this.d, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray obtainAttributes;
                if ("animated-vector".equals(name)) {
                    int[] iArr = n.e;
                    if (theme == null) {
                        obtainAttributes = resources.obtainAttributes(attributeSet, iArr);
                    } else {
                        obtainAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                    }
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        c a = c.a(resources, resourceId, theme);
                        a.c = false;
                        a.setCallback(this.e);
                        if (this.a.b != null) {
                            this.a.b.setCallback(null);
                        }
                        this.a.b = a;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, n.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.b != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.b, resourceId2);
                            loadAnimator.setTarget(this.a.b.b.b.i.get(string));
                            if (VERSION.SDK_INT < 21) {
                                a(loadAnimator);
                            }
                            if (this.a.c == null) {
                                this.a.c = new ArrayList();
                                this.a.d = new b();
                            }
                            this.a.c.add(loadAnimator);
                            this.a.d.put(loadAnimator, string);
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.d != null) {
            q.a(this.d, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.d != null) {
            return q.d(this.d);
        }
        return false;
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.c == null) {
                    this.c = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.c);
            }
        }
    }

    public final boolean isRunning() {
        if (this.d != null) {
            return ((AnimatedVectorDrawable) this.d).isRunning();
        }
        ArrayList arrayList = this.a.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean a() {
        ArrayList arrayList = this.a.c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        if (this.d != null) {
            ((AnimatedVectorDrawable) this.d).start();
        } else if (!a()) {
            ArrayList arrayList = this.a.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.d != null) {
            ((AnimatedVectorDrawable) this.d).stop();
            return;
        }
        ArrayList arrayList = this.a.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
