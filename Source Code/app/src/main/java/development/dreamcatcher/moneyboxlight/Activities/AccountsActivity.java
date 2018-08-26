package development.dreamcatcher.moneyboxlight.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import development.dreamcatcher.moneyboxlight.R;
import development.dreamcatcher.moneyboxlight.ViewModels.AccountsViewModel;


public class AccountsActivity extends AppCompatActivity {

    private AccountsViewModel viewModel;
    private Button btnIsa, btnGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        viewModel.setContext(this);
        viewModel = ViewModelProviders.of(this).get(AccountsViewModel.class);

        btnIsa = findViewById(R.id.btn_ISA);
        btnGia = findViewById(R.id.btn_GIA);

        btnIsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { viewModel.openIsaAccountActivity(); }
        });

        btnGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { viewModel.openGiaAccountActivity(); }
        });
    }
}
