package garcia.sergio.examen1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var nombre: TextInputEditText = findViewById(R.id.text)
        var otroNombre: TextInputEditText = findViewById(R.id.texto2)
        var boton : Button = findViewById(R.id.btnCalcular)
        var resultado : TextView = findViewById(R.id.tvResultado) as TextView
        var comentario : TextView = findViewById(R.id.tvResultado2) as TextView



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        boton.setOnClickListener{

            val tuNombre: String = nombre.text.toString()
            val nombreCrush: String = otroNombre.text.toString()
            val nombres: String = tuNombre + nombreCrush

            var vocales: Int = 0


            if(!(tuNombre.isNullOrEmpty() || nombreCrush.isNullOrEmpty())) {

                for (s in nombres) {
                    if (s.equals('a') || s.equals('e') || s.equals('i') || s.equals('o') || s.equals(
                            'u'
                        )
                    ) {
                        vocales++
                    }
                }


                var porcentaje: Float = (vocales.toFloat() * 100) / nombres.trim().length


                if (porcentaje.toInt() >= 90) {
                    resultado.setText(porcentaje.toString() + "%")
                    comentario.setText("Huele a boda")
                }

                if (porcentaje.toInt() < 90 && porcentaje.toInt() > 74) {
                    resultado.setText(porcentaje.toString() + "%")
                    comentario.setText("Invatala a salir")
                }

                if (porcentaje.toInt() < 75 && porcentaje.toInt() > 59) {
                    resultado.setText(porcentaje.toString() + "%")
                    comentario.setText("Buena suerte")
                }

                if (porcentaje.toInt() < 60) {
                    resultado.setText(porcentaje.toString() + "%")
                    comentario.setText("No hay manera")

                }

            }
            else{
                comentario.setText("Llene todos los campos")
            }


        }



    }
}