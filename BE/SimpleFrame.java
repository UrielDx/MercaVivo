package about;
import com.qoppa.pdf.PDFException;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JPanel;
import com.qoppa.pdfViewer.PDFViewerBean;

public class SimpleFrame extends JFrame
{
    private String c = "";
    private JPanel jPanel = null;
    private PDFViewerBean PDFViewerBean = null;

    public static void main (String [] args) throws PDFException
    {
    }
    public SimpleFrame(String c) throws PDFException 
    {
        this.c = c;
    	initialize();
    }
    private void initialize() throws PDFException 
    {
        this.setBounds(new Rectangle(0, 0, 800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getJPanel());
    	this.setTitle("Qoppa Software - jPDFViewer Sample");
    	this.setLocationRelativeTo(null);
    }
    private JPanel getJPanel() throws PDFException
    {
        if (jPanel == null)
        {
            jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
            jPanel.add(getPDFViewerBean(), BorderLayout.CENTER);
        }
        return jPanel;
    }
    private PDFViewerBean getPDFViewerBean() throws PDFException
    {
        if (PDFViewerBean == null)
        {
            PDFViewerBean = new PDFViewerBean();
            PDFViewerBean.loadPDF ("facturas/"+c+".pdf");
        }
        return PDFViewerBean;
    }

}