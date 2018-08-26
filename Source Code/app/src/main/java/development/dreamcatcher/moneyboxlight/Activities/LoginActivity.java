package development.dreamcatcher.moneyboxlight.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import development.dreamcatcher.moneyboxlight.R;
import development.dreamcatcher.moneyboxlight.ViewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel viewModel;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginViewModel.context = this;
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        viewModel.setContext(this);

        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { viewModel.logIn(); }
        });
    }
}
