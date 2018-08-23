package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import development.dreamcatcher.moneyboxlight.Activities.AccountsActivity;
import development.dreamcatcher.moneyboxlight.Activities.IsaAccountActivity;
import development.dreamcatcher.moneyboxlight.Data.AccountData;
import development.dreamcatcher.moneyboxlight.Data.DataRepository;


public class IsaAccountViewModel extends ViewModel {

    private DataRepository dataRepository;

    public LiveData<AccountData> isaAccountData() { return dataRepository.isaAccountData(); }

    public IsaAccountViewModel() {

        DataRepository.initialize();
        dataRepository = DataRepository.dataRepository;
    }

    public void add10ToMoneyBox() {

        // API Request
        try { dataRepository.add10ToMoneyBox(DataRepository.dataRepository.getIsaInvestorProductId()); }
        catch (Exception ex) {}
    }
}
