package development.dreamcatcher.moneyboxlight.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


@Dao
public interface AccountDao {

    @Insert
    void save(AccountData accountData);

    @Update
    void update(AccountData accountData);

    @Query("SELECT * FROM accounts WHERE product_id = 1 LIMIT 1")
    LiveData<AccountData> loadIsaAccount();

    @Query("SELECT * FROM accounts WHERE product_id = 2 LIMIT 1")
    LiveData<AccountData> loadGiaAccount();

    @Query("SELECT COUNT(*) FROM accounts WHERE product_id = 1")
    int getIsaAccountsAmount();

    @Query("SELECT COUNT(*) FROM accounts WHERE product_id = 2")
    int getGiaAccountsAmount();
}