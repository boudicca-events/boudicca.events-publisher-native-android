package com.example.bouddicaclient.ui.screens.mainscreen

import android.content.ContentValues.TAG
import android.util.Log;

import android.media.metrics.Event
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bouddicaclient.data.model.EventItem
import com.example.bouddicaclient.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: EventRepository) : ViewModel() {
  private val _events = MutableLiveData<List<EventItem>>()
  val events: LiveData<List<EventItem>> get() = _events

  private val TAG = "YourViewModelTag"

  fun loadEvents() {
    viewModelScope.launch {
      try {
        val result = repository.searchEvents("name contains a", 0, 10)

        Timber.tag(TAG).d("This is a debug message")
        Timber.tag(TAG).d(result.result.toString())

        _events.value = result.result
      } catch (e: Exception) {
        // Handle error
        e.printStackTrace()
      }
    }
  }
}