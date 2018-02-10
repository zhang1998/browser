package com.uc.b.a;

/* compiled from: ProGuard */
enum p {
    OPACITY,
    FILL,
    FILL_RULE,
    FILL_OPACITY,
    FILL_FILTER,
    STROKE,
    STROKE_OPACITY,
    STROKE_WIDTH,
    STROKE_LINE_CAP,
    STROKE_LINE_JOIN,
    STROKE_MITER_LIMIT,
    STROKE_DASH_ARRAY,
    STROKE_DASH_OFFSET;
    
    final int n;

    final boolean a(int i) {
        return (this.n & i) != 0;
    }
}
