package com.yiyitec.richeditor.sample.common.richeditor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.ExperimentalSoftwareKeyboardApi
import com.moriatsushi.insetsx.safeDrawingPadding
import com.yiyitec.richeditor.sample.common.components.RichTextStyleRow
import com.yiyitec.richeditor.sample.common.ui.theme.ComposeRichEditorTheme
import com.yiyitec.richeditor.ui.BasicRichTextEditor
import com.yiyitec.richeditor.ui.material3.OutlinedRichTextEditor
import com.yiyitec.richeditor.ui.material3.RichText
import com.yiyitec.richeditor.ui.material3.RichTextEditor
import com.yiyitec.richeditor.ui.rememberRichTextState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSoftwareKeyboardApi::class)
@Composable
fun RichEditorContent() {
    val navigator = LocalNavigator.currentOrThrow

    val basicRichTextState = rememberRichTextState()
    val richTextState = rememberRichTextState()
    val outlinedRichTextState = rememberRichTextState()

    LaunchedEffect(Unit) {
        richTextState.setHtml(
            """
            <p><b>RichTextEditor</b> is a <i>composable</i> that allows you to edit <u>rich text</u> content.</p>
            """.trimIndent()
        )
    }

    ComposeRichEditorTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Compose Rich Editor") },
                    navigationIcon = {
                        IconButton(
                            onClick = { navigator.pop() }
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
        ) { paddingValue ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue)
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // BasicRichTextEditor
                Text(
                    text = "BasicRichTextEditor:",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                RichTextStyleRow(
                    modifier = Modifier.fillMaxWidth(),
                    state = basicRichTextState,
                )

                BasicRichTextEditor(
                    modifier = Modifier.fillMaxWidth(),
                    state = basicRichTextState,
                )

                Divider(modifier = Modifier.padding(vertical = 20.dp))

                // RichTextEditor
                Text(
                    text = "RichTextEditor:",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                RichTextStyleRow(
                    modifier = Modifier.fillMaxWidth(),
                    state = richTextState,
                )

                RichTextEditor(
                    modifier = Modifier.fillMaxWidth(),
                    state = richTextState,
                )

                Divider(modifier = Modifier.padding(vertical = 20.dp))

                // OutlinedRichTextEditor
                Text(
                    text = "OutlinedRichTextEditor:",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                RichTextStyleRow(
                    modifier = Modifier.fillMaxWidth(),
                    state = outlinedRichTextState,
                )

                OutlinedRichTextEditor(
                    modifier = Modifier.fillMaxWidth(),
                    state = outlinedRichTextState,
                )

                Divider(modifier = Modifier.padding(vertical = 20.dp))

                // RichText
                Text(
                    text = "RichText:",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                RichText(
                    modifier = Modifier.fillMaxWidth(),
                    state = richTextState,
                )
            }
        }
    }
}