package com.ucpro.feature.navigation.view;

/* compiled from: ProGuard */
public final class ac implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ aq b;

    public ac(aq aqVar, j jVar) {
        this.b = aqVar;
        this.a = jVar;
    }

    public final void run() {
        aq aqVar = this.b;
        j jVar = this.a;
        if (jVar != null) {
            aqVar.d.a(jVar.getWidgetInfo());
            aqVar.b.notifyDataSetChanged();
        }
    }
}
