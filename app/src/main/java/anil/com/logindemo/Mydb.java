package anil.com.logindemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Anil on 03-Jul-17.
 */

public class Mydb extends SQLiteOpenHelper
{
    Context context;
    public Mydb(Context context) {
        super(context, "demo_db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="create table customers(name text, email text primary key,password text)";
        db.execSQL(qry);
        Toast.makeText(context,"Table created",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
