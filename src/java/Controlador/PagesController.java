/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin Posada Alegría
 */
public class PagesController {
    @RequestMapping(value = "Error.htm", method = RequestMethod.GET)
    public ModelAndView LogrosAdd(HttpServletRequest request, @ModelAttribute("Errores") String Errores) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Errores/Error");
        mav.addObject(Errores);
        return mav;
    }
}
