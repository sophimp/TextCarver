package com.yiyitec.richeditor.parser

import com.yiyitec.richeditor.ui.RichTextState

internal interface RichTextStateParser<T> {

    fun encode(input: T): RichTextState

    fun decode(richTextState: RichTextState): T

}