package com.yiyitec.tc

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.compose.Markdown

/**
 * create by sfx on 2023/7/21 18:29
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            SampleTheme {
                val markdownContent = """
            # Title 1
        
            To get started with this library, just provide some Markdown.
           
            Usually Markdown will contain different characters *or different styles*, which can **change** just as you ~write~ different text. 
           
            Sometimes it will even contain images within the text
            
            ![Image](https://avatars.githubusercontent.com/u/1476232?v=4)
                
            After installing GPG Suite (or your preferred solution) first create a new key.
            
            Supports reference links:
            [Reference Link Test][1] 
            
            But can also be a auto link: https://mikepenz.dev
            
            Links with links as label are also handled:
            [https://mikepenz.dev](https://mikepenz.dev)
            
            Some `inline` code is also supported!
            
            ## Title 2
            
            ### Title 3
            
            [1]: https://mikepenz.dev/
            
            - [Text] Some text
        """.trimIndent()

                val scrollState = rememberScrollState()
                Markdown(
                    content = markdownContent,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(scrollState)
                        .padding(bottom = 48.dp, top = 56.dp)
                )
            }
        }
    }
}