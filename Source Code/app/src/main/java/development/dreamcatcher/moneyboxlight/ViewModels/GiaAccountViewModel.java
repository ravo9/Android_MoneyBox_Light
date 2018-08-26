package development.dreamcatcher.moneyboxlight.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import development.dreamcatcher.moneyboxlight.Data.AccountData;
import development.dreamcatcher.moneyboxlight.Data.DataRepository;


public class GiaAccountViewModel extends ViewModel {

    private DataRepository dataRepository;
    private static Context context;

    public LiveData<AccountData> giaAccountData() { return dataRepository.giaAccountData(); }

    public GiaAccountViewModel() {
        DataRepository.initialize(context);
        this.dataRepository = DataRepository.dataRepository;
    }

    public static void setContext(Context c) { context = c; }

    public void add10ToMoneyBox() {

        // API Request
        try { dataRepository.add10ToMoneyBox(2, DataRepository.dataRepository.getGiaInvestorProductId()); }
        catch (Exception ex) {}
    }
}
