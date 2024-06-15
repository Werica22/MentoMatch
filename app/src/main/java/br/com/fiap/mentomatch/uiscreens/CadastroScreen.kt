package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(navController: NavController) {

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    var confSenha by remember {
        mutableStateOf("")
    }

    val customColor = Color(0xFF039AB6)
    val iconColor = Color(0xFF42B6AF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Cadastre-se",
            style = TextStyle(
                color = Color.Black,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            TextField(
                value = name,
                onValueChange = { letra ->
                    name = letra
                },
                placeholder = { Text("Nome") },
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
                            "Nome",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedIndicatorColor = customColor,
                    disabledLabelColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 2.dp, top = 2.dp)
                    // .padding(top = 2.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = email,
                onValueChange = { letra ->
                    email = letra
                },
                placeholder = { Text("Email") },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_email),
                            contentDescription = "Ícone de Email",
                            tint = iconColor
                        )
                        Text(
                            "Email",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedIndicatorColor = customColor,
                    disabledLabelColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 8.dp, top = 2.dp)
                    // .padding(top = 2.dp),
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                    )
            )

            TextField(
                value = senha,
                onValueChange = { numero ->
                    senha = numero
                },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Senha") },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(id = R.drawable.eye_24),
                            contentDescription = "Ícone de olho",
                            tint = iconColor
                        )
                        Text(
                            "Senha",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedIndicatorColor = customColor,
                    disabledLabelColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 8.dp, top = 2.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                    )
            )

            TextField(
                value = confSenha,
                onValueChange = { numero ->
                    confSenha = numero
                },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Confirmar senha") },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(id = R.drawable.eye_24),
                            contentDescription = "Ícone de olho",
                            tint = iconColor
                        )
                        Text(
                            "Confirmar senha",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedIndicatorColor = customColor,
                    disabledLabelColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 8.dp, top = 2.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                    )
            )

            Spacer(modifier = Modifier.height(30.dp))


            Button(
                onClick = { navController.navigate("cadastroPerfil") },
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
            Spacer(modifier = Modifier.height(30.dp))

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

        }
    }
}

