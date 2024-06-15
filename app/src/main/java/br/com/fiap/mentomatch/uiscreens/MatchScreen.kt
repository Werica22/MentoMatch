package br.com.fiap.mentomatch.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.R

@Composable
fun MatchScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = "DEU MATCH",
                modifier = Modifier
                    .align(Alignment.Center),
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Imagem mentor",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(32.dp))

            Image(
                painter = painterResource(id = R.drawable.foto2),
                contentDescription = "Imagem mentorado",
                modifier = Modifier.size(100.dp)
            )
        }

        // Botões com texto e cor específica
        Row(
            modifier = Modifier.padding(start = 16.dp,top = 16.dp,bottom = 16.dp)
                //.width(300.dp)
                .fillMaxWidth()
            //horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Button(
                onClick = { /* Ação do primeiro botão */ },
                colors = ButtonDefaults.buttonColors(Color(0xFF039AB6)),
                modifier = Modifier
                    .weight(1f) // Ocupa metade da largura disponível
                    .padding(end = 8.dp)
                    .size(60.dp)
            ){
                Text(text = "Nome do mentor", color = Color.White)
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { /* Ação do segundo botão */ },
                colors = ButtonDefaults.buttonColors(Color(0xFF039AB6)),
                modifier = Modifier
                    .weight(1f) // Ocupa metade da largura disponível
                    .padding(end = 8.dp)
                    .size(60.dp)
            ) {
                Text(text = "Nome ", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Informações do horário do encontro e data do match
        Text(
            text = "Horário do encontro: XX:XX",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Data do match: XX/XX/XXXX",
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}