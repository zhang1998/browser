package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public class Range implements Cloneable {
    public static final long MAX_LENGTH = Long.MAX_VALUE;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public long e = Long.MAX_VALUE;
    public long s = 0;

    public Range(Range range) {
        assign(range);
    }

    public Range(long j) {
        assign(j, Long.MAX_VALUE);
    }

    public Range(long j, long j2) {
        assign(j, j2);
    }

    public long length() {
        return this.e - this.s;
    }

    public boolean empty() {
        return this.s >= this.e;
    }

    public void assign(long j, long j2) {
        this.s = j;
        this.e = j2;
    }

    public void assign(Range range) {
        this.s = range.s;
        this.e = range.e;
    }

    public Range clone() {
        return new Range(this);
    }

    public String toString() {
        if (this.s == this.e) {
            return "[empty, pos: " + this.s + "]";
        }
        return "[" + this.s + ", " + (this.e == Long.MAX_VALUE ? "*" : Long.valueOf(this.e)) + "]";
    }
}
