package com.valerian.finpulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.valerian.finpulse.ui.theme.FinPulseTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.style.TextAlign



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinPulseTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
   // FinPulseTheme {
      //  Greeting("Android")
   // }
//}

@Composable
fun DisplayDrawableImage() {
    Column( modifier = Modifier.fillMaxWidth().fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.SpaceEvenly) {
    Image(
        painter = painterResource(id = R.drawable.welcome),
        contentDescription = "welcome Image")
        Text(
            text = "Welcome to FinPulse, \nWhere financial clarity and \nmental serenity thrive together",
            )
        FilledButtonExample{}
    }
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun DisplayDrawableImagePreview() {
    FinPulseTheme{
        DisplayDrawableImage()
    }
}


@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Get Started")
    }
}


@Composable
fun SignUpScreen() {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    val ageOptions = listOf("18-25", "26-35", "36-45", "46+")
    val incomeOptions = listOf("Below 10,000", "10,000-30,000", "30,000-50,000", "50,000+")
    val goalOptions = listOf("Save", "Invest", "Debt-Free", "Emergency Fund")

    val selectedAge = remember { mutableStateOf(ageOptions[0]) }
    val selectedIncome = remember { mutableStateOf(incomeOptions[0]) }
    val selectedGoal = remember { mutableStateOf(goalOptions[0]) }

    val termsAccepted = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Sign up",modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.Black,textAlign = TextAlign.Center)

        // Logo + Tagline
       Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            //Text("Fin", color = Color(0xFF008080), fontWeight = FontWeight.Bold)
            //Text("Pulse",color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text("Financial Clarity,",color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        Text("Emotional calm", color = Color(0xFF008080), fontWeight = FontWeight.Bold )}

        // Input fields
        OutlinedTextField(value = name.value, onValueChange = { name.value = it }, label = { Text("Name") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = email.value, onValueChange = { email.value = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = password.value, onValueChange = { password.value = it }, label = { Text("Password") }, modifier = Modifier.fillMaxWidth(), visualTransformation = PasswordVisualTransformation())
        OutlinedTextField(value = confirmPassword.value, onValueChange = { confirmPassword.value = it }, label = { Text("Confirm Password") }, modifier = Modifier.fillMaxWidth(), visualTransformation = PasswordVisualTransformation())

        // Dropdowns
        DropdownField("Age", ageOptions, selectedAge)
        DropdownField("Monthly Income", incomeOptions, selectedIncome)
        DropdownField("Financial Goal", goalOptions, selectedGoal)

        // Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = termsAccepted.value, onCheckedChange = { termsAccepted.value = it })
            Text("I agree to terms and privacy policy")
        }

        // Button
        Button(
            onClick = { /* handle sign up */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Create Account", color = Color(0xFFFFA500))
        }

        // Login Link
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Already have an account? ")
            Text("login", color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DropdownField(label: String, options: List<String>, selectedOption: MutableState<String>) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedOption.value,
            onValueChange = {},
            label = { Text(label) },
            readOnly = true,
            modifier = Modifier.fillMaxWidth().clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(text = { Text(option) }, onClick = {
                    selectedOption.value = option
                    expanded = false
                })
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    MaterialTheme
            SignUpScreen()
        }


@Composable
fun LoginFields(

    email: String, password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit
) {

    Column (horizontalAlignment = Alignment.CenterHorizontally){

        Image(        painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo Image")
        Text(text = "Welcome Back ", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
        Image(        painter = painterResource(id = R.drawable.login),
            contentDescription = "login Image")
        TextField(
            value = email,
            label = "Email",
            placeholder = "Enter your email address",
            onValueChange = onEmailChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
               // imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password,
            label = "Password",
            placeholder = "Enter your password",
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                //imeAction = ImeAction.Go
            ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            }
        )

        TextButton(onClick = onForgotPasswordClick, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Forgot Password?",color = Color(0xFF008080))
        }
    }
}

@Composable
fun LoginFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onSignInClick, colors = ButtonDefaults.buttonColors(containerColor = Color.Black), modifier = Modifier.fillMaxWidth()) {
            Text("Log In",color = Color(0xFFFFA500))
        }
        TextButton(onClick = onSignUpClick) {
            Text("Don't have an account?",color = Color.Black)
            Text("sign up",color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TextField(
    value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LoginFields(
                email = email,
                password = password,
                onEmailChange = { email = it },
                onPasswordChange = { password = it },
                onForgotPasswordClick = {}
            )

            LoginFooter(
                onSignInClick = {},
                onSignUpClick = {}
            )
        }
    }


@Composable
fun LinkAccountsScreen() {
    var linkMpesa by remember { mutableStateOf(false) }
    var linkBank by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Lets personalize your experience",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008080),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = linkMpesa,
                onCheckedChange = { linkMpesa = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFFFC107),
                    uncheckedColor = Color(0xFFFFC107)
                )
            )
            Text(
                text = "Link Mpesa Account",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = linkBank,
                onCheckedChange = { linkBank = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFFFC107),
                    uncheckedColor = Color(0xFFFFC107)
                )
            )
            Text(
                text = "Link Bank Account",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Handle Link Now */ },
                colors = ButtonDefaults.buttonColors ( Color.Black),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("Link Now", color = Color(0xFFFFC107))
            }

            Button(
                onClick = { /* Handle Remind Later */ },
                colors = ButtonDefaults.buttonColors (Color.Black)
                //shape = RoundedCornerShape(12.dp),
                //modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("Remind Me Later", color = Color(0xFFFFC107))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LinkAccountsScreenPreview() {
    MaterialTheme {
        LinkAccountsScreen()
    }
}
@Composable
fun MpesaLinkScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Text(
            text = "Link your Mpesa account",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008080),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var phoneNumber by remember { mutableStateOf("") }

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            placeholder = { Text("Phone number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        Text(
            text = "Enter code sent to your phone",
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            val codeDigits = remember { List(6) { mutableStateOf("") } }
            for (digit in codeDigits) {
                OutlinedTextField(
                    value = digit.value,
                    onValueChange = { if (it.length <= 1) digit.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(48.dp)
                        .background(Color.White)
                        .padding(4.dp)
                )
            }
        }

        var agreed by remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Checkbox(checked = agreed, onCheckedChange = { agreed = it })
            Text("I agree to securely link and allow FinPulse to access my transaction history.")
        }

        Button(
            onClick = { /* Handle linking action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                //contentColor = Color(0xFFFFD700)
            )
        ) {
            Text("Link Account", color = Color(0xFFFFC107))
        }
    }
}
@Composable
@Preview(showBackground = true)
fun PreviewMpesaLinkScreen() {
    MpesaLinkScreen()
}

@Composable
fun SuccessPopup() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "success!",
            color = Color(0xFFFFD700), // Yellow
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your Mpesa Account has been linked",
            color = Color.Black,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .border(2.dp, Color(0xFFFFD700), shape = RoundedCornerShape(8.dp))
        ) {
            Text(text = "Manage Accounts", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier
              //  .border(12.dp, Color(0xFFFFD700), shape = RoundedCornerShape(8.dp))
        ) {
            Text(text = "Proceed", color = Color(0xFFFFD700))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SuccessPopupPreview() {
    SuccessPopup()
}

@Composable
fun LinkBankAccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Link your Bank Account",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008080),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var accountNumber by remember { mutableStateOf("") }
        var bankName by remember { mutableStateOf("") }

        OutlinedTextField(
            value = accountNumber,
            onValueChange = { accountNumber = it },
            label = { Text("Account Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = bankName,
            onValueChange = { bankName = it },
            label = { Text("Bank Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Handle linking */ },
            modifier = Modifier.fillMaxWidth() ,colors = ButtonDefaults.buttonColors(containerColor = Color.Black)

        ) {
            Text("Link Account",color = Color(0xFFFFD700))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Cancel",color = Color(0xFF008080), fontWeight = FontWeight.Bold,fontSize = 18.sp,)
      //  modifier = Modifier.clickable { /* Handle cancel action */ }

    }
}
@Preview(showBackground = true)
@Composable
fun LinkBankAccountScreenPreview() {
    LinkBankAccountScreen()
}

