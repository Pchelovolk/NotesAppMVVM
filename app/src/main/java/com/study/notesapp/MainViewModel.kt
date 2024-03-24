package com.study.notesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.notesapp.model.Note
import com.study.notesapp.utils.TYPE_FIREBASE
import com.study.notesapp.utils.TYPE_ROOM
import java.lang.IllegalArgumentException

class MainViewModel (application: Application):AndroidViewModel(application){

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy{
        MutableLiveData<String>(TYPE_ROOM)
    }

    init{
        readTest.value =
            when(dbType.value){
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "NOTE 1", subtitle = "SubTitle for NOTE 1"),
                        Note(title = "NOTE 2", subtitle = "SubTitle for NOTE 2"),
                        Note(title = "NOTE 3", subtitle = "SubTitle for NOTE 3"),
                        Note(title = "NOTE 4", subtitle = "SubTitle for NOTE 4"),
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }

    // создадим функцию инициализации базы данных
    fun initDatabase(type: String){

        dbType.value = type
        Log.d("checkData", "MainViewModel init Database with type: $type")
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