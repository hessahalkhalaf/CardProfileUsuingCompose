package com.hessah.cardprofileusuingcompose

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection.Companion.Content
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

    val VV_ClickButtonState = remember {
        mutableStateOf(true)
    }

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


                    CreateImegeProfile()//end surfac4e Block for photo .

                    //for boot the line
                    Divider()
                    Createinfo() //end column
                    Button(
                        onClick = {

                            // for make the list visible and invisible
                            // wine the user click on the Button  **
                            VV_ClickButtonState.value= !VV_ClickButtonState.value

                            Log.d("Clicked","Clicked")
                        }
                    ){
                      Text(text = "Portfolio",
                      style = MaterialTheme.typography.button)
                    }
                    if (VV_ClickButtonState.value) {
                        FFContent()

                    }else {
                        // mean make the box empty (no showing eni thing
                        Box {  }
                }
            } //end card Block .
        }// end surface card Block .
} // end function compose Block



    }

    @Composable
fun FFContent(){

    Box (modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(5.dp)){
        Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()
            , shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(width = 2.dp,color= Color.LightGray)) {

            FFPorfolio_list (variable_data = listOf("Project 1 ", "Project 2 "
                ,"Project 3 ","Project 3 ","Project 3 ","Project 3 ","Project 3 "))
        }
    }
}
@Composable
fun FFPorfolio_list(variable_data: List<String>) {

    //lazycolmun for make the list as scroll list
    //like Recyclerview **
    LazyColumn {
        items(variable_data){ item ->
         Card (modifier = Modifier .padding(13.dp)
             .fillMaxHeight(),
         shape = RectangleShape)   {

             Row  (modifier = Modifier.padding(8.dp).
             background(MaterialTheme.colors.surface)
                 .padding(16.dp)){
                 CreateImegeProfile()
             }

         }



        }
    }
}


@Composable
 fun Createinfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "hessah",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant,
        )//end Text 1
        Text(
            text = "Android Compose programing ",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(3.dp),
        )
        Text(
            text = "hooos70005@gmial.com", modifier = Modifier.padding(3.dp)
        )//end text 2
    }
}

@Composable
 fun CreateImegeProfile(modofier_variable_For_Optional: Modifier=Modifier) {
    Surface(
        modifier = modofier_variable_For_Optional
            .size(150.dp)
            .padding(5.dp), shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {

        //what image you want see (id & Description )for photo
        Image(
            painter = painterResource(R.drawable.horsesphoto),
            contentDescription = "profile photo",
            modifier = modofier_variable_For_Optional.size(130.dp),

            //make photo fill max padding
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardProfileUsuingComposeTheme {

        // Function have all the element in side
    CreatBizCardFunction()

    }
}