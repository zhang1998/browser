package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.a.b;
import com.alibaba.fastjson.a.a.d;
import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.b.ab;
import com.alibaba.fastjson.b.l;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: ProGuard */
public final class c implements Closeable {
    public final q a;
    public n b;
    public String c;
    public DateFormat d;
    public final i e;
    protected m f;
    public int g;
    protected List<b> h;
    protected List<Object> i;
    public d j;
    private m[] k;
    private int l;
    private List<b> m;

    private void a(java.util.Collection r14, java.lang.Object r15) {
        /* JADX: method processing error */
/*
Error: java.lang.StackOverflowError
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:461)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
*/
        /*
        r13 = this;
        r12 = 34;
        r5 = 26;
        r1 = 0;
        r2 = 1;
        r11 = 16;
        r0 = r13.e;
        r0 = r0.a;
        r3 = 21;
        if (r0 == r3) goto L_0x0014;
    L_0x0010:
        r3 = 22;
        if (r0 != r3) goto L_0x001d;
    L_0x0014:
        r0 = r13.e;
        r0.g();
        r0 = r13.e;
        r0 = r0.a;
    L_0x001d:
        r3 = 14;
        if (r0 == r3) goto L_0x0048;
    L_0x0021:
        r1 = new com.alibaba.fastjson.d;
        r2 = new java.lang.StringBuilder;
        r3 = "syntax error, expect [, actual ";
        r2.<init>(r3);
        r0 = com.alibaba.fastjson.a.j.a(r0);
        r0 = r2.append(r0);
        r2 = ", pos ";
        r0 = r0.append(r2);
        r2 = r13.e;
        r2 = r2.b;
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0048:
        r0 = r13.e;
        r6 = r0.r;
        r7 = r13.f;
        if (r6 != 0) goto L_0x0055;
    L_0x0050:
        r0 = r13.f;
        r13.a(r0, r14, r15);
    L_0x0055:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r0 = r0.d;	 Catch:{ all -> 0x011c }
        if (r0 == r12) goto L_0x0122;	 Catch:{ all -> 0x011c }
    L_0x005b:
        r3 = 93;	 Catch:{ all -> 0x011c }
        if (r0 != r3) goto L_0x0070;	 Catch:{ all -> 0x011c }
    L_0x005f:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r0.c();	 Catch:{ all -> 0x011c }
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r1 = 16;	 Catch:{ all -> 0x011c }
        r0.a(r1);	 Catch:{ all -> 0x011c }
        if (r6 != 0) goto L_0x006f;
    L_0x006d:
        r13.f = r7;
    L_0x006f:
        return;
    L_0x0070:
        r3 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r0 != r3) goto L_0x0113;
    L_0x0074:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = r0.e;	 Catch:{ all -> 0x011c }
        r3 = r3 + 1;	 Catch:{ all -> 0x011c }
        r0.e = r3;	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r0 = r0.p;	 Catch:{ all -> 0x011c }
        if (r3 < r0) goto L_0x0109;	 Catch:{ all -> 0x011c }
    L_0x0084:
        r0 = r5;	 Catch:{ all -> 0x011c }
    L_0x0085:
        r4.d = r0;	 Catch:{ all -> 0x011c }
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = 12;	 Catch:{ all -> 0x011c }
        r0.a = r3;	 Catch:{ all -> 0x011c }
    L_0x008d:
        r0 = r1;	 Catch:{ all -> 0x011c }
    L_0x008e:
        r3 = r1;	 Catch:{ all -> 0x011c }
    L_0x008f:
        if (r0 == 0) goto L_0x00ca;	 Catch:{ all -> 0x011c }
    L_0x0091:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.d;	 Catch:{ all -> 0x011c }
        if (r4 != r12) goto L_0x00ca;	 Catch:{ all -> 0x011c }
    L_0x0097:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r4.l();	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.d;	 Catch:{ all -> 0x011c }
        r9 = 44;	 Catch:{ all -> 0x011c }
        if (r4 != r9) goto L_0x0143;	 Catch:{ all -> 0x011c }
    L_0x00a5:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = r4.e;	 Catch:{ all -> 0x011c }
        r9 = r9 + 1;	 Catch:{ all -> 0x011c }
        r4.e = r9;	 Catch:{ all -> 0x011c }
        r10 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.p;	 Catch:{ all -> 0x011c }
        if (r9 < r4) goto L_0x0139;	 Catch:{ all -> 0x011c }
    L_0x00b5:
        r4 = r5;	 Catch:{ all -> 0x011c }
    L_0x00b6:
        r10.d = r4;	 Catch:{ all -> 0x011c }
        r14.add(r8);	 Catch:{ all -> 0x011c }
        r8 = r13.g;	 Catch:{ all -> 0x011c }
        if (r8 != r2) goto L_0x00c2;	 Catch:{ all -> 0x011c }
    L_0x00bf:
        r13.a(r14);	 Catch:{ all -> 0x011c }
    L_0x00c2:
        if (r4 == r12) goto L_0x0106;	 Catch:{ all -> 0x011c }
    L_0x00c4:
        r0 = r1;	 Catch:{ all -> 0x011c }
    L_0x00c5:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4.g();	 Catch:{ all -> 0x011c }
    L_0x00ca:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.a;	 Catch:{ all -> 0x011c }
        if (r4 != r11) goto L_0x00db;	 Catch:{ all -> 0x011c }
    L_0x00d0:
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r8.c;	 Catch:{ all -> 0x011c }
        r9 = com.alibaba.fastjson.a.e.AllowArbitraryCommas;	 Catch:{ all -> 0x011c }
        r9 = r9.q;	 Catch:{ all -> 0x011c }
        r8 = r8 & r9;	 Catch:{ all -> 0x011c }
        if (r8 != 0) goto L_0x00c5;	 Catch:{ all -> 0x011c }
    L_0x00db:
        switch(r4) {
            case 2: goto L_0x0179;
            case 3: goto L_0x0188;
            case 4: goto L_0x01ab;
            case 5: goto L_0x00de;
            case 6: goto L_0x01da;
            case 7: goto L_0x01e5;
            case 8: goto L_0x0223;
            case 9: goto L_0x00de;
            case 10: goto L_0x00de;
            case 11: goto L_0x00de;
            case 12: goto L_0x01f0;
            case 13: goto L_0x00de;
            case 14: goto L_0x0215;
            case 15: goto L_0x0235;
            case 16: goto L_0x00de;
            case 17: goto L_0x00de;
            case 18: goto L_0x00de;
            case 19: goto L_0x00de;
            case 20: goto L_0x0242;
            case 21: goto L_0x00de;
            case 22: goto L_0x00de;
            case 23: goto L_0x022c;
            default: goto L_0x00de;
        };	 Catch:{ all -> 0x011c }
    L_0x00de:
        r4 = 0;	 Catch:{ all -> 0x011c }
        r4 = r13.a(r4);	 Catch:{ all -> 0x011c }
    L_0x00e3:
        r14.add(r4);	 Catch:{ all -> 0x011c }
        r4 = r13.g;	 Catch:{ all -> 0x011c }
        if (r4 != r2) goto L_0x00ed;	 Catch:{ all -> 0x011c }
    L_0x00ea:
        r13.a(r14);	 Catch:{ all -> 0x011c }
    L_0x00ed:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.a;	 Catch:{ all -> 0x011c }
        if (r4 != r11) goto L_0x0106;	 Catch:{ all -> 0x011c }
    L_0x00f3:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.d;	 Catch:{ all -> 0x011c }
        if (r4 != r12) goto L_0x024a;	 Catch:{ all -> 0x011c }
    L_0x00f9:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r8.e;	 Catch:{ all -> 0x011c }
        r4.b = r8;	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4.k();	 Catch:{ all -> 0x011c }
    L_0x0106:
        r3 = r3 + 1;	 Catch:{ all -> 0x011c }
        goto L_0x008f;	 Catch:{ all -> 0x011c }
    L_0x0109:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r0 = r0.o;	 Catch:{ all -> 0x011c }
        r0 = r0.charAt(r3);	 Catch:{ all -> 0x011c }
        goto L_0x0085;	 Catch:{ all -> 0x011c }
    L_0x0113:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = 12;	 Catch:{ all -> 0x011c }
        r0.a(r3);	 Catch:{ all -> 0x011c }
        goto L_0x008d;
    L_0x011c:
        r0 = move-exception;
        if (r6 != 0) goto L_0x0121;
    L_0x011f:
        r13.f = r7;
    L_0x0121:
        throw r0;
    L_0x0122:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r0 = r0.c;	 Catch:{ all -> 0x011c }
        r3 = com.alibaba.fastjson.a.e.AllowISO8601DateFormat;	 Catch:{ all -> 0x011c }
        r3 = r3.q;	 Catch:{ all -> 0x011c }
        r0 = r0 & r3;	 Catch:{ all -> 0x011c }
        if (r0 != 0) goto L_0x0130;	 Catch:{ all -> 0x011c }
    L_0x012d:
        r0 = r2;	 Catch:{ all -> 0x011c }
        goto L_0x008e;	 Catch:{ all -> 0x011c }
    L_0x0130:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = 4;	 Catch:{ all -> 0x011c }
        r0.a(r3);	 Catch:{ all -> 0x011c }
        r0 = r1;	 Catch:{ all -> 0x011c }
        goto L_0x008e;	 Catch:{ all -> 0x011c }
    L_0x0139:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.o;	 Catch:{ all -> 0x011c }
        r4 = r4.charAt(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00b6;	 Catch:{ all -> 0x011c }
    L_0x0143:
        r9 = 93;	 Catch:{ all -> 0x011c }
        if (r4 != r9) goto L_0x00c5;	 Catch:{ all -> 0x011c }
    L_0x0147:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r1 = r0.e;	 Catch:{ all -> 0x011c }
        r1 = r1 + 1;	 Catch:{ all -> 0x011c }
        r0.e = r1;	 Catch:{ all -> 0x011c }
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = r3.p;	 Catch:{ all -> 0x011c }
        if (r1 < r3) goto L_0x0170;	 Catch:{ all -> 0x011c }
    L_0x0157:
        r0.d = r5;	 Catch:{ all -> 0x011c }
        r14.add(r8);	 Catch:{ all -> 0x011c }
        r0 = r13.g;	 Catch:{ all -> 0x011c }
        if (r0 != r2) goto L_0x0163;	 Catch:{ all -> 0x011c }
    L_0x0160:
        r13.a(r14);	 Catch:{ all -> 0x011c }
    L_0x0163:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r1 = 16;	 Catch:{ all -> 0x011c }
        r0.a(r1);	 Catch:{ all -> 0x011c }
        if (r6 != 0) goto L_0x006f;
    L_0x016c:
        r13.f = r7;
        goto L_0x006f;
    L_0x0170:
        r3 = r13.e;	 Catch:{ all -> 0x011c }
        r3 = r3.o;	 Catch:{ all -> 0x011c }
        r5 = r3.charAt(r1);	 Catch:{ all -> 0x011c }
        goto L_0x0157;	 Catch:{ all -> 0x011c }
    L_0x0179:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.i();	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 16;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x0188:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.c;	 Catch:{ all -> 0x011c }
        r8 = com.alibaba.fastjson.a.e.UseBigDecimal;	 Catch:{ all -> 0x011c }
        r8 = r8.q;	 Catch:{ all -> 0x011c }
        r4 = r4 & r8;	 Catch:{ all -> 0x011c }
        if (r4 == 0) goto L_0x01a3;	 Catch:{ all -> 0x011c }
    L_0x0193:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = 1;	 Catch:{ all -> 0x011c }
        r4 = r4.a(r8);	 Catch:{ all -> 0x011c }
    L_0x019a:
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 16;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x01a3:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = 0;	 Catch:{ all -> 0x011c }
        r4 = r4.a(r8);	 Catch:{ all -> 0x011c }
        goto L_0x019a;	 Catch:{ all -> 0x011c }
    L_0x01ab:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.p();	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 16;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r8.c;	 Catch:{ all -> 0x011c }
        r9 = com.alibaba.fastjson.a.e.AllowISO8601DateFormat;	 Catch:{ all -> 0x011c }
        r9 = r9.q;	 Catch:{ all -> 0x011c }
        r8 = r8 & r9;	 Catch:{ all -> 0x011c }
        if (r8 == 0) goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x01c3:
        r8 = new com.alibaba.fastjson.a.i;	 Catch:{ all -> 0x011c }
        r8.<init>(r4);	 Catch:{ all -> 0x011c }
        r9 = 1;	 Catch:{ all -> 0x011c }
        r9 = r8.b(r9);	 Catch:{ all -> 0x011c }
        if (r9 == 0) goto L_0x01d5;	 Catch:{ all -> 0x011c }
    L_0x01cf:
        r4 = r8.m;	 Catch:{ all -> 0x011c }
        r4 = r4.getTime();	 Catch:{ all -> 0x011c }
    L_0x01d5:
        r8.b();	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x01da:
        r4 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 16;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x01e5:
        r4 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 16;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x01f0:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.c;	 Catch:{ all -> 0x011c }
        r8 = com.alibaba.fastjson.a.e.OrderedField;	 Catch:{ all -> 0x011c }
        r8 = r8.q;	 Catch:{ all -> 0x011c }
        r4 = r4 & r8;	 Catch:{ all -> 0x011c }
        if (r4 == 0) goto L_0x020f;	 Catch:{ all -> 0x011c }
    L_0x01fb:
        r4 = new com.alibaba.fastjson.e;	 Catch:{ all -> 0x011c }
        r8 = new java.util.LinkedHashMap;	 Catch:{ all -> 0x011c }
        r8.<init>();	 Catch:{ all -> 0x011c }
        r4.<init>(r8);	 Catch:{ all -> 0x011c }
    L_0x0205:
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x011c }
        r4 = r13.a(r4, r8);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x020f:
        r4 = new com.alibaba.fastjson.e;	 Catch:{ all -> 0x011c }
        r4.<init>();	 Catch:{ all -> 0x011c }
        goto L_0x0205;	 Catch:{ all -> 0x011c }
    L_0x0215:
        r4 = new com.alibaba.fastjson.b;	 Catch:{ all -> 0x011c }
        r4.<init>();	 Catch:{ all -> 0x011c }
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x011c }
        r13.a(r4, r8);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x0223:
        r4 = 0;	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 4;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x022c:
        r4 = 0;	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r9 = 4;	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        goto L_0x00e3;	 Catch:{ all -> 0x011c }
    L_0x0235:
        r0 = r13.e;	 Catch:{ all -> 0x011c }
        r1 = 16;	 Catch:{ all -> 0x011c }
        r0.a(r1);	 Catch:{ all -> 0x011c }
        if (r6 != 0) goto L_0x006f;
    L_0x023e:
        r13.f = r7;
        goto L_0x006f;
    L_0x0242:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x011c }
        r1 = "unclosed jsonArray";	 Catch:{ all -> 0x011c }
        r0.<init>(r1);	 Catch:{ all -> 0x011c }
        throw r0;	 Catch:{ all -> 0x011c }
    L_0x024a:
        r8 = 48;	 Catch:{ all -> 0x011c }
        if (r4 < r8) goto L_0x0261;	 Catch:{ all -> 0x011c }
    L_0x024e:
        r8 = 57;	 Catch:{ all -> 0x011c }
        if (r4 > r8) goto L_0x0261;	 Catch:{ all -> 0x011c }
    L_0x0252:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r8.e;	 Catch:{ all -> 0x011c }
        r4.b = r8;	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4.s();	 Catch:{ all -> 0x011c }
        goto L_0x0106;	 Catch:{ all -> 0x011c }
    L_0x0261:
        r8 = 123; // 0x7b float:1.72E-43 double:6.1E-322;	 Catch:{ all -> 0x011c }
        if (r4 != r8) goto L_0x0289;	 Catch:{ all -> 0x011c }
    L_0x0265:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = 12;	 Catch:{ all -> 0x011c }
        r4.a = r8;	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r8 = r4.e;	 Catch:{ all -> 0x011c }
        r8 = r8 + 1;	 Catch:{ all -> 0x011c }
        r4.e = r8;	 Catch:{ all -> 0x011c }
        r9 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.p;	 Catch:{ all -> 0x011c }
        if (r8 < r4) goto L_0x0280;	 Catch:{ all -> 0x011c }
    L_0x027b:
        r4 = r5;	 Catch:{ all -> 0x011c }
    L_0x027c:
        r9.d = r4;	 Catch:{ all -> 0x011c }
        goto L_0x0106;	 Catch:{ all -> 0x011c }
    L_0x0280:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4 = r4.o;	 Catch:{ all -> 0x011c }
        r4 = r4.charAt(r8);	 Catch:{ all -> 0x011c }
        goto L_0x027c;	 Catch:{ all -> 0x011c }
    L_0x0289:
        r4 = r13.e;	 Catch:{ all -> 0x011c }
        r4.g();	 Catch:{ all -> 0x011c }
        goto L_0x0106;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.c.a(java.util.Collection, java.lang.Object):void");
    }

    public c(String str, n nVar) {
        this(new i(str, a.c), nVar);
    }

    public c(String str, n nVar, int i) {
        this(new i(str, i), nVar);
    }

    private c(i iVar, n nVar) {
        char c = '\u001a';
        this.c = a.d;
        this.l = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.e = iVar;
        this.b = nVar;
        this.a = nVar.b;
        int i;
        if (iVar.d == '{') {
            i = iVar.e + 1;
            iVar.e = i;
            if (i < iVar.p) {
                c = iVar.o.charAt(i);
            }
            iVar.d = c;
            iVar.a = 12;
        } else if (iVar.d == '[') {
            i = iVar.e + 1;
            iVar.e = i;
            if (i < iVar.p) {
                c = iVar.o.charAt(i);
            }
            iVar.d = c;
            iVar.a = 14;
        } else {
            iVar.g();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.Map r19, java.lang.Object r20) {
        /*
        r18 = this;
        r0 = r18;
        r13 = r0.e;
        r3 = r13.a;
        r4 = 8;
        if (r3 != r4) goto L_0x0010;
    L_0x000a:
        r13.g();
        r19 = 0;
    L_0x000f:
        return r19;
    L_0x0010:
        r4 = 12;
        if (r3 == r4) goto L_0x003f;
    L_0x0014:
        r4 = 16;
        if (r3 == r4) goto L_0x003f;
    L_0x0018:
        r3 = new com.alibaba.fastjson.d;
        r4 = new java.lang.StringBuilder;
        r5 = "syntax error, expect {, actual ";
        r4.<init>(r5);
        r5 = r13.h();
        r4 = r4.append(r5);
        r5 = ", ";
        r4 = r4.append(r5);
        r5 = r13.j();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.<init>(r4);
        throw r3;
    L_0x003f:
        r0 = r19;
        r3 = r0 instanceof com.alibaba.fastjson.e;
        if (r3 == 0) goto L_0x0083;
    L_0x0045:
        r3 = r19;
        r3 = (com.alibaba.fastjson.e) r3;
        r4 = r3.f;
        r3 = 1;
    L_0x004c:
        r5 = r13.c;
        r6 = com.alibaba.fastjson.a.e.AllowISO8601DateFormat;
        r6 = r6.q;
        r5 = r5 & r6;
        if (r5 == 0) goto L_0x0086;
    L_0x0055:
        r5 = 1;
    L_0x0056:
        r14 = r13.r;
        r0 = r18;
        r7 = r0.f;
        r12 = 0;
        r9 = r12;
    L_0x005e:
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r8 = 34;
        if (r6 == r8) goto L_0x006d;
    L_0x0064:
        r8 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r6 == r8) goto L_0x006d;
    L_0x0068:
        r13.r();	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
    L_0x006d:
        r8 = 44;
        if (r6 != r8) goto L_0x0088;
    L_0x0071:
        r8 = r13.c;	 Catch:{ all -> 0x00c7 }
        r10 = com.alibaba.fastjson.a.e.AllowArbitraryCommas;	 Catch:{ all -> 0x00c7 }
        r10 = r10.q;	 Catch:{ all -> 0x00c7 }
        r8 = r8 & r10;
        if (r8 == 0) goto L_0x0088;
    L_0x007a:
        r13.c();	 Catch:{ all -> 0x00c7 }
        r13.r();	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        goto L_0x006d;
    L_0x0083:
        r3 = 0;
        r4 = 0;
        goto L_0x004c;
    L_0x0086:
        r5 = 0;
        goto L_0x0056;
    L_0x0088:
        r10 = 0;
        r8 = 34;
        if (r6 != r8) goto L_0x00cf;
    L_0x008d:
        r0 = r18;
        r6 = r0.a;	 Catch:{ all -> 0x00c7 }
        r8 = 34;
        r8 = r13.a(r6, r8);	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r11 = 58;
        if (r6 == r11) goto L_0x077f;
    L_0x009d:
        r13.r();	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r11 = 58;
        if (r6 == r11) goto L_0x077f;
    L_0x00a6:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "expect ':' at ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.b;	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r5 = ", name ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r8);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x00c7:
        r3 = move-exception;
        if (r14 != 0) goto L_0x00ce;
    L_0x00ca:
        r0 = r18;
        r0.f = r7;
    L_0x00ce:
        throw r3;
    L_0x00cf:
        r8 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r6 != r8) goto L_0x00f8;
    L_0x00d3:
        r3 = r13.e;	 Catch:{ all -> 0x00c7 }
        r3 = r3 + 1;
        r13.e = r3;	 Catch:{ all -> 0x00c7 }
        r4 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r3 < r4) goto L_0x00f1;
    L_0x00dd:
        r3 = 26;
    L_0x00df:
        r13.d = r3;	 Catch:{ all -> 0x00c7 }
        r3 = 0;
        r13.h = r3;	 Catch:{ all -> 0x00c7 }
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x000f;
    L_0x00eb:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x00f1:
        r4 = r13.o;	 Catch:{ all -> 0x00c7 }
        r3 = r4.charAt(r3);	 Catch:{ all -> 0x00c7 }
        goto L_0x00df;
    L_0x00f8:
        r8 = 39;
        if (r6 != r8) goto L_0x014e;
    L_0x00fc:
        r6 = r13.c;	 Catch:{ all -> 0x00c7 }
        r8 = com.alibaba.fastjson.a.e.AllowSingleQuotes;	 Catch:{ all -> 0x00c7 }
        r8 = r8.q;	 Catch:{ all -> 0x00c7 }
        r6 = r6 & r8;
        if (r6 != 0) goto L_0x011e;
    L_0x0105:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x011e:
        r0 = r18;
        r6 = r0.a;	 Catch:{ all -> 0x00c7 }
        r8 = 39;
        r8 = r13.a(r6, r8);	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r11 = 58;
        if (r6 == r11) goto L_0x0131;
    L_0x012e:
        r13.r();	 Catch:{ all -> 0x00c7 }
    L_0x0131:
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r11 = 58;
        if (r6 == r11) goto L_0x077f;
    L_0x0137:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "expect ':' at ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.b;	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x014e:
        r8 = 26;
        if (r6 != r8) goto L_0x016b;
    L_0x0152:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x016b:
        r8 = 44;
        if (r6 != r8) goto L_0x0188;
    L_0x016f:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x0188:
        r8 = 48;
        if (r6 < r8) goto L_0x0190;
    L_0x018c:
        r8 = 57;
        if (r6 <= r8) goto L_0x0194;
    L_0x0190:
        r8 = 45;
        if (r6 != r8) goto L_0x01e8;
    L_0x0194:
        r6 = 0;
        r13.h = r6;	 Catch:{ all -> 0x00c7 }
        r13.s();	 Catch:{ all -> 0x00c7 }
        r6 = r13.a;	 Catch:{ NumberFormatException -> 0x01ce }
        r8 = 2;
        if (r6 != r8) goto L_0x01c8;
    L_0x019f:
        r6 = r13.i();	 Catch:{ NumberFormatException -> 0x01ce }
    L_0x01a3:
        if (r3 == 0) goto L_0x01a9;
    L_0x01a5:
        r6 = r6.toString();	 Catch:{ NumberFormatException -> 0x01ce }
    L_0x01a9:
        r8 = r13.d;	 Catch:{ all -> 0x00c7 }
        r11 = 58;
        if (r8 == r11) goto L_0x0782;
    L_0x01af:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "parse number key error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x01c8:
        r6 = 1;
        r6 = r13.a(r6);	 Catch:{ NumberFormatException -> 0x01ce }
        goto L_0x01a3;
    L_0x01ce:
        r3 = move-exception;
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "parse number key error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x01e8:
        r8 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r6 == r8) goto L_0x01f0;
    L_0x01ec:
        r8 = 91;
        if (r6 != r8) goto L_0x0233;
    L_0x01f0:
        r13.g();	 Catch:{ all -> 0x00c7 }
        r6 = 0;
        r0 = r18;
        r8 = r0.a(r6);	 Catch:{ all -> 0x00c7 }
        r6 = 1;
        if (r3 == 0) goto L_0x0201;
    L_0x01fd:
        r8 = r8.toString();	 Catch:{ all -> 0x00c7 }
    L_0x0201:
        if (r6 != 0) goto L_0x0298;
    L_0x0203:
        r6 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6 + 1;
        r13.e = r6;	 Catch:{ all -> 0x00c7 }
        r10 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r6 < r10) goto L_0x0290;
    L_0x020d:
        r6 = 26;
    L_0x020f:
        r13.d = r6;	 Catch:{ all -> 0x00c7 }
    L_0x0211:
        r10 = 32;
        if (r6 > r10) goto L_0x077c;
    L_0x0215:
        r10 = 32;
        if (r6 == r10) goto L_0x022d;
    L_0x0219:
        r10 = 10;
        if (r6 == r10) goto L_0x022d;
    L_0x021d:
        r10 = 13;
        if (r6 == r10) goto L_0x022d;
    L_0x0221:
        r10 = 9;
        if (r6 == r10) goto L_0x022d;
    L_0x0225:
        r10 = 12;
        if (r6 == r10) goto L_0x022d;
    L_0x0229:
        r10 = 8;
        if (r6 != r10) goto L_0x077c;
    L_0x022d:
        r13.c();	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        goto L_0x0211;
    L_0x0233:
        r6 = r13.c;	 Catch:{ all -> 0x00c7 }
        r8 = com.alibaba.fastjson.a.e.AllowUnQuotedFieldNames;	 Catch:{ all -> 0x00c7 }
        r8 = r8.q;	 Catch:{ all -> 0x00c7 }
        r6 = r6 & r8;
        if (r6 != 0) goto L_0x0255;
    L_0x023c:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x0255:
        r0 = r18;
        r6 = r0.a;	 Catch:{ all -> 0x00c7 }
        r8 = r13.b(r6);	 Catch:{ all -> 0x00c7 }
        r13.r();	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r11 = 58;
        if (r6 == r11) goto L_0x0287;
    L_0x0266:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "expect ':' at ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.e;	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r5 = ", actual ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x0287:
        if (r3 == 0) goto L_0x077f;
    L_0x0289:
        r8 = r8.toString();	 Catch:{ all -> 0x00c7 }
        r6 = r10;
        goto L_0x0201;
    L_0x0290:
        r10 = r13.o;	 Catch:{ all -> 0x00c7 }
        r6 = r10.charAt(r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x020f;
    L_0x0298:
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r10 = r6;
    L_0x029b:
        r6 = 0;
        r13.h = r6;	 Catch:{ all -> 0x00c7 }
        r6 = "@type";
        if (r8 != r6) goto L_0x0365;
    L_0x02a2:
        r6 = com.alibaba.fastjson.a.e.DisableSpecialKeyDetect;	 Catch:{ all -> 0x00c7 }
        r6 = r13.a(r6);	 Catch:{ all -> 0x00c7 }
        if (r6 != 0) goto L_0x0365;
    L_0x02aa:
        r0 = r18;
        r6 = r0.a;	 Catch:{ all -> 0x00c7 }
        r8 = 34;
        r6 = r13.a(r6, r8);	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r8 = r0.b;	 Catch:{ all -> 0x00c7 }
        r8 = r8.c;	 Catch:{ all -> 0x00c7 }
        r8 = com.alibaba.fastjson.c.e.a(r6, r8);	 Catch:{ all -> 0x00c7 }
        if (r8 != 0) goto L_0x02c9;
    L_0x02c0:
        r8 = "@type";
        r0 = r19;
        r0.put(r8, r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x005e;
    L_0x02c9:
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        r3 = r13.a;	 Catch:{ all -> 0x00c7 }
        r4 = 13;
        if (r3 != r4) goto L_0x031e;
    L_0x02d4:
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        r4 = 0;
        r0 = r18;
        r3 = r0.b;	 Catch:{ Exception -> 0x0315 }
        r3 = r3.a(r8);	 Catch:{ Exception -> 0x0315 }
        r5 = r3 instanceof com.alibaba.fastjson.a.f;	 Catch:{ Exception -> 0x0315 }
        if (r5 == 0) goto L_0x0779;
    L_0x02e6:
        r3 = (com.alibaba.fastjson.a.f) r3;	 Catch:{ Exception -> 0x0315 }
        r0 = r18;
        r3 = r3.a(r0, r8);	 Catch:{ Exception -> 0x0315 }
    L_0x02ee:
        if (r3 != 0) goto L_0x02f9;
    L_0x02f0:
        r3 = java.lang.Cloneable.class;
        if (r8 != r3) goto L_0x0303;
    L_0x02f4:
        r3 = new java.util.HashMap;	 Catch:{ Exception -> 0x0315 }
        r3.<init>();	 Catch:{ Exception -> 0x0315 }
    L_0x02f9:
        if (r14 != 0) goto L_0x02ff;
    L_0x02fb:
        r0 = r18;
        r0.f = r7;
    L_0x02ff:
        r19 = r3;
        goto L_0x000f;
    L_0x0303:
        r3 = "java.util.Collections$EmptyMap";
        r3 = r3.equals(r6);	 Catch:{ Exception -> 0x0315 }
        if (r3 == 0) goto L_0x0310;
    L_0x030b:
        r3 = java.util.Collections.emptyMap();	 Catch:{ Exception -> 0x0315 }
        goto L_0x02f9;
    L_0x0310:
        r3 = r8.newInstance();	 Catch:{ Exception -> 0x0315 }
        goto L_0x02f9;
    L_0x0315:
        r3 = move-exception;
        r4 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r5 = "create instance error";
        r4.<init>(r5, r3);	 Catch:{ all -> 0x00c7 }
        throw r4;	 Catch:{ all -> 0x00c7 }
    L_0x031e:
        r3 = 2;
        r0 = r18;
        r0.g = r3;	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r3 = r0.f;	 Catch:{ all -> 0x00c7 }
        if (r3 == 0) goto L_0x0332;
    L_0x0329:
        r0 = r20;
        r3 = r0 instanceof java.lang.Integer;	 Catch:{ all -> 0x00c7 }
        if (r3 != 0) goto L_0x0332;
    L_0x032f:
        r18.b();	 Catch:{ all -> 0x00c7 }
    L_0x0332:
        r3 = r19.size();	 Catch:{ all -> 0x00c7 }
        if (r3 <= 0) goto L_0x034d;
    L_0x0338:
        r0 = r18;
        r3 = r0.b;	 Catch:{ all -> 0x00c7 }
        r0 = r19;
        r19 = com.alibaba.fastjson.c.e.a(r0, r8, r3);	 Catch:{ all -> 0x00c7 }
        r18.b(r19);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x000f;
    L_0x0347:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x034d:
        r0 = r18;
        r3 = r0.b;	 Catch:{ all -> 0x00c7 }
        r3 = r3.a(r8);	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r1 = r20;
        r19 = r3.a(r0, r8, r1);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x000f;
    L_0x035f:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x0365:
        r6 = "$ref";
        if (r8 != r6) goto L_0x0459;
    L_0x0369:
        r6 = com.alibaba.fastjson.a.e.DisableSpecialKeyDetect;	 Catch:{ all -> 0x00c7 }
        r6 = r13.a(r6);	 Catch:{ all -> 0x00c7 }
        if (r6 != 0) goto L_0x0459;
    L_0x0371:
        r3 = 4;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        r3 = r13.a;	 Catch:{ all -> 0x00c7 }
        r4 = 4;
        if (r3 != r4) goto L_0x043e;
    L_0x037a:
        r5 = r13.p();	 Catch:{ all -> 0x00c7 }
        r3 = 13;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        r3 = 0;
        r4 = "@";
        r4 = r4.equals(r5);	 Catch:{ all -> 0x00c7 }
        if (r4 == 0) goto L_0x03d0;
    L_0x038c:
        r0 = r18;
        r4 = r0.f;	 Catch:{ all -> 0x00c7 }
        if (r4 == 0) goto L_0x042d;
    L_0x0392:
        r0 = r18;
        r4 = r0.f;	 Catch:{ all -> 0x00c7 }
        r0 = r4.a;	 Catch:{ all -> 0x00c7 }
        r19 = r0;
        r0 = r19;
        r5 = r0 instanceof java.lang.Object[];	 Catch:{ all -> 0x00c7 }
        if (r5 != 0) goto L_0x03a6;
    L_0x03a0:
        r0 = r19;
        r5 = r0 instanceof java.util.Collection;	 Catch:{ all -> 0x00c7 }
        if (r5 == 0) goto L_0x03c5;
    L_0x03a6:
        r3 = r13.a;	 Catch:{ all -> 0x00c7 }
        r4 = 13;
        if (r3 == r4) goto L_0x0431;
    L_0x03ac:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x03c5:
        r5 = r4.b;	 Catch:{ all -> 0x00c7 }
        if (r5 == 0) goto L_0x03cd;
    L_0x03c9:
        r3 = r4.b;	 Catch:{ all -> 0x00c7 }
        r3 = r3.a;	 Catch:{ all -> 0x00c7 }
    L_0x03cd:
        r19 = r3;
        goto L_0x03a6;
    L_0x03d0:
        r4 = "..";
        r4 = r4.equals(r5);	 Catch:{ all -> 0x00c7 }
        if (r4 == 0) goto L_0x03f3;
    L_0x03d8:
        r4 = r7.a;	 Catch:{ all -> 0x00c7 }
        if (r4 == 0) goto L_0x03e1;
    L_0x03dc:
        r3 = r7.a;	 Catch:{ all -> 0x00c7 }
        r19 = r3;
        goto L_0x03a6;
    L_0x03e1:
        r4 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x00c7 }
        r4.<init>(r7, r5);	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r0.a(r4);	 Catch:{ all -> 0x00c7 }
        r4 = 1;
        r0 = r18;
        r0.g = r4;	 Catch:{ all -> 0x00c7 }
        r19 = r3;
        goto L_0x03a6;
    L_0x03f3:
        r4 = "$";
        r4 = r4.equals(r5);	 Catch:{ all -> 0x00c7 }
        if (r4 == 0) goto L_0x041e;
    L_0x03fb:
        r4 = r7;
    L_0x03fc:
        r6 = r4.b;	 Catch:{ all -> 0x00c7 }
        if (r6 == 0) goto L_0x0403;
    L_0x0400:
        r4 = r4.b;	 Catch:{ all -> 0x00c7 }
        goto L_0x03fc;
    L_0x0403:
        r6 = r4.a;	 Catch:{ all -> 0x00c7 }
        if (r6 == 0) goto L_0x040c;
    L_0x0407:
        r3 = r4.a;	 Catch:{ all -> 0x00c7 }
        r19 = r3;
        goto L_0x03a6;
    L_0x040c:
        r6 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x00c7 }
        r6.<init>(r4, r5);	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r0.a(r6);	 Catch:{ all -> 0x00c7 }
        r4 = 1;
        r0 = r18;
        r0.g = r4;	 Catch:{ all -> 0x00c7 }
        r19 = r3;
        goto L_0x03a6;
    L_0x041e:
        r4 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x00c7 }
        r4.<init>(r7, r5);	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r0.a(r4);	 Catch:{ all -> 0x00c7 }
        r4 = 1;
        r0 = r18;
        r0.g = r4;	 Catch:{ all -> 0x00c7 }
    L_0x042d:
        r19 = r3;
        goto L_0x03a6;
    L_0x0431:
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x000f;
    L_0x0438:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x043e:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "illegal ref, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.a;	 Catch:{ all -> 0x00c7 }
        r5 = com.alibaba.fastjson.a.j.a(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x0459:
        if (r14 != 0) goto L_0x0776;
    L_0x045b:
        if (r9 != 0) goto L_0x0776;
    L_0x045d:
        r0 = r18;
        r6 = r0.f;	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r1 = r19;
        r2 = r20;
        r6 = r0.a(r6, r1, r2);	 Catch:{ all -> 0x00c7 }
        if (r7 != 0) goto L_0x0773;
    L_0x046d:
        r7 = 1;
        r12 = r7;
        r7 = r6;
    L_0x0470:
        r6 = 34;
        if (r10 != r6) goto L_0x04be;
    L_0x0474:
        r6 = r13.l();	 Catch:{ all -> 0x00c7 }
        if (r5 == 0) goto L_0x048f;
    L_0x047a:
        r9 = new com.alibaba.fastjson.a.i;	 Catch:{ all -> 0x00c7 }
        r9.<init>(r6);	 Catch:{ all -> 0x00c7 }
        r10 = 1;
        r10 = r9.b(r10);	 Catch:{ all -> 0x00c7 }
        if (r10 == 0) goto L_0x048c;
    L_0x0486:
        r6 = r9.m;	 Catch:{ all -> 0x00c7 }
        r6 = r6.getTime();	 Catch:{ all -> 0x00c7 }
    L_0x048c:
        r9.b();	 Catch:{ all -> 0x00c7 }
    L_0x048f:
        if (r4 == 0) goto L_0x04b8;
    L_0x0491:
        r4.put(r8, r6);	 Catch:{ all -> 0x00c7 }
    L_0x0494:
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
        r8 = 44;
        if (r6 == r8) goto L_0x04a3;
    L_0x049a:
        r8 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r6 == r8) goto L_0x04a3;
    L_0x049e:
        r13.r();	 Catch:{ all -> 0x00c7 }
        r6 = r13.d;	 Catch:{ all -> 0x00c7 }
    L_0x04a3:
        r8 = 44;
        if (r6 != r8) goto L_0x06bd;
    L_0x04a7:
        r6 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6 + 1;
        r13.e = r6;	 Catch:{ all -> 0x00c7 }
        r8 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r6 < r8) goto L_0x06b5;
    L_0x04b1:
        r6 = 26;
    L_0x04b3:
        r13.d = r6;	 Catch:{ all -> 0x00c7 }
        r9 = r12;
        goto L_0x005e;
    L_0x04b8:
        r0 = r19;
        r0.put(r8, r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x0494;
    L_0x04be:
        r6 = 48;
        if (r10 < r6) goto L_0x04c6;
    L_0x04c2:
        r6 = 57;
        if (r10 <= r6) goto L_0x04ca;
    L_0x04c6:
        r6 = 45;
        if (r10 != r6) goto L_0x04d4;
    L_0x04ca:
        r6 = r13.u();	 Catch:{ all -> 0x00c7 }
        r0 = r19;
        r0.put(r8, r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x0494;
    L_0x04d4:
        r6 = 91;
        if (r10 != r6) goto L_0x053b;
    L_0x04d8:
        r6 = 14;
        r13.a = r6;	 Catch:{ all -> 0x00c7 }
        r6 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6 + 1;
        r13.e = r6;	 Catch:{ all -> 0x00c7 }
        r9 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r6 < r9) goto L_0x0511;
    L_0x04e6:
        r6 = 26;
    L_0x04e8:
        r13.d = r6;	 Catch:{ all -> 0x00c7 }
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x00c7 }
        r6.<init>();	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r0.a(r6, r8);	 Catch:{ all -> 0x00c7 }
        r9 = new com.alibaba.fastjson.b;	 Catch:{ all -> 0x00c7 }
        r9.<init>(r6);	 Catch:{ all -> 0x00c7 }
        if (r4 == 0) goto L_0x0518;
    L_0x04fb:
        r4.put(r8, r9);	 Catch:{ all -> 0x00c7 }
    L_0x04fe:
        r6 = r13.a;	 Catch:{ all -> 0x00c7 }
        r8 = 13;
        if (r6 != r8) goto L_0x051e;
    L_0x0504:
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x000f;
    L_0x050b:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x0511:
        r9 = r13.o;	 Catch:{ all -> 0x00c7 }
        r6 = r9.charAt(r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x04e8;
    L_0x0518:
        r0 = r19;
        r0.put(r8, r9);	 Catch:{ all -> 0x00c7 }
        goto L_0x04fe;
    L_0x051e:
        r8 = 16;
        if (r6 == r8) goto L_0x0766;
    L_0x0522:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x053b:
        r6 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r10 != r6) goto L_0x0622;
    L_0x053f:
        r6 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6 + 1;
        r13.e = r6;	 Catch:{ all -> 0x00c7 }
        r9 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r6 < r9) goto L_0x05ef;
    L_0x0549:
        r6 = 26;
    L_0x054b:
        r13.d = r6;	 Catch:{ all -> 0x00c7 }
        r6 = 12;
        r13.a = r6;	 Catch:{ all -> 0x00c7 }
        r0 = r20;
        r15 = r0 instanceof java.lang.Integer;	 Catch:{ all -> 0x00c7 }
        r6 = r13.c;	 Catch:{ all -> 0x00c7 }
        r9 = com.alibaba.fastjson.a.e.OrderedField;	 Catch:{ all -> 0x00c7 }
        r9 = r9.q;	 Catch:{ all -> 0x00c7 }
        r6 = r6 & r9;
        if (r6 == 0) goto L_0x05f7;
    L_0x055e:
        r6 = new com.alibaba.fastjson.e;	 Catch:{ all -> 0x00c7 }
        r9 = new java.util.LinkedHashMap;	 Catch:{ all -> 0x00c7 }
        r9.<init>();	 Catch:{ all -> 0x00c7 }
        r6.<init>(r9);	 Catch:{ all -> 0x00c7 }
        r11 = r6;
    L_0x0569:
        r6 = 0;
        if (r14 != 0) goto L_0x0770;
    L_0x056c:
        if (r15 != 0) goto L_0x0770;
    L_0x056e:
        r0 = r18;
        r6 = r0.a(r7, r11, r8);	 Catch:{ all -> 0x00c7 }
        r10 = r6;
    L_0x0575:
        r9 = 0;
        r6 = 0;
        r0 = r18;
        r0 = r0.j;	 Catch:{ all -> 0x00c7 }
        r16 = r0;
        if (r16 == 0) goto L_0x0769;
    L_0x057f:
        if (r8 == 0) goto L_0x0584;
    L_0x0581:
        r8.toString();	 Catch:{ all -> 0x00c7 }
    L_0x0584:
        r0 = r18;
        r0 = r0.j;	 Catch:{ all -> 0x00c7 }
        r16 = r0;
        r16 = r16.a();	 Catch:{ all -> 0x00c7 }
        if (r16 == 0) goto L_0x0769;
    L_0x0590:
        r0 = r18;
        r6 = r0.b;	 Catch:{ all -> 0x00c7 }
        r0 = r16;
        r6 = r6.a(r0);	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r1 = r16;
        r9 = r6.a(r0, r1, r8);	 Catch:{ all -> 0x00c7 }
        r6 = 1;
        r17 = r6;
        r6 = r9;
        r9 = r17;
    L_0x05a8:
        if (r9 != 0) goto L_0x05b0;
    L_0x05aa:
        r0 = r18;
        r6 = r0.a(r11, r8);	 Catch:{ all -> 0x00c7 }
    L_0x05b0:
        if (r10 == 0) goto L_0x05b8;
    L_0x05b2:
        if (r11 == r6) goto L_0x05b8;
    L_0x05b4:
        r0 = r19;
        r10.a = r0;	 Catch:{ all -> 0x00c7 }
    L_0x05b8:
        r0 = r18;
        r9 = r0.g;	 Catch:{ all -> 0x00c7 }
        r10 = 1;
        if (r9 != r10) goto L_0x05ca;
    L_0x05bf:
        r9 = r8.toString();	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r1 = r19;
        r0.b(r1, r9);	 Catch:{ all -> 0x00c7 }
    L_0x05ca:
        if (r4 == 0) goto L_0x05ff;
    L_0x05cc:
        r4.put(r8, r6);	 Catch:{ all -> 0x00c7 }
    L_0x05cf:
        if (r15 == 0) goto L_0x05d6;
    L_0x05d1:
        r0 = r18;
        r0.a(r7, r6, r8);	 Catch:{ all -> 0x00c7 }
    L_0x05d6:
        r6 = r13.a;	 Catch:{ all -> 0x00c7 }
        r8 = 13;
        if (r6 != r8) goto L_0x0605;
    L_0x05dc:
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x05e7;
    L_0x05e3:
        r0 = r18;
        r0.f = r7;	 Catch:{ all -> 0x00c7 }
    L_0x05e7:
        if (r14 != 0) goto L_0x000f;
    L_0x05e9:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x05ef:
        r9 = r13.o;	 Catch:{ all -> 0x00c7 }
        r6 = r9.charAt(r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x054b;
    L_0x05f7:
        r6 = new com.alibaba.fastjson.e;	 Catch:{ all -> 0x00c7 }
        r6.<init>();	 Catch:{ all -> 0x00c7 }
        r11 = r6;
        goto L_0x0569;
    L_0x05ff:
        r0 = r19;
        r0.put(r8, r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x05cf;
    L_0x0605:
        r8 = 16;
        if (r6 == r8) goto L_0x0766;
    L_0x0609:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x0622:
        r6 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        if (r10 != r6) goto L_0x0644;
    L_0x0626:
        r6 = r13.o;	 Catch:{ all -> 0x00c7 }
        r9 = "true";
        r10 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6.startsWith(r9, r10);	 Catch:{ all -> 0x00c7 }
        if (r6 == 0) goto L_0x0494;
    L_0x0632:
        r6 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6 + 3;
        r13.e = r6;	 Catch:{ all -> 0x00c7 }
        r13.c();	 Catch:{ all -> 0x00c7 }
        r6 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x00c7 }
        r0 = r19;
        r0.put(r8, r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x0494;
    L_0x0644:
        r6 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r10 != r6) goto L_0x0666;
    L_0x0648:
        r6 = r13.o;	 Catch:{ all -> 0x00c7 }
        r9 = "false";
        r10 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6.startsWith(r9, r10);	 Catch:{ all -> 0x00c7 }
        if (r6 == 0) goto L_0x0494;
    L_0x0654:
        r6 = r13.e;	 Catch:{ all -> 0x00c7 }
        r6 = r6 + 4;
        r13.e = r6;	 Catch:{ all -> 0x00c7 }
        r13.c();	 Catch:{ all -> 0x00c7 }
        r6 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x00c7 }
        r0 = r19;
        r0.put(r8, r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x0494;
    L_0x0666:
        r13.g();	 Catch:{ all -> 0x00c7 }
        r6 = 0;
        r0 = r18;
        r9 = r0.a(r6);	 Catch:{ all -> 0x00c7 }
        r6 = r19.getClass();	 Catch:{ all -> 0x00c7 }
        r10 = com.alibaba.fastjson.e.class;
        if (r6 != r10) goto L_0x0694;
    L_0x0678:
        r6 = r8.toString();	 Catch:{ all -> 0x00c7 }
    L_0x067c:
        r0 = r19;
        r0.put(r6, r9);	 Catch:{ all -> 0x00c7 }
        r6 = r13.a;	 Catch:{ all -> 0x00c7 }
        r8 = 13;
        if (r6 != r8) goto L_0x0696;
    L_0x0687:
        r3 = 16;
        r13.a(r3);	 Catch:{ all -> 0x00c7 }
        if (r14 != 0) goto L_0x000f;
    L_0x068e:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x0694:
        r6 = r8;
        goto L_0x067c;
    L_0x0696:
        r6 = r13.a;	 Catch:{ all -> 0x00c7 }
        r8 = 16;
        if (r6 == r8) goto L_0x0766;
    L_0x069c:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x06b5:
        r8 = r13.o;	 Catch:{ all -> 0x00c7 }
        r6 = r8.charAt(r6);	 Catch:{ all -> 0x00c7 }
        goto L_0x04b3;
    L_0x06bd:
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r6 != r3) goto L_0x074d;
    L_0x06c1:
        r3 = r13.e;	 Catch:{ all -> 0x00c7 }
        r3 = r3 + 1;
        r13.e = r3;	 Catch:{ all -> 0x00c7 }
        r4 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r3 < r4) goto L_0x06ff;
    L_0x06cb:
        r3 = 26;
    L_0x06cd:
        r13.d = r3;	 Catch:{ all -> 0x00c7 }
        r4 = 0;
        r13.h = r4;	 Catch:{ all -> 0x00c7 }
        r4 = 44;
        if (r3 != r4) goto L_0x070d;
    L_0x06d6:
        r3 = r13.e;	 Catch:{ all -> 0x00c7 }
        r3 = r3 + 1;
        r13.e = r3;	 Catch:{ all -> 0x00c7 }
        r4 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r3 < r4) goto L_0x0706;
    L_0x06e0:
        r3 = 26;
    L_0x06e2:
        r13.d = r3;	 Catch:{ all -> 0x00c7 }
        r3 = 16;
        r13.a = r3;	 Catch:{ all -> 0x00c7 }
    L_0x06e8:
        if (r14 != 0) goto L_0x06f7;
    L_0x06ea:
        r0 = r18;
        r3 = r0.f;	 Catch:{ all -> 0x00c7 }
        r0 = r18;
        r1 = r19;
        r2 = r20;
        r0.a(r3, r1, r2);	 Catch:{ all -> 0x00c7 }
    L_0x06f7:
        if (r14 != 0) goto L_0x000f;
    L_0x06f9:
        r0 = r18;
        r0.f = r7;
        goto L_0x000f;
    L_0x06ff:
        r4 = r13.o;	 Catch:{ all -> 0x00c7 }
        r3 = r4.charAt(r3);	 Catch:{ all -> 0x00c7 }
        goto L_0x06cd;
    L_0x0706:
        r4 = r13.o;	 Catch:{ all -> 0x00c7 }
        r3 = r4.charAt(r3);	 Catch:{ all -> 0x00c7 }
        goto L_0x06e2;
    L_0x070d:
        r4 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r3 != r4) goto L_0x072b;
    L_0x0711:
        r3 = r13.e;	 Catch:{ all -> 0x00c7 }
        r3 = r3 + 1;
        r13.e = r3;	 Catch:{ all -> 0x00c7 }
        r4 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r3 < r4) goto L_0x0724;
    L_0x071b:
        r3 = 26;
    L_0x071d:
        r13.d = r3;	 Catch:{ all -> 0x00c7 }
        r3 = 13;
        r13.a = r3;	 Catch:{ all -> 0x00c7 }
        goto L_0x06e8;
    L_0x0724:
        r4 = r13.o;	 Catch:{ all -> 0x00c7 }
        r3 = r4.charAt(r3);	 Catch:{ all -> 0x00c7 }
        goto L_0x071d;
    L_0x072b:
        r4 = 93;
        if (r3 != r4) goto L_0x0749;
    L_0x072f:
        r3 = r13.e;	 Catch:{ all -> 0x00c7 }
        r3 = r3 + 1;
        r13.e = r3;	 Catch:{ all -> 0x00c7 }
        r4 = r13.p;	 Catch:{ all -> 0x00c7 }
        if (r3 < r4) goto L_0x0742;
    L_0x0739:
        r3 = 26;
    L_0x073b:
        r13.d = r3;	 Catch:{ all -> 0x00c7 }
        r3 = 15;
        r13.a = r3;	 Catch:{ all -> 0x00c7 }
        goto L_0x06e8;
    L_0x0742:
        r4 = r13.o;	 Catch:{ all -> 0x00c7 }
        r3 = r4.charAt(r3);	 Catch:{ all -> 0x00c7 }
        goto L_0x073b;
    L_0x0749:
        r13.g();	 Catch:{ all -> 0x00c7 }
        goto L_0x06e8;
    L_0x074d:
        r3 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r5 = "syntax error, ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c7 }
        r5 = r13.j();	 Catch:{ all -> 0x00c7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3.<init>(r4);	 Catch:{ all -> 0x00c7 }
        throw r3;	 Catch:{ all -> 0x00c7 }
    L_0x0766:
        r9 = r12;
        goto L_0x005e;
    L_0x0769:
        r17 = r6;
        r6 = r9;
        r9 = r17;
        goto L_0x05a8;
    L_0x0770:
        r10 = r6;
        goto L_0x0575;
    L_0x0773:
        r6 = r7;
        goto L_0x046d;
    L_0x0776:
        r12 = r9;
        goto L_0x0470;
    L_0x0779:
        r3 = r4;
        goto L_0x02ee;
    L_0x077c:
        r10 = r6;
        goto L_0x029b;
    L_0x077f:
        r6 = r10;
        goto L_0x0201;
    L_0x0782:
        r8 = r6;
        r6 = r10;
        goto L_0x0201;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.c.a(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public final <T> T a(Type type, Object obj) {
        if (this.e.a == 8) {
            this.e.g();
            return null;
        }
        if (this.e.a == 4) {
            if (type == byte[].class) {
                T o = this.e.o();
                this.e.g();
                return o;
            } else if (type == char[].class) {
                String p = this.e.p();
                this.e.g();
                return p.toCharArray();
            }
        }
        try {
            return this.b.a(type).a(this, type, obj);
        } catch (com.alibaba.fastjson.d e) {
            throw e;
        } catch (Throwable e2) {
            throw new com.alibaba.fastjson.d(e2.getMessage(), e2);
        }
    }

    public final void a(Type type, Collection collection) {
        a(type, collection, null);
    }

    public final void a(Type type, Collection collection, Object obj) {
        if (this.e.a == 21 || this.e.a == 22) {
            this.e.g();
        }
        if (this.e.a != 14) {
            throw new com.alibaba.fastjson.d("exepct '[', but " + j.a(this.e.a) + ", " + this.e.j());
        }
        e eVar;
        if (Integer.TYPE == type) {
            eVar = l.a;
            this.e.a(2);
        } else if (String.class == type) {
            eVar = ab.a;
            this.e.a(4);
        } else {
            eVar = this.b.a(type);
            this.e.a(12);
        }
        m mVar = this.f;
        if (!this.e.r) {
            a(this.f, (Object) collection, obj);
        }
        int i = 0;
        while (true) {
            try {
                if ((this.e.c & e.AllowArbitraryCommas.q) != 0) {
                    while (this.e.a == 16) {
                        this.e.g();
                    }
                }
                if (this.e.a == 15) {
                    break;
                }
                if (Integer.TYPE == type) {
                    collection.add(l.a.a(this, null, null));
                } else if (String.class == type) {
                    if (this.e.a == 4) {
                        r1 = this.e.p();
                        this.e.a(16);
                    } else {
                        r1 = a(null);
                        if (r1 == null) {
                            r1 = null;
                        } else {
                            r1 = r1.toString();
                        }
                    }
                    collection.add(r1);
                } else {
                    if (this.e.a == 8) {
                        this.e.g();
                        r1 = null;
                    } else {
                        r1 = eVar.a(this, type, Integer.valueOf(i));
                    }
                    collection.add(r1);
                    if (this.g == 1) {
                        a(collection);
                    }
                }
                if (this.e.a == 16) {
                    this.e.g();
                }
                i++;
            } finally {
                this.f = mVar;
            }
        }
        this.e.a(16);
    }

    private void b(Object obj) {
        f fVar;
        Type type = obj.getClass();
        e a = this.b.a(type);
        if (a instanceof f) {
            fVar = (f) a;
        } else {
            fVar = null;
        }
        if (this.e.a == 12 || this.e.a == 16) {
            while (true) {
                com.alibaba.fastjson.a.a.c a2;
                String a3 = this.e.a(this.a);
                if (a3 == null) {
                    if (this.e.a == 13) {
                        this.e.a(16);
                        return;
                    } else if (this.e.a == 16 && (this.e.c & e.AllowArbitraryCommas.q) != 0) {
                    }
                }
                if (fVar != null) {
                    a2 = fVar.a(a3);
                } else {
                    a2 = null;
                }
                if (a2 != null) {
                    Object a4;
                    Class cls = a2.b.f;
                    Type type2 = a2.b.g;
                    if (cls == Integer.TYPE) {
                        this.e.d();
                        a4 = l.a.a(this, type2, null);
                    } else if (cls == String.class) {
                        this.e.d();
                        a4 = d();
                    } else if (cls == Long.TYPE) {
                        this.e.d();
                        a4 = l.a.a(this, type2, null);
                    } else {
                        e a5 = this.b.a(cls, type2);
                        this.e.d();
                        a4 = a5.a(this, type2, null);
                    }
                    a2.a(obj, a4);
                    if (this.e.a != 16 && this.e.a == 13) {
                        this.e.a(16);
                        return;
                    }
                } else if ((this.e.c & e.IgnoreNotMatch.q) == 0) {
                    throw new com.alibaba.fastjson.d("setter not found, class " + type.getName() + ", property " + a3);
                } else {
                    this.e.d();
                    a(null);
                    if (this.e.a == 13) {
                        this.e.g();
                        return;
                    }
                }
            }
        } else {
            throw new com.alibaba.fastjson.d("syntax error, expect {, actual " + this.e.h());
        }
    }

    protected final void a(Collection collection) {
        if (collection instanceof List) {
            b a = a();
            a.c = new o(this, (List) collection, collection.size() - 1);
            a.d = this.f;
            this.g = 0;
            return;
        }
        b a2 = a();
        a2.c = new o(collection);
        a2.d = this.f;
        this.g = 0;
    }

    protected final void b(Map map, Object obj) {
        com.alibaba.fastjson.a.a.c oVar = new o(map, obj);
        b a = a();
        a.c = oVar;
        a.d = this.f;
        this.g = 0;
    }

    public final void b(Collection collection) {
        a(collection, null);
    }

    protected final void a(b bVar) {
        if (this.m == null) {
            this.m = new ArrayList(2);
        }
        this.m.add(bVar);
    }

    protected final b a() {
        return (b) this.m.get(this.m.size() - 1);
    }

    public final void a(m mVar) {
        if (!this.e.r) {
            this.f = mVar;
        }
    }

    protected final void b() {
        this.f = this.f.b;
        this.k[this.l - 1] = null;
        this.l--;
    }

    protected final m a(m mVar, Object obj, Object obj2) {
        if (this.e.r) {
            return null;
        }
        this.f = new m(mVar, obj, obj2);
        int i = this.l;
        this.l = i + 1;
        if (this.k == null) {
            this.k = new m[8];
        } else if (i >= this.k.length) {
            Object obj3 = new m[((this.k.length * 3) / 2)];
            System.arraycopy(this.k, 0, obj3, 0, this.k.length);
            this.k = obj3;
        }
        this.k[i] = this.f;
        return this.f;
    }

    public final Object a(Object obj) {
        boolean z = true;
        Object i;
        Collection bVar;
        switch (this.e.a) {
            case 2:
                i = this.e.i();
                this.e.g();
                return i;
            case 3:
                if ((this.e.c & e.UseBigDecimal.q) == 0) {
                    z = false;
                }
                i = this.e.a(z);
                this.e.g();
                return i;
            case 4:
                i = this.e.p();
                this.e.a(16);
                if ((this.e.c & e.AllowISO8601DateFormat.q) == 0) {
                    return i;
                }
                i iVar = new i(i);
                try {
                    if (iVar.b(true)) {
                        i = iVar.m.getTime();
                        return i;
                    }
                    iVar.b();
                    return i;
                } finally {
                    iVar.b();
                }
            case 6:
                this.e.a(16);
                return Boolean.TRUE;
            case 7:
                this.e.a(16);
                return Boolean.FALSE;
            case 8:
            case 23:
                this.e.g();
                return null;
            case 9:
                this.e.a(18);
                if (this.e.a != 18) {
                    throw new com.alibaba.fastjson.d("syntax error, " + this.e.j());
                }
                this.e.a(10);
                a(10);
                long longValue = this.e.i().longValue();
                a(2);
                a(11);
                return new Date(longValue);
            case 12:
                return a((this.e.c & e.OrderedField.q) != 0 ? new com.alibaba.fastjson.e(new LinkedHashMap()) : new com.alibaba.fastjson.e(), obj);
            case 14:
                bVar = new com.alibaba.fastjson.b();
                a(bVar, obj);
                return bVar;
            case 20:
                if (this.e.q()) {
                    return null;
                }
                throw new com.alibaba.fastjson.d("syntax error, " + this.e.j());
            case 21:
                this.e.g();
                bVar = new HashSet();
                a(bVar, obj);
                return bVar;
            case 22:
                this.e.g();
                bVar = new TreeSet();
                a(bVar, obj);
                return bVar;
            default:
                throw new com.alibaba.fastjson.d("syntax error, " + this.e.j());
        }
    }

    public final void a(int i) {
        if (this.e.a == i) {
            this.e.g();
            return;
        }
        throw new com.alibaba.fastjson.d("syntax error, expect " + j.a(i) + ", actual " + j.a(this.e.a));
    }

    public final void close() {
        try {
            if ((this.e.c & e.AutoCloseSource.q) == 0 || this.e.a == 20) {
                this.e.b();
                return;
            }
            throw new com.alibaba.fastjson.d("not close json text, token : " + j.a(this.e.a));
        } catch (Throwable th) {
            this.e.b();
        }
    }

    public final void c() {
        if (this.m != null) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.m.get(i);
                com.alibaba.fastjson.a.a.c cVar = bVar.c;
                if (cVar != null) {
                    Object obj;
                    Object obj2;
                    if (bVar.d != null) {
                        obj = bVar.d.a;
                    } else {
                        obj = null;
                    }
                    String str = bVar.b;
                    if (str.startsWith("$")) {
                        obj2 = null;
                        for (int i2 = 0; i2 < this.l; i2++) {
                            if (str.equals(this.k[i2].toString())) {
                                obj2 = this.k[i2].a;
                            }
                        }
                    } else {
                        obj2 = bVar.a.a;
                    }
                    cVar.a(obj, obj2);
                }
            }
        }
    }

    public final String d() {
        char c = '\u001a';
        int i = this.e.a;
        if (i == 4) {
            String p = this.e.p();
            i iVar;
            int i2;
            if (this.e.d == ',') {
                iVar = this.e;
                i2 = iVar.e + 1;
                iVar.e = i2;
                iVar = this.e;
                if (i2 < this.e.p) {
                    c = this.e.o.charAt(i2);
                }
                iVar.d = c;
                this.e.a = 16;
            } else if (this.e.d == ']') {
                iVar = this.e;
                i2 = iVar.e + 1;
                iVar.e = i2;
                iVar = this.e;
                if (i2 < this.e.p) {
                    c = this.e.o.charAt(i2);
                }
                iVar.d = c;
                this.e.a = 15;
            } else if (this.e.d == '}') {
                iVar = this.e;
                i2 = iVar.e + 1;
                iVar.e = i2;
                iVar = this.e;
                if (i2 < this.e.p) {
                    c = this.e.o.charAt(i2);
                }
                iVar.d = c;
                this.e.a = 13;
            } else {
                this.e.g();
            }
            return p;
        } else if (i == 2) {
            String f = this.e.f();
            this.e.a(16);
            return f;
        } else {
            Object a = a(null);
            if (a == null) {
                return null;
            }
            return a.toString();
        }
    }
}
