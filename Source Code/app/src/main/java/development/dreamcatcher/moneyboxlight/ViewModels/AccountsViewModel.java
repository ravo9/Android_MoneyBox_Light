package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import development.dreamcatcher.moneyboxlight.Activities.IsaAccountActivity;
import development.dreamcatcher.moneyboxlight.Data.DataRepository;


public class AccountsViewModel extends ViewModel {

    private DataRepository dataRepository;
    private Context context;
    private Intent intent;

    public AccountsViewModel() {

        DataRepository.initialize();
        dataRepository = DataRepository.dataRepository;
    }

    public void setContext(Context context) { this.context = context; }

    public void openIsaAccountActivity() {

        intent = new Intent(context, IsaAccountActivity.class);
        context.startActivity(intent);
        //finish();
    }
}
