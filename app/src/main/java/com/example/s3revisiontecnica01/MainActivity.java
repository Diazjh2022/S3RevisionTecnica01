package com.example.s3revisiontecnica01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout myDrawer;
    NavigationView myNav;
    Toolbar myToolbar;

    ActionBarDrawerToggle toggle;

    EditText txtRegistro_de_revision, txtCodigoIngreso, txtFechaHora, txtDocumentacion_Del_Vehiculo, txtPatente;
    EditText txtSistema_De_Direccion, txtFrenos, txtNeumaticos_y_llantas, txtSuspencion, txtAlineacion, txtKit_De_Seguridad;
    EditText txtCinturones_De_Seguridad, txtLuces, txtPuertas, txtVidrios, txtTubo_De_Escape, txtGases, txtObservaciones;
    Button  btnFotografia, btnGuardarFoto, btnVerFoto, btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawerLayout);
        myNav = findViewById(R.id.myNavigationView);
        myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        myNav.setNavigationItemSelectedListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myFrame, new Fragmento1())
                .commit();
        setTitle("Home");
        //toggle=new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open,R.string.drawer_close);
        toggle = setDrawerToggle();




        txtCodigoIngreso = findViewById(R.id.txtCodigoIngreso);
        txtFechaHora = findViewById(R.id.txtFechaHora);
        txtDocumentacion_Del_Vehiculo = findViewById(R.id.txtDocumentacion_Del_Vehiculo);
        txtPatente = findViewById(R.id.txtPatente);
        txtSistema_De_Direccion = findViewById(R.id.txtSistema_De_Direccion);
        txtFrenos = findViewById(R.id.txtFrenos);
        txtNeumaticos_y_llantas = findViewById(R.id.txtNeumaticos_y_llantas);
        txtSuspencion = findViewById(R.id.txtSuspencion);
        txtAlineacion = findViewById(R.id.txtAlineacion);
        txtKit_De_Seguridad = findViewById(R.id.txtKit_De_Seguridad);
        txtCinturones_De_Seguridad = findViewById(R.id.txtCinturones_De_Seguridad);
        txtLuces = findViewById(R.id.txtLuces);
        txtPuertas = findViewById(R.id.txtPuertas);
        txtVidrios = findViewById(R.id.txtVidrios);
        txtTubo_De_Escape = findViewById(R.id.txtTubo_De_Escape);
        txtGases = findViewById(R.id.txtGases);
        txtObservaciones = findViewById(R.id.txtObservaciones);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnFotografia = findViewById(R.id.btnFotografia);
        btnGuardarFoto = findViewById(R.id.btnGuardarFoto);
        btnVerFoto = findViewById(R.id.btnVerFoto);




    }


    public void guardar(View view) {
        ConexionBD conexion = new ConexionBD(this, "administracion", null, 1);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        String CodigoIngreso  = txtCodigoIngreso.getText().toString();
        String FechaHora  = txtFechaHora .getText().toString();
        String Documentacion  = txtDocumentacion_Del_Vehiculo  .getText().toString();
        String Patente  = txtPatente  .getText().toString();
        String Direccion   = txtSistema_De_Direccion   .getText().toString();
        String Frenos  = txtFrenos   .getText().toString();
        String Neumaticos_y_llantas  = txtNeumaticos_y_llantas   .getText().toString();
        String Suspencion  = txtSuspencion    .getText().toString();
        String Alineacion  = txtAlineacion    .getText().toString();
        String Seguridad  = txtKit_De_Seguridad    .getText().toString();
        String Cinturones  = txtCinturones_De_Seguridad    .getText().toString();
        String Luces  = txtLuces     .getText().toString();
        String Puertas  = txtPuertas     .getText().toString();
        String Vidrios  = txtVidrios     .getText().toString();
        String Tubo_De_Escape  = txtTubo_De_Escape     .getText().toString();
        String Gases  = txtGases      .getText().toString();
        String Observaciones = txtObservaciones      .getText().toString();

        ContentValues registro = new ContentValues();
        registro.put ("CodigoIngreso",CodigoIngreso);
        registro.put( "FechaHora ", FechaHora );
        registro.put( "Documentacion  ", Documentacion  );
        registro.put( "Patente    ", Patente    );
        registro.put( "Direccion  ", Direccion  );

        registro.put( "Frenos  ", Frenos  );
        registro.put( "Neumaticos_y_llantas  ", Neumaticos_y_llantas  );
        registro.put( "Suspencion  ", Suspencion  );
        registro.put( "Alineacion  ", Alineacion  );

        registro.put( "Seguridad  ", Seguridad  );
        registro.put( "Cinturones  ", Cinturones  );
        registro.put( "Luces  ", Luces  );
        registro.put( "Puertas  ", Puertas  );
        registro.put( "Vidrios  ", Vidrios  );
        registro.put( "Tubo_De_Escape  ", Tubo_De_Escape  );
        registro.put( "Gases  ", Gases  );
        registro.put( "Observaciones  ", Observaciones  );

        bd.insert( "revisionT", null, registro);
        bd.close();
        txtCodigoIngreso.setText("");
        txtFechaHora.setText("");
        txtDocumentacion_Del_Vehiculo.setText("");
        txtPatente.setText("");
        txtSistema_De_Direccion.setText("");
        txtFrenos.setText("");
        txtNeumaticos_y_llantas.setText("");
        txtSuspencion.setText("");
        txtAlineacion.setText("");
        txtKit_De_Seguridad.setText("");
        txtCinturones_De_Seguridad.setText("");
        txtLuces.setText("");
        txtPuertas.setText("");
        txtVidrios.setText("");
        txtTubo_De_Escape.setText("");
        txtGases.setText("");
        txtObservaciones.setText("");
        Toast.makeText(this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();







    }



    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private ActionBarDrawerToggle setDrawerToggle() {
        return  new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open,R.string.drawer_close);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        switch (item.getItemId()){
            case R.id.registro_de_revision:
                ft.replace(R.id.myFrame, new Fragmento1()).commit();


                return true;

            case R.id.busqueda_de_revision:
                ft.replace(R.id.myFrame, new Fragmento2()).commit();

                return true;

            case R.id.modificacion_de_revision:
                ft.replace(R.id.myFrame, new Fragmento3()).commit();

                return true;

            case R.id.eliminacion_de_revision:
                ft.replace(R.id.myFrame, new Fragmento4()).commit();
                return true;

        }
                setTitle(item.getTitle());

        myDrawer.closeDrawers();

        return false;

    }
}
