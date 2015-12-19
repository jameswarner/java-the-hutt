package com.mse.android.javathehutt.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by Bill on 12/18/15.
 */
public class MapCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public MapCursorWrapper(Cursor cursor) {
        super(cursor);
    }


}
