package com.smwrd.sample.mvvm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smwrd.sample.mvvm.ui.theme.MVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val clazz: Class<*> = MainActivity::class.java
        setContent {
            MVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(32.dp)) {
                        anotherActivityButtons(modifier = Modifier.padding(it))
                    }
                }
            }
        }
    }
}

fun getAnotherActivityList(): List<Class<*>> {
    return listOf(
        MVCActivity::class.java,
        MVPActivity::class.java,
        MVVMActivity_V1::class.java,
        MVVMActivity_V2::class.java,
        MVCActivityEx::class.java,
        MVPActivityEx::class.java,
        MVVMActivityEx_V1::class.java,
        MVVMActivityEx_V2::class.java,
    )
}

@Composable
fun anotherActivityButtons(
    modifier: Modifier = Modifier,
    list: List<Class<*>> = getAnotherActivityList()
) {
    Column {
        if(list.isNotEmpty()) {
            list.forEach {
                anotherActivityButton(clazz = it)
            }
        } else {
            Text(text = "아무것도 없습니다")
        }
    }
}

@Composable
fun anotherActivityButton(
    modifier: Modifier = Modifier,
    clazz: Class<*>
) {
    val context = LocalContext.current
    Button(
        modifier = modifier,
        onClick = { goToAcitivity(context, clazz) },
        ) {
        Text(text = clazz.simpleName)
    }
}

fun goToAcitivity(context: Context, clazz: Class<*>) {
    val intent = Intent(context, clazz)
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun appPreview() {
    MVVMTheme {
        anotherActivityButtons()
    }
}