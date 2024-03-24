package com.study.notesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.notesapp.database.room.AppRoomDataBase
import com.study.notesapp.database.room.repository.RoomRepository
import com.study.notesapp.model.Note
import com.study.notesapp.utils.REPOSITORY
import com.study.notesapp.utils.TYPE_FIREBASE
import com.study.notesapp.utils.TYPE_ROOM
import java.lang.IllegalArgumentException

class MainViewModel (application: Application):AndroidViewModel(application){

    val context = application

    // создадим функцию инициализации базы данных
    fun initDatabase(type: String, onSuccess: () -> Unit){
        Log.d("checkData", "MainViewModel init Database with type: $type")
        when(type){
            TYPE_ROOM ->{
                val dao = AppRoomDataBase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}

class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}