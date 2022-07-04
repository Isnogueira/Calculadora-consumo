package com.infnet.at_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*


class DataViewModel: ViewModel() {

   private var dataValue: String = ""

    // Setar Data e hora
  private val date = Calendar.getInstance().time
    private val dateTimeFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())

    private val _data = MutableLiveData<String>().apply {
        dataValue = dateTimeFormat.format(date)
        value = dataValue
    }
     var data: LiveData<String> = _data




}