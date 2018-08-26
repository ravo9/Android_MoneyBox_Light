package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import development.dreamcatcher.moneyboxlight.Activities.GiaAccountActivity;
import development.dreamcatcher.moneyboxlight.Activities.IsaAccountActivity;


public class AccountsViewModel extends ViewModel {

    private static Context context;
    private Intent intent;

    public AccountsViewModel() {}

    public static void setContext(Context c) { context = c; }

    public void openIsaAccountActivity() {
        intent = new Intent(context, IsaAccountActivity.class);
        context.startActivity(intent);
    }

    public void openGiaAccountActivity() {
        intent = new Intent(context, GiaAccountActivity.class);
        context.startActivity(intent);
    }
}
