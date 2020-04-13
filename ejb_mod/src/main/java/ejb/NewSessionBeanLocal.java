package ejb;

import javax.ejb.CreateException;
import javax.ejb.Local;

/**
 *
 * @author eyvind
 */
@Local
public interface NewSessionBeanLocal {


    String determineResult(int guess);

}