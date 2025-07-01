package Alda.it.Sc1.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.NumberFormat;

@Controller
public class MainController {
    private float toKelvin(float centigradi){
        return centigradi + 273.15f;
    }
    private float toFahrenheit(float centigradi){

        return (centigradi * 9/5) + 32;
    }

    @GetMapping("/home")

    public String convertitore (Model model, @RequestParam (required = false) String centigradi){
        System.out.println(centigradi);

        try {


        float centigradiInFloat= Float.parseFloat(centigradi);

        float kelvin = centigradiInFloat + 273.15f;
        System.out.println(kelvin);

        float fahrenheit = (centigradiInFloat * 9/5) + 32;
        System.out.println(fahrenheit);

        model.addAttribute("gradiFahreneit",fahrenheit);
        model.addAttribute("gradiKelvin",kelvin);

        }
        catch (NumberFormatException ex) {
            model.addAttribute("error", "inserire un numero" );
        }
        catch (NullPointerException enx){
            model.addAttribute("error", "inserire il parametro centigradi");

        }

        return "ConversioneTemperatura.html";
    }

}
