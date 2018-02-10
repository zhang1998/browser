package com.airbnb.lottie;

/* compiled from: ProGuard */
enum b {
    Star(1),
    Polygon(2);
    
    private final int c;

    private b(int i) {
        this.c = i;
    }

    static b a(int i) {
        for (b bVar : values()) {
            if (bVar.c == i) {
                return bVar;
            }
        }
        return null;
    }
}
