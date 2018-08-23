package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import development.dreamcatcher.moneyboxlight.Activities.AccountsActivity;
import development.dreamcatcher.moneyboxlight.Data.DataRepository;


public class LoginViewModel extends ViewModel {

    private DataRepository dataRepository;
    private Context context;
    private Intent intent;

    @Inject
    public LoginViewModel(DataRepository dataRepository) {

        this.dataRepository = dataRepository;
        Log.d("Flag1", "A");
    }

    /*public LoginViewModel() {
        Log.d("Flag1", "B");
    }*/

    public LoginViewModel() {

        DataRepository.initialize();
        dataRepository = DataRepository.dataRepository;
    }

    public void setContext(Context context) { this.context = context; }

    public void logIn() {

        // API Request
        try { dataRepository.fetchBearerToken();}
        catch (Exception ex) {}

        // Answer Handling (Entrance Request)
        try {
            AsyncTask<Void, Void, String> execute = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {
                    requestEntrance();
                    return null;
                }
            };
            execute.execute();
        } catch (Exception ex) {}
    }

    public void requestEntrance() {

        if (dataRepository.isLoggedIn())
            openAccountsActivity();
        else {
            // Try again after 1 second.
            try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) {}
            if (dataRepository.isLoggedIn())
                openAccountsActivity();
        }
    }

    public void openAccountsActivity() {

        intent = new Intent(context, AccountsActivity.class);
        context.startActivity(intent);
        //finish();
    }
}
