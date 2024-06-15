package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.MainActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentoradoCadastro(navController: NavController) {
    var texto by remember {
        mutableStateOf("")
    }
    var letra by remember {
        mutableStateOf("")
    }
    var letter by remember {
        mutableStateOf("")
    }
    var text by remember {
        mutableStateOf("")
    }
    var input by remember {
        mutableStateOf("")
    }
    var letre by remember {
        mutableStateOf("")
    }
    val customColor = Color(0xFF039AB6)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = texto,
            onValueChange = { letra ->
                texto = letra
            },
            placeholder = { Text("Área de atuação ou interesse profissional") },
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Área de atuação ou interesse profissional",
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Define a cor do contêiner como transparente
                unfocusedIndicatorColor = Color.Gray, // Cor da linha quando o campo não está focado
                focusedIndicatorColor = customColor, // Cor da linha quando o campo está focado
                disabledLabelColor = Color.Gray  //Cor da linha quando o campo está focado

            ),
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 3.dp)
                .padding(top = 8.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,

                    )

        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = letra,
            onValueChange = { texto ->
                letra = texto
            },
            placeholder = { Text("Nível de escolaridade") },
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Nível de escolaridade",
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Define a cor do contêiner como transparente
                unfocusedIndicatorColor = Color.Gray, // Cor da linha quando o campo não está focado
                focusedIndicatorColor = customColor, // Cor da linha quando o campo está focado
                disabledLabelColor = Color.Gray  //Cor da linha quando o campo está focado

            ),
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 6.dp)
                .padding(top = 5.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,

                    )
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = letter,
            onValueChange = { text ->
                letter = text
            },
            placeholder = { Text("Experiência profissional") },
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Experiência profissional",
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Define a cor do contêiner como transparente
                unfocusedIndicatorColor = Color.Gray, // Cor da linha quando o campo não está focado
                focusedIndicatorColor = customColor, // Cor da linha quando o campo está focado
                disabledLabelColor = Color.Gray  //Cor da linha quando o campo está focado

            ),
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 6.dp)
                .padding(top = 5.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,

                    )
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = text,
            onValueChange = { letter ->
                text = letter
            },
            placeholder = { Text("Áreas ou temas de interesse para mentoria") },
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Áreas de interesse para mentoria",
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Define a cor do contêiner como transparente
                unfocusedIndicatorColor = Color.Gray, // Cor da linha quando o campo não está focado
                focusedIndicatorColor = customColor, // Cor da linha quando o campo está focado
                disabledLabelColor = Color.Gray  //Cor da linha quando o campo está focado

            ),
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 4.dp)
                .padding(top = 3.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,

                    )
        )
         Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = input,
            onValueChange = { letre ->
                input = letre
            },
            placeholder = { Text("Localização, cep") },
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Localização, cep",
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Define a cor do contêiner como transparente
                unfocusedIndicatorColor = Color.Gray, // Cor da linha quando o campo não está focado
                focusedIndicatorColor = customColor, // Cor da linha quando o campo está focado
                disabledLabelColor = Color.Gray  //Cor da linha quando o campo está focado

            ),
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 6.dp)
                .padding(top = 5.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,

                    )
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = letre,
            onValueChange = { input ->
                letre = input
            },
            placeholder = { Text("Disponibilidade") },
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Disponibilidade",
                        modifier = Modifier.padding(start = 1.dp)

                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Define a cor do contêiner como transparente
                unfocusedIndicatorColor = Color.Gray, // Cor da linha quando o campo não está focado
                focusedIndicatorColor = customColor, // Cor da linha quando o campo está focado
                disabledLabelColor = Color.Gray  //Cor da linha quando o campo está focado

            ),
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 6.dp)
                .padding(top = 5.dp)
                .border(
                    width = 10.dp,
                    color = Color.Transparent,

                    )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {navController.navigate( "login")},
                colors = ButtonDefaults.buttonColors(customColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 15.dp),
                elevation = null
            ) {
                Text("Cadastrar", color = Color.White)
            }
        }
    }
}





