package edu.put.inf151764.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.put.inf151764.data.db.data.ItemEntity
import edu.put.inf151764.data.db.data.ItemsResponseEntity
import edu.put.inf151764.data.db.data.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items:List<ItemEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResponse(response:ItemsResponseEntity)

    //Czymy to musimy dzielić
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:UserEntity)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertDetails(detailsResponse: DetailsResponse)

    @Query("Select * from ItemsResponseEntity")
    suspend fun getResponse() : ItemsResponseEntity?

    @Query("Select * from ItemEntity")
    suspend fun getItem() : List<ItemEntity>

    @Query("Select * from UserEntity")
    fun getUser() : Flow<UserEntity?>

    @Query("Select count(*) from UserEntity")
    suspend fun getUserTableCount(): Int




}