package br.com.fiap.mentomatch.uiscreens

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.R
import br.com.fiap.mentomatch.model.Mentorado
import br.com.fiap.mentomatch.repository.getAllMentorado
import br.com.fiap.mentomatch.repository.getAllMentoradoBuscar

@Composable
fun PerfilMentoradoScreen(navController: NavController) {
    val customColor = Color(0xFF039AB6)
    val mentoradoList = getAllMentorado()
    var selectedMentorado by remember { mutableStateOf<Mentorado?>(null) }
    var texto by remember {
        mutableStateOf("")
    }
    var buscar by remember {
        mutableStateOf("")
    }
    var listMentoradoByBuscar by remember {
        mutableStateOf(getAllMentoradoBuscar(buscar))
    }

    val xSegundos = 10000L
    val timer = object: CountDownTimer(xSegundos, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            Log.d("Timer", "Acabou o tempo!")

        }
    }

    timer.start()

    Column( modifier = Modifier.fillMaxSize()
    ){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.White)
    ) {
        OutlinedTextField(
            value = buscar,
            onValueChange = { buscar = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            placeholder = { Text(text = ("Buscar")) },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraLight,
                textAlign = TextAlign.Start,
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_lupa),
                    contentDescription = "imagem lupa de buscar",
                    modifier = Modifier.size(32.dp) // alterei tamanho da imagem do icone
                        .clickable(onClick = { listMentoradoByBuscar = getAllMentoradoBuscar(buscar) })
                )
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                disabledContainerColor = Color.White,


                )
        )
    }

            //Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                items(listMentoradoByBuscar) { mentorado ->
                    Image(
                        painter = painterResource(id = mentorado.imagemResId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clickable {
                                selectedMentorado = mentorado
                                selectedMentorado?.let { mentorado ->
                                    // navController.navigate("perfilMentor/${mentorado.id}")
                                    selectedMentorado = mentorado
                                }
                            }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.62f)
                    .padding(horizontal = 16.dp)
            ) {
                selectedMentorado?.let { mentorado ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = mentorado.imagemResId),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(bottom = 10.dp)
                            )
                            Text(
                                text = mentorado.nome,
                                fontSize = 24.sp,
                                color = customColor,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Interesses: ${mentorado.interesses}",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            Text(
                                text = "Disponibilidade: ${mentorado.disponibilidade}",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(bottom = 4.dp)
                                    .clickable { navController.navigate("calendario") },
                                color = Color.Blue, // Cor do texto
                                textDecoration = TextDecoration.Underline // Adiciona sublinhado ao texto para indicar que é clicável
                            )

                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
                    .height(60.dp)
                    .background(customColor),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = "Perfil",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                IconButton(onClick = { /*  */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = "Mensagem",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                IconButton(onClick = { /* */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Configurações",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }

    }











