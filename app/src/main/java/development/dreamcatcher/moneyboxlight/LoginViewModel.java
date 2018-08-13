package development.dreamcatcher.moneyboxlight;


import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {

    private String userId;
    private User user;

    private UserRepository userRepo;

    @Inject
    public LoginViewModel() {}

    //@Inject
    //public LoginViewModel(UserRepository userRepo) { this.userRepo = userRepo; }

    public void init(String userId) {
        if (this.user != null)
            return;

        //user = userRepo.getUser(userId);
    }

    public User getUser() {
        return this.user;
    }
}
