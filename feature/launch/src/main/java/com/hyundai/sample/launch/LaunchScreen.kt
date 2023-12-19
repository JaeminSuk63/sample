package com.hyundai.sample.launch

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LaunchScreen(viewModel: LaunchViewModel = hiltViewModel()) {
    val context = LocalContext.current as? ComponentActivity
    val message by viewModel.errorMessage.collectAsState()

    AlertDialog(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp),
        onDismissRequest = {

        },
        title = {
            Text(text = "Alert", fontSize = 50.sp)
        },
        text = {
            Text(text = message, fontSize = 40.sp)
        },
        confirmButton = {
            Button(
                onClick = {
                    context?.finish()
                }
            ) {
                Text("OK", fontSize = 40.sp)
            }
        }
    )

}