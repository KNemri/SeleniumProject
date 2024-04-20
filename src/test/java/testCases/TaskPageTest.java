package testCases;


import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskPageTest extends CommonMethods {
    /*
     Go to https://www.webstaurantstore.com/
     Search for 'stainless work table'.
     */
    @Test
    public void ItemSearch() {
       homePage.searchForItem("stainless work table");
    }

   // Check the search result ensuring every product has the word 'Table' in its title.

    @Test
    public void verifyAllTitlesContainTable() {
        //
        searchPage.tableItems();
    };

      //  4. Add the last of found items to Cart.

    @Test
    public void addLastItemToCart(){
        searchPage.findLastItem();
        searchPage.addItemToCart();
    }

      //  5 Empty Cart.
    @Test
    public void emptyCart(){
        viewCartPage.clearCart();
    }



}




