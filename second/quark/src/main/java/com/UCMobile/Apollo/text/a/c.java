package com.UCMobile.Apollo.text.a;

import android.text.TextUtils;
import com.UCMobile.Apollo.b;
import com.UCMobile.Apollo.text.a.a.AnonymousClass1;
import com.UCMobile.Apollo.text.a.a.a;
import com.UCMobile.Apollo.text.e;
import com.UCMobile.Apollo.text.f;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class c implements f {
    private final b a = new b();
    private final com.UCMobile.Apollo.util.c b = new com.UCMobile.Apollo.util.c();
    private final a c = new a();

    public final /* synthetic */ e a(byte[] bArr, int i) throws b {
        return b(bArr, i);
    }

    public final e b(byte[] bArr, int i) throws b {
        Object obj;
        com.UCMobile.Apollo.util.c cVar = this.b;
        int i2 = i + 0;
        cVar.a = bArr;
        cVar.c = i2;
        cVar.b = 0;
        com.UCMobile.Apollo.util.c cVar2 = this.b;
        if (cVar2.c >= 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        cVar2.b = 0;
        this.c.a();
        d.a(this.b);
        do {
        } while (!TextUtils.isEmpty(this.b.a()));
        List arrayList = new ArrayList();
        while (this.a.a(this.b, this.c)) {
            a aVar = this.c;
            if (aVar.h != Float.MIN_VALUE && aVar.i == SectionHeader.SHT_LOUSER) {
                if (aVar.d != null) {
                    switch (AnonymousClass1.a[aVar.d.ordinal()]) {
                        case 1:
                            aVar.i = 0;
                            break;
                        case 2:
                            aVar.i = 1;
                            break;
                        case 3:
                            aVar.i = 2;
                            break;
                        default:
                            new StringBuilder("Unrecognized alignment: ").append(aVar.d);
                            aVar.i = 0;
                            break;
                    }
                }
                aVar.i = SectionHeader.SHT_LOUSER;
            }
            arrayList.add(new a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h, aVar.i, aVar.j));
            this.c.a();
        }
        return new e(arrayList);
    }
}
