/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hardsecurity;

import com.ui.CriptonixAuthentification;

/**
 *
 * @author yuri
 */
public class HardSecurity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CriptonixAuthentification master = new CriptonixAuthentification();
        master.setVisible(true);
        master.setLocationRelativeTo(master.getParent());
    }
}
