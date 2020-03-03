package ejemploimpresora;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JFrame;

/**
 *
 * @author lgmar
 */
public class EjemploImpresora {

    public static void main(String[] args) {
        EjemploImpresora app = new EjemploImpresora();
        
        JFrame ventana = new JF_Inicio();
        ventana.show();
    }
    
    private void prueba(){
        String texto = "Esto es lo que va a la impresora";

        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();


        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        DocPrintJob docPrintJob = printService.createPrintJob();
        Doc doc = new SimpleDoc(texto.getBytes(), flavor, null);
        try {
                docPrintJob.print(doc, null);
        } catch (PrintException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
}
