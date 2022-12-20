package com.hessah.cardprofileusuingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hessah.cardprofileusuingcompose.ui.theme.CardProfileUsuingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardProfileUsuingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    CreatBizCardFunction()
                }
            }
        }
    }
}

@Composable
fun CreatBizCardFunction(){


        Surface (modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

            Card(

                modifier = Modifier.width(200.dp).height(390.dp).padding(12.dp),

                shape = RoundedCornerShape(corner = CornerSize(15.dp)),

                backgroundColor = Color.White,
                elevation = 4.dp

            ) {

                Column(modifier = Modifier.height(300.dp),

                verticalArrangement = Arrangement.Top,

                    // center men in place for this photo in the page
                horizontalAlignment = Alignment.CenterHorizontally
                ){


                    Surface ( modifier = Modifier
                        .size(150.dp,)
                        .padding(5.dp)
                        , shape = CircleShape ,
                        border = BorderStroke(0.5.dp, Color.LightGray),
                        elevation = 4.dp ,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                    ){

                        //what image you want see (id & Description )for photo
                        Image(painter = painterResource(R.drawable.horsesphoto),
                            contentDescription = "profile photo",
                            modifier = Modifier.size(130.dp),

                            //make photo fill max padding
                            contentScale = ContentScale.Crop
                        )
                    }//end surface Block for photo .
                }


            } //end card Block .

        }// end surface card Block .

} // end function compose Block .





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardProfileUsuingComposeTheme {

    CreatBizCardFunction()

    }
}