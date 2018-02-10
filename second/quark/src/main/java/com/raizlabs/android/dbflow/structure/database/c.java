package com.raizlabs.android.dbflow.structure.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: ProGuard */
public final class c extends CursorWrapper {
    public Cursor a;

    public static c a(@NonNull Cursor cursor) {
        if (cursor instanceof c) {
            return (c) cursor;
        }
        return new c(cursor);
    }

    private c(@NonNull Cursor cursor) {
        super(cursor);
        this.a = cursor;
    }

    public final Cursor getWrappedCursor() {
        return this.a;
    }

    @Nullable
    public final String a(String str) {
        int columnIndex = this.a.getColumnIndex(str);
        if (columnIndex == -1 || this.a.isNull(columnIndex)) {
            return null;
        }
        return this.a.getString(columnIndex);
    }

    public final int b(String str) {
        int columnIndex = this.a.getColumnIndex(str);
        if (columnIndex == -1 || this.a.isNull(columnIndex)) {
            return 0;
        }
        return this.a.getInt(columnIndex);
    }

    public final long c(String str) {
        int columnIndex = this.a.getColumnIndex(str);
        if (columnIndex == -1 || this.a.isNull(columnIndex)) {
            return 0;
        }
        return this.a.getLong(columnIndex);
    }
}
