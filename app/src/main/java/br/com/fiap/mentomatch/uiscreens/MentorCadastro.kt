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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentomatch.R
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentorCadastro(navController: NavController) {
    var texto by remember { mutableStateOf("") }
    var letra by remember { mutableStateOf("") }
    var letter by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var letre by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var ufState by remember { mutableStateOf("") }
    var cidadeState by remember { mutableStateOf("") }
    var ruaState by remember { mutableStateOf("") }
    var showCard by remember { mutableStateOf(false) }
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
            onValueChange = { texto = it },
            placeholder = { Text("Área de especialização:") },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Área de especialização", modifier = Modifier.padding(start = 1.dp))
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
                .padding(vertical = 8.dp)
                .border(width = 10.dp, color = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = letra,
            onValueChange = { letra = it },
            placeholder = { Text("Certificações") },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Certificações", modifier = Modifier.padding(start = 1.dp))
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
                .padding(vertical = 5.dp)
                .border(width = 10.dp, color = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = letter,
            onValueChange = { letter = it },
            placeholder = { Text("Experiência profissional") },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Experiência profissional", modifier = Modifier.padding(start = 1.dp))
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
                .padding(vertical = 5.dp)
                .border(width = 10.dp, color = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Preferências") },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Preferências", modifier = Modifier.padding(start = 1.dp))
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
                .padding(vertical = 5.dp)
                .border(width = 10.dp, color = Color.Transparent)
        )

        TextField(
            value = cep,
            onValueChange = { cep = it },
            placeholder = { Text("Localização, cep") },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Localização, cep", modifier = Modifier.padding(start = 1.dp))
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
                .padding(vertical = 5.dp)
                .border(width = 10.dp, color = Color.Transparent),
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.img_lupa),
                    contentDescription = "Lupa",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                        .clickable {

                            if (cep.isEmpty() || cep.length < 8) {
                                showCard = false
                            } else {
                                val url = "https://viacep.com.br/ws/$cep/json/"
                                val header: HashMap<String, String> = hashMapOf()
                                Fuel.get(url).header(header).responseJson { request, response, result ->
                                    when (result) {
                                        is Result.Failure -> {
                                            showCard = false
                                            val ex = result.getException()
                                            if (ex.response.statusCode == 404) {
                                                // Tratamento do erro 404
                                            }
                                        }
                                        is Result.Success -> {
                                            showCard = true
                                            println("resp: " + result.get().obj().toString())

                                            val json = result.get().obj()
                                            ufState = json.getString("uf")
                                            cidadeState = json.getString("localidade")
                                            ruaState = json.getString("logradouro")
                                        }
                                    }
                                }
                            }
                        }
                )
            }
        )
        // Mostrando o cartão se o estado for verdadeiro
        if (showCard) {
            val cidade = "Exemplo Cidade"
            val uf = "EX"
            CardCep(cep, cidadeState, ufState, ruaState)
        }


        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = letre,
            onValueChange = { letre = it },
            placeholder = { Text("Disponibilidade") },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Disponibilidade", modifier = Modifier.padding(start = 1.dp))
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
                .padding(vertical = 5.dp)
                .border(width = 10.dp, color = Color.Transparent)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(customColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                elevation = null
            ) {
                Text("Cadastrar", color = Color.White)
            }
        }
    }
}

// Função para criar o cartão com as informações do CEP
@Composable
fun CardCep(cep: String, cidade: String, uf: String, rua : String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, Color.Black)
            .padding(8.dp)
    ) {
        Text("CEP: $cep")
        Text("Cidade: $cidade")
        Text("UF: $uf")
        Text("Rua: $rua")
    }
}

