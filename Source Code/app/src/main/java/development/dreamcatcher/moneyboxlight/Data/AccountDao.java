package development.dreamcatcher.moneyboxlight.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface AccountDao {
    @Insert(onConflict = 1)
    void save(AccountData accountData);
    @Query("SELECT * FROM accountData")
    LiveData<AccountData> load();
}