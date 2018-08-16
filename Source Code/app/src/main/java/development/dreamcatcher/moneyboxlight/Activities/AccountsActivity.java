package development.dreamcatcher.moneyboxlight.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import development.dreamcatcher.moneyboxlight.R;
import development.dreamcatcher.moneyboxlight.ViewModels.AccountsViewModel;

public class AccountsActivity extends AppCompatActivity {

    private AccountsViewModel viewModel;
    private Button btnSsisa, btnGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        viewModel = ViewModelProviders.of(this).get(AccountsViewModel.class);
        btnSsisa = findViewById(R.id.btn_SSISA);
        btnGia = findViewById(R.id.btn_GIA);
    }
}
