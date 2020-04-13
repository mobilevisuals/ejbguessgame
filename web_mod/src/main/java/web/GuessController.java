package web;

import ejb.NewSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author eyvind
 */
@Named(value = "guessController")
@SessionScoped
public class GuessController implements Serializable {
    //injektion av EJB: istället för att skapa den med konstruktor
    @EJB
    private NewSessionBeanLocal newSessionBean;

    private int guess;
    private String message;


    /**
     * Creates a new instance of GuessController
     */
    public GuessController() {
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void determineResult()
    {
        message=newSessionBean.determineResult(guess);
    }

}