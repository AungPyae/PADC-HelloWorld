package xyz.aungpyaephyo.padc_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements ViewFragment.ControllerView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "HomeActivity - onCreate");
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                /*
                Intent intentToLoginSummary = new Intent(HomeActivity.this, LoginSummaryActivity.class);
                startActivity(intentToLoginSummary);
                */
            }
        });

        if(findViewById(R.id.fl_container_2) != null) {
            //LoginFragment fragment = new LoginFragment();
            RegisterFragment fragment = new RegisterFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container_2, fragment)
                    .commit();
        }

        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, loginFragment)
                .commit();

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                LoginFragment fragment = LoginFragment.newInstance("dummy default");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit();
            }
        });

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment fragment = new RegisterFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "HomeActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "HomeActivity - onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mm", "sample_value");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("mm");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showMessage(){

    }

    @Override
    public void onLoginPerform() {
        Toast.makeText(HomeActivity.this, "onLoginPerform", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterPerform() {
        Toast.makeText(HomeActivity.this, "onRegisterPerform", Toast.LENGTH_SHORT).show();
    }
}
