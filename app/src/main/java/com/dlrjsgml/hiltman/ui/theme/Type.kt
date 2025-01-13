package com.dlrjsgml.hiltman.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.dlrjsgml.hiltman.R

val PretendardFontFamily = FontFamily(
    Font(R.font.pretendard_black, FontWeight.Black),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extrabold, FontWeight.ExtraBold),
    Font(R.font.pretendard_extralight, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_thin, FontWeight.Thin),
)
val hero = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Light,
    fontSize = 36.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val heading1 = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Light,
    fontSize = 32.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val heading1_medium = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 32.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val heading2_bold = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val heading2_medium = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val heading3_bold = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 21.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val heading3_medium = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 21.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val subHeading_bold = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 21.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val body1_bold = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val body1_medium = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val body2_bold = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)
val body2_medium = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)

val caption_bold = TextStyle(
    fontFamily = PretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 1.3.em,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)