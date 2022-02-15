package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        num_zero.setOnClickListener { AcrescentarExpressao("0",true) }
        num_um.setOnClickListener { AcrescentarExpressao("1",true) }
        num_dois.setOnClickListener { AcrescentarExpressao("2",true) }
        num_tres.setOnClickListener { AcrescentarExpressao("3",true) }
        num_quatro.setOnClickListener { AcrescentarExpressao("4",true) }
        num_cinco.setOnClickListener { AcrescentarExpressao("5",true) }
        num_seis.setOnClickListener { AcrescentarExpressao("6",true) }
        num_sete.setOnClickListener { AcrescentarExpressao("7",true) }
        num_oito.setOnClickListener { AcrescentarExpressao("8",true) }
        num_nove.setOnClickListener { AcrescentarExpressao("9",true) }
        ponto.setOnClickListener { AcrescentarExpressao(".",true) }

        //Operadores
        soma.setOnClickListener { AcrescentarExpressao("+", false) }
        subtrai.setOnClickListener { AcrescentarExpressao("-", false) }
        divisao.setOnClickListener { AcrescentarExpressao("/", false) }
        multiplica.setOnClickListener { AcrescentarExpressao("*", false) }



        limpar.setOnClickListener {
            expressao.text=""
            txtResultado.text=""
        }

        backspace.setOnClickListener {
            val string = expressao.text.toString()

            if (string.isNotBlank()){
                expressao.text = string.substring(0,string.length-1)
            }
            txtResultado.text =""
        }
        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultado == longResult.toDouble())
                    txtResultado.text = longResult.toString()
                else
                    txtResultado.text = resultado.toString()

            }catch (e: Exception){

            }
        }

    }

    fun AcrescentarExpressao(string: String, limpa_dados : Boolean){

        if (txtResultado.text.isNotEmpty()){
            expressao.append(string)
        }
        if (limpa_dados){
            txtResultado.text =""
            expressao.append(string)

        }else{
            expressao.append(txtResultado.text)
            expressao.append(string)
            txtResultado.text =""
        }
    }
}