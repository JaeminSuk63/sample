package com.hyundai.sample.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyundai.sample.entity.SearchHistoryItem
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun SearchHistoryList(
    items: List<SearchHistoryItem>,
    onDeleteItem: (SearchHistoryItem) -> Unit
) {
    val pattern = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items) { _, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onDeleteItem(item) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.keyword,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 40.sp
                )
                Text(
                    text = pattern.format(Date(item.createdDateTime)),
                    modifier = Modifier.padding(10.dp),
                    fontSize = 35.sp
                )
            }
        }
    }
}