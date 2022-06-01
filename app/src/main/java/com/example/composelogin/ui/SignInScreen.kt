package com.example.composelogin.ui

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.composelogin.R
import com.example.composelogin.R.string.sign_in
import com.example.composelogin.ui.theme.darkBlue


@Preview(showSystemUi = true)
@Composable
fun SignInScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ){
        Title()
        Email()
        Password()
        SignInButton()
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.sign_in_welcome_text)

    )
}
@Composable
fun Email() {
    val emailState = remember { mutableStateOf(TextFieldValue())
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = emailState.value,
        onValueChange = {emailState.value = it},
        label   ={Text(text = stringResource(R.string.email_hint))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor =   Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}
@Composable
fun Password() {
    val passwordState = remember {mutableStateOf(TextFieldValue())}
    val showPassword = remember { mutableStateOf(false)}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = stringResource(R.string.password_hint))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor =  Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword.value){
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(R.string.hide_password
                        )
                    )
                }
            } else {
                Icon(
                    imageVector = Icons.Filled.VisibilityOff,
                    contentDescription = stringResource(R.string.show_password)
                )

            }
        }

    )
}
   
@Composable
    fun SignInButton() {
        Button(
            onClick = {},
            modifier   = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = darkBlue,
                contentColor = Color.White
            )
        ) {
           Text(
               text = stringResource(sign_in)
           )
        }
    }
    






