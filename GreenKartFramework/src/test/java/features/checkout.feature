Feature: Place the order for products

Scenario Outline: Search for a product and add the product to cart and checkout

Given User is on GreenKart landing page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
|	Name		|
|	Tom			|