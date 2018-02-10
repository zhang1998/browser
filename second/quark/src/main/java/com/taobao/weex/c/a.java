package com.taobao.weex.c;

/* compiled from: ProGuard */
final class a implements ad {
    static a a;

    a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.taobao.weex.c.ae r12) {
        /*
        r11 = this;
        r6 = 8;
        r5 = 3;
        r4 = 2;
        r3 = 1;
        r2 = 0;
        r7 = r12.g();
        r0 = r12.w();
        if (r0 == 0) goto L_0x003c;
    L_0x0010:
        r0 = r0.entrySet();
        r8 = r0.iterator();
    L_0x0018:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x003c;
    L_0x001e:
        r0 = r8.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = r7.containsKey(r1);
        if (r1 != 0) goto L_0x0018;
    L_0x002e:
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r7.a(r1, r0);
        goto L_0x0018;
    L_0x003c:
        r0 = r12.g();
        r0 = r0.size();
        if (r0 <= 0) goto L_0x06f5;
    L_0x0046:
        r7 = r12.g();
        r8 = r12.o;
        r0 = r7.isEmpty();
        if (r0 != 0) goto L_0x06f5;
    L_0x0052:
        r0 = r7.entrySet();
        r9 = r0.iterator();
    L_0x005a:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x06f5;
    L_0x0060:
        r0 = r9.next();
        r0 = (java.util.Map.Entry) r0;
        r0 = r0.getKey();
        r0 = (java.lang.String) r0;
        r1 = -1;
        r10 = r0.hashCode();
        switch(r10) {
            case -1971292586: goto L_0x01b6;
            case -1501175880: goto L_0x01e6;
            case -1452542531: goto L_0x01aa;
            case -1383228885: goto L_0x0156;
            case -1375815020: goto L_0x00cd;
            case -1290574193: goto L_0x01c2;
            case -1221029593: goto L_0x0102;
            case -1081309778: goto L_0x0162;
            case -1063257157: goto L_0x0091;
            case -1044792121: goto L_0x017a;
            case -975171706: goto L_0x00af;
            case -906066005: goto L_0x00eb;
            case -806339567: goto L_0x01da;
            case -657971195: goto L_0x011a;
            case -289173127: goto L_0x0192;
            case -223992013: goto L_0x01ce;
            case -133587431: goto L_0x00d7;
            case 115029: goto L_0x013e;
            case 3145721: goto L_0x00a5;
            case 3317767: goto L_0x0132;
            case 90130308: goto L_0x01f2;
            case 108511772: goto L_0x014a;
            case 113126854: goto L_0x010e;
            case 202355100: goto L_0x020a;
            case 400381634: goto L_0x00e1;
            case 644734664: goto L_0x00f6;
            case 713848971: goto L_0x01fe;
            case 741115130: goto L_0x019e;
            case 747804969: goto L_0x0126;
            case 975087886: goto L_0x0186;
            case 1744216035: goto L_0x00c3;
            case 1767100401: goto L_0x009b;
            case 1860657097: goto L_0x00b9;
            case 1970934485: goto L_0x016e;
            default: goto L_0x0074;
        };
    L_0x0074:
        r0 = r1;
    L_0x0075:
        switch(r0) {
            case 0: goto L_0x0079;
            case 1: goto L_0x025a;
            case 2: goto L_0x02b2;
            case 3: goto L_0x02cf;
            case 4: goto L_0x0327;
            case 5: goto L_0x0387;
            case 6: goto L_0x03bb;
            case 7: goto L_0x03dc;
            case 8: goto L_0x03fd;
            case 9: goto L_0x041e;
            case 10: goto L_0x043f;
            case 11: goto L_0x043f;
            case 12: goto L_0x0465;
            case 13: goto L_0x0465;
            case 14: goto L_0x048b;
            case 15: goto L_0x04da;
            case 16: goto L_0x04ff;
            case 17: goto L_0x0524;
            case 18: goto L_0x0549;
            case 19: goto L_0x056e;
            case 20: goto L_0x0581;
            case 21: goto L_0x05a4;
            case 22: goto L_0x05c7;
            case 23: goto L_0x05ea;
            case 24: goto L_0x060d;
            case 25: goto L_0x061a;
            case 26: goto L_0x0629;
            case 27: goto L_0x0638;
            case 28: goto L_0x0647;
            case 29: goto L_0x0656;
            case 30: goto L_0x0669;
            case 31: goto L_0x068c;
            case 32: goto L_0x06af;
            case 33: goto L_0x06d2;
            default: goto L_0x0078;
        };
    L_0x0078:
        goto L_0x005a;
    L_0x0079:
        r0 = "alignItems";
        r0 = r7.get(r0);
        if (r0 != 0) goto L_0x0216;
    L_0x0081:
        r0 = com.taobao.weex.c.b.b.STRETCH;
    L_0x0083:
        r1 = r12.a_;
        r1 = r1.e;
        if (r1 == r0) goto L_0x005a;
    L_0x0089:
        r1 = r12.a_;
        r1.e = r0;
        r12.h();
        goto L_0x005a;
    L_0x0091:
        r10 = "alignItems";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0099:
        r0 = r2;
        goto L_0x0075;
    L_0x009b:
        r10 = "alignSelf";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00a3:
        r0 = r3;
        goto L_0x0075;
    L_0x00a5:
        r10 = "flex";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00ad:
        r0 = r4;
        goto L_0x0075;
    L_0x00af:
        r10 = "flexDirection";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00b7:
        r0 = r5;
        goto L_0x0075;
    L_0x00b9:
        r10 = "justifyContent";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00c1:
        r0 = 4;
        goto L_0x0075;
    L_0x00c3:
        r10 = "flexWrap";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00cb:
        r0 = 5;
        goto L_0x0075;
    L_0x00cd:
        r10 = "minWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00d5:
        r0 = 6;
        goto L_0x0075;
    L_0x00d7:
        r10 = "minHeight";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00df:
        r0 = 7;
        goto L_0x0075;
    L_0x00e1:
        r10 = "maxWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00e9:
        r0 = r6;
        goto L_0x0075;
    L_0x00eb:
        r10 = "maxHeight";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00f3:
        r0 = 9;
        goto L_0x0075;
    L_0x00f6:
        r10 = "defaultHeight";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x00fe:
        r0 = 10;
        goto L_0x0075;
    L_0x0102:
        r10 = "height";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x010a:
        r0 = 11;
        goto L_0x0075;
    L_0x010e:
        r10 = "width";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0116:
        r0 = 12;
        goto L_0x0075;
    L_0x011a:
        r10 = "defaultWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0122:
        r0 = 13;
        goto L_0x0075;
    L_0x0126:
        r10 = "position";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x012e:
        r0 = 14;
        goto L_0x0075;
    L_0x0132:
        r10 = "left";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x013a:
        r0 = 15;
        goto L_0x0075;
    L_0x013e:
        r10 = "top";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0146:
        r0 = 16;
        goto L_0x0075;
    L_0x014a:
        r10 = "right";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0152:
        r0 = 17;
        goto L_0x0075;
    L_0x0156:
        r10 = "bottom";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x015e:
        r0 = 18;
        goto L_0x0075;
    L_0x0162:
        r10 = "margin";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x016a:
        r0 = 19;
        goto L_0x0075;
    L_0x016e:
        r10 = "marginLeft";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0176:
        r0 = 20;
        goto L_0x0075;
    L_0x017a:
        r10 = "marginTop";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0182:
        r0 = 21;
        goto L_0x0075;
    L_0x0186:
        r10 = "marginRight";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x018e:
        r0 = 22;
        goto L_0x0075;
    L_0x0192:
        r10 = "marginBottom";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x019a:
        r0 = 23;
        goto L_0x0075;
    L_0x019e:
        r10 = "borderWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01a6:
        r0 = 24;
        goto L_0x0075;
    L_0x01aa:
        r10 = "borderTopWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01b2:
        r0 = 25;
        goto L_0x0075;
    L_0x01b6:
        r10 = "borderRightWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01be:
        r0 = 26;
        goto L_0x0075;
    L_0x01c2:
        r10 = "borderBottomWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01ca:
        r0 = 27;
        goto L_0x0075;
    L_0x01ce:
        r10 = "borderLeftWidth";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01d6:
        r0 = 28;
        goto L_0x0075;
    L_0x01da:
        r10 = "padding";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01e2:
        r0 = 29;
        goto L_0x0075;
    L_0x01e6:
        r10 = "paddingLeft";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01ee:
        r0 = 30;
        goto L_0x0075;
    L_0x01f2:
        r10 = "paddingTop";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x01fa:
        r0 = 31;
        goto L_0x0075;
    L_0x01fe:
        r10 = "paddingRight";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0206:
        r0 = 32;
        goto L_0x0075;
    L_0x020a:
        r10 = "paddingBottom";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0074;
    L_0x0212:
        r0 = 33;
        goto L_0x0075;
    L_0x0216:
        r0 = r0.toString();
        r1 = r0.trim();
        r0 = com.taobao.weex.c.b.b.STRETCH;
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 == 0) goto L_0x022a;
    L_0x0226:
        r0 = com.taobao.weex.c.b.b.STRETCH;
        goto L_0x0083;
    L_0x022a:
        r10 = "stretch";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0236;
    L_0x0232:
        r0 = com.taobao.weex.c.b.b.STRETCH;
        goto L_0x0083;
    L_0x0236:
        r10 = "flex-end";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0242;
    L_0x023e:
        r0 = com.taobao.weex.c.b.b.FLEX_END;
        goto L_0x0083;
    L_0x0242:
        r10 = "auto";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x024e;
    L_0x024a:
        r0 = com.taobao.weex.c.b.b.AUTO;
        goto L_0x0083;
    L_0x024e:
        r10 = "center";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0083;
    L_0x0256:
        r0 = com.taobao.weex.c.b.b.CENTER;
        goto L_0x0083;
    L_0x025a:
        r0 = "alignSelf";
        r0 = r7.get(r0);
        if (r0 != 0) goto L_0x0273;
    L_0x0262:
        r0 = com.taobao.weex.c.b.b.AUTO;
    L_0x0264:
        r1 = r12.a_;
        r1 = r1.f;
        if (r1 == r0) goto L_0x005a;
    L_0x026a:
        r1 = r12.a_;
        r1.f = r0;
        r12.h();
        goto L_0x005a;
    L_0x0273:
        r0 = r0.toString();
        r1 = r0.trim();
        r0 = com.taobao.weex.c.b.b.AUTO;
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 == 0) goto L_0x0286;
    L_0x0283:
        r0 = com.taobao.weex.c.b.b.AUTO;
        goto L_0x0264;
    L_0x0286:
        r10 = "flex-start";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0291;
    L_0x028e:
        r0 = com.taobao.weex.c.b.b.FLEX_START;
        goto L_0x0264;
    L_0x0291:
        r10 = "flex-end";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x029c;
    L_0x0299:
        r0 = com.taobao.weex.c.b.b.FLEX_END;
        goto L_0x0264;
    L_0x029c:
        r10 = "stretch";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x02a7;
    L_0x02a4:
        r0 = com.taobao.weex.c.b.b.STRETCH;
        goto L_0x0264;
    L_0x02a7:
        r10 = "center";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0264;
    L_0x02af:
        r0 = com.taobao.weex.c.b.b.CENTER;
        goto L_0x0264;
    L_0x02b2:
        r0 = "flex";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0);
        r1 = r12.a_;
        r1 = r1.i;
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x02c6:
        r1 = r12.a_;
        r1.i = r0;
        r12.h();
        goto L_0x005a;
    L_0x02cf:
        r0 = "flexDirection";
        r0 = r7.get(r0);
        if (r0 != 0) goto L_0x02e8;
    L_0x02d7:
        r0 = com.taobao.weex.c.b.e.COLUMN;
    L_0x02d9:
        r1 = r12.a_;
        r1 = r1.b;
        if (r1 == r0) goto L_0x005a;
    L_0x02df:
        r1 = r12.a_;
        r1.b = r0;
        r12.h();
        goto L_0x005a;
    L_0x02e8:
        r0 = r0.toString();
        r1 = r0.trim();
        r0 = com.taobao.weex.c.b.e.ROW;
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 == 0) goto L_0x02fb;
    L_0x02f8:
        r0 = com.taobao.weex.c.b.e.ROW;
        goto L_0x02d9;
    L_0x02fb:
        r10 = "column";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0306;
    L_0x0303:
        r0 = com.taobao.weex.c.b.e.COLUMN;
        goto L_0x02d9;
    L_0x0306:
        r10 = "column-reverse";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0311;
    L_0x030e:
        r0 = com.taobao.weex.c.b.e.COLUMN_REVERSE;
        goto L_0x02d9;
    L_0x0311:
        r10 = "row";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x031c;
    L_0x0319:
        r0 = com.taobao.weex.c.b.e.ROW;
        goto L_0x02d9;
    L_0x031c:
        r10 = "row-reverse";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x02d9;
    L_0x0324:
        r0 = com.taobao.weex.c.b.e.ROW_REVERSE;
        goto L_0x02d9;
    L_0x0327:
        r0 = "justifyContent";
        r0 = r7.get(r0);
        if (r0 != 0) goto L_0x0340;
    L_0x032f:
        r0 = com.taobao.weex.c.b.f.FLEX_START;
    L_0x0331:
        r1 = r12.a_;
        r1 = r1.c;
        if (r1 == r0) goto L_0x005a;
    L_0x0337:
        r1 = r12.a_;
        r1.c = r0;
        r12.h();
        goto L_0x005a;
    L_0x0340:
        r0 = r0.toString();
        r1 = r0.trim();
        r0 = com.taobao.weex.c.b.f.FLEX_START;
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 != 0) goto L_0x0358;
    L_0x0350:
        r10 = "flex-start";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x035b;
    L_0x0358:
        r0 = com.taobao.weex.c.b.f.FLEX_START;
        goto L_0x0331;
    L_0x035b:
        r10 = "flex-end";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0366;
    L_0x0363:
        r0 = com.taobao.weex.c.b.f.FLEX_END;
        goto L_0x0331;
    L_0x0366:
        r10 = "center";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x0371;
    L_0x036e:
        r0 = com.taobao.weex.c.b.f.CENTER;
        goto L_0x0331;
    L_0x0371:
        r10 = "space-between";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x037c;
    L_0x0379:
        r0 = com.taobao.weex.c.b.f.SPACE_BETWEEN;
        goto L_0x0331;
    L_0x037c:
        r10 = "space-around";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0331;
    L_0x0384:
        r0 = com.taobao.weex.c.b.f.SPACE_AROUND;
        goto L_0x0331;
    L_0x0387:
        r0 = "flexWrap";
        r0 = r7.get(r0);
        if (r0 != 0) goto L_0x03a0;
    L_0x038f:
        r0 = com.taobao.weex.c.b.n.NOWRAP;
    L_0x0391:
        r1 = r12.a_;
        r1 = r1.h;
        if (r1 == r0) goto L_0x005a;
    L_0x0397:
        r1 = r12.a_;
        r1.h = r0;
        r12.h();
        goto L_0x005a;
    L_0x03a0:
        r0 = r0.toString();
        r1 = r0.trim();
        r0 = com.taobao.weex.c.b.n.NOWRAP;
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 != 0) goto L_0x0391;
    L_0x03b0:
        r10 = "wrap";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0391;
    L_0x03b8:
        r0 = com.taobao.weex.c.b.n.WRAP;
        goto L_0x0391;
    L_0x03bb:
        r0 = "minWidth";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.o;
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x03d3:
        r1 = r12.a_;
        r1.o = r0;
        r12.h();
        goto L_0x005a;
    L_0x03dc:
        r0 = "minHeight";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.p;
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x03f4:
        r1 = r12.a_;
        r1.p = r0;
        r12.h();
        goto L_0x005a;
    L_0x03fd:
        r0 = "maxWidth";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.q;
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x0415:
        r1 = r12.a_;
        r1.q = r0;
        r12.h();
        goto L_0x005a;
    L_0x041e:
        r0 = "maxHeight";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.r;
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x0436:
        r1 = r12.a_;
        r1.r = r0;
        r12.h();
        goto L_0x005a;
    L_0x043f:
        r0 = "height";
        r0 = r7.containsKey(r0);
        if (r0 == 0) goto L_0x045a;
    L_0x0447:
        r0 = "height";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x0451:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.b(r0);
        goto L_0x005a;
    L_0x045a:
        r0 = "defaultHeight";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0);
        goto L_0x0451;
    L_0x0465:
        r0 = "width";
        r0 = r7.containsKey(r0);
        if (r0 == 0) goto L_0x0480;
    L_0x046d:
        r0 = "width";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x0477:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.a(r0);
        goto L_0x005a;
    L_0x0480:
        r0 = "defaultWidth";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0);
        goto L_0x0477;
    L_0x048b:
        r0 = "position";
        r0 = r7.get(r0);
        if (r0 != 0) goto L_0x04a4;
    L_0x0493:
        r0 = com.taobao.weex.c.b.l.RELATIVE;
    L_0x0495:
        r1 = r12.a_;
        r1 = r1.g;
        if (r1 == r0) goto L_0x005a;
    L_0x049b:
        r1 = r12.a_;
        r1.g = r0;
        r12.h();
        goto L_0x005a;
    L_0x04a4:
        r0 = r0.toString();
        r1 = r0.trim();
        r0 = com.taobao.weex.c.b.l.RELATIVE;
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 != 0) goto L_0x04c4;
    L_0x04b4:
        r10 = "relative";
        r10 = r1.equals(r10);
        if (r10 != 0) goto L_0x04c4;
    L_0x04bc:
        r10 = "sticky";
        r10 = r1.equals(r10);
        if (r10 == 0) goto L_0x04c7;
    L_0x04c4:
        r0 = com.taobao.weex.c.b.l.RELATIVE;
        goto L_0x0495;
    L_0x04c7:
        r10 = "absolute";
        r10 = r1.equals(r10);
        if (r10 != 0) goto L_0x04d7;
    L_0x04cf:
        r10 = "fixed";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0495;
    L_0x04d7:
        r0 = com.taobao.weex.c.b.l.ABSOLUTE;
        goto L_0x0495;
    L_0x04da:
        r0 = "left";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.m;
        r1 = r1[r2];
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x04f4:
        r1 = r12.a_;
        r1 = r1.m;
        r1[r2] = r0;
        r12.h();
        goto L_0x005a;
    L_0x04ff:
        r0 = "top";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.m;
        r1 = r1[r3];
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x0519:
        r1 = r12.a_;
        r1 = r1.m;
        r1[r3] = r0;
        r12.h();
        goto L_0x005a;
    L_0x0524:
        r0 = "right";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.m;
        r1 = r1[r4];
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x053e:
        r1 = r12.a_;
        r1 = r1.m;
        r1[r4] = r0;
        r12.h();
        goto L_0x005a;
    L_0x0549:
        r0 = "bottom";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r1 = r12.a_;
        r1 = r1.m;
        r1 = r1[r5];
        r1 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r1 != 0) goto L_0x005a;
    L_0x0563:
        r1 = r12.a_;
        r1 = r1.m;
        r1[r5] = r0;
        r12.h();
        goto L_0x005a;
    L_0x056e:
        r0 = "margin";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.a(r6, r0);
        goto L_0x005a;
    L_0x0581:
        r0 = "marginLeft";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x059b;
    L_0x0591:
        r0 = "margin";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x059b:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.a(r2, r0);
        goto L_0x005a;
    L_0x05a4:
        r0 = "marginTop";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x05be;
    L_0x05b4:
        r0 = "margin";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x05be:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.a(r3, r0);
        goto L_0x005a;
    L_0x05c7:
        r0 = "marginRight";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x05e1;
    L_0x05d7:
        r0 = "margin";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x05e1:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.a(r4, r0);
        goto L_0x005a;
    L_0x05ea:
        r0 = "marginBottom";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x0604;
    L_0x05fa:
        r0 = "margin";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x0604:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.a(r5, r0);
        goto L_0x005a;
    L_0x060d:
        r0 = r7.a(r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.c(r6, r0);
        goto L_0x005a;
    L_0x061a:
        r0 = "borderTopWidth";
        r0 = r7.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.c(r3, r0);
        goto L_0x005a;
    L_0x0629:
        r0 = "borderRightWidth";
        r0 = r7.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.c(r4, r0);
        goto L_0x005a;
    L_0x0638:
        r0 = "borderBottomWidth";
        r0 = r7.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.c(r5, r0);
        goto L_0x005a;
    L_0x0647:
        r0 = "borderLeftWidth";
        r0 = r7.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.c(r2, r0);
        goto L_0x005a;
    L_0x0656:
        r0 = "padding";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.b(r6, r0);
        goto L_0x005a;
    L_0x0669:
        r0 = "paddingLeft";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x0683;
    L_0x0679:
        r0 = "padding";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x0683:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.b(r2, r0);
        goto L_0x005a;
    L_0x068c:
        r0 = "paddingTop";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x06a6;
    L_0x069c:
        r0 = "padding";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x06a6:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.b(r3, r0);
        goto L_0x005a;
    L_0x06af:
        r0 = "paddingRight";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x06c9;
    L_0x06bf:
        r0 = "padding";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x06c9:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.b(r4, r0);
        goto L_0x005a;
    L_0x06d2:
        r0 = "paddingBottom";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
        r1 = java.lang.Float.isNaN(r0);
        if (r1 == 0) goto L_0x06ec;
    L_0x06e2:
        r0 = "padding";
        r0 = r7.get(r0);
        r0 = com.taobao.weex.utils.ah.a(r0, r8);
    L_0x06ec:
        r0 = com.taobao.weex.utils.WXViewUtils.a(r0, r8);
        r12.b(r5, r0);
        goto L_0x005a;
    L_0x06f5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.c.a.a(com.taobao.weex.c.ae):void");
    }
}
