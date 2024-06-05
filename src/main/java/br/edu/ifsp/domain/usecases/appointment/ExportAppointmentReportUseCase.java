package br.edu.ifsp.domain.usecases.appointment;

//CDU024

import br.edu.ifsp.domain.model.appointment.Appointment;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ExportAppointmentReportUseCase {
    public void exportReportPDF(ArrayList<Appointment> report, String path) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            for (Appointment appointment : report) {
                document.add(new Paragraph(appointment.toString()));
                document.add(new Paragraph());
            }
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportReportCSV(ArrayList<Appointment> report, String path) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(path), CSVFormat.DEFAULT.withHeader("ID", "Date", "Hour", "Description", "Veterinarian", "Pet", "Status", "Cost", "Payment"))) {
            for (Appointment appointment : report) {
                printer.printRecord(appointment.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
