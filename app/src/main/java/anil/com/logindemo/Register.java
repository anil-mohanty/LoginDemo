package anil.com.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {

    EditText et[] = new EditText[4];
    int ids[] = {R.id.name,R.id.email,R.id.pass1,R.id.pass2};
    String values[] = new String[et.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        for(int i=0;i<et.length;i++){
            et[i]=(EditText)findViewById(ids[i]);
        }
    }

    public void signup(View v)
    {
        int i;
        for (i=0;i<et.length;i++)
        {
            values[i] = et[i].getText().toString().trim();
            if (values[i].isEmpty())
            {
                et[i].requestFocus();
                et[i].setError("Empty");
                break;
            }
        }
        if(i== et.length)
        {
            if(values[2].equals(values[3]))
            {

                Mydb my = new Mydb(this);
                SQLiteDatabase db = my.getWritableDatabase();

                String qry = "insert into customers values('" + values[0] + "','" + values[1] + "','" + values[2] + "')";
                db.execSQL(qry);
                Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
            {
                et[3].requestFocus();
                et[3].setError("Not Matching");
            }

        }
        else {
            Toast.makeText(this,"Enter Data",Toast.LENGTH_LONG).show();
        }
    }
    public void Return(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
