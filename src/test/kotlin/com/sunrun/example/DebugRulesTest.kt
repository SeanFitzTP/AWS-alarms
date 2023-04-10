package com.sunrun.example

import org.drools.decisiontable.InputType
import org.drools.decisiontable.SpreadsheetCompiler
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

class DebugRulesTest {

    private fun testSpreadsheet(dtpath: String) {
        val dtf = File(dtpath)
        val inputStream: InputStream
        try {
            inputStream = FileInputStream(dtf)
            val ssComp = SpreadsheetCompiler()
            val s: String = ssComp.compile(inputStream, InputType.XLS)
            println("=== Begin generated DRL ===")
            println(s)
            println("=== End generated DRL ===")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testHelloEndpoint() {
        testSpreadsheet("src/main/resources/com/sunrun/example/rules.xls")
    }
}
