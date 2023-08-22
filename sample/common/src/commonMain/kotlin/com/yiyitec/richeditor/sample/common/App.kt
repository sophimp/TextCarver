package com.yiyitec.richeditor.sample.common

import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import com.yiyitec.richeditor.sample.common.home.HomeScreen
import com.yiyitec.richeditor.sample.common.ui.theme.ComposeRichEditorTheme

@Composable
fun App() {
    ComposeRichEditorTheme {
        Navigator(HomeScreen)
    }
}