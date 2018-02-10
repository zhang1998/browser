package com.raizlabs.android.dbflow.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.structure.a;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.h;
import com.raizlabs.android.dbflow.structure.i;
import com.raizlabs.android.dbflow.structure.j;
import java.util.HashSet;

/* compiled from: ProGuard */
public class FlowManager {
    static e a;
    private static GlobalDatabaseHolder b = new GlobalDatabaseHolder();
    private static HashSet<Class<? extends f>> c = new HashSet();
    private static final String d = FlowManager.class.getPackage().getName();
    private static final String e = (d + ".GeneratedDatabaseHolder");

    /* compiled from: ProGuard */
    class GlobalDatabaseHolder extends f {
        private boolean initialized;

        private GlobalDatabaseHolder() {
            this.initialized = false;
        }

        public void add(f fVar) {
            this.databaseDefinitionMap.putAll(fVar.databaseDefinitionMap);
            this.databaseNameMap.putAll(fVar.databaseNameMap);
            this.typeConverters.putAll(fVar.typeConverters);
            this.databaseClassLookupMap.putAll(fVar.databaseClassLookupMap);
            this.initialized = true;
        }

        public boolean isInitialized() {
            return this.initialized;
        }
    }

    @NonNull
    public static String a(Class<?> cls) {
        a j = j(cls);
        if (j != null) {
            return j.j_();
        }
        h k = k(cls);
        if (k != null) {
            return k.b();
        }
        a("ModelAdapter/ModelViewAdapter", cls);
        return null;
    }

    @NonNull
    public static c b(Class<?> cls) {
        c();
        c databaseForTable = b.getDatabaseForTable(cls);
        if (databaseForTable != null) {
            return databaseForTable;
        }
        throw new j("Model object: " + cls.getName() + " is not registered with a Database. Did you forget an annotation?");
    }

    @NonNull
    public static c c(Class<?> cls) {
        c();
        c database = b.getDatabase((Class) cls);
        if (database != null) {
            return database;
        }
        throw new j("Database: " + cls.getName() + " is not a registered Database. Did you forget the @Database annotation?");
    }

    @NonNull
    public static b d(Class<?> cls) {
        return b(cls).a();
    }

    public static e a() {
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Configuration is not initialized. Please call init(FlowConfig) in your application class.");
    }

    private static void i(Class<? extends f> cls) {
        if (!c.contains(cls)) {
            try {
                f fVar = (f) cls.newInstance();
                if (fVar != null) {
                    b.add(fVar);
                    c.add(cls);
                }
            } catch (Throwable th) {
                a aVar = new a("Cannot load " + cls, th);
            }
        }
    }

    @NonNull
    public static Context b() {
        if (a != null) {
            return a.c;
        }
        throw new IllegalStateException("You must provide a valid FlowConfig instance. We recommend calling init() in your application class.");
    }

    public static void a(@NonNull e eVar) {
        a = eVar;
        try {
            i(Class.forName(e));
        } catch (a e) {
            t.a(s.d, e.getMessage());
        } catch (ClassNotFoundException e2) {
            t.a(s.d, "Could not find the default GeneratedDatabaseHolder");
        }
        if (!(eVar.a == null || eVar.a.isEmpty())) {
            for (Class i : eVar.a) {
                i(i);
            }
        }
        if (eVar.d) {
            for (c a : b.getDatabaseDefinitions()) {
                a.a();
            }
        }
    }

    public static com.raizlabs.android.dbflow.d.a e(Class<?> cls) {
        c();
        return b.getTypeConverterForClass(cls);
    }

    @NonNull
    public static <TModel> com.raizlabs.android.dbflow.structure.b<TModel> f(Class<TModel> cls) {
        com.raizlabs.android.dbflow.structure.b<TModel> j = j(cls);
        if (j == null) {
            j = k(cls);
            if (j == null) {
                j = (i) b(cls).d.get(cls);
            }
        }
        if (j == null) {
            a("InstanceAdapter", cls);
        }
        return j;
    }

    @NonNull
    public static <TModel> a<TModel> g(Class<TModel> cls) {
        a<TModel> j = j(cls);
        if (j == null) {
            a("ModelAdapter", cls);
        }
        return j;
    }

    @NonNull
    public static com.raizlabs.android.dbflow.runtime.b h(Class<?> cls) {
        c b = b(cls);
        if (b.f == null) {
            k kVar = (k) a().b.get(b.e());
            if (kVar == null || kVar.f == null) {
                b.f = new com.raizlabs.android.dbflow.runtime.a();
            } else {
                b.f = kVar.f;
            }
        }
        return b.f;
    }

    @Nullable
    private static <T> a<T> j(Class<T> cls) {
        return (a) b(cls).b.get(cls);
    }

    @Nullable
    private static <T> h<T> k(Class<T> cls) {
        return (h) b(cls).c.get(cls);
    }

    private static void a(String str, Class<?> cls) {
        throw new IllegalArgumentException("Cannot find " + str + " for " + cls + ". Ensure the class is annotated with proper annotation.");
    }

    private static void c() {
        if (!b.isInitialized()) {
            throw new IllegalStateException("The global database holder is not initialized. Ensure you call FlowManager.init() before accessing the database.");
        }
    }
}
