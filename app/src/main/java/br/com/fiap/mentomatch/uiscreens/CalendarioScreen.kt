package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.R
import br.com.fiap.mentomatch.model.Mentor
import br.com.fiap.mentomatch.repository.getAllMentor

@Composable
fun CalendarioScreen (navController: NavController) {
    val customColor = Color(0xFF039AB6)
    val mentorList = getAllMentor()
    var selectedMentor by remember { mutableStateOf<Mentor?>(null) }
    var showCalendar by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 32.dp)
        ) {
            items(mentorList) { mentor ->
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
                                showCalendar = true
                            }
                        }

                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.calendario),
                contentDescription = "Calendário",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)

            )


            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("match")
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF039AB6)),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                Text(text = "Enviar Solicitação")
            }
        }
    }


