package br.com.fiap.mentomatch.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CaixaDeEntrada(
    placeHolder: String,
    value: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier,
    atualizarValor: (String) -> Unit,
    showError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textStyle: TextStyle? = null

) {

    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= 8) { //Usuário so pode digitar no maximo até 8 digitos
                atualizarValor(it)
            }
        },
        label = { Text("Usuário") },
        singleLine = true,
        modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .border(1.dp, Color.Gray, MaterialTheme.shapes.small),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
        placeholder = {
            Text(text = placeHolder)
        },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraLight,
            textAlign = TextAlign.Start
        ),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = Color.Black,
            disabledContainerColor = Color.White
        ),
        isError = showError,
        visualTransformation = visualTransformation
    )
}
