package com.uc.weex.component.richtext.a;

import org.xml.sax.Attributes;

/* compiled from: ProGuard */
public final class a implements Attributes {
    int a;
    String[] b;

    public a() {
        this.a = 0;
        this.b = null;
    }

    public a(Attributes attributes) {
        a(attributes);
    }

    public final int getLength() {
        return this.a;
    }

    public final String getURI(int i) {
        if (i < 0 || i >= this.a) {
            return null;
        }
        return this.b[i * 5];
    }

    public final String getLocalName(int i) {
        if (i < 0 || i >= this.a) {
            return null;
        }
        return this.b[(i * 5) + 1];
    }

    public final String getQName(int i) {
        if (i < 0 || i >= this.a) {
            return null;
        }
        return this.b[(i * 5) + 2];
    }

    public final String getType(int i) {
        if (i < 0 || i >= this.a) {
            return null;
        }
        return this.b[(i * 5) + 3];
    }

    public final String getValue(int i) {
        if (i < 0 || i >= this.a) {
            return null;
        }
        return this.b[(i * 5) + 4];
    }

    public final int getIndex(String str, String str2) {
        int i = this.a * 5;
        int i2 = 0;
        while (i2 < i) {
            if (this.b[i2].equals(str) && this.b[i2 + 1].equals(str2)) {
                return i2 / 5;
            }
            i2 += 5;
        }
        return -1;
    }

    public final int getIndex(String str) {
        int i = this.a * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.b[i2 + 2].equals(str)) {
                return i2 / 5;
            }
        }
        return -1;
    }

    public final String getType(String str, String str2) {
        int i = this.a * 5;
        int i2 = 0;
        while (i2 < i) {
            if (this.b[i2].equals(str) && this.b[i2 + 1].equals(str2)) {
                return this.b[i2 + 3];
            }
            i2 += 5;
        }
        return null;
    }

    public final String getType(String str) {
        int i = this.a * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.b[i2 + 2].equals(str)) {
                return this.b[i2 + 3];
            }
        }
        return null;
    }

    public final String getValue(String str, String str2) {
        int i = this.a * 5;
        int i2 = 0;
        while (i2 < i) {
            if (this.b[i2].equals(str) && this.b[i2 + 1].equals(str2)) {
                return this.b[i2 + 4];
            }
            i2 += 5;
        }
        return null;
    }

    public final String getValue(String str) {
        int i = this.a * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.b[i2 + 2].equals(str)) {
                return this.b[i2 + 4];
            }
        }
        return null;
    }

    private void a(Attributes attributes) {
        int i = 0;
        if (this.b != null) {
            for (int i2 = 0; i2 < this.a * 5; i2++) {
                this.b[i2] = null;
            }
        }
        this.a = 0;
        this.a = attributes.getLength();
        if (this.a > 0) {
            this.b = new String[(this.a * 5)];
            while (i < this.a) {
                this.b[i * 5] = attributes.getURI(i);
                this.b[(i * 5) + 1] = attributes.getLocalName(i);
                this.b[(i * 5) + 2] = attributes.getQName(i);
                this.b[(i * 5) + 3] = attributes.getType(i);
                this.b[(i * 5) + 4] = attributes.getValue(i);
                i++;
            }
        }
    }

    public final void a(int i) {
        if (i < 0 || i >= this.a) {
            b(i);
            return;
        }
        if (i < this.a - 1) {
            System.arraycopy(this.b, (i + 1) * 5, this.b, i * 5, ((this.a - i) - 1) * 5);
        }
        int i2 = (this.a - 1) * 5;
        int i3 = i2 + 1;
        this.b[i2] = null;
        int i4 = i3 + 1;
        this.b[i3] = null;
        i3 = i4 + 1;
        this.b[i4] = null;
        i4 = i3 + 1;
        this.b[i3] = null;
        this.b[i4] = null;
        this.a--;
    }

    static void b(int i) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException("Attempt to modify attribute at illegal index: " + i);
    }
}
