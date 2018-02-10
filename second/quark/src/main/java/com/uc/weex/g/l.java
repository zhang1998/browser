package com.uc.weex.g;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.common.o;
import com.uc.apollo.android.GuideDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class l extends o {
    private SensorManager a = null;
    private Sensor d = null;
    private Sensor e = null;
    private Sensor f = null;
    private Sensor g = null;
    private Sensor h = null;
    private Sensor i = null;
    private List<k> j = new ArrayList();
    private List<j> k = new ArrayList();

    private void a() {
        if (this.a == null) {
            this.a = (SensorManager) this.b.b().getSystemService("sensor");
        }
    }

    @JSMethod(uiThread = false)
    public void watchOrientation(String str, c cVar, c cVar2) {
        int i;
        double d = 83.0d;
        double d2 = 16.7d;
        try {
            double optDouble = new JSONObject(str).optDouble("interval", 83.0d);
            if (optDouble >= 16.7d) {
                d2 = optDouble;
            }
            d = d2;
        } catch (JSONException e) {
        }
        if (d < 50.0d) {
            i = 0;
        } else if (d < 100.0d) {
            i = 1;
        } else {
            i = 3;
        }
        a();
        Sensor defaultSensor = this.a.getDefaultSensor(-1);
        SensorEventListener kVar = new k(this, cVar, i, d);
        this.a.registerListener(kVar, defaultSensor, 3);
        this.d = this.a.getDefaultSensor(1);
        this.e = this.a.getDefaultSensor(2);
        this.f = this.a.getDefaultSensor(3);
        if (this.a.registerListener(kVar, this.d, i)) {
            this.a.registerListener(kVar, this.e, i);
            this.a.registerListener(kVar, this.f, i);
            return;
        }
        a(kVar, cVar2);
    }

    @JSMethod(uiThread = false)
    public void stopOrientation() {
        for (SensorEventListener unregisterListener : this.j) {
            this.a.unregisterListener(unregisterListener);
        }
        this.j.clear();
    }

    @JSMethod(uiThread = false)
    public void watchAcceleration(String str, c cVar, c cVar2) {
        double d = 83.0d;
        double d2 = 16.7d;
        try {
            double optDouble = new JSONObject(str).optDouble("interval", 83.0d);
            if (optDouble >= 16.7d) {
                d2 = optDouble;
            }
            d = d2;
        } catch (JSONException e) {
        }
        int i = 3;
        if (d < 50.0d) {
            i = 0;
        } else if (d < 100.0d) {
            i = 1;
        }
        a();
        SensorEventListener jVar = new j(this, cVar, i, d);
        this.g = this.a.getDefaultSensor(1);
        this.h = this.a.getDefaultSensor(10);
        this.i = this.a.getDefaultSensor(4);
        if (this.a.registerListener(jVar, this.g, i)) {
            this.a.registerListener(jVar, this.h, i);
            this.a.registerListener(jVar, this.i, i);
            return;
        }
        a(jVar, cVar2);
    }

    @JSMethod(uiThread = false)
    public void stopAcceleration() {
        for (SensorEventListener unregisterListener : this.k) {
            this.a.unregisterListener(unregisterListener);
        }
        this.k.clear();
    }

    private void a(SensorEventListener sensorEventListener, c cVar) {
        if (this.a != null) {
            this.a.unregisterListener(sensorEventListener);
        }
        Map hashMap = new HashMap();
        hashMap.put("result", "WX_NO_PERMISSION");
        hashMap.put(GuideDialog.MESSAGE, "");
        cVar.b(hashMap);
    }

    public final void b() {
        if (this.a != null) {
            for (SensorEventListener unregisterListener : this.j) {
                this.a.unregisterListener(unregisterListener);
            }
            for (SensorEventListener unregisterListener2 : this.k) {
                this.a.unregisterListener(unregisterListener2);
            }
        }
        super.b();
    }

    public final void c() {
        if (this.a != null) {
            for (k kVar : this.j) {
                this.a.registerListener(kVar, this.d, kVar.f);
                this.a.registerListener(kVar, this.e, kVar.f);
                this.a.registerListener(kVar, this.f, kVar.f);
            }
            for (j jVar : this.k) {
                this.a.registerListener(jVar, this.g, jVar.f);
                this.a.registerListener(jVar, this.h, jVar.f);
                this.a.registerListener(jVar, this.i, jVar.f);
            }
        }
        super.c();
    }
}
