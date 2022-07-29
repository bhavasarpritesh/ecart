package com.bbd.pritesh.util;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bbd.pritesh.model.Order;
import com.bbd.pritesh.model.OrderProduct;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
 
 
public class InvoiceDataPdfExport extends AbstractPdfView {
    private Order order;
     
    public InvoiceDataPdfExport(Order order) {
        this.order = order;
    }
 
    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request)
    {
       Font headerFont = new Font(Font.TIMES_ROMAN, 20, Font.BOLD, Color.magenta);
       HeaderFooter header = new HeaderFooter(new Phrase("All Invoices PDF View", headerFont), false);
       header.setAlignment(Element.ALIGN_CENTER);
       document.setHeader(header);

       Font dateFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLUE);

       HeaderFooter footer = new HeaderFooter(new Phrase("PDF Export Executed On : "+new Date(), dateFont), true);
       footer.setAlignment(Element.ALIGN_CENTER);
       document.setFooter(footer);
    }
    @Override
    protected void buildPdfDocument(
       Map<String, Object> model,
       Document document,
       PdfWriter writer,
       HttpServletRequest request,
       HttpServletResponse response)
       throws Exception
    {

       //download PDF with a given filename
       response.addHeader("Content-Disposition", "attachment;filename=Invoices.pdf");

       //read data from controller
     //  List<Invoice> list = (List<Invoice>) model.get("list");

       //create element
       Font titleFont = new Font(Font.TIMES_ROMAN, 24, Font.BOLD, Color.blue);
       Paragraph title = new Paragraph("ALL INVOICES DATA", titleFont);
       title.setAlignment(Element.ALIGN_CENTER);
       title.setSpacingBefore(20.0f);
       title.setSpacingAfter(25.0f);
       //add to document
       document.add(title);

       Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.blue);
       PdfPTable table = new PdfPTable(4);// no.of columns
       table.addCell(new Phrase("ID",tableHead));
       table.addCell(new Phrase("Product NAME",tableHead));
       table.addCell(new Phrase("Price",tableHead));
       table.addCell(new Phrase("Quanitity",tableHead));

       for(OrderProduct invoice : order.getProducts() ) {
          table.addCell(invoice.getId().toString());
          table.addCell(invoice.getProduct().getProductname());
          table.addCell(invoice.getPrice().toString());
          table.addCell(invoice.getQuantity().toString());
       }
       //add table data to document
       document.add(table);
    }
}

