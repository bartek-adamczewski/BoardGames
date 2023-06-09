package edu.put.inf151764.repo

import edu.put.inf151764.data.api.GamesApi
import edu.put.inf151764.data.db.GamesDao
import edu.put.inf151764.data.db.GamesDatabase
import edu.put.inf151764.data.db.data.ItemsResponseEntity
import edu.put.inf151764.data.db.data.UserEntity
import edu.put.inf151764.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GamesRepo @Inject constructor(
    private val gamesDao: GamesDao,
    private val gamesApi: GamesApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val gamesDb: GamesDatabase
) {

    suspend fun getUser(): Flow<UserEntity?> = withContext(ioDispatcher){
        gamesDao.getUser()
    }

    suspend fun isUserLogged(): Boolean = withContext(ioDispatcher) {
        gamesDao.getUserTableCount() > 0
    }

    suspend fun addUser(name: String) = withContext(ioDispatcher){
        gamesDao.insertUser(user = UserEntity(name))
    }

    suspend fun clearDb() = withContext(ioDispatcher) {
        gamesDb.clearAllTables()
    }

}