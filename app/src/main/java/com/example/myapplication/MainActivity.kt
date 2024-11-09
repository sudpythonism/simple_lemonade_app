package com.example.myapplication

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonApp(
                        Modifier.padding(innerPadding)
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.tertiaryContainer)
                    )
                }
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier) {

    var currentStep by remember { mutableIntStateOf(1) }

    val img1 = R.drawable.lemon_tree
    val img2 = R.drawable.lemon_squeeze
    val img3 = R.drawable.lemon_drink
    val img4 = R.drawable.lemon_restart

    val t1 = stringResource(R.string.s1)
    val t2 = stringResource(R.string.s2)
    val t3 = stringResource(R.string.s3)
    val t4 = stringResource(R.string.s4)

    Surface (modifier = modifier) {

        when(currentStep){
            1 -> {
                LemonScreen(
                    drawableResId = img1,
                    textLabel = t1,
                    contentDescription = null,
                    onImgClick = {
                        currentStep = 2
                    },
                    modifier = Modifier
                )
            }
            2 -> {
                LemonScreen(
                    drawableResId = img2,
                    textLabel = t2,
                    contentDescription = null,
                    onImgClick = {
                        currentStep = (2..4).random()
                    },
                    modifier = Modifier
                )
            }
            3 -> {
                LemonScreen(
                    drawableResId = img3,
                    textLabel = t3,
                    contentDescription = null,
                    onImgClick = {
                        currentStep = 4
                    },
                    modifier = Modifier
                )
            }
            4 -> {
                LemonScreen(
                    drawableResId = img4,
                    textLabel = t4,
                    contentDescription = null,
                    onImgClick = {
                        currentStep = 1
                    },
                    modifier = Modifier
                )
            }

        }

    }

}

@Composable
fun LemonScreen(
    drawableResId:Int,
    textLabel:String,
    contentDescription:String?,
    onImgClick : () -> Unit,
    modifier: Modifier){

    Box(modifier = modifier){

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Button(
                onClick = onImgClick,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)

            ){

                Image(painter = painterResource(drawableResId),
                    contentDescription = contentDescription,)
            }
            Spacer(modifier.height(10.dp))
            Text(text = textLabel,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif,
                ))

        }

    }


}

@Preview(showBackground = true)
@Composable
fun LemonPreview() {
    MyApplicationTheme {

        LemonApp(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiaryContainer)
        )
    }
}