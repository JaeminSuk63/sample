package com.hyundai.sample.launch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TabItem(icon: Int, label: String, selected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier
                .height(60.dp)
                .width(90.dp),
            painter = painterResource(icon),
            tint = if (selected) Color.White else Color.Black,
            contentDescription = label,
        )
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = if (selected) Color.White else Color.Black,
        )
        Spacer(modifier = Modifier.height(5.dp))
    }
}