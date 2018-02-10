package com.raizlabs.android.dbflow.a.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.structure.database.c;

/* compiled from: ProGuard */
public final class a<TModel> extends b<TModel, TModel> {
    public a(Class<TModel> cls) {
        super(cls);
    }

    public final TModel a(@NonNull c cVar, @Nullable TModel tModel) {
        if (cVar.moveToFirst()) {
            if (tModel == null) {
                tModel = a().h();
            }
            a().a(cVar, (Object) tModel);
        }
        return tModel;
    }
}
