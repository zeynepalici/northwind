package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.IShoppingCartItemService;
import com.example.northwind.dataAccess.abstracts.ShoppingCartItemRepository;
import com.example.northwind.entities.concretes.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemManager implements IShoppingCartItemService {
    @Autowired
    ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    ProductManager productManager;

    @Override
    public ShoppingCartItem add(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    @Override
    public ShoppingCartItem update(int cardItemId, ShoppingCartItem shoppingCartItem) {
        ShoppingCartItem shoppingCartItemUpToDate = shoppingCartItemRepository.getById(cardItemId);

        shoppingCartItemUpToDate.setQuantity(shoppingCartItem.getQuantity());
        return shoppingCartItemRepository.save(shoppingCartItemUpToDate);
    }

    @Override
    public ShoppingCartItem delete(int id) {
        ShoppingCartItem shoppingCartItemToDelete = shoppingCartItemRepository.getById(id);
        shoppingCartItemRepository.delete(shoppingCartItemToDelete);
        return shoppingCartItemToDelete;
    }


    @Override
    public ShoppingCartItem deleteProductFromShoppingCartItem(int cartId, int productId, int quantity) {

        if (shoppingCartItemRepository.existsShoppingCartItemByCartIdAndProductIdAndQuantityGreaterThan(cartId, productId, quantity)) {
            ShoppingCartItem shoppingCartItemToUpdate = shoppingCartItemRepository.findByCartIdAndProductId(cartId, productId);
            ShoppingCartItem updatedShoppingCartItem = new ShoppingCartItem();
            updatedShoppingCartItem.setId(shoppingCartItemToUpdate.getId());
            updatedShoppingCartItem.setCartId(cartId);
            updatedShoppingCartItem.setProductId(productId);
            updatedShoppingCartItem.setQuantity(shoppingCartItemToUpdate.getQuantity() - quantity);
            return update(updatedShoppingCartItem.getId(), updatedShoppingCartItem);
        } else if (shoppingCartItemRepository.existsShoppingCartItemByCartIdAndProductIdAndQuantityEquals(cartId, productId, quantity)) {
            ShoppingCartItem shoppingCartItemToDelete = shoppingCartItemRepository.findByCartIdAndProductId(cartId, productId);
            return delete(shoppingCartItemToDelete.getId());
        } else
            return null;
    }

    public List<ShoppingCartItem> deleteAllItemsOfTheShoppingCart(int cartId) {
        List<ShoppingCartItem> deletedShoppingCartItems = shoppingCartItemRepository.getAllByCartId(cartId);
        for (ShoppingCartItem deletedShoppingCartItem : deletedShoppingCartItems) {
            delete(deletedShoppingCartItem.getId());
        }
        return deletedShoppingCartItems;
    }

    @Override
    public ShoppingCartItem addProductToShoppingCartItem(int cartId, int productId) {
        if (productManager.findById(productId) == null)
            return null;

        if (shoppingCartItemRepository.existsShoppingCartItemByCartIdAndProductId(cartId, productId)) {
            ShoppingCartItem shoppingCartItemToUpdate = shoppingCartItemRepository.findByCartIdAndProductId(cartId, productId);
            ShoppingCartItem updatedShoppingCartItem = new ShoppingCartItem();
            updatedShoppingCartItem.setQuantity(shoppingCartItemToUpdate.getQuantity() + 1);
            updatedShoppingCartItem.setProductId(shoppingCartItemToUpdate.getProductId());
            updatedShoppingCartItem.setCartId(shoppingCartItemToUpdate.getCartId());
            updatedShoppingCartItem.setId(shoppingCartItemToUpdate.getId());
            return update(updatedShoppingCartItem.getId(), updatedShoppingCartItem);
        } else {
            ShoppingCartItem shoppingCartItemToAdd = new ShoppingCartItem();
            shoppingCartItemToAdd.setQuantity(1);
            shoppingCartItemToAdd.setCartId(cartId);
            shoppingCartItemToAdd.setProductId(productId);
            return add(shoppingCartItemToAdd);
        }
    }

    @Override
    public List<ShoppingCartItem> getAll() {
        return shoppingCartItemRepository.findAll();
    }


    @Override
    public List<ShoppingCartItem> getAllProductsOfTheShoppingCart(int cardId) {
        return shoppingCartItemRepository.getAllByCartId(cardId);
    }
}
