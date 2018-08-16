package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.util.concurrent.TimeUnit;
import development.dreamcatcher.moneyboxlight.Activities.AccountsActivity;
import development.dreamcatcher.moneyboxlight.Data.UserRepository;


public class LoginViewModel extends ViewModel {

    private UserRepository userRepo;
    private Context context;
    private Intent intent;

    public LoginViewModel() {

        UserRepository.initialize();
        userRepo = UserRepository.userRepository;
    }

    public void setContext(Context context) { this.context = context; }

    public void logIn() {

        userRepo.getBearerToken();

        // API Request
        try { userRepo.getBearerToken();}
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

        if (userRepo.isLoggedIn())
            openAccountsActivity();
        else {
            // Try again after 1 second.
            try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) {}
            if (userRepo.isLoggedIn())
                openAccountsActivity();
        }
    }

    public void openAccountsActivity() {

        intent = new Intent(context, AccountsActivity.class);
        context.startActivity(intent);
        //finish();
    }
}
