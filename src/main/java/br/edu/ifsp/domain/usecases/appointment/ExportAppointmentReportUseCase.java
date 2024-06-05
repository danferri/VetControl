package br.edu.ifsp.domain.usecases.appointment;



import br.edu.ifsp.domain.model.appointment.Appointment;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;


public class ExportAppointmentReportUseCase {
    public void exportReportPDF(ArrayList<Appointment> report, String path) {
        try {
            // Verificar e criar o diretório, se necessário
            File file = new File(path);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Diretório criado: " + parentDir.getAbsolutePath());
                } else {
                    System.out.println("Falha ao criar o diretório: " + parentDir.getAbsolutePath());
                }
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            for (Appointment appointment : report) {
                document.add(new Paragraph(appointment.toString()));
                document.add(new Paragraph());
            }
            document.close();
            System.out.println("PDF exportado com sucesso para: " + path);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportReportCSV(ArrayList<Appointment> report, String path) {
        try {
            // Verificar e criar o diretório, se necessário
            File file = new File(path);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Diretório criado: " + parentDir.getAbsolutePath());
                } else {
                    System.out.println("Falha ao criar o diretório: " + parentDir.getAbsolutePath());
                }
            }

            try (CSVPrinter printer = new CSVPrinter(new FileWriter(path), CSVFormat.DEFAULT.withHeader("ID", "Date", "Hour", "Description", "Veterinarian", "Pet", "Status", "Cost", "Payment"))) {
                for (Appointment appointment : report) {
                    printer.printRecord(appointment.toString());
                }
            }
            System.out.println("CSV exportado com sucesso para: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
