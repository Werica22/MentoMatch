package br.com.fiap.mentomatch.uiscreens

import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import br.com.fiap.mentomatch.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.MainActivity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var texto by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    val senhaVisualTransformation = PasswordVisualTransformation()

    val customColor = Color(0xFF039AB6)
    val iconColor = Color(0xFF42B6AF)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Caixa de texto para o usuário
            TextField(
                value = texto,
                onValueChange = { letra ->
                    texto = letra
                },
                placeholder = { Text("Usuário") },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Ícone do usuário",
                            tint = iconColor
                        )
                        Text(
                            "Usuário",
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
            Spacer(modifier = Modifier.height(16.dp))

            // Caixa de texto para a senha
            TextField(
                value = senha,
                onValueChange = { numero ->
                    senha = numero

                },
                visualTransformation = senhaVisualTransformation,

                placeholder = { Text("Senha") },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "Ícone de cadeado",
                            tint = iconColor
                        )
                        Text(
                            "Senha",

                            modifier = Modifier.padding(start = 8.dp)
                        )
                        // keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                    }
                },
                trailingIcon = {
                    Icon(
                        painterResource(id = R.drawable.eye_24),
                        contentDescription = "Icone de olho",
                        tint = Color.LightGray
                    )
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
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,

                        )
            )

            Spacer(modifier = Modifier.height(40.dp))
            // Botão "Entrar"
            Button(
                onClick = {
                    navController.navigate("entrarPerfil")
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF039AB6)),
                modifier = Modifier
                    .width(300.dp)
                    .background(
                        Color(0xFF039AB6),
                        shape = RoundedCornerShape(26.dp)
                    ),
                elevation = null

            ) {
                Text("Entrar", color = Color.White)
            }
            Spacer(modifier = Modifier.height(40.dp))

            // Ícones e textos
            Text(
                "Ou faça login com",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Ícones do Google e Facebook
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Ícone google",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.navigate("loginGoogle") }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Ícone facebook",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Ação ao clicar */ }
                )
            }

            Spacer(modifier = Modifier.height(70.dp))

            // Textos "Esqueci senha" e "Cadastre-se aqui"

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Cadastre-se aqui",
                    color = Color.Gray,
                    modifier = Modifier.clickable {
                        navController.navigate("cadastro")
                    },
                    textDecoration = TextDecoration.Underline
                )

                Text(
                    "Esqueci senha",
                    color = Color.Gray,
                    modifier = Modifier.clickable { navController.navigate("esqueciSenha") },
                    textDecoration = TextDecoration.Underline
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


        }
    }
}
