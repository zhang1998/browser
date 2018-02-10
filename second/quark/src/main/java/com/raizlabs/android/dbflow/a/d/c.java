package com.raizlabs.android.dbflow.a.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.structure.database.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class c<TModel> extends b<TModel, List<TModel>> {
    @NonNull
    public final /* bridge */ /* synthetic */ Object a(@NonNull b bVar, String str, @Nullable Object obj) {
        return (List) super.a(bVar, str, (List) obj);
    }

    @NonNull
    public final /* synthetic */ Object a(@Nullable com.raizlabs.android.dbflow.structure.database.c cVar) {
        return b(cVar);
    }

    @NonNull
    public final /* synthetic */ Object a(@NonNull com.raizlabs.android.dbflow.structure.database.c cVar, @Nullable Object obj) {
        obj = (List) obj;
        if (obj == null) {
            obj = new ArrayList();
        } else {
            obj.clear();
        }
        if (cVar.moveToFirst()) {
            do {
                Object h = a().h();
                a().a(cVar, h);
                obj.add(h);
            } while (cVar.moveToNext());
        }
        return obj;
    }

    @NonNull
    public final /* synthetic */ Object a(String str) {
        return b(str);
    }

    @NonNull
    public final /* synthetic */ Object b(@Nullable com.raizlabs.android.dbflow.structure.database.c cVar, @Nullable Object obj) {
        obj = (List) obj;
        if (obj == null) {
            obj = new ArrayList();
        } else {
            obj.clear();
        }
        return (List) super.b(cVar, obj);
    }

    public c(@NonNull Class<TModel> cls) {
        super(cls);
    }

    @NonNull
    public final List<TModel> b(String str) {
        return (List) super.a(str);
    }

    @NonNull
    public final List<TModel> b(@Nullable com.raizlabs.android.dbflow.structure.database.c cVar) {
        return (List) super.a(cVar);
    }
}
