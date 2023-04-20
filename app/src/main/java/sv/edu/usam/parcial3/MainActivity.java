package sv.edu.usam.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import sv.edu.usam.parcial3.Helper.AdminSQLiteOpenHelper;
public class MainActivity extends AppCompatActivity {
EditText txtName,txtEmail,txtTel,txtApe,txtCod;
Button btnInserts,btnUpdates,btnDeletes,btnsBuscar,btnApe,btnTel,btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCod=findViewById(R.id.edtCod);
        txtName=findViewById(R.id.edtName);
        txtApe=findViewById(R.id.edtApe);
        txtTel=findViewById(R.id.edtTel);
        txtEmail=findViewById(R.id.edtEmail);
        btnInserts=findViewById(R.id.btnInsert);
        btnUpdates=findViewById(R.id.btnUpdate);
        btnDeletes=findViewById(R.id.btnDelete);
        btnsBuscar=findViewById(R.id.btnBuscar);
        btnApe=findViewById(R.id.btnBApe);
        btnEmail=findViewById(R.id.btnBemail);
        btnTel=findViewById(R.id.btnBtel);

        btnInserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();
                String cod=txtCod.getText().toString();
                String nom=txtName.getText().toString();
                String ape=txtApe.getText().toString();
                String tel=txtTel.getText().toString();
                String email=txtEmail.getText().toString();

                ContentValues informacion =new ContentValues();

                informacion.put("cod",cod);
                informacion.put("nombre",nom);
                informacion.put("apellidos",ape);
                informacion.put("telefono",tel);
                informacion.put("email",email);
                db.insert("Contactos",null,informacion);
                db.close();
                Toast.makeText(getApplicationContext(),"Datos Ingresados",Toast.LENGTH_SHORT).show();

            }
        });

        btnUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();
                //update por codigo
                String cod=txtCod.getText().toString();
                String nom=txtName.getText().toString();
                String ape=txtApe.getText().toString();
                String tel=txtTel.getText().toString();
                String email=txtEmail.getText().toString();

                ContentValues informacion =new ContentValues();

                informacion.put("cod",cod);
                informacion.put("nombre",nom);
                informacion.put("apellidos",ape);
                informacion.put("telefono",tel);
                informacion.put("email",email);

                int cat=db.update("Contactos",informacion,"cod="+cod,null);
                db.close();

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el dato",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"No modifico el dato",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnDeletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();

                String cod=txtCod.getText().toString();
                int cat=db.delete("Contactos",
                        "cod="+cod,null);
                db.close();

                    txtCod.setText("");
                 txtName.setText("");
                 txtApe.setText("");
                 txtTel.setText("");
                 txtEmail.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro el dato",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"No se borro el dato",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnsBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();

                String nom=txtName.getText().toString();
                Cursor filas =db.rawQuery("select cod,nombre,apellidos,telefono,email" +
                        " from Contactos where nombre='"+nom+"'",null);

                if(filas.moveToFirst()){
                    txtCod.setText(filas.getString(0));
                    txtName.setText(filas.getString(1));
                    txtApe.setText(filas.getString(2));
                    txtTel.setText(filas.getString(3));
                    txtEmail.setText(filas.getString(4));
                }else {
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el nombre",Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });
        btnApe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();

                String ape=txtApe.getText().toString();

                Cursor filas =db.rawQuery("select cod,nombre,apellidos,telefono,email" +
                        " from Contactos where apellidos='"+ape+"'",null);

                if(filas.moveToFirst()){
                    txtCod.setText(filas.getString(0));
                    txtName.setText(filas.getString(1));
                    txtApe.setText(filas.getString(2));
                    txtTel.setText(filas.getString(3));
                    txtEmail.setText(filas.getString(4));
                }else {
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el Apellido",Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();

                String tel=txtTel.getText().toString();

                Cursor filas =db.rawQuery("select cod,nombre,apellidos,telefono,email" +
                        " from Contactos where telefono='"+tel+"'",null);

                if(filas.moveToFirst()){
                    txtCod.setText(filas.getString(0));
                    txtName.setText(filas.getString(1));
                    txtApe.setText(filas.getString(2));
                    txtTel.setText(filas.getString(3));
                    txtEmail.setText(filas.getString(4));
                }else {
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el N° de Telefono",Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,1);
                SQLiteDatabase db= admin.getWritableDatabase();

                String mail=txtEmail.getText().toString();

                Cursor filas =db.rawQuery("select cod,nombre,apellidos,telefono,email" +
                        " from Contactos where email='"+mail+"'",null);

                if(filas.moveToFirst()){
                    txtCod.setText(filas.getString(0));
                    txtName.setText(filas.getString(1));
                    txtApe.setText(filas.getString(2));
                    txtTel.setText(filas.getString(3));
                    txtEmail.setText(filas.getString(4));
                }else {
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el N° de Telefono",Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });
    }
}