package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.b.a;
import android.support.v4.b.a.q;
import android.support.v4.content.g;
import android.support.v4.d.b;
import android.support.v4.d.e;
import android.support.v7.c.d;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class fb {
    private static final Mode a = Mode.SRC_IN;
    private static fb b;
    private static final dt c = new dt();
    private static final int[] d = new int[]{d.abc_textfield_search_default_mtrl_alpha, d.abc_textfield_default_mtrl_alpha, d.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = new int[]{d.abc_ic_ab_back_mtrl_am_alpha, d.abc_ic_go_search_api_mtrl_alpha, d.abc_ic_search_api_mtrl_alpha, d.abc_ic_commit_search_api_mtrl_alpha, d.abc_ic_clear_mtrl_alpha, d.abc_ic_menu_share_mtrl_alpha, d.abc_ic_menu_copy_mtrl_am_alpha, d.abc_ic_menu_cut_mtrl_alpha, d.abc_ic_menu_selectall_mtrl_alpha, d.abc_ic_menu_paste_mtrl_am_alpha, d.abc_ic_menu_moreoverflow_mtrl_alpha, d.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] f = new int[]{d.abc_textfield_activated_mtrl_alpha, d.abc_textfield_search_activated_mtrl_alpha, d.abc_cab_background_top_mtrl_alpha, d.abc_text_cursor_material};
    private static final int[] g = new int[]{d.abc_popup_background_mtrl_mult, d.abc_cab_background_internal_bg, d.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = new int[]{d.abc_edit_text_material, d.abc_tab_indicator_material, d.abc_textfield_search_material, d.abc_spinner_mtrl_am_alpha, d.abc_spinner_textfield_background_material, d.abc_ratingbar_full_material, d.abc_switch_track_mtrl_alpha, d.abc_switch_thumb_material, d.abc_btn_default_mtrl_shape, d.abc_btn_borderless_material};
    private static final int[] i = new int[]{d.abc_btn_check_material, d.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> j;
    private b<String, fn> k;
    private SparseArray<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, e<WeakReference<ConstantState>>> n = new WeakHashMap(0);
    private TypedValue o;

    public static fb a() {
        if (b == null) {
            fb fbVar = new fb();
            b = fbVar;
            int i = VERSION.SDK_INT;
            if (i < 23) {
                fbVar.a("vector", new dc());
                if (i >= 11) {
                    fbVar.a("animated-vector", new fh());
                }
            }
        }
        return b;
    }

    public final Drawable a(@NonNull Context context, @DrawableRes int i, boolean z) {
        Drawable a = a(context, i);
        if (a == null) {
            if (this.o == null) {
                this.o = new TypedValue();
            }
            TypedValue typedValue = this.o;
            context.getResources().getValue(i, typedValue, true);
            long a2 = a(typedValue);
            a = a(context, a2);
            if (a == null) {
                if (i == d.abc_cab_background_top_material) {
                    a = new LayerDrawable(new Drawable[]{a(context, d.abc_cab_background_internal_bg, false), a(context, d.abc_cab_background_top_mtrl_alpha, false)});
                }
                if (a != null) {
                    a.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a2, a);
                }
            }
        }
        if (a == null) {
            a = g.a(context, i);
        }
        if (a != null) {
            a = a(context, i, z, a);
        }
        if (a != null) {
            cb.b(a);
        }
        return a;
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    final Drawable a(@NonNull Context context, @DrawableRes int i, boolean z, @NonNull Drawable drawable) {
        Mode mode = null;
        ColorStateList b = b(context, i);
        if (b != null) {
            if (cb.c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = q.f(drawable);
            q.a(drawable, b);
            if (i == d.abc_switch_thumb_material) {
                mode = Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawable;
            }
            q.a(drawable, mode);
            return drawable;
        } else if (i == d.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), dg.a(context, k.colorControlNormal), a);
            a(r0.findDrawableByLayerId(16908303), dg.a(context, k.colorControlNormal), a);
            a(r0.findDrawableByLayerId(16908301), dg.a(context, k.colorControlActivated), a);
            return drawable;
        } else if (i == d.abc_ratingbar_indicator_material || i == d.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), dg.c(context, k.colorControlNormal), a);
            a(r0.findDrawableByLayerId(16908303), dg.a(context, k.colorControlActivated), a);
            a(r0.findDrawableByLayerId(16908301), dg.a(context, k.colorControlActivated), a);
            return drawable;
        } else if (a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    final Drawable a(@NonNull Context context, @DrawableRes int i) {
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        String str;
        if (this.l != null) {
            str = (String) this.l.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.k.get(str) == null)) {
                return null;
            }
        }
        this.l = new SparseArray();
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 != null) {
            return a2;
        }
        Drawable drawable;
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                XmlPullParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                str = xml.getName();
                this.l.append(i, str);
                fn fnVar = (fn) this.k.get(str);
                if (fnVar != null) {
                    a2 = fnVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, a2);
                }
                drawable = a2;
                if (drawable == null) {
                    return drawable;
                }
                this.l.append(i, "appcompat_skip_skip");
                return drawable;
            } catch (Throwable e) {
                Log.e("AppCompatDrawableManager", "Exception while inflating drawable", e);
            }
        }
        drawable = a2;
        if (drawable == null) {
            return drawable;
        }
        this.l.append(i, "appcompat_skip_skip");
        return drawable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(@android.support.annotation.NonNull android.content.Context r7, long r8) {
        /*
        r6 = this;
        r2 = 0;
        r3 = r6.m;
        monitor-enter(r3);
        r0 = r6.n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r7);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.d.e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.a(r8);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0049;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r7.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r1 = r0.c;	 Catch:{ all -> 0x002b }
        r4 = r0.e;	 Catch:{ all -> 0x002b }
        r1 = android.support.v4.d.j.a(r1, r4, r8);	 Catch:{ all -> 0x002b }
        if (r1 < 0) goto L_0x0049;
    L_0x0038:
        r4 = r0.d;	 Catch:{ all -> 0x002b }
        r4 = r4[r1];	 Catch:{ all -> 0x002b }
        r5 = android.support.v4.d.e.a;	 Catch:{ all -> 0x002b }
        if (r4 == r5) goto L_0x0049;
    L_0x0040:
        r4 = r0.d;	 Catch:{ all -> 0x002b }
        r5 = android.support.v4.d.e.a;	 Catch:{ all -> 0x002b }
        r4[r1] = r5;	 Catch:{ all -> 0x002b }
        r1 = 1;
        r0.b = r1;	 Catch:{ all -> 0x002b }
    L_0x0049:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.fb.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean a(@NonNull Context context, long j, @NonNull Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.m) {
            e eVar = (e) this.n.get(context);
            if (eVar == null) {
                eVar = new e();
                this.n.put(context, eVar);
            }
            eVar.a(j, new WeakReference(constantState));
        }
        return true;
    }

    static boolean a(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = a;
        if (a(d, i)) {
            i2 = k.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(f, i)) {
            i2 = k.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == d.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (cb.c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(dg.a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void a(@NonNull String str, @NonNull fn fnVar) {
        if (this.k == null) {
            this.k = new b();
        }
        this.k.put(str, fnVar);
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final ColorStateList b(@NonNull Context context, @DrawableRes int i) {
        SparseArray sparseArray;
        ColorStateList colorStateList;
        if (this.j != null) {
            sparseArray = (SparseArray) this.j.get(context);
            if (sparseArray != null) {
                colorStateList = (ColorStateList) sparseArray.get(i);
            } else {
                colorStateList = null;
            }
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2;
        int[][] iArr;
        int[] iArr2;
        if (i == d.abc_edit_text_material) {
            iArr = new int[3][];
            iArr2 = new int[]{dg.a, dg.c(context, k.colorControlNormal), dg.g};
            iArr2[1] = dg.a(context, k.colorControlNormal);
            iArr[2] = dg.h;
            iArr2[2] = dg.a(context, k.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == d.abc_switch_track_mtrl_alpha) {
            iArr = new int[3][];
            iArr2 = new int[]{dg.a, dg.a(context, 16842800, 0.1f), dg.e};
            iArr2[1] = dg.a(context, k.colorControlActivated, 0.3f);
            iArr[2] = dg.h;
            iArr2[2] = dg.a(context, 16842800, 0.3f);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == d.abc_switch_thumb_material) {
            iArr = new int[3][];
            iArr2 = new int[3];
            colorStateList2 = dg.b(context, k.colorSwitchThumbNormal);
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                iArr[0] = dg.a;
                iArr2[0] = dg.c(context, k.colorSwitchThumbNormal);
                iArr[1] = dg.e;
                iArr2[1] = dg.a(context, k.colorControlActivated);
                iArr[2] = dg.h;
                iArr2[2] = dg.a(context, k.colorSwitchThumbNormal);
            } else {
                iArr[0] = dg.a;
                iArr2[0] = colorStateList2.getColorForState(iArr[0], 0);
                iArr[1] = dg.e;
                iArr2[1] = dg.a(context, k.colorControlActivated);
                iArr[2] = dg.h;
                iArr2[2] = colorStateList2.getDefaultColor();
            }
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == d.abc_btn_default_mtrl_shape) {
            colorStateList2 = c(context, dg.a(context, k.colorButtonNormal));
        } else if (i == d.abc_btn_borderless_material) {
            colorStateList2 = c(context, 0);
        } else if (i == d.abc_btn_colored_material) {
            colorStateList2 = c(context, dg.a(context, k.colorAccent));
        } else if (i == d.abc_spinner_mtrl_am_alpha || i == d.abc_spinner_textfield_background_material) {
            iArr = new int[3][];
            iArr2 = new int[]{dg.a, dg.c(context, k.colorControlNormal), dg.g};
            iArr2[1] = dg.a(context, k.colorControlNormal);
            iArr[2] = dg.h;
            iArr2[2] = dg.a(context, k.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (a(e, i)) {
            colorStateList2 = dg.b(context, k.colorControlNormal);
        } else if (a(h, i)) {
            int a = dg.a(context, k.colorControlNormal);
            int a2 = dg.a(context, k.colorControlActivated);
            r2 = new int[7][];
            int[] iArr3 = new int[]{dg.a, dg.c(context, k.colorControlNormal), dg.b, a2, dg.c, a2, dg.d};
            iArr3[3] = a2;
            r2[4] = dg.e;
            iArr3[4] = a2;
            r2[5] = dg.f;
            iArr3[5] = a2;
            r2[6] = dg.h;
            iArr3[6] = a;
            colorStateList2 = new ColorStateList(r2, iArr3);
        } else if (a(i, i)) {
            iArr = new int[3][];
            iArr2 = new int[]{dg.a, dg.c(context, k.colorControlNormal), dg.e};
            iArr2[1] = dg.a(context, k.colorControlActivated);
            iArr[2] = dg.h;
            iArr2[2] = dg.a(context, k.colorControlNormal);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == d.abc_seekbar_thumb_material) {
            iArr = new int[2][];
            iArr2 = new int[]{dg.a, dg.c(context, k.colorControlActivated)};
            iArr[1] = dg.h;
            iArr2[1] = dg.a(context, k.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else {
            colorStateList2 = colorStateList;
        }
        if (colorStateList2 != null) {
            if (this.j == null) {
                this.j = new WeakHashMap();
            }
            sparseArray = (SparseArray) this.j.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.j.put(context, sparseArray);
            }
            sparseArray.append(i, colorStateList2);
        }
        return colorStateList2;
    }

    private static ColorStateList c(Context context, @ColorInt int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = dg.a(context, k.colorControlHighlight);
        r0[0] = dg.a;
        r1[0] = dg.c(context, k.colorButtonNormal);
        r0[1] = dg.d;
        r1[1] = a.a(a, i);
        r0[2] = dg.b;
        r1[2] = a.a(a, i);
        r0[3] = dg.h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    public static void a(Drawable drawable, dl dlVar, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!cb.c(drawable) || drawable.mutate() == drawable) {
            if (dlVar.d || dlVar.c) {
                ColorStateList colorStateList;
                Mode mode;
                if (dlVar.d) {
                    colorStateList = dlVar.a;
                } else {
                    colorStateList = null;
                }
                if (dlVar.c) {
                    mode = dlVar.b;
                } else {
                    mode = a;
                }
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(colorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    private static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) c.a((Object) Integer.valueOf(dt.a(i, mode)));
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        c.a(Integer.valueOf(dt.a(i, mode)), porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (cb.c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i, mode));
    }
}
