package com.hyundai.sample.base.main

import HSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hyundai.sample.entity.SearchHistoryItem
import com.hyundai.sample.base.DefaultTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val searchHistoryList by viewModel.searchHistoryList.collectAsState()

    val onDeleteItem: (SearchHistoryItem) -> Unit = { item ->
        viewModel.deleteSearchHistory(item)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = HSize.ScreenStartPadding),
        topBar = { DefaultTopBar("Sample") }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = HSize.D40)
        ) {

            TextButton(onClick = {
                viewModel.addSearchHistory(SearchHistoryItem(keyword = "Test"))
            }) {
                Text(
                    text = "Add",
                    fontSize = 40.sp,
                )
            }

            SearchHistoryList(items = searchHistoryList, onDeleteItem = onDeleteItem)
        }
    }
}
