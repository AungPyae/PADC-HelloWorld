package xyz.aungpyaephyo.padc_helloworld;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    public static final String BARG_DUMMY_USERNAME = "dummy_username";

    private String defaultUsername;

    public LoginFragment() {

    }

    public static LoginFragment newInstance(String defaultUsername) {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LoginFragment.BARG_DUMMY_USERNAME, defaultUsername);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null) {
            defaultUsername = bundle.getString(LoginFragment.BARG_DUMMY_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final EditText etUsername = (EditText) view.findViewById(R.id.et_username);
        etUsername.setText(defaultUsername);

        final EditText etPassword = (EditText) view.findViewById(R.id.et_password);

        Button btnLogin = (Button) view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                //Toast.makeText(getContext(), "Hello Login Form : "+username+" - "+password, Toast.LENGTH_SHORT).show();

                Intent intentToLoginSummary = LoginSummaryActivity.newIntent(username);
                startActivity(intentToLoginSummary);
            }
        });

        return view;
    }
}
