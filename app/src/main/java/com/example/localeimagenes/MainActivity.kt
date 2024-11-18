package com.example.localeimagenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.localeimagenes.ui.theme.LocaleImagenesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocaleImagenesTheme {
                Scaffold(
                    topBar = { TopAppComponent() },
                    bottomBar = { BottomBarComponent() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPaddingValues ->
                    Box(modifier = Modifier.padding(innerPaddingValues)) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            val imageIds = listOf(
                                R.drawable.erik_mclean_8sejumfahu0_unsplash,
                                R.drawable.jason_leung_t844cluxqve_unsplash ,
                                R.drawable.mateusz_waclawek_t2b2svmf8ek_unsplash        ,
                                R.drawable.rachit_khurana_v3gbv_keh10_unsplash
                            )
                            imageIds.forEach { imageId ->
                                ImageCard(imageId)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ImageCard(imageId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppComponent() {
    TopAppBar({ Text(stringResource(R.string.app_name)) })
}

@Composable
fun BottomBarComponent() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Home, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Search, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.AddCircle, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.PlayArrow, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.AccountCircle, contentDescription = null)
            }
        }
    }
}

