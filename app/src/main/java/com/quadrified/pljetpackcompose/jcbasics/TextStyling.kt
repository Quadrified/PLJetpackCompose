package com.quadrified.pljetpackcompose.jcbasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.quadrified.pljetpackcompose.R

@Composable
fun TextStyling(modifier: Modifier = Modifier) {

    // Custom Font Family
    val fontFamily = FontFamily(
        Font(R.font.lexend_regular, FontWeight.Normal),
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_semibold, FontWeight.SemiBold),
        Font(R.font.lexend_bold, FontWeight.Bold)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF101010)),
    ) {
        Text(
            text = "Omer Quadri is a developer",
//            text = buildAnnotatedString {
//
//            },
            color = Color.White,
            fontSize = 34.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.LineThrough,

            )
    }

}

@Preview(showSystemUi = true)
@Composable
fun TextStylingPreview() {
    TextStyling()
}
