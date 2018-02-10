package com.uc.webview.browser.internal.uc;

import com.uc.webview.browser.interfaces.IAccessControl;
import com.uc.webview.browser.interfaces.ICoreStat;
import com.uc.webview.browser.interfaces.IStateChangeDispatcher;
import com.uc.webview.browser.interfaces.IUserAgent;
import com.uc.webview.browser.internal.interfaces.INotificationPermissions;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.ReflectionUtil.BindingMethod;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class a extends CoreFactory {
    protected static a a = new a();

    /* compiled from: ProGuard */
    final class a {
        final BindingMethod<IStateChangeDispatcher> a = new BindingMethod(a.Lazy.sCoreFactoryImpl, "getStateChangeDispatcher");
        final BindingMethod<ICoreStat> b = new BindingMethod(a.Lazy.sCoreFactoryImpl, "getCoreStat");
        final BindingMethod<IAccessControl> c = new BindingMethod(a.Lazy.sCoreFactoryImpl, "getAccessControl");
        final BindingMethod<IUserAgent> d = new BindingMethod(a.Lazy.sCoreFactoryImpl, "getUserAgent");
        final BindingMethod<INotificationPermissions> e;
        final BindingMethod<HashMap<String, String>> f = new BindingMethod(a.Lazy.sCoreFactoryImpl, "getBusinessInfo", new Class[]{Integer.TYPE});

        public a() {
            BindingMethod bindingMethod;
            try {
                bindingMethod = new BindingMethod(a.Lazy.sCoreFactoryImpl, "getNotificationPermissions");
            } catch (Throwable th) {
                bindingMethod = null;
            }
            this.e = bindingMethod;
        }
    }

    static {
        CoreFactory.sLazyUpdateCallback = new b();
    }

    public static IStateChangeDispatcher a() {
        return (IStateChangeDispatcher) a.a.getInstance();
    }

    public static ICoreStat b() {
        return (ICoreStat) a.b.getInstance();
    }

    public static IAccessControl c() {
        return (IAccessControl) a.c.getInstance();
    }

    public static IUserAgent d() {
        return (IUserAgent) a.d.getInstance();
    }

    public static INotificationPermissions e() {
        if (a.e == null) {
            return null;
        }
        return (INotificationPermissions) a.e.getInstance();
    }

    public static HashMap<String, String> a(int i) {
        return (HashMap) a.f.invoke(new Object[]{Integer.valueOf(i)});
    }
}
