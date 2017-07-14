package anil.com.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText uname,upass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText)findViewById(R.id.uname);
        upass=(EditText)findViewById(R.id.upass);
    }

    public void callsignup(View v)
    {
        Intent i= new Intent(this,Register.class);
        startActivity(i);
    }

    public void login(View v)
    {
        String name=uname.getText().toString().trim();
        String pass=upass.getText().toString().trim();

        if(name.isEmpty())
        {
            uname.setError("Empty");
            uname.requestFocus();
        }else if(pass.isEmpty())
        {
            upass.setError("Empty");
            upass.requestFocus();
        }
        else
        {
            Mydb my= new Mydb(this);
            SQLiteDatabase db=my.getWritableDatabase();

            String qry= "select password from customers where email='"+name+"'";
            Cursor c= db.rawQuery(qry,null);
            boolean res= c.moveToFirst();
            if(res)
            {
                finish();
                Intent i= new Intent(this,welcome.class);
                startActivity(i);
            }else{
                Toast.makeText(this,"Invalid Username & Password",Toast.LENGTH_LONG).show();
                uname.setText("");
                upass.setText("");
            }

        }

    }
}
