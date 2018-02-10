package android.mini.support.v7.widget;

import android.mini.support.v4.d.n;
import android.mini.support.v4.d.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class c implements ab {
    final ArrayList<b> a;
    final ArrayList<b> b;
    final a c;
    Runnable d;
    final boolean e;
    final ac f;
    int g;
    private n<b> h;

    c(a aVar) {
        this(aVar, (byte) 0);
    }

    private c(a aVar, byte b) {
        this.h = new o(30);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.g = 0;
        this.c = aVar;
        this.e = false;
        this.f = new ac(this);
    }

    final void a() {
        a(this.a);
        a(this.b);
        this.g = 0;
    }

    final void b() {
        ac acVar = this.f;
        List list = this.a;
        while (true) {
            int i;
            Object obj;
            Object obj2;
            int i2;
            int i3;
            int i4;
            int i5;
            Object obj3 = null;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj4;
                int i6;
                b bVar;
                b bVar2;
                b bVar3;
                int i7;
                int size2;
                if (((b) list.get(size)).a != 8) {
                    obj4 = 1;
                } else if (obj3 != null) {
                    i = size;
                    if (i != -1) {
                        i6 = i + 1;
                        bVar = (b) list.get(i);
                        bVar2 = (b) list.get(i6);
                        switch (bVar2.a) {
                            case 1:
                                size = 0;
                                if (bVar.d < bVar2.b) {
                                    size = -1;
                                }
                                if (bVar.b < bVar2.b) {
                                    size++;
                                }
                                if (bVar2.b <= bVar.b) {
                                    bVar.b += bVar2.d;
                                }
                                if (bVar2.b <= bVar.d) {
                                    bVar.d += bVar2.d;
                                }
                                bVar2.b = size + bVar2.b;
                                list.set(i, bVar2);
                                list.set(i6, bVar);
                                break;
                            case 2:
                                bVar3 = null;
                                obj = null;
                                if (bVar.b < bVar.d) {
                                    obj2 = null;
                                    if (bVar2.b == bVar.b && bVar2.d == bVar.d - bVar.b) {
                                        obj = 1;
                                    }
                                } else {
                                    obj2 = 1;
                                    if (bVar2.b == bVar.d + 1 && bVar2.d == bVar.b - bVar.d) {
                                        obj = 1;
                                    }
                                }
                                if (bVar.d < bVar2.b) {
                                    if (bVar.d < bVar2.b + bVar2.d) {
                                        bVar2.d--;
                                        bVar.a = 2;
                                        bVar.d = 1;
                                        if (bVar2.d != 0) {
                                            break;
                                        }
                                        list.remove(i6);
                                        acVar.a.a(bVar2);
                                        break;
                                    }
                                }
                                bVar2.b--;
                                if (bVar.b <= bVar2.b) {
                                    bVar2.b++;
                                } else if (bVar.b < bVar2.b + bVar2.d) {
                                    bVar3 = acVar.a.a(2, bVar.b + 1, (bVar2.b + bVar2.d) - bVar.b, null);
                                    bVar2.d = bVar.b - bVar2.b;
                                }
                                if (obj == null) {
                                    if (obj2 == null) {
                                        if (bVar3 != null) {
                                            if (bVar.b > bVar3.b) {
                                                bVar.b -= bVar3.d;
                                            }
                                            if (bVar.d > bVar3.b) {
                                                bVar.d -= bVar3.d;
                                            }
                                        }
                                        if (bVar.b > bVar2.b) {
                                            bVar.b -= bVar2.d;
                                        }
                                        if (bVar.d > bVar2.b) {
                                            bVar.d -= bVar2.d;
                                        }
                                    } else {
                                        if (bVar3 != null) {
                                            if (bVar.b >= bVar3.b) {
                                                bVar.b -= bVar3.d;
                                            }
                                            if (bVar.d >= bVar3.b) {
                                                bVar.d -= bVar3.d;
                                            }
                                        }
                                        if (bVar.b >= bVar2.b) {
                                            bVar.b -= bVar2.d;
                                        }
                                        if (bVar.d >= bVar2.b) {
                                            bVar.d -= bVar2.d;
                                        }
                                    }
                                    list.set(i, bVar2);
                                    if (bVar.b == bVar.d) {
                                        list.set(i6, bVar);
                                    } else {
                                        list.remove(i6);
                                    }
                                    if (bVar3 == null) {
                                        break;
                                    }
                                    list.add(i, bVar3);
                                    break;
                                }
                                list.set(i, bVar2);
                                list.remove(i6);
                                acVar.a.a(bVar);
                                break;
                            case 4:
                                obj2 = null;
                                obj = null;
                                if (bVar.d < bVar2.b) {
                                    bVar2.b--;
                                } else if (bVar.d < bVar2.b + bVar2.d) {
                                    bVar2.d--;
                                    obj2 = acVar.a.a(4, bVar.b, 1, bVar2.c);
                                }
                                if (bVar.b <= bVar2.b) {
                                    bVar2.b++;
                                } else if (bVar.b < bVar2.b + bVar2.d) {
                                    i7 = (bVar2.b + bVar2.d) - bVar.b;
                                    obj = acVar.a.a(4, bVar.b + 1, i7, bVar2.c);
                                    bVar2.d -= i7;
                                }
                                list.set(i6, bVar);
                                if (bVar2.d <= 0) {
                                    list.set(i, bVar2);
                                } else {
                                    list.remove(i);
                                    acVar.a.a(bVar2);
                                }
                                if (obj2 != null) {
                                    list.add(i, obj2);
                                }
                                if (obj == null) {
                                    break;
                                }
                                list.add(i, obj);
                                break;
                            default:
                                break;
                        }
                    }
                    size2 = this.a.size();
                    for (i = 0; i < size2; i++) {
                        bVar = (b) this.a.get(i);
                        switch (bVar.a) {
                            case 1:
                                c(bVar);
                                break;
                            case 2:
                                i6 = bVar.b;
                                i2 = bVar.d + bVar.b;
                                i7 = -1;
                                size = bVar.b;
                                i3 = 0;
                                while (size < i2) {
                                    obj3 = null;
                                    if (this.c.a(size) == null || c(size)) {
                                        if (i7 == 0) {
                                            b(a(2, i6, i3, null));
                                            obj3 = 1;
                                        }
                                        i7 = 1;
                                    } else {
                                        if (i7 == 1) {
                                            c(a(2, i6, i3, null));
                                            obj3 = 1;
                                        }
                                        i7 = 0;
                                    }
                                    if (obj3 == null) {
                                        i4 = size - i3;
                                        size = i2 - i3;
                                        i2 = 1;
                                    } else {
                                        i5 = size;
                                        size = i2;
                                        i2 = i3 + 1;
                                        i4 = i5;
                                    }
                                    i3 = i2;
                                    i2 = size;
                                    size = i4 + 1;
                                }
                                if (i3 != bVar.d) {
                                    a(bVar);
                                    bVar = a(2, i6, i3, null);
                                }
                                if (i7 != 0) {
                                    c(bVar);
                                    break;
                                } else {
                                    b(bVar);
                                    break;
                                }
                                break;
                            case 4:
                                i7 = bVar.b;
                                i3 = bVar.b + bVar.d;
                                i2 = bVar.b;
                                i4 = 0;
                                size = i7;
                                i7 = -1;
                                while (i2 < i3) {
                                    if (this.c.a(i2) == null || c(i2)) {
                                        if (i7 == 0) {
                                            b(a(4, size, i4, bVar.c));
                                            i4 = 0;
                                            size = i2;
                                        }
                                        i7 = size;
                                        size = i4;
                                        i4 = 1;
                                    } else {
                                        if (i7 == 1) {
                                            c(a(4, size, i4, bVar.c));
                                            i4 = 0;
                                            size = i2;
                                        }
                                        i7 = size;
                                        size = i4;
                                        i4 = 0;
                                    }
                                    i2++;
                                    i5 = i4;
                                    i4 = size + 1;
                                    size = i7;
                                    i7 = i5;
                                }
                                if (i4 != bVar.d) {
                                    obj = bVar.c;
                                    a(bVar);
                                    bVar = a(4, size, i4, obj);
                                }
                                if (i7 != 0) {
                                    c(bVar);
                                    break;
                                } else {
                                    b(bVar);
                                    break;
                                }
                                break;
                            case 8:
                                c(bVar);
                                break;
                        }
                        if (this.d != null) {
                            this.d.run();
                        }
                    }
                    this.a.clear();
                    return;
                } else {
                    obj4 = obj3;
                }
                size--;
                obj3 = obj4;
            }
            i = -1;
            if (i != -1) {
                i6 = i + 1;
                bVar = (b) list.get(i);
                bVar2 = (b) list.get(i6);
                switch (bVar2.a) {
                    case 1:
                        size = 0;
                        if (bVar.d < bVar2.b) {
                            size = -1;
                        }
                        if (bVar.b < bVar2.b) {
                            size++;
                        }
                        if (bVar2.b <= bVar.b) {
                            bVar.b += bVar2.d;
                        }
                        if (bVar2.b <= bVar.d) {
                            bVar.d += bVar2.d;
                        }
                        bVar2.b = size + bVar2.b;
                        list.set(i, bVar2);
                        list.set(i6, bVar);
                        break;
                    case 2:
                        bVar3 = null;
                        obj = null;
                        if (bVar.b < bVar.d) {
                            obj2 = null;
                            obj = 1;
                            break;
                        }
                        obj2 = 1;
                        obj = 1;
                        break;
                        if (bVar.d < bVar2.b) {
                            if (bVar.d < bVar2.b + bVar2.d) {
                                bVar2.d--;
                                bVar.a = 2;
                                bVar.d = 1;
                                if (bVar2.d != 0) {
                                    list.remove(i6);
                                    acVar.a.a(bVar2);
                                    break;
                                }
                                break;
                            }
                        }
                        bVar2.b--;
                        if (bVar.b <= bVar2.b) {
                            bVar2.b++;
                        } else if (bVar.b < bVar2.b + bVar2.d) {
                            bVar3 = acVar.a.a(2, bVar.b + 1, (bVar2.b + bVar2.d) - bVar.b, null);
                            bVar2.d = bVar.b - bVar2.b;
                        }
                        if (obj == null) {
                            list.set(i, bVar2);
                            list.remove(i6);
                            acVar.a.a(bVar);
                            break;
                        }
                        if (obj2 == null) {
                            if (bVar3 != null) {
                                if (bVar.b >= bVar3.b) {
                                    bVar.b -= bVar3.d;
                                }
                                if (bVar.d >= bVar3.b) {
                                    bVar.d -= bVar3.d;
                                }
                            }
                            if (bVar.b >= bVar2.b) {
                                bVar.b -= bVar2.d;
                            }
                            if (bVar.d >= bVar2.b) {
                                bVar.d -= bVar2.d;
                            }
                        } else {
                            if (bVar3 != null) {
                                if (bVar.b > bVar3.b) {
                                    bVar.b -= bVar3.d;
                                }
                                if (bVar.d > bVar3.b) {
                                    bVar.d -= bVar3.d;
                                }
                            }
                            if (bVar.b > bVar2.b) {
                                bVar.b -= bVar2.d;
                            }
                            if (bVar.d > bVar2.b) {
                                bVar.d -= bVar2.d;
                            }
                        }
                        list.set(i, bVar2);
                        if (bVar.b == bVar.d) {
                            list.remove(i6);
                        } else {
                            list.set(i6, bVar);
                        }
                        if (bVar3 == null) {
                            list.add(i, bVar3);
                            break;
                        }
                        break;
                    case 4:
                        obj2 = null;
                        obj = null;
                        if (bVar.d < bVar2.b) {
                            bVar2.b--;
                        } else if (bVar.d < bVar2.b + bVar2.d) {
                            bVar2.d--;
                            obj2 = acVar.a.a(4, bVar.b, 1, bVar2.c);
                        }
                        if (bVar.b <= bVar2.b) {
                            bVar2.b++;
                        } else if (bVar.b < bVar2.b + bVar2.d) {
                            i7 = (bVar2.b + bVar2.d) - bVar.b;
                            obj = acVar.a.a(4, bVar.b + 1, i7, bVar2.c);
                            bVar2.d -= i7;
                        }
                        list.set(i6, bVar);
                        if (bVar2.d <= 0) {
                            list.remove(i);
                            acVar.a.a(bVar2);
                        } else {
                            list.set(i, bVar2);
                        }
                        if (obj2 != null) {
                            list.add(i, obj2);
                        }
                        if (obj == null) {
                            list.add(i, obj);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            size2 = this.a.size();
            for (i = 0; i < size2; i++) {
                bVar = (b) this.a.get(i);
                switch (bVar.a) {
                    case 1:
                        c(bVar);
                        break;
                    case 2:
                        i6 = bVar.b;
                        i2 = bVar.d + bVar.b;
                        i7 = -1;
                        size = bVar.b;
                        i3 = 0;
                        while (size < i2) {
                            obj3 = null;
                            if (this.c.a(size) == null) {
                                break;
                            }
                            if (i7 == 0) {
                                b(a(2, i6, i3, null));
                                obj3 = 1;
                            }
                            i7 = 1;
                            if (obj3 == null) {
                                i5 = size;
                                size = i2;
                                i2 = i3 + 1;
                                i4 = i5;
                            } else {
                                i4 = size - i3;
                                size = i2 - i3;
                                i2 = 1;
                            }
                            i3 = i2;
                            i2 = size;
                            size = i4 + 1;
                        }
                        if (i3 != bVar.d) {
                            a(bVar);
                            bVar = a(2, i6, i3, null);
                        }
                        if (i7 != 0) {
                            b(bVar);
                            break;
                        } else {
                            c(bVar);
                            break;
                        }
                    case 4:
                        i7 = bVar.b;
                        i3 = bVar.b + bVar.d;
                        i2 = bVar.b;
                        i4 = 0;
                        size = i7;
                        i7 = -1;
                        while (i2 < i3) {
                            if (this.c.a(i2) == null) {
                                break;
                            }
                            if (i7 == 0) {
                                b(a(4, size, i4, bVar.c));
                                i4 = 0;
                                size = i2;
                            }
                            i7 = size;
                            size = i4;
                            i4 = 1;
                            i2++;
                            i5 = i4;
                            i4 = size + 1;
                            size = i7;
                            i7 = i5;
                        }
                        if (i4 != bVar.d) {
                            obj = bVar.c;
                            a(bVar);
                            bVar = a(4, size, i4, obj);
                        }
                        if (i7 != 0) {
                            b(bVar);
                            break;
                        } else {
                            c(bVar);
                            break;
                        }
                    case 8:
                        c(bVar);
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
            this.c.b((b) this.b.get(i));
        }
        a(this.b);
        this.g = 0;
    }

    private void b(b bVar) {
        if (bVar.a == 1 || bVar.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = b(bVar.b, bVar.a);
        int i2 = bVar.b;
        switch (bVar.a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < bVar.d; i2++) {
            Object obj;
            int b2 = b(bVar.b + (i * i2), bVar.a);
            int i5;
            switch (bVar.a) {
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
                b a = a(bVar.a, i4, i3, bVar.c);
                a(a, b);
                a(a);
                if (bVar.a == 4) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        Object obj2 = bVar.c;
        a(bVar);
        if (i3 > 0) {
            b a2 = a(bVar.a, i4, i3, obj2);
            a(a2, b);
            a(a2);
        }
    }

    private void a(b bVar, int i) {
        this.c.a(bVar);
        switch (bVar.a) {
            case 2:
                this.c.a(i, bVar.d);
                return;
            case 4:
                this.c.a(i, bVar.d, bVar.c);
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
            b bVar = (b) this.b.get(size);
            if (bVar.a == 8) {
                int i6;
                if (bVar.b < bVar.d) {
                    i6 = bVar.b;
                    i3 = bVar.d;
                } else {
                    i6 = bVar.d;
                    i3 = bVar.b;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < bVar.b) {
                        if (i2 == 1) {
                            bVar.b++;
                            bVar.d++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            bVar.b--;
                            bVar.d--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == bVar.b) {
                    if (i2 == 1) {
                        bVar.d++;
                    } else if (i2 == 2) {
                        bVar.d--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.b++;
                    } else if (i2 == 2) {
                        bVar.b--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (bVar.b <= i4) {
                    if (bVar.a == 1) {
                        i5 = i4 - bVar.d;
                    } else if (bVar.a == 2) {
                        i5 = bVar.d + i4;
                    }
                } else if (i2 == 1) {
                    bVar.b++;
                    i5 = i4;
                } else if (i2 == 2) {
                    bVar.b--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.b.size() - 1; i3 >= 0; i3--) {
            bVar = (b) this.b.get(i3);
            if (bVar.a == 8) {
                if (bVar.d == bVar.b || bVar.d < 0) {
                    this.b.remove(i3);
                    a(bVar);
                }
            } else if (bVar.d <= 0) {
                this.b.remove(i3);
                a(bVar);
            }
        }
        return i4;
    }

    private boolean c(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.b.get(i2);
            if (bVar.a == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.a == 1) {
                int i3 = bVar.b + bVar.d;
                for (int i4 = bVar.b; i4 < i3; i4++) {
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

    private void c(b bVar) {
        this.b.add(bVar);
        switch (bVar.a) {
            case 1:
                this.c.c(bVar.b, bVar.d);
                return;
            case 2:
                this.c.b(bVar.b, bVar.d);
                return;
            case 4:
                this.c.a(bVar.b, bVar.d, bVar.c);
                return;
            case 8:
                this.c.d(bVar.b, bVar.d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
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
            b bVar = (b) this.b.get(i2);
            if (bVar.a == 8) {
                if (bVar.b == i3) {
                    i3 = bVar.d;
                } else {
                    if (bVar.b < i3) {
                        i3--;
                    }
                    if (bVar.d <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.b > i3) {
                continue;
            } else if (bVar.a == 2) {
                if (i3 < bVar.b + bVar.d) {
                    return -1;
                }
                i3 -= bVar.d;
            } else if (bVar.a == 1) {
                i3 += bVar.d;
            }
            i2++;
        }
        return i3;
    }

    final void e() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.a.get(i);
            switch (bVar.a) {
                case 1:
                    this.c.b(bVar);
                    this.c.c(bVar.b, bVar.d);
                    break;
                case 2:
                    this.c.b(bVar);
                    this.c.a(bVar.b, bVar.d);
                    break;
                case 4:
                    this.c.b(bVar);
                    this.c.a(bVar.b, bVar.d, bVar.c);
                    break;
                case 8:
                    this.c.b(bVar);
                    this.c.d(bVar.b, bVar.d);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
        this.g = 0;
    }

    public final b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.h.a();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.a = i;
        bVar.b = i2;
        bVar.d = i3;
        bVar.c = obj;
        return bVar;
    }

    public final void a(b bVar) {
        if (!this.e) {
            bVar.c = null;
            this.h.a(bVar);
        }
    }

    private void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a((b) list.get(i));
        }
        list.clear();
    }
}
