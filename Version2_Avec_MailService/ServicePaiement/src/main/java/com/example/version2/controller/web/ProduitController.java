package com.example.version2.controller.web;

import com.example.version2.dao.JeuInterface;
import com.example.version2.entities.Jeu;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.ProductUpdateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProduitController {

    @Autowired
    private JeuInterface jeuInterface;

    @PostMapping("/create-product")
    public void createJeu(@RequestBody Jeu jeu) throws StripeException {

        ProductCreateParams params = ProductCreateParams.builder()
                .setName(jeu.getNom())
                .setDescription(jeu.getDescription())
                .build();
        Product product = Product.create(params);

        PriceCreateParams params1 = PriceCreateParams.builder()
                .setCurrency("eur")
                .setUnitAmount(jeu.getPrix()*100L)
                .setProduct(product.getId())
                .build();
        Price price = Price.create(params1);
        jeu.setPriceId(price.getId());
        jeuInterface.save(jeu);
    }

    @PutMapping("/update-product/{Id}")
    public void updateJeu(@RequestBody Jeu jeu, @PathVariable int id) throws StripeException {

        Price price = Price.retrieve(jeu.getPriceId());
        Product product = Product.retrieve(price.getProduct());
        ProductUpdateParams params = ProductUpdateParams.builder()
                .setName(jeu.getNom())
                .setDescription(jeu.getDescription())
                .build();
        product.update(params);
        jeu.setId(id);
        jeuInterface.save(jeu);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteJeu(@PathVariable int id) throws StripeException {
        Jeu jeu = jeuInterface.findById(id).get();
        Price price = Price.retrieve(jeu.getPriceId());
        Product product = Product.retrieve(price.getProduct());

        price.setActive(false);
        Product produit = product.delete();
        jeuInterface.delete(jeu);
    }

}
