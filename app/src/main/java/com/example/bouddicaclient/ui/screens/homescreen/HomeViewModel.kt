package com.example.bouddicaclient.ui.screens.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bouddicaclient.data.model.EventItem
import com.example.bouddicaclient.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: EventRepository) : ViewModel() {
  private val _events = MutableLiveData<List<EventItem>>()
  val events: LiveData<List<EventItem>> get() = _events
  fun loadEvents() {
    viewModelScope.launch {
      try {
        val result = repository.queryEnteries("name contains a", 0, 10)
        _events.value = result.result
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }
}