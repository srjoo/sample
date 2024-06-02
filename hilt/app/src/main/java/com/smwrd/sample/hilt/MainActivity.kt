package com.smwrd.sample.hilt

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smwrd.sample.hilt.computer.Computer
import com.smwrd.sample.hilt.module.Computer1
import com.smwrd.sample.hilt.module.Computer2
import com.smwrd.sample.hilt.module.ComputerAll
import com.smwrd.sample.hilt.ui.theme.HiltTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ComputerAll
    @Inject
    lateinit var coms: List<@JvmSuppressWildcards Computer>
    // list의 경우 @JvmSuppressWildcards 를 선언해줘야 오류가 안난다

    @Computer1
    @Inject
    lateinit var com1: Computer

    @Computer2
    @Inject
    lateinit var com2: Computer

    @ApplicationContext
    @Inject
    lateinit var con1: Context

    @ActivityContext
    @Inject
    lateinit var con2: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coms.forEach {
            it.turnOn()
        }
        enableEdgeToEdge()
        setContent {
            HiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .verticalScroll(rememberScrollState())
                        ) {
                        Column {
                            Text(text = con1.toString())
                            Text(text = con2.toString())
                        }
                        ComputersLog(
                            // com1 = @ActivityScoped 로 선언되어 coms의 첫번째와 동일하다
                            // com2 = 스코프 선언이 되어 있지 않아 매번 새로 만들기 때문에 coms의 두번재와 com2는 서로 다른 인스턴스이다
                            computers = coms.toMutableList().apply {
                                add(com1)
                                add(com2)
                            }
                        )
                    }
                }
            }
        }
    }

    override fun toString(): String {
        return "${super.toString()} / [MainActivity] 입니다~"
    }
}

@Composable
fun ComputersLog(computers: List<Computer>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        computers.forEach {
            ComputerLog(computerLog = it.getLog(), modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun ComputerLog(computerLog: String, modifier: Modifier = Modifier) {
    Text(
        text = computerLog,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ComputerLogPreview() {
    HiltTheme {
        ComputerLog("""
            컴퓨터 부팅중
            [컴퓨터 정보]
            |CPU : Intel Core i5-10400F
            |RAM : 8GB
            |MotherBoard : Asus Prime Z390-A
            |PowerSupply : 500W
            컴퓨터 부팅 성공
        """.trimIndent());
    }
}