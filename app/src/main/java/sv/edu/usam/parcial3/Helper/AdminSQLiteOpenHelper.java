package sv.edu.usam.parcial3.Helper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Contactos (cod int primary key ,nombre text," +
                " apellidos text,telefono text,email text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
