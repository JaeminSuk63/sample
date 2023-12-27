package com.hyundai.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hyundai.sample.launch.LaunchScreen
import com.hyundai.sample.launch.LaunchViewModel
import com.hyundai.sample.launch.Navigation
import com.hyundai.sample.ui.theme.SampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }

        setContent {
            SampleTheme {
                if (viewModel.isStartCondition) Navigation() else LaunchScreen()
            }
        }
    }
}
