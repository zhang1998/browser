package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class f {
    protected final Map<Class<?>, c> databaseClassLookupMap = new HashMap();
    protected final Map<Class<?>, c> databaseDefinitionMap = new HashMap();
    protected final Map<String, c> databaseNameMap = new HashMap();
    protected final Map<Class<?>, a> typeConverters = new HashMap();

    public a getTypeConverterForClass(Class<?> cls) {
        return (a) this.typeConverters.get(cls);
    }

    public c getDatabaseForTable(Class<?> cls) {
        return (c) this.databaseDefinitionMap.get(cls);
    }

    public c getDatabase(Class<?> cls) {
        return (c) this.databaseClassLookupMap.get(cls);
    }

    public c getDatabase(String str) {
        return (c) this.databaseNameMap.get(str);
    }

    public void putDatabaseForTable(Class<?> cls, c cVar) {
        this.databaseDefinitionMap.put(cls, cVar);
        this.databaseNameMap.put(cVar.b(), cVar);
        this.databaseClassLookupMap.put(cVar.e(), cVar);
    }

    public void reset() {
        this.databaseDefinitionMap.clear();
        this.databaseNameMap.clear();
        this.databaseClassLookupMap.clear();
        this.typeConverters.clear();
    }

    public List<c> getDatabaseDefinitions() {
        return new ArrayList(this.databaseNameMap.values());
    }
}
