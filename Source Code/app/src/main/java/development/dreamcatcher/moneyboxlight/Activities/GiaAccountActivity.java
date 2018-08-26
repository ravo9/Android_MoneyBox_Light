package development.dreamcatcher.moneyboxlight.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import development.dreamcatcher.moneyboxlight.R;
import development.dreamcatcher.moneyboxlight.ViewModels.GiaAccountViewModel;
import development.dreamcatcher.moneyboxlight.ViewModels.IsaAccountViewModel;

public class GiaAccountActivity extends AppCompatActivity {

    private GiaAccountViewModel viewModel;
    private TextView textViewGiaAccountState, textViewMoneyBoxState;
    private Button buttonAdd10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gia_account);

        viewModel.setContext(this);
        viewModel = ViewModelProviders.of(this).get(GiaAccountViewModel.class);

        textViewGiaAccountState = findViewById(R.id.textView_gia_account_state);
        textViewMoneyBoxState = findViewById(R.id.textView_moneybox_state);
        buttonAdd10 = findViewById(R.id.button_add_10);

        viewModel.giaAccountData().observe(this, giaAccountData -> {
            textViewGiaAccountState.setText("GIA Account State: " + String.valueOf(giaAccountData.getAccountState()));
            textViewMoneyBoxState.setText("MoneyBox State: " + String.valueOf(giaAccountData.getMoneyBoxState()));
        });

        buttonAdd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { viewModel.add10ToMoneyBox(); }
        });
    }
}
