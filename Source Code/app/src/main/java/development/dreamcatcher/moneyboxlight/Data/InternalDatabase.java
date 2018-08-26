package development.dreamcatcher.moneyboxlight.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {AccountData.class}, version = 1)
public abstract class InternalDatabase extends RoomDatabase {

    private static InternalDatabase internalDatabase;

    public abstract AccountDao accountDao();

    public static InternalDatabase getInternalDatabase(Context context) {
        if (internalDatabase == null) {
            internalDatabase =
                    Room.databaseBuilder(context.getApplicationContext(), InternalDatabase.class, "accounts")
                            .allowMainThreadQueries()
                            .build();
        }
        return internalDatabase;
    }

    public static void destroyInternalDatabase() {
        internalDatabase = null;
    }
}