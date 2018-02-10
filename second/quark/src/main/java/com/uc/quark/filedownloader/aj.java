package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.message.MessageSnapshot;
import com.uc.quark.filedownloader.message.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class aj {
    final ArrayList<at> a;

    private aj() {
        this.a = new ArrayList();
    }

    final int a(int i) {
        int i2 = 0;
        synchronized (this.a) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                int i3;
                if (((at) it.next()).d(i)) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public final at b(int i) {
        synchronized (this.a) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                if (atVar.d(i)) {
                    return atVar;
                }
            }
            return null;
        }
    }

    final List<at> c(int i) {
        List<at> arrayList = new ArrayList();
        synchronized (this.a) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                if (atVar.d(i) && !atVar.O()) {
                    arrayList.add(atVar);
                }
            }
        }
        return arrayList;
    }

    final boolean a(at atVar) {
        return !this.a.isEmpty() && this.a.contains(atVar);
    }

    public final at[] a() {
        at[] atVarArr;
        synchronized (this.a) {
            atVarArr = (at[]) this.a.toArray(new at[this.a.size()]);
        }
        return atVarArr;
    }

    public final boolean a(at atVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte i = messageSnapshot.i();
        synchronized (this.a) {
            remove = this.a.remove(atVar);
        }
        if (j.a && this.a.size() == 0) {
            j.f(this, "remove %s left %d %d", atVar, Byte.valueOf(i), Integer.valueOf(this.a.size()));
        }
        if (remove) {
            h b = atVar.N().b();
            switch (i) {
                case (byte) -5:
                    b.j(messageSnapshot);
                    break;
                case (byte) -4:
                    b.g(messageSnapshot);
                    break;
                case (byte) -3:
                    b.e(d.a(messageSnapshot));
                    break;
                case (byte) -2:
                    b.i(messageSnapshot);
                    break;
                case (byte) -1:
                    b.h(messageSnapshot);
                    break;
            }
        }
        j.b(this, "remove error, not exist: %s %d", atVar, Byte.valueOf(i));
        return remove;
    }

    final void b(at atVar) {
        if (!atVar.M().b()) {
            atVar.P();
        }
        if (atVar.N().b().a() && !atVar.J()) {
            synchronized (this.a) {
                if (this.a.contains(atVar)) {
                    j.e(this, "already has %s", atVar);
                } else {
                    atVar.I();
                    this.a.add(atVar);
                    if (j.a) {
                        j.f(this, "add list in all %s %d %d", atVar, Byte.valueOf(atVar.M().s()), Integer.valueOf(this.a.size()));
                    }
                }
            }
        }
    }
}
