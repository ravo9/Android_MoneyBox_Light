package development.dreamcatcher.moneyboxlight.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import development.dreamcatcher.moneyboxlight.R;
import development.dreamcatcher.moneyboxlight.ViewModels.IsaAccountViewModel;

public class IsaAccountActivity extends AppCompatActivity {

    private IsaAccountViewModel viewModel;
    private TextView textViewIsaAccountState, textViewMoneyBoxState;
    private Button buttonAdd10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isa_account);

        viewModel = ViewModelProviders.of(this).get(IsaAccountViewModel.class);

        textViewIsaAccountState = findViewById(R.id.textView_isa_account_state);
        textViewMoneyBoxState = findViewById(R.id.textView_moneybox_state);
        viewModel.isaAccountData().observe(this, isaAccountData -> {
            textViewIsaAccountState.setText("ISA Account State: " + String.valueOf(isaAccountData.getAccountState()));
            textViewMoneyBoxState.setText("MoneyBox State: " + String.valueOf(isaAccountData.getMoneyBoxState()));
        });

        buttonAdd10 = findViewById(R.id.button_add_10);
        buttonAdd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { viewModel.add10ToMoneyBox(); }
        });
    }
}
