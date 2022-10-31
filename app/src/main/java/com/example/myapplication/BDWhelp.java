package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;

public class BDWhelp extends SQLiteOpenHelper{

    private final Context context;
    private static final String DataBase_Name = "AC.db";
    private static final int DataBase_Version = 1;

    private static final String Table_Name = "User";
    private static final String ID = "id";
    private static String Column_Login = "login";
    private static final String Column_Password = "password";
    private static final String Column_EMail = "email";

    public BDWhelp(@Nullable Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "Create Table " + Table_Name +
                        " (" + ID + " Integer PRIMARY KEY AUTOINCREMENT, " +
                        Column_Login + " Text, " +
                        Column_EMail + " Text, " +
                        Column_Password + " Text);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists " + Table_Name);
        onCreate(db);
    }

    void add_users(String log, String password, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Column_Login, log);
        cv.put(Column_Password, password);
        cv.put(Column_EMail, email);

        long result = db.insert(Table_Name,null, cv);
        if(result == -1)
        {
            Toast.makeText(context,"Ошибка, профиль не добавлен", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Пользователь успешно добавлен", Toast.LENGTH_SHORT).show();
        }

    }

    void search(String log, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * from " + Table_Name + " where " + Column_Login + " = " + log + " and " + Column_Password + " = " + password, null);
        /*if(cursor.getCount() == 0){
            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Ваш аккаунт есть", Toast.LENGTH_SHORT).show(); Не работает проверка на сущ пользователя
        }*/

    }



}
