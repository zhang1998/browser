package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.s;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.view.a;
import android.support.v7.view.d;
import android.support.v7.view.h;
import android.support.v7.view.m;
import android.support.v7.view.n;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ViewStubCompat;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Window.Callback;
import android.widget.PopupWindow;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
class ab extends m {
    final /* synthetic */ o c;

    ab(o oVar, Callback callback) {
        this.c = oVar;
        super(oVar, callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (this.c.g) {
            return a(callback);
        }
        return super.onWindowStartingActionMode(callback);
    }

    final ActionMode a(ActionMode.Callback callback) {
        Object mVar = new m(this.c.i, callback);
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.c;
        if (appCompatDelegateImplV7.a != null) {
            appCompatDelegateImplV7.a.c();
        }
        d dVar = new d(appCompatDelegateImplV7, mVar);
        ActionBar j = appCompatDelegateImplV7.j();
        if (j != null) {
            appCompatDelegateImplV7.a = j.a(dVar);
        }
        if (appCompatDelegateImplV7.a == null) {
            appCompatDelegateImplV7.g();
            if (appCompatDelegateImplV7.a != null) {
                appCompatDelegateImplV7.a.c();
            }
            d dVar2 = new d(appCompatDelegateImplV7, dVar);
            if (appCompatDelegateImplV7.b == null) {
                if (appCompatDelegateImplV7.s) {
                    Context aVar;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = appCompatDelegateImplV7.i.getTheme();
                    theme.resolveAttribute(k.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = appCompatDelegateImplV7.i.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        aVar = new a(appCompatDelegateImplV7.i, 0);
                        aVar.getTheme().setTo(newTheme);
                    } else {
                        aVar = appCompatDelegateImplV7.i;
                    }
                    appCompatDelegateImplV7.b = new ActionBarContextView(aVar);
                    appCompatDelegateImplV7.c = new PopupWindow(aVar, null, k.actionModePopupWindowStyle);
                    s.a(appCompatDelegateImplV7.c, 2);
                    appCompatDelegateImplV7.c.setContentView(appCompatDelegateImplV7.b);
                    appCompatDelegateImplV7.c.setWidth(-1);
                    aVar.getTheme().resolveAttribute(k.actionBarSize, typedValue, true);
                    appCompatDelegateImplV7.b.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, aVar.getResources().getDisplayMetrics()));
                    appCompatDelegateImplV7.c.setHeight(-2);
                    appCompatDelegateImplV7.d = new ay(appCompatDelegateImplV7);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImplV7.f.findViewById(j.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(appCompatDelegateImplV7.m()));
                        appCompatDelegateImplV7.b = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (appCompatDelegateImplV7.b != null) {
                boolean z;
                appCompatDelegateImplV7.g();
                appCompatDelegateImplV7.b.a();
                Context context = appCompatDelegateImplV7.b.getContext();
                ActionBarContextView actionBarContextView = appCompatDelegateImplV7.b;
                if (appCompatDelegateImplV7.c == null) {
                    z = true;
                } else {
                    z = false;
                }
                h nVar = new n(context, actionBarContextView, dVar2, z);
                if (dVar.a(nVar, nVar.d())) {
                    nVar.b();
                    appCompatDelegateImplV7.b.a(nVar);
                    appCompatDelegateImplV7.a = nVar;
                    ViewCompat.c(appCompatDelegateImplV7.b, 0.0f);
                    appCompatDelegateImplV7.e = ViewCompat.q(appCompatDelegateImplV7.b).a((float) IPictureView.DEFAULT_MIN_SCALE);
                    appCompatDelegateImplV7.e.a(new am(appCompatDelegateImplV7));
                    if (appCompatDelegateImplV7.c != null) {
                        appCompatDelegateImplV7.j.getDecorView().post(appCompatDelegateImplV7.d);
                    }
                } else {
                    appCompatDelegateImplV7.a = null;
                }
            }
            appCompatDelegateImplV7.a = appCompatDelegateImplV7.a;
        }
        h hVar = appCompatDelegateImplV7.a;
        if (hVar != null) {
            return mVar.b(hVar);
        }
        return null;
    }
}
