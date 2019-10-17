package com.company.AndresInciarteU1Capstone.Service;

import com.company.AndresInciarteU1Capstone.Dao.*;
import com.company.AndresInciarteU1Capstone.Dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ServiceLayer {
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    private TshirtDao tshirtDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TshirtDao tshirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tshirtDao = tshirtDao;
    }

    //CRUD Invoice
    @Transactional
    public Invoice findAddInvoice(UserPurchaseInfo info) {
        //using info provided by user to fill up similar fields in invoice
        Invoice invoice = new Invoice();
        invoice.setName(info.getName());
        invoice.setStreet(info.getStreet());
        invoice.setCity(info.getCity());
        invoice.setState(info.getState());
        invoice.setZipcode(info.getZipcode());
        invoice.setItemType(info.getItemType());
        invoice.setItemId(info.getItemId());
        invoice.setQuantity(info.getQuantity());
        //unit price
        if (invoice.getItemType().equals("Consoles")) {
            //sets unit price by getting the console by the id provided and retrieving the price
            invoice.setUnitPrice(consoleDao.getConsole(invoice.getItemId()).getPrice());
            // get console quantity by using invoice provided id
            Console console = consoleDao.getConsole(invoice.getItemId());

            if (console.getQuantity() > invoice.getQuantity()) {
                // change the console quantity to the console quantity and subtract by the quantity given by the user
                console.setQuantity(console.getQuantity() - invoice.getQuantity());
                // then update the console to have the new quantity
                consoleDao.updateConsole(console);
            } else {
                throw new IllegalArgumentException("Quantity can not be larger than amount in storage, quantity in storage: " + console.getQuantity());
            }

        } else if (invoice.getItemType().equals("Games")) {

            invoice.setUnitPrice(gameDao.getGame(invoice.getItemId()).getPrice());

            Game game = gameDao.getGame(invoice.getItemId());
            if (game.getQuantity() > invoice.getQuantity()) {

                game.setQuantity(game.getQuantity() - invoice.getQuantity());
                gameDao.updateGame(game);

            } else {
                throw new IllegalArgumentException("Quantity can not be larger than amount in storage, quantity in storage: " + game.getQuantity());
            }

        } else if (invoice.getItemType().equals("T-Shirts")) {
            invoice.setUnitPrice(tshirtDao.getTshirt(invoice.getItemId()).getPrice());

            TShirt tShirt = tshirtDao.getTshirt(invoice.getItemId());

            if (tShirt.getQuantity() > invoice.getQuantity()) {

                tShirt.setQuantity(tShirt.getQuantity() - invoice.getQuantity());
                tshirtDao.updateTshirt(tShirt);

            } else {
                throw new IllegalArgumentException("Quantity can not be larger than amount in storage, quantity in storage: " + tShirt.getQuantity());
            }

        } else {
            // if the user does not provides any of the words then return null
            return null;
        }

        //subtotal = no tax, yes processing fee
        invoice.setSubtotal(invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity())));
        //get tax
        invoice.setTax(salesTaxRateDao.getTaxByState(invoice.getState()).getRate().multiply(invoice.getSubtotal()));
        //processing fee
        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByItem(invoice.getItemType()).getFee());
        //get total
        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()));

        invoice = invoiceDao.addInvoice(invoice);

        return invoice;
    }

    public Invoice addInvoice(Invoice invoice) {return invoiceDao.addInvoice(invoice);}

    public Invoice getInvoice(int id) {
        return invoiceDao.getInvoice(id);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceDao.getAllInvoices();
    }

    public void deleteInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }

    //crud console

    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public Console getConsole(int id){
        return consoleDao.getConsole(id);
    }

    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public void deleteConsole(int id){
        consoleDao.deleteConsole(id);
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    public List<Console> getByManufacturer(String manufacturer) {
        return consoleDao.getConsoleByManufacturer(manufacturer);
    }

    // crud Game

    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }

    public Game getGame(int id){
        return gameDao.getGame(id);
    }

    public List<Game> getAllGames() {
        return gameDao.allGames();
    }

    public void deleteGame(int id){
        gameDao.deleteGame(id);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public Game getGameByTitle(String title) {
        return gameDao.getGameByTile(title);
    }

    public List<Game> getGamesByEsrbRating(String esrb) {
        return gameDao.getGamesByEsrbRating(esrb);
    }

    public List<Game> getGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    //tshirt crud

    public TShirt addTshirt(TShirt tShirt) {
        return tshirtDao.addTshirt(tShirt);
    }

    public TShirt getTshirt(int id){
        return tshirtDao.getTshirt(id);
    }

    public List<TShirt> getAllTshirts() {
        return tshirtDao.getAllTshirts();
    }

    public void deleteTshirt(int id){
        tshirtDao.deleteTshirt(id);
    }

    public void updateTshirt(TShirt tShirt) {
        tshirtDao.updateTshirt(tShirt);
    }

    public List<TShirt> getTShirtsByColor(String color){
        return tshirtDao.getTshirtsByColor(color);
    }

    public List<TShirt> getTShirtsBySize(String size){
        return tshirtDao.getTshirtsBySize(size);
    }
}
