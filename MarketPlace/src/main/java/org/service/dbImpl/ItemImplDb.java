package org.service.dbImpl;

import jakarta.persistence.EntityManager;
import org.config.AbstractDAO;
import org.models.Product;
import org.service.impl.ProductImpl;
import org.service.inter.ItemInter;

import java.util.Optional;

public class ItemImplDb extends AbstractDAO implements ItemInter {

    @Override
    public Double itemTotal(String barcode, int count) {
        ProductImplDb productImplDb  =new ProductImplDb();
        Double total =0d;

        Product product =productImplDb.getProductByBarcode(barcode);
        total= product.getPrice()*count;
        return total;
    }
}
