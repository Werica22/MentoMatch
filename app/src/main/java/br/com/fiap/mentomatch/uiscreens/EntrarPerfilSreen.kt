package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.ui.theme.librebaskerville


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntrarPerfilScreen(navController: NavController) {

    val customColor = Color(0xFF039AB6)
    val iconColor = Color(0xFF42B6AF)
    val buttonColor = Color(0xFFB1E4EB)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 32.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = {navController.navigate( "perfilMentorado")},
            colors = ButtonDefaults.buttonColors(customColor),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 8.dp)
                .height(50.dp)
                .background(customColor, shape = RoundedCornerShape(40.dp))
        ) {
            Text(
                "Mentor",
                color = Color.White,
                style = TextStyle(
                    fontFamily = librebaskerville,
                    fontSize = 20.sp,
                )
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {navController.navigate( "perfilMentor")},
            colors = ButtonDefaults.buttonColors(customColor),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 8.dp)
                .height(50.dp)
                .background(customColor, shape = RoundedCornerShape(50.dp))
        ) {
            Text(
                "Mentorado",
                color = Color.White,
                style = TextStyle(
                    fontFamily = librebaskerville,
                    fontSize = 20.sp,
                )
            )
        }
        Spacer(modifier = Modifier.height(90.dp))

    }
}