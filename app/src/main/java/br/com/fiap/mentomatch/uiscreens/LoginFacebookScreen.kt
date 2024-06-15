package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentomatch.R
import br.com.fiap.mentomatch.ui.theme.librebaskerville


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginFacebookScreen () {
    var texto by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    val senhaVisualTransformation = PasswordVisualTransformation()

    val CardColor = Color(0xFFE8EDEC)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        //.padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            // verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(5.dp))


            Text(
                "Fazer login usando sua Conta do Facebook",
                color = Color.LightGray,
                fontSize = 16.sp,
                fontFamily = librebaskerville,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            //Spacer(modifier = Modifier.height(10.dp))

            // Ícone do Google
            Image(
                painter = painterResource(id = R.drawable.face),
                contentDescription = "Nome Google",
                modifier = Modifier.size(110.dp)
            )

            // Spacer(modifier = Modifier.height(10.dp))

            // Card com caixas de texto para email e senha
            Card(
                colors = CardDefaults.cardColors(containerColor = CardColor),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_person),
                            contentDescription = "Foto de Perfil",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(32.dp)),
                            colorFilter = ColorFilter.tint(Color.White)

                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    // Caixa de texto para email
                    TextField(
                        value = texto,
                        onValueChange = { letra ->
                            texto = letra
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                        placeholder = { Text("Email") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Caixa de texto para senha
                    TextField(
                        value = senha,
                        onValueChange = { numero ->
                            senha = numero

                        },
                        visualTransformation = senhaVisualTransformation,
                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                        placeholder = { Text("Senha") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Botão "FAZER LOGIN"
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color(0xFF039AB6)),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(0.dp))
            ) {
                Text("FAZER LOGIN", color = Color.White)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Texto "Preciso de ajuda?"
            Text(
                "Preciso de ajuda?",
                color = Color.Gray,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { /* Adicione a lógica para o evento de clique aqui */ }
                    .align(Alignment.Start)
            )
        }
    }
}


