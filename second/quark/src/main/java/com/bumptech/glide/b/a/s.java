package com.bumptech.glide.b.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class s extends q<InputStream> {
    private static final UriMatcher a;

    protected final /* synthetic */ Object a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        Object openContactPhotoInputStream;
        switch (a.match(uri)) {
            case 1:
                Uri lookupContact = Contacts.lookupContact(contentResolver, uri);
                if (lookupContact != null) {
                    openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
                    break;
                }
                throw new FileNotFoundException("Contact cannot be found");
            case 3:
                openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, uri, true);
                break;
            default:
                openContactPhotoInputStream = contentResolver.openInputStream(uri);
                break;
        }
        if (openContactPhotoInputStream != null) {
            return openContactPhotoInputStream;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    protected final /* synthetic */ void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        a = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public s(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<InputStream> d() {
        return InputStream.class;
    }
}
