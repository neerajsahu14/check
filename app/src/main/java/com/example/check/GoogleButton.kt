import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.check.R

@Composable
fun GoogleButton(
    text : String = "Sign in with Google",
    loadingText : String = "Loading ..."

) {
    var clicked by remember{
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.clickable { clicked = !clicked },
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.surface
    ){
        Row(
            modifier= Modifier.absolutePadding(
                left=16.dp,
                top=12.dp,
                right=24.dp,
                bottom=12.dp
            ).animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ){
           Icon(
                  painter = painterResource(id = R.drawable.ic_google_logo),
                  contentDescription = "Google Button",
                  tint = Color.Unspecified
             )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                  text= (if(!clicked) text else loadingText),
                  style = MaterialTheme.typography.bodyLarge
              )
               Spacer(modifier = Modifier.width(8.dp))
            if(clicked){
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
@Preview
fun GoogleButtonPreview() {
    GoogleButton()
}
