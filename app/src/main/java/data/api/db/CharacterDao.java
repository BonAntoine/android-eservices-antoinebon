package data.api.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CharacterDao {

    @Query("SELECT * from characterentity WHERE id = :id")
    CharacterEntity getCharacterById(String id);

    @Query("SELECT * from characterentity")
    List<CharacterEntity> loadCharacters();

    @Insert
    public Completable addCharacter(CharacterEntity characterEntity);

    @Query("DELETE FROM characterentity WHERE id = :id")
    public Completable deleteCharacter(String id);

}
