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

import timber.log.Timber

data class SearchDTO(
  val name: String? = null,
  val category: String? = null,
  val locationCity: String? = null,
  val locationName: String? = null,
  val fromDate: String? = null,
  val toDate: String? = null,
  val durationShorter: Int? = null,
  val durationLonger: Int? = null,
  val flags: List<String>? = null,
  val bandName: String? = null
)

object BoudiccaQueryBuilder {
  fun buildQuery(searchDTO: SearchDTO): String {
    val queryParts = mutableListOf<String>()

    if (!searchDTO.name.isNullOrBlank()) {
      queryParts.add("name contains \"${searchDTO.name}\"")
    }

    return queryParts.joinToString(" and ")
  }
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: EventRepository) : ViewModel() {
  private val _events = MutableLiveData<List<EventItem>>()
  val events: LiveData<List<EventItem>> get() = _events

  private var isLoading = false
  private var currentPage = 1 // Initial page

  private var PAGE_SIZE = 10

  val TAG = "home screen"

  init {
    loadEvents()
    Timber.tag(TAG).d("This is a debug message in init - HomeViewModel")
  }

  fun loadEvents() {
    if (isLoading) return

    viewModelScope.launch {
      try {
        isLoading = true
        val searchDTO = SearchDTO("")
        val query = BoudiccaQueryBuilder.buildQuery(searchDTO)
        val newEvents = repository.queryEntries(query, currentPage * PAGE_SIZE, PAGE_SIZE)
          .result // Assuming the result field in Response contains the list of events
        Timber.tag(TAG).d("This is a debug message in init - load events")
        _events.value = (_events.value ?: emptyList()) + newEvents
        currentPage++
      } catch (e: Exception) {
        // Handle error
      } finally {
        isLoading = false
      }
    }
  }

  fun canLoadMore(): Boolean {
    // Customize this condition based on your requirements
    return currentPage <= MAX_PAGES
  }

  companion object {
    private const val MAX_PAGES = 500
  }
}