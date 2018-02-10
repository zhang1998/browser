package com.ucpro.ui.widget.ripple;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class k {
    static List<WeakReference<ObjectAnimator>> a = new ArrayList();
    private static List<WeakReference<ObjectAnimator>> b = new ArrayList();

    public static void a(ObjectAnimator objectAnimator) {
        for (WeakReference weakReference : a) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) weakReference.get();
            if (objectAnimator2 != null) {
                Object obj;
                if (objectAnimator2 instanceof ObjectAnimator) {
                    PropertyValuesHolder[] values = objectAnimator2.getValues();
                    PropertyValuesHolder[] values2 = objectAnimator.getValues();
                    if (objectAnimator2.getTarget() == objectAnimator.getTarget() && values2.length == values.length) {
                        int length = values2.length;
                        for (int i = 0; i < length; i++) {
                            PropertyValuesHolder propertyValuesHolder = values2[i];
                            PropertyValuesHolder propertyValuesHolder2 = values[i];
                            if (propertyValuesHolder.getPropertyName() == null || !propertyValuesHolder.getPropertyName().equals(propertyValuesHolder2.getPropertyName())) {
                                obj = null;
                                break;
                            }
                        }
                        obj = 1;
                        if (obj != null) {
                            objectAnimator2.cancel();
                            b.add(weakReference);
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    objectAnimator2.cancel();
                    b.add(weakReference);
                }
            }
        }
        a.add(new WeakReference(objectAnimator));
        try {
            for (WeakReference weakReference2 : b) {
                if (a.contains(weakReference2)) {
                    a.remove(weakReference2);
                }
            }
            b.clear();
        } catch (Exception e) {
        }
        try {
            objectAnimator.start();
        } catch (Exception e2) {
            Log.e("AnimatorsCompat", "AnimatorsCompat start " + e2.toString());
            objectAnimator.cancel();
        }
    }
}
