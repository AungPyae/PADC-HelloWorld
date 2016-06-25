package xyz.aungpyaephyo.padc_helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoginSummaryActivity extends AppCompatActivity {

    private static final String IE_USERNAME = "username_key";

    public static Intent newIntent(String username){
        Context context = HelloWorldApp.getContext();
        Intent intentToLoginSummary = new Intent(context, LoginSummaryActivity.class);
        intentToLoginSummary.putExtra(IE_USERNAME, username);
        return intentToLoginSummary;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_summary);

        Intent intentFromHomeActivity = getIntent();
        String username = intentFromHomeActivity.getStringExtra(IE_USERNAME);

        TextView tvLoginSummary = (TextView) findViewById(R.id.tv_login_summary);
        tvLoginSummary.setText("Welcome : " + username);

        //Toast.makeText(getApplicationContext(), "Username - " + username, Toast.LENGTH_SHORT).show();
    }
}
