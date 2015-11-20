/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author Cameron
 */
@FacesValidator(value="speciesValidator")
public class SpeciesValidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String species = (String)value;
        HtmlInputText htmlInputText = (HtmlInputText)component;
        if (species.toUpperCase().equals("HUMAN"))
        {
            FacesMessage facesMessage =  new FacesMessage(htmlInputText.getLabel()+": cannot sell humans");
            throw new ValidatorException(facesMessage);
        }
    }
    
}
