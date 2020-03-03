package ejemploimpresora;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author lgmar
 */
public class ServiciosImpresora implements Printable{
    private List<PrintService> impresoras = new ArrayList<>();
    private String mText = ""

    +"Four score and seven years ago our fathers brought forth on this "
  + "continent a new nation, conceived in  "
  + "proposition that all men "
  + "a great civil war, testing whether that "
  + "conceived and so dedicated can long endure. We are met on a great "
  + "battlefield of that war. We have "
  + "that field as a final resting-place for those who here gave their "
  + "lives that that nation might live. It is altogether fitting and "
  + "proper that we should do this. But in a larger sense, we cannot "
  + "dedicate, we cannot consecrate, we cannot hallow this ground. "
  + "The brave men, living and dead who struggled here have consecrated "
  + "it far above our poor power to add or detract. The world will "
  + "little note nor long remember what we say here, but it can never "
  + "forget what they did here. It is for us the living rather to be "
  + "dedicated here to the unfinished work which they who fought here "
  + "have thus far so nobly advanced. It is rather for us to be here "
  + "dedicated to the great task remaining before us--that from these "
  + "honored dead we take increased devotion to that cause for which "
  + "they gave the last full measure of devotion--that we here highly "
  + "resolve that these dead shall not have died in vain, that this "
  + "nation under God shall have a new birth of freedom, and that "
  + "government of the people, by the people, for the people shall "
  + "not perish from the earth.";
    
    public ServiciosImpresora(){}
    
    public ServiciosImpresora(String texto){
        this.mText = texto;
        this.mStyledText = new AttributedString(texto);
    }
    
    // Our text in a form for which we can obtain a
    // AttributedCharacterIterator.
    private AttributedString mStyledText = null;
    
    // Print a single page containing some sample text.
    
    public void establecerTexto(String texto){
        this.mText = texto;
        Font fuente=new Font(Font.SANS_SERIF, Font.BOLD, 8);
        this.mStyledText = new AttributedString(mText);
        this.mStyledText.addAttribute(TextAttribute.FONT, fuente);
        
        /*g2.setColor(colorModel.getColor("alertColor"));  
        g2.setFont(new Font(res.getString("g2_Font"), Font.BOLD, 20));  
        g2.drawString(res.getString("ERROR"), 5, 20);  */
    }

    public void imprimir() {
        // Get the representation of the current printer and
        // the current print job.
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Build a book containing pairs of page painters (Printables)
        // and PageFormats. This example has a single page containing
        // text.

        
        Paper paper_aux = new Paper();
        //paper_aux.setSize(30, 40);
        // distancia en X, distancia en Y, ancho del papel, altura del papel
        paper_aux.setImageableArea(10, 10, 800, 1000); // 5 por cada caracter
        
        
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper_aux);
        
        Book book = new Book();
        book.append(this, pageFormat);
        
        // Set the object to be printed (the Book) into the PrinterJob.
        // Doing this before bringing up the print dialog allows the
        // print dialog to correctly display the page range to be printed
        // and to dissallow any print settings not appropriate for the
        // pages to be printed.
        printerJob.setPageable(book);
        // Show the print dialog to the user. This is an optional step
        // and need not be done if the application wants to perform
        // 'quiet' printing. If the user cancels the print dialog then false
        // is returned. If true is returned we go ahead and print.
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException exception) {
                System.err.println("Printing error: " + exception);
            }
        }
    }
    // Print a page of text.

    @Override
    public int print(Graphics g, PageFormat format, int pageIndex) {
        // We'll assume that Jav2D is available.
        Graphics2D g2d = (Graphics2D) g;
        // Move the origin from the corner of the Paper to the corner
        // of the imageable area.
        g2d.translate(format.getImageableX(), format.getImageableY());
        // Set the text color.
        g2d.setPaint(Color.black);
        // Use a LineBreakMeasurer instance to break our text into
        // lines that fit the imageable area of the page.
        Point2D.Float pen = new Point2D.Float();
        AttributedCharacterIterator charIterator = mStyledText.getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(charIterator, g2d.getFontRenderContext());
        float wrappingWidth = (float) 80;//format.getImageableWidth();
        while (measurer.getPosition() < charIterator.getEndIndex()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            pen.y += layout.getAscent();
            float dx = layout.isLeftToRight() ? 0 : (wrappingWidth - layout.getAdvance());
            layout.draw(g2d, pen.x + dx, pen.y);
            pen.y += layout.getDescent() + layout.getLeading();
        }
        return Printable.PAGE_EXISTS;
    }
    
    /**
     * Obtener todas las impresoras disponibles del sistema.
     * @return 
     */
    public List<PrintService> listarImpresoras() {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Lista de impresoras disponibles");

        for (PrintService printService : printServices) {
            System.out.println("\t" + printService.getName());
            impresoras.add(printService);
        }
        
        return impresoras;
    }
}
