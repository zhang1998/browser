package com.uc.apollo.rebound;

import com.uc.apollo.annotation.KeepForRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ProGuard */
public class BaseSpringSystem {
    private final Map<String, Spring> a = new HashMap();
    private final Set<Spring> b = new CopyOnWriteArraySet();
    private final f c;
    private final CopyOnWriteArraySet<Object> d = new CopyOnWriteArraySet();
    private boolean e = true;

    public BaseSpringSystem(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("springLooper is required");
        }
        this.c = fVar;
        this.c.a(this);
    }

    @KeepForRuntime
    public Spring createSpring() {
        Spring spring = new Spring(this);
        if (this.a.containsKey(spring.a())) {
            throw new IllegalArgumentException("spring is already registered");
        }
        this.a.put(spring.a(), spring);
        return spring;
    }

    public final void a(double d) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        for (Spring spring : this.b) {
            boolean z;
            if (spring.c() && spring.b()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                spring.a(d / 1000.0d);
            } else {
                this.b.remove(spring);
            }
        }
        if (this.b.isEmpty()) {
            this.e = true;
        }
        it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.e) {
            this.c.b();
        }
    }

    final void a(String str) {
        Spring spring = (Spring) this.a.get(str);
        if (spring == null) {
            throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
        }
        this.b.add(spring);
        if (this.e) {
            this.e = false;
            this.c.a();
        }
    }
}
