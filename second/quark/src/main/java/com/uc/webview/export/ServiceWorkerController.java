package com.uc.webview.export;

import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IServiceWorkerController;
import java.util.HashMap;

@Api
/* compiled from: ProGuard */
public class ServiceWorkerController {
    private static HashMap<Integer, ServiceWorkerController> a;
    private IServiceWorkerController b;

    private ServiceWorkerController(IServiceWorkerController iServiceWorkerController) {
        this.b = iServiceWorkerController;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public static ServiceWorkerController getInstance() {
        return a(((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue());
    }

    public static ServiceWorkerController getInstance(WebView webView) {
        return a(webView.getCurrentViewCoreType());
    }

    private static synchronized ServiceWorkerController a(int i) throws RuntimeException {
        ServiceWorkerController serviceWorkerController;
        synchronized (ServiceWorkerController.class) {
            if (a == null) {
                a = new HashMap();
            }
            serviceWorkerController = (ServiceWorkerController) a.get(Integer.valueOf(i));
            if (serviceWorkerController == null) {
                ServiceWorkerController serviceWorkerController2 = new ServiceWorkerController((IServiceWorkerController) SDKFactory.invoke(10054, Integer.valueOf(i)));
                a.put(Integer.valueOf(i), serviceWorkerController2);
                serviceWorkerController = serviceWorkerController2;
            }
        }
        return serviceWorkerController;
    }

    public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
        return this.b.getServiceWorkerWebSettings();
    }

    public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
        this.b.setServiceWorkerClient(serviceWorkerClient);
    }
}
