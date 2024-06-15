package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.ui.theme.librebaskerville

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RedefinirSenhaScreen (navController: NavController) {

    var texto by remember {
        mutableStateOf("")
    }
    val customColor = Color(0xFF039AB6)
    val iconColor = Color(0xFF42B6AF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(25.dp))


        Text(
            "Redefinir Senha",
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontFamily = librebaskerville,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(start = 10.dp, top = 10.dp )
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "Informe o e-mail para o qual deseja redefinir a sua senha",
            color = Color.Gray,
            fontSize = 16.sp,
            fontFamily = librebaskerville,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .width(350.dp)
        )

            // Caixa de texto para o usuário
            TextField(
                value = texto,
                onValueChange = { letra ->
                    texto = letra
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                placeholder = { Text("E-mail") },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "E-mail",
                            modifier = Modifier.padding(start = 8.dp)
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
                    .padding(bottom = 8.dp)
                    .padding(top = 40.dp)
                    .border(
                        width = 10.dp,
                        color = Color.Transparent,

                        )
            )

        Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color(0xFF039AB6)),
                modifier = Modifier
                    .width(300.dp)
                    .background(
                        Color(0xFF039AB6),
                        shape = RoundedCornerShape(10.dp)
                    ),
                elevation = null

            ) {
                Text("REDEFINIR SENHA", color = Color.White)
            }
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            "Voltar ao login",
            color = Color.Gray,
            fontSize = 16.sp,
            fontFamily = librebaskerville,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                //.padding(start = 10.dp, top = 10.dp )
                .clickable{navController.navigate( "login")},
                    textDecoration = TextDecoration.Underline
        )
        }
    }
