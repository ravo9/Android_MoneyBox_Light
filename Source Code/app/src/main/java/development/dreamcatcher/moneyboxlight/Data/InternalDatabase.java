package development.dreamcatcher.moneyboxlight.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {AccountData.class}, version = 1)
public abstract class InternalDatabase extends RoomDatabase {
    public abstract AccountDao accountDao();
}