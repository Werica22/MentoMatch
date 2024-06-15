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
import br.com.fiap.mentomatch.model.Mentor
import br.com.fiap.mentomatch.repository.getAllMentor
import br.com.fiap.mentomatch.repository.getAllMentorBuscas


@Composable
fun PerfilMentorScreen(navController: NavController) {
    val customColor = Color(0xFF039AB6)
    val mentorList = getAllMentor()
    var selectedMentor by remember { mutableStateOf<Mentor?>(null) }
    var buscas by remember {
        mutableStateOf("")
    }
    var listMentorByBuscas by remember {
        mutableStateOf(getAllMentorBuscas(buscas))
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
            value = buscas,
            onValueChange = { buscas = it },
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
                        .clickable(onClick = { listMentorByBuscas = getAllMentorBuscas(buscas) })
                )
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                disabledContainerColor = Color.White,


                )
        )
    }
        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
        ) {
            items(listMentorByBuscas) { mentor ->
                Image(
                    painter = painterResource(id = mentor.imagemResId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(15.dp)
                        .clickable {
                            selectedMentor = mentor
                            selectedMentor?.let { mentor ->
                                //  navController.navigate("perfilMentor/${mentor.id}")
                                selectedMentor = mentor

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
                selectedMentor?.let { mentor ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = mentor.imagemResId),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(100.dp).padding(bottom = 10.dp)
                            )
                            Text(
                                text = mentor.nome,
                                fontSize = 24.sp,
                                color = customColor,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Experiência: ${mentor.experiencia}",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Interesses: ${mentor.interesses}",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Disponibilidade: ${mentor.disponibilidade}",
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
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