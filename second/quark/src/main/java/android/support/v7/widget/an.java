package android.support.v7.widget;

import android.support.v4.d.m;
import android.support.v4.d.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class an implements bk {
    final ArrayList<ai> a;
    final ArrayList<ai> b;
    final z c;
    Runnable d;
    final boolean e;
    final am f;
    int g;
    private q<ai> h;

    an(z zVar) {
        this(zVar, (byte) 0);
    }

    private an(z zVar, byte b) {
        this.h = new m(30);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.g = 0;
        this.c = zVar;
        this.e = false;
        this.f = new am(this);
    }

    final void a() {
        a(this.a);
        a(this.b);
        this.g = 0;
    }

    final void b() {
        am amVar = this.f;
        List list = this.a;
        while (true) {
            int i;
            ai aiVar;
            int i2;
            int i3;
            Object obj = null;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj2;
                int i4;
                ai aiVar2;
                ai aiVar3;
                Object obj3;
                Object obj4;
                int size2;
                int i5;
                int i6;
                int i7;
                if (((ai) list.get(size)).a != 8) {
                    obj2 = 1;
                } else if (obj != null) {
                    i = size;
                    if (i != -1) {
                        i4 = i + 1;
                        aiVar2 = (ai) list.get(i);
                        aiVar3 = (ai) list.get(i4);
                        switch (aiVar3.a) {
                            case 1:
                                size = 0;
                                if (aiVar2.d < aiVar3.b) {
                                    size = -1;
                                }
                                if (aiVar2.b < aiVar3.b) {
                                    size++;
                                }
                                if (aiVar3.b <= aiVar2.b) {
                                    aiVar2.b += aiVar3.d;
                                }
                                if (aiVar3.b <= aiVar2.d) {
                                    aiVar2.d += aiVar3.d;
                                }
                                aiVar3.b = size + aiVar3.b;
                                list.set(i, aiVar3);
                                list.set(i4, aiVar2);
                                break;
                            case 2:
                                aiVar = null;
                                obj3 = null;
                                if (aiVar2.b < aiVar2.d) {
                                    obj4 = null;
                                    if (aiVar3.b == aiVar2.b && aiVar3.d == aiVar2.d - aiVar2.b) {
                                        obj3 = 1;
                                    }
                                } else {
                                    obj4 = 1;
                                    if (aiVar3.b == aiVar2.d + 1 && aiVar3.d == aiVar2.b - aiVar2.d) {
                                        obj3 = 1;
                                    }
                                }
                                if (aiVar2.d < aiVar3.b) {
                                    if (aiVar2.d < aiVar3.b + aiVar3.d) {
                                        aiVar3.d--;
                                        aiVar2.a = 2;
                                        aiVar2.d = 1;
                                        if (aiVar3.d != 0) {
                                            break;
                                        }
                                        list.remove(i4);
                                        amVar.a.a(aiVar3);
                                        break;
                                    }
                                }
                                aiVar3.b--;
                                if (aiVar2.b <= aiVar3.b) {
                                    aiVar3.b++;
                                } else if (aiVar2.b < aiVar3.b + aiVar3.d) {
                                    aiVar = amVar.a.a(2, aiVar2.b + 1, (aiVar3.b + aiVar3.d) - aiVar2.b, null);
                                    aiVar3.d = aiVar2.b - aiVar3.b;
                                }
                                if (obj3 == null) {
                                    if (obj4 == null) {
                                        if (aiVar != null) {
                                            if (aiVar2.b > aiVar.b) {
                                                aiVar2.b -= aiVar.d;
                                            }
                                            if (aiVar2.d > aiVar.b) {
                                                aiVar2.d -= aiVar.d;
                                            }
                                        }
                                        if (aiVar2.b > aiVar3.b) {
                                            aiVar2.b -= aiVar3.d;
                                        }
                                        if (aiVar2.d > aiVar3.b) {
                                            aiVar2.d -= aiVar3.d;
                                        }
                                    } else {
                                        if (aiVar != null) {
                                            if (aiVar2.b >= aiVar.b) {
                                                aiVar2.b -= aiVar.d;
                                            }
                                            if (aiVar2.d >= aiVar.b) {
                                                aiVar2.d -= aiVar.d;
                                            }
                                        }
                                        if (aiVar2.b >= aiVar3.b) {
                                            aiVar2.b -= aiVar3.d;
                                        }
                                        if (aiVar2.d >= aiVar3.b) {
                                            aiVar2.d -= aiVar3.d;
                                        }
                                    }
                                    list.set(i, aiVar3);
                                    if (aiVar2.b == aiVar2.d) {
                                        list.set(i4, aiVar2);
                                    } else {
                                        list.remove(i4);
                                    }
                                    if (aiVar == null) {
                                        break;
                                    }
                                    list.add(i, aiVar);
                                    break;
                                }
                                list.set(i, aiVar3);
                                list.remove(i4);
                                amVar.a.a(aiVar2);
                                break;
                            case 4:
                                obj4 = null;
                                obj3 = null;
                                if (aiVar2.d < aiVar3.b) {
                                    aiVar3.b--;
                                } else if (aiVar2.d < aiVar3.b + aiVar3.d) {
                                    aiVar3.d--;
                                    obj4 = amVar.a.a(4, aiVar2.b, 1, aiVar3.c);
                                }
                                if (aiVar2.b <= aiVar3.b) {
                                    aiVar3.b++;
                                } else if (aiVar2.b < aiVar3.b + aiVar3.d) {
                                    i2 = (aiVar3.b + aiVar3.d) - aiVar2.b;
                                    obj3 = amVar.a.a(4, aiVar2.b + 1, i2, aiVar3.c);
                                    aiVar3.d -= i2;
                                }
                                list.set(i4, aiVar2);
                                if (aiVar3.d <= 0) {
                                    list.set(i, aiVar3);
                                } else {
                                    list.remove(i);
                                    amVar.a.a(aiVar3);
                                }
                                if (obj4 != null) {
                                    list.add(i, obj4);
                                }
                                if (obj3 == null) {
                                    break;
                                }
                                list.add(i, obj3);
                                break;
                            default:
                                break;
                        }
                    }
                    size2 = this.a.size();
                    for (i = 0; i < size2; i++) {
                        aiVar2 = (ai) this.a.get(i);
                        switch (aiVar2.a) {
                            case 1:
                                c(aiVar2);
                                break;
                            case 2:
                                i4 = aiVar2.b;
                                i5 = aiVar2.d + aiVar2.b;
                                i2 = -1;
                                size = aiVar2.b;
                                i6 = 0;
                                while (size < i5) {
                                    obj = null;
                                    if (this.c.a(size) == null || c(size)) {
                                        if (i2 == 0) {
                                            b(a(2, i4, i6, null));
                                            obj = 1;
                                        }
                                        i2 = 1;
                                    } else {
                                        if (i2 == 1) {
                                            c(a(2, i4, i6, null));
                                            obj = 1;
                                        }
                                        i2 = 0;
                                    }
                                    if (obj == null) {
                                        i7 = size - i6;
                                        size = i5 - i6;
                                        i5 = 1;
                                    } else {
                                        i3 = size;
                                        size = i5;
                                        i5 = i6 + 1;
                                        i7 = i3;
                                    }
                                    i6 = i5;
                                    i5 = size;
                                    size = i7 + 1;
                                }
                                if (i6 != aiVar2.d) {
                                    a(aiVar2);
                                    aiVar2 = a(2, i4, i6, null);
                                }
                                if (i2 != 0) {
                                    c(aiVar2);
                                    break;
                                } else {
                                    b(aiVar2);
                                    break;
                                }
                                break;
                            case 4:
                                i2 = aiVar2.b;
                                i6 = aiVar2.b + aiVar2.d;
                                i5 = aiVar2.b;
                                i7 = 0;
                                size = i2;
                                i2 = -1;
                                while (i5 < i6) {
                                    if (this.c.a(i5) == null || c(i5)) {
                                        if (i2 == 0) {
                                            b(a(4, size, i7, aiVar2.c));
                                            i7 = 0;
                                            size = i5;
                                        }
                                        i2 = size;
                                        size = i7;
                                        i7 = 1;
                                    } else {
                                        if (i2 == 1) {
                                            c(a(4, size, i7, aiVar2.c));
                                            i7 = 0;
                                            size = i5;
                                        }
                                        i2 = size;
                                        size = i7;
                                        i7 = 0;
                                    }
                                    i5++;
                                    i3 = i7;
                                    i7 = size + 1;
                                    size = i2;
                                    i2 = i3;
                                }
                                if (i7 != aiVar2.d) {
                                    obj3 = aiVar2.c;
                                    a(aiVar2);
                                    aiVar2 = a(4, size, i7, obj3);
                                }
                                if (i2 != 0) {
                                    c(aiVar2);
                                    break;
                                } else {
                                    b(aiVar2);
                                    break;
                                }
                                break;
                            case 8:
                                c(aiVar2);
                                break;
                        }
                        if (this.d != null) {
                            this.d.run();
                        }
                    }
                    this.a.clear();
                    return;
                } else {
                    obj2 = obj;
                }
                size--;
                obj = obj2;
            }
            i = -1;
            if (i != -1) {
                i4 = i + 1;
                aiVar2 = (ai) list.get(i);
                aiVar3 = (ai) list.get(i4);
                switch (aiVar3.a) {
                    case 1:
                        size = 0;
                        if (aiVar2.d < aiVar3.b) {
                            size = -1;
                        }
                        if (aiVar2.b < aiVar3.b) {
                            size++;
                        }
                        if (aiVar3.b <= aiVar2.b) {
                            aiVar2.b += aiVar3.d;
                        }
                        if (aiVar3.b <= aiVar2.d) {
                            aiVar2.d += aiVar3.d;
                        }
                        aiVar3.b = size + aiVar3.b;
                        list.set(i, aiVar3);
                        list.set(i4, aiVar2);
                        break;
                    case 2:
                        aiVar = null;
                        obj3 = null;
                        if (aiVar2.b < aiVar2.d) {
                            obj4 = null;
                            obj3 = 1;
                            break;
                        }
                        obj4 = 1;
                        obj3 = 1;
                        break;
                        if (aiVar2.d < aiVar3.b) {
                            if (aiVar2.d < aiVar3.b + aiVar3.d) {
                                aiVar3.d--;
                                aiVar2.a = 2;
                                aiVar2.d = 1;
                                if (aiVar3.d != 0) {
                                    list.remove(i4);
                                    amVar.a.a(aiVar3);
                                    break;
                                }
                                break;
                            }
                        }
                        aiVar3.b--;
                        if (aiVar2.b <= aiVar3.b) {
                            aiVar3.b++;
                        } else if (aiVar2.b < aiVar3.b + aiVar3.d) {
                            aiVar = amVar.a.a(2, aiVar2.b + 1, (aiVar3.b + aiVar3.d) - aiVar2.b, null);
                            aiVar3.d = aiVar2.b - aiVar3.b;
                        }
                        if (obj3 == null) {
                            list.set(i, aiVar3);
                            list.remove(i4);
                            amVar.a.a(aiVar2);
                            break;
                        }
                        if (obj4 == null) {
                            if (aiVar != null) {
                                if (aiVar2.b >= aiVar.b) {
                                    aiVar2.b -= aiVar.d;
                                }
                                if (aiVar2.d >= aiVar.b) {
                                    aiVar2.d -= aiVar.d;
                                }
                            }
                            if (aiVar2.b >= aiVar3.b) {
                                aiVar2.b -= aiVar3.d;
                            }
                            if (aiVar2.d >= aiVar3.b) {
                                aiVar2.d -= aiVar3.d;
                            }
                        } else {
                            if (aiVar != null) {
                                if (aiVar2.b > aiVar.b) {
                                    aiVar2.b -= aiVar.d;
                                }
                                if (aiVar2.d > aiVar.b) {
                                    aiVar2.d -= aiVar.d;
                                }
                            }
                            if (aiVar2.b > aiVar3.b) {
                                aiVar2.b -= aiVar3.d;
                            }
                            if (aiVar2.d > aiVar3.b) {
                                aiVar2.d -= aiVar3.d;
                            }
                        }
                        list.set(i, aiVar3);
                        if (aiVar2.b == aiVar2.d) {
                            list.remove(i4);
                        } else {
                            list.set(i4, aiVar2);
                        }
                        if (aiVar == null) {
                            list.add(i, aiVar);
                            break;
                        }
                        break;
                    case 4:
                        obj4 = null;
                        obj3 = null;
                        if (aiVar2.d < aiVar3.b) {
                            aiVar3.b--;
                        } else if (aiVar2.d < aiVar3.b + aiVar3.d) {
                            aiVar3.d--;
                            obj4 = amVar.a.a(4, aiVar2.b, 1, aiVar3.c);
                        }
                        if (aiVar2.b <= aiVar3.b) {
                            aiVar3.b++;
                        } else if (aiVar2.b < aiVar3.b + aiVar3.d) {
                            i2 = (aiVar3.b + aiVar3.d) - aiVar2.b;
                            obj3 = amVar.a.a(4, aiVar2.b + 1, i2, aiVar3.c);
                            aiVar3.d -= i2;
                        }
                        list.set(i4, aiVar2);
                        if (aiVar3.d <= 0) {
                            list.remove(i);
                            amVar.a.a(aiVar3);
                        } else {
                            list.set(i, aiVar3);
                        }
                        if (obj4 != null) {
                            list.add(i, obj4);
                        }
                        if (obj3 == null) {
                            list.add(i, obj3);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            size2 = this.a.size();
            for (i = 0; i < size2; i++) {
                aiVar2 = (ai) this.a.get(i);
                switch (aiVar2.a) {
                    case 1:
                        c(aiVar2);
                        break;
                    case 2:
                        i4 = aiVar2.b;
                        i5 = aiVar2.d + aiVar2.b;
                        i2 = -1;
                        size = aiVar2.b;
                        i6 = 0;
                        while (size < i5) {
                            obj = null;
                            if (this.c.a(size) == null) {
                                break;
                            }
                            if (i2 == 0) {
                                b(a(2, i4, i6, null));
                                obj = 1;
                            }
                            i2 = 1;
                            if (obj == null) {
                                i3 = size;
                                size = i5;
                                i5 = i6 + 1;
                                i7 = i3;
                            } else {
                                i7 = size - i6;
                                size = i5 - i6;
                                i5 = 1;
                            }
                            i6 = i5;
                            i5 = size;
                            size = i7 + 1;
                        }
                        if (i6 != aiVar2.d) {
                            a(aiVar2);
                            aiVar2 = a(2, i4, i6, null);
                        }
                        if (i2 != 0) {
                            b(aiVar2);
                            break;
                        } else {
                            c(aiVar2);
                            break;
                        }
                    case 4:
                        i2 = aiVar2.b;
                        i6 = aiVar2.b + aiVar2.d;
                        i5 = aiVar2.b;
                        i7 = 0;
                        size = i2;
                        i2 = -1;
                        while (i5 < i6) {
                            if (this.c.a(i5) == null) {
                                break;
                            }
                            if (i2 == 0) {
                                b(a(4, size, i7, aiVar2.c));
                                i7 = 0;
                                size = i5;
                            }
                            i2 = size;
                            size = i7;
                            i7 = 1;
                            i5++;
                            i3 = i7;
                            i7 = size + 1;
                            size = i2;
                            i2 = i3;
                        }
                        if (i7 != aiVar2.d) {
                            obj3 = aiVar2.c;
                            a(aiVar2);
                            aiVar2 = a(4, size, i7, obj3);
                        }
                        if (i2 != 0) {
                            b(aiVar2);
                            break;
                        } else {
                            c(aiVar2);
                            break;
                        }
                    case 8:
                        c(aiVar2);
                        break;
                }
                if (this.d != null) {
                    this.d.run();
                }
            }
            this.a.clear();
            return;
        }
    }

    final void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.b((ai) this.b.get(i));
        }
        a(this.b);
        this.g = 0;
    }

    private void b(ai aiVar) {
        if (aiVar.a == 1 || aiVar.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = b(aiVar.b, aiVar.a);
        int i2 = aiVar.b;
        switch (aiVar.a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + aiVar);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < aiVar.d; i2++) {
            Object obj;
            int b2 = b(aiVar.b + (i * i2), aiVar.a);
            int i5;
            switch (aiVar.a) {
                case 2:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                ai a = a(aiVar.a, i4, i3, aiVar.c);
                a(a, b);
                a(a);
                if (aiVar.a == 4) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        Object obj2 = aiVar.c;
        a(aiVar);
        if (i3 > 0) {
            ai a2 = a(aiVar.a, i4, i3, obj2);
            a(a2, b);
            a(a2);
        }
    }

    private void a(ai aiVar, int i) {
        this.c.a(aiVar);
        switch (aiVar.a) {
            case 2:
                this.c.a(i, aiVar.d);
                return;
            case 4:
                this.c.a(i, aiVar.d, aiVar.c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int b(int i, int i2) {
        int i3;
        int size = this.b.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            ai aiVar = (ai) this.b.get(size);
            if (aiVar.a == 8) {
                int i6;
                if (aiVar.b < aiVar.d) {
                    i6 = aiVar.b;
                    i3 = aiVar.d;
                } else {
                    i6 = aiVar.d;
                    i3 = aiVar.b;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < aiVar.b) {
                        if (i2 == 1) {
                            aiVar.b++;
                            aiVar.d++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            aiVar.b--;
                            aiVar.d--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == aiVar.b) {
                    if (i2 == 1) {
                        aiVar.d++;
                    } else if (i2 == 2) {
                        aiVar.d--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        aiVar.b++;
                    } else if (i2 == 2) {
                        aiVar.b--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (aiVar.b <= i4) {
                    if (aiVar.a == 1) {
                        i5 = i4 - aiVar.d;
                    } else if (aiVar.a == 2) {
                        i5 = aiVar.d + i4;
                    }
                } else if (i2 == 1) {
                    aiVar.b++;
                    i5 = i4;
                } else if (i2 == 2) {
                    aiVar.b--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.b.size() - 1; i3 >= 0; i3--) {
            aiVar = (ai) this.b.get(i3);
            if (aiVar.a == 8) {
                if (aiVar.d == aiVar.b || aiVar.d < 0) {
                    this.b.remove(i3);
                    a(aiVar);
                }
            } else if (aiVar.d <= 0) {
                this.b.remove(i3);
                a(aiVar);
            }
        }
        return i4;
    }

    private boolean c(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ai aiVar = (ai) this.b.get(i2);
            if (aiVar.a == 8) {
                if (a(aiVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (aiVar.a == 1) {
                int i3 = aiVar.b + aiVar.d;
                for (int i4 = aiVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void c(ai aiVar) {
        this.b.add(aiVar);
        switch (aiVar.a) {
            case 1:
                this.c.c(aiVar.b, aiVar.d);
                return;
            case 2:
                this.c.b(aiVar.b, aiVar.d);
                return;
            case 4:
                this.c.a(aiVar.b, aiVar.d, aiVar.c);
                return;
            case 8:
                this.c.d(aiVar.b, aiVar.d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + aiVar);
        }
    }

    final boolean d() {
        return this.a.size() > 0;
    }

    final boolean a(int i) {
        return (this.g & i) != 0;
    }

    final int b(int i) {
        return a(i, 0);
    }

    final int a(int i, int i2) {
        int size = this.b.size();
        int i3 = i;
        while (i2 < size) {
            ai aiVar = (ai) this.b.get(i2);
            if (aiVar.a == 8) {
                if (aiVar.b == i3) {
                    i3 = aiVar.d;
                } else {
                    if (aiVar.b < i3) {
                        i3--;
                    }
                    if (aiVar.d <= i3) {
                        i3++;
                    }
                }
            } else if (aiVar.b > i3) {
                continue;
            } else if (aiVar.a == 2) {
                if (i3 < aiVar.b + aiVar.d) {
                    return -1;
                }
                i3 -= aiVar.d;
            } else if (aiVar.a == 1) {
                i3 += aiVar.d;
            }
            i2++;
        }
        return i3;
    }

    final void e() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ai aiVar = (ai) this.a.get(i);
            switch (aiVar.a) {
                case 1:
                    this.c.b(aiVar);
                    this.c.c(aiVar.b, aiVar.d);
                    break;
                case 2:
                    this.c.b(aiVar);
                    this.c.a(aiVar.b, aiVar.d);
                    break;
                case 4:
                    this.c.b(aiVar);
                    this.c.a(aiVar.b, aiVar.d, aiVar.c);
                    break;
                case 8:
                    this.c.b(aiVar);
                    this.c.d(aiVar.b, aiVar.d);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
        this.g = 0;
    }

    public final ai a(int i, int i2, int i3, Object obj) {
        ai aiVar = (ai) this.h.a();
        if (aiVar == null) {
            return new ai(i, i2, i3, obj);
        }
        aiVar.a = i;
        aiVar.b = i2;
        aiVar.d = i3;
        aiVar.c = obj;
        return aiVar;
    }

    public final void a(ai aiVar) {
        if (!this.e) {
            aiVar.c = null;
            this.h.a(aiVar);
        }
    }

    private void a(List<ai> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a((ai) list.get(i));
        }
        list.clear();
    }
}
