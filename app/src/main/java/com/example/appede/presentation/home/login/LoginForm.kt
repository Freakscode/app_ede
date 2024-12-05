package com.example.appede.presentation.home.login
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appede.ui.theme.AppEDETheme
import com.example.appede.R
import com.example.appede.ui.theme.secondaryContainerLight

@Composable
fun LoginForm(
    modifier: Modifier = Modifier
) {
    var cedula: String by remember { mutableStateOf("") }
    var pwd: String by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp, bottom = 120.dp, start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "INICIAR SESIÓN",
            style = TextStyle(
                color = Color(0xFF002F5D),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Image(
            painter = painterResource(id = R.drawable.dgrd),
            contentDescription = "Logo DGRD",
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
        )
        Text(
            text = "Aplicación para la Evaluación de Daños en Edificaciones",
            style = TextStyle(
                color = Color(0xFF002F5D),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cedula,
            onValueChange = {cedula = it},
            label = { Text("Cédula") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(2.dp))
        OutlinedTextField(
            value = pwd,
            onValueChange = {pwd = it},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "¿Olvidaste la contraseña?",
            color = Color(0xFF002F5D),
            modifier = Modifier.padding(1.dp)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                secondaryContainerLight
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(50.dp)
        ) {
            Text(
                text = "INGRESAR",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun LoginScreenPreview() {
    AppEDETheme {
        LoginForm()
    }
}
