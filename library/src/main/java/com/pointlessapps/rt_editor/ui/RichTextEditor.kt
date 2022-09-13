package com.pointlessapps.rt_editor.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.input.VisualTransformation
import com.pointlessapps.rt_editor.model.RichTextValue

@Composable
fun RichTextEditor(
    value: RichTextValue,
    onValueChange: (RichTextValue) -> Unit,
    modifier: Modifier = Modifier,
    textFieldStyle: RichTextFieldStyle = defaultRichTextFieldStyle(),
    vararg visualTransformations: VisualTransformation,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    RichTextField(
        modifier = modifier,
        value = value.value,
        styledValue = value.styledValue,
        styleMapper = value.styleMapper,
        onValueChange = {
            val newValue = value.copy()
            if (newValue.updatedValueAndStyles(it)) {
                onValueChange(newValue)
            }
        },
        textFieldStyle = textFieldStyle,
        visualTransformations = visualTransformations,
        onTextLayout = onTextLayout,
    )
}
