package com.f.a.c;

import com.f.a.b.a.c;
import com.f.a.b.a.d;
import com.f.a.b.a.g;

/* compiled from: ProGuard */
public final class f {
    private String a;

    public f() {
        this.a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.a = g.a(this.a.getBytes(), 0);
    }

    public final String a(String str) {
        return d.b(this.a, str);
    }

    public final String b(String str) {
        String b = d.b(this.a, str);
        if (c.a(b)) {
            return null;
        }
        try {
            return new String(g.a(b));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
