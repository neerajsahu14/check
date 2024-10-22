package com.example.check

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Magenta

@Composable
fun CoilImage(){
    Box(modifier= Modifier
        .height(150.dp)
        .width(150.dp)
    ,contentAlignment = Alignment.Center){
    val painter= rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = "https://images.unsplash.com/photo-1620288627223-53302f4e8c74?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8bG9nbyUyMHBuZ3xlbnwwfDF8MHx8fDA%3D")
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(1000)
                transformations(  RoundedCornersTransformation(50f))
                error(R.drawable.error)
                placeholder(R.drawable.ic_launcher_background)
            }).build()
    )
       val painterState= painter.state
    Image(painter = painter,contentDescription = "Image")
//        if(painterState is AsyncImagePainter.State.Loading){
//            CircularProgressIndicator()
//        }
    }
}

@Composable
fun PasswordField() {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by remember{
        mutableStateOf(false)
    }
    var icon = if(passwordVisibility){
        painterResource(id = android.R.drawable.ic_menu_view)
    }else{
        painterResource(id = android.R.drawable.ic_menu_edit)
    }

    OutlinedTextField(
        value = password,
        placeholder = { Text("Enter password") },
        onValueChange = { password = it },
        label = { Text("Password") },
        trailingIcon = {
            IconButton( onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Password"
                )
            }
        },
        keyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        }
        else{
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun GradientButton(
//    text: String,
//    textColor: android.graphics.Color,
//    gradient: Brush,
//    onClick: () -> Unit
) {
   Button(
       contentPadding = PaddingValues(),
       onClick ={} ){
       Box(modifier = Modifier.background(
           brush = Brush.horizontalGradient(
               colors = listOf(
                   Magenta,
                   Cyan
               )
           )
       )){
        Text(
            modifier= Modifier.padding( horizontal=16.dp, vertical=12.dp),
            text="Gradient Button",
            color= Color.White
        )
       }
   }
}

@Composable
@Preview
fun CoilImagePreview(){
    GradientButton()
}