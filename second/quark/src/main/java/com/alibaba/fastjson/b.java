package com.alibaba.fastjson;

import com.alibaba.fastjson.b.y;
import com.alibaba.fastjson.c.e;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: ProGuard */
public class b extends a implements Serializable, Cloneable, List<Object>, RandomAccess {
    public final List<Object> f;
    protected transient Object g;
    protected transient Type h;

    public b() {
        this.f = new ArrayList(10);
    }

    public b(List<Object> list) {
        this.f = list;
    }

    public b(int i) {
        this.f = new ArrayList(i);
    }

    public final Object b() {
        return this.g;
    }

    public final void c(Object obj) {
        this.g = obj;
    }

    public final Type c() {
        return this.h;
    }

    public final void a(Type type) {
        this.h = type;
    }

    public int size() {
        return this.f.size();
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.f.contains(obj);
    }

    public Iterator<Object> iterator() {
        return this.f.iterator();
    }

    public Object[] toArray() {
        return this.f.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f.toArray(tArr);
    }

    public boolean add(Object obj) {
        return this.f.add(obj);
    }

    public boolean remove(Object obj) {
        return this.f.remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f.containsAll(collection);
    }

    public boolean addAll(Collection<? extends Object> collection) {
        return this.f.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends Object> collection) {
        return this.f.addAll(i, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.f.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.f.retainAll(collection);
    }

    public void clear() {
        this.f.clear();
    }

    public Object set(int i, Object obj) {
        return this.f.set(i, obj);
    }

    public void add(int i, Object obj) {
        this.f.add(i, obj);
    }

    public Object remove(int i) {
        return this.f.remove(i);
    }

    public int indexOf(Object obj) {
        return this.f.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.f.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.f.listIterator();
    }

    public ListIterator<Object> listIterator(int i) {
        return this.f.listIterator(i);
    }

    public List<Object> subList(int i, int i2) {
        return this.f.subList(i, i2);
    }

    public Object get(int i) {
        return this.f.get(i);
    }

    public final e a(int i) {
        Object obj = this.f.get(i);
        if (obj instanceof e) {
            return (e) obj;
        }
        return (e) a.a(obj, y.a);
    }

    public final Integer b(int i) {
        return e.j(get(i));
    }

    public final String c(int i) {
        return e.a(get(i));
    }

    public Object clone() {
        return new b(new ArrayList(this.f));
    }

    public boolean equals(Object obj) {
        return this.f.equals(obj);
    }

    public int hashCode() {
        return this.f.hashCode();
    }
}
