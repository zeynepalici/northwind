package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.IShoppingCartService;
import com.example.northwind.dataAccess.abstracts.ShoppingCartRepository;
import com.example.northwind.entities.concretes.ShoppingCart;
import com.example.northwind.entities.concretes.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartManager implements IShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ShoppingCartItemManager shoppingCartItemManager;

    @Override
    public ShoppingCart delete(int id) {
        ShoppingCart shoppingCartToDelete = shoppingCartRepository.getById(id);
        shoppingCartRepository.delete(shoppingCartToDelete);
        return shoppingCartToDelete;
    }

    @Override
    public ShoppingCartItem deleteProductOfTheShoppingCart(String customerId, int productId, int quantity) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByCustomerId(customerId);
        return shoppingCartItemManager.deleteProductFromShoppingCartItem(shoppingCart.getId(), productId, quantity);
    }

    @Override
    public ShoppingCartItem addProductToTheShoppingCart(String customerId, int productId) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByCustomerId(customerId);
        if (shoppingCart == null) {
            return null;
        }
        return shoppingCartItemManager.addProductToShoppingCartItem(shoppingCart.getId(), productId);

    }

    public ShoppingCart clearShoppingCart(String customerId) {
        ShoppingCart shoppingCartToBeCleaned = shoppingCartRepository.getByCustomerId(customerId);
        if (shoppingCartToBeCleaned == null) {
            return null;
        }
        shoppingCartItemManager.deleteAllItemsOfTheShoppingCart(shoppingCartToBeCleaned.getId());
        return shoppingCartToBeCleaned;
    }

    @Override
    public List<ShoppingCartItem> getAllItemsOfTheShoppingCart(String customerId) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByCustomerId(customerId);
        if (shoppingCart == null) {
            return null;
        }
        return shoppingCartItemManager.getAllProductsOfTheShoppingCart(shoppingCart.getId());
    }


}
