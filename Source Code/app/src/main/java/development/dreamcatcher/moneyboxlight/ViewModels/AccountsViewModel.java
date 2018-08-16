package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.ViewModel;
import development.dreamcatcher.moneyboxlight.Data.UserRepository;


public class AccountsViewModel extends ViewModel {

    private UserRepository userRepo;

    public AccountsViewModel() {

        UserRepository.initialize();
        userRepo = UserRepository.userRepository;
    }
}
